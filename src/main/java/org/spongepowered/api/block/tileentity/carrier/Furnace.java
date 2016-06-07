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
package org.spongepowered.api.block.tileentity.carrier;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.tileentity.FurnaceData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;

/**
 * Represents a Furnace.
 */
public interface Furnace extends TileEntityCarrier {

    /**
     * Attempts to smelt the current items if possible.
     *
     * <p>This will work if there is a compatible recipe.</p>
     *
     * @return If the smelt was successful
     */
    boolean smelt();

    /**
     * Gets this furnace's {@link FurnaceData}.
     *
     * @return The furnace data
     */
    default FurnaceData getFurnaceData() {
        return get(FurnaceData.class).get();
    }

    /**
     * Gets the {@link MutableBoundedValue} for the already passed burn time.
     *
     * @return The value for the already passed burn time
     * @see FurnaceData#passedBurnTime
     */
    default MutableBoundedValue<Integer> passedBurnTime() {
        return getValue(Keys.PASSED_BURN_TIME).get();
    }

    /**
     * Gets the {@link MutableBoundedValue} for the maximum amount of fuel that
     * can be supplied with the used fuel item.
     *
     * @return The value for the maximum amount of fuel that can be supplied
     *         with the used fuel item
     * @see FurnaceData#maxBurnTime
     */
    default MutableBoundedValue<Integer> maxBurnTime() {
        return getValue(Keys.MAX_BURN_TIME).get();
    }

    /**
     * Gets the {@link MutableBoundedValue} for the already passed cook time of
     * the item stack in this furnace.
     *
     * @return The value for the already passed cook time
     * @see FurnaceData#passedCookTime
     */
    default MutableBoundedValue<Integer> passedCookTime() {
        return getValue(Keys.PASSED_COOK_TIME).get();
    }

    /**
     * Gets the {@link MutableBoundedValue} for the total time the item stack
     * has to cook until it is cooked.
     *
     * @return The value for the time the item has to cook
     * @see FurnaceData#maxCookTime
     */
    default MutableBoundedValue<Integer> maxCookTime() {
        return getValue(Keys.MAX_COOK_TIME).get();
    }

}
