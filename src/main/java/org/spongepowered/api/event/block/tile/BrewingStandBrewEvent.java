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
package org.spongepowered.api.event.block.tile;

import org.spongepowered.api.block.tile.carrier.BrewingStand;
import org.spongepowered.api.event.inventory.BulkItemResultEvent;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.List;

/**
 * An event when a {@link BrewingStand} freshly brews {@link ItemStack}s into new potions.
 */
public interface BrewingStandBrewEvent extends BrewingStandEvent, BulkItemResultEvent {

    /**
     * Gets the orignal {@link ItemStack}s that were being brewed.
     *
     * @return The original item stacks
     */
    List<ItemStack> getSourceItems();

    /**
     * Gets the fuel source being brewed into the source items.
     *
     * @return The fuel source being brewed into the source items
     */
    ItemStack getFuelSource();

    /**
     * Gets the final brewed items.
     *
     * @return The resulting brewed items
     */
    List<ItemStack> getBrewedItems();

    /**
     * Sets the final brewed items.
     *
     * <p>Note that the brewed items must not exceed the inventory size of the {@link BrewingStand}.</p>
     *
     * @param items The newly brewed items
     */
    void setBrewedItems(List<ItemStack> items);
}
