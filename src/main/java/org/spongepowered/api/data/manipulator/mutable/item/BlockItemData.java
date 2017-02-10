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
package org.spongepowered.api.data.manipulator.mutable.item;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.item.ImmutableBlockItemData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An {@link DataManipulator} handling the {@link BlockState}
 * information for an {@link ItemStack} that is representing a
 * {@link BlockType}. Since the {@link BlockState} itself stores information
 * related to the actual block information, not all information can be
 * retrieved through the {@link ItemStack} itself.
 *
 * <p>Note that some block states have properties that are only defined by the
 * position the item block is placed. Some blocks may read some properties, and
 * others may not read all properties. {@link BlockState}s are not representing
 * complex data like inventories, if complex information is required, use a
 * different {@link DataManipulator} type.</p>
 */
public interface BlockItemData extends DataManipulator<BlockItemData, ImmutableBlockItemData> {

    /**
     * Gets the {@link Value} for the currently represented
     * {@link BlockState}.
     *
     * @return The value for the currently represented block state
     * @see Keys#ITEM_BLOCKSTATE
     */
    Value<BlockState> state();

}
