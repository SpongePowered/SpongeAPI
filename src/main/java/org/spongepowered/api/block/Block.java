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

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.math.Vector3i;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * Represents a block at a specific location in an {@link Extent}.
 */
public interface Block extends BlockState {

    /**
     * Get the extent.
     *
     * @return The extent
     */
    Extent getExtent();

    /**
     * Get the position of the block.
     *
     * @return The position
     */
    Vector3i getPosition();

    /**
     * Get the location of the block.
     *
     * @return The location
     */
    Location getLocation();

    /**
     * Get the X component of this block instance's position.
     *
     * @return The x component
     */
    int getX();

    /**
     * Get the Y component of this block instance's position.
     *
     * @return The y component
     */
    int getY();

    /**
     * Get the Z component of this block instance's position.
     *
     * @return The z component
     */
    int getZ();

    /**
     * Replace the block at this position by with a new block with the same
     * type but a different data value.
     *
     * <p>This will remove any block data at the given position.</p>
     *
     * @param data The new data value
     * @see BlockState#getDataValue()
     * @deprecated Minecraft is phasing out data values
     */
    @Deprecated
    void replaceData(byte data);

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any block data at the given position.</p>
     *
     * @param type The new type
     */
    void replaceWith(BlockType type);

    /**
     * Replace the block at this position with a copy of the given snapshot.
     *
     * <p>Changing the snapshot afterwards will not affect the block that
     * has been placed at this location.</p>
     *
     * @param snapshot The snapshot
     */
    void replaceWith(BlockSnapshot snapshot);

    /**
     * Simulates the interaction with this object as if a player had done so.
     */
    void interact();

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param itemStack The item
     */
    void interactWith(ItemStack itemStack);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @return Whether the block was destroyed
     */
    boolean dig();

    /**
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    boolean digWith(ItemStack itemStack);

    /**
     * Get the light level for this object.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance();

    /**
     * Get the light level for this object that is caused by an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromSky();

    /**
     * Get the light level for this object that is caused by everything
     * other than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromGround();

    /**
     * Test whether the object is powered.
     *
     * @return Whether powered
     */
    boolean isPowered();

    /**
     * Test whether the object is indirectly powered.
     *
     * @return Whether powered
     */
    boolean isIndirectlyPowered();

    /**
     * Test whether the face in the given direction is powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    boolean isFacePowered(Direction direction);

    /**
     * Test whether the face in the given direction is indirectly powered.
     *
     * @param direction The direction
     * @return Whether powered
     */
    boolean isFaceIndirectlyPowered(Direction direction);
}
