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
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link BiomeType}s available in vanilla
 * minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BiomeTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final RegistryReference<BiomeType> BADLANDS = BiomeTypes.key(ResourceKey.sponge("badlands"));

    public static final RegistryReference<BiomeType> BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.sponge("badlands_plateau"));

    public static final RegistryReference<BiomeType> BAMBOO_JUNGLE = BiomeTypes.key(ResourceKey.sponge("bamboo_jungle"));

    public static final RegistryReference<BiomeType> BAMBOO_JUNGLE_HILLS = BiomeTypes.key(ResourceKey.sponge("bamboo_jungle_hills"));

    public static final RegistryReference<BiomeType> BASALT_DELTAS = BiomeTypes.key(ResourceKey.sponge("basalt_deltas"));

    public static final RegistryReference<BiomeType> BEACH = BiomeTypes.key(ResourceKey.sponge("beach"));

    public static final RegistryReference<BiomeType> BIRCH_FOREST = BiomeTypes.key(ResourceKey.sponge("birch_forest"));

    public static final RegistryReference<BiomeType> BIRCH_FOREST_HILLS = BiomeTypes.key(ResourceKey.sponge("birch_forest_hills"));

    public static final RegistryReference<BiomeType> COLD_OCEAN = BiomeTypes.key(ResourceKey.sponge("cold_ocean"));

    public static final RegistryReference<BiomeType> CRIMSON_FOREST = BiomeTypes.key(ResourceKey.sponge("crimson_forest"));

    public static final RegistryReference<BiomeType> DARK_FOREST = BiomeTypes.key(ResourceKey.sponge("dark_forest"));

    public static final RegistryReference<BiomeType> DARK_FOREST_HILLS = BiomeTypes.key(ResourceKey.sponge("dark_forest_hills"));

    public static final RegistryReference<BiomeType> DEEP_COLD_OCEAN = BiomeTypes.key(ResourceKey.sponge("deep_cold_ocean"));

    public static final RegistryReference<BiomeType> DEEP_FROZEN_OCEAN = BiomeTypes.key(ResourceKey.sponge("deep_frozen_ocean"));

    public static final RegistryReference<BiomeType> DEEP_LUKEWARM_OCEAN = BiomeTypes.key(ResourceKey.sponge("deep_lukewarm_ocean"));

    public static final RegistryReference<BiomeType> DEEP_OCEAN = BiomeTypes.key(ResourceKey.sponge("deep_ocean"));

    public static final RegistryReference<BiomeType> DEEP_WARM_OCEAN = BiomeTypes.key(ResourceKey.sponge("deep_warm_ocean"));

    public static final RegistryReference<BiomeType> DESERT = BiomeTypes.key(ResourceKey.sponge("desert"));

    public static final RegistryReference<BiomeType> DESERT_HILLS = BiomeTypes.key(ResourceKey.sponge("desert_hills"));

    public static final RegistryReference<BiomeType> DESERT_LAKES = BiomeTypes.key(ResourceKey.sponge("desert_lakes"));

    public static final RegistryReference<BiomeType> END_BARRENS = BiomeTypes.key(ResourceKey.sponge("end_barrens"));

    public static final RegistryReference<BiomeType> END_HIGHLANDS = BiomeTypes.key(ResourceKey.sponge("end_highlands"));

    public static final RegistryReference<BiomeType> END_MIDLANDS = BiomeTypes.key(ResourceKey.sponge("end_midlands"));

    public static final RegistryReference<BiomeType> ERODED_BADLANDS = BiomeTypes.key(ResourceKey.sponge("eroded_badlands"));

    public static final RegistryReference<BiomeType> FLOWER_FOREST = BiomeTypes.key(ResourceKey.sponge("flower_forest"));

    public static final RegistryReference<BiomeType> FOREST = BiomeTypes.key(ResourceKey.sponge("forest"));

    public static final RegistryReference<BiomeType> FROZEN_OCEAN = BiomeTypes.key(ResourceKey.sponge("frozen_ocean"));

    public static final RegistryReference<BiomeType> FROZEN_RIVER = BiomeTypes.key(ResourceKey.sponge("frozen_river"));

    public static final RegistryReference<BiomeType> GIANT_SPRUCE_TAIGA = BiomeTypes.key(ResourceKey.sponge("giant_spruce_taiga"));

    public static final RegistryReference<BiomeType> GIANT_SPRUCE_TAIGA_HILLS = BiomeTypes.key(ResourceKey.sponge("giant_spruce_taiga_hills"));

    public static final RegistryReference<BiomeType> GIANT_TREE_TAIGA = BiomeTypes.key(ResourceKey.sponge("giant_tree_taiga"));

    public static final RegistryReference<BiomeType> GIANT_TREE_TAIGA_HILLS = BiomeTypes.key(ResourceKey.sponge("giant_tree_taiga_hills"));

    public static final RegistryReference<BiomeType> GRAVELLY_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("gravelly_mountains"));

    public static final RegistryReference<BiomeType> ICE_SPIKES = BiomeTypes.key(ResourceKey.sponge("ice_spikes"));

    public static final RegistryReference<BiomeType> JUNGLE = BiomeTypes.key(ResourceKey.sponge("jungle"));

    public static final RegistryReference<BiomeType> JUNGLE_EDGE = BiomeTypes.key(ResourceKey.sponge("jungle_edge"));

    public static final RegistryReference<BiomeType> JUNGLE_HILLS = BiomeTypes.key(ResourceKey.sponge("jungle_hills"));

    public static final RegistryReference<BiomeType> LUKEWARM_OCEAN = BiomeTypes.key(ResourceKey.sponge("lukewarm_ocean"));

    public static final RegistryReference<BiomeType> MODIFIED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.sponge("modified_badlands_plateau"));

    public static final RegistryReference<BiomeType> MODIFIED_GRAVELLY_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("modified_gravelly_mountains"));

    public static final RegistryReference<BiomeType> MODIFIED_JUNGLE = BiomeTypes.key(ResourceKey.sponge("modified_jungle"));

    public static final RegistryReference<BiomeType> MODIFIED_JUNGLE_EDGE = BiomeTypes.key(ResourceKey.sponge("modified_jungle_edge"));

    public static final RegistryReference<BiomeType> MODIFIED_WOODED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.sponge("modified_wooded_badlands_plateau"));

    public static final RegistryReference<BiomeType> MOUNTAIN_EDGE = BiomeTypes.key(ResourceKey.sponge("mountain_edge"));

    public static final RegistryReference<BiomeType> MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("mountains"));

    public static final RegistryReference<BiomeType> MUSHROOM_FIELD_SHORE = BiomeTypes.key(ResourceKey.sponge("mushroom_field_shore"));

    public static final RegistryReference<BiomeType> MUSHROOM_FIELDS = BiomeTypes.key(ResourceKey.sponge("mushroom_fields"));

    public static final RegistryReference<BiomeType> NETHER_WASTES = BiomeTypes.key(ResourceKey.sponge("nether_wastes"));

    public static final RegistryReference<BiomeType> OCEAN = BiomeTypes.key(ResourceKey.sponge("ocean"));

    public static final RegistryReference<BiomeType> PLAINS = BiomeTypes.key(ResourceKey.sponge("plains"));

    public static final RegistryReference<BiomeType> RIVER = BiomeTypes.key(ResourceKey.sponge("river"));

    public static final RegistryReference<BiomeType> SAVANNA = BiomeTypes.key(ResourceKey.sponge("savanna"));

    public static final RegistryReference<BiomeType> SAVANNA_PLATEAU = BiomeTypes.key(ResourceKey.sponge("savanna_plateau"));

    public static final RegistryReference<BiomeType> SHATTERED_SAVANNA = BiomeTypes.key(ResourceKey.sponge("shattered_savanna"));

    public static final RegistryReference<BiomeType> SHATTERED_SAVANNA_PLATEAU = BiomeTypes.key(ResourceKey.sponge("shattered_savanna_plateau"));

    public static final RegistryReference<BiomeType> SMALL_END_ISLANDS = BiomeTypes.key(ResourceKey.sponge("small_end_islands"));

    public static final RegistryReference<BiomeType> SNOWY_BEACH = BiomeTypes.key(ResourceKey.sponge("snowy_beach"));

    public static final RegistryReference<BiomeType> SNOWY_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("snowy_mountains"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA = BiomeTypes.key(ResourceKey.sponge("snowy_taiga"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA_HILLS = BiomeTypes.key(ResourceKey.sponge("snowy_taiga_hills"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("snowy_taiga_mountains"));

    public static final RegistryReference<BiomeType> SNOWY_TUNDRA = BiomeTypes.key(ResourceKey.sponge("snowy_tundra"));

    public static final RegistryReference<BiomeType> SOUL_SAND_VALLEY = BiomeTypes.key(ResourceKey.sponge("soul_sand_valley"));

    public static final RegistryReference<BiomeType> STONE_SHORE = BiomeTypes.key(ResourceKey.sponge("stone_shore"));

    public static final RegistryReference<BiomeType> SUNFLOWER_PLAINS = BiomeTypes.key(ResourceKey.sponge("sunflower_plains"));

    public static final RegistryReference<BiomeType> SWAMP = BiomeTypes.key(ResourceKey.sponge("swamp"));

    public static final RegistryReference<BiomeType> SWAMP_HILLS = BiomeTypes.key(ResourceKey.sponge("swamp_hills"));

    public static final RegistryReference<BiomeType> TAIGA = BiomeTypes.key(ResourceKey.sponge("taiga"));

    public static final RegistryReference<BiomeType> TAIGA_HILLS = BiomeTypes.key(ResourceKey.sponge("taiga_hills"));

    public static final RegistryReference<BiomeType> TAIGA_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("taiga_mountains"));

    public static final RegistryReference<BiomeType> TALL_BIRCH_FOREST = BiomeTypes.key(ResourceKey.sponge("tall_birch_forest"));

    public static final RegistryReference<BiomeType> TALL_BIRCH_HILLS = BiomeTypes.key(ResourceKey.sponge("tall_birch_hills"));

    public static final RegistryReference<BiomeType> THE_END = BiomeTypes.key(ResourceKey.sponge("the_end"));

    public static final RegistryReference<BiomeType> THE_VOID = BiomeTypes.key(ResourceKey.sponge("the_void"));

    public static final RegistryReference<BiomeType> WARM_OCEAN = BiomeTypes.key(ResourceKey.sponge("warm_ocean"));

    public static final RegistryReference<BiomeType> WARPED_FOREST = BiomeTypes.key(ResourceKey.sponge("warped_forest"));

    public static final RegistryReference<BiomeType> WOODED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.sponge("wooded_badlands_plateau"));

    public static final RegistryReference<BiomeType> WOODED_HILLS = BiomeTypes.key(ResourceKey.sponge("wooded_hills"));

    public static final RegistryReference<BiomeType> WOODED_MOUNTAINS = BiomeTypes.key(ResourceKey.sponge("wooded_mountains"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BiomeTypes() {
    }

    private static RegistryReference<BiomeType> key(final ResourceKey location) {
        return RegistryKey.<BiomeType>of(Registries.BIOME_TYPE.registry(), location).asReference();
    }
}
