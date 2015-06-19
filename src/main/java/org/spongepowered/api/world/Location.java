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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.data.DataQuery.of;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.DataPriority;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * A position within a particular {@link Extent}.
 *
 * <p>This class is primarily a helper class to represent a location in a
 * particular {@link Extent}. The methods provided are proxy methods to ones
 * on {@link Extent}.</p>
 *
 * <p>Each instance can be used to either represent a block or a location on
 * a continuous coordinate system. Internally, positions are stored using
 * doubles. When a block-related method is used, the components of the
 * position are each rounded to an integer.</p>
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 */
public final class Location implements DataHolder {

    private final Extent extent;
    // Lazily computed, either position or blockPosition is set by the constructor
    @Nullable
    private Vector3d position = null;
    @Nullable
    private Vector3i blockPosition = null;
    @Nullable
    private Vector2i biomePosition = null;

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param position The position
     */
    public Location(Extent extent, Vector3d position) {
        this.extent = checkNotNull(extent, "extent");
        this.position = checkNotNull(position, "position");
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(Extent extent, double x, double y, double z) {
        this(extent, new Vector3d(x, y, z));
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param blockPosition The position
     */
    public Location(Extent extent, Vector3i blockPosition) {
        this.extent = checkNotNull(extent, "extent");
        this.blockPosition = checkNotNull(blockPosition, "blockPosition");
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(Extent extent, int x, int y, int z) {
        this(extent, new Vector3i(x, y, z));
    }

    /**
     * Get the underlying extent.
     *
     * @return The extent
     */
    public Extent getExtent() {
        return this.extent;
    }

    /**
     * Get the underlying position.
     *
     * @return The underlying position
     */
    public Vector3d getPosition() {
        if (this.position == null) {
            checkState(this.blockPosition != null);
            this.position = getBlockPosition().toDouble();
        }
        return this.position;
    }

    /**
     * Get the underlying block position.
     *
     * @return The underlying block position
     */
    public Vector3i getBlockPosition() {
        if (this.blockPosition == null) {
            checkState(this.position != null);
            this.blockPosition = getPosition().floor().toInt();
        }
        return this.blockPosition;
    }

    /**
     * Gets the underlying biome position.
     *
     * @return The underlying biome position
     */
    public Vector2i getBiomePosition() {
        if (this.biomePosition == null) {
            this.biomePosition = getBlockPosition().toVector2(true);
        }
        return this.biomePosition;
    }

    /**
     * Get the X component of this instance's position.
     *
     * @return The x component
     */
    public double getX() {
        return getPosition().getX();
    }

    /**
     * Get the Y component of this instance's position.
     *
     * @return The y component
     */
    public double getY() {
        return getPosition().getY();
    }

    /**
     * Get the Z component of this instance's position.
     *
     * @return The z component
     */
    public double getZ() {
        return getPosition().getZ();
    }

    /**
     * Get the floored X component of this instance's position.
     *
     * @return The floored x component
     */
    public int getBlockX() {
        return getBlockPosition().getX();
    }

    /**
     * Get the floored Y component of this instance's position.
     *
     * @return The floored y component
     */
    public int getBlockY() {
        return getBlockPosition().getY();
    }

    /**
     * Get the floored Z component of this instance's position.
     *
     * @return The floored z component
     */
    public int getBlockZ() {
        return getBlockPosition().getZ();
    }

    /**
     * Returns true if this location is in the given extent.
     * This is implemented as an {@link Object#equals(Object)} check.
     *
     * @param extent The extent to check
     * @return Whether this location is in the extent
     */
    public boolean inExtent(Extent extent) {
        return getExtent().equals(extent);
    }

    /**
     * Returns true if this location has a biome at its
     * {@link #getBiomePosition()}.
     *
     * @return Whether or not there is a biome at this location.
     */
    public boolean hasBiome() {
        return getExtent().containsBiome(getBiomePosition());
    }

    /**
     * Returns true if this location has a block at its
     * {@link #getBlockPosition()} ()}.
     *
     * @return Whether or not there is a block at this location.
     */
    public boolean hasBlock() {
        return getExtent().containsBlock(getBlockPosition());
    }

    /**
     * Create a new instance with a new extent.
     *
     * @param extent The new extent
     * @return A new instance
     */
    public Location setExtent(Extent extent) {
        checkNotNull(extent, "extent");
        if (extent == getExtent()) {
            return this;
        }
        return new Location(extent, getPosition());
    }

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location setPosition(Vector3d position) {
        checkNotNull(position, "position");
        if (position == getPosition()) {
            return this;
        }
        return new Location(getExtent(), position);
    }

    /**
     * Add another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location add(Vector3d v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Add vector components to the position on this instance, returning
     * a new Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    public Location add(double x, double y, double z) {
        return setPosition(getPosition().add(x, y, z));
    }

    /**
     * Gets the location next to this one in the give direction.
     *
     * @param direction The direction to look in
     * @return The block in that direction
     */
    public Location getRelative(Direction direction) {
        return add(direction.toVector3d());
    }

    /**
     * Gets the block at this location.
     *
     * @return The biome at this location
     */
    public BiomeType getBiome() {
        return getExtent().getBiome(getBiomePosition());
    }

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    public BlockType getBlockType() {
        return getExtent().getBlockType(getBlockPosition());
    }

    /**
     * Get the block state for this position.
     *
     * @return The current block state
     */
    public BlockState getBlock() {
        return getExtent().getBlock(getBlockPosition());
    }

    /**
     * Checks for whether the block at this position contains tile entity data.
     *
     * @return True if the block at this position has tile entity data, false otherwise
     */
    boolean hasTileEntity() {
        return getExtent().getTileEntity(getBlockPosition()).isPresent();
    }

    /**
     * Gets the associated {@link TileEntity} on this block.
     *
     * @return The associated tile entity, if available
     */
    public Optional<TileEntity> getTileEntity() {
        return getExtent().getTileEntity(getBlockPosition());
    }

    /**
     * Replace the block at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     */
    public void setBlock(BlockState state) {
        getExtent().setBlock(getBlockPosition(), state);
    }

    /**
     * Replace the block type at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     */
    public void setBlockType(BlockType type) {
        getExtent().setBlockType(getBlockPosition(), type);
    }

    /**
     * Replace the block at this position with a copy of the given snapshot.
     *
     * <p>Changing the snapshot afterwards will not affect the block that has
     * been placed at this location.</p>
     *
     * @param snapshot The snapshot
     */
    public void setBlockSnapshot(BlockSnapshot snapshot) {
        getExtent().setBlockSnapshot(getBlockPosition(), snapshot);
    }

    /**
     * Remove the block at this position by replacing it with {@link BlockTypes#AIR}.
     *
     * <p>This will remove any extended block data at the given position.</p>
     */
    @SuppressWarnings("ConstantConditions")
    public void removeBlock() {
        getExtent().setBlockType(getBlockPosition(), BlockTypes.AIR);
    }

    @Override
    public <T extends DataManipulator<T>> boolean remove(Class<T> manipulatorClass) {
        return getExtent().remove(getBlockPosition(), manipulatorClass);
    }

    /**
     * Simulates the interaction with this object as if a player had done so.
     */
    public void interactBlock() {
        getExtent().interactBlock(getBlockPosition());
    }

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param itemStack The item
     */
    public void interactBlockWith(ItemStack itemStack) {
        getExtent().interactBlockWith(getBlockPosition(), itemStack);
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @return Whether the block was destroyed
     */
    public boolean digBlock() {
        return getExtent().digBlock(getBlockPosition());
    }

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    public boolean digBlockWith(ItemStack itemStack) {
        return getExtent().digBlockWith(getBlockPosition(), itemStack);
    }

    /**
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @return The time in ticks
     */
    public int getBlockDigTime() {
        return getExtent().getBlockDigTime(getBlockPosition());
    }

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    public int getBlockDigTimeWith(ItemStack itemStack) {
        return getExtent().getBlockDigTimeWith(getBlockPosition(), itemStack);
    }

    /**
     * Gets the temperature at this position.
     *
     * <p>Vanilla behaviour for weather causes snow when the temperature is <= 0.15.</p>
     *
     * @return The temperature, as a float between 0 and 1, inclusive
     */
    public float getTemperature() {
        return getExtent().getTemperature(getBlockPosition());
    }

    /**
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    public byte getLuminance() {
        return getExtent().getLuminance(getBlockPosition());
    }

    /**
     * Get the light level for this object that is caused by an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    public byte getLuminanceFromSky() {
        return getExtent().getLuminanceFromSky(getBlockPosition());
    }

    /**
     * Get the light level for this object that is caused by everything other
     * than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    public byte getLuminanceFromGround() {
        return getExtent().getLuminanceFromGround(getBlockPosition());
    }

    /**
     * Test whether the object is powered.
     *
     * @return Whether powered
     */
    public boolean isBlockPowered() {
        return getExtent().isBlockPowered(getBlockPosition());
    }

    /**
     * Test whether the object is indirectly powered.
     *
     * @return Whether powered
     */
    public boolean isBlockIndirectlyPowered() {
        return getExtent().isBlockPowered(getBlockPosition());
    }

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isBlockFacePowered(Direction direction) {
        return getExtent().isBlockFacePowered(getBlockPosition(), direction);
    }

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isBlockFaceIndirectlyPowered(Direction direction) {
        return getExtent().isBlockFaceIndirectlyPowered(getBlockPosition(), direction);
    }

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @return Faces powered
     */
    public Collection<Direction> getPoweredBlockFaces() {
        return getExtent().getPoweredBlockFaces(getBlockPosition());
    }

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @return Faces indirectly powered
     */
    public Collection<Direction> getIndirectlyPoweredBlockFaces() {
        return getExtent().getIndirectlyPoweredBlockFaces(getBlockPosition());
    }

    /**
     * Test whether the the block will block the movement of entities.
     *
     * @return Blocks movement
     */
    public boolean isBlockPassable() {
        return getExtent().isBlockPassable(getBlockPosition());
    }

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param direction The face of the block to check
     * @return Is flammable
     */
    public boolean isBlockFaceFlammable(Direction direction) {
        return getExtent().isBlockFlammable(getBlockPosition(), direction);
    }

    /**
     * Get a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @return A snapshot
     */
    public BlockSnapshot getBlockSnapshot() {
        return getExtent().getBlockSnapshot(getBlockPosition());
    }

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @return A list of ScheduledBlockUpdates on this block
     */
    public Collection<ScheduledBlockUpdate> getScheduledUpdates() {
        return getExtent().getScheduledUpdates(getBlockPosition());
    }

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    public ScheduledBlockUpdate addScheduledUpdate(int priority, int ticks) {
        return getExtent().addScheduledUpdate(getBlockPosition(), priority, ticks);
    }

    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.
     *
     * @param update The ScheduledBlockUpdate to remove
     */
    void removeScheduledUpdate(ScheduledBlockUpdate update) {
        getExtent().removeScheduledUpdate(getBlockPosition(), update);
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getData(Class<T> dataClass) {
        return getExtent().getData(getBlockPosition(), dataClass);
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getOrCreate(Class<T> manipulatorClass) {
        return getExtent().getOrCreate(getBlockPosition(), manipulatorClass);
    }

    @Override
    public <T extends DataManipulator<T>> boolean isCompatible(Class<T> manipulatorClass) {
        return getExtent().isCompatible(getBlockPosition(), manipulatorClass);
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(T manipulatorData) {
        return getExtent().offer(getBlockPosition(), manipulatorData);
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(T manipulatorData, DataPriority priority) {
        return getExtent().offer(getBlockPosition(), manipulatorData, priority);
    }

    @Override
    public Collection<DataManipulator<?>> getManipulators() {
        return getExtent().getManipulators(getBlockPosition());
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass) {
        return getExtent().getProperty(getBlockPosition(), propertyClass);
    }

    @Override
    public Collection<Property<?, ?>> getProperties() {
        return getExtent().getProperties(getBlockPosition());
    }

    @Override
    public boolean validateRawData(DataContainer container) {
        return getExtent().validateRawData(getBlockPosition(), container);
    }

    @Override
    public void setRawData(DataContainer container) throws InvalidDataException {
        getExtent().setRawData(getBlockPosition(), container);
    }

    @Override
    public DataContainer toContainer() {
        DataContainer container = new MemoryDataContainer();
        if (getExtent() instanceof World) {
            container.set(of("WorldName"), ((World) getExtent()).getName());
        }
        container.set(of("BlockType"), this.getExtent().getBlockType(getBlockPosition()).getId());
        container.set(of("x"), this.getX());
        container.set(of("y"), this.getY());
        container.set(of("z"), this.getZ());
        container.set(of("Manipulators"), getManipulators());
        return container;
    }
}
