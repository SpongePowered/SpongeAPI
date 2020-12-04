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
 * An enumeration of vanilla {@link WoodType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class WoodTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<WoodType> ACACIA = WoodTypes.key(ResourceKey.sponge("acacia"));

    public static final DefaultedRegistryReference<WoodType> BIRCH = WoodTypes.key(ResourceKey.sponge("birch"));

    public static final DefaultedRegistryReference<WoodType> DARK_OAK = WoodTypes.key(ResourceKey.sponge("dark_oak"));

    public static final DefaultedRegistryReference<WoodType> JUNGLE = WoodTypes.key(ResourceKey.sponge("jungle"));

    public static final DefaultedRegistryReference<WoodType> OAK = WoodTypes.key(ResourceKey.sponge("oak"));

    public static final DefaultedRegistryReference<WoodType> SPRUCE = WoodTypes.key(ResourceKey.sponge("spruce"));

    // SORTFIELDS:OFF

    // @formatter:on

    private WoodTypes() {
    }

    private static DefaultedRegistryReference<WoodType> key(final ResourceKey location) {
        return RegistryKey.<WoodType>of(Registries.WOOD_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
