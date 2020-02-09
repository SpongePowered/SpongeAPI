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

import org.spongepowered.api.event.economy.EconomyTransactionEvent;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Represents the result of a particular transaction, such as a deposit
 * or withdrawal.
 */
public interface EconomyTransactionResult {

    /**
     * Gets the {@link Account} involved in the transaction.
     *
     * @return The involved account
     */
    Account getAccount();

    /**
     * Gets the {@link Currency} involved in the transaction.
     *
     * @return The currency being used
     */
    Currency getCurrency();

    /**
     * Gets the amount of the {@link Currency} involved in the transaction.
     *
     * @return The amount of currency in the transaction
     */
    BigDecimal getAmount();

    /**
     * Returns the set of {@link Context}s used to perform the
     * transaction.
     *
     * @return An optional set of involved contexts
     */
    Set<Context> getContexts();

    /**
     * Gets the {@link EconomyTransactionResultType} of this transaction.
     *
     * @return The result type of this transaction
     */
    EconomyTransactionResultType getResultType();

    /**
     * Returns the {@link EconomyTransactionType} of this result.
     *
     * @return The type of transaction
     */
    EconomyTransactionType getType();

    /**
     * Reverses the transaction, in a sense creating a new transaction in
     * the opposite direction.
     *
     * <p>Should be a no-op operation if the original transaction was
     * not successful.</p>
     *
     * <p>Be careful undoing transactions, as undoing the transaction
     * throws a new {@link EconomyTransactionEvent}</p> and returns a new
     * {@link EconomyTransactionResult}, and can therefore be undone again.
     *
     * @return The transaction result of the reversal
     */
    EconomyTransactionResult undoTransaction();

}
