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

package org.spongepowered.api.block;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.persistence.data.DataHolder;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents a block at a specific location in an {@link Extent}.
 *
 * <p>A {@code BlockLoc} is <strong>not</strong> a copy of a block's data.
 * The type of block a {@code BlockLoc} refers to can change over time. To
 * get a copy of the block's data, use {@link #getSnapshot()}.</p>
 *
 * <p>Instances are immutable, however, so they will never refer to
 * a different location.</p>
 */
public class BlockLoc implements DataHolder {

    private final Extent extent;
    private final Vector3i position;

    /**
     * Create a new instance
     *
     * @param extent The underlying extent
     * @param position The position of the block
     */
    public BlockLoc(Extent extent, Vector3i position) {
        checkNotNull(extent, "extent");
        checkNotNull(position, "position");
        this.extent = extent;
        this.position = position;
    }

    /**
     * Get the extent that the block that is referred to resides within.
     *
     * @return The extent
     */
    public Extent getExtent() {
        return extent;
    }

    /**
     * Get the position of the block.
     *
     * @return The position
     */
    public Vector3i getPosition() {
        return position;
    }

    /**
     * Get the location of the block.
     *
     * @return The location
     */
    public Location getLocation() {
        return new Location(getExtent(), getPosition().toDouble());
    }

    /**
     * Get the X component of this block instance's position.
     *
     * @return The x component
     */
    public int getX() {
        return getPosition().getX();
    }

    /**
     * Get the Y component of this block instance's position.
     *
     * @return The y component
     */
    public int getY() {
        return getPosition().getY();
    }

    /**
     * Get the Z component of this block instance's position.
     *
     * @return The z component
     */
    public int getZ() {
        return getPosition().getZ();
    }

    /**
     * Gets the block in the given direction of this block.
     *
     * @param direction The direction to look in
     * @return The block in that direction
     */
    public BlockLoc getRelative(Direction direction) {
        return new BlockLoc(getExtent(), getPosition().add(direction.toVector3d().toInt()));
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
        return getExtent().getBlockType(getPosition());
    }

    /**
     * Get the block state for this position.
     *
     * @return The current block state
     */
    public BlockState getState() {
        return getExtent().getBlockState(getPosition());
    }

    /**
     * Replace the block state at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     */
    public void replaceWith(BlockState state) {
        getExtent().setBlockState(getPosition(), state);
    }

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     */
    public void replaceWith(BlockType type) {
        getExtent().setBlockType(getPosition(), type);
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
        getExtent().setBlockSnapshot(getPosition(), snapshot);
    }

    /**
     * Simulates the interaction with this object as if a player had done so.
     */
    public void interact() {
        getExtent().interactBlock(getPosition());
    }

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param itemStack The item
     */
    public void interactWith(ItemStack itemStack) {
        getExtent().interactBlockWith(getPosition(), itemStack);
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @return Whether the block was destroyed
     */
    public boolean dig() {
        return getExtent().digBlock(getPosition());
    }

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    public boolean digWith(ItemStack itemStack) {
        return getExtent().digBlockWith(getPosition(), itemStack);
    }

    /**
     * Gets the time it takes to dig this block with a fist in ticks.
     *
     * @return The time in ticks
     */
    public int getDigTime() {
        return getExtent().getBlockDigTime(getPosition());
    }

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    public int getDigTimeWith(ItemStack itemStack) {
        return getExtent().getBlockDigTimeWith(getPosition(), itemStack);
    }

    /**
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    public byte getLuminance() {
        return getExtent().getLuminance(getPosition());
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
        return getExtent().getLuminanceFromSky(getPosition());
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
        return getExtent().getLuminanceFromGround(getPosition());
    }

    /**
     * Test whether the object is powered.
     *
     * @return Whether powered
     */
    public boolean isPowered() {
        return getExtent().isBlockPowered(getPosition());
    }

    /**
     * Test whether the object is indirectly powered.
     *
     * @return Whether powered
     */
    public boolean isIndirectlyPowered() {
        return getExtent().isBlockPowered(getPosition());
    }

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isFacePowered(Direction direction) {
        return getExtent().isBlockFacePowered(getPosition(), direction);
    }

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    public boolean isFaceIndirectlyPowered(Direction direction) {
        return getExtent().isBlockFaceIndirectlyPowered(getPosition(), direction);
    }

    /**
     * Get all the faces of this block that are directly powered.
     *
     * @return Faces powered
     */
    public Collection<Direction> getPoweredFaces() {
        return getExtent().getPoweredBlockFaces(getPosition());
    }

    /**
     * Get all faces of this block that are indirectly powered.
     *
     * @return Faces indirectly powered
     */
    public Collection<Direction> getIndirectlyPoweredFaces() {
        return getExtent().getIndirectlyPoweredBlockFaces(getPosition());
    }

    /**
     * Test whether the the block will block the movement of entities.
     *
     * @return Blocks movement
     */
    public boolean isPassable() {
        return getExtent().isBlockPassable(getPosition());
    }

    /**
     * Test whether the given face of the block can catch fire.
     *
     * @param direction The face of the block to check
     * @return Is flammable
     */
    public boolean isFaceFlammable(Direction direction) {
        return getExtent().isBlockFlammable(getPosition(), direction);
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
        return getExtent().getBlockSnapshot(getPosition());
    }

    @Override
    public <T> Optional<T> getData(Class<T> dataClass) {
        return getExtent().getBlockData(getPosition(), dataClass);
    }

}
