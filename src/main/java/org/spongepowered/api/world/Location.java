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

package org.spongepowered.api.world;

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.persistence.data.DataHolder;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

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
public class Location implements DataHolder {

    private final Extent extent;
    private final Vector3d position;
    private final Vector3i blockPosition;

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param position The position
     */
    public Location(Extent extent, Vector3d position) {
        checkNotNull(extent);
        checkNotNull(position);
        this.extent = extent;
        this.position = position;
        this.blockPosition = position.floor().toInt();
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
        return this.position;
    }

    /**
     * Get the underlying block position.
     *
     * @return The underlying block position
     */
    public Vector3i getBlockPosition() {
        return this.blockPosition;
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
     * Create a new instance with a new extent.
     *
     * @param extent The new extent
     * @return A new instance
     */
    public Location setExtent(Extent extent) {
        checkNotNull(extent);
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
        checkNotNull(position);
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
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    public BlockType getType() {
        return getExtent().getBlockType(getBlockPosition());
    }

    /**
     * Get the block state for this position.
     *
     * @return The current block state
     */
    public BlockState getState() {
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
     * Replace the block state at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     */
    public void replaceWith(BlockState state) {
        getExtent().setBlock(getBlockPosition(), state);
    }

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     */
    public void replaceWith(BlockType type) {
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
    public void replaceWith(BlockSnapshot snapshot) {
        getExtent().setBlockSnapshot(getBlockPosition(), snapshot);
    }

    /**
     * Remove the block at this position by replacing it with {@link BlockTypes#AIR}.
     *
     * <p>This will remove any extended block data at the given position.</p>
     */
    @SuppressWarnings("ConstantConditions")
    void remove() {
        getExtent().setBlockType(getBlockPosition(), BlockTypes.AIR);
    }

    /**
     * Simulates the interaction with this object as if a player had done so.
     */
    public void interact() {
        getExtent().interactBlock(getBlockPosition());
    }

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param itemStack The item
     */
    public void interactWith(ItemStack itemStack) {
        getExtent().interactBlockWith(getBlockPosition(), itemStack);
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @return Whether the block was destroyed
     */
    public boolean dig() {
        return getExtent().digBlock(getBlockPosition());
    }

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    public boolean digWith(ItemStack itemStack) {
        return getExtent().digBlockWith(getBlockPosition(), itemStack);
    }

    /**
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @return The time in ticks
     */
    public int getDigTime() {
        return getExtent().getBlockDigTime(getBlockPosition());
    }

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    public int getDigTimeWith(ItemStack itemStack) {
        return getExtent().getBlockDigTimeWith(getBlockPosition(), itemStack);
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
    public boolean isPowered() {
        return getExtent().isBlockPowered(getBlockPosition());
    }

    /**
     * Test whether the object is indirectly powered.
     *
     * @return Whether powered
     */
    public boolean isIndirectlyPowered() {
        return getExtent().isBlockPowered(getBlockPosition());
    }

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isFacePowered(Direction direction) {
        return getExtent().isBlockFacePowered(getBlockPosition(), direction);
    }

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isFaceIndirectlyPowered(Direction direction) {
        return getExtent().isBlockFaceIndirectlyPowered(getBlockPosition(), direction);
    }

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @return Faces powered
     */
    public Collection<Direction> getPoweredFaces() {
        return getExtent().getPoweredBlockFaces(getBlockPosition());
    }

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @return Faces indirectly powered
     */
    public Collection<Direction> getIndirectlyPoweredFaces() {
        return getExtent().getIndirectlyPoweredBlockFaces(getBlockPosition());
    }

    /**
     * Test whether the the block will block the movement of entities.
     *
     * @return Blocks movement
     */
    public boolean isPassable() {
        return getExtent().isBlockPassable(getBlockPosition());
    }

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param direction The face of the block to check
     * @return Is flammable
     */
    public boolean isFaceFlammable(Direction direction) {
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
    public BlockSnapshot getSnapshot() {
        return getExtent().getBlockSnapshot(getBlockPosition());
    }

    @Override
    public <T> Optional<T> getData(Class<T> dataClass) {
        return getExtent().getBlockData(getBlockPosition(), dataClass);
    }

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @return A list of ScheduledBlockUpdates on this block
     */
    Collection<ScheduledBlockUpdate> getScheduledUpdates() {
        return getExtent().getScheduledUpdates(getBlockPosition());
    }

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledBlockUpdate addScheduledUpdate(int priority, int ticks) {
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

}
