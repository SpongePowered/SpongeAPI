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
package org.spongepowered.api.service.permission.change;

import org.spongepowered.api.util.Tristate;

/**
 * Represents a change in permission values
 */
public class PermissionChange {
    private final String permission;
    private final Tristate oldValue;
    private final Tristate newValue;

    public PermissionChange(String permission, Tristate oldValue, Tristate newValue) {
        this.permission = permission;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * The permission with a value being changed.
     *
     * @return The permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * The old value of the permission. {@link Tristate#UNDEFINED} if the permission has not been set before.
     *
     * @return The old value
     */
    public Tristate getOldValue() {
        return oldValue;
    }

    /**
     * The new value of the permission. {@link Tristate#UNDEFINED} if the permission will be unset.
     *
     * @return The new value
     */
    public Tristate getNewValue() {
        return newValue;
    }
}
