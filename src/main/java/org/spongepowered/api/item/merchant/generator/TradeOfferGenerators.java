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

import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class TradeOfferGenerators {

    public static DynamicTradeOfferGenerator.Builder dynamic(GameRegistry registry) {
        return DynamicTradeOfferGenerator.builder(registry);
    }

    public static TradeOfferGenerator wrap(TradeOffer offer) {
        return new SimpleTradeOfferGenerator(checkNotNull(offer, "offer"));
    }

    public static List<TradeOfferGenerator> wrapEach(TradeOffer... offers) {
        checkNotNull(offers, "offers");
        final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>(offers.length);
        for (TradeOffer offer : offers) {
            generators.add(wrap(offer));
        }
        return generators;
    }

    public static List<TradeOfferGenerator> wrapEach(Collection<TradeOffer> offers) {
        checkNotNull(offers, "offers");
        final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>(offers.size());
        for (TradeOffer offer : offers) {
            generators.add(wrap(offer));
        }
        return generators;
    }

    public static Collector collector() {
        return new Collector();
    }

    public static class Collector {

        private final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>();

        private Collector() {
        }

        public Collector add(TradeOfferGenerator generator) {
            this.generators.add(checkNotNull(generator, "generator"));
            return this;
        }

        public Collector addAll(TradeOfferGenerator... generators) {
            this.generators.addAll(Arrays.asList(checkNotNull(generators, "generators")));
            return this;
        }

        public Collector addAll(Collection<? extends TradeOfferGenerator> generators) {
            this.generators.addAll(checkNotNull(generators, "generators"));
            return this;
        }

        public TradeOfferGenerator combineAll() {
            if (this.generators.size() == 1) {
                return this.generators.get(0);
            } else {
                return new CombineTradeOfferGenerator(this.generators);
            }
        }

        public TradeOfferGenerator oneOf() {
            return new RandomTradeOfferGenerator(this.generators);
        }

        public TradeOfferGenerator someOf(int amount) {
            return new RandomTradeOfferGenerator(amount, this.generators);
        }

        public TradeOfferGenerator randomOf(int min, int max) {
            return new RandomTradeOfferGenerator(min, max, this.generators);
        }

    }
}
