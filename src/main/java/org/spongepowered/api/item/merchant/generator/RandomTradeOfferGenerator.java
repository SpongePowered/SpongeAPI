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
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.util.SupplierUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * A random trade offer generator, that returns random results from the given
 * generators.
 */
public class RandomTradeOfferGenerator implements TradeOfferGenerator {

    private final Supplier<Integer> amount;
    private final Supplier<List<TradeOfferGenerator>> generators;

    /**
     * Creates a random trade offer generator which always uses one of the
     * supplied generators.
     *
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(TradeOfferGenerator... generators) {
        this(1, generators);
    }

    /**
     * Creates a random trade offer generator which always uses a fixed number
     * of the supplied generators.
     *
     * @param amount The amount of generators to use
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(int amount, TradeOfferGenerator... generators) {
        this(amount, amount, generators);
    }

    /**
     * Creates a random trade offer generator which always uses a random number
     * of the supplied generators.
     *
     * @param min The min amount of generators to use
     * @param max The max amount of generators to use
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(int min, int max, TradeOfferGenerator... generators) {
        this(min, max, Arrays.asList(checkNotNull(generators, "generators")));
    }

    /**
     * Creates a random trade offer generator which always uses one of the
     * supplied generators.
     *
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(Collection<? extends TradeOfferGenerator> generators) {
        this(1, generators);
    }

    /**
     * Creates a random trade offer generator which always uses a fixed number
     * of the supplied generators.
     *
     * @param amount The amount of generators to use
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(int amount, Collection<? extends TradeOfferGenerator> generators) {
        this(amount, amount, generators);
    }

    /**
     * Creates a random trade offer generator which always uses a random number
     * of the supplied generators.
     *
     * @param min The min amount of generators to use
     * @param max The max amount of generators to use
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(int min, int max, Collection<? extends TradeOfferGenerator> generators) {
        this(SupplierUtil.randomBetween(min, max), SupplierUtil.randomized(checkNotNull(generators, "generators")));
    }

    /**
     * Creates a random trade offer generator which always uses a fixed number
     * of the supplied generators.
     *
     * @param amount The amount of generators to use
     * @param generators The possible generators to choose from
     */
    public RandomTradeOfferGenerator(Supplier<Integer> amount, Supplier<List<TradeOfferGenerator>> generators) {
        super();
        this.generators = checkNotNull(generators, "generators");
        this.amount = checkNotNull(amount, "amount");
    }

    @Override
    public List<TradeOffer> generate() {
        final List<TradeOffer> offers = new ArrayList<TradeOffer>();
        final List<TradeOfferGenerator> generators = this.generators.get();
        final int amount = Math.min(this.amount.get(), generators.size());
        for (TradeOfferGenerator generator : generators.subList(0, amount)) {
            offers.addAll(generator.generate());
        }
        return offers;
    }

}
