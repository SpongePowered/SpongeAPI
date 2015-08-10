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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.item.ImmutableBreakableData;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents an editable collection of {@link BlockType}s that can
 * be broken with this item. This data usually refers to blocks that can be
 * broken only when a human is in adventure mode.
 *
 * <p>Normally, when players are in survival gamemode, they can edit blocks
 * without needing to know the item is able to break said block. However, when
 * the player is in a gamemode like adventure, they loose the ability to edit
 * blocks unless the item has this type of {@link BreakableData} to note
 * which {@link BlockType}s can be broken with that item.</p>
 */
public interface BreakableData extends DataManipulator<BreakableData, ImmutableBreakableData> {

    /**
     * Gets the {@link SetValue} for all known {@link BlockType}s that
     * can be broken by the owning {@link ItemStack}.
     *
     * @return The immutable set of block types that can be broken by the item
     *     stack
     */
    SetValue<BlockType> breakable();

}
