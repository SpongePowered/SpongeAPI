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
package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.entity.TradeOfferData;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.item.merchant.Merchant;
import org.spongepowered.api.item.merchant.TradeOffer;

/**
 * An {@link ImmutableDataManipulator} handling the {@link TradeOffer}s that
 * can be offered to {@link Humanoid}s from {@link Merchant}s such as
 * {@link Villager}s.
 */
public interface ImmutableTradeOfferData extends ImmutableListData<TradeOffer, ImmutableTradeOfferData, TradeOfferData> {

    /**
     * Gets the {@link ImmutableListValue} of {@link TradeOffer}s that can be
     * offered.
     *
     * @return The immutable list value of trade offers
     */
    default ImmutableListValue<TradeOffer> tradeOffers() {
        return getListValue();
    }

}
