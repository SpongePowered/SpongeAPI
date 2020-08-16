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

    // Standard Biomes

    // SORTFIELDS:ON

    public static final Supplier<BiomeType> BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "beach");

    public static final Supplier<BiomeType> BIRCH_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest");

    public static final Supplier<BiomeType> BIRCH_FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest_hills");

    public static final Supplier<BiomeType> COLD_BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "cold_beach");

    public static final Supplier<BiomeType> COLD_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "cold_taiga");

    public static final Supplier<BiomeType> COLD_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "cold_taiga_hills");

    public static final Supplier<BiomeType> DEEP_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "deep_ocean");

    public static final Supplier<BiomeType> DESERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert");

    public static final Supplier<BiomeType> DESERT_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert_hills");

    public static final Supplier<BiomeType> EXTREME_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "extreme_hills");

    public static final Supplier<BiomeType> EXTREME_HILLS_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "extreme_hills_edge");

    public static final Supplier<BiomeType> EXTREME_HILLS_PLUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "extreme_hills_plus");

    public static final Supplier<BiomeType> FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "forest");

    public static final Supplier<BiomeType> FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "forest_hills");

    public static final Supplier<BiomeType> FROZEN_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "frozen_ocean");

    public static final Supplier<BiomeType> FROZEN_RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "frozen_river");

    public static final Supplier<BiomeType> HELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "hell");

    public static final Supplier<BiomeType> ICE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ice_mountains");

    public static final Supplier<BiomeType> ICE_PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ice_plains");

    public static final Supplier<BiomeType> JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle");

    public static final Supplier<BiomeType> JUNGLE_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_edge");

    public static final Supplier<BiomeType> JUNGLE_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_hills");

    public static final Supplier<BiomeType> MEGA_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mega_taiga");

    public static final Supplier<BiomeType> MEGA_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mega_taiga_hills");

    public static final Supplier<BiomeType> MESA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa");

    public static final Supplier<BiomeType> MESA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa_plateau");

    public static final Supplier<BiomeType> MESA_PLATEAU_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa_plateau_forest");

    public static final Supplier<BiomeType> MUSHROOM_ISLAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mushroom_island");

    public static final Supplier<BiomeType> MUSHROOM_ISLAND_SHORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mushroom_island_shore");

    public static final Supplier<BiomeType> OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ocean");

    public static final Supplier<BiomeType> PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "plains");

    public static final Supplier<BiomeType> RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "river");

    public static final Supplier<BiomeType> ROOFED_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "roofed_forest");

    public static final Supplier<BiomeType> SAVANNA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna");

    public static final Supplier<BiomeType> SAVANNA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna_plateau");

    public static final Supplier<BiomeType> SKY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "sky");

    public static final Supplier<BiomeType> STONE_BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "stone_beach");

    public static final Supplier<BiomeType> SWAMPLAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "swampland");

    public static final Supplier<BiomeType> TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga");

    public static final Supplier<BiomeType> TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga_hills");

    // SORTFIELDS:OFF

    // Mutated Biomes
    // SORTFIELDS:ON

    public static final Supplier<BiomeType> BIRCH_FOREST_HILLS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest_hills_mountains");

    public static final Supplier<BiomeType> BIRCH_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "birch_forest_mountains");

    public static final Supplier<BiomeType> COLD_TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "cold_taiga_mountains");

    public static final Supplier<BiomeType> DESERT_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "desert_mountains");

    public static final Supplier<BiomeType> EXTREME_HILLS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "extreme_hills_mountains");

    public static final Supplier<BiomeType> EXTREME_HILLS_PLUS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "extreme_hills_plus_mountains");

    public static final Supplier<BiomeType> FLOWER_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "flower_forest");

    public static final Supplier<BiomeType> ICE_PLAINS_SPIKES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ice_plains_spikes");

    public static final Supplier<BiomeType> JUNGLE_EDGE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_edge_mountains");

    public static final Supplier<BiomeType> JUNGLE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "jungle_mountains");

    public static final Supplier<BiomeType> MEGA_SPRUCE_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mega_spruce_taiga");

    public static final Supplier<BiomeType> MEGA_SPRUCE_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mega_spruce_taiga_hills");

    public static final Supplier<BiomeType> MESA_BRYCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa_bryce");

    public static final Supplier<BiomeType> MESA_PLATEAU_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa_plateau_forest_mountains");

    public static final Supplier<BiomeType> MESA_PLATEAU_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "mesa_plateau_mountains");

    public static final Supplier<BiomeType> ROOFED_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "roofed_forest_mountains");

    public static final Supplier<BiomeType> SAVANNA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna_mountains");

    public static final Supplier<BiomeType> SAVANNA_PLATEAU_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "savanna_plateau_mountains");

    public static final Supplier<BiomeType> SUNFLOWER_PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "sunflower_plains");

    public static final Supplier<BiomeType> SWAMPLAND_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "swampland_mountains");

    public static final Supplier<BiomeType> TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "taiga_mountains");

    public static final Supplier<BiomeType> VOID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "void");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BiomeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
