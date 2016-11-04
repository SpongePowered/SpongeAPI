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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.change.OptionChange;
import org.spongepowered.api.service.permission.change.PermissionChange;
import org.spongepowered.api.util.GuavaCollectors;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.Nullable;

/**
 * A subject data implementation storing all contained data in memory.
 * All events called from this subject data object occur after the data change has been made.
 *
 * <p>This class is thread-safe.
 */
public class MemorySubjectData implements SubjectData {

    private final PermissionService service;
    private final Subject subject;
    private final Cause cause;
    private final AtomicReference<ConcurrentMap<Set<Context>, Map<String, String>>> options = new AtomicReference<>(new ConcurrentHashMap<>());
    private final AtomicReference<ConcurrentMap<Set<Context>, NodeTree>> permissions = new AtomicReference<>(new ConcurrentHashMap<>());
    private final AtomicReference<ConcurrentMap<Set<Context>, List<Map.Entry<String, String>>>> parents = new AtomicReference<>(new ConcurrentHashMap<>());

    /**
     * Creates a new subject data instance, using the provided service to request instances of permission subjects.
     *
     * @param service The service to request subjects from
     * @param subject The subject this data is attached to
     */
    public MemorySubjectData(PermissionService service, Subject subject) {
        checkNotNull(service, "service");
        this.service = service;
        this.subject = subject;
        this.cause = Cause.source(this.service).build();
    }

    private static <T> List<T> ls(T el) {
        return ImmutableList.of(el);
    }

    @Override
    public Map<Set<Context>, Map<String, Boolean>> getAllPermissions() {
        ImmutableMap.Builder<Set<Context>, Map<String, Boolean>> ret = ImmutableMap.builder();
        for (Map.Entry<Set<Context>, NodeTree> ent : this.permissions.get().entrySet()) {
            ret.put(ent.getKey(), ent.getValue().asMap());
        }
        return ret.build();
    }

    /**
     * Gets the calculated node tree representation of the permissions for this subject data instance.
     * If no data is present for the given context, returns null.
     *
     * @param contexts The contexts to get a node tree for
     * @return The node tree
     */
    public NodeTree getNodeTree(Set<Context> contexts) {
        NodeTree perms = this.permissions.get().get(contexts);
        return perms == null ? NodeTree.of(Collections.emptyMap()) : perms;
    }

    @Override
    public Map<String, Boolean> getPermissions(Set<Context> contexts) {
        NodeTree perms = this.permissions.get().get(contexts);
        return perms == null ? Collections.emptyMap() : perms.asMap();
    }

    @Override
    public boolean setPermission(Set<Context> contexts, String permission, Tristate value) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            NodeTree oldTree = this.permissions.get().get(contexts);
            if (oldTree != null && oldTree.get(permission) == value) {
                return false;
            }

            if (oldTree == null && value != Tristate.UNDEFINED) {
                if (this.permissions.get().putIfAbsent(contexts, NodeTree.of(ImmutableMap.of(permission, value.asBoolean()))) == null) {
                    Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventPermission(this.cause,
                            ls(new PermissionChange(permission, Tristate.UNDEFINED, value)), contexts, this.subject));
                    break;
                }
            } else {
                if (oldTree == null) { // There is no permission set and we are unsetting the permission, so effectively a no-op
                    break;
                } else if (this.permissions.get().replace(contexts, oldTree, oldTree.withValue(permission, value))) {
                    Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventPermission(this.cause,
                            ls(new PermissionChange(permission, oldTree.getOwn(permission), value)), contexts, this.subject));
                    break;
                }
            }
        }
        return true;

    }

    @Override
    public boolean clearPermissions() {
        Map<Set<Context>, NodeTree> oldPerms = this.permissions.getAndSet(new ConcurrentHashMap<>());
        if (oldPerms.isEmpty()) {
            return false;
        }
        oldPerms.forEach((ctx, tree) -> {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventPermission(this.cause, tree.asMap().entrySet().stream()
                    .map(ent -> new PermissionChange(ent.getKey(), Tristate.fromBoolean(ent.getValue()), Tristate.UNDEFINED))
                    .collect(GuavaCollectors.toImmutableList()), ctx, this.subject));
        });
        return true;
    }

    @Override
    public boolean clearPermissions(Set<Context> context) { // TODO: How to throw events here?
        NodeTree oldPerms = this.permissions.get().remove(context);
        if (oldPerms != null) {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventPermission(this.cause, oldPerms.asMap().entrySet().stream()
                    .map(ent -> new PermissionChange(ent.getKey(), Tristate.fromBoolean(ent.getValue()), Tristate.UNDEFINED))
                    .collect(GuavaCollectors.toImmutableList()), context, this.subject));
        }
        return oldPerms != null;
    }

    @Override
    public Map<Set<Context>, List<Subject>> getAllParents() {
        ImmutableMap.Builder<Set<Context>, List<Subject>> ret = ImmutableMap.builder();
        for (Map.Entry<Set<Context>, List<Map.Entry<String, String>>> ent : this.parents.get().entrySet()) {
            ret.put(ent.getKey(), toSubjectList(ent.getValue()));
        }
        return ret.build();
    }

    List<Subject> toSubjectList(@Nullable List<Map.Entry<String, String>> parents) {
        if (parents == null) {
            return ImmutableList.of();
        }

        ImmutableList.Builder<Subject> ret = ImmutableList.builder();
        try {
            for (Map.Entry<String, String> ent : parents) {
                ret.add(this.service.getSubjects(ent.getKey()).thenCompose(coll -> coll.get(ent.getValue())).get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e); // TODO: Figure out how to handle this
        }
        return ret.build();
    }

    @Override
    public List<Subject> getParents(Set<Context> contexts) {
        List<Map.Entry<String, String>> ret = this.parents.get().get(contexts);
        return toSubjectList(ret);
    }

    @Override
    public boolean addParent(Set<Context> contexts, Subject parent) {
        contexts = ImmutableSet.copyOf(contexts);
        while (true) {
            Map.Entry<String, String> newEnt = Maps.immutableEntry(parent.getContainingCollection().getIdentifier(),
                    parent.getIdentifier());
            List<Map.Entry<String, String>> oldParents = this.parents.get().get(contexts);
            List<Map.Entry<String, String>> newParents = ImmutableList.<Map.Entry<String, String>>builder()
                    .addAll(oldParents == null ? Collections.emptyList() : oldParents)
                    .add(newEnt)
                    .build();
            if (oldParents != null && oldParents.contains(newEnt)) {
                return false;
            }

            if (updateCollection(this.parents.get(), contexts, oldParents, newParents)) {
                Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventParents(this.cause, contexts, toSubjectList(newParents),
                        toSubjectList(oldParents), this.subject));
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
            List<Map.Entry<String, String>> oldParents = this.parents.get().get(contexts);
            List<Map.Entry<String, String>> newParents;

            if (oldParents == null || !oldParents.contains(removeEnt)) {
                return false;
            }
            newParents = new ArrayList<>(oldParents);
            newParents.remove(removeEnt);

            if (updateCollection(this.parents.get(), contexts, oldParents, Collections.unmodifiableList(newParents))) {
                Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventParents(this.cause, contexts, toSubjectList(newParents),
                        toSubjectList(oldParents), this.subject));
                return true;
            }
        }

    }

    @Override
    public boolean clearParents() {
        Map<Set<Context>, List<Map.Entry<String, String>>> oldParents = this.parents.getAndSet(new ConcurrentHashMap<>());
        if (oldParents.isEmpty()) {
            return false;
        }

        oldParents.forEach((ctx, parents) -> {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventParents(this.cause, ctx, ImmutableList.of(),
                    toSubjectList(parents), this.subject));
        });
        return true;
    }

    @Override
    public boolean clearParents(Set<Context> contexts) {
        List<Map.Entry<String, String>> oldParents = this.parents.get().remove(contexts);
        if (oldParents != null) {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventParents(this.cause, contexts, ImmutableList.of(),
                    toSubjectList(oldParents), this.subject));
        }
        return oldParents != null;
    }

    @Override
    public Map<Set<Context>, Map<String, String>> getAllOptions() {
        return ImmutableMap.copyOf(this.options.get());
    }

    @Override
    public Map<String, String> getOptions(Set<Context> contexts) {
        Map<String, String> ret = this.options.get().get(contexts);
        return ret == null ? ImmutableMap.of() : ImmutableMap.copyOf(ret);
    }

    @Override
    public boolean setOption(Set<Context> contexts, String key, @Nullable String value) {
        Map<String, String> origMap = this.options.get().get(contexts);
        Map<String, String> newMap;

        if (origMap == null) {
            if ((origMap = this.options.get().putIfAbsent(ImmutableSet.copyOf(contexts), ImmutableMap.of(key.toLowerCase(), value))) == null) {
                Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventOption(this.cause, ls(new OptionChange(key, null, value)),
                        contexts, this.subject));
                return true;
            }
        }
        do {
            if (value == null) {
                if (!origMap.containsKey(key)) {
                    return false;
                }
                newMap = new HashMap<>(origMap);
                newMap.remove(key);
            } else {
                newMap = new HashMap<>(origMap);
                newMap.put(key, value);
            }
            newMap = Collections.unmodifiableMap(newMap);
        } while (!this.options.get().replace(contexts, origMap, newMap));
        Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventOption(this.cause, ls(new OptionChange(key, origMap.get(key), value)),
                contexts, this.subject));
        return true;
    }

    @Override
    public boolean clearOptions(Set<Context> contexts) {
        Map<String, String> oldOptions = this.options.get().remove(contexts);
        if (oldOptions != null) {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventOption(this.cause, oldOptions.entrySet().stream()
                    .map(ent -> new OptionChange(ent.getKey(), ent.getValue(), null))
                    .collect(GuavaCollectors.toImmutableList()), contexts, this.subject));
        }
        return oldOptions != null;
    }

    @Override
    public boolean clearOptions() {
        Map<Set<Context>, Map<String, String>> oldOptions = this.options.getAndSet(new ConcurrentHashMap<>());
        if (oldOptions.isEmpty()) {
            return false;
        }
        oldOptions.forEach((ctx, options) -> {
            Sponge.getEventManager().post(SpongeEventFactory.createChangeSubjectEventOption(this.cause, options.entrySet().stream()
                    .map(ent -> new OptionChange(ent.getKey(), ent.getValue(), null))
                    .collect(GuavaCollectors.toImmutableList()), ctx, this.subject));
        });
        return true;
    }
}
