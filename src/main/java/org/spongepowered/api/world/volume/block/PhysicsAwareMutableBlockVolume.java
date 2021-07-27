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
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.BlockChangeFlags;
import org.spongepowered.math.vector.Vector3i;

public interface PhysicsAwareMutableBlockVolume<P extends PhysicsAwareMutableBlockVolume<P>> extends BlockVolume.Modifiable<P> {

    /**
     * {@inheritDoc}
     *
     * Additionally, this performs what's considered to be "default" placement
     * by a {@link org.spongepowered.api.entity.living.player.Player} such that
     * neighboring blocks are affected, light is updated, pathfinding awareness
     * is notified, etc. see {@link BlockChangeFlags#DEFAULT_PLACEMENT} for
     * more information, and see {@link BlockChangeFlag} for details on the
     * modifiers and what they may change.
     *
     * @param position The position
     * @param block The block
     * @return True if the block change was not cancelled
     */
    @Override
    default boolean setBlock(final Vector3i position, final BlockState block) {
        return this.setBlock(position.x(), position.y(), position.z(), block, BlockChangeFlags.DEFAULT_PLACEMENT);
    }

    /**
     * {@inheritDoc}
     *
     * Additionally, this performs what's considered to be "default" placement
     * by a {@link org.spongepowered.api.entity.living.player.Player} such that
     * neighboring blocks are affected, light is updated, pathfinding awareness
     * is notified, etc. see {@link BlockChangeFlags#DEFAULT_PLACEMENT} for
     * more information, and see {@link BlockChangeFlag} for details on the
     * modifiers and what they may change.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param block The block
     * @return True if the block change was not cancelled
     */
    @Override
    default boolean setBlock(final int x, final int y, final int z, final BlockState block) {
        return this.setBlock(x, y, z, block, BlockChangeFlags.DEFAULT_PLACEMENT);
    }

    /**
     * Sets the block at the given position in the world.
     *
     * @param position The position
     * @param blockState The block
     * @param flag The various change flags controlling some interactions
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default boolean setBlock(final Vector3i position, final BlockState blockState, final BlockChangeFlag flag) {
        return this.setBlock(position.x(), position.y(), position.z(), blockState, flag);
    }

    /**
     * Sets the block at the given position in the world.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param blockState The block
     * @param flag The various change flags controlling some interactions
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    boolean setBlock(int x, int y, int z, BlockState blockState, BlockChangeFlag flag);
}
