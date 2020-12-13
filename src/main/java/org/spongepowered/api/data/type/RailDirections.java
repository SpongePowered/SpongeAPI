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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link RailDirection}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class RailDirections {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<RailDirection> ASCENDING_EAST = RailDirections.key(ResourceKey.sponge("ascending_east"));

    public static final DefaultedRegistryReference<RailDirection> ASCENDING_NORTH = RailDirections.key(ResourceKey.sponge("ascending_north"));

    public static final DefaultedRegistryReference<RailDirection> ASCENDING_SOUTH = RailDirections.key(ResourceKey.sponge("ascending_south"));

    public static final DefaultedRegistryReference<RailDirection> ASCENDING_WEST = RailDirections.key(ResourceKey.sponge("ascending_west"));

    public static final DefaultedRegistryReference<RailDirection> EAST_WEST = RailDirections.key(ResourceKey.sponge("east_west"));

    public static final DefaultedRegistryReference<RailDirection> NORTH_EAST = RailDirections.key(ResourceKey.sponge("north_east"));

    public static final DefaultedRegistryReference<RailDirection> NORTH_SOUTH = RailDirections.key(ResourceKey.sponge("north_south"));

    public static final DefaultedRegistryReference<RailDirection> NORTH_WEST = RailDirections.key(ResourceKey.sponge("north_west"));

    public static final DefaultedRegistryReference<RailDirection> SOUTH_EAST = RailDirections.key(ResourceKey.sponge("south_east"));

    public static final DefaultedRegistryReference<RailDirection> SOUTH_WEST = RailDirections.key(ResourceKey.sponge("south_west"));

    // SORTFIELDS:OFF

    // @formatter:on

    private RailDirections() {
    }

    private static DefaultedRegistryReference<RailDirection> key(final ResourceKey location) {
        return RegistryKey.<RailDirection>of(Registries.RAIL_DIRECTION.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
