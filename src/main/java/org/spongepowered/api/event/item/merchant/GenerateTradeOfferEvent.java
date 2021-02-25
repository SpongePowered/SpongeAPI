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
package org.spongepowered.api.event.item.merchant;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.merchant.Merchant;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.List;

public interface GenerateTradeOfferEvent extends Event {

    /**
     * Gets the {@link Merchant owner} of the trade offers.
     *
     * @return The owner getting a trade offer added
     */
    Merchant getMerchant();

    /**
     * Gets the current unmodifiable list of {@link TradeOffer trade offers}
     * available from the {@link Merchant owner}. Note that it is not available
     * to be modified by {@link org.spongepowered.api.data.Keys#TRADE_OFFERS}
     *
     * @return The unmodifiable list of trade offers
     */
    List<TradeOffer> getTradeOffers();

    interface Propose extends GenerateTradeOfferEvent, Cancellable {

        /**
         * Gets the {@link Transaction} of the {@link TradeOffer} that is being
         * added to the {@link #getTradeOffers() list of offers} available. As
         * expected, whether the event is cancelled with {@link #setCancelled(boolean)}
         * or {@link Transaction#invalidate()}, the {@link TradeOffer} is only
         * added if the transaction is valid and the event is not cancelled.
         * <p>Proposing a new {@link TradeOffer} by
         * {@link Transaction#setCustom(DataSerializable) Transaction.setCustom(TradeOffer)}
         * will replace the trade offer and still be added to the resulting
         * list.
         *
         * @return The trade offer transaction
         */
        Transaction<TradeOffer> getTradeOffer();

    }

    interface Post extends GenerateTradeOfferEvent {

        /**
         * Gets the {@link TradeOffer} being added to the list.
         *
         * @return The trade offer being added
         */
        TradeOffer getTradeOfferAdded();

    }

}
