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

import org.spongepowered.api.component.attribute.Powerable;
import org.spongepowered.api.math.Vector3i;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * Represents a block at a specific location in an {@link Extent}.
 */
public interface Block extends BlockState, Powerable {

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
     * Get the light level for this block.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance();

    /**
     * Get the light level for this block that is caused by an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromSky();

    /**
     * Get the light level for this block that is caused by everything
     * other than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromGround();

}
