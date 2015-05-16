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
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.util.SupplierUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Helper class utility methods for {@link TradeOfferGenerator}s.
 */
public class TradeOfferGenerators {

    /**
     * Creates a new dynamic {@link TradeOfferGenerator} builder.
     *
     * @param registry The gameRegistry used to create the trade offer
     * @return The builder for the dynamic trade offer builder
     */
    public static DynamicTradeOfferGenerator.Builder dynamic(GameRegistry registry) {
        return DynamicTradeOfferGenerator.builder(registry);
    }

    /**
     * Wraps the trade offer in the generator for direct use of fixed
     * {@link TradeOffer}.
     *
     * @param offer The trade offer to wrap
     * @return The wrapped trade offer generator
     */
    public static TradeOfferGenerator wrap(TradeOffer offer) {
        return new SimpleTradeOfferGenerator(checkNotNull(offer, "offer"));
    }

    /**
     * Wraps each of the trade offers in a generator for direct use of fixed
     * {@link TradeOffer}s.
     *
     * @param offers The trade offers to wrap
     * @return A list containing the wrapped trade offer generators
     */
    public static List<TradeOfferGenerator> wrapEach(TradeOffer... offers) {
        checkNotNull(offers, "offers");
        final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>(offers.length);
        for (TradeOffer offer : offers) {
            generators.add(wrap(offer));
        }
        return generators;
    }

    /**
     * Wraps each of the trade offers in a generator for direct use of fixed
     * {@link TradeOffer}s.
     *
     * @param offers The trade offers to wrap
     * @return A list containing the wrapped trade offer generators
     */
    public static List<TradeOfferGenerator> wrapEach(Collection<TradeOffer> offers) {
        checkNotNull(offers, "offers");
        final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>(offers.size());
        for (TradeOffer offer : offers) {
            generators.add(wrap(offer));
        }
        return generators;
    }

    /**
     * Creates a collector, that can be used to collect trade offers for easier
     * flow calls.
     *
     * @return The newly created collector
     */
    public static Collector collector() {
        return new Collector();
    }

    /**
     * A utility class to collect trade offer generators in flow class.
     */
    public static class Collector {

        private final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>();

        private Collector() {
        }

        /**
         * Adds the given trade offer generator to the collected ones.
         *
         * @param generator The generator to add
         * @return This collector
         */
        public Collector add(TradeOfferGenerator generator) {
            this.generators.add(checkNotNull(generator, "generator"));
            return this;
        }

        /**
         * Adds the given trade offer generators to the collected ones.
         *
         * @param generators The generators to add
         * @return This collector
         */
        public Collector addAll(TradeOfferGenerator... generators) {
            this.generators.addAll(Arrays.asList(checkNotNull(generators, "generators")));
            return this;
        }

        /**
         * Adds the given trade offer generators to the collected ones.
         *
         * @param generators The generators to add
         * @return This collector
         */
        public Collector addAll(Collection<? extends TradeOfferGenerator> generators) {
            this.generators.addAll(checkNotNull(generators, "generators"));
            return this;
        }

        /**
         * Combines all collected trade offer generators to one trade offer
         * generator.
         *
         * @return The combined trade offer generator
         */
        public TradeOfferGenerator combineAll() {
            if (this.generators.size() == 1) {
                return this.generators.get(0);
            } else {
                return new CombineTradeOfferGenerator(this.generators);
            }
        }

        /**
         * Combines all collected trade offer generators to one random trade
         * offer generator, which always uses a random generator in random
         * order.
         *
         * @return The randomized trade offer generator
         */
        public TradeOfferGenerator oneOf() {
            if (this.generators.size() == 1) {
                return this.generators.get(0);
            } else {
                return new RandomTradeOfferGenerator(this.generators);
            }
        }

        /**
         * Combines all collected trade offer generators to one random trade
         * offer generator, which always uses a given amount of random
         * generators in random order.
         *
         * @param amount The amount of generators
         * @return The randomized trade offer generator
         */
        public TradeOfferGenerator someOf(int amount) {
            return new RandomTradeOfferGenerator(amount, this.generators);
        }

        /**
         * Combines all collected trade offer generators to one random trade
         * offer generator, which always uses a random amount of random
         * generators in random order.
         *
         * @param min The min amount of generators
         * @param max The max amount of generators
         * @return The randomized trade offer generator
         */
        public TradeOfferGenerator randomOf(int min, int max) {
            return new RandomTradeOfferGenerator(min, max, this.generators);
        }

        /**
         * Combines all collected trade offer generators to one random trade
         * offer generator, which always uses a given amount of random
         * generators in random order.
         *
         * @param amount The amount of generators
         * @return The randomized trade offer generator
         */
        public TradeOfferGenerator randomOf(Supplier<Integer> amount) {
            return new RandomTradeOfferGenerator(amount, SupplierUtil.randomized(this.generators));
        }

        /**
         * Resets this collector to its initial empty state.
         *
         * @return This collector
         */
        public Collector reset() {
            this.generators.clear();
            return this;
        }

    }

}
