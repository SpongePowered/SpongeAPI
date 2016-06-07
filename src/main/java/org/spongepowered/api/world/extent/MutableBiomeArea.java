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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.util.DiscreteTransform2;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.extent.worker.MutableBiomeAreaWorker;

/**
 * An area containing biomes that can be accessed and modified.
 *
 * @see BiomeArea
 */
public interface MutableBiomeArea extends BiomeArea {

    /**
     * Sets the biome at the given position in the world.
     *
     * @param position The position
     * @param biome The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the area
     */
    default void setBiome(Vector2i position, BiomeType biome) {
        setBiome(position.getX(), position.getY(), biome);
    }

    /**
     * Sets the biome at the given position in the world.
     *
     * @param x The X position
     * @param z The Z position
     * @param biome The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the area
     */
    void setBiome(int x, int z, BiomeType biome);

    /**
     * Returns a new area that is the same or smaller than the current area.
     * This does not copy the biomes, it only provides a new view of the
     * storage.
     *
     * @param newMin The new minimum coordinates in this area
     * @param newMax The new maximum coordinates in this area
     * @return The new area with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum are
     *         outside the current area
     */
    @Override
    MutableBiomeArea getBiomeView(Vector2i newMin, Vector2i newMax);

    /**
     * Returns a new area that is viewed through some transformation. This does
     * not copy the biomes, it only provides a new view of the storage.
     *
     * @param transform The transformation to be applied
     * @return The new area with the transform
     */
    @Override
    MutableBiomeArea getBiomeView(DiscreteTransform2 transform);

    /**
     * Returns a new area that is translated so that
     * {@link BiomeArea#getBiomeMin()} returns {@link Vector2i#ZERO}. This does
     * not copy the biomes, it only provides a new view of the storage.
     *
     * @return The new area with its minimum at zero
     */
    @Override
    default MutableBiomeArea getRelativeBiomeView() {
        return getBiomeView(DiscreteTransform2.fromTranslation(getBiomeMin().negate()));
    }

    @Override
    MutableBiomeAreaWorker<? extends MutableBiomeArea> getBiomeWorker();

}
