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
package org.spongepowered.api.item.merchant;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.item.inventory.Carrier;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Represents a Merchant which can offer trades to customers.
 */
public interface Merchant extends Carrier {

    /**
     * Gets the currently trading customer with this merchant.
     *
     * @return The currently trading customer if available
     */
    Optional<Human> getCustomer();

    /**
     * Sets the currently trading customer with this merchant.
     * <p>If the human entity is available, a new trading window may open
     * with this merchant.</p>
     *
     * @param human The human to trade with
     */
    void setCustomer(@Nullable Human human);

    /**
     * Gets an immutable list of {@link TradeOffer}s that this merchant
     * can send to a {@link org.spongepowered.api.entity.living.Human}.
     *
     * @return An immutable list of trade offers
     */
    List<TradeOffer> getOffers();

    /**
     * Replaces the entire list of trade offers this merchant can trade
     * with a {@link org.spongepowered.api.entity.living.Human}.
     * <p>When a merchant is in the middle of a trade, the offers may change
     * dynamically according to the offers completed by the customer.</p>
     *
     * @param offers The offers to set
     */
    void setOffers(List<TradeOffer> offers);

    /**
     * Adds the given offer to the list of offers provided by this merchant.
     *
     * @param offer The offer to add
     */
    void addOffer(TradeOffer offer);
}
