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
package org.spongepowered.api.data.manipulator.immutable.item;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.item.BreakableData;
import org.spongepowered.api.data.value.immutable.ImmutableSetValue;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An {@link ImmutableDataManipulator} handling the list of {@link BlockType}s
 * that the {@link ItemStack} can physically break. Usually this mechanic is
 * only applicable to {@link Player}s when they are in a particular
 * {@link GameMode}. When the {@link ItemStack} dictates that it is able to
 * break a particular {@link BlockType}, other {@link BlockType}s can not be
 * broken by the same {@link ItemStack}.
 */
public interface ImmutableBreakableData extends ImmutableDataManipulator<ImmutableBreakableData, BreakableData> {

    /**
     * Gets the {@link ImmutableSetValue} for all known {@link BlockType}s that
     * can be broken by the owning {@link ItemStack}.
     *
     * @return The immutable set of block types that can be broken by the item
     *     stack
     */
    ImmutableSetValue<BlockType> breakable();

}
