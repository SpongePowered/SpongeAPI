/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.block.tile.data;

import org.spongepowered.api.block.tile.carrier.Furnace;

/**
 * Represents the usable data of a {@link Furnace}.
 */
public interface FurnaceData extends TileEntityData<Furnace, FurnaceData> {

    /**
     * Gets the remaining time until another piece of fuel will be consumed.
     * Will be zero if the furnace is not currently lit.
     *
     * @return The remaining time, in ticks
     */
    int getRemainingBurnTime();

    /**
     * Sets the remaining time until a new piece of fuel will be consumed.
     *
     * @param time The new time, in ticks
     */
    void setRemainingBurnTime(int time);

    /**
     * Gets the remaining time until the next item is cooked.
     *
     * @return The remaining time, in ticks
     */
    int getRemainingCookTime();

    /**
     * Sets the remaining time until a new item is cooked.
     *
     * @param time The new time, in ticks
     */
    void setRemainingCookTime(int time);

}
