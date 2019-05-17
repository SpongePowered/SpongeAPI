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

import org.spongepowered.api.block.entity.carrier.cooker.CookingBlockEntity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.item.inventory.AffectItemStackEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;

import java.util.List;

public interface CookEvent extends Event {

    /**
     * Gets the {@link CookingBlockEntity}.
     *
     * @return The cooker
     */
    CookingBlockEntity getCooker();

    /**
     * Gets the {@link Recipe} used by the cooker.
     *
     * @return The recipe
     */
    CookingRecipe getRecipe();

    interface Start extends CookEvent, AffectItemStackEvent, Cancellable {}

    interface Tick extends CookEvent, AffectItemStackEvent, Cancellable {}

    interface Finish extends CookEvent {

        /**
         * Gets an immutable {@link List} of {@link ItemStackSnapshot}s that are the
         * result of the cook.
         *
         * @return The items
         */
        List<ItemStackSnapshot> getCookedItems();
    }
}
