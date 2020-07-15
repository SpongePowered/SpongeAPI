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
package org.spongepowered.api.world;

import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

public interface LocationCreator {

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent.
     *
     * @param position The position
     * @return The location in this extent
     */
    ServerLocation getLocation(Vector3i position);

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    default ServerLocation getLocation(int x, int y, int z) {
        return this.getLocation(new Vector3i(x, y, z));
    }

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent. This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param position The position
     * @return The location in this extent
     */
    ServerLocation getLocation(Vector3d position);

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent. This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    default ServerLocation getLocation(double x, double y, double z) {
        return this.getLocation(new Vector3i(x, y, z));
    }

    /**
     * Gets a {@link LocatableBlock} for the desired {@link Vector3i} position.
     *
     * @param position The position to get the locatable block
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(Vector3i position) {
        return LocatableBlock.builder().location(this.getLocation(position)).build();
    }

    /**
     * Gets a {@link LocatableBlock} for the desired {@code x, y, z} coordinates.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(int x, int y, int z) {
        return LocatableBlock.builder().location(this.getLocation(x, y, z)).build();
    }

}
