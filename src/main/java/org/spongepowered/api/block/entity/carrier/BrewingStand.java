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
package org.spongepowered.api.block.entity.carrier;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.util.Ticks;

/**
 * Represents a Brewing Stand.
 */
public interface BrewingStand extends NameableCarrierBlockEntity {

    /**
     * {@link Keys#FUEL}
     *
     * <p>Note 1 {@link ItemTypes#BLAZE_POWDER} supplies 20 fuel</p>
     *
     * @return The amount of fuel left in the brewing stand.
     */
    default Value.Mutable<Integer> fuel() {
        return this.requireValue(Keys.FUEL).asMutable();
    }

    /**
     * {@link Keys#REMAINING_BREW_TIME}
     * @return The remaining brewing time in ticks.
     */
    default Value.Mutable<Ticks> remainingBrewTime() {
        return this.requireValue(Keys.REMAINING_BREW_TIME).asMutable();
    }

    /**
     * Attempts to brew the current potions if possible.
     *
     * <p>This will work if there is a compatible recipe.</p>
     *
     * @return If the brew was successful
     */
    boolean brew();

}
