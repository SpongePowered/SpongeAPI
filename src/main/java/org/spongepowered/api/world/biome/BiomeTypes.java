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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all possible {@link BiomeType}s available in vanilla
 * minecraft.
 */
public final class BiomeTypes {

    // SORTFIELDS:ON

    public static final Supplier<BiomeType> BADLANDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "badlands");

    public static final Supplier<BiomeType> BADLANDS_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "badlands_plateau");

    public static final Supplier<BiomeType> BAMBOO_JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "bamboo_jungle");

    public static final Supplier<BiomeType> BAMBOO_JUNGLE_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "bamboo_jungle_hills");

    public static final Supplier<BiomeType> BASALT_DELTAS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "basalt_deltas");

    public static final Supplier<BiomeType> BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "beach");

    public static final Supplier<BiomeType> BIRCH_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest");

    public static final Supplier<BiomeType> BIRCH_FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest_hills");

    public static final Supplier<BiomeType> COLD_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "cold_ocean");

    public static final Supplier<BiomeType> CRIMSON_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "crimson_forest");

    public static final Supplier<BiomeType> DARK_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "dark_forest");

    public static final Supplier<BiomeType> DARK_FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "dark_forest_hills");

    public static final Supplier<BiomeType> DEEP_COLD_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_cold_ocean");

    public static final Supplier<BiomeType> DEEP_FROZEN_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_frozen_ocean");

    public static final Supplier<BiomeType> DEEP_LUKEWARM_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_lukewarm_ocean");

    public static final Supplier<BiomeType> DEEP_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_ocean");

    public static final Supplier<BiomeType> DEEP_WARM_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_warm_ocean");

    public static final Supplier<BiomeType> DESERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert");

    public static final Supplier<BiomeType> DESERT_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert_hills");

    public static final Supplier<BiomeType> DESERT_LAKES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert_lakes");

    public static final Supplier<BiomeType> END_BARRENS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "end_barrens");

    public static final Supplier<BiomeType> END_HIGHLANDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "end_highlands");

    public static final Supplier<BiomeType> END_MIDLANDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "end_midlands");

    public static final Supplier<BiomeType> ERODED_BADLANDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "eroded_badlands");

    public static final Supplier<BiomeType> FLOWER_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "flower_forest");

    public static final Supplier<BiomeType> FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "forest");

    public static final Supplier<BiomeType> FROZEN_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "frozen_ocean");

    public static final Supplier<BiomeType> FROZEN_RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "frozen_river");

    public static final Supplier<BiomeType> GIANT_SPRUCE_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "giant_spruce_taiga");

    public static final Supplier<BiomeType> GIANT_SPRUCE_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "giant_spruce_taiga_hills");

    public static final Supplier<BiomeType> GIANT_TREE_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "giant_tree_taiga");

    public static final Supplier<BiomeType> GIANT_TREE_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "giant_tree_taiga_hills");

    public static final Supplier<BiomeType> GRAVELLY_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "gravelly_mountains");

    public static final Supplier<BiomeType> ICE_SPIKES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ice_spikes");

    public static final Supplier<BiomeType> JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle");

    public static final Supplier<BiomeType> JUNGLE_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_edge");

    public static final Supplier<BiomeType> JUNGLE_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_hills");

    public static final Supplier<BiomeType> LUKEWARM_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "lukewarm_ocean");

    public static final Supplier<BiomeType> MODIFIED_BADLANDS_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "modified_badlands_plateau");

    public static final Supplier<BiomeType> MODIFIED_GRAVELLY_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "modified_gravelly_mountains");

    public static final Supplier<BiomeType> MODIFIED_JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "modified_jungle");

    public static final Supplier<BiomeType> MODIFIED_JUNGLE_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "modified_jungle_edge");

    public static final Supplier<BiomeType> MODIFIED_WOODED_BADLANDS_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "modified_wooded_badlands_plateau");

    public static final Supplier<BiomeType> MOUNTAIN_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mountain_edge");

    public static final Supplier<BiomeType> MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mountains");

    public static final Supplier<BiomeType> MUSHROOM_FIELD_SHORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mushroom_field_shore");

    public static final Supplier<BiomeType> MUSHROOM_FIELDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mushroom_fields");

    public static final Supplier<BiomeType> NETHER_WASTES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "nether_wastes");

    public static final Supplier<BiomeType> OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ocean");

    public static final Supplier<BiomeType> PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "plains");

    public static final Supplier<BiomeType> RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "river");

    public static final Supplier<BiomeType> SAVANNA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna");

    public static final Supplier<BiomeType> SAVANNA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna_plateau");

    public static final Supplier<BiomeType> SHATTERED_SAVANNA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "shattered_savanna");

    public static final Supplier<BiomeType> SHATTERED_SAVANNA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "shattered_savanna_plateau");

    public static final Supplier<BiomeType> SMALL_END_ISLANDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "small_end_islands");

    public static final Supplier<BiomeType> SNOWY_BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_beach");

    public static final Supplier<BiomeType> SNOWY_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_mountains");

    public static final Supplier<BiomeType> SNOWY_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_taiga");

    public static final Supplier<BiomeType> SNOWY_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_taiga_hills");

    public static final Supplier<BiomeType> SNOWY_TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_taiga_mountains");

    public static final Supplier<BiomeType> SNOWY_TUNDRA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "snowy_tundra");

    public static final Supplier<BiomeType> SOUL_SAND_VALLEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "soul_sand_valley");

    public static final Supplier<BiomeType> STONE_SHORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "stone_shore");

    public static final Supplier<BiomeType> SUNFLOWER_PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "sunflower_plains");

    public static final Supplier<BiomeType> SWAMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "swamp");

    public static final Supplier<BiomeType> SWAMP_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "swamp_hills");

    public static final Supplier<BiomeType> TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga");

    public static final Supplier<BiomeType> TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga_hills");

    public static final Supplier<BiomeType> TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga_mountains");

    public static final Supplier<BiomeType> TALL_BIRCH_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "tall_birch_forest");

    public static final Supplier<BiomeType> TALL_BIRCH_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "tall_birch_hills");

    public static final Supplier<BiomeType> THE_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "the_end");

    public static final Supplier<BiomeType> THE_VOID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "the_void");

    public static final Supplier<BiomeType> WARM_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "warm_ocean");

    public static final Supplier<BiomeType> WARPED_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "warped_forest");

    public static final Supplier<BiomeType> WOODED_BADLANDS_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "wooded_badlands_plateau");

    public static final Supplier<BiomeType> WOODED_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "wooded_hills");

    public static final Supplier<BiomeType> WOODED_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "wooded_mountains");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BiomeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
