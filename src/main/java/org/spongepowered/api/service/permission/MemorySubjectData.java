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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.permission.SubjectDataUpdateEvent;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;

/**
 * A subject data implementation storing all contained data in memory.
 *
 * <p>Users of this class who wish to correctly implement the
 * {@link SubjectDataUpdateEvent} should do so by overriding the
 * {@link #onUpdate()} method. </p>
 *
 * <p>This class is thread-safe.</p>
 */
public class MemorySubjectData implements SubjectData {

    protected final Subject subject;
    protected final ConcurrentMap<Set<Context>, Map<String, String>> options = Maps.newConcurrentMap();
    protected final ConcurrentMap<Set<Context>, NodeTree> permissions = Maps.newConcurrentMap();
    protected final ConcurrentMap<Set<Context>, List<SubjectReference>> parents = Maps.newConcurrentMap();

    /**
     * Creates a new subject data instance, using the provided service to
     * request instances of permission subjects.
     *
     * @param subject The subject this data belongs to
     */
    public MemorySubjectData(Subject subject) {
        this.subject = Objects.requireNonNull(subject, "subject");
    }

    /**
     * Called each time the data in this {@link MemorySubjectData} is mutated
     * in some way.
     */
    protected void onUpdate() {
        // Do nothing - users of the class will override.
    }

    @Override
    public Subject getSubject() {
        return this.subject;
    }

    @Override
    public boolean isTransient() {
        return true;
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
        NodeTree perms = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return perms == null ? NodeTree.of(ImmutableMap.of()) : perms;
    }

    @Override
    public Map<String, Boolean> getPermissions(Set<Context> contexts) {
        NodeTree perms = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return perms == null ? ImmutableMap.of() : perms.asMap();
    }

    @Override
    public CompletableFuture<Boolean> setPermission(Set<Context> contexts, String permission, Tristate value) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(permission, "permission");
        Objects.requireNonNull(value, "value");
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
        onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearPermissions() {
        boolean wasEmpty = this.permissions.isEmpty();
        this.permissions.clear();
        if (!wasEmpty) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
    public CompletableFuture<Boolean> clearPermissions(Set<Context> context) {
        boolean ret = this.permissions.remove(Objects.requireNonNull(context, "context")) != null;
        if (ret) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(ret);
    }

    @Override
    public Map<Set<Context>, List<SubjectReference>> getAllParents() {
        return ImmutableMap.copyOf(this.parents);
    }

    @Override
    public List<SubjectReference> getParents(Set<Context> contexts) {
        return this.parents.getOrDefault(Objects.requireNonNull(contexts, "contexts"), ImmutableList.of());
    }

    @Override
    public CompletableFuture<Boolean> addParent(Set<Context> contexts, SubjectReference parent) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(parent, "parent");
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            List<SubjectReference> oldParents = this.parents.get(contexts);
            if (oldParents != null && oldParents.contains(parent)) {
                return CompletableFuture.completedFuture(false);
            }

            List<SubjectReference> newParents = ImmutableList.<SubjectReference>builder()
                    .addAll(oldParents == null ? ImmutableList.of() : oldParents)
                    .add(parent)
                    .build();

            if (updateCollection(this.parents, contexts, oldParents, newParents)) {
                onUpdate();
                return CompletableFuture.completedFuture(true);
            }
        }
    }

    private <K, V> boolean updateCollection(ConcurrentMap<K, V> collection, K key, @Nullable V oldValue, V newValue) {
        if (oldValue == null) {
            return collection.putIfAbsent(key, newValue) == null;
        } else {
            return collection.replace(key, oldValue, newValue);
        }
    }

    @Override
    public CompletableFuture<Boolean> removeParent(Set<Context> contexts, SubjectReference parent) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(parent, "parent");
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            List<SubjectReference> oldParents = this.parents.get(contexts);
            if (oldParents == null || !oldParents.contains(parent)) {
                return CompletableFuture.completedFuture(false);
            }

            List<SubjectReference> newParents = new ArrayList<>(oldParents);
            newParents.remove(parent);

            if (updateCollection(this.parents, contexts, oldParents, ImmutableList.copyOf(newParents))) {
                onUpdate();
                return CompletableFuture.completedFuture(true);
            }
        }
    }

    @Override
    public CompletableFuture<Boolean> clearParents() {
        boolean wasEmpty = this.parents.isEmpty();
        this.parents.clear();
        if (!wasEmpty) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
    public CompletableFuture<Boolean> clearParents(Set<Context> contexts) {
        boolean ret = this.parents.remove(Objects.requireNonNull(contexts, "contexts")) != null;
        if (ret) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(ret);
    }

    @Override
    public Map<Set<Context>, Map<String, String>> getAllOptions() {
        return ImmutableMap.copyOf(this.options);
    }

    @Override
    public Map<String, String> getOptions(Set<Context> contexts) {
        return this.options.getOrDefault(Objects.requireNonNull(contexts, "contexts"), ImmutableMap.of());
    }

    @Override
    public CompletableFuture<Boolean> setOption(Set<Context> contexts, String key, @Nullable String value) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(key, "key");
        Map<String, String> origMap = this.options.get(contexts);
        Map<String, String> newMap;

        if (origMap == null) {
            if (value == null) {
                return CompletableFuture.completedFuture(false);
            }

            if ((origMap = this.options.putIfAbsent(ImmutableSet.copyOf(contexts), ImmutableMap.of(key.toLowerCase(), value))) == null) {
                onUpdate();
                return CompletableFuture.completedFuture(true);
            }
        }
        do {
            if (value == null) {
                if (!origMap.containsKey(key)) {
                    return CompletableFuture.completedFuture(false);
                }
                newMap = new HashMap<>(origMap);
                newMap.remove(key);
            } else {
                newMap = new HashMap<>(origMap);
                newMap.put(key, value);
            }
            newMap = ImmutableMap.copyOf(newMap);
        } while (!this.options.replace(contexts, origMap, newMap));
        onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearOptions() {
        boolean wasEmpty = this.options.isEmpty();
        this.options.clear();
        if (!wasEmpty) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
    public CompletableFuture<Boolean> clearOptions(Set<Context> contexts) {
        boolean ret = this.options.remove(Objects.requireNonNull(contexts, "contexts")) != null;
        if (ret) {
            onUpdate();
        }
        return CompletableFuture.completedFuture(ret);
    }
}
