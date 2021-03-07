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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * A pseudo-enum of supported orientations of a {@link org.spongepowered.api.map.decoration.MapDecoration}
 * The {@link #NORTH} orientation is the upwards orientation on a map.
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public class MapDecorationOrientations {

	// SORTFIELDS:ON

	public static final DefaultedRegistryReference<MapDecorationOrientation> NORTH = MapDecorationOrientations.key(ResourceKey.sponge("north"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> NORTH_NORTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("north_northeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> NORTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("northeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> EAST_NORTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("east_northeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> EAST = MapDecorationOrientations.key(ResourceKey.sponge("east"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> EAST_SOUTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("east_southeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> SOUTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("southeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> SOUTH_SOUTHEAST = MapDecorationOrientations.key(ResourceKey.sponge("south_southeast"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> SOUTH = MapDecorationOrientations.key(ResourceKey.sponge("south"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> SOUTH_SOUTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("south_southwest"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> SOUTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("southwest"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> WEST_SOUTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("west_southwest"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> WEST = MapDecorationOrientations.key(ResourceKey.sponge("west"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> WEST_NORTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("west_northwest"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> NORTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("northwest"));

	public static final DefaultedRegistryReference<MapDecorationOrientation> NORTH_NORTHWEST = MapDecorationOrientations.key(ResourceKey.sponge("north_northwest"));

	// SORTFIELDS:OFF

	private MapDecorationOrientations() { throw new AssertionError("You should not be attempting to instantiate this class."); }

	private static DefaultedRegistryReference<MapDecorationOrientation> key(final ResourceKey location) {
		return RegistryKey.of(RegistryTypes.MAP_DECORATION_ORIENTATION, location).asDefaultedReference(() -> Sponge.getGame().registries());
	}
}
