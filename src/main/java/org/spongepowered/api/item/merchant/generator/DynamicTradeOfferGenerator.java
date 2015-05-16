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

package org.spongepowered.api.item.merchant.generator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * A highly dynamic {@link TradeOfferGenerator}, that can only return a single
 * trade offer.
 */
public final class DynamicTradeOfferGenerator implements TradeOfferGenerator {

    /**
     * Creates a new builder to create a new dynamic {@link TradeOfferGenerator}
     * instance.
     *
     * @param registry The backing {@link GameRegistry}
     * @return The newly created builder
     */
    public static Builder builder(GameRegistry registry) {
        return new Builder(registry);
    }

    private final GameRegistry registry;
    private final Supplier<ItemStack> primaryBuyingItem;
    private final Supplier<ItemStack> secondaryBuyingItem;
    private final Supplier<ItemStack> sellingItem;
    private final Supplier<Integer> startUses;
    private final Supplier<Integer> maxUses;
    private final boolean canGrantExperience;

    /**
     * Creates a dynamic {@link TradeOfferGenerator} from the given
     * specifications always returning a single trade offer.
     *
     * @param registry The {@link GameRegistry} to obtain trade offer builders
     *        from
     * @param primaryBuyingItem The primary buying item. Should never return
     *        null
     * @param secondaryBuyingItem The secondary buying item
     * @param sellingItem The selling item. Should never return null
     * @param startUses The start uses for the trade offer. This value is
     *        automatically truncated to maxUses. Should never return null
     * @param maxUses The max uses for the trade offer. Should never return null
     * @param canGrantExperience Whether the generated trade offer can grant
     *        experience
     */
    public DynamicTradeOfferGenerator(GameRegistry registry, Supplier<ItemStack> primaryBuyingItem,
            @Nullable Supplier<ItemStack> secondaryBuyingItem,
            Supplier<ItemStack> sellingItem, Supplier<Integer> startUses, Supplier<Integer> maxUses, boolean canGrantExperience) {
        super();
        this.registry = checkNotNull(registry, "registry");
        this.primaryBuyingItem = checkNotNull(primaryBuyingItem, "primaryBuyingItem");
        this.secondaryBuyingItem = secondaryBuyingItem == null ? Suppliers.<ItemStack>ofInstance(null) : secondaryBuyingItem;
        this.sellingItem = checkNotNull(sellingItem, "sellingItem");
        this.startUses = checkNotNull(startUses, "startUses");
        this.maxUses = checkNotNull(maxUses, "maxUses");
        this.canGrantExperience = canGrantExperience;
    }

    @Override
    public List<TradeOffer> generate() {
        final int maxUses = checkNotNull(this.maxUses.get(), "maxUses from %s", this.maxUses);
        final int startUses = Math.min(maxUses, checkNotNull(this.startUses.get(), "startUses from %s", this.startUses));
        return Arrays.asList(this.registry.getTradeOfferBuilder()
                .firstBuyingItem(checkNotNull(this.primaryBuyingItem.get(), "primaryBuyingItem from %s", this.primaryBuyingItem))
                .secondBuyingItem(this.secondaryBuyingItem.get())
                .sellingItem(checkNotNull(this.sellingItem.get(), "sellingItem from %s", this.sellingItem))
                .uses(startUses)
                .maxUses(maxUses)
                .setCanGrantExperience(this.canGrantExperience)
                .build());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("primaryBuyingItem", this.primaryBuyingItem)
                .add("secondaryBuyingItem", this.secondaryBuyingItem)
                .add("sellingItem", this.sellingItem)
                .add("startUses", this.startUses)
                .add("maxUses", this.maxUses)
                .add("canGrantExperience", this.canGrantExperience)
                .toString();
    }

    /**
     * The builder for dynamic {@link TradeOfferGenerator}s.
     */
    public static class Builder {

        private final GameRegistry registry;
        private Supplier<ItemStack> primaryBuyingItem;
        @Nullable
        private Supplier<ItemStack> secondaryBuyingItem;
        private Supplier<ItemStack> sellingItem;
        private Supplier<Integer> startUses = Suppliers.ofInstance(1);
        private Supplier<Integer> maxUses = Suppliers.ofInstance(1);
        private boolean canGrantExperience;

        private Builder(GameRegistry registry) {
            this.registry = registry;
        }

        /**
         * <p>Sets the first selling item of the trade offer to be
         * generated.</p>
         *
         * <p>Trade offers require at least one item to be generated.</p>
         *
         * @param item The first item to buy
         * @return This builder
         */
        public Builder primaryBuyingItem(Supplier<ItemStack> item) {
            this.primaryBuyingItem = item;
            return this;
        }

        /**
         * <p>Sets the first selling item of the trade offer to be
         * generated.</p>
         *
         * <p>Trade offers require at least one item to be generated.</p>
         *
         * @param item The first item to buy
         * @return This builder
         */
        public Builder primaryBuyingItem(ItemStack item) {
            this.primaryBuyingItem = Suppliers.ofInstance(checkNotNull(item, "primaryBuyingItem"));
            return this;
        }

        /**
         * Sets the second selling item of the trade offer to be generated.
         *
         * @param item The second item to buy
         * @return This builder
         */
        public Builder secondaryBuyingItem(@Nullable Supplier<ItemStack> item) {
            this.secondaryBuyingItem = item;
            return this;
        }

        /**
         * Sets the second selling item of the trade offer to be generated.
         *
         * @param item The second item to buy
         * @return This builder
         */
        public Builder secondaryBuyingItem(@Nullable ItemStack item) {
            this.secondaryBuyingItem = Suppliers.ofInstance(item);
            return this;
        }

        /**
         * Sets the selling item of the trade offer to be generated.
         *
         * @param item The item to sell
         * @return This builder
         */
        public Builder sellingItem(Supplier<ItemStack> item) {
            this.sellingItem = item;
            return this;
        }

        /**
         * Sets the selling item of the trade offer to be generated.
         *
         * @param item The item to sell
         * @return This builder
         */
        public Builder sellingItem(ItemStack item) {
            this.sellingItem = Suppliers.ofInstance(checkNotNull(item, "sellingItem"));
            return this;
        }

        /**
         * Sets the existing uses of the trade offer to be generated. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param uses The uses
         * @return This builder
         */
        public Builder startUses(Supplier<Integer> uses) {
            this.startUses = uses;
            return this;
        }

        /**
         * Sets the existing uses of the trade offer to be generated. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param uses The uses
         * @return This builder
         */
        public Builder startUses(int uses) {
            this.startUses = Suppliers.ofInstance(uses);
            return this;
        }

        /**
         * Sets the maximum uses the generated trade offer will have. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param maxUses The maximum uses of the trade offer
         * @return This builder
         */
        public Builder maxUses(Supplier<Integer> maxUses) {
            this.maxUses = maxUses;
            return this;
        }

        /**
         * Sets the maximum uses the generated trade offer will have. A trade
         * offer will become unusable when the uses surpasses the max uses.
         *
         * @param maxUses The maximum uses of the trade offer
         * @return This builder
         */
        public Builder maxUses(int maxUses) {
            this.maxUses = Suppliers.ofInstance(maxUses);
            return this;
        }

        /**
         * Sets the trade offer to be generated to grant experience upon use.
         *
         * @param experience Whether the offer will grant experience
         * @return This builder
         */
        public Builder canGrantExperience(boolean experience) {
            this.canGrantExperience = experience;
            return this;
        }

        /**
         * Creates a new DynamicTradeOfferGenerator instance with the current
         * state of the builder.
         *
         * @return A new trade offer generator instance
         */
        public DynamicTradeOfferGenerator build() {
            return new DynamicTradeOfferGenerator(this.registry, this.primaryBuyingItem, this.secondaryBuyingItem, this.sellingItem, this.startUses,
                    this.maxUses, this.canGrantExperience);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("primaryBuyingItem", this.primaryBuyingItem)
                    .add("secondaryBuyingItem", this.secondaryBuyingItem)
                    .add("sellingItem", this.sellingItem)
                    .add("startUses", this.startUses)
                    .add("maxUses", this.maxUses)
                    .add("canGrantExperience", this.canGrantExperience)
                    .toString();
        }

    }

}
