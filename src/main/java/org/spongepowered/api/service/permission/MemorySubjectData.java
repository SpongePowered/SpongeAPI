/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nullable;

/**
 * A subject data implementation storing all contained data in memory.
 *
 * <p>This class is thread-safe.
 */
public class MemorySubjectData implements SubjectData {

    private final PermissionService service;
    private final ConcurrentMap<Set<Context>, NodeTree> permissions = Maps.newConcurrentMap();
    private final ConcurrentMap<Set<Context>, List<Map.Entry<String, String>>> parents = Maps.newConcurrentMap();

    /**
     * Creates a new subject data instance, using the provided service to request instances of permission subjects.
     *
     * @param service The service to request subjects from
     */
    public MemorySubjectData(PermissionService service) {
        checkNotNull(service);
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
     * Get the calculated node tree representation of the permissions for this subject data instance.
     * If no data is present for the given context, returns null.
     *
     * @param contexts The contexts to get a node tree for
     * @return The node tree
     */
    public NodeTree getNodeTree(Set<Context> contexts) {
        NodeTree perms = this.permissions.get(contexts);
        return perms == null ? NodeTree.of(Collections.<String, Boolean>emptyMap()) : perms;
    }

    @Override
    public Map<String, Boolean> getPermissions(Set<Context> contexts) {
        NodeTree perms = this.permissions.get(contexts);
        return perms == null ? Collections.<String, Boolean>emptyMap() : perms.asMap();
    }

    @Override
    public boolean setPermission(Set<Context> contexts, String permission, Tristate value) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            NodeTree oldTree = this.permissions.get(contexts);
            if (oldTree != null && oldTree.get(permission) == value) {
                return false;
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
        return true;

    }

    @Override
    public boolean clearPermissions() {
        boolean wasEmpty = this.permissions.isEmpty();
        this.permissions.clear();
        return !wasEmpty;
    }

    @Override
    public boolean clearPermissions(Set<Context> context) {
        return this.permissions.remove(context) != null;
    }

    @Override
    public Map<Set<Context>, List<Subject>> getAllParents() {
        ImmutableMap.Builder<Set<Context>, List<Subject>> ret = ImmutableMap.builder();
        for (Map.Entry<Set<Context>, List<Map.Entry<String, String>>> ent : this.parents.entrySet()) {
            ret.put(ent.getKey(), toSubjectList(ent.getValue()));
        }
        return ret.build();
    }

    List<Subject> toSubjectList(List<Map.Entry<String, String>> parents) {
        ImmutableList.Builder<Subject> ret = ImmutableList.builder();
        for (Map.Entry<String, String> ent : parents) {
            SubjectCollection collection = this.service.getSubjects(ent.getKey());
            ret.add(collection.get(ent.getValue()));
        }
        return ret.build();
    }

    @Override
    public List<Subject> getParents(Set<Context> contexts) {
        List<Map.Entry<String, String>> ret = this.parents.get(contexts);
        return ret == null ? Collections.<Subject>emptyList() : toSubjectList(ret);
    }

    @Override
    public boolean addParent(Set<Context> contexts, Subject parent) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            Map.Entry<String, String> newEnt = Maps.immutableEntry(parent.getContainingCollection().getIdentifier(),
                    parent.getIdentifier());
            List<Map.Entry<String, String>> oldParents = this.parents.get(contexts);
            List<Map.Entry<String, String>> newParents = ImmutableList.<Map.Entry<String, String>>builder()
                    .addAll(oldParents == null ? Collections.<Map.Entry<String, String>>emptyList() : oldParents)
                    .add(newEnt)
                    .build();
            if (oldParents != null && oldParents.contains(newEnt)) {
                return false;
            }

            if (updateCollection(this.parents, contexts, oldParents, newParents)) {
                return true;
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
    public boolean removeParent(Set<Context> contexts, Subject parent) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            Map.Entry<String, String> removeEnt = Maps.immutableEntry(parent.getContainingCollection().getIdentifier(),
                    parent.getIdentifier());
            List<Map.Entry<String, String>> oldParents = this.parents.get(contexts);
            List<Map.Entry<String, String>> newParents;

            if (oldParents == null || !oldParents.contains(removeEnt)) {
                return false;
            }
            newParents = new ArrayList<Map.Entry<String, String>>(oldParents);
            newParents.remove(removeEnt);

            if (updateCollection(this.parents, contexts, oldParents, Collections.unmodifiableList(newParents))) {
                return true;
            }
        }

    }

    @Override
    public boolean clearParents() {
        boolean wasEmpty = this.parents.isEmpty();
        this.parents.clear();
        return !wasEmpty;
    }

    @Override
    public boolean clearParents(Set<Context> contexts) {
        return this.parents.remove(contexts) != null;
    }
}
