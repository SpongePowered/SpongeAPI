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

import org.spongepowered.api.block.Block;
import org.spongepowered.api.math.Vector3i;

/**
 * A volume containing blocks.
 */
public interface BlockVolume {

    /**
     * Get the block (type) at the given position.
     *
     * <p>If the position is outside the bounds of the volume, the behavior
     * is undefined. Implementations may return "air" as the given block, but
     * may also return any other valid block.</p>
     *
     * @param position The position
     * @return The block type
     */
    Block getBlock(Vector3i position);

    /**
     * Set the block (type) at the given location.
     *
     * <p>If the position is outside the bounds of the volume, then no change
     * should occur and {@code false] should be returned.</p>
     *
     * @param position The position
     * @param block The block type
     * @return True if a change potentially occurred
     */
    boolean setBlock(Vector3i position, Block block);

    /**
     * Get the light level at the given location.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminance(Vector3i position);

    /**
     * Get the light level at the given location that is caused by
     * an overhead sky.
     *
     * <p>Higher levels indicate a higher luminance. If no sky is overheard,
     * the return value may be 0.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromSky(Vector3i position);

    /**
     * Get the light level at the given location that is caused by everything
     * other than the sky.
     *
     * <p>Higher levels indicate a higher luminance.</p>
     *
     * @return A light level, nominally between 0 and 15, inclusive
     */
    byte getLuminanceFromGround(Vector3i position);

}
