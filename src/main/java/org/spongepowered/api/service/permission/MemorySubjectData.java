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
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.permission.SubjectDataUpdateEvent;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.Collections;
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
    protected final ConcurrentMap<Set<Context>, Map<String, String>> options = new ConcurrentHashMap<>();
    protected final ConcurrentMap<Set<Context>, NodeTree> permissions = new ConcurrentHashMap<>();
    protected final ConcurrentMap<Set<Context>, List<SubjectReference>> parents = new ConcurrentHashMap<>();

    /**
     * Creates a new subject data instance, using the provided service to
     * request instances of permission subjects.
     *
     * @param subject The subject this data belongs to
     */
    public MemorySubjectData(final Subject subject) {
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
    public Subject subject() {
        return this.subject;
    }

    @Override
    public boolean isTransient() {
        return true;
    }

    @Override
    public Map<Set<Context>, Map<String, Boolean>> allPermissions() {
        final ImmutableMap.Builder<Set<Context>, Map<String, Boolean>> ret = ImmutableMap.builder();
<<<<<<< HEAD
        for (Map.Entry<Set<Context>, NodeTree> ent : this.permissions.entrySet()) {
=======
        for (final Map.Entry<Set<Context>, NodeTree> ent : this.permissions.entrySet()) {
>>>>>>> 823e6c7c6 (A variety of codestyle tweaks)
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
<<<<<<< HEAD
    public NodeTree nodeTree(Set<Context> contexts) {
        final NodeTree perms = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return perms == null ? NodeTree.of(ImmutableMap.of()) : perms;
    }

    @Override
    public Map<String, Boolean> permissions(Set<Context> contexts) {
=======
    public NodeTree nodeTree(final Set<Context> contexts) {
        final NodeTree perms = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return perms == null ? NodeTree.of(Collections.emptyMap()) : perms;
    }

    @Override
    public Map<String, Boolean> permissions(final Set<Context> contexts) {
>>>>>>> 823e6c7c6 (A variety of codestyle tweaks)
        final NodeTree perms = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return perms == null ? ImmutableMap.of() : perms.asMap();
    }

    @Override
    public CompletableFuture<Boolean> setPermission(Set<Context> contexts, final String permission, final Tristate value) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(permission, "permission");
        Objects.requireNonNull(value, "value");
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            final NodeTree oldTree = this.permissions.get(contexts);
            if (oldTree != null && oldTree.get(permission) == value) {
                return CompletableFuture.completedFuture(false);
            }

            if (oldTree == null && value != Tristate.UNDEFINED) {
                if (this.permissions.putIfAbsent(contexts, NodeTree.of(Collections.singletonMap(permission, value.asBoolean()))) == null) {
                    break;
                }
            } else {
                if (oldTree == null || this.permissions.replace(contexts, oldTree, oldTree.withValue(permission, value))) {
                    break;
                }
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> setPermissions(Set<Context> contexts, final @Nullable Map<String, Boolean> permissions, final TransferMethod method) {
        contexts = ImmutableSet.copyOf(Objects.requireNonNull(contexts, "contexts"));
        Objects.requireNonNull(method, "method");

        outer: while (true) {
            final NodeTree oldTree = this.permissions.get(contexts);
            switch (method) {
                case MERGE:
                    if (permissions == null) {
                        break outer;
                    }

                    final NodeTree newTree;
                    if (oldTree != null) {
                        newTree = oldTree.withAll(permissions);
                    } else {
                        newTree = NodeTree.of(permissions);
                    }
                    if (this.updateCollection(this.permissions, contexts, oldTree, newTree)) {
                        break outer;
                    }
                    break;
                case OVERWRITE:
                    if (this.updateCollection(this.permissions, contexts, oldTree, NodeTree.of(permissions == null ? ImmutableMap.of() : permissions))) {
                        break outer;
                    }

                    break;
                default:
                    throw new IllegalStateException("Unhandled enum state " + method);
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public Tristate fallbackPermissionValue(final Set<Context> contexts) {
        final NodeTree tree = this.permissions.get(Objects.requireNonNull(contexts, "contexts"));
        return tree == null ? Tristate.UNDEFINED : tree.rootValue();
    }

    @Override
    public Map<Set<Context>, Tristate> allFallbackPermissionValues() {
        final ImmutableMap.Builder<Set<Context>, Tristate> builder = ImmutableMap.builder();

        for (final Map.Entry<Set<Context>, NodeTree> entry : this.permissions.entrySet()) {
            builder.put(entry.getKey(), entry.getValue().rootValue());
        }
        return builder.build();
    }

    @Override
    public CompletableFuture<Boolean> setFallbackPermissionValue(Set<Context> contexts, final Tristate fallback) {
        contexts = ImmutableSet.copyOf(Objects.requireNonNull(contexts, "contexts"));
        Objects.requireNonNull(fallback, "fallback");

        while (true) {
            final NodeTree oldTree = this.permissions.get(contexts);
            if (oldTree != null && oldTree.rootValue() == fallback) {
                return CompletableFuture.completedFuture(false);
            }

            if (oldTree == null && fallback != Tristate.UNDEFINED) {
                if (this.permissions.putIfAbsent(contexts, NodeTree.of(ImmutableMap.of(), fallback)) == null) {
                    break;
                }
            } else {
                if (oldTree == null || this.permissions.replace(contexts, oldTree, oldTree.withRootValue(fallback))) {
                    break;
                }
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearFallbackPermissionValues() {
        boolean anyUpdated = false;
        for (final Set<Context> key : this.permissions.keySet()) {
            while (true) {
                final NodeTree oldTree = this.permissions.get(key);
                if (oldTree == null || oldTree.rootValue() == Tristate.UNDEFINED) {
                    continue;
                }

                if (this.updateCollection(this.permissions, key, oldTree, oldTree.withRootValue(Tristate.UNDEFINED))) {
                    anyUpdated = true;
                    break;
                }
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(anyUpdated);
    }

    @Override
    public CompletableFuture<Boolean> clearPermissions() {
        final boolean wasEmpty = this.permissions.isEmpty();
        this.permissions.clear();
        if (!wasEmpty) {
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
<<<<<<< HEAD
    public CompletableFuture<Boolean> clearPermissions(Set<Context> context) {
        final boolean ret = this.permissions.remove(Objects.requireNonNull(context, "context")) != null;
        if (ret) {
=======
    public CompletableFuture<Boolean> clearPermissions(final Set<Context> context) {
        final boolean changed = this.permissions.remove(Objects.requireNonNull(context, "context")) != null;
        if (changed) {
>>>>>>> 823e6c7c6 (A variety of codestyle tweaks)
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(changed);
    }

    @Override
    public Map<Set<Context>, List<? extends SubjectReference>> allParents() {
        return ImmutableMap.copyOf(this.parents);
    }

    @Override
    public List<SubjectReference> parents(final Set<Context> contexts) {
        return this.parents.getOrDefault(Objects.requireNonNull(contexts, "contexts"), ImmutableList.of());
    }

    @Override
    public CompletableFuture<Boolean> setParents(Set<Context> contexts, final List<? extends SubjectReference> parents, final TransferMethod method) {
        contexts = ImmutableSet.copyOf(Objects.requireNonNull(contexts, "contexts"));
        Objects.requireNonNull(method, "method");

        outer: while (true) {
            final List<SubjectReference> oldParents = this.parents.get(contexts);
            switch (method) {
                case MERGE:
                    if (oldParents != null) {
                        final List<SubjectReference> newParents = new ArrayList<>(oldParents);
                        newParents.removeAll(parents);
                        newParents.addAll(parents);
                        if (this.parents.replace(contexts, oldParents, newParents)) {
                            break outer;
                        }
                    } else {
                        if (this.parents.putIfAbsent(contexts, ImmutableList.copyOf(parents)) == null) {
                            break outer;
                        }
                    }
                    break;
                case OVERWRITE:
                    if (this.parents.replace(contexts, oldParents, ImmutableList.copyOf(parents))) {
                        break outer;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unhandled enum state " + method);
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> addParent(Set<Context> contexts, final SubjectReference parent) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(parent, "parent");
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            final List<SubjectReference> oldParents = this.parents.get(contexts);
            if (oldParents != null && oldParents.contains(parent)) {
                return CompletableFuture.completedFuture(false);
            }

            final List<SubjectReference> newParents = ImmutableList.<SubjectReference>builder()
                    .addAll(oldParents == null ? ImmutableList.of() : oldParents)
                    .add(parent)
                    .build();

            if (this.updateCollection(this.parents, contexts, oldParents, newParents)) {
                this.onUpdate();
                return CompletableFuture.completedFuture(true);
            }
        }
    }

    private <K, V> boolean updateCollection(final ConcurrentMap<K, V> collection, final K key, final @Nullable V oldValue, final @Nullable V newValue) {
        if (newValue == null) {
            return oldValue == null ? !collection.containsKey(key) : collection.remove(key, oldValue);
        } else if (oldValue == null) {
            return collection.putIfAbsent(key, newValue) == null;
        } else {
            return collection.replace(key, oldValue, newValue);
        }
    }

    @Override
    public CompletableFuture<Boolean> removeParent(Set<Context> contexts, final SubjectReference parent) {
        Objects.requireNonNull(contexts, "contexts");
        Objects.requireNonNull(parent, "parent");
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            final List<SubjectReference> oldParents = this.parents.get(contexts);
            if (oldParents == null || !oldParents.contains(parent)) {
                return CompletableFuture.completedFuture(false);
            }

            final List<SubjectReference> newParents = new ArrayList<>(oldParents);
            newParents.remove(parent);

            if (this.updateCollection(this.parents, contexts, oldParents, ImmutableList.copyOf(newParents))) {
                this.onUpdate();
                return CompletableFuture.completedFuture(true);
            }
        }
    }

    @Override
    public CompletableFuture<Boolean> clearParents() {
        final boolean wasEmpty = this.parents.isEmpty();
        this.parents.clear();
        if (!wasEmpty) {
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
<<<<<<< HEAD
    public CompletableFuture<Boolean> clearParents(Set<Context> contexts) {
        final boolean ret = this.parents.remove(Objects.requireNonNull(contexts, "contexts")) != null;
        if (ret) {
=======
    public CompletableFuture<Boolean> clearParents(final Set<Context> contexts) {
        final boolean changed = this.parents.remove(Objects.requireNonNull(contexts, "contexts")) != null;
        if (changed) {
>>>>>>> 823e6c7c6 (A variety of codestyle tweaks)
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(changed);
    }

    @Override
    public Map<Set<Context>, Map<String, String>> allOptions() {
        return ImmutableMap.copyOf(this.options);
    }

    @Override
    public Map<String, String> options(final Set<Context> contexts) {
        return this.options.getOrDefault(Objects.requireNonNull(contexts, "contexts"), Collections.emptyMap());
    }

    @Override
    public CompletableFuture<Boolean> setOption(Set<Context> contexts, final String key, final @Nullable String value) {
        contexts = ImmutableSet.copyOf(Objects.requireNonNull(contexts, "contexts"));
        Objects.requireNonNull(key, "key");
        @Nullable Map<String, String> origMap = this.options.get(contexts);
        Map<String, String> newMap;

        if (origMap == null) {
            if (value == null) {
                return CompletableFuture.completedFuture(false);
            }

            if ((origMap = this.options.putIfAbsent(contexts, Collections.singletonMap(key.toLowerCase(), value))) == null) {
                this.onUpdate();
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
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> setOptions(Set<Context> contexts, final @Nullable Map<String, String> options, final TransferMethod method) {
        contexts = ImmutableSet.copyOf(Objects.requireNonNull(contexts, "contexts"));
        Objects.requireNonNull(method, "method");

        outer: while (true) {
            final Map<String, String> oldOptions = this.options.get(contexts);
            switch (method) {
                case MERGE:
                    if (options == null) {
                        break outer;
                    }

                    final Map<String, String> newOptions = oldOptions == null ? new HashMap<>() : new HashMap<>(oldOptions);
                    newOptions.putAll(options);
                    if (this.updateCollection(this.options, contexts, oldOptions, newOptions)) {
                        break outer;
                    }
                    break;
                case OVERWRITE:
                    if (this.updateCollection(this.options, contexts, oldOptions, options == null ? null : ImmutableMap.copyOf(options))) {
                        break outer;
                    }

                    break;
                default:
                    throw new IllegalStateException("Unhandled enum state " + method);
            }
        }
        this.onUpdate();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> clearOptions() {
        final boolean wasEmpty = this.options.isEmpty();
        this.options.clear();
        if (!wasEmpty) {
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(!wasEmpty);
    }

    @Override
<<<<<<< HEAD
    public CompletableFuture<Boolean> clearOptions(Set<Context> contexts) {
=======
    public CompletableFuture<Boolean> clearOptions(final Set<Context> contexts) {
>>>>>>> 823e6c7c6 (A variety of codestyle tweaks)
        final boolean ret = this.options.remove(Objects.requireNonNull(contexts, "contexts")) != null;
        if (ret) {
            this.onUpdate();
        }
        return CompletableFuture.completedFuture(ret);
    }

    @Override
    public CompletableFuture<Boolean> copyFrom(final SubjectData other, final TransferMethod method) {
        Objects.requireNonNull(other, "other");
        Objects.requireNonNull(method, "method");
        final Map<Set<Context>, Map<String, Boolean>> otherPerms = other.allPermissions();
        final Map<Set<Context>, Map<String, String>> otherOptions = other.allOptions();
        final Map<Set<Context>, List<? extends SubjectReference>> otherParents = other.allParents();

        if (method == TransferMethod.OVERWRITE) {
            this.permissions.clear();
            this.parents.clear();
            this.options.clear();
        }

        otherPerms.forEach((ctx, permissions) -> this.setPermissions(ctx, permissions, method));
        otherOptions.forEach((ctx, options) -> this.setOptions(ctx, options, method));
        otherParents.forEach((ctx, parents) -> this.setParents(ctx, parents, method));

        return CompletableFuture.completedFuture(true);
    }

    @Override
    public CompletableFuture<Boolean> moveFrom(final SubjectData other, final TransferMethod method) {
        return this.copyFrom(other, method).thenCompose(res ->
                CompletableFuture.allOf(other.clearOptions(), other.clearParents(), other.clearPermissions()).thenApply(x -> res));
    }
}
