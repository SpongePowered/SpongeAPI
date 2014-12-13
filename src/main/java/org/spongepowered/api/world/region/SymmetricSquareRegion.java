/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.world.region;

import org.spongepowered.api.util.AxisDirection;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;

/**
 * Represents a chunk container also known as region with a squarish shape
 * similar to minecraft's region, but not necessarily with the same size.
 * <p />
 * <p>
 * Some important facts about symmetric square regions:
 * </p>
 * <ul>
 * <li>Represent the internal grouping of one or more chunks.</li>
 * <li>A region contains at least one chunk although its not required that the
 * chunk is loaded or any file or data hint to its existence.</li>
 * <li>There is no limit how many chunks can be contained in a region.</li>
 * <li>The shape is squarish.</li>
 * <li>A chunk is bound to a single region and every time it is regenerated it
 * will be bound to the same region.</li>
 * <li>All contained chunks share borders with other chunks in the same region.</li>
 * <li>All regions in the world must be symmetric square regions of the same
 * size.</li>
 * </ul>
 */
public interface SymmetricSquareRegion extends Region {

    /**
     * Gets the position of this region.
     *
     * @return The position of this region.
     */
    Vector2i getPosition();

    /**
     * Gets the minimal chunk's position located in this region.
     *
     * @return The minimal chunk's position
     */
    Vector2i getMinChunkPosition();

    /**
     * Gets the maximal chunk's position located in this region.
     *
     * @return The minimal chunk's position
     */
    Vector2i getMaxChunkPosition();

    /**
     * Gets the chunk's position matching to the given {@link AxisDirection}s.
     *
     * <ul>
     * <li>{@link AxisDirection#MINUS} for the minimal chunk's position within
     * this region for the given axis.</li>
     * <li>{@link AxisDirection#ZERO} for the middle chunk's position within
     * this region for the given axis. If there are two chunks matching this
     * condition the lower one will be returned.</li>
     * <li>{@link AxisDirection#PLUS} for the maximal chunk position within this
     * region for the given axis.</li>
     * </ul>
     *
     * @param xDirection The direction for the given x-axis
     * @param zDirection The direction for the given z-axis
     * @return The chunk's position matching the given specifications
     */
    Vector2i getChunkPosition(AxisDirection xDirection, AxisDirection zDirection);

    /**
     * Gets the minimal block's position located in this region.
     *
     * @return The minimal block's position
     */
    Vector3d getMinBlockPosition();

    /**
     * Gets the maximal block's position located in this region.
     *
     * @return The maximal block's position
     */
    Vector3d getMaxBlockPosition();

    /**
     * Gets the block's position matching to the given {@link AxisDirection}s.
     *
     * <ul>
     * <li>{@link AxisDirection#MINUS} for the minimal block's position within
     * this region for the given axis.</li>
     * <li>{@link AxisDirection#ZERO} for the middle block's position within
     * this region for the given axis. If there are two blocks matching this
     * condition the lower one will be returned.</li>
     * <li>{@link AxisDirection#PLUS} for the maximal block's position within
     * this region for the given axis.</li>
     * </ul>
     *
     * @param xDirection The direction for the given x-axis
     * @param yDirection The direction for the given y-axis
     * @param zDirection The direction for the given z-axis
     * @return The blocks's position matching the given specifications
     */
    Vector3d getBlockPosition(AxisDirection xDirection, AxisDirection yDirection, AxisDirection zDirection);

}
