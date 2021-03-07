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
package org.spongepowered.api.world.generation.structure;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@RegistryScopes(scopes = RegistryScope.GAME)
public final class Structures {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<Structure> BASTION_REMNANT = Structures.key(ResourceKey.minecraft("bastion_remnant"));

    public static final DefaultedRegistryReference<Structure> BURIED_TREASURE = Structures.key(ResourceKey.minecraft("buried_treasure"));

    public static final DefaultedRegistryReference<Structure> DESERT_PYRAMID = Structures.key(ResourceKey.minecraft("desert_pyramid"));

    public static final DefaultedRegistryReference<Structure> END_CITY = Structures.key(ResourceKey.minecraft("endcity"));

    public static final DefaultedRegistryReference<Structure> IGLOO = Structures.key(ResourceKey.minecraft("igloo"));

    public static final DefaultedRegistryReference<Structure> JUNGLE_TEMPLE = Structures.key(ResourceKey.minecraft("jungle_pyramid"));

    public static final DefaultedRegistryReference<Structure> MINESHAFT = Structures.key(ResourceKey.minecraft("mineshaft"));

    public static final DefaultedRegistryReference<Structure> NETHER_BRIDGE = Structures.key(ResourceKey.minecraft("fortress"));

    public static final DefaultedRegistryReference<Structure> NETHER_FOSSIL = Structures.key(ResourceKey.minecraft("nether_fossil"));

    public static final DefaultedRegistryReference<Structure> OCEAN_MONUMENT = Structures.key(ResourceKey.minecraft("monument"));

    public static final DefaultedRegistryReference<Structure> OCEAN_RUIN = Structures.key(ResourceKey.minecraft("ocean_ruin"));

    public static final DefaultedRegistryReference<Structure> PILLAGER_OUTPOST = Structures.key(ResourceKey.minecraft("pillager_outpost"));

    public static final DefaultedRegistryReference<Structure> RUINED_PORTAL = Structures.key(ResourceKey.minecraft("ruined_portal"));

    public static final DefaultedRegistryReference<Structure> SHIPWRECK = Structures.key(ResourceKey.minecraft("shipwreck"));

    public static final DefaultedRegistryReference<Structure> STRONGHOLD = Structures.key(ResourceKey.minecraft("stronghold"));

    public static final DefaultedRegistryReference<Structure> SWAMP_HUT = Structures.key(ResourceKey.minecraft("swamp_hut"));

    public static final DefaultedRegistryReference<Structure> VILLAGE = Structures.key(ResourceKey.minecraft("village"));

    public static final DefaultedRegistryReference<Structure> WOODLAND_MANSION = Structures.key(ResourceKey.minecraft("mansion"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Structures() {
    }

    private static DefaultedRegistryReference<Structure> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.STRUCTURE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
