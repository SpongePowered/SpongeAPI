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
package org.spongepowered.api.event.block.tile;

import org.spongepowered.api.block.tile.carrier.Furnace;
import org.spongepowered.api.event.inventory.ItemResultEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.event.Cancellable;

/**
 * An event that occurs when a {@link Furnace} smelt an item.
 */
public interface FurnaceSmeltItemEvent extends FurnaceEvent, ItemResultEvent, Cancellable {

    /**
     * Gets the freshly cooked {@link ItemStack}.
     *
     * <p>A {@link Furnace} cooks {@link ItemStack}s with fuel and produces
     * new items.</p>
     *
     * @return The cooked item
     */
    ItemStack getCookedItem();

    /**
     * Sets the cooked {@link ItemStack}.
     *
     * <p>A {@link Furnace} cooks {@link ItemStack}s with fuel and produces
     * new items.</p>
     *
     * @param item The resulting cooked item
     */
    void setCookedItem(ItemStack item);

    /**
     * Gets the source {@link ItemStack} that was cooked.
     *
     * @return The source item
     */
    ItemStack getSourceItem();

}
