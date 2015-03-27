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
package org.spongepowered.api.item.data;

import org.spongepowered.api.block.BlockState;

/**
 * Represents data about a block being represented by this item data. Since
 * blocks are not itemstacks, but an itemstack can place a block,
 * some blocks even have custom states: {@link BlockState}. With a block
 * state, it is possible to change the signature of an item for any reason.
 *
 * <p>Note that some block states have properties that are only defined by the
 * position the item block is placed. Some blocks may read some properties, and
 * others may not read all properties.</p>
 *
 * <p>{@link BlockState}s are not representing complex data like inventories,
 * if complex information is required, use a different {@link ItemData}
 * type.</p>
 */
public interface BlockItemData extends ItemData<BlockItemData> {

    /**
     * Gets the block state of this item representing a block.
     *
     * <p>The {@link BlockState} is immutable, to change the block
     * state, use {@link #setState(BlockState)}.</p>
     *
     * @return The current blockstate represented by this item
     */
    BlockState getState();

    /**
     * Sets the block state of the block being represented by this item
     * data.
     *
     * <p>Since {@link BlockState}s are immutable (they return a new
     * {@link BlockState} on modification), the block state used here is
     * also immutable and applied directly to the item.</p>
     *
     * <p>It should be noted that the block type should be the same as the
     * item type referenced on the item stack.</p>
     *
     * @param state The new block state of the block
     */
    void setState(BlockState state);

}
