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

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.DataPriority;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.util.Collection;

/**
 * Contains blocks, tile entities, entities, and possibly other game objects.
 */
public interface Extent extends EntityUniverse, TileEntityVolume, WeatherUniverse, BiomeArea {

    /**
     * Get a representation of the block at the given position.
     *
     * @param position The position
     * @return The block
     */
    Location getFullBlock(Vector3i position);

    /**
     * Get a representation of the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block
     */
    Location getFullBlock(int x, int y, int z);

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @param position The position of the block
     * @return The type of block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the block volume
     */
    BlockType getBlockType(Vector3i position);

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The type of block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the block volume
     */
    BlockType getBlockType(int x, int y, int z);

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
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param type The new type
     */
    void setBlockType(int x, int y, int z, BlockType type);

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
    BlockSnapshot getBlockSnapshot(int x, int y, int z);

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
     * Replace the block at this position with a copy of the given snapshot.
     *
     * <p>Changing the snapshot afterwards will not affect the block that
     * has been placed at this location.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param snapshot The snapshot
     */
    void setBlockSnapshot(int x, int y, int z, BlockSnapshot snapshot);

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
     * Get an instance of the given data class for this block.
     *
     * <p>For example, if this block represents a sign,
     * {@code getBlockData(Sign.class)} would yield an instance of
     * {@code Sign} to change the contents of the sign. However, if
     * this block does not represent a sign, then an instance will not
     * be returned.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class
     */
    <T> Optional<T> getBlockData(int x, int y, int z, Class<T> dataClass);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param position The position of the block
     */
    void interactBlock(Vector3i position);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     */
    void interactBlock(int x, int y, int z);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     */
    void interactBlockWith(Vector3i position, ItemStack itemStack);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     */
    void interactBlockWith(int x, int y, int z, ItemStack itemStack);

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
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @param position The position of the block
     * @return The time in ticks
     */
    int getBlockDigTime(Vector3i position);

    /**
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The time in ticks
     */
    int getBlockDigTime(int x, int y, int z);

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
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @param position The position of the block
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance(Vector3i position);

    /**
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance(int x, int y, int z);

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
     * Get the light level for this object that is caused by an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromSky(int x, int y, int z);

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
     * Get the light level for this object that is caused by everything
     * other than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromGround(int x, int y, int z);

    /**
     * Test whether the object is powered.
     *
     * @param position The position of the block
     * @return Whether powered
     */
    boolean isBlockPowered(Vector3i position);

    /**
     * Test whether the object is powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Whether powered
     */
    boolean isBlockPowered(int x, int y, int z);

    /**
     * Test whether the object is indirectly powered.
     *
     * @param position The position of the block
     * @return Whether powered
     */
    boolean isBlockIndirectlyPowered(Vector3i position);

    /**
     * Test whether the object is indirectly powered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Whether powered
     */
    boolean isBlockIndirectlyPowered(int x, int y, int z);

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
     * Test whether the the block will block the movement of entities.
     *
     * @param position The position of the block
     * @return Blocks movement
     */
    boolean isBlockPassable(Vector3i position);

    /**
     * Test whether the the block will block the movement of entities.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Blocks movement
     */
    boolean isBlockPassable(int x, int y, int z);

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
     * Gets an instance of the given data class for given block at the location.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link DataManipulator} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param position The position of the block
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<T>> Optional<T> getData(Vector3i position, Class<T> dataClass);

    /**
     * Gets an instance of the given data class for given block at the location.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link DataManipulator} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<T>> Optional<T> getData(int x, int y, int z, Class<T> dataClass);

    /**
     * Gets or creates a new {@link DataManipulator} that can be accepted by
     * the block at the location. In the event that there is no data that can
     * be represented by the given {@link DataManipulator}, a new
     * {@link  DataManipulator} object is created with default values.
     *
     * <p>In the event the {@link DataManipulator} can not represent any data
     * pertaining to the block at the location, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param position The position of the block
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<T>> Optional<T> getOrCreate(Vector3i position, Class<T> manipulatorClass);

    /**
     * Gets or creates a new {@link DataManipulator} that can be accepted by
     * the block at the location. In the event that there is no data that can
     * be represented by the given {@link DataManipulator}, a new
     * {@link  DataManipulator} object is created with default values.
     *
     * <p>In the event the {@link DataManipulator} can not represent any data
     * pertaining to the block at the location, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<T>> Optional<T> getOrCreate(int x, int y, int z, Class<T> manipulatorClass);

    /**
     * Attempts to remove the given {@link DataManipulator} represented by
     * the block at the given location if possible.
     *
     * <p>Certain {@link DataManipulator}s can not be removed due to certain
     * dependencies relying on the particular data to function.</p>
     *
     * @param position The position of the block
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return If the manipulator was removed
     */
    <T extends DataManipulator<T>> boolean remove(Vector3i position, Class<T> manipulatorClass);

    /**
     * Attempts to remove the given {@link DataManipulator} represented by
     * the block at the given location if possible.
     *
     * <p>Certain {@link DataManipulator}s can not be removed due to certain
     * dependencies relying on the particular data to function.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return If the manipulator was removed
     */
    <T extends DataManipulator<T>> boolean remove(int x, int y, int z, Class<T> manipulatorClass);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param position The position of the block
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    <T extends DataManipulator<T>> boolean isCompatible(Vector3i position, Class<T> manipulatorClass);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    <T extends DataManipulator<T>> boolean isCompatible(int x, int y, int z, Class<T> manipulatorClass);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>In the event that the {@link DataManipulator} contains data that
     * would otherwise overlap existing data on the block at the given
     * position, a default {@link DataPriority#DATA_MANIPULATOR} is used.</p>
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param position The position of the block
     * @param manipulatorData The manipulator data to offer
     * @param <T> The type of manipulator data
     * @return The transaction result
     */
    <T extends DataManipulator<T>> DataTransactionResult offer(Vector3i position, T manipulatorData);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>In the event that the {@link DataManipulator} contains data that
     * would otherwise overlap existing data on the block at the given
     * position, a default {@link DataPriority#DATA_MANIPULATOR} is used.</p>
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorData The manipulator data to offer
     * @param <T> The type of manipulator data
     * @return The transaction result
     */
    <T extends DataManipulator<T>> DataTransactionResult offer(int x, int y, int z, T manipulatorData);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param position The position of the block
     * @param manipulatorData The manipulator data to offer
     * @param priority The data priority to use
     * @param <T> The type of manipulator data
     * @return The transaction result
     */
    <T extends DataManipulator<T>> DataTransactionResult offer(Vector3i position, T manipulatorData, DataPriority priority);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorData The manipulator data to offer
     * @param priority The data priority to use
     * @param <T> The type of manipulator data
     * @return The transaction result
     */
    <T extends DataManipulator<T>> DataTransactionResult offer(int x, int y, int z, T manipulatorData, DataPriority priority);

    /**
     * Gets an copied collection of all known {@link DataManipulator}s
     * belonging to the block at the given position. An individual
     * {@link DataManipulator} can be used for creating new data to replace
     * on the block at the given position.
     *
     * @param position The position of the block
     * @return A collection of copied data manipulators belonging to the block
     *     at the given position
     */
    Collection<DataManipulator<?>> getManipulators(Vector3i position);

    /**
     * Gets an copied collection of all known {@link DataManipulator}s
     * belonging to the block at the given position. An individual
     * {@link DataManipulator} can be used for creating new data to replace
     * on the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A collection of copied data manipulators belonging to the block
     *     at the given position
     */
    Collection<DataManipulator<?>> getManipulators(int x, int y, int z);

    /**
     * Attempts to retrieve a specific {@link Property} type of this the block
     * at the given position. If the property is not applicable,
     * {@link Optional#absent()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * the block at the given position that is dependent on the instance of the
     * holder. As {@link Property}s cannot be changed, the the block at the
     * given  position can not change the information about it's own properties
     * either.</p>
     *
     * @param position The position of the block
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property, if available
     */
    <T extends Property<?, ?>> Optional<T> getProperty(Vector3i position, Class<T> propertyClass);

    /**
     * Attempts to retrieve a specific {@link Property} type of the block at
     * the given position. If the property is not applicable,
     * {@link Optional#absent()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * the block at the given position that is dependent on the instance of the
     * holder. As {@link Property}s cannot be changed, the the block at the
     * given  position can not change the information about it's own properties
     * either.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property, if available
     */
    <T extends Property<?, ?>> Optional<T> getProperty(int x, int y, int z, Class<T> propertyClass);

    /**
     * Gets an immutable collection of all known {@link Property}s pertaining to
     * the block at the given position.
     *
     * <p>{@link Property}s can not be changed such that the property is attached
     * to the instance of the residing {@link DataHolder}.</p>
     *
     * @param position The position of the block
     * @return An immutable collection of all known {@link Property}s
     */
    Collection<Property<?, ?>> getProperties(Vector3i position);

    /**
     * Gets an immutable collection of all known {@link Property}s pertaining to
     * the block at the given position.
     *
     * <p>{@link Property}s can not be changed such that the property is attached
     * to the instance of the residing {@link DataHolder}.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return An immutable collection of all known {@link Property}s
     */
    Collection<Property<?, ?>> getProperties(int x, int y, int z);

    /**
     * Validates the container with known data required to set the raw data to
     * the block at the given position. If the container is incomplete or
     * contains invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(Vector3i, DataContainer)} to avoid exceptions.</p>
     *
     * @param position The position of the block
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(Vector3i position, DataContainer container);

    /**
     * Validates the container with known data required to set the raw data to
     * the block at the given position. If the container is incomplete or
     * contains invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(Vector3i, DataContainer)} to avoid exceptions.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(int x, int y, int z, DataContainer container);

    /**
     * Attempts to set all data of the block at the given position according to
     * the {@link DataContainer}'s held information. Using this to modify known
     * {@link DataManipulator}s is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link DataManipulator}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param position The position of the block
     * @param container A container containing all raw data to set on the block
     *     at the given position
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(Vector3i position, DataContainer container) throws InvalidDataException;

    /**
     * Attempts to set all data of the block at the given position according to
     * the {@link DataContainer}'s held information. Using this to modify known
     * {@link DataManipulator}s is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link DataManipulator}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param container A container containing all raw data to set on the block
     *     at the given position
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(int x, int y, int z, DataContainer container) throws InvalidDataException;
}
