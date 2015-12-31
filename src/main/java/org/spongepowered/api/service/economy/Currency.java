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

import org.spongepowered.api.text.Text;

import java.math.BigDecimal;

/**
 * Represents a form of currency. At least one type of currency is always supported.
 * Depending on the provider of the {@link EconomyService}, more currencies may be available.
 */
public interface Currency {

    /**
     * The currency's display name, in singular form. Ex: Dollar.
     *
     * @return displayName of the currency singular
     */
    Text getDisplayName();

    /**
     * The currency's display name in plural form. Ex: Dollars.
     *
     * <p>Not all currencies will have a plural name that differs from the
     * display name.</p>
     *
     * @return displayName of the currency plural
     */
    Text getPluralDisplayName();

    /**
     * The currency's symbol. Ex. $
     *
     * @return symbol of the currency
     */
    Text getSymbol();

    /**
     * Formats the given amount using the default number of fractional digits.
     *
     * <p>Should include the symbol if it is present</p>
     *
     * @param amount to format
     * @return String formatted amount
     */
    Text format(BigDecimal amount);

    /**
     * Formats the given amount using the specified number of fractional digits.
     *
     *  <p>Should include the symbol if it is present</p>
     *
     * @param amount
     * @param numFractionDigits
     * @return String formatted amount.
     */
    Text format(BigDecimal amount, int numFractionDigits);

    /**
     * This is the default number of fractional digits that is utilized for
     * formatting purposes.
     *
     * @return defaultFractionDigits utilized.
     */
    int getDefaultFractionDigits();

    /**
     * Returns true if this currency is the default currency for the economy,
     * otherwise false.
     *
     * @return true if this is the default currency
     */
    boolean isDefault();

}
