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
package org.spongepowered.api.event.economy;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.transaction.EconomyTransactionResult;
import org.spongepowered.api.service.economy.transaction.EconomyTransactionType;
import org.spongepowered.api.service.economy.transaction.EconomyTransactionTypes;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Fired when the {@link EconomyService} is processing a transaction.
 */
public interface EconomyTransactionEvent extends Event, Cancellable {

    /**
     * Gets the {@link Account} involved in the transaction.
     *
     * @return The involved account
     */
    Account getAccount();

    /**
     * Gets the original {@link Currency} involved in the transaction.
     *
     * @return The original currency involved
     */
    Currency getOriginalCurrency();

    /**
     * Gets the {@link Currency} involved in the transaction.
     *
     * @return The currency being used
     */
    Currency getCurrency();

    /**
     * Sets the {@link Currency} to be used in the transaction.
     *
     * @param currency The new currency to use
     */
    void setCurrency(Currency currency);

    /**
     * Gets the original amount of the {@link Currency} involved
     * in the transaction.
     *
     * @return The amount of currency in the transaction
     */
    BigDecimal getOriginalAmount();

    /**
     * Gets the amount of the {@link Currency} involved in the transaction.
     *
     * @return The amount of currency in the transaction
     */
    BigDecimal getAmount();

    /**
     * Sets the amount of the {@link Currency} involved in the transaction.
     *
     * @param amount The amount of currency to include in the transaction
     */
    void setAmount(BigDecimal amount);

    /**
     * Gets the {@link EconomyTransactionResult} for the transaction that occurred.
     *
     * @return The {@link EconomyTransactionResult}
     */
    EconomyTransactionResult getTransactionResult();

    /**
     * Returns the set of {@link Context}s used to perform the
     * transaction. This is an unmodifiable set.
     *
     * @return An optional set of involved contexts
     */
    Set<Context> getContexts();

    /**
     * Overrides the set of the {@link Context}s used to perform the
     * transaction. This should be an unmodifiable set.
     *
     * @param contexts The new set of contexts to use
     */
    void setContexts(Set<Context> contexts);

    /**
     * Returns the {@link EconomyTransactionType} of this result.
     *
     * @return The type of transaction
     */
    EconomyTransactionType getType();

    /**
     * When the transaction is of a {@link EconomyTransactionTypes#TRANSFER}
     * type to another account.
     */
    interface Transfer extends EconomyTransactionEvent {

        /**
         * Gets the target {@link Account} of the transfer.
         *
         * @return The account receiving the transfer
         */
        Account targetAccount();

    }

}
