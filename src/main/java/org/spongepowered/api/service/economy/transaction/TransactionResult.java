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

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Represents the result of a particular transaction, such as a deposit
 * or withdrawal.
 */
public interface TransactionResult {

    /**
     * Gets the {@link Account} involved in the transaction.
     *
     * @return The {@link Account}
     */
    Account getAccount();

    /**
     * Gets the {@link Currency} involved in the transaction.
     *
     * @return The {@link Currency}
     */
    Currency getCurrency();

    /**
     * Gets the amount of the {@link Currency} involved in the transaction.
     *
     * @return The amount
     */
    BigDecimal getAmount();

    /**
     * Returns the set of {@link Context}s used to perform the
     * transaction.
     *
     * @return optional set of contexts
     */
    Set<Context> getContexts();

    /**
     * Gets the {@link ResultType} of this transaction.
     *
     * @return resultType
     */
    ResultType getResult();

    /**
     * Returns the {@link TransactionType} of this result.
     *
     * @return type of Transaction
     */
    TransactionType getType();
}
