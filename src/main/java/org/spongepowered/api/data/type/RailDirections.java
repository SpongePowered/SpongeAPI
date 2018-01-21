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

public final class RailDirections {

    // SORTFIELDS:ON

    public static final RailDirection ASCENDING_EAST = DummyObjectProvider.createFor(RailDirection.class, "ASCENDING_EAST");

    public static final RailDirection ASCENDING_NORTH = DummyObjectProvider.createFor(RailDirection.class, "ASCENDING_NORTH");

    public static final RailDirection ASCENDING_SOUTH = DummyObjectProvider.createFor(RailDirection.class, "ASCENDING_SOUTH");

    public static final RailDirection ASCENDING_WEST = DummyObjectProvider.createFor(RailDirection.class, "ASCENDING_WEST");

    public static final RailDirection EAST_WEST = DummyObjectProvider.createFor(RailDirection.class, "EAST_WEST");

    public static final RailDirection NORTH_EAST = DummyObjectProvider.createFor(RailDirection.class, "NORTH_EAST");

    public static final RailDirection NORTH_SOUTH = DummyObjectProvider.createFor(RailDirection.class, "NORTH_SOUTH");

    public static final RailDirection NORTH_WEST = DummyObjectProvider.createFor(RailDirection.class, "NORTH_WEST");

    public static final RailDirection SOUTH_EAST = DummyObjectProvider.createFor(RailDirection.class, "SOUTH_EAST");

    public static final RailDirection SOUTH_WEST = DummyObjectProvider.createFor(RailDirection.class, "SOUTH_WEST");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private RailDirections() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
