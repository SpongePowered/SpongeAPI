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
package org.spongepowered.api.event.block.tileentity;

import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.event.item.inventory.AffectItemStackEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;

/**
 * Fires during the brewing process where {@link ItemStack}s are brewed into different {@link ItemStack}s
 * based on an ingredient which is also an {@link ItemStack} within a {@link BrewingStand}.
 */
public interface BrewingEvent extends TargetTileEntityEvent {

    @Override
    BrewingStand getTargetTile();

    /**
     * Gets the {@link ItemStackSnapshot} as the ingredient used.
     *
     * @return The ingredient
     */
    ItemStackSnapshot getIngredient();

    interface Start extends BrewingEvent, AffectItemStackEvent {}

    interface Tick extends BrewingEvent, AffectItemStackEvent {}

    interface Interrupt extends BrewingEvent {
        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the result
         * of the brew.
         * @return The brewed items
         */
        List<ItemStackSnapshot> getBrewedItemStacks();
    }

    interface Finish extends BrewingEvent {

        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the result
         * of the brew.
         * @return The brewed items
         */
        List<ItemStackSnapshot> getBrewedItemStacks();
    }
}
