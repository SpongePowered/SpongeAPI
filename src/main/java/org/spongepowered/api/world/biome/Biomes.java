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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.WORLD)
public final class Biomes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final RegistryReference<Biome> BADLANDS = Biomes.key(ResourceKey.minecraft("badlands"));

    public static final RegistryReference<Biome> BADLANDS_PLATEAU = Biomes.key(ResourceKey.minecraft("badlands_plateau"));

    public static final RegistryReference<Biome> BAMBOO_JUNGLE = Biomes.key(ResourceKey.minecraft("bamboo_jungle"));

    public static final RegistryReference<Biome> BAMBOO_JUNGLE_HILLS = Biomes.key(ResourceKey.minecraft("bamboo_jungle_hills"));

    public static final RegistryReference<Biome> BASALT_DELTAS = Biomes.key(ResourceKey.minecraft("basalt_deltas"));

    public static final RegistryReference<Biome> BEACH = Biomes.key(ResourceKey.minecraft("beach"));

    public static final RegistryReference<Biome> BIRCH_FOREST = Biomes.key(ResourceKey.minecraft("birch_forest"));

    public static final RegistryReference<Biome> BIRCH_FOREST_HILLS = Biomes.key(ResourceKey.minecraft("birch_forest_hills"));

    public static final RegistryReference<Biome> COLD_OCEAN = Biomes.key(ResourceKey.minecraft("cold_ocean"));

    public static final RegistryReference<Biome> CRIMSON_FOREST = Biomes.key(ResourceKey.minecraft("crimson_forest"));

    public static final RegistryReference<Biome> DARK_FOREST = Biomes.key(ResourceKey.minecraft("dark_forest"));

    public static final RegistryReference<Biome> DARK_FOREST_HILLS = Biomes.key(ResourceKey.minecraft("dark_forest_hills"));

    public static final RegistryReference<Biome> DEEP_COLD_OCEAN = Biomes.key(ResourceKey.minecraft("deep_cold_ocean"));

    public static final RegistryReference<Biome> DEEP_FROZEN_OCEAN = Biomes.key(ResourceKey.minecraft("deep_frozen_ocean"));

    public static final RegistryReference<Biome> DEEP_LUKEWARM_OCEAN = Biomes.key(ResourceKey.minecraft("deep_lukewarm_ocean"));

    public static final RegistryReference<Biome> DEEP_OCEAN = Biomes.key(ResourceKey.minecraft("deep_ocean"));

    public static final RegistryReference<Biome> DEEP_WARM_OCEAN = Biomes.key(ResourceKey.minecraft("deep_warm_ocean"));

    public static final RegistryReference<Biome> DESERT = Biomes.key(ResourceKey.minecraft("desert"));

    public static final RegistryReference<Biome> DESERT_HILLS = Biomes.key(ResourceKey.minecraft("desert_hills"));

    public static final RegistryReference<Biome> DESERT_LAKES = Biomes.key(ResourceKey.minecraft("desert_lakes"));

    public static final RegistryReference<Biome> END_BARRENS = Biomes.key(ResourceKey.minecraft("end_barrens"));

    public static final RegistryReference<Biome> END_HIGHLANDS = Biomes.key(ResourceKey.minecraft("end_highlands"));

    public static final RegistryReference<Biome> END_MIDLANDS = Biomes.key(ResourceKey.minecraft("end_midlands"));

    public static final RegistryReference<Biome> ERODED_BADLANDS = Biomes.key(ResourceKey.minecraft("eroded_badlands"));

    public static final RegistryReference<Biome> FLOWER_FOREST = Biomes.key(ResourceKey.minecraft("flower_forest"));

    public static final RegistryReference<Biome> FOREST = Biomes.key(ResourceKey.minecraft("forest"));

    public static final RegistryReference<Biome> FROZEN_OCEAN = Biomes.key(ResourceKey.minecraft("frozen_ocean"));

    public static final RegistryReference<Biome> FROZEN_RIVER = Biomes.key(ResourceKey.minecraft("frozen_river"));

    public static final RegistryReference<Biome> GIANT_SPRUCE_TAIGA = Biomes.key(ResourceKey.minecraft("giant_spruce_taiga"));

    public static final RegistryReference<Biome> GIANT_SPRUCE_TAIGA_HILLS = Biomes.key(ResourceKey.minecraft("giant_spruce_taiga_hills"));

    public static final RegistryReference<Biome> GIANT_TREE_TAIGA = Biomes.key(ResourceKey.minecraft("giant_tree_taiga"));

    public static final RegistryReference<Biome> GIANT_TREE_TAIGA_HILLS = Biomes.key(ResourceKey.minecraft("giant_tree_taiga_hills"));

    public static final RegistryReference<Biome> GRAVELLY_MOUNTAINS = Biomes.key(ResourceKey.minecraft("gravelly_mountains"));

    public static final RegistryReference<Biome> ICE_SPIKES = Biomes.key(ResourceKey.minecraft("ice_spikes"));

    public static final RegistryReference<Biome> JUNGLE = Biomes.key(ResourceKey.minecraft("jungle"));

    public static final RegistryReference<Biome> JUNGLE_EDGE = Biomes.key(ResourceKey.minecraft("jungle_edge"));

    public static final RegistryReference<Biome> JUNGLE_HILLS = Biomes.key(ResourceKey.minecraft("jungle_hills"));

    public static final RegistryReference<Biome> LUKEWARM_OCEAN = Biomes.key(ResourceKey.minecraft("lukewarm_ocean"));

    public static final RegistryReference<Biome> MODIFIED_BADLANDS_PLATEAU = Biomes.key(ResourceKey.minecraft("modified_badlands_plateau"));

    public static final RegistryReference<Biome> MODIFIED_GRAVELLY_MOUNTAINS = Biomes.key(ResourceKey.minecraft("modified_gravelly_mountains"));

    public static final RegistryReference<Biome> MODIFIED_JUNGLE = Biomes.key(ResourceKey.minecraft("modified_jungle"));

    public static final RegistryReference<Biome> MODIFIED_JUNGLE_EDGE = Biomes.key(ResourceKey.minecraft("modified_jungle_edge"));

    public static final RegistryReference<Biome> MODIFIED_WOODED_BADLANDS_PLATEAU = Biomes.key(ResourceKey.minecraft("modified_wooded_badlands_plateau"));

    public static final RegistryReference<Biome> MOUNTAIN_EDGE = Biomes.key(ResourceKey.minecraft("mountain_edge"));

    public static final RegistryReference<Biome> MOUNTAINS = Biomes.key(ResourceKey.minecraft("mountains"));

    public static final RegistryReference<Biome> MUSHROOM_FIELD_SHORE = Biomes.key(ResourceKey.minecraft("mushroom_field_shore"));

    public static final RegistryReference<Biome> MUSHROOM_FIELDS = Biomes.key(ResourceKey.minecraft("mushroom_fields"));

    public static final RegistryReference<Biome> NETHER_WASTES = Biomes.key(ResourceKey.minecraft("nether_wastes"));

    public static final RegistryReference<Biome> OCEAN = Biomes.key(ResourceKey.minecraft("ocean"));

    public static final RegistryReference<Biome> PLAINS = Biomes.key(ResourceKey.minecraft("plains"));

    public static final RegistryReference<Biome> RIVER = Biomes.key(ResourceKey.minecraft("river"));

    public static final RegistryReference<Biome> SAVANNA = Biomes.key(ResourceKey.minecraft("savanna"));

    public static final RegistryReference<Biome> SAVANNA_PLATEAU = Biomes.key(ResourceKey.minecraft("savanna_plateau"));

    public static final RegistryReference<Biome> SHATTERED_SAVANNA = Biomes.key(ResourceKey.minecraft("shattered_savanna"));

    public static final RegistryReference<Biome> SHATTERED_SAVANNA_PLATEAU = Biomes.key(ResourceKey.minecraft("shattered_savanna_plateau"));

    public static final RegistryReference<Biome> SMALL_END_ISLANDS = Biomes.key(ResourceKey.minecraft("small_end_islands"));

    public static final RegistryReference<Biome> SNOWY_BEACH = Biomes.key(ResourceKey.minecraft("snowy_beach"));

    public static final RegistryReference<Biome> SNOWY_MOUNTAINS = Biomes.key(ResourceKey.minecraft("snowy_mountains"));

    public static final RegistryReference<Biome> SNOWY_TAIGA = Biomes.key(ResourceKey.minecraft("snowy_taiga"));

    public static final RegistryReference<Biome> SNOWY_TAIGA_HILLS = Biomes.key(ResourceKey.minecraft("snowy_taiga_hills"));

    public static final RegistryReference<Biome> SNOWY_TAIGA_MOUNTAINS = Biomes.key(ResourceKey.minecraft("snowy_taiga_mountains"));

    public static final RegistryReference<Biome> SNOWY_TUNDRA = Biomes.key(ResourceKey.minecraft("snowy_tundra"));

    public static final RegistryReference<Biome> SOUL_SAND_VALLEY = Biomes.key(ResourceKey.minecraft("soul_sand_valley"));

    public static final RegistryReference<Biome> STONE_SHORE = Biomes.key(ResourceKey.minecraft("stone_shore"));

    public static final RegistryReference<Biome> SUNFLOWER_PLAINS = Biomes.key(ResourceKey.minecraft("sunflower_plains"));

    public static final RegistryReference<Biome> SWAMP = Biomes.key(ResourceKey.minecraft("swamp"));

    public static final RegistryReference<Biome> SWAMP_HILLS = Biomes.key(ResourceKey.minecraft("swamp_hills"));

    public static final RegistryReference<Biome> TAIGA = Biomes.key(ResourceKey.minecraft("taiga"));

    public static final RegistryReference<Biome> TAIGA_HILLS = Biomes.key(ResourceKey.minecraft("taiga_hills"));

    public static final RegistryReference<Biome> TAIGA_MOUNTAINS = Biomes.key(ResourceKey.minecraft("taiga_mountains"));

    public static final RegistryReference<Biome> TALL_BIRCH_FOREST = Biomes.key(ResourceKey.minecraft("tall_birch_forest"));

    public static final RegistryReference<Biome> TALL_BIRCH_HILLS = Biomes.key(ResourceKey.minecraft("tall_birch_hills"));

    public static final RegistryReference<Biome> THE_END = Biomes.key(ResourceKey.minecraft("the_end"));

    public static final RegistryReference<Biome> THE_VOID = Biomes.key(ResourceKey.minecraft("the_void"));

    public static final RegistryReference<Biome> WARM_OCEAN = Biomes.key(ResourceKey.minecraft("warm_ocean"));

    public static final RegistryReference<Biome> WARPED_FOREST = Biomes.key(ResourceKey.minecraft("warped_forest"));

    public static final RegistryReference<Biome> WOODED_BADLANDS_PLATEAU = Biomes.key(ResourceKey.minecraft("wooded_badlands_plateau"));

    public static final RegistryReference<Biome> WOODED_HILLS = Biomes.key(ResourceKey.minecraft("wooded_hills"));

    public static final RegistryReference<Biome> WOODED_MOUNTAINS = Biomes.key(ResourceKey.minecraft("wooded_mountains"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Biomes() {
    }

    private static RegistryReference<Biome> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.BIOME, location).asReference();
    }
}
