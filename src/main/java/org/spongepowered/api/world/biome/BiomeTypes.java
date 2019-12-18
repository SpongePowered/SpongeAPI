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

    public static final Supplier<BiomeType> BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "BEACH");

    public static final Supplier<BiomeType> BIRCH_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "BIRCH_FOREST");

    public static final Supplier<BiomeType> BIRCH_FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "BIRCH_FOREST_HILLS");

    public static final Supplier<BiomeType> COLD_BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "COLD_BEACH");

    public static final Supplier<BiomeType> COLD_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "COLD_TAIGA");

    public static final Supplier<BiomeType> COLD_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "COLD_TAIGA_HILLS");

    public static final Supplier<BiomeType> DEEP_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "DEEP_OCEAN");

    public static final Supplier<BiomeType> DESERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "DESERT");

    public static final Supplier<BiomeType> DESERT_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "DESERT_HILLS");

    public static final Supplier<BiomeType> EXTREME_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "EXTREME_HILLS");

    public static final Supplier<BiomeType> EXTREME_HILLS_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "EXTREME_HILLS_EDGE");

    public static final Supplier<BiomeType> EXTREME_HILLS_PLUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "EXTREME_HILLS_PLUS");

    public static final Supplier<BiomeType> FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "FOREST");

    public static final Supplier<BiomeType> FOREST_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "FOREST_HILLS");

    public static final Supplier<BiomeType> FROZEN_OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "FROZEN_OCEAN");

    public static final Supplier<BiomeType> FROZEN_RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "FROZEN_RIVER");

    public static final Supplier<BiomeType> HELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "HELL");

    public static final Supplier<BiomeType> ICE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ICE_MOUNTAINS");

    public static final Supplier<BiomeType> ICE_PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ICE_PLAINS");

    public static final Supplier<BiomeType> JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "JUNGLE");

    public static final Supplier<BiomeType> JUNGLE_EDGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "JUNGLE_EDGE");

    public static final Supplier<BiomeType> JUNGLE_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "JUNGLE_HILLS");

    public static final Supplier<BiomeType> MEGA_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MEGA_TAIGA");

    public static final Supplier<BiomeType> MEGA_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MEGA_TAIGA_HILLS");

    public static final Supplier<BiomeType> MESA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA");

    public static final Supplier<BiomeType> MESA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA_PLATEAU");

    public static final Supplier<BiomeType> MESA_PLATEAU_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA_PLATEAU_FOREST");

    public static final Supplier<BiomeType> MUSHROOM_ISLAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MUSHROOM_ISLAND");

    public static final Supplier<BiomeType> MUSHROOM_ISLAND_SHORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MUSHROOM_ISLAND_SHORE");

    public static final Supplier<BiomeType> OCEAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "OCEAN");

    public static final Supplier<BiomeType> PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "PLAINS");

    public static final Supplier<BiomeType> RIVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "RIVER");

    public static final Supplier<BiomeType> ROOFED_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ROOFED_FOREST");

    public static final Supplier<BiomeType> SAVANNA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SAVANNA");

    public static final Supplier<BiomeType> SAVANNA_PLATEAU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SAVANNA_PLATEAU");

    public static final Supplier<BiomeType> SKY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SKY");

    public static final Supplier<BiomeType> STONE_BEACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "STONE_BEACH");

    public static final Supplier<BiomeType> SWAMPLAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SWAMPLAND");

    public static final Supplier<BiomeType> TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "TAIGA");

    public static final Supplier<BiomeType> TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "TAIGA_HILLS");

    // SORTFIELDS:OFF

    // Mutated Biomes
    // SORTFIELDS:ON

    public static final Supplier<BiomeType> BIRCH_FOREST_HILLS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "BIRCH_FOREST_HILLS_MOUNTAINS");

    public static final Supplier<BiomeType> BIRCH_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "BIRCH_FOREST_MOUNTAINS");

    public static final Supplier<BiomeType> COLD_TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "COLD_TAIGA_MOUNTAINS");

    public static final Supplier<BiomeType> DESERT_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "DESERT_MOUNTAINS");

    public static final Supplier<BiomeType> EXTREME_HILLS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "EXTREME_HILLS_MOUNTAINS");

    public static final Supplier<BiomeType> EXTREME_HILLS_PLUS_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "EXTREME_HILLS_PLUS_MOUNTAINS");

    public static final Supplier<BiomeType> FLOWER_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "FLOWER_FOREST");

    public static final Supplier<BiomeType> ICE_PLAINS_SPIKES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ICE_PLAINS_SPIKES");

    public static final Supplier<BiomeType> JUNGLE_EDGE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "JUNGLE_EDGE_MOUNTAINS");

    public static final Supplier<BiomeType> JUNGLE_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "JUNGLE_MOUNTAINS");

    public static final Supplier<BiomeType> MEGA_SPRUCE_TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MEGA_SPRUCE_TAIGA");

    public static final Supplier<BiomeType> MEGA_SPRUCE_TAIGA_HILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MEGA_SPRUCE_TAIGA_HILLS");

    public static final Supplier<BiomeType> MESA_BRYCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA_BRYCE");

    public static final Supplier<BiomeType> MESA_PLATEAU_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA_PLATEAU_FOREST_MOUNTAINS");

    public static final Supplier<BiomeType> MESA_PLATEAU_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "MESA_PLATEAU_MOUNTAINS");

    public static final Supplier<BiomeType> ROOFED_FOREST_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "ROOFED_FOREST_MOUNTAINS");

    public static final Supplier<BiomeType> SAVANNA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SAVANNA_MOUNTAINS");

    public static final Supplier<BiomeType> SAVANNA_PLATEAU_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SAVANNA_PLATEAU_MOUNTAINS");

    public static final Supplier<BiomeType> SUNFLOWER_PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SUNFLOWER_PLAINS");

    public static final Supplier<BiomeType> SWAMPLAND_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "SWAMPLAND_MOUNTAINS");

    public static final Supplier<BiomeType> TAIGA_MOUNTAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "TAIGA_MOUNTAINS");

    public static final Supplier<BiomeType> VOID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BiomeType.class, "VOID");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BiomeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
