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
package org.spongepowered.api.util.orientation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Supplier;

/**
 * An enumeration of possible rotations for something that can rotate,
 * such as an {@link ItemStack} within
 * an {@link ItemFrame}.
 */
public final class Orientations {

    // SORTFIELDS:ON

    public static final Supplier<Orientation> BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "bottom");

    public static final Supplier<Orientation> BOTTOM_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "bottom_left");

    public static final Supplier<Orientation> BOTTOM_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "bottom_right");

    public static final Supplier<Orientation> LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "left");

    public static final Supplier<Orientation> RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "right");

    public static final Supplier<Orientation> TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "top");

    public static final Supplier<Orientation> TOP_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "top_left");

    public static final Supplier<Orientation> TOP_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Orientation.class, "top_right");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Orientations() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
