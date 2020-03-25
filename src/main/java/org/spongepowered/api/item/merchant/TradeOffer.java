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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * <p>Represents a trade offer that a {@link Merchant} may offer a
 * {@link Humanoid}.</p>
 *
 * <p>TradeOffers usually have a limited amount of times they can be used.</p>
 *
 * <p>Also, trade offers are not guaranteed to have two buying items.</p>
 */
public interface TradeOffer extends DataSerializable {

    /**
     * Creates a new {@link Builder} to build a {@link TradeOffer}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the first buying item.
     * <p>The first buying item is an item that the customer is selling to the
     * merchant in exchange for {@link #getSellingItem()}.</p>
     *
     * @return The first buying item
     */
    ItemStackSnapshot getFirstBuyingItem();

    /**
     * Returns whether this trade offer has a second item the merchant is buying
     * from the customer.
     *
     * @return True if there is a second buying item
     */
    boolean hasSecondItem();

    /**
     * <p>Gets the second buying item.</p>
     *
     * <p>The second buying item is an item that the customer is selling to the
     * merchant, along with the {@link #getFirstBuyingItem()}, in exchange for
     * {@link #getSellingItem()}.</p>
     *
     * @return The second buying item, if available
     */
    Optional<ItemStackSnapshot> getSecondBuyingItem();

    /**
     * Gets the selling item the {@link Merchant} will give to the customer
     * often in exchange for a single item or sometimes, two items from the
     * following methods: {@link #getFirstBuyingItem()} and
     * {@link #getSecondBuyingItem}.
     *
     * @return The selling item
     */
    ItemStackSnapshot getSellingItem();

    /**
     * <p>Gets the current uses of this offer.</p>
     *
     * <p>Usually, the uses of an offer are limited by the amount of
     * {@link #getMaxUses()}. Once the uses reaches the max uses, the offer may
     * temporarily become disabled.</p>
     *
     * @return The current uses of this trade offer
     */
    int getUses();

    /**
     * <p>Gets the current maximum uses of this offer.</p>
     *
     * <p>Usually, the uses of an offer are limited by the amount of maximum
     * uses. Once the uses reaches the max uses, the offer may temporarily
     * become disabled.</p>
     *
     * @return The maximum uses of this trade offer
     */
    int getMaxUses();

    /**
     * Checks if this trade offer has indeed passed the time of which the uses
     * surpassed the maximum uses.
     *
     * @return True if the uses have surpassed the maximum uses
     */
    boolean hasExpired();

    /**
     * Gets whether this trade offer will grant experience to the customer upon
     * usage or not.
     *
     * @return True if using this trade offer will grant experience to the customer
     */
    boolean doesGrantExperience();

    /**
     * Gets the amount of experience granted to the merchant when this trade
     * offer is used.
     *
     * @return The experience to be granted to the merchant
     */
    int getExperienceGrantedToMerchant();

    /**
     * Gets the rate at which this trade offer's price will grow when demand for
     * an item increases. Every time a villager trades, this value is multiplied
     * by the current price of the offer and the demand bonus.
     *
     * <p>If this value is 0, demand will have no effect on this offer's
     * price.</p>
     *
     * @return the price growth multiplier
     * @see <a href="https://minecraft.gamepedia.com/Trading#Economics">the
     * Minecraft Wiki for more detail on how the price growth multiplier applies
     * to trade offers</a>
     */
    double getPriceGrowthMultiplier();

    /**
     * Gets the demand bonus for this trade offer.
     *
     * @return the demand bonus
     */
    int getDemandBonus();

    /**
     * Represents a builder to generate immutable {@link TradeOffer}s.
     */
    interface Builder extends CopyableBuilder<TradeOffer, Builder>, DataBuilder<TradeOffer> {

        /**
         * <p>Sets the first selling item of the trade offer to be
         * generated.</p>
         *
         * <p>Trade offers require at least one item to be generated.</p>
         *
         * @param item The first item to buy
         * @return This builder
         */
        Builder firstBuyingItem(ItemStack item);

        /**
         * Sets the second selling item of the trade offer to be generated.
         *
         * @param item The second item to buy
         * @return This builder
         */
        Builder secondBuyingItem(ItemStack item);

        /**
         * Sets the selling item of the trade offer to be generated.
         *
         * @param item The item to sell
         * @return This builder
         */
        Builder sellingItem(ItemStack item);

        /**
         * Sets the existing uses of the trade offer to be generated. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param uses The uses
         * @return This builder
         */
        Builder uses(int uses);

        /**
         * Sets the maximum uses the generated trade offer will have. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param maxUses The maximum uses of the trade offer
         * @return This builder
         */
        Builder maxUses(int maxUses);

        /**
         * Sets the trade offer to be generated to grant experience to
         * the customer upon use.
         *
         * @param experience Whether the offer will grant experience
         * @return This builder
         */
        Builder canGrantExperience(boolean experience);

        /**
         * Sets how much experience the trade offer will grant to the merchant
         * upon use.
         *
         * @param experience The amount of experience.
         * @return This builder
         */
        Builder merchantExperienceGranted(int experience);

        /**
         * Sets the rate at which the generated trade offer's price will grow
         * when demand for an item increases. Every time a villager trades, this
         * value is multiplied by the current price of the offer and the demand
         * bonus.
         *
         * <p>If this value is 0, trade demand will have no effect on this
         * offer's price.</p>
         *
         * @param priceGrowthMultiplier The offer's rate of price growth
         * @return This builder
         * @see <a href="https://minecraft.gamepedia.com/Trading#Economics">the
         * Minecraft Wiki for more detail on how the price growth multiplier
         * applies to trade offers</a>
         */
        Builder priceGrowthMultiplier(double priceGrowthMultiplier);

        /**
         * Sets the demand bonus for this trade offer.
         *
         * @param bonus The offer's demand bonus
         * @return This builder
         */
        Builder demandBonus(int bonus);

        /**
         * Creates a new TradeOffer instance with the current state of the
         * builder.
         *
         * @return A new trade offer instance
         * @throws IllegalStateException If the resulting trade offer would be
         *      invalid
         */
        TradeOffer build() throws IllegalStateException;

    }
}
