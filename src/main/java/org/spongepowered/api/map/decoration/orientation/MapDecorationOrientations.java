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
package org.spongepowered.api.map.decoration.orientation;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * A pseudo-enum of supported orientations of a {@link org.spongepowered.api.map.decoration.MapDecoration}
 * The {@link #NORTH} orientation is the upwards orientation on a map.
 */
public class MapDecorationOrientations {

	// SORTFIELDS:ON

	public static final Supplier<MapDecorationOrientation> NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "north");

	public static final Supplier<MapDecorationOrientation> NORTH_NORTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "north_northeast");

	public static final Supplier<MapDecorationOrientation> NORTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "northeast");

	public static final Supplier<MapDecorationOrientation> EAST_NORTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "east_northeast");

	public static final Supplier<MapDecorationOrientation> EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "east");

	public static final Supplier<MapDecorationOrientation> EAST_SOUTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "east_southeast");

	public static final Supplier<MapDecorationOrientation> SOUTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "southeast");

	public static final Supplier<MapDecorationOrientation> SOUTH_SOUTHEAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "south_southeast");

	public static final Supplier<MapDecorationOrientation> SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "south");

	public static final Supplier<MapDecorationOrientation> SOUTH_SOUTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "south_southwest");

	public static final Supplier<MapDecorationOrientation> SOUTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "southwest");

	public static final Supplier<MapDecorationOrientation> WEST_SOUTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "west_southwest");

	public static final Supplier<MapDecorationOrientation> WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "west");

	public static final Supplier<MapDecorationOrientation> WEST_NORTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "west_northwest");

	public static final Supplier<MapDecorationOrientation> NORTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "northwest");

	public static final Supplier<MapDecorationOrientation> NORTH_NORTHWEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationOrientation.class, "north_northwest");

	// SORTFIELDS:OFF

	private MapDecorationOrientations() { throw new AssertionError("You should not be attempting to instantiate this class."); }
}
