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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

public interface Location<W extends World<W, L>, L extends Location<W, L>> {

    /**
     * Gets the underlying world. Throws a {@link IllegalStateException}
     * if the world isn't available.
     *
     * @return The underlying world
     * @see #worldIfAvailable()
     */
    W world();

    /**
     * Gets the underlying {@link World} if it's available. A {@link World}
     * is available when it exists and is loaded.
     *
     * @return The underlying world, if available
     * @see #isAvailable()
     */
    Optional<W> worldIfAvailable();

    /**
     * Gets whether this location is available. A location is
     * available when the target {@link World} exists and is loaded.
     *
     * @return Whether the location is available
     */
    boolean isAvailable();

    /**
     * Gets whether this location is valid. A location is valid
     * when the target {@link World} exists, this can be loaded
     * or unloaded.
     *
     * @return Whether the location is valid
     */
    boolean isValid();

    /**
     * Gets the underlying position.
     *
     * @return The underlying position
     */
    Vector3d position();

    /**
     * Gets the underlying block position.
     *
     * @return The underlying block position
     */
    Vector3i blockPosition();

    /**
     * Gets the underlying chunk position.
     *
     * @return The underlying chunk position
     */
    Vector3i chunkPosition();

    /**
     * Gets the underlying biome position.
     *
     * @return The underlying biome position
     */
    Vector3i biomePosition();

    /**
     * Gets the X component of this instance's position.
     *
     * @return The x component
     */
    double x();

    /**
     * Gets the Y component of this instance's position.
     *
     * @return The y component
     */
    double y();

    /**
     * Gets the Z component of this instance's position.
     *
     * @return The z component
     */
    double z();

    /**
     * Gets the floored X component of this instance's position.
     *
     * @return The floored x component
     */
    int blockX();

    /**
     * Gets the floored Y component of this instance's position.
     *
     * @return The floored y component
     */
    int blockY();

    /**
     * Gets the floored Z component of this instance's position.
     *
     * @return The floored z component
     */
    int blockZ();

    default Optional<ServerLocation> onServer() {
        return Optional.ofNullable(this instanceof ServerLocation ? (ServerLocation) this : null);
    }

    /**
     * Returns true if this location is in the given world. This is implemented
     * as an {@link Object#equals(Object)} check.
     *
     * @param world The world to check
     * @return Whether this location is in the world
     */
    boolean inWorld(W world);

    /**
     * Create a new instance with a new World.
     *
     * @param world The new world
     * @return A new instance
     */
    L withWorld(W world);

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    L withPosition(Vector3d position);

    /**
     * Create a new instance with a new block position.
     *
     * @param position The new position
     * @return A new instance
     */
    L withBlockPosition(Vector3i position);

    /**
     * Subtract another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    L sub(Vector3d v);

    /**
     * Subtract another Vector3i to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    L sub(Vector3i v);

    /**
     * Subtract vector components to the position on this instance, returning a
     * new Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    L sub(double x, double y, double z);

    /**
     * Add another Vector3d to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    L add(Vector3d v);

    /**
     * Add another Vector3i to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    L add(Vector3i v);

    /**
     * Add vector components to the position on this instance, returning a new
     * Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    L add(double x, double y, double z);

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a unit amount, even diagonally.
     *
     * @param direction The direction to move in
     * @return The location in that direction
     */
    L relativeTo(Direction direction);

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a block amount, even diagonally.
     *
     * <p>{@link Direction.Division#SECONDARY_ORDINAL}
     * directions are not a valid argument. These will throw an exception.
     * </p>
     *
     * @param direction The direction to move in
     * @return The location in that direction
     * @throws IllegalArgumentException If the direction is a
     * {@link Direction.Division#SECONDARY_ORDINAL}
     */
    L relativeToBlock(Direction direction);

    /**
     * Gets the block at this location.
     *
     * @return The biome at this location
     */
    Biome biome();

    /**
     * Returns true if this location has a block at its
     * {@link #blockPosition()}.
     *
     * @return Whether or not there is a block at this location.
     */
    boolean hasBlock();

    /**
     * Gets the {@link BlockState} for this location.
     *
     * @return The block state
     */
    BlockState block();

    /**
     * Gets the {@link BlockType} for this location.
     *
     * @return The block type
     */
    default BlockType blockType() {
        return this.block().type();
    }

    /**
     * Gets the {@link FluidState} for this location.
     *
     * @return The fluid state
     */
    FluidState fluid();

    /**
     * Checks for whether the block at this location contains block entity data.
     *
     * @return True if the block at this location has block entity data, false
     *      otherwise
     */
    boolean hasBlockEntity();

    /**
     * Gets the associated {@link BlockEntity} on this block.
     *
     * @return The associated block entity, if available
     */
    Optional<? extends BlockEntity> blockEntity();

    /**
     * Replace the block at this location with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     * @return True if the block change was successful
     */
    boolean setBlock(BlockState state);

    /**
     * Replace the block at this location with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *  @param state The new block state
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    boolean setBlock(BlockState state, BlockChangeFlag flag);

    /**
     * Replace the block type at this location by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     * @return True if the block change was successful
     */
    boolean setBlockType(BlockType type);

    /**
     * Replace the block type at this location by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @param type The new type
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    boolean setBlockType(BlockType type, BlockChangeFlag flag);
}
