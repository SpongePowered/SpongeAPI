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

/**
 * An area containing biomes that can be accessed but not modified.
 * The data will never change.
 *
 * @see BiomeArea
 */
public interface ImmutableBiomeArea extends UnmodifiableBiomeArea {

    /**
     * Returns a new area that is the same or smaller than the current area.
     * This does not copy the biomes, it only provides a new view of the
     * storage.
     *
     * @param newMin The new minimum coordinates in this area
     * @param newMax The new maximum coordinates in this area
     * @return The new area with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum
     *     are outside the current area
     */
    @Override
    ImmutableBiomeArea getBiomeView(Vector2i newMin, Vector2i newMax);

    /**
     * Returns a new area that is viewed through some transformation.
     * This does not copy the biomes, it only provides a new view of the
     * storage.
     *
     * @param transform The transformation to be applied
     * @return The new area with the transform
     */
    @Override
    ImmutableBiomeArea getBiomeView(DiscreteTransform2 transform);

    /**
     * Returns a new area that is translated so that
     * {@link BiomeArea#getBiomeMin()} returns {@link Vector2i#ZERO}.
     * This does not copy the biomes, it only provides a new view of the
     * storage.
     *
     * @return The new area with its minimum at zero
     */
    @Override
    ImmutableBiomeArea getRelativeBiomeView();

}
