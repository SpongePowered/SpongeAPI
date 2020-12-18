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
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link BiomeType}s available in vanilla
 * minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.WORLD)
public final class BiomeTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final RegistryReference<BiomeType> BADLANDS = BiomeTypes.key(ResourceKey.minecraft("badlands"));

    public static final RegistryReference<BiomeType> BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("badlands_plateau"));

    public static final RegistryReference<BiomeType> BAMBOO_JUNGLE = BiomeTypes.key(ResourceKey.minecraft("bamboo_jungle"));

    public static final RegistryReference<BiomeType> BAMBOO_JUNGLE_HILLS = BiomeTypes.key(ResourceKey.minecraft("bamboo_jungle_hills"));

    public static final RegistryReference<BiomeType> BASALT_DELTAS = BiomeTypes.key(ResourceKey.minecraft("basalt_deltas"));

    public static final RegistryReference<BiomeType> BEACH = BiomeTypes.key(ResourceKey.minecraft("beach"));

    public static final RegistryReference<BiomeType> BIRCH_FOREST = BiomeTypes.key(ResourceKey.minecraft("birch_forest"));

    public static final RegistryReference<BiomeType> BIRCH_FOREST_HILLS = BiomeTypes.key(ResourceKey.minecraft("birch_forest_hills"));

    public static final RegistryReference<BiomeType> COLD_OCEAN = BiomeTypes.key(ResourceKey.minecraft("cold_ocean"));

    public static final RegistryReference<BiomeType> CRIMSON_FOREST = BiomeTypes.key(ResourceKey.minecraft("crimson_forest"));

    public static final RegistryReference<BiomeType> DARK_FOREST = BiomeTypes.key(ResourceKey.minecraft("dark_forest"));

    public static final RegistryReference<BiomeType> DARK_FOREST_HILLS = BiomeTypes.key(ResourceKey.minecraft("dark_forest_hills"));

    public static final RegistryReference<BiomeType> DEEP_COLD_OCEAN = BiomeTypes.key(ResourceKey.minecraft("deep_cold_ocean"));

    public static final RegistryReference<BiomeType> DEEP_FROZEN_OCEAN = BiomeTypes.key(ResourceKey.minecraft("deep_frozen_ocean"));

    public static final RegistryReference<BiomeType> DEEP_LUKEWARM_OCEAN = BiomeTypes.key(ResourceKey.minecraft("deep_lukewarm_ocean"));

    public static final RegistryReference<BiomeType> DEEP_OCEAN = BiomeTypes.key(ResourceKey.minecraft("deep_ocean"));

    public static final RegistryReference<BiomeType> DEEP_WARM_OCEAN = BiomeTypes.key(ResourceKey.minecraft("deep_warm_ocean"));

    public static final RegistryReference<BiomeType> DESERT = BiomeTypes.key(ResourceKey.minecraft("desert"));

    public static final RegistryReference<BiomeType> DESERT_HILLS = BiomeTypes.key(ResourceKey.minecraft("desert_hills"));

    public static final RegistryReference<BiomeType> DESERT_LAKES = BiomeTypes.key(ResourceKey.minecraft("desert_lakes"));

    public static final RegistryReference<BiomeType> END_BARRENS = BiomeTypes.key(ResourceKey.minecraft("end_barrens"));

    public static final RegistryReference<BiomeType> END_HIGHLANDS = BiomeTypes.key(ResourceKey.minecraft("end_highlands"));

    public static final RegistryReference<BiomeType> END_MIDLANDS = BiomeTypes.key(ResourceKey.minecraft("end_midlands"));

    public static final RegistryReference<BiomeType> ERODED_BADLANDS = BiomeTypes.key(ResourceKey.minecraft("eroded_badlands"));

    public static final RegistryReference<BiomeType> FLOWER_FOREST = BiomeTypes.key(ResourceKey.minecraft("flower_forest"));

    public static final RegistryReference<BiomeType> FOREST = BiomeTypes.key(ResourceKey.minecraft("forest"));

    public static final RegistryReference<BiomeType> FROZEN_OCEAN = BiomeTypes.key(ResourceKey.minecraft("frozen_ocean"));

    public static final RegistryReference<BiomeType> FROZEN_RIVER = BiomeTypes.key(ResourceKey.minecraft("frozen_river"));

    public static final RegistryReference<BiomeType> GIANT_SPRUCE_TAIGA = BiomeTypes.key(ResourceKey.minecraft("giant_spruce_taiga"));

    public static final RegistryReference<BiomeType> GIANT_SPRUCE_TAIGA_HILLS = BiomeTypes.key(ResourceKey.minecraft("giant_spruce_taiga_hills"));

    public static final RegistryReference<BiomeType> GIANT_TREE_TAIGA = BiomeTypes.key(ResourceKey.minecraft("giant_tree_taiga"));

    public static final RegistryReference<BiomeType> GIANT_TREE_TAIGA_HILLS = BiomeTypes.key(ResourceKey.minecraft("giant_tree_taiga_hills"));

    public static final RegistryReference<BiomeType> GRAVELLY_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("gravelly_mountains"));

    public static final RegistryReference<BiomeType> ICE_SPIKES = BiomeTypes.key(ResourceKey.minecraft("ice_spikes"));

    public static final RegistryReference<BiomeType> JUNGLE = BiomeTypes.key(ResourceKey.minecraft("jungle"));

    public static final RegistryReference<BiomeType> JUNGLE_EDGE = BiomeTypes.key(ResourceKey.minecraft("jungle_edge"));

    public static final RegistryReference<BiomeType> JUNGLE_HILLS = BiomeTypes.key(ResourceKey.minecraft("jungle_hills"));

    public static final RegistryReference<BiomeType> LUKEWARM_OCEAN = BiomeTypes.key(ResourceKey.minecraft("lukewarm_ocean"));

    public static final RegistryReference<BiomeType> MODIFIED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("modified_badlands_plateau"));

    public static final RegistryReference<BiomeType> MODIFIED_GRAVELLY_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("modified_gravelly_mountains"));

    public static final RegistryReference<BiomeType> MODIFIED_JUNGLE = BiomeTypes.key(ResourceKey.minecraft("modified_jungle"));

    public static final RegistryReference<BiomeType> MODIFIED_JUNGLE_EDGE = BiomeTypes.key(ResourceKey.minecraft("modified_jungle_edge"));

    public static final RegistryReference<BiomeType> MODIFIED_WOODED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("modified_wooded_badlands_plateau"));

    public static final RegistryReference<BiomeType> MOUNTAIN_EDGE = BiomeTypes.key(ResourceKey.minecraft("mountain_edge"));

    public static final RegistryReference<BiomeType> MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("mountains"));

    public static final RegistryReference<BiomeType> MUSHROOM_FIELD_SHORE = BiomeTypes.key(ResourceKey.minecraft("mushroom_field_shore"));

    public static final RegistryReference<BiomeType> MUSHROOM_FIELDS = BiomeTypes.key(ResourceKey.minecraft("mushroom_fields"));

    public static final RegistryReference<BiomeType> NETHER_WASTES = BiomeTypes.key(ResourceKey.minecraft("nether_wastes"));

    public static final RegistryReference<BiomeType> OCEAN = BiomeTypes.key(ResourceKey.minecraft("ocean"));

    public static final RegistryReference<BiomeType> PLAINS = BiomeTypes.key(ResourceKey.minecraft("plains"));

    public static final RegistryReference<BiomeType> RIVER = BiomeTypes.key(ResourceKey.minecraft("river"));

    public static final RegistryReference<BiomeType> SAVANNA = BiomeTypes.key(ResourceKey.minecraft("savanna"));

    public static final RegistryReference<BiomeType> SAVANNA_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("savanna_plateau"));

    public static final RegistryReference<BiomeType> SHATTERED_SAVANNA = BiomeTypes.key(ResourceKey.minecraft("shattered_savanna"));

    public static final RegistryReference<BiomeType> SHATTERED_SAVANNA_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("shattered_savanna_plateau"));

    public static final RegistryReference<BiomeType> SMALL_END_ISLANDS = BiomeTypes.key(ResourceKey.minecraft("small_end_islands"));

    public static final RegistryReference<BiomeType> SNOWY_BEACH = BiomeTypes.key(ResourceKey.minecraft("snowy_beach"));

    public static final RegistryReference<BiomeType> SNOWY_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("snowy_mountains"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA = BiomeTypes.key(ResourceKey.minecraft("snowy_taiga"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA_HILLS = BiomeTypes.key(ResourceKey.minecraft("snowy_taiga_hills"));

    public static final RegistryReference<BiomeType> SNOWY_TAIGA_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("snowy_taiga_mountains"));

    public static final RegistryReference<BiomeType> SNOWY_TUNDRA = BiomeTypes.key(ResourceKey.minecraft("snowy_tundra"));

    public static final RegistryReference<BiomeType> SOUL_SAND_VALLEY = BiomeTypes.key(ResourceKey.minecraft("soul_sand_valley"));

    public static final RegistryReference<BiomeType> STONE_SHORE = BiomeTypes.key(ResourceKey.minecraft("stone_shore"));

    public static final RegistryReference<BiomeType> SUNFLOWER_PLAINS = BiomeTypes.key(ResourceKey.minecraft("sunflower_plains"));

    public static final RegistryReference<BiomeType> SWAMP = BiomeTypes.key(ResourceKey.minecraft("swamp"));

    public static final RegistryReference<BiomeType> SWAMP_HILLS = BiomeTypes.key(ResourceKey.minecraft("swamp_hills"));

    public static final RegistryReference<BiomeType> TAIGA = BiomeTypes.key(ResourceKey.minecraft("taiga"));

    public static final RegistryReference<BiomeType> TAIGA_HILLS = BiomeTypes.key(ResourceKey.minecraft("taiga_hills"));

    public static final RegistryReference<BiomeType> TAIGA_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("taiga_mountains"));

    public static final RegistryReference<BiomeType> TALL_BIRCH_FOREST = BiomeTypes.key(ResourceKey.minecraft("tall_birch_forest"));

    public static final RegistryReference<BiomeType> TALL_BIRCH_HILLS = BiomeTypes.key(ResourceKey.minecraft("tall_birch_hills"));

    public static final RegistryReference<BiomeType> THE_END = BiomeTypes.key(ResourceKey.minecraft("the_end"));

    public static final RegistryReference<BiomeType> THE_VOID = BiomeTypes.key(ResourceKey.minecraft("the_void"));

    public static final RegistryReference<BiomeType> WARM_OCEAN = BiomeTypes.key(ResourceKey.minecraft("warm_ocean"));

    public static final RegistryReference<BiomeType> WARPED_FOREST = BiomeTypes.key(ResourceKey.minecraft("warped_forest"));

    public static final RegistryReference<BiomeType> WOODED_BADLANDS_PLATEAU = BiomeTypes.key(ResourceKey.minecraft("wooded_badlands_plateau"));

    public static final RegistryReference<BiomeType> WOODED_HILLS = BiomeTypes.key(ResourceKey.minecraft("wooded_hills"));

    public static final RegistryReference<BiomeType> WOODED_MOUNTAINS = BiomeTypes.key(ResourceKey.minecraft("wooded_mountains"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BiomeTypes() {
    }

    private static RegistryReference<BiomeType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.BIOME_TYPE, location).asReference();
    }
}
