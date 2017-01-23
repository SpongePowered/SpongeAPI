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

import org.spongepowered.api.service.context.Context;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Object that manages subjects of a certain type (user, group, etc).
 *
 * A distinction is made between subjects that are stored and subjects that are currently cached. The cached methods must return quickly, but the
 * future methods may perform asynchronous computations within the future. Notably, the default subject must already be cached when the subject
 * collection is fetched. Note also that all of the methods within {@link Subject} are synchronous. This means that loading the subject into cache
 * also involves loading the entire parent hierarchy into cache and maintaining their position in cache as long as the child is in cache.
 */
public interface SubjectCollection {

    /**
     * Return the identifier for the type of subjects this collection contains.
     *
     * @return The appropriate identifier
     */
    String getIdentifier();

    /**
     * Get the type definition controlling how this subject functions.
     *
     * @return The type definition
     */
    SubjectTypeDefinition getDefinition();

    /**
     * Set the type definition that describes restrictions on this subject type.
     *
     * @param def The type definition. Must not be null.
     */
    void setDefinition(SubjectTypeDefinition def);

    /**
     * Returns the subject specified. Will not return null.
     *
     * @param identifier The identifier to look up a subject by.
     *                   Case-insensitive
     * @return A stored subject if present, otherwise a subject that may be
     *         stored if data is changed from defaults
     */
    CompletableFuture<Subject> get(String identifier);

    /**
     * Returns the subject specified. Will only return an empty optional if the subject has not been cached.
     *
     * @param identifier The identifier to look up a subject by.
     *                   Case-insensitive
     * @return A stored subject if present, otherwise a subject that may be
     *         stored if data is changed from defaults
     */
    Optional<Subject> getIfCached(String identifier);


    /**
     * Returns whether there is any data stored for the given subject. The
     * return value of this function does not influence whether or not the
     * result from {@link #get(String)} should be queried.
     *
     * @param identifier The identifier of the given subject
     * @return whether any data is stored
     */
    CompletableFuture<Boolean> hasRegistered(String identifier);

    /**
     * Returns whether or not the permissions provider has any data for the
     * given subject currently in its cache.
     *
     * @param identifier The identifier of the given subject
     * @return whether any data is stored
     */
    boolean hasCached(String identifier);

    /**
     * Returns all subjects. The iterator provided by this method may be
     * populated asynchronously. Be aware that for large collections this method
     * may be very resource-intensive
     *
     * @return An iterable providing all subjects stored by this collection.
     */
    CompletableFuture<Collection<Subject>> getAllSubjects();

    /**
     * Returns all subjects currently cached.
     *
     * @return An iterable providing all subjects stored by this collection.
     */
    Collection<Subject> getCachedSubjects();

    /**
     * Return all known subjects with the given permission information. Because
     * no context is passed, only subjects who have this permission globally or
     * subjects which have accurate context calculations are returned.
     *
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    CompletableFuture<Map<Subject, Boolean>> getAllWithPermission(String permission);

    /**
     * Return all known subjects with the given permission information.
     *
     * @param contexts The context combination to check for permissions in
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    CompletableFuture<Map<Subject, Boolean>> getAllWithPermission(Set<Context> contexts, String permission);

    /**
     * Return all subjects currently cached with the given permission information. Because
     * no context is passed, only subjects who have this permission globally or
     * subjects which have accurate context calculations are returned.
     *
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    Map<Subject, Boolean> getCachedWithPermission(String permission);

    /**
     * Return all subjects currently cached with the given permission information.
     *
     * @param contexts The context combination to check for permissions in
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    Map<Subject, Boolean> getCachedWithPermission(Set<Context> contexts, String permission);

    /**
     * Gets the subject holding data that is applied by default for subjects of this type.
     * This subject is placed at the root of any inheritance tree involving subjects of
     * this type, but has a higher priority than {@link PermissionService#getDefaults()}.
     *
     * <p>Note: This data may be persisted, so plugins that add permissions to this subject
     * must take care to not override permissions already set or modified. It is also
     * recommended to use {@link Subject#getTransientSubjectData()} where possible to
     * avoid persisting unnecessary data.
     *
     * @return The subject holding defaults
     */
    Subject getDefaults();

    /**
     * Indicate that a certain subject may be removed from cache. This is only a hint to the permissions plugin, though, so this does not guarantee
     * that a certain subject is removed from the cache.
     *
     * @param identifier The identifier of the subject to remove from cache.
     */
    void uncache(String identifier);
}
