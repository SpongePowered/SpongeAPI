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
import org.spongepowered.api.util.Tristate;

import java.util.Map;

/**
 * Container for a {@link Subject}'s data.
 */
public interface SubjectData {

    /**
     * The {@link Subject} this data belong to.
     *
     * @return The subject this data belong to
     */
    Subject getSubject();

    /**
     * Checks whether the {@link Subject} belonging to this data
     *
     * @param permission
     * @return
     */
    boolean hasPermission(String permission);

    /**
     * Grants or declines or resets a permission for the associated
     * {@link Subject}. This method does not include parents.
     *
     * @param permission The permission to grant or decline
     * @return {@link Tristate#TRUE} if the given permission is granted.
     *         {@link Tristate#FALSE} if the given permission is declined.
     *         {@link Tristate#UNDEFINED} if the given permission is undefined
     */
    Tristate getPermission(String permission);

    /**
     * Return all permissions associated with this data object.
     *
     * @return A map of all permissions
     */
    Map<String, Tristate> getPermissions();

    /**
     * Gets the subject that actually granted or declined the given permission.
     * If the authority granted or declined the permission itself it will return
     * <tt>this</tt>. If more authorities grant or decline this permission the
     * first one will be returned that is used to calculate the result for
     * {@link #isPermitted(String)}.
     *
     * @param permission The permission string
     * @return The subject that has granted or declined the given permission
     */
    Optional<Subject> getPermissionAuthority(String permission);

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
     * Gets the subject that provided the given permission value. If the
     * authority provided/calculated the given permission value itself it will
     * return <tt>this</tt>. If more authorities provide the same value the
     * first one will be returned.
     *
     * @param permissionValue The permission string
     * @return The subject that provides the given permission value if available
     */
    Optional<Subject> getPermissionValueAuthority(String permissionValue);

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
     * Return all registered parents.
     *
     * @return An immutable iterable containing all parents.
     */
    public Iterable<Subject> getAllParents();

}
