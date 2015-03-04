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
package org.spongepowered.api.util.gen;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.world.extent.BlockVolume;

/**
 * A mutable buffer for {@link BlockType} data. This buffer has no direct relation
 * to the world and changes to it are not synchronized to the world.
 */
public interface MutableBlockBuffer extends BlockBuffer, BlockVolume {

    /**
     * Fills the entire buffer with the given block.
     *
     * @param block The block to fill with
     */
    void fill(BlockState block);

    /**
     * Sets all horizontal layers between {@code y} (inclusive) and 
     * {@code y+height} (exclusive) to the given block type.
     *
     * @param y The starting Y position
     * @param height The height
     * @param block The block type
     */
    void setHorizontalLayer(int y, int height, BlockState block);

    /**
     * Returns an immutable copy of this block buffer.
     *
     * @return An immutable copy
     */
    ImmutableBlockBuffer getImmutableClone();

}
