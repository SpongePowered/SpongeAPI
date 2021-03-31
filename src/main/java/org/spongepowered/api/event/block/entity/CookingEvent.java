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
package org.spongepowered.api.event.block.entity;

import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.item.inventory.AffectItemStackEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;

import java.util.List;
import java.util.Optional;

/**
 * Events for cooking items in a {@link org.spongepowered.api.block.entity.carrier.furnace.FurnaceBlockEntity}
 * or {@link org.spongepowered.api.block.entity.carrier.Campfire}.
 */
public interface CookingEvent extends Event {

    /**
     * Gets the {@link BlockEntity} used for cooking.
     *
     * @return The furnace
     */
    BlockEntity blockEntity();

    /**
     * Gets the fuel represented as an {@link ItemStackSnapshot}.
     *
     * @return The ingredient
     */
    Optional<ItemStackSnapshot> fuel();

    /**
     * Gets the recipe currently active.
     * <p>Always {@link Optional#empty()} for {@link CookingEvent.Interrupt}</p>
     *
     * @return The recipe
     */
    Optional<CookingRecipe> recipe();

    /**
     * The first tick of an item cooking.
     * Note that actually no stacks are affected when starting to cook.
     */
    interface Start extends CookingEvent, AffectItemStackEvent {}

    /**
     * Fires whenever fuel is consumed to refill the current burn time.
     * Canceling this event prevents fuel from being consumed in a furnace In the current burn time to 0.
     */
    interface ConsumeFuel extends CookingEvent, AffectItemStackEvent {}

    /**
     * The cooking timer ticking up or down.
     * Note that actually no stacks are affected when ticking.
     */
    interface Tick extends CookingEvent, AffectItemStackEvent {}

    /**
     * Fires when the cooking is interrupted causing the current cooking time to reset to 0.
     */
    interface Interrupt extends CookingEvent {
    }

    interface Finish extends CookingEvent {
        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the result of the cooking.
         * Always exactly one item.
         *
         * @return The cooked items
         */
        List<ItemStackSnapshot> cookedItems();
    }
}
