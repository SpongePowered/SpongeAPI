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
package org.spongepowered.api.item.merchant;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.entity.TradeOfferData;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.item.inventory.Carrier;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a Merchant which can offer trades to customers.
 */
public interface Merchant extends DataHolder, Carrier {

    /**
     * Gets the currently trading customer with this merchant.
     *
     * @return The currently trading customer if available
     */
    Optional<Humanoid> getCustomer();

    /**
     * Sets the currently trading customer with this merchant.
     * <p>If the humanoid entity is available, a new trading window may open
     * with this merchant.</p>
     *
     * @param humanoid The humanoid to trade with
     */
    void setCustomer(@Nullable Humanoid humanoid);

    /**
     * Gets a copy of the used {@link TradeOfferData} containing all available
     * {@link TradeOffer}s this {@link Merchant} may use.
     *
     * @return A copy of the trade offer data
     */
    default TradeOfferData getTradeOfferData() {
        return get(TradeOfferData.class).get();
    }

}
