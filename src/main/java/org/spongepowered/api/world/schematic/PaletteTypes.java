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
package org.spongepowered.api.world.schematic;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.biome.BiomeType;

import java.util.function.Supplier;

public final class PaletteTypes {

    // SORTFIELDS:ON
    /**
     * A type of {@link Palette} that refers to a simplified "global"
     * {@link BiomeType} palette referring to each biome individually.
     * <p>Note that while {@link PaletteType#create()} may allow a
     * {@link Palette.Mutable mutable palette} to be created, all
     * registered {@link BiomeType biomes} will have an assigned
     * {@code integer id}.
     */
    public static Supplier<PaletteType<BiomeType>> GLOBAL_BIOME_PALETTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PaletteType.class, "global_biome_palette");

    /**
     * A type of {@link Palette} that refers to a simplified "global"
     * {@link BlockState} palette referring to each state individually.
     * <p>Note that while {@link PaletteType#create()} may allow a
     * {@link Palette.Mutable mutable palette} to be created, all
     * registered {@link BlockState block states} will have an assigned
     * {@code integer id}.
     */
    public static Supplier<PaletteType<BlockState>> GLOBAL_BLOCK_PALETTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PaletteType.class, "global_block_palette");

    /**
     * A type of {@link PaletteType} that refers to a localized mapping of
     * {@link BiomeType biomes} for individualized usage. Traditionally the
     * palette will generate {@code integer ids} in the order in which a
     * {@link BiomeType biome} is registered via {@link Palette.Mutable#getOrAssign(Object)}
     */
    public static Supplier<PaletteType<BiomeType>> BIOME_PALETTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PaletteType.class, "biome_palette");

    /**
     * A type of {@link PaletteType} that refers to a localized mapping of
     * {@link BlockState block states} for individualized usage. Traditionally the
     * palette will generate {@code integer ids} in the order in which a
     * {@link BlockState biome} is registered via {@link Palette.Mutable#getOrAssign(Object)}
     */
    public static Supplier<PaletteType<BlockState>> BLOCK_STATE_PALETTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PaletteType.class, "block_state_palette");
    // SORTFIELDS:OFF

    private PaletteTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
