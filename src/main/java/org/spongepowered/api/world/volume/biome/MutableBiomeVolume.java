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
package org.spongepowered.api.world.volume.biome;

import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.math.vector.Vector3i;

public interface MutableBiomeVolume<M extends MutableBiomeVolume<M>> extends StreamableBiomeVolume<M>, MutableVolume {

    /**
     * Sets the {@link BiomeType} at the given position in this volume.
     *
     * @param position The position
     * @param biome The biome type
     * @return Whether the biome change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *                                      bounds of the volume
     */
    default boolean setBiome(Vector3i position, BiomeType biome) {
        return setBiome(position.getX(), position.getY(), position.getZ(), biome);
    }

    /**
     * Sets the {@link BiomeType} at the given position in this volume.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param biome The biome type
     * @return Whether the biome change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *                                      bounds of the volume
     */
    boolean setBiome(int x, int y, int z, BiomeType biome);

}
