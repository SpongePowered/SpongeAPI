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
package org.spongepowered.api.event.source.block;

import org.spongepowered.api.block.BlockState;

/**
 * Called when a {@link BlockState} changes the power level of another
 * {@link BlockState}.
 *
 * <p>ie. Redstone updating a power level of another BlockState</p>
 */
public interface BlockUpdateBlockPowerEvent extends BlockUpdateNeighborBlockEvent {

    /**
     * Gets the signal strength of the {@link BlockState} prior to event.
     *
     * @return The old signal strength
     */
    int getOriginalSignalStrength();

    /**
     * Gets the signal strength that the {@link BlockState} will be at after event resolution.
     *
     * @return The new signal strength
     */
    int getSignalStrength();

    /**
     * Sets the signal strength that the {@link BlockState} will be at after event resolution.
     *
     * @param newSignalStrength The new signal strength.
     */
    void setSignalStrength(int newSignalStrength);

}
