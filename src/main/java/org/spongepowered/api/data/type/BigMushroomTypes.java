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
 * An enumeration of known vanilla {@link BigMushroomType}s.
 */
public final class BigMushroomTypes {

    // SORTFIELDS:ON

    public static final BigMushroomType ALL_INSIDE = DummyObjectProvider.createFor(BigMushroomType.class, "ALL_INSIDE");

    public static final BigMushroomType ALL_OUTSIDE = DummyObjectProvider.createFor(BigMushroomType.class, "ALL_OUTSIDE");

    public static final BigMushroomType ALL_STEM = DummyObjectProvider.createFor(BigMushroomType.class, "ALL_STEM");

    public static final BigMushroomType CENTER = DummyObjectProvider.createFor(BigMushroomType.class, "CENTER");

    public static final BigMushroomType EAST = DummyObjectProvider.createFor(BigMushroomType.class, "EAST");

    public static final BigMushroomType NORTH = DummyObjectProvider.createFor(BigMushroomType.class, "NORTH");

    public static final BigMushroomType NORTH_EAST = DummyObjectProvider.createFor(BigMushroomType.class, "NORTH_EAST");

    public static final BigMushroomType NORTH_WEST = DummyObjectProvider.createFor(BigMushroomType.class, "NORTH_WEST");

    public static final BigMushroomType SOUTH = DummyObjectProvider.createFor(BigMushroomType.class, "SOUTH");

    public static final BigMushroomType SOUTH_EAST = DummyObjectProvider.createFor(BigMushroomType.class, "SOUTH_EAST");

    public static final BigMushroomType SOUTH_WEST = DummyObjectProvider.createFor(BigMushroomType.class, "SOUTH_WEST");

    public static final BigMushroomType STEM = DummyObjectProvider.createFor(BigMushroomType.class, "STEM");

    public static final BigMushroomType WEST = DummyObjectProvider.createFor(BigMushroomType.class, "WEST");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BigMushroomTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
