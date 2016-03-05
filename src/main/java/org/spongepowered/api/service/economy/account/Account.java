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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.Contextual;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.service.economy.transaction.TransferResult;
import org.spongepowered.api.text.Text;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an account, which stores amounts of various {@link Currency currencies}.
 *
 * <p>Accounts come in two varieties: {@link UniqueAccount user accounts} and {@link VirtualAccount} virtual accounts.
 *
 * Unique accounts are bound to a {@link UUID}, usually of a particular {@link User}'s {@link GameProfile}.
 *
 * Virtual accounts are identified by a String identifier, which may have any
 * value. They are not tied to any {@link Entity}, player or otherwise. Virtual
 * accounts may be used for purposes such as bank accounts, non-player {@link Entity} accounts, or other things.</p>
 */
public interface Account extends Contextual {

    /**
     * Gets the display name for this account.
     *
     * <p>This should be used by plugins to get a human-readable name for an
     * account, regardless of the specific type ({@link UniqueAccount} or
     * {@link VirtualAccount}).</p>
     *
     * <p>Its contents are dependent on the provider of {@link EconomyService}.
     * For example, an economy plugin could allow players to configure the
     * display name of their account</p>.
     *
     * @return the display name for this account.
     */
    Text getDisplayName();

    /**
     * Gets the default currency for this account.
     *
     * <p>Consumers of the Economy API should use an account's default currency for transactions
     * with it, unless they have a specific reason not to (such as a user manually specifying
     * a different currency</p>.
     *
     * @return The default currency for this account
     */
    default Currency getDefaultCurrency() {
        return Sponge.getServiceManager().provide(EconomyService.class).get().getDefaultCurrency();
    }

    /**
     * Gets the default balance of this account for the specified
     * {@link Currency}.
     *
     * <p>The default balance is used when the balance is retrieved for the
     * first time for a given {@link Currency} on this account, or if no
     * balance is available for the {@link Context}s used when retrieving
     * a balance.</p>
     *
     * @param currency the currency to get the default balance for.
     * @return The default balance for the specified {@link Currency}.
     */
    BigDecimal getDefaultBalance(Currency currency);

    /**
     * Gets the default balance of this account for this account's
     * default currency.
     *
     * <p>The default balance is used when the balance is retrieved for the
     * first time for a given {@link Currency} on this account, or if no
     * balance is available for the {@link Context}s used when retrieving
     * a balance.</p>
     *
     * @return The default balance for the default currency.
     */
    default BigDecimal getDefaultBalance() {
        return this.getDefaultBalance(this.getDefaultCurrency());
    }

    /**
     * Returns whether this account has a set balance for the specified
     * {@link Currency}, with the specified {@link Context}s.
     *
     * <p>If this method returns <code>false</code>, then {@link #getDefaultBalance(Currency)}
     * will be used when retrieving a balance for the specifid {@link Currency} with
     * the specified {@link Context}s.</p>
     *
     * @param currency The {@link Currency} to determine if a balance is set for.
     * @param contexts The {@link Context}s to use with the {@link Currency}.
     * @return Whether this account has a set balance for the speicified {@link Currency} and {@link Context}s
     */
    boolean hasBalance(Currency currency, Set<Context> contexts);

    /**
     * Returns whether this account has a set balance for the specified
     * {@link Currency}, with the current active contexts.
     *
     * <p>If this method returns <code>false</code>, then {@link #getDefaultBalance(Currency)}
     * will be used when retrieving a balance for the specifid {@link Currency} with the
     * current active contexts</p>.
     *
     * @param currency The {@link Currency} to determine if a balance is set for.
     * @return Whether this account has a set balance for the speicified {@link Currency} and current active contexts.
     */
    default boolean hasBalance(Currency currency) {
        return this.hasBalance(currency, this.getActiveContexts());
    }

    /**
     * Returns whether this account has a set balance for this account's
     * default {@link Currency}, with the current active contexts.
     *
     * <p>If this method returns <code>false</code>, then {@link #getDefaultBalance(Currency)}
     * will be used when retrieving a balance for the specifid {@link Currency} with the
     * current active contexts</p>.
     *
     * @return Whether this account has a set balance for the default {@link Currency} and current active contexts.
     */
    default boolean hasBalance() {
        return this.hasBalance(this.getDefaultCurrency());
    }

    /**
     * Returns a {@link BigDecimal} representative of the balance stored within this
     * {@link Account} for the {@link Currency} given and the set of {@link Context}s.
     *
     * <p>The default result when the account does not have a balance of the
     * given {@link Currency} should be {@link BigDecimal#ZERO}.</p>
     *
     * <p>The balance may be unavailable depending on the set of {@link Context}s used.</p>
     *
     * @param currency a {@link Currency} to check the balance of
     * @param contexts a set of contexts to check the balance against
     *
     * @return he value for the specified {@link Currency} with the specified {@link Context}s.
     */
    BigDecimal getBalance(Currency currency, Set<Context> contexts);

    /**
     * Returns a {@link BigDecimal} representative of the balance stored within this
     * {@link Account} for the {@link Currency} given, with the current active contexts.
     *
     * <p>The default result when the account does not have a balance of the
     * given {@link Currency} will be {@link #getDefaultBalance(Currency)}.</p>
     *
     * @param currency a {@link Currency} to check the balance of
     *
     * @return the value for the specified {@link Currency}.
     */
    default BigDecimal getBalance(Currency currency) {
        return this.getBalance(currency, this.getActiveContexts());
    }

    /**
     * Returns a {@link BigDecimal} representative of the balance stored within this
     * {@link Account} for this account's default {@link Currency}, with the current active contexts.
     *
     * <p>The default result when the account does not have a balance of the
     * given {@link Currency} will be {@link #getDefaultBalance(Currency)}.</p>
     *
     * @return the value for the default {@link Currency}.
     */
    default BigDecimal getBalance() {
        return this.getBalance(this.getDefaultCurrency());
    }

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
     * {@link Account}.
     * See {@link #setBalance(Currency, BigDecimal, Cause, Set)}  to set values.</p>
     *
     * @param contexts the set of {@link Context}s to use with the speciied amounts.
     *
     * @return {@link Map} of {@link Currency} to {@link BigDecimal} amounts that this
     *         account holds.
     */
    Map<Currency, BigDecimal> getBalances(Set<Context> contexts);

    /**
     * Returns a {@link Map} of all currently set balances the account holds within
     * the current active {@link Context}s.
     *
     * <p>Amounts may differ depending on the {@link Context}s specified and
     * the implementation. The set of {@link Context}s may be empty.</p>
     *
     * <p>{@link Currency} amounts which are 0 may or may not be included in the
     * returned mapping.</p>
     *
     * <p>Changes to the returned {@link Map} will not be reflected in the underlying
     * {@link Account} and may result in runtime exceptions depending on implementation.
     * See {@link #setBalance(Currency, BigDecimal, Cause, Set)}  to set values.</p>
     *
     * @return {@link Map} of {@link Currency} to {@link BigDecimal} amounts that this
     *         account holds.
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
     * @param currency The {@link Currency} to set the balance for
     * @param amount The amount to set for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     * @param contexts The set of {@link Context}s to use with the specified {@link Currency}
     *
     * @return The result of the transaction
     */
    TransactionResult setBalance(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Sets the balance for this account to the specified amount for the
     * specified {@link Currency}, with the current active {@link Context}s.
     *
     * <p>Negative balances may or may not be supported depending on
     * the {@link Currency} specified and the implementation.</p>
     *
     * @param currency The {@link Currency} to set the balance for
     * @param amount The amount to set for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     * @return The result of the transaction
     */
    default TransactionResult setBalance(Currency currency, BigDecimal amount, Cause cause) {
        return this.setBalance(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Sets the balance for this account to the specified amount for this account's
     * default {@link Currency}, with the current active {@link Context}s.
     *
     * <p>Negative balances may or may not be supported depending on
     * the {@link Currency} specified and the implementation.</p>
     *
     * @param amount The amount to set for the default {@link Currency}
     * @param cause The {@link Cause} for the transaction
     * @return The result of the transaction
     */
    default TransactionResult setBalance(BigDecimal amount, Cause cause) {
        return this.setBalance(this.getDefaultCurrency(), amount, cause);
    }

    /**
     * Resets the balances for all {@link Currency}s used on this account to their
     * default values ({@link #getDefaultBalance(Currency)}), using the specified {@link Context}s.
     *
     * @param cause The {@link Cause} for the transaction
     * @param contexts the {@link Context}s to use when resetting the balances.
     *
     * @return The result of the transaction
     */
    TransactionResult resetBalances(Cause cause, Set<Context> contexts);

    /**
     * Resets the balances for all {@link Currency}s used on this account to
     * their default values ({@link #getDefaultBalance(Currency)}), using the current active {@link Context}.
     *
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult resetBalances(Cause cause) {
        return this.resetBalances(cause, this.getActiveContexts());
    }

    /**
     * Resets the balance for the specified {@link Currency} to its default value
     * ({@link #getDefaultBalance(Currency)}), using the specified {@link Context}s.
     *
     * @param currency The {@link Currency} to reset the balance for
     * @param cause The {@link Cause} for the transaction
     * @param contexts The {@link Context}s to use when resetting the balance
     *
     * @return The result of the transaction
     */
    TransactionResult resetBalance(Currency currency, Cause cause, Set<Context> contexts);

    /**
     * Resets the balance for the specified {@link Currency} to its default value
     * ({@link #getDefaultBalance(Currency)}), using the current active {@link Context}s.
     *
     * @param currency The {@link Currency} to reset the balance for
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult resetBalance(Currency currency, Cause cause) {
        return this.resetBalance(currency, cause, this.getActiveContexts());
    }

    /**
     * Resets the balance for this account's default {@link Currency} to its default value
     * ({@link #getDefaultBalance(Currency)}), using the current active {@link Context}s.
     *
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult resetBalance(Cause cause) {
        return this.resetBalance(this.getDefaultCurrency(), cause);
    }

    /**
     * Deposits the specified amount of the specified {@link Currency} to this account,
     * using the specified {@link Context}s.
     *
     * @param currency The {@link Currency} to deposit the specified amount for
     * @param amount The amount to deposit for the specified {@link Currency}.
     * @param cause The {@link Cause} for the transaction
     * @param contexts the {@link Context}s to use with the specified {@link Currency}
     *
     * @return The result of the transaction
     */
    TransactionResult deposit(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Deposits the given amount of the specified {@link Currency} to this account,
     * using the current active {@link Context}s.
     *
     * @param currency The {@link Currency} to deposit the specified amount for
     * @param amount The amount to deposit for the specified {@link Currency}.
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult deposit(Currency currency, BigDecimal amount, Cause cause) {
        return this.deposit(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Deposits the given amount of this account's default {@link Currency} into this account,
     * using the current active {@link Context}s.
     *
     * @param amount The amount to deposit for the specified {@link Currency}.
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult deposit(BigDecimal amount, Cause cause) {
        return this.deposit(this.getDefaultCurrency(), amount, cause);
    }

    /**
     * Withdraws the specified amount of the specified {@link Currency} from this account,
     * using the specified {@link Context}s.
     *
     * @param currency The {@link Currency} to deposit the specifie amount for
     * @param amount The amount to deposit for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     * @param contexts The {@link Context}s to use with the specified {@link Currency}
     *
     * @return The result of the transaction
     */
    TransactionResult withdraw(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Withdraws the specified amount of the specified {@link Currency} from this account,
     * using the current active {@link Context}s.
     *
     * @param currency The {@link Currency} to deposit the specified amount for
     * @param amount The amount to deposit for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult withdraw(Currency currency, BigDecimal amount, Cause cause) {
        return this.withdraw(currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Withdraws the specified amount of this account's default {@link Currency} from this account,
     * using the current active {@link Context}s.
     *
     * @param amount The amount to deposit for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     *
     * @return The result of the transaction
     */
    default TransactionResult withdraw(BigDecimal amount, Cause cause) {
        return this.withdraw(this.getDefaultCurrency(), amount, cause);
    }

    /**
     * Transfers the specified amount of the specified {@link Currency} from this account
     * the destination account, using the specified {@link Context}s.
     *
     * <p>This operation is a merged {@link #withdraw(Currency, BigDecimal, Cause, Set)}  from this account
     * with a {@link #deposit(Currency, BigDecimal, Cause, Set)}  into the specified account.</p>
     *
     * @param to the Account to transfer the amounts to.
     * @param currency The {@link Currency} to transfer the specified amount for
     * @param amount The amount to transfer for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     * @param contexts The {@link Context}s to use with the specified {@link Currency} and account
     *
     * @return a {@link TransferResult} representative of the effects of the
     *         operation
     */
    TransferResult transfer(Account to, Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts);

    /**
     * Transfers the specified amount of the specified {@link Currency} from this account
     * the destination account, using the current active {@link Context}s.
     *
     * <p>This operation is a merged {@link #withdraw(Currency, BigDecimal, Cause, Set)} from this account
     * with a {@link #deposit(Currency, BigDecimal, Cause, Set)} into the specified account.</p>
     *
     * @param to the Account to transfer the amounts to.
     * @param currency The {@link Currency} to transfer the specified amount for
     * @param amount The amount to transfer for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     *
     * @return a {@link TransferResult} representative of the effects of the
     *         operation
     */
    default TransferResult transfer(Account to, Currency currency, BigDecimal amount, Cause cause) {
        return this.transfer(to, currency, amount, cause, this.getActiveContexts());
    }

    /**
     * Transfers the specified amount of this account's default {@link Currency} from this account
     * the destination account, using the current active {@link Context}s.
     *
     * <p>This operation is a merged {@link #withdraw(Currency, BigDecimal, Cause, Set)} from this account
     * with a {@link #deposit(Currency, BigDecimal, Cause, Set)} into the specified account.</p>
     *
     * @param to the Account to transfer the amounts to.
     * @param amount The amount to transfer for the specified {@link Currency}
     * @param cause The {@link Cause} for the transaction
     *
     * @return a {@link TransferResult} representative of the effects of the
     *         operation
     */
    default TransferResult transfer(Account to, BigDecimal amount, Cause cause) {
        return this.transfer(to, this.getDefaultCurrency(), amount, cause);
    }
}
