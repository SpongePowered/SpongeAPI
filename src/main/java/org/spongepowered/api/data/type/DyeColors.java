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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of known {@link DyeColor} types.
 */
public final class DyeColors {

    // SORTFIELDS:ON

    public static final DyeColor BLACK = DummyObjectProvider.createFor(DyeColor.class, "BLACK");

    public static final DyeColor BLUE = DummyObjectProvider.createFor(DyeColor.class, "BLUE");

    public static final DyeColor BROWN = DummyObjectProvider.createFor(DyeColor.class, "BROWN");

    public static final DyeColor CYAN = DummyObjectProvider.createFor(DyeColor.class, "CYAN");

    public static final DyeColor GRAY = DummyObjectProvider.createFor(DyeColor.class, "GRAY");

    public static final DyeColor GREEN = DummyObjectProvider.createFor(DyeColor.class, "GREEN");

    public static final DyeColor LIGHT_BLUE = DummyObjectProvider.createFor(DyeColor.class, "LIGHT_BLUE");

    public static final DyeColor LIME = DummyObjectProvider.createFor(DyeColor.class, "LIME");

    public static final DyeColor MAGENTA = DummyObjectProvider.createFor(DyeColor.class, "MAGENTA");

    public static final DyeColor ORANGE = DummyObjectProvider.createFor(DyeColor.class, "ORANGE");

    public static final DyeColor PINK = DummyObjectProvider.createFor(DyeColor.class, "PINK");

    public static final DyeColor PURPLE = DummyObjectProvider.createFor(DyeColor.class, "PURPLE");

    public static final DyeColor RED = DummyObjectProvider.createFor(DyeColor.class, "RED");

    public static final DyeColor SILVER = DummyObjectProvider.createFor(DyeColor.class, "SILVER");

    public static final DyeColor WHITE = DummyObjectProvider.createFor(DyeColor.class, "WHITE");

    public static final DyeColor YELLOW = DummyObjectProvider.createFor(DyeColor.class, "YELLOW");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DyeColors() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
