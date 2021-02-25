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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackGenerator;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.weighted.VariableAmount;

import java.util.Random;
import java.util.function.BiFunction;

/**
 * Represents a generator to create {@link TradeOffer}s with a bit of
 * randomization based on {@link ItemStackGenerator}s for populating
 * {@link ItemStack}s and finally generating a {@link TradeOffer}.
 * <p>
 * <p>
 * <strong>Can be directly implemented as a lambda as follows:</strong>
 * <p><pre>
 * final TradeOfferGenerator generator = (merchant, random) -> TradeOffer.builder()
 *   .firstBuyingItem(ItemStack.of(ItemTypes.EMERALD, 64))
 *   .sellingItem(ItemStack.builder()
 *       .itemType(ItemTypes.DIAMOND_SWORD)
 *       .quantity(1)
 *       .add(Keys.APPLIED_ENCHANTMENTS, List.of(Enchantment.of(EnchantmentTypes.SHARPNESS, 1000)))
 *       .build()
 *   )
 *   .merchantExperienceGranted(5)
 *   .priceGrowthMultiplier(1.3f)
 *   .maxUses(20)
 *   .build()
 * );
 * </pre>
 * The by-product of a direct implementation is that you would be needing to
 * build out functions accepting the {@link Random random} instance to add
 * dynamism to your generated {@link TradeOffer TradeOffers}. As such, a handy
 * builder has been provided with {@link TradeOfferGenerator#builder()} and the
 * related methods exposed in {@link ItemStackGenerator}.
 *
 * <p>The primary use of this, and why the {@link Random} must be provided as
 * part of the {@link BiFunction} signature is that during multiple world
 * instances, there's different {@link Random} instances instantiated, and more
 * can be provided without the necessity to change the generator. One advantage
 * to using a generator is the ability to provide some "randomization" or
 * "chance" on the various aspects of the generated {@link TradeOffer} versus
 * creating a static non-changing offer. Normally, the vanilla
 * {@link TradeOffer}s are using a similar generator with limited scopes of
 * what the {@link ItemStack} can be customized as.</p>
 */
@FunctionalInterface
public interface TradeOfferGenerator extends BiFunction<Entity, Random, TradeOffer> {

    /**
     * Gets a new {@link Builder} to create a new {@link TradeOfferGenerator}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    @Override
    TradeOffer apply(Entity entity, Random random);

    /**
     * A simple builder to create a {@link TradeOfferGenerator}.
     */
    interface Builder extends org.spongepowered.api.util.Builder<TradeOfferGenerator, Builder>, CopyableBuilder<TradeOfferGenerator, Builder> {

        /**
         * Sets the {@link ItemStackGenerator} for creating the primary item
         * to be bought by the merchant.
         *
         * @param generator The generator that will create the first purchased
         *     itemstack
         * @return This builder, for chaining
         */
        Builder firstBuyingItemGenerator(ItemStackGenerator generator);

        /**
         * Sets the second {@link ItemStackGenerator} for creating the secondary
         * item to be bought by the merchant.
         *
         * @param generator The generator that will create (if not null) the
         *      second purchased itemstack
         * @return This builder, for chaining
         */
        Builder secondBuyingItemGenerator(@Nullable ItemStackGenerator generator);

        /**
         * Sets the buying {@link ItemStackGenerator} for creating the selling
         * item that players are buying.
         *
         * @param sellingGenerator The generator that will create the selling
         *      item
         * @return This builder, for chaining
         */
        Builder sellingItemGenerator(ItemStackGenerator sellingGenerator);

        /**
         * Sets the chance when {@link Random#nextDouble()} is called where
         * if the double is greater than the desired experience chance, the
         * generated {@link TradeOffer} will grant experience upon a
         * successful trade.
         *
         * @param experienceChance The experience chance
         * @return This builder, for chaining
         */
        Builder experienceChance(double experienceChance);

        Builder grantedExperience(VariableAmount amount);

        /**
         * Sets the {@link VariableAmount} of starting uses for the generated
         * {@link TradeOffer}.
         *
         * @param amount The variable amount of starting uses
         * @return This builder, for chaining
         */
        Builder startingUses(VariableAmount amount);

        /**
         * Sets the {@link VariableAmount} of maximum uses of the generated
         * {@link TradeOffer}.
         *
         * @param amount The variable amount of maximum uses
         * @return This builder, for chaining
         */
        Builder maxUses(VariableAmount amount);

        /**
         * Builds a new {@link TradeOfferGenerator}.
         *
         * @return The newly created generator
         */
        TradeOfferGenerator build();

    }

}
