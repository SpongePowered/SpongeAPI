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

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.service.context.ContextualService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.AccountType;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Represents a service for managing a server economy.
 *
 * <p>Unlike other services provided by the API, the economy service
 * does **not** have an implementation registered by default. Since Vanilla has
 * no concept of economy, the economy service implementation must always be
 * provided by a plugin. This service exists to provide a common API which
 * can be used by implementors and consumers.</p>
 */
public interface EconomyService extends ContextualService<Account> {

    /**
     * Retrieves the default {@link Currency} used by the {@link EconomyService}.
     *
     * @return The default currency for the economy service
     * @see Currency
     */
    Currency getDefaultCurrency();

    /**
     * Retrieves the default {@link AccountType} used by
     * the {@link EconomyService}.
     *
     * @return The default account type for the economy service
     */
    AccountType getDefaultAccountType();

    /**
     * Returns the {@link Set} of supported {@link Currency currencies} that are
     * implemented by this {@link EconomyService}.
     *
     * <p>The economy service provider may only support one currency, in which
     * case {@link #getDefaultCurrency()} will be the only member of the set.</p>
     *
     * <p>The set returned is a read-only a view of all currencies available in
     * the EconomyService.</p>
     *
     * @return The set of all currencies supported by the service
     */
    Set<Currency> getCurrencies();

    /**
     * Gets the account with the specified {@link UUID}, if it exists.
     *
     * @param uniqueId The UUID of the account to get
     * @return The account with the specified UUID, if present
     */
    Optional<Account> getAccount(UUID uniqueId);

    /**
     * Gets the existing default account or creates one for the specified
     * {@link UUID} owner of the default {@link AccountType}.
     *
     * <p>This is the account players will most likely generally use, but
     * this doesn't need to only be used for owners that are users.</p>
     *
     * @param owner Who should be set as the owner of the account
     * @return The account if it was found or made successfully
     */
    Optional<Account> getOrCreateDefaultAccount(UUID owner);

    /**
     * Attempts to create a new account of the specified {@link AccountType}.
     *
     * @param accountType The account type to create the account with
     * @return The account if it was made successfully
     */
    Optional<Account> createAccount(AccountType accountType);

    /**
     * Gets all accounts the specified {@link UUID} has access to as an owner
     * as a read-only collection.
     *
     * @param owner The owner of the accounts
     * @return Read only collection of all accounts owned by the specified owner
     */
    Collection<Account> getAccessibleAccounts(UUID owner);

    /**
     * Gets a read-only set of all accounts present within the
     * {@link EconomyService}.
     *
     * @return Read only set of all economy accounts
     */
    Stream<Account> getAllAccounts();
}
