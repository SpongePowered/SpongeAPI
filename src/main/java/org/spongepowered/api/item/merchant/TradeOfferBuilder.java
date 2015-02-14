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

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a builder to generate immutable {@link TradeOffer}s.
 */
public interface TradeOfferBuilder {

    /**
     * <p>Sets the first selling item of the trade offer to be generated.</p>
     *
     * <p>Trade offers require at least one item to be generated.</p>
     *
     * @param item The first item to buy
     * @return This builder
     */
    TradeOfferBuilder firstBuyingItem(ItemStack item);

    /**
     * Sets the second selling item of the trade offer to be generated.
     *
     * @param item The second item to buy
     * @return This builder
     */
    TradeOfferBuilder secondBuyingItem(ItemStack item);

    /**
     * Sets the selling item of the trade offer to be generated.
     *
     * @param item The item to sell
     * @return This builder
     */
    TradeOfferBuilder sellingItem(ItemStack item);

    /**
     * Sets the existing uses of the trade offer to be generated. A trade offer
     * will become unusable when the uses surpasses the max uses.
     *
     * @param uses The uses
     * @return This builder
     */
    TradeOfferBuilder uses(int uses);

    /**
     * Sets the maximum uses the generated trade offer will have. A trade offer
     * will become unusable when the uses surpasses the max uses.
     *
     * @param maxUses The maximum uses of the trade offer
     * @return This builder
     */
    TradeOfferBuilder maxUses(int maxUses);

    /**
     * Sets the trade offer to be generated to grant experience upon use.
     *
     * @param experience Whether the offer will grant experience
     * @return This builder
     */
    TradeOfferBuilder setCanGrantExperience(boolean experience);

    /**
     * Creates a new TradeOffer instance with the current state of the builder.
     *
     * @return A new trade offer instance
     * @throws IllegalStateException If the resulting trade offer would be
     *      invalid
     */
    TradeOffer build() throws IllegalStateException;

    /**
     * Sets all the settings of this builder with the provided trade offer as a
     * blueprint.
     *
     * @param offer The offer to copy
     * @return This builder
     */
    TradeOfferBuilder from(TradeOffer offer);

    /**
     * Clears all settings of this builder.
     *
     * @return This builder
     */
    TradeOfferBuilder reset();

}
