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
package org.spongepowered.api.map.color;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.map.decoration.MapDecorationType;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

import java.util.function.Supplier;

/**
 * A pseudo-enum of supported {@link MapShade}s for a {@link MapColor}.
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public final class MapShades {

	// SORTFIELDS:ON

	public static final DefaultedRegistryReference<MapShade> DARKER = MapShades.key(ResourceKey.sponge("darker"));

	public static final DefaultedRegistryReference<MapShade> DARK = MapShades.key(ResourceKey.sponge("dark"));

	public static final DefaultedRegistryReference<MapShade> BASE = MapShades.key(ResourceKey.sponge("base"));

	public static final DefaultedRegistryReference<MapShade> DARKEST = MapShades.key(ResourceKey.sponge("darkest"));

	// SORTFIELDS:OFF

	private MapShades() {
		throw new AssertionError("You should not be attempting to instantiate this class.");
	}

	private static DefaultedRegistryReference<MapShade> key(final ResourceKey location) {
		return RegistryKey.of(RegistryTypes.MAP_SHADE, location).asDefaultedReference(() -> Sponge.getGame().registries());
	}
}
