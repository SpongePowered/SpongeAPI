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

import org.spongepowered.api.util.Tristate;

/**
 * Represents a mutable {@link Subject}.
 */
public interface MutableSubjectData extends SubjectData {

    /**
     * Grants or declines or resets a permission for the associated
     * {@link Subject}.
     *
     * @param permission The permission to grant or decline
     * @param value {@link Tristate#TRUE} to grand the given permission.
     *            {@link Tristate#FALSE} to decline the given permission.
     *            {@link Tristate#UNDEFINED} to reset the given permission
     */
    void setPermission(String permission, Tristate value);

    /**
     * Clears all granted or declined permissions from the subject this data
     * belongs to.
     */
    void clearPermissions();

    /**
     * Sets the permission value for the given permission string.
     *
     * @param permissionValue The permission string
     * @param value The value to set
     * @throws UnsupportedOperationException If this subject does not support
     *             permission values
     * @throws IllegalArgumentException If the value is not supported by the
     *             subject
     */
    void setPermissionValue(String permissionValue, Object value) throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * Removes the permission value for the given permission string.
     *
     * @param permissionValue The permission string
     */
    void removePermissionValue(String permissionValue);

    /**
     * Clears all granted or declined permissions from the subject this data
     * belongs to.
     */
    void clearPermissionValues();

    /**
     * Adds the specified parent to this subject's data.
     *
     * @param parent The parent to add to this subject
     */
    public void addParent(Subject parent);

    /**
     * Removes the specified parent from this subject's data. This method does
     * nothing if the given subject is not a parent of this subject. Only direct
     * parents are removed, recursive parents are not effected by this.
     *
     * @param parent The parent to remove from this subject
     */
    public void removeParent(Subject parent);

    /**
     * Removes all direct parents from this subject's data.
     */
    public void clearParents();

}
