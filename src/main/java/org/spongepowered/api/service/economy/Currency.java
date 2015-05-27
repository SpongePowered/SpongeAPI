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

import com.google.common.base.Optional;

/**
 * TODO: entire documentation.
 *
 */
public interface Currency {

    /**
     * The currency's display name, in singular form. Ex: Dollar.
     * 
     * @return displayName of the currency singular
     */
    String getDisplayName();

    /**
     * The currency's display name in plural form. Ex: Dollars.
     * 
     * <p>The plural name is not necessary as not all currencies will have a
     * plural name that differs from the display name.</p>
     * 
     * @return displayName of the currency plural
     */
    Optional<String> getPluralDisplayName();

    /**
     * The currency's symbol. Ex. $
     * 
     * 
     * @return symbol of the currency
     */
    Optional<String> getSymbol();

    /**
     * Formats the given amount using the default number of fractional digits.
     * 
     * <p>Should include the symbol if it is present</p>
     * 
     * @param amount to format
     * @return String formatted amount
     */
    String format(BigDecimal amount);

    /**
     * Formats the given amount using the specified number of fractional digits.
     * 
     *  <p>Should include the symbol if it is present</p>
     * 
     * @param amount
     * @param numFractionDigits
     * @return String formatted amount.
     */
    String format(BigDecimal amount, int numFractionDigits);

    /**
     * Returns the amount that this currency would convert into of the given
     * currency type.
     * 
     * <p>The amount may be absent if this currency can not be converted into
     * the currency that is specified</p>
     * 
     * @param currency to convert into
     * @param amount to convert
     * @return optional converted amount
     */
    Optional<BigDecimal> convertTo(Currency currencyTo, BigDecimal amount);

    /**
     * Checks if this currency is allowed to be converted into the specified
     * currency.
     * 
     * @param currency to convert into
     * @return
     */
    boolean canConvertTo(Currency currencyTo);

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
