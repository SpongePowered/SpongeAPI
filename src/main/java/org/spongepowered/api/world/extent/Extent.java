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

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.DiscreteTransform3;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.Location;

import java.util.Collection;

/**
 * A mutable object containing blocks, tile entities, entities, and possibly other game objects.
 */
public interface Extent extends EntityUniverse, TileEntityVolume, MutableBiomeArea, LocationCompositeValueStore, Identifiable {

    /**
     * Gets a location in this extent at the given position.
     * Essentially, this is a 3D pointer in the extent.
     *
     * @param position The position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(Vector3i position);

    /**
     * Gets a location in this extent at the given position.
     * Essentially, this is a 3D pointer in the extent.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(int x, int y, int z);

    /**
     * Gets a location in this extent at the given position.
     * Essentially, this is a 3D pointer in the extent.
     * This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param position The position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(Vector3d position);

    /**
     * Gets a location in this extent at the given position.
     * Essentially, this is a 3D pointer in the extent.
     * This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(double x, double y, double z);

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
    BlockSnapshot createSnapshot(Vector3i position);

    /**
     * Get a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was
     * taken from so changes to the original block do not affect the
     * snapshot.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A snapshot
     */
    BlockSnapshot createSnapshot(int x, int y, int z);

    /**
     * Restores the given {@link BlockSnapshot} using the saved block position
     * stored within the snapshot.
     * 
     * <p>If forced, the state of the block will change its {@link BlockType}
     * to match that of the snapshot then set the state. However, if force is
     * set to false and the {@link BlockType}s does not match, false will be
     * returned.
     * If notifyNeighbors is true, neighboring blocks will be notified of
     * changes at the restored block location triggering physic updates.</p>
     *
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *     {@link BlockType} does not match the snapshot one.
     * @param notifyNeighbors Whether or not you want to notify neighboring
     *     blocks of this change. If true, this may cause blocks to change.
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, boolean notifyNeighbors);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     * 
     * <p>If forced, the state of the block will change its {@link BlockType}
     * to match that of the snapshot then set the state. However, if force is
     * set to false and the {@link BlockType}s does not match, false will be
     * returned.
     * If notifyNeighbors is true, neighboring blocks will be notified of
     * changes at the restored block location triggering physic updates.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *     {@link BlockType} does not match the snapshot one.
     * @param notifyNeighbors Whether or not you want to notify neighboring
     *     blocks of this change. If true, this may cause blocks to change.
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(Vector3i position, BlockSnapshot snapshot, boolean force, boolean notifyNeighbors);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     * 
     * <p>If forced, the state of the block will change its {@link BlockType}
     * to match that of the snapshot then set the state. However, if force is
     * set to false and the {@link BlockType}s does not match, false will be
     * returned.
     * If notifyNeighbors is true, neighboring blocks will be notified of
     * changes at the restored block location triggering physic updates.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *     {@link BlockType} does not match the snapshot one.
     * @param notifyNeighbors Whether or not you want to notify neighboring
     *     blocks of this change. If true, this may cause blocks to change.
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(int x, int y, int z, BlockSnapshot snapshot, boolean force, boolean notifyNeighbors);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     */
    void interactBlock(Vector3i position, Direction side);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     */
    void interactBlock(int x, int y, int z, Direction side);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     * @param side The side of the block to interact with
     */
    void interactBlockWith(Vector3i position, ItemStack itemStack, Direction side);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     * @param side The side of the block to interact with
     */
    void interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param position The position of the block
     * @return Whether the block was destroyed
     */
    boolean digBlock(Vector3i position);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Whether the block was destroyed
     */
    boolean digBlock(int x, int y, int z);

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
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(int x, int y, int z, ItemStack itemStack);

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param position The position of the block
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    int getBlockDigTimeWith(Vector3i position, ItemStack itemStack);

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    int getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack);

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param position The position of the block
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFacePowered(Vector3i position, Direction direction);

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFacePowered(int x, int y, int z, Direction direction);

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param position The position of the block
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFaceIndirectlyPowered(Vector3i position, Direction direction);

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param direction The direction
     * @return Whether powered
     */
    boolean isBlockFaceIndirectlyPowered(int x, int y, int z, Direction direction);

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @param position The position of the block
     * @return Faces powered
     */
    Collection<Direction> getPoweredBlockFaces(Vector3i position);

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Faces powered
     */
    Collection<Direction> getPoweredBlockFaces(int x, int y, int z);

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @param position The position of the block
     * @return Faces indirectly powered
     */
    Collection<Direction> getIndirectlyPoweredBlockFaces(Vector3i position);

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Faces indirectly powered
     */
    Collection<Direction> getIndirectlyPoweredBlockFaces(int x, int y, int z);

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param position The position of the block
     * @param faceDirection The face of the block to check
     * @return Is flammable
     */
    boolean isBlockFlammable(Vector3i position, Direction faceDirection);

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param faceDirection The face of the block to check
     * @return Is flammable
     */
    boolean isBlockFlammable(int x, int y, int z, Direction faceDirection);

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @param position The position of the block
     * @return A list of ScheduledBlockUpdates on this block
     */
    Collection<ScheduledBlockUpdate> getScheduledUpdates(Vector3i position);

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A list of ScheduledBlockUpdates on this block
     */
    Collection<ScheduledBlockUpdate> getScheduledUpdates(int x, int y, int z);

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param position The position of the block
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledBlockUpdate addScheduledUpdate(Vector3i position, int priority, int ticks);

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledBlockUpdate addScheduledUpdate(int x, int y, int z, int priority, int ticks);

    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.
     *
     * @param position The position of the block
     * @param update The ScheduledBlockUpdate to remove
     */
    void removeScheduledUpdate(Vector3i position, ScheduledBlockUpdate update);


    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.

     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param update The ScheduledBlockUpdate to remove
     */
    void removeScheduledUpdate(int x, int y, int z, ScheduledBlockUpdate update);

    /**
     * Gets whether or not this extent is currently loaded.
     *
     * @return Whether or not this extent is loaded
     */
    boolean isLoaded();

    /**
     * Returns a new extent that is the same or smaller than the current
     * extent. This does not copy the data, it only provides a new view
     * of the extent.
     *
     * @param newMin The new minimum coordinates in this extent
     * @param newMax The new maximum coordinates in this extent
     * @return The new extent with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum
     *     are outside the current extent
     */
    Extent getExtentView(Vector3i newMin, Vector3i newMax);

    /**
     * Returns a new extent that is viewed through some transformation.
     * This does not copy the data, it only provides a new view of the
     * extent.
     *
     * @param transform The transformation to be applied
     * @return The new extent with the transform
     */
    Extent getExtentView(DiscreteTransform3 transform);

    /**
     * Returns a new extent that is translated so that
     * {@link Extent#getBlockMin()} returns {@link Vector3i#ZERO}.
     * This does not copy the data, it only provides a new view of the
     * extent.
     *
     * @return The new extent its minimum at zero
     */
    Extent getRelativeExtentView();

}
