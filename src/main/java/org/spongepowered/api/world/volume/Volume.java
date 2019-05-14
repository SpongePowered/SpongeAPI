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
package org.spongepowered.api.world.volume;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.util.PositionOutOfBoundsException;

public interface Volume {

    Vector3i getBlockMin();

    Vector3i getBlockMax();

    Vector3i getBlockSize();

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <= position <=
     * {@link #getBlockMax()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position has a block in this volume
     */
    default boolean containsBlock(Vector3i position) {
        return containsBlock(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <= (x, y, z)
     * <= {@link #getBlockMax()}</code>
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position has a block in this volume
     */
    boolean containsBlock(int x, int y, int z);

    default boolean isAreaAvailable(Vector3i vector3i) {
        return isAreaAvailable(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    boolean isAreaAvailable(int x, int y, int z);

    /**
     * Returns a new volume that is the same or smaller than the current volume.
     * This does not copy the biomes, it only provides a new view of the
     * storage.
     *
     * @param newMin The new minimum coordinates in this volume
     * @param newMax The new maximum coordinates in this volume
     * @return The new volume with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum are
     *         outside the current volume
     */
    Volume getView(Vector3i newMin, Vector3i newMax);
}
