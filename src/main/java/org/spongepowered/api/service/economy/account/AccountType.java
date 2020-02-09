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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * A type of economy account with some default settings as well as related
 * functionality.
 *
 * <p>Unlike many other {@link CatalogType}s, account type has no predefined
 * values. General plugins as well as the economy service implementor may
 * introduce new types, but if you do not have access specific type or one in
 * mind, then {@link EconomyService#getDefaultAccountType()} can be used.</p>
 *
 * <p>If a type was previously registered but can no longer be found,
 * economy service implementors should general fall back to the default
 * account type.</p>
 */
public interface AccountType extends CatalogType {

    /**
     * Gets whether this account type is meant for more than one owner.
     *
     * @return If the account type is meant for multiple owners
     */
    boolean isShared();

    /**
     * Gets the default balance of this account type for the specified
     * {@link Currency}.
     *
     * <p>The default balance is used when the balance is retrieved for the
     * first time for a given {@link Currency} on an account with this type,
     * if no balance is available for the {@link Context}s used when retrieving
     * a balance, or if the account's balance is reset.</p>
     *
     * @param currency The currency to get the default balance for
     * @return The default balance for the specified currency
     */
    BigDecimal getDefaultBalance(Currency currency);

    /**
     * Gets the minimum balance of this account type for the
     * specified currency if one exists.
     *
     * @param currency The currency to get the minimum for
     * @return The maximum balance, if it exists
     */
    Optional<BigDecimal> minimumBalance(Currency currency);

    /**
     * Gets the maximum balance of this account type for the
     * specified currency if one exists.
     *
     * @param currency The currency to get the maximum for
     * @return The maximum balance, if it exists
     */
    Optional<BigDecimal> maximumBalance(Currency currency);

}
