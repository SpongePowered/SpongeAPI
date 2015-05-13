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

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.Arrays;
import java.util.List;

/**
 * A highly dynamic {@link TradeOfferGenerator}, that can only return a single
 * trade offer.
 */
public final class DynamicTradeOfferGenerator implements TradeOfferGenerator {

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

    public DynamicTradeOfferGenerator(GameRegistry registry, Supplier<ItemStack> primaryBuyingItem, Supplier<ItemStack> secondaryBuyingItem,
            Supplier<ItemStack> sellingItem, Supplier<Integer> startUses, Supplier<Integer> maxUses, boolean canGrantExperience) {
        super();
        this.registry = checkNotNull(registry, "registry");
        this.primaryBuyingItem = checkNotNull(primaryBuyingItem, "primaryBuyingItem");
        this.secondaryBuyingItem = checkNotNull(secondaryBuyingItem, "secondaryBuyingItem");
        this.sellingItem = checkNotNull(sellingItem, "sellingItem");
        this.startUses = checkNotNull(startUses, "startUses");
        this.maxUses = checkNotNull(maxUses, "maxUses");
        this.canGrantExperience = canGrantExperience;
    }

    @Override
    public List<TradeOffer> generate() {
        int maxUses = this.maxUses.get();
        int startUses = Math.min(maxUses, this.startUses.get());
        return Arrays.asList(this.registry.getTradeOfferBuilder()
                .firstBuyingItem(this.primaryBuyingItem.get())
                .secondBuyingItem(this.secondaryBuyingItem.get())
                .sellingItem(this.sellingItem.get())
                .uses(startUses)
                .maxUses(maxUses)
                .setCanGrantExperience(this.canGrantExperience).build());
    }

    public static class Builder {

        private final GameRegistry registry;
        private Supplier<ItemStack> primaryBuyingItem;
        private Supplier<ItemStack> secondaryBuyingItem = Suppliers.ofInstance(null);
        private Supplier<ItemStack> sellingItem;
        private Supplier<Integer> startUses = Suppliers.ofInstance(1);
        private Supplier<Integer> maxUses = Suppliers.ofInstance(1);
        private boolean canGrantExperience;

        private Builder(GameRegistry registry) {
            this.registry = registry;
        }

        public Builder primaryBuyingItem(Supplier<ItemStack> primaryBuyingItem) {
            this.primaryBuyingItem = primaryBuyingItem;
            return this;
        }

        public Builder primaryBuyingItem(ItemStack primaryBuyingItem) {
            this.primaryBuyingItem = Suppliers.ofInstance(checkNotNull(primaryBuyingItem, "primaryBuyingItem"));
            return this;
        }

        public Builder secondaryBuyingItem(Supplier<ItemStack> secondaryBuyingItem) {
            this.secondaryBuyingItem = secondaryBuyingItem;
            return this;
        }

        public Builder secondaryBuyingItem(ItemStack secondaryBuyingItem) {
            this.secondaryBuyingItem = Suppliers.ofInstance(secondaryBuyingItem);
            return this;
        }

        public Builder sellingItem(Supplier<ItemStack> sellingItem) {
            this.sellingItem = sellingItem;
            return this;
        }

        public Builder sellingItem(ItemStack sellingItem) {
            this.sellingItem = Suppliers.ofInstance(checkNotNull(sellingItem, "sellingItem"));
            return this;
        }

        public Builder startUses(Supplier<Integer> startUses) {
            this.startUses = startUses;
            return this;
        }

        public Builder startUses(int startUses) {
            this.startUses = Suppliers.ofInstance(startUses);
            return this;
        }

        public Builder maxUses(Supplier<Integer> maxUses) {
            this.maxUses = maxUses;
            return this;
        }

        public Builder maxUses(int maxUses) {
            this.maxUses = Suppliers.ofInstance(maxUses);
            return this;
        }

        public Builder canGrantExperience(boolean canGrantExperience) {
            this.canGrantExperience = canGrantExperience;
            return this;
        }

        public DynamicTradeOfferGenerator build() {
            return new DynamicTradeOfferGenerator(this.registry, this.primaryBuyingItem, this.secondaryBuyingItem, this.sellingItem, this.startUses,
                    this.maxUses, this.canGrantExperience);
        }

    }

}
