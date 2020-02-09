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
package org.spongepowered.api.service.economy.transaction;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.economy.EconomyTransactionEvent;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.EconomyService;

import java.util.function.Supplier;

/**
 * A catalog of various results of economy transactions. These results
 * are implemented directly by Sponge but the {@link EconomyService}
 * implementor can add and implement novel result types.
 *
 * @see EconomyTransactionResultType
 */
public final class EconomyTransactionResultTypes {

    // SORTFIELDS:ON

    /**
     * Represents when the transaction is unsuccessful due to one or more
     * of the involved accounts being frozen and suspended from making
     * economy transactions.
     */
    public static final Supplier<EconomyTransactionResultType> ACCOUNT_FROZEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "ACCOUNT_FROZEN");

    /**
     * Represents when the transaction is unsuccessful due to the target
     * account having already reached their maximum fund amount.
     */
    public static final Supplier<EconomyTransactionResultType> ACCOUNT_FULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "ACCOUNT_FULL");

    /**
     * Represents when the transaction is unsuccessful, likely due to being
     * cancelled by a plugin through {@link EconomyTransactionEvent}.
     */
    public static final Supplier<EconomyTransactionResultType> CANCELLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "CANCELLED");

    /**
     * Represents when the transaction attempt resulted in a difference
     * in {@link Context contexts}.
     */
    public static final Supplier<EconomyTransactionResultType> CONTEXT_MISMATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "CONTEXT_MISMATCH");

    /**
     * Represents when the transaction failed for an unspecific reason.
     */
    public static final Supplier<EconomyTransactionResultType> FAILED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "FAILED");

    /**
     * Represents when the transaction is unsuccessful due to the account
     * which is being removed from having insufficient funds.
     */
    public static final Supplier<EconomyTransactionResultType> INSUFFICIENT_FUNDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "INSUFFICIENT_FUNDS");

    /**
     * Represents a successfully completed transaction.
     */
    public static final Supplier<EconomyTransactionResultType> SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "SUCCESS");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EconomyTransactionResultTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
