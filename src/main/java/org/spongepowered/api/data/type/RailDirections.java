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
 * An enumeration of vanilla {@link RailDirection}s.
 */
public final class RailDirections {

    // SORTFIELDS:ON

    public static final Supplier<RailDirection> ASCENDING_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "ASCENDING_EAST");

    public static final Supplier<RailDirection> ASCENDING_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "ASCENDING_NORTH");

    public static final Supplier<RailDirection> ASCENDING_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "ASCENDING_SOUTH");

    public static final Supplier<RailDirection> ASCENDING_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "ASCENDING_WEST");

    public static final Supplier<RailDirection> EAST_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "EAST_WEST");

    public static final Supplier<RailDirection> NORTH_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "NORTH_EAST");

    public static final Supplier<RailDirection> NORTH_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "NORTH_SOUTH");

    public static final Supplier<RailDirection> NORTH_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "NORTH_WEST");

    public static final Supplier<RailDirection> SOUTH_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "SOUTH_EAST");

    public static final Supplier<RailDirection> SOUTH_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RailDirection.class, "SOUTH_WEST");

    // SORTFIELDS:OFF

    private RailDirections() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
