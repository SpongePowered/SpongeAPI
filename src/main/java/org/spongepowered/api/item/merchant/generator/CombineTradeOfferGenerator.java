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

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A {@link TradeOfferGenerator} that combines all generated result from all
 * contained {@link TradeOfferGenerator}s.
 */
public class CombineTradeOfferGenerator implements TradeOfferGenerator {

    private final List<TradeOfferGenerator> generators;

    public CombineTradeOfferGenerator(Collection<TradeOfferGenerator> generators) {
        super();
        this.generators = ImmutableList.copyOf(checkNotNull(generators, "generator"));
    }

    @Override
    public List<TradeOffer> generate() {
        final List<TradeOffer> offers = new ArrayList<TradeOffer>();
        for (TradeOfferGenerator generator : this.generators) {
            offers.addAll(generator.generate());
        }
        return offers;
    }

}
