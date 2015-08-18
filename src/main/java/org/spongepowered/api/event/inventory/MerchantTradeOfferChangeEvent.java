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

package org.spongepowered.api.event.inventory;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.item.merchant.Merchant;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.List;

/**
 * Called when a {@link Merchant} changes his {@link TradeOffer}s.
 */
public interface MerchantTradeOfferChangeEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets the {@link Merchant} involved involved in this event.
     *
     * @return The villager involved
     */
    Merchant getMerchant();

    /**
     * Gets an immutable list of {@link TradeOffer}s the merchant had before.
     *
     * @return A list of trade offers the merchant had before
     */
    List<TradeOffer> getOldTradeOffers();

    /**
     * Gets an immutable list of {@link TradeOffer}s the merchant had before.
     *
     * @return A list of trade offers the merchant had before
     */
    List<TradeOffer> getNewTradeOffers();

    /**
     * Sets a list of trade offers the merchant should have.
     *
     * @param offers A list of trade offers the merchant should have
     */
    void setNewTradeOffers(List<TradeOffer> offers);

}
