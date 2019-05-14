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

import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.event.item.inventory.AffectItemStackEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;

public interface SmeltEvent extends TargetTileEntityEvent {

    @Override
    Furnace getTargetTile();

    /**
     * Gets the fuel represented as an {@link ItemStackSnapshot}.
     *
     * @return The ingredient
     */
    ItemStackSnapshot getFuel();

    /**
     * The first tick of an item smelting.
     * Note that actually no stacks are affected when starting to smelt.
     */
    interface Start extends SmeltEvent, AffectItemStackEvent {}

    /**
     * Fires whenever fuel is consumed to refill the current burn time.
     * Canceling this event prevents fuel from being consumed in a furnace In the current burn time to 0.
     */
    interface ConsumeFuel extends SmeltEvent, AffectItemStackEvent {}

    /**
     * The smelting timer ticking up or down.
     * Note that actually no stacks are affected when ticking.
     */
    interface Tick extends SmeltEvent, AffectItemStackEvent {}

    /**
     * Fires when the smelting is interrupted causing the current smelting time to reset to 0.
     */
    interface Interrupt extends SmeltEvent {
        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the result
         * of the smelt.
         * @return The smelt items
         *
         * @deprecated always empty
         */
        @Deprecated
        List<ItemStackSnapshot> getSmeltedItems();
    }

    interface Finish extends SmeltEvent {
        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the result of the smelt.
         * Always exactly one item.
         *
         * @return The smelt items
         */
        List<ItemStackSnapshot> getSmeltedItems();
    }
}
