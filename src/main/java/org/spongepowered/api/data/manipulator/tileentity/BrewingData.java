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
package org.spongepowered.api.data.manipulator.tileentity;

import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.data.manipulator.IntData;

/**
 * Represents the information for a {@link BrewingStand}.
 */
public interface BrewingData extends IntData<BrewingData> {

    /**
     * Gets the remaining time until the brewing is complete. Will be zero if
     * the brewing stand is not currently brewing anything.
     *
     * @return The remaining time, in ticks
     */
    int getRemainingBrewTime();

    /**
     * Sets the remaining time until the brewing is complete. This will only
     * have effect if the current items within the brewing stand are valid.
     *
     * @param time The new remaining time, in ticks
     * @return This instance, for chaining
     */
    BrewingData setRemainingBrewTime(int time);

}
