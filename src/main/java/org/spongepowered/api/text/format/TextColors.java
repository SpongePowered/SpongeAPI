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
package org.spongepowered.api.text.format;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;

import java.util.function.Supplier;

/**
 * TextColors is a list of text colors provided by Vanilla Minecraft.
 */
public final class TextColors {

    /**
     * Represents a base color that is used as default if no color is specified.
     * This will result in either the default color of the receiver or inherit
     * it from a parent {@link Text}.
     */
    public static final Supplier<TextColor> NONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "NONE");

    /**
     * Resets the current color to the default one on the client. In most cases
     * this should be the same as {@link #WHITE}.
     */
    public static final Supplier<TextColor> RESET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "RESET");

    // SORTFIELDS:ON

    public static final Supplier<TextColor> AQUA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "AQUA");

    public static final Supplier<TextColor> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "BLACK");

    public static final Supplier<TextColor> BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "BLUE");

    public static final Supplier<TextColor> DARK_AQUA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_AQUA");

    public static final Supplier<TextColor> DARK_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_BLUE");

    public static final Supplier<TextColor> DARK_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_GRAY");

    public static final Supplier<TextColor> DARK_GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_GREEN");

    public static final Supplier<TextColor> DARK_PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_PURPLE");

    public static final Supplier<TextColor> DARK_RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "DARK_RED");

    public static final Supplier<TextColor> GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "GOLD");

    public static final Supplier<TextColor> GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "GRAY");

    public static final Supplier<TextColor> GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "GREEN");

    public static final Supplier<TextColor> LIGHT_PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "LIGHT_PURPLE");

    public static final Supplier<TextColor> RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "RED");

    public static final Supplier<TextColor> WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "WHITE");

    public static final Supplier<TextColor> YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TextColor.class, "YELLOW");

    // SORTFIELDS:OFF

    private TextColors() {
    }
}
