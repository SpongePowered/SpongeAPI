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
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A {@link TradeOfferGenerator} that uses a {@link Supplier} to return the
 * generated {@link TradeOffer}s.
 */
public class SupplierTradeOfferGenerator implements TradeOfferGenerator {

    /**
     * Wraps the supplier in an {@link TradeOfferGenerator}.
     *
     * @param supplier The supplier to wrap. Should never return null
     * @return The created trade offer generator
     */
    public static TradeOfferGenerator wrapSingle(Supplier<TradeOffer> supplier) {
        return wrapMultiple(new SingleEntrySupplier(supplier));
    }

    /**
     * Wraps the supplier in an {@link TradeOfferGenerator}.
     *
     * @param supplier The supplier to wrap. Should never return null or null
     *        elements
     * @return The created trade offer generator
     */
    public static TradeOfferGenerator wrapMultiple(Supplier<? extends Collection<TradeOffer>> supplier) {
        return new SupplierTradeOfferGenerator(supplier);
    }

    private final Supplier<? extends Collection<TradeOffer>> supplier;

    /**
     * Creates a {@link TradeOfferGenerator} using the given {@link Supplier} to
     * generate the result.
     *
     * @param supplier The supplier used to generate the result. Should never
     *        return null or null elements
     */
    public SupplierTradeOfferGenerator(Supplier<? extends Collection<TradeOffer>> supplier) {
        super();
        this.supplier = checkNotNull(supplier, "supplier");
    }

    @Override
    public List<TradeOffer> generate() {
        return new ArrayList<TradeOffer>(checkNotNull(this.supplier.get(), "tradeOffers from %s", this.supplier));
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("supplier", this.supplier)
                .toString();
    }

    private static class SingleEntrySupplier implements Supplier<List<TradeOffer>> {

        private final Supplier<TradeOffer> supplier;

        /**
         * Creates a List-{@link Supplier} wrapping the single entry
         * {@link Supplier}.
         *
         * @param supplier The supplier used to generate the result. Should
         *        never return null
         */
        SingleEntrySupplier(Supplier<TradeOffer> supplier) {
            super();
            this.supplier = supplier;
        }

        @Override
        public List<TradeOffer> get() {
            List<TradeOffer> result = new ArrayList<TradeOffer>(1);
            result.add(checkNotNull(this.supplier.get(), "tradeOffer from %s", this.supplier));
            return result;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("supplier", this.supplier)
                    .toString();
        }

    }

}
