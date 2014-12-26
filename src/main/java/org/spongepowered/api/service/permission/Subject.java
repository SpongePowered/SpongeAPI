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

import com.google.common.base.Optional;

import org.spongepowered.api.service.permission.context.Context;

/**
 * A source of permission requests.
 *
 * <p>Authorization checks are made using "permission strings."</p>
 *
 * <p>Permission strings are hierarchical with each level separated
 * by periods (full stops). An example of a valid permission string is
 * {@code example.function}. Inheritance is implicit; that is,
 * if a subject has been granted {@code example}, then the subject
 * should have also be automatically granted
 * {@code example.function}, {@code example.another},
 * {@code example.deeper.nesting}, and so on. However, implementations
 * may allow administrators to configure "negation" such that
 * {@code example} and all child levels would granted but
 * {@code example.access} would denied (for example).</p>
 *
 * <p>Plugins may opt to implement "dynamic" permissions such as
 * {@code example.region.define.&lt;region&gt;} where {@code region}
 * would be a dynamically added level based on the context, though some
 * attention should be made towards the handling of periods / full stops
 * in such cases.</p>
 *
 * <p>Due to the implicit inheritance, it is recommended that
 * commands that allow a user to "apply" an effect to other users
 * use {@code example.function.self} as the permission for applying
 * this effect to one's self. This allows administrators to grant
 * {@code example.function.self} to permit usage on one's self
 * and grant {@code example.function} to grant usage on other users.</p>
 *
 * <p>Use a {@link PermissionService} to create instances.</p>
 *
 * @see PermissionService
 */
public interface Subject {

    /**
     * Returns the identifier associated with this subject. May not be
     * human-readable, but always refers to a single subject (of the same type).
     *
     * @return The identifier associated with this subject.
     */
    String getIdentifier();

    /**
     * Gets the type of this subject.
     *
     * @return The type of this subject
     */
    SubjectType getType();

    /**
     * The container for permissions data that <b>may</b> be persisted if the
     * service provider supports it. This might return the same object as
     * {@link #getTransientData()} if the provider for this service does not
     * implement persistence for permissions data.
     *
     * @return The container for permissions data this subject uses
     */
    public SubjectData getData();

    /**
     * Returns container for subject data that is guaranteed to be transient
     * (only lasting for the duration of the subject's session, not persisted).
     * This might return the same object as {@link #getData()} if the provider
     * for this service does not implement persistence for permissions data.
     *
     * @return The transient container for permissions data this subject uses
     */
    public SubjectData getTransientData();

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string using all active {@link Context}s.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    public boolean hasPermission(String permission);

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string using the given {@link Context}s. It is not
     * required that the subject currently uses any of this {@link Context}s.
     *
     * @param permission The permission string
     * @param contexts The context to check for permissions
     * @return True if permission is granted
     */
    public boolean hasPermission(String permission, Iterable<Context> contexts);

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string using the given {@link Context}s. It is not
     * required that the subject currently uses any of this {@link Context}s.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    boolean hasPermission(String permission, Context... contexts);

    /**
     * Gets the permission value for the given permission string. If this
     * subject does not support permission values this will always return
     * Optional.absent().
     *
     * @param permissionValue The permission string
     * @param clazz The class the value should be converted to if found
     * @return The permission value with the given type if available.
     * @param <T> specifies the result type
     * @throws ClassCastException If the value was found but could not be
     *             converted to the given class.
     */
    <T> Optional<T> getPermissionValue(String permissionValue, Class<T> clazz) throws ClassCastException;

    /**
     * Checks whether this subject is a child of the given subject. This will
     * also return true for any subsequent children the given subject may have.
     *
     * @param parent The parent subject to check
     * @return True if this a child of the given parent or any of its subsequent
     *         children it may have, false otherwise
     */
    boolean isChildOf(Subject parent);

    /**
     * Gets all currently active parents that this subject has.
     *
     * @param recursive True if also parents of the parents should be
     *            recursively included
     * @return An immutable iterable containing the parents
     * @see SubjectData#getAllParents()
     */
    Iterable<Subject> getParents(boolean recursive);

    /**
     * Gets all currently active {@link Context}s for this subject.
     *
     * @return An immutable iterable of active contexts
     */
    Iterable<Context> getActiveContexts();

}
