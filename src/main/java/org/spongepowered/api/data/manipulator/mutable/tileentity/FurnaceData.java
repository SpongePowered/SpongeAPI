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
package org.spongepowered.api.data.manipulator.mutable.tileentity;

import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableFurnaceData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents the data for a {@link Furnace}.
 */
public interface FurnaceData extends DataManipulator<FurnaceData, ImmutableFurnaceData> {

    /**
     * Gets the {@link MutableBoundedValue} for the already passed burn time of
     * the {@link Furnace}. When this is equal to the {@link #maxBurnTime()},
     * the current used fuel is depleted.
     *
     * @return The value for the already passed burn time
     * @see Keys#PASSED_BURN_TIME
     */
    MutableBoundedValue<Integer> passedBurnTime();

    /**
     * Gets the {@link MutableBoundedValue} for the maximum amount of fuel that
     * can be supplied with the used fuel item.
     *
     * <p>This is represented by the flame icon in the {@link Furnace}, if the
     * flame is 100% filled the value is exactly this one. So its the maximum
     * of the {@link #passedBurnTime()}.</p>
     *
     * @return The value for the maximum amount of fuel that can be supplied
     *     with the used fuel item
     * @see Keys#MAX_BURN_TIME
     */
    MutableBoundedValue<Integer> maxBurnTime();

    /**
     * Gets the {@link MutableBoundedValue} for the already passed cook time of
     * the {@link ItemStack} in the {@link Furnace}. When this is equal to the
     * {@link #maxCookTime()}, the {@link ItemStack} is cooked.
     *
     * @return The value for the already passed cook time
     * @see Keys#PASSED_COOK_TIME
     */
    MutableBoundedValue<Integer> passedCookTime();

    /**
     * Gets the {@link MutableBoundedValue} for the total time the
     * {@link ItemStack} has to cook until it is cooked.
     *
     * <p>This is represented by the arrow icon in the {@link Furnace}, if the
     * arrow is 100% filled the value is exact this one. So its the maximum of
     * the {@link #passedCookTime()}.</p>
     *
     * @return The value for the time the item has to cook
     * @see Keys#MAX_COOK_TIME
     */
    MutableBoundedValue<Integer> maxCookTime();
}
