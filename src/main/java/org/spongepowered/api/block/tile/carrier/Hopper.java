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

package org.spongepowered.api.block.tile.carrier;

import org.spongepowered.api.block.tile.TileDataTransactionResult;
import org.spongepowered.api.block.tile.data.HopperData;

/**
 * Represents a Hopper.
 */
public interface Hopper extends TileEntityCarrier {

    /**
     * Requests this {@link Hopper} to transfer an item to the next carrier.
     *
     * <p>Since {@link Hopper}s normally send items to other {@link
     * TileEntityCarrier}s adjacent to themselves, if there is no available
     * carrier to send an item to, this will perform nothing.</p>
     */
    void transferItem();

    /**
     * Gets the current {@link HopperData} of this hopper.
     *
     * <p>Note that as time goes on, the {@link HopperData} may not remain in
     * sync with the {@link Hopper} tile entity. It is advisable that a
     * {@link HopperData} is manipulated in the same tick that it is
     * retrieved.</p>
     *
     * @return The currently associated {@link HopperData}
     */
    HopperData getHopperData();

    /**
     * Sets the given {@link HopperData} onto this {@link Hopper}.

     * <p>Validation is performed on the {@link HopperData} to ensure the
     * desired data is properly set.</p>

     * @param data The hopper data to set
     * @return The transaction result
     */
    TileDataTransactionResult setHopperData(HopperData data);
}
