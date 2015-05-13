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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A simple trade offer generator, that always returns the same results.
 */
public class RandomTradeOfferGenerator implements TradeOfferGenerator {

    private static final Random RANDOM = new Random();
    private final List<TradeOfferGenerator> generators;
    private final int min;
    private final int max;

    public RandomTradeOfferGenerator(TradeOfferGenerator... generators) {
        this(1, generators);
    }

    public RandomTradeOfferGenerator(int amount, TradeOfferGenerator... generators) {
        this(amount, amount, generators);
    }

    public RandomTradeOfferGenerator(int min, int max, TradeOfferGenerator... generators) {
        this(min, max, Arrays.asList(checkNotNull(generators, "generators")));
    }

    public RandomTradeOfferGenerator(Collection<? extends TradeOfferGenerator> offers) {
        this(1, offers);
    }

    public RandomTradeOfferGenerator(int amount, Collection<? extends TradeOfferGenerator> generators) {
        this(amount, amount, generators);
    }

    public RandomTradeOfferGenerator(int min, int max, Collection<? extends TradeOfferGenerator> generators) {
        super();
        this.generators = ImmutableList.copyOf(checkNotNull(generators, "generators"));
        checkArgument(min >= 0, "Min cannot be negative");
        checkArgument(min <= max, "Min cannot be higher than max");
        checkArgument(max <= generators.size(), "Max cannot be higher than the size of generators");
        this.min = min;
        this.max = max;
    }

    @Override
    public List<TradeOffer> generate() {
        final List<TradeOfferGenerator> generators = new ArrayList<TradeOfferGenerator>(this.generators);
        Collections.shuffle(generators);
        List<TradeOffer> offers = new ArrayList<TradeOffer>();
        int count = randomRange(this.min, this.max);
        for (TradeOfferGenerator generator : generators.subList(0, count)) {
            offers.addAll(generator.generate());
        }
        return offers;
    }

    private static int randomRange(int minInclusive, int maxInlcusive) {
        return RANDOM.nextInt(maxInlcusive - minInclusive + 1) + minInclusive;
    }

}
