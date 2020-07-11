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

import org.spongepowered.api.service.context.ContextualService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.AccountDeletionResultType;
import org.spongepowered.api.service.economy.account.AccountDeletionResultTypes;
import org.spongepowered.api.service.economy.account.AccountHolder;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
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
     * Retrieves the default {@link Currency} used by the
     * {@link EconomyService}.
     *
     * @return {@link Currency} default for the EconomyService
     *
     * @see Currency
     */
    Currency getDefaultCurrency();

    /**
     * Returns whether a {@link Account} exists for the specified
     * {@link AccountHolder}.
     *
     * @param holder The {@link AccountHolder} of the account to check for
     * @return Whether a {@link Account} exists for the specified {@link AccountHolder}
     */
    boolean hasAccount(AccountHolder holder);

    /**
     * Returns whether an {@link Account} with the specified identifier exists.
     *
     * @param identifier The identifier of the account to check for
     * @return Whether an {@link Account} with the specified identifier exists
     */
    boolean hasAccount(String identifier);

    /**
     * Gets the {@link Account} for the specified {@link AccountHolder}.
     *
     * <p>If an account does not already exist for the specified {@link AccountHolder},
     * it will be created.</p>
     *
     * @param holder The {@link AccountHolder} of the account to get.
     * @return The {@link Account}, if available.
     */
    Optional<Account> getOrCreateAccount(AccountHolder holder);

    /**
     * Gets the {@link Account} with the specified identifier.
     *
     * <p>If an account does not already exist with the specified identifier,
     * it will be created.</p>
     *
     * <p>Creation may fail for an implementation-defined reason.</p>
     *
     * @param identifier The identifier of the account to get.
     * @return The {@link Account}, if available.
     */
    Optional<Account> getOrCreateAccount(String identifier);

    /**
     * Gets a {@link Stream} of all available {@link Account}s.
     *
     * @return A stream of all {@link Account}s.
     */
    Stream<Account> streamAccounts();

    /**
     * Gets a {@link Collection} of all available {@link Account}s.
     *
     * @return A Collection of all {@link Account}s.
     */
    Collection<Account> getUniqueAccounts();

    /**
     * Deletes the account for the specified {@link AccountHolder}.
     *
     * @param holder The {@link AccountHolder} of the account to delete.
     * @return The result of the deletion.
     */
    default AccountDeletionResultType deleteAccount(AccountHolder holder) {
        return AccountDeletionResultTypes.UNSUPPORTED;
    }

    /**
     * Deletes the account with the specified identifier.
     *
     * <p>If an account exists with the specified identifier,
     * it will be deleted.</p>
     *
     * <p>Deletion may fail for an implementation-defined reason.</p>
     *
     * @param identifier The identifier of the account to delete.
     * @return The result of the deletion.
     */
    default AccountDeletionResultType deleteAccount(String identifier) {
        return AccountDeletionResultTypes.UNSUPPORTED;
    }
}
