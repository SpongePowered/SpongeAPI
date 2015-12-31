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
import org.spongepowered.api.service.economy.account.UserAccount;
import org.spongepowered.api.service.economy.account.VirtualAccount;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

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
     * EconomyService. Attempting to inject new currencies may or may not work and
     * may cause an exception to be raised depending on implementation.</p>
     *
     * @return Collection of all Currencies
     */
    Collection<Currency> getCurrencies();

    /**
     * Gets the {@link UserAccount} with the specified {@link UUID}, if available.
     *
     * @param uuid The {@link UUID} of the account to get
     * @return The {@link UserAccount}, if available.
     */
    Optional<UserAccount> getAccount(UUID uuid);

    /**
     * Attempts to create a {@link UserAccount} for the user with the specified {@link UUID}.
     *
     * <p>If an account already exists for the user with the specified {@link UUID}, it will be
     * returned. No further action will be taken.</p>
     *
     * <p>Creation may fail if the provided {@link UUID} does not correspond to an actual
     * player, or for an implementation-defined reason.</p>
     *
     * @param uuid The {@link UUID} of the account to create.
     * @return The created {@link UserAccount}, if available.
     */
    Optional<UserAccount> createAccount(UUID uuid);

    /**
     * Gets the {@link VirtualAccount} with the specified identifier, if available.
     *
     * @param identifier The identifier of the account to get
     * @return The {@link VirtualAccount}, if available.
     */
    Optional<VirtualAccount> getVirtualAccount(String identifier);

    /**
     * Attempts to create a {@link VirtualAccount} with the specified identifier
     *
     * <p>If an account already exists with the specified identifier, it will be
     * returned. No further action will be taken.</p>
     *
     * <p>Creation may fail for an implementation-defined reason.</p>
     *
     * @param identifier The identifier of the account to create.
     * @return The created {@link VirtualAccount}, if available.
     */
    Optional<VirtualAccount> createVirtualAccount(String identifier);
}
