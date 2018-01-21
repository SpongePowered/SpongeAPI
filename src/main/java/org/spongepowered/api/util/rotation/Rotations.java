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
package org.spongepowered.api.util.rotation;

import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of possible rotations for something that can rotate,
 * such as an {@link ItemStack} within
 * an {@link ItemFrame}.
 */
public final class Rotations {

    // SORTFIELDS:ON

    public static final Rotation BOTTOM = DummyObjectProvider.createFor(Rotation.class, "BOTTOM");

    public static final Rotation BOTTOM_LEFT = DummyObjectProvider.createFor(Rotation.class, "BOTTOM_LEFT");

    public static final Rotation BOTTOM_RIGHT = DummyObjectProvider.createFor(Rotation.class, "BOTTOM_RIGHT");

    public static final Rotation LEFT = DummyObjectProvider.createFor(Rotation.class, "LEFT");

    public static final Rotation RIGHT = DummyObjectProvider.createFor(Rotation.class, "RIGHT");

    public static final Rotation TOP = DummyObjectProvider.createFor(Rotation.class, "TOP");

    public static final Rotation TOP_LEFT = DummyObjectProvider.createFor(Rotation.class, "TOP_LEFT");

    public static final Rotation TOP_RIGHT = DummyObjectProvider.createFor(Rotation.class, "TOP_RIGHT");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Rotations() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
