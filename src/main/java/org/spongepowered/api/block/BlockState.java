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

import org.spongepowered.api.world.extent.Extent;

/**
 * Represents a block with type and data.
 */
public interface BlockState {

    /**
     * Get the base type of block.
     *
     * <p>The base type does not include variants (yet) because some blocks
     * are differentiated using a data value. In the future, the type will
     * be a full representation of the variant of a block.</p>
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     * @see #getDataValue() For extra differentiation
     */
    BlockType getType();

    /**
     * Get the data value of the block at the given position.
     *
     * <p>The data value is a number between 0 and 15 (inclusive) that
     * represents a value for differentiation with certain blocks. For example,
     * the base dirt block has a data value that changes the variant of dirt.
     * The base data value is generally 0.</p>
     *
     * <p>However, be aware that data values are being deprecated in
     * Minecraft because they are a waste of bytes and add extra complexity to
     * block differentiation. Most blocks don't use a data value, so that's
     * a waste of four bits of data per block. In the future, there will
     * only be <em>one</em> number to represent each 'state' of a block.</p>
     *
     * @return The data value
     * @deprecated Being removed from Minecraft
     */
    @Deprecated
    byte getDataValue();

    /**
     * Get a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was
     * taken from so changes to the original block do not affect the
     * snapshot.</p>
     *
     * @return A snapshot
     */
    BlockSnapshot getSnapshot();

}
