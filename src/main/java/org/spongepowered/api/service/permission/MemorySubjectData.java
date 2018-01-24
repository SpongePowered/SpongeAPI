/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.permission;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nullable;

/**
 * A subject data implementation storing all contained data in memory.
 *
 * <p>This class is thread-safe.</p>
 */
public class MemorySubjectData implements SubjectData {

    private final PermissionService service;
    private final ConcurrentMap<Set<Context>, Map<String, String>> options = Maps.newConcurrentMap();
    private final ConcurrentMap<Set<Context>, NodeTree> permissions = Maps.newConcurrentMap();
    private final ConcurrentMap<Set<Context>, List<Map.Entry<String, String>>> parents = Maps.newConcurrentMap();

    /**
     * Creates a new subject data instance, using the provided service to
     * request instances of permission subjects.
     *
     * @param service The service to request subjects from
     */
    public MemorySubjectData(PermissionService service) {
        checkNotNull(service, "service");
        this.service = service;
    }

    @Override
    public Map<Set<Context>, Map<String, Boolean>> getAllPermissions() {
        ImmutableMap.Builder<Set<Context>, Map<String, Boolean>> ret = ImmutableMap.builder();
        for (Map.Entry<Set<Context>, NodeTree> ent : this.permissions.entrySet()) {
            ret.put(ent.getKey(), ent.getValue().asMap());
        }
        return ret.build();
    }

    /**
     * Gets the calculated node tree representation of the permissions for this
     * subject data instance. If no data is present for the given context,
     * returns null.
     *
     * @param contexts The contexts to get a node tree for
     * @return The node tree
     */
    public NodeTree getNodeTree(Set<Context> contexts) {
        NodeTree perms = this.permissions.get(contexts);
        return perms == null ? NodeTree.of(Collections.emptyMap()) : perms;
    }

    @Override
    public Map<String, Boolean> getPermissions(Set<Context> contexts) {
        NodeTree perms = this.permissions.get(contexts);
        return perms == null ? Collections.emptyMap() : perms.asMap();
    }

    @Override
    public CompletableFuture<Boolean> setPermission(Set<Context> contexts, String permission, Tristate value) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            NodeTree oldTree = this.permissions.get(contexts);
            if (oldTree != null && oldTree.get(permission) == value) {
                return CompletableFuture.completedFuture(false);
            }

            if (oldTree == null && value != Tristate.UNDEFINED) {
                if (this.permissions.putIfAbsent(contexts, NodeTree.of(ImmutableMap.of(permission, value.asBoolean()))) == null) {
                    break;
                }
            } else {
                if (oldTree == null || this.permissions.replace(contexts, oldTree, oldTree.withValue(permission, value))) {
                    break;
                }
            }
        }
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearPermissions() {
        boolean wasEmpty = this.permissions.isEmpty();
        this.permissions.clear();
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
    public CompletableFuture<Boolean> clearPermissions(Set<Context> context) {
        return CompletableFuture.completedFuture(this.permissions.remove(context) != null);
    }

    @Override
    public Map<Set<Context>, List<SubjectReference>> getAllParents() {
        ImmutableMap.Builder<Set<Context>, List<SubjectReference>> ret = ImmutableMap.builder();
        for (Map.Entry<Set<Context>, List<Map.Entry<String, String>>> ent : this.parents.entrySet()) {
            ret.put(ent.getKey(), toSubjectList(ent.getValue()));
        }
        return ret.build();
    }

    List<SubjectReference> toSubjectList(List<Map.Entry<String, String>> parents) {
        ImmutableList.Builder<SubjectReference> ret = ImmutableList.builder();
        for (Map.Entry<String, String> ent : parents) {
            ret.add(this.service.newSubjectReference(ent.getKey(), ent.getValue()));
        }
        return ret.build();
    }

    @Override
    public List<SubjectReference> getParents(Set<Context> contexts) {
        List<Map.Entry<String, String>> ret = this.parents.get(contexts);
        return ret == null ? Collections.emptyList() : toSubjectList(ret);
    }

    @Override
    public CompletableFuture<Boolean> addParent(Set<Context> contexts, SubjectReference parent) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            Map.Entry<String, String> newEnt = Maps.immutableEntry(parent.getCollectionIdentifier(),
                    parent.getSubjectIdentifier());
            List<Map.Entry<String, String>> oldParents = this.parents.get(contexts);
            List<Map.Entry<String, String>> newParents = ImmutableList.<Map.Entry<String, String>>builder()
                    .addAll(oldParents == null ? Collections.emptyList() : oldParents)
                    .add(newEnt)
                    .build();
            if (oldParents != null && oldParents.contains(newEnt)) {
                return CompletableFuture.completedFuture(false);
            }

            if (updateCollection(this.parents, contexts, oldParents, newParents)) {
                return CompletableFuture.completedFuture(true);
            }
        }
    }

    private <K, V> boolean updateCollection(ConcurrentMap<K, V> collection, K key, @Nullable V oldValue, V newValue) {
        if (oldValue == null) {
            if (collection.putIfAbsent(key, newValue) == null) {
                return true;
            }
        } else {
            if (collection.replace(key, oldValue, newValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CompletableFuture<Boolean> removeParent(Set<Context> contexts, SubjectReference parent) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            Map.Entry<String, String> removeEnt = Maps.immutableEntry(parent.getCollectionIdentifier(),
                    parent.getSubjectIdentifier());
            List<Map.Entry<String, String>> oldParents = this.parents.get(contexts);
            List<Map.Entry<String, String>> newParents;

            if (oldParents == null || !oldParents.contains(removeEnt)) {
                return CompletableFuture.completedFuture(false);
            }
            newParents = new ArrayList<>(oldParents);
            newParents.remove(removeEnt);

            if (updateCollection(this.parents, contexts, oldParents, Collections.unmodifiableList(newParents))) {
                return CompletableFuture.completedFuture(true);
            }
        }

    }

    @Override
    public CompletableFuture<Boolean> clearParents() {
        boolean wasEmpty = this.parents.isEmpty();
        this.parents.clear();
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
    public CompletableFuture<Boolean> clearParents(Set<Context> contexts) {
        return CompletableFuture.completedFuture(this.parents.remove(contexts) != null);
    }

    @Override
    public Map<Set<Context>, Map<String, String>> getAllOptions() {
        return ImmutableMap.copyOf(this.options);
    }

    @Override
    public Map<String, String> getOptions(Set<Context> contexts) {
        Map<String, String> ret = this.options.get(contexts);
        return ret == null ? ImmutableMap.of() : ImmutableMap.copyOf(ret);
    }

    @Override
    public CompletableFuture<Boolean> setOption(Set<Context> contexts, String key, @Nullable String value) {
        Map<String, String> origMap = this.options.get(contexts);
        Map<String, String> newMap;

        if (origMap == null) {
            if (value == null) {
                return CompletableFuture.completedFuture(false);
            }

            if ((origMap = this.options.putIfAbsent(ImmutableSet.copyOf(contexts), ImmutableMap.of(key.toLowerCase(), value))) == null) {
                return CompletableFuture.completedFuture(true);
            }
        }
        do {
            if (value == null) {
                if (!origMap.containsKey(key)) {
                    return CompletableFuture.completedFuture(false);
                }
                newMap = new HashMap<>();
                newMap.putAll(origMap);
                newMap.remove(key);
            } else {
                newMap = new HashMap<>();
                newMap.putAll(origMap);
                newMap.put(key, value);
            }
            newMap = Collections.unmodifiableMap(newMap);
        } while (!this.options.replace(contexts, origMap, newMap));
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearOptions(Set<Context> contexts) {
        return CompletableFuture.completedFuture(this.options.remove(contexts) != null);
    }

    @Override
    public CompletableFuture<Boolean> clearOptions() {
        this.options.clear();
        return CompletableFuture.completedFuture(true);
    }
}
