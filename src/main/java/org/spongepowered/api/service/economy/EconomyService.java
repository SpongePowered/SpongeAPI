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

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.ContextualService;
import org.spongepowered.api.service.economy.transaction.TransactionCallback;

import com.google.common.base.Optional;

/**
 * TODO: overview doc
 *
 */
public interface EconomyService extends ContextualService<Account> {

    /**
     * Retrieves the default {@link Currency} used by the {@link EconomyService}.
     * 
     * @return {@link Currency} default for the EconomyService
     * 
     * @see Currency
     */
    Currency getDefaultCurrency();

    /**
     * Returns the {@link Collection} of supported {@link Currency} objects that are
     * implemented by this EconomyService.
     * 
     * <p>The collection returned is only a view of all currencies available in the
     * EconomyService.  Attempting to inject new currencies may or may not work and 
     * may cause an exception to be raised depending on implementation.</p>
     * 
     * @return Collection of all Currencies
     */
    Collection<Currency> getCurrencies();

    /**
     * Search for an {@link Account} with the given identifier. If no account is
     * found then {@link Optional<Account>#absent()} will be returned.
     * 
     * 
     * @param identifier
     * @return optional account
     */
    Optional<Account> getAccount(String identifier);

    /**
     * Get all {@link Account}s associated to the given User UUID. Optionally filtered 
     * by a set of {@link Context}s.
     * 
     * <p>The collection returned is only a view of the user's accounts. Changes
     * will not be reflected back into the economy, and attempts to manipulate the
     * collection may cause exceptions depending on implementation.</p>
     * 
     * @param uuid of the user
     * @param optional set of {@link Context}s
     * @return accounts Collection of {@link Account}s
     */
    Collection<Account> getAccounts(UUID uuid, Optional<Set<Context>> contexts);

    /**
     * Get the {@link Wallet} associated with the given {@link User} UUID.
     * 
     * <p>If no wallet is currently setup, this method will create a new wallet. </p>
     * 
     * @param uuid of the user
     * @return wallet the user's {@link Wallet}
     */
    Wallet getWallet(UUID uuid);

    /**
     * Registers a {@link TransactionCallback} with the EconomyService to be notified of
     * any transactions that take place.
     * 
     * <p>This should be utilized for any plugins that want to log the results of 
     * calls into the EconomyService or for other uses that need to monitor the
     * service usage</p>
     * 
     * @param callback
     */
    void registerTransactionCallback(TransactionCallback callback);
}
