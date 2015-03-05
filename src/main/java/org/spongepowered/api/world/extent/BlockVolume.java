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

package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Direction;

import java.util.Collection;

/**
 * A volume containing blocks.
 */
public interface BlockVolume {

    /**
     * Get a representation of the block at the given position.
     *
     * @param position The position
     * @return The block
     */
    BlockLoc getBlock(Vector3d position);

    /**
     * Get a representation of the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block
     */
    BlockLoc getBlock(int x, int y, int z);

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @param position The position of the block
     * @return The type of block
     */
    BlockType getBlockType(Vector3i position);

    /**
     * Get the block state for this position.
     *
     * @param position The position of the block
     * @return The current block state
     */
    BlockState getBlockState(Vector3i position);

    /**
     * Get an instance of the given data class for this block.
     *
     * <p>For example, if this block represents a sign,
     * {@code getBlockData(Sign.class)} would yield an instance of
     * {@code Sign} to change the contents of the sign. However, if
     * this block does not represent a sign, then an instance will not
     * be returned.</p>
     *
     * @param position The position of the block
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class
     */
    <T> Optional<T> getBlockData(Vector3i position, Class<T> dataClass);

    /**
     * Replace the block state at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param position The position of the block
     * @param state The new block state
     */
    void setBlockState(Vector3i position, BlockState state);

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param position The position of the block
     * @param type The new type
     */
    void setBlockType(Vector3i position, BlockType type);

    /**
     * Replace the block at this position with a copy of the given snapshot.
     *
     * <p>Changing the snapshot afterwards will not affect the block that
     * has been placed at this location.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     */
    void setBlockSnapshot(Vector3i position, BlockSnapshot snapshot);

    /**
     * Get a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was
     * taken from so changes to the original block do not affect the
     * snapshot.</p>
     *
     * @param position The position of the block
     * @return A snapshot
     */
    BlockSnapshot getBlockSnapshot(Vector3i position);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param position The position of the block
     */
    void interactBlock(Vector3i position);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     */
    void interactBlockWith(Vector3i position, ItemStack itemStack);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @return Whether the block was destroyed
     */
    boolean digBlock(Vector3i position);

    /**
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * @param position The position of the block
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(Vector3i position, ItemStack itemStack);

    /**
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @param position The position of the block
     * @return The time in ticks
     */
    int getBlockDigTime(Vector3i position);

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param position The position of the block
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    int getBlockDigTimeWith(Vector3i position, ItemStack itemStack);

    /**
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @param position The position of the block
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance(Vector3i position);

    /**
     * Get the light level for this object that is caused by an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @param position The position of the block
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromSky(Vector3i position);

    /**
     * Get the light level for this object that is caused by everything
     * other than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @param position The position of the block
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromGround(Vector3i position);

    /**
     * Test whether the object is powered.
     *
     * @param position The position of the block
     * @return Whether powered
     */
    boolean isBlockPowered(Vector3i position);

    /**
     * Test whether the object is indirectly powered.
     *
     * @param position The position of the block
     * @return Whether powered
     */
    boolean isBlockIndirectlyPowered(Vector3i position);

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param position The position of the block
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFacePowered(Vector3i position, Direction direction);

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param position The position of the block
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFaceIndirectlyPowered(Vector3i position, Direction direction);

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @param position The position of the block
     * @return Faces powered
     */
    Collection<Direction> getPoweredBlockFaces(Vector3i position);

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @param position The position of the block
     * @return Faces indirectly powered
     */
    Collection<Direction> getIndirectlyPoweredBlockFaces(Vector3i position);

    /**
     * Test whether the the block will block the movement of entities.
     *
     * @param position The position of the block
     * @return Blocks movement
     */
    boolean isBlockPassable(Vector3i position);

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param position The position of the block
     * @param faceDirection The face of the block to check
     * @return Is flammable
     */
    boolean isBlockFlammable(Vector3i position, Direction faceDirection);

}
