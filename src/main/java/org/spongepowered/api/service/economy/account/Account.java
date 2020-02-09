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
package org.spongepowered.api.service.economy.account;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.Contextual;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.transaction.EconomyTransactionResult;
import org.spongepowered.api.service.economy.transaction.EconomyTransferResult;
import org.spongepowered.api.text.Text;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an account, which stores amounts of
 * various {@link Currency currencies}.
 *
 * The account has a type and can have one or more owners.
 */
public interface Account extends Contextual {

    /**
     * Gets the display name for this account.
     *
     * <p>This should be used by plugins to get a human-readable name for an
     * account.</p>
     *
     * <p>Its contents are dependent on the provider of {@link EconomyService}.
     * For example, an economy plugin could allow players to configure the
     * display name of their account.</p>
     *
     * @return The display name for this account
     */
    Text getDisplayName();

    /**
     * Gets the {@link AccountType} of this account.
     *
     * @return The account type
     */
    AccountType getType();

    /**
     * Gets if the {@link Account} is frozen and cannot
     * process any transactions.
     *
     * @return If the account is frozen
     */
    boolean isFrozen();

    /**
     * Gets all owners of this account, specified with {@link UUID}s as an
     * unmodifiable collection.
     *
     * <p>These are often the UUIDs of players, but could also be the UUID's
     * of other accounts, factions, or similar.</p>
     *
     * @return An unmodifiable collection of all owners of the account
     */
    Collection<UUID> getOwners();

    /**
     * Removes the specified {@link UUID} as an owner of the account.
     *
     * @param owner The owner to remove from the account
     */
    void removeOwner(UUID owner);

    /**
     * Adds the specified {@link UUID} as an owner of the account.
     *
     * @param owner The owner to add to the account
     */
    void addOwner(UUID owner);

    /**
     * Gets the default balance of this account for the specified
     * {@link Currency}.
     *
     * <p>The default balance is used when the balance is retrieved for the
     * first time for a given {@link Currency} on this account, if no
     * balance is available for the {@link Context}s used when retrieving
     * a balance, or if the account's balance is reset.</p>
     *
     * <p>If not specified for the specific account, simply uses the
     * default balance from their account type.</p>
     *
     * @param currency The currency to get the default balance for
     * @return The default balance for the specified currency
     */
    default BigDecimal getDefaultBalance(Currency currency) {
        return getType().getDefaultBalance(currency);
    }

    /**
     * Returns whether this account has a set balance for the specified
     * {@link Currency}, with the specified {@link Context}s.
     *
     * <p>If this method returns <code>false</code>, then
     * {@link #getDefaultBalance(Currency)} will be used when
     * retrieving a balance for the specified {@link Currency} with
     * the specified {@link Context}s.</p>
     *
     * @param currency The currency to determine if a balance is set for
     * @param contexts The contexts to use with the currency
     * @return Whether this account has a set balance for the specified
     *     currency and contexts
     */
    boolean hasBalance(Currency currency, Set<Context> contexts);

    /**
     * Returns whether this account has a set balance for the specified
     * {@link Currency}, with the current active contexts.
     *
     * <p>If this method returns <code>false</code>, then
     * {@link #getDefaultBalance(Currency)} will be used when retrieving
     * a balance for the specific {@link Currency} with
     * the current active contexts</p>.
     *
     * @param currency The currency to determine if a balance is set for
     * @return Whether this account has a set balance for the specified
     *     currency and current active contexts
     */
    default boolean hasBalance(Currency currency) {
        return this.hasBalance(currency, this.getActiveContexts());
    }

    /**
     * Returns a {@link BigDecimal} representative of the balance stored
     * within this {@link Account} for the {@link Currency} given and the
     * set of {@link Context}s.
     *
     * <p>The default result when the account does not have a balance of the
     * given {@link Currency} should be {@link BigDecimal#ZERO}.</p>
     *
     * <p>The balance may be unavailable depending on the set of
     * {@link Context}s used.</p>
     *
     * @param currency The currency to check the balance of
     * @param contexts The set of contexts to check the balance against
     * @return The value for the specified currency with
     *     the specified contexts
     */
    BigDecimal getBalance(Currency currency, Set<Context> contexts);

    /**
     * Returns a {@link BigDecimal} representative of the balance stored
     * within this {@link Account} for the {@link Currency} given, with
     * the current active contexts.
     *
     * <p>The default result when the account does not have a balance of the
     * given {@link Currency} will be {@link #getDefaultBalance(Currency)}.</p>
     *
     * @param currency The currency to check the balance of
     * @return The value for the specified currency
     */
    default BigDecimal getBalance(Currency currency) {
        return this.getBalance(currency, this.getActiveContexts());
    }

    /**
     * Returns a {@link Map} of all currently set balances the account holds
     * within the set of {@link Context}s.
     *
     * <p>Amounts may differ depending on the {@link Context}s specified and
     * the implementation. The set of {@link Context}s may be empty.</p>
     *
     * <p>{@link Currency} amounts which are 0 may or may not be included in
     * the returned mapping.</p>
     *
     * <p>Changes to the returned {@link Map} will not be reflected in
     * the underlying {@link Account}. See
     * {@link #setBalance(Currency, BigDecimal, Cause, Set)}  to set values.</p>
     *
     * @param contexts The set of contexts to use with the
     *     specified amounts
     * @return A map of currencies to balances that this account holds
     */
    Map<Currency, BigDecimal> getBalances(Set<Context> contexts);

    /**
     * Returns a {@link Map} of all currently set balances the account holds
     * within the current active {@link Context}s.2
     *
     * <p>Amounts may differ depending on the {@link Context}s specified and
     * the implementation. The set of {@link Context}s may be empty.</p>
     *
     * <p>{@link Currency} amounts which are 0 may or may not be included in
     * the returned mapping.</p>
     *
     * <p>Changes to the returned {@link Map} will not be reflected in
     * the underlying {@link Account} and may result in runtime exceptions
     * depending on implementation. See
     * {@link #setBalance(Currency, BigDecimal, Cause, Set)}  to set values.</p>
     *
     * @return A map of currencies to balances that this account holds
     */
    default Map<Currency, BigDecimal> getBalances() {
        return this.getBalances(this.getActiveContexts());
    }

    /**
     * Sets the balance for this account to the specified amount for
     * the specified {@link Currency}, with the specified set of {@link Context}s.
     *
     * <p>Negative balances may or may not be supported depending on
     * the {@link Currency} specified and the implementation.</p>
     *
     * @param currency The currency to set the balance for
     * @param amount The amount to set for the specified currency
     * @param cause The cause for the transaction
     * @param contexts The set of contexts to use with the
     *     specified currency
     * @return The result of the transaction
     */
    EconomyTransactionResult setBalance(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Sets the balance for this account to the specified amount for the
     * specified {@link Currency}, with the current active {@link Context}s.
     *
     * <p>Negative balances may or may not be supported depending on
     * the {@link Currency} specified and the implementation.</p>
     *
     * @param currency The currency to set the balance for
     * @param amount The amount to set for the specified currency
     * @param cause The cause for the transaction
     * @return The result of the transaction
     */
    default EconomyTransactionResult setBalance(Currency currency, BigDecimal amount, Cause cause) {
        return this.setBalance(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Resets the balances for all {@link Currency}s used on this account
     * to their default values ({@link #getDefaultBalance(Currency)}),
     * using the specified {@link Context}s.
     *
     * @param cause The cause for the transaction
     * @param contexts the contexts to use when resetting the balances.
     * @return A map of currencies to transaction results. Each
     *     entry represents the result of resetting a particular currency
     */
    Map<Currency, EconomyTransactionResult> resetBalances(Cause cause, Set<Context> contexts);

    /**
     * Resets the balances for all {@link Currency}s used on this account to
     * their default values ({@link #getDefaultBalance(Currency)}), using
     * the current active {@link Context}.
     *
     * @param cause The cause of the transaction
     * @return A map of currencies to transaction results. Each
     *     entry represents the result of resetting a particular currency
     */
    default Map<Currency, EconomyTransactionResult> resetBalances(Cause cause) {
        return this.resetBalances(cause, this.getActiveContexts());
    }

    /**
     * Resets the balance for the specified {@link Currency} to its default
     * value ({@link #getDefaultBalance(Currency)}), using
     * the specified {@link Context}s.
     *
     * @param currency The currency to reset the balance for
     * @param cause The cause for the transaction
     * @param contexts The contexts to use when resetting the balance
     * @return The result of the transaction
     */
    EconomyTransactionResult resetBalance(Currency currency, Cause cause, Set<Context> contexts);

    /**
     * Resets the balance for the specified {@link Currency} to its default
     * value ({@link #getDefaultBalance(Currency)}),
     * using the current active {@link Context}s.
     *
     * @param currency The currency to reset the balance for
     * @param cause The cause for the transaction
     * @return The result of the transaction
     */
    default EconomyTransactionResult resetBalance(Currency currency, Cause cause) {
        return this.resetBalance(currency, cause, this.getActiveContexts());
    }

    /**
     * Deposits the specified amount of the specified {@link Currency} to
     * this account, using the specified {@link Context}s.
     *
     * @param currency The currency to deposit the specified amount for
     * @param amount The amount to deposit for the specified currency
     * @param cause The cause for the transaction
     * @param contexts The contexts to use with the specified currency
     * @return The result of the transaction
     */
    EconomyTransactionResult deposit(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Deposits the given amount of the specified {@link Currency} to
     * this account, using the current active {@link Context}s.
     *
     * @param currency The currency to deposit the specified amount for
     * @param amount The amount to deposit for the specified currency
     * @param cause The cause for the transaction
     * @return The result of the transaction
     */
    default EconomyTransactionResult deposit(Currency currency, BigDecimal amount, Cause cause) {
        return this.deposit(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Withdraws the specified amount of the specified {@link Currency} from
     * this account, using the specified {@link Context}s.
     *
     * @param currency The currency to deposit the specified amount for
     * @param amount The amount to deposit for the specified currency
     * @param cause The cause for the transaction
     * @param contexts The contexts to use with the specified currency
     * @return The result of the transaction
     */
    EconomyTransactionResult withdraw(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Withdraws the specified amount of the specified {@link Currency} from
     * this account, using the current active {@link Context}s.
     *
     * @param currency The currency to deposit the specified amount for
     * @param amount The amount to deposit for the specified currency
     * @param cause The cause for the transaction
     * @return The result of the transaction
     */
    default EconomyTransactionResult withdraw(Currency currency, BigDecimal amount, Cause cause) {
        return this.withdraw(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Transfers the specified amount of the specified {@link Currency}
     * from this account the destination account,
     * using the specified {@link Context}s.
     *
     * <p>This operation is a merged {@link #withdraw(Currency, BigDecimal, Cause, Set)}
     * from this account with a {@link #deposit(Currency, BigDecimal, Cause, Set)}
     * into the specified account.</p>
     *
     * @param to The account to transfer the amounts to.
     * @param currency The currency to transfer the specified amount for
     * @param amount The amount to transfer for the specified currency
     * @param cause The cause for the transaction
     * @param contexts The contexts to use with the
     *     specified currency and account
     * @return A transfer result representative of the effects of the operation
     */
    EconomyTransferResult transfer(Account to, Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Transfers the specified amount of the specified {@link Currency}
     * from this account the destination account,
     * using the current active {@link Context}s.
     *
     * <p>This operation is a merged {@link #withdraw(Currency, BigDecimal, Cause, Set)}
     * from this account with a {@link #deposit(Currency, BigDecimal, Cause, Set)}
     * into the specified account.</p>
     *
     * @param to The account to transfer the amounts to.
     * @param currency The currency to transfer the specified amount for
     * @param amount The amount to transfer for the specified currency
     * @param cause The cause for the transaction
     * @return A transfer result representative of the effects of the operation
     */
    default EconomyTransferResult transfer(Account to, Currency currency, BigDecimal amount, Cause cause) {
        return this.transfer(to, currency, amount, cause, this.getActiveContexts());
    }
}
