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
package org.spongepowered.api.service.economy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.Contextual;
import org.spongepowered.api.service.economy.transaction.DepositResult;
import org.spongepowered.api.service.economy.transaction.ExchangeResult;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.service.economy.transaction.TransferResult;
import org.spongepowered.api.service.economy.transaction.WithdrawResult;

/**
 * TODO: Add overview doc
 *
 */
public interface Account extends Contextual {

    
    BigDecimal getDefaultBalance(Currency currency);

    /**
     * Returns a {@link BigDecimal} representative of the balance stored within this
     * {@link Account} for the {@link Currency} given and the set of {@link Context}s.
     * 
     * <p>The default result when the account does not have a balance of the given
     * {@link Currency} should be {@link BigDecimal#ZERO}.</p>
     * 
     * <p>The balance may be unavailable depending on the set of {@link Context}s used.</p>
     * 
     * @param a {@link Currency} to check the balance of
     * @param set of contexts to check the balance against
     * 
     * @return a {@link BigDecimal} value.
     */
    BigDecimal getBalance(Currency currency, Set<Context> contexts);

    /**
     * Returns a {@link Map} of all currently set balances the account holds within
     * the set of {@link Context}s.
     * 
     * <p>Amounts may differ depending on the {@link Context}s specified and 
     * the implementation. The set of {@link Context}s may be empty.</p>
     * 
     * <p>{@link Currency} amounts which are 0 may or may not be included in the
     * returned mapping.</p>
     * 
     * <p>Changes to the returned {@link Map} will not be reflected in the underlying
     * {@link Account} and may result in runtime exceptions depending on implementation.
     * See {@link #setBalance(BigDecimal, Currency)} to set values.</p>
     * 
     * @param set of {@link Context}s
     * 
     * @return {@link Map} of {@link Currency} to {@link BigDecimal} amounts that this
     *         account holds.
     */
    Map<Currency, BigDecimal> getBalances(Set<Context> contexts);

    /**
     * Sets the balances stored by this {@link Account} to the given amounts for
     * each of the {@link Currency}s specified using the set of {@link Context}s
     * if they are present.
     * 
     * <p>This will only set balances for the currencies contained in the map.
     * Currencies which are omitted will not be altered.</p>
     * 
     * <p>Negative balances may or may not be supported depending on
     * the {@link Currency} specified and the implementation.</p>
     * 
     * @param map of the {@link Currency}s and {@link BigDecimal} amounts to be used
     * @param set of {@link Context}s
     *
     * @return result of the transaction
     */
    TransactionResult setBalances(Map<Currency, BigDecimal> amounts, Set<Context> contexts);
    
    /**
     * Resets the account data back to the default values, only for the
     * given {@link Context}s.
     * 
     * <p>The set of {@link Context}s may be an empty set.</p>
     * 
     * @param set of contexts to reset.
     * 
     * @return a {@link TransactionResult} representing the effects of the operation
     */
    TransactionResult resetBalances(Set<Context> contexts);

    /**
     * Adds the given amounts of the {@link Currency}s to this {@link Account} 
     * in the given contexts if specified.
     * 
     * <p>If the account is not in the given {@link Context}s the result should be
     * a failure.</p>
     * 
     * @param map of the {@link Currency}s and {@link BigDecimal} amounts to be used
     * @param set of {@link Context}s used to validate the deposit
     * 
     * @return a {@link DepositResult} representative of the effects of the
     *         operation
     */
    DepositResult deposit(Map<Currency, BigDecimal> amounts, Set<Context> contexts);

    /**
     * Removes the given amounts of the {@link Currency}s from this {@link Account}
     * in the given contexts if specified.
     * 
     * <p>If the account is not in the given {@link Context}s the result should be
     * a failure.</p>
     * 
     * @param map of the {@link Currency}s and {@link BigDecimal} amounts to be used
     * @param set of {@link Context}s used to validate the withdraw
     * 
     * @return a {@link WithdrawResult} representative of the effects of the
     *         operation
     */
    WithdrawResult withdraw(Map<Currency, BigDecimal> amounts, Set<Context> contexts);

    /**
     * Transfers the given amounts of currencies from this {@link Account} to
     * the destination Account in the given {@link Context}s if present.
     * 
     * <p>If either of the accounts are not in the given {@link Context}s the result may
     * by a failure.</p>
     * 
     * <p>This operation is a merged {@link #withdraw(Map, Optional)} from this account
     * with a {@link #deposit(Map, Optional)} into the given account.</p>
     * 
     * @param to the Account to transfer the amounts to.
     * @param map of {@link Currency} and {@link BigDecimal} amounts to transfer
     * @param optional set of {@link Context}s used to validate the transfer
     * 
     * @return a {@link TransferResult} representative of the effects of the
     *         operation
     */
    TransferResult transfer(Account to, Map<Currency, BigDecimal> amounts, Set<Context> contexts);
    
    /**
     * Attempts to withdraw the fromAmounts from this account and add them into the exchanger
     * at the same time attempts to deduct the withAmounts from the exchanger and deposit
     * them into this account.
     * 
     * <p> This operation is a merged {@link #transfer(Account, Map, Optional)} on 2 accounts.</p>
     * 
     * @param to Account
     * @param fromAmounts
     * @param withAmounts
     * @param optional set of {@link Context}s used to validate the exchange.
     * @return
     */
    ExchangeResult exchange(Account exchanger, Map<Currency, BigDecimal> fromAmounts, Map<Currency, BigDecimal> withAmounts, Set<Context> contexts);
}
