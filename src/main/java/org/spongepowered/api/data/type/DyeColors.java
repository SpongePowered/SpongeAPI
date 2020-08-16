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
package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link DyeColor}s.
 */
public final class DyeColors {

    // SORTFIELDS:ON

    public static final Supplier<DyeColor> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "black");

    public static final Supplier<DyeColor> BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "blue");

    public static final Supplier<DyeColor> BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "brown");

    public static final Supplier<DyeColor> CYAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "cyan");

    public static final Supplier<DyeColor> GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "gray");

    public static final Supplier<DyeColor> GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "green");

    public static final Supplier<DyeColor> LIGHT_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "light_blue");

    public static final Supplier<DyeColor> LIGHT_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "light_gray");

    public static final Supplier<DyeColor> LIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "lime");

    public static final Supplier<DyeColor> MAGENTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "magenta");

    public static final Supplier<DyeColor> ORANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "orange");

    public static final Supplier<DyeColor> PINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "pink");

    public static final Supplier<DyeColor> PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "purple");

    public static final Supplier<DyeColor> RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "red");

    public static final Supplier<DyeColor> WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "white");

    public static final Supplier<DyeColor> YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DyeColor.class, "yellow");

    // SORTFIELDS:OFF

    private DyeColors() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
