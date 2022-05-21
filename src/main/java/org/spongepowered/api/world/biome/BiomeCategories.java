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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

// TODO Enum Biome.BiomeCategory
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BiomeCategories {

    // @formatter:off

    public static final DefaultedRegistryReference<BiomeCategory> NONE = BiomeCategories.key(ResourceKey.sponge("none"));

    public static final DefaultedRegistryReference<BiomeCategory> TAIGA = BiomeCategories.key(ResourceKey.sponge("taiga"));

    public static final DefaultedRegistryReference<BiomeCategory> EXTREME_HILLS = BiomeCategories.key(ResourceKey.sponge("extreme_hills"));

    public static final DefaultedRegistryReference<BiomeCategory> JUNGLE = BiomeCategories.key(ResourceKey.sponge("jungle"));

    public static final DefaultedRegistryReference<BiomeCategory> MESA = BiomeCategories.key(ResourceKey.sponge("mesa"));

    public static final DefaultedRegistryReference<BiomeCategory> PLAINS = BiomeCategories.key(ResourceKey.sponge("plains"));

    public static final DefaultedRegistryReference<BiomeCategory> SAVANNA = BiomeCategories.key(ResourceKey.sponge("savanna"));

    public static final DefaultedRegistryReference<BiomeCategory> ICY = BiomeCategories.key(ResourceKey.sponge("icy"));

    public static final DefaultedRegistryReference<BiomeCategory> THEEND = BiomeCategories.key(ResourceKey.sponge("theend"));

    public static final DefaultedRegistryReference<BiomeCategory> BEACH = BiomeCategories.key(ResourceKey.sponge("beach"));

    public static final DefaultedRegistryReference<BiomeCategory> FOREST = BiomeCategories.key(ResourceKey.sponge("forest"));

    public static final DefaultedRegistryReference<BiomeCategory> OCEAN = BiomeCategories.key(ResourceKey.sponge("ocean"));

    public static final DefaultedRegistryReference<BiomeCategory> DESERT = BiomeCategories.key(ResourceKey.sponge("desert"));

    public static final DefaultedRegistryReference<BiomeCategory> RIVER = BiomeCategories.key(ResourceKey.sponge("river"));

    public static final DefaultedRegistryReference<BiomeCategory> SWAMP = BiomeCategories.key(ResourceKey.sponge("swamp"));

    public static final DefaultedRegistryReference<BiomeCategory> MUSHROOM = BiomeCategories.key(ResourceKey.sponge("mushroom"));

    public static final DefaultedRegistryReference<BiomeCategory> NETHER = BiomeCategories.key(ResourceKey.sponge("nether"));

    public static final DefaultedRegistryReference<BiomeCategory> UNDERGROUND = BiomeCategories.key(ResourceKey.sponge("underground"));

    public static final DefaultedRegistryReference<BiomeCategory> MOUNTAIN = BiomeCategories.key(ResourceKey.sponge("mountain"));

    // @formatter:on

    private BiomeCategories() {
    }

    public static Registry<BiomeCategory> registry() {
        return Sponge.game().registry(RegistryTypes.BIOME_CATEGORY);
    }

    private static DefaultedRegistryReference<BiomeCategory> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.BIOME_CATEGORY, location).asDefaultedReference(Sponge::game);
    }
}
