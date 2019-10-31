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
package org.spongepowered.api.world.volume.block;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3i;

public interface ReadableBlockVolume extends Volume, LocationBaseDataHolder {

    BlockState getBlock(int x, int y, int z);

    default BlockState getBlock(Vector3i vector3i) {
        return getBlock(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    FluidState getFluid(int x, int y, int z);

    default FluidState getFluid(Vector3i vector3i) {
        return getFluid(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    UnmodifiableBlockVolume<?> asUnmodifiableBlockVolume();

    ImmutableBlockVolume asImmutableBlockVolume();

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param x The x column value
     * @param z The z column value
     * @return The y value of the highest opaque block
     */
    int getHighestYAt(int x, int z);

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param column The column value
     * @return The y value of the highest opaque block
     */
    default int getHighestYAt(Vector2i column) {
        return this.getHighestYAt(column.getX(), column.getY());
    }

    /**
     * Get the {@link Location} of the highest block that sunlight can reach in
     * the given column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param position The column position
     * @return The highest opaque position
     */
    default Vector3i getHighestPositionAt(Vector3i position) {
        return new Vector3i(position.getX(), getHighestYAt(position.getX(), position.getZ()), position.getZ());
    }
}
