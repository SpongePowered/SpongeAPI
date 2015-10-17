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
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableFurnaceData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;

/**
 * Represents the data for a {@link Furnace}.
 */
public interface FurnaceData extends DataManipulator<FurnaceData, ImmutableFurnaceData> {

    /**
     * Gets the {@link MutableBoundedValue} for the remaining burn time of the {@link Furnace}.
     *
     * @return The value for the remaining burn time
     */
    MutableBoundedValue<Integer> remainingBurnTime();

    /**
     * Gets the {@link MutableBoundedValue} for the remaining cook time of the {@link Furnace}.
     *
     * The {@link #remainingCookTime()} is the subtraction of the {@link #maxCookTime()} and the
     * time the item already cooked.
     *
     * @return The value for the remaining cook time
     */
    MutableBoundedValue<Integer> remainingCookTime();

    /**
     * Gets the {@link MutableBoundedValue} for the cook time of the {@link
     * org.spongepowered.api.entity.Item} that should be cooked.
     *
     * Its named "maxCookTime" because the client calculate the {@link #remainingCookTime()} from
     * the "maxCookTime" minus the time the item cooked already. So this value it the maximum of the
     * {@link #remainingCookTime()}
     *
     * @return The value for the maximum cook time
     */
    MutableBoundedValue<Integer> maxCookTime();

}
