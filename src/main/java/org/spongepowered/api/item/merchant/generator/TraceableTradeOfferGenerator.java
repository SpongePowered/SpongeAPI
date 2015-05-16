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
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.util.TraceableException;

import java.util.Arrays;
import java.util.List;

/**
 * A traceable {@link TradeOfferGenerator} can be used to track down the
 * original source of a malicious {@link TradeOfferGenerator}. Due to the
 * callback functionality of trade offer generators the stacktrace of the real
 * exception is less useful. Instead the location where the trade offer
 * generators has been set is more important.
 */
public class TraceableTradeOfferGenerator implements TradeOfferGenerator {

    /**
     * Wraps the given {@link TradeOfferGenerator} in a traceable generator.
     *
     * @param generator The generator to wrap
     * @return The traceable generator
     */
    public static TradeOfferGenerator wrap(TradeOfferGenerator generator) {
        if (generator instanceof TraceableTradeOfferGenerator) {
            return generator;
        } else {
            return new TraceableTradeOfferGenerator(generator);
        }
    }

    private final StackTraceElement[] trace;
    private final TradeOfferGenerator generator;

    /**
     * Creates a new traceable generator wrapping the given generator.
     *
     * @param generator The generator to wrap
     */
    public TraceableTradeOfferGenerator(TradeOfferGenerator generator) {
        this(generator, Thread.currentThread().getStackTrace());
    }

    /**
     * Creates a new traceable generator wrapping the given generator.
     *
     * @param generator The generator to wrap
     * @param trace The trace to keep track of
     */
    public TraceableTradeOfferGenerator(TradeOfferGenerator generator, StackTraceElement[] trace) {
        super();
        this.generator = checkNotNull(generator, "generator");
        this.trace = checkNotNull(trace, "trace");
    }

    @Override
    public List<TradeOffer> generate() {
        try {
            return checkNoNullElements(this.generator.generate());
        } catch (TraceableException e) {
            throw e;
        } catch (Exception e) {
            throw new TraceableException("An error occured while trying to generate trade offers", e, this.generator, this.trace);
        }
    }

    private List<TradeOffer> checkNoNullElements(List<TradeOffer> tradeOffers) {
        checkNotNull(tradeOffers, "tradeOffers from %s", this.generator);
        for (TradeOffer tradeOffer : tradeOffers) {
            checkNotNull(tradeOffer, "tradeOffer from %s", this.generator);
        }
        return tradeOffers;
    }

    /**
     * Gets the parent generator this generator wraps.
     *
     * @return The parent generator
     */
    public TradeOfferGenerator getParent() {
        return this.generator;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("generator", this.generator)
                .add("trace", Arrays.toString(this.trace))
                .toString();
    }

}
