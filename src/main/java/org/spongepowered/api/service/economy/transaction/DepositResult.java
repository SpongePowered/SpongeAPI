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
package org.spongepowered.api.service.economy.transaction;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Account;
import org.spongepowered.api.service.economy.Currency;

import com.google.common.base.Optional;

public final class DepositResult implements TransactionResult {

    private final Account account;
    private final String message;
    private final ResultType result;
    private final Map<Currency, BigDecimal> amounts;
    private final Optional<Set<Context>> contexts;

    public DepositResult(Account account, Map<Currency, BigDecimal> amounts, Optional<Set<Context>> contexts, ResultType result, String message) {
        this.account = account;
        this.message = message;
        this.amounts = Collections.unmodifiableMap(amounts);
        this.contexts = contexts;
        this.result = result;
    }

    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ResultType getResult() {
        return result;
    }

    @Override
    public Optional<Set<Context>> getContexts() {
        return contexts;
    }

    /**
     * Return the {@link Account} that the deposit was attempted on
     * 
     * @return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns an unmodifiable view of the amounts map detailing the {@link Currency}s
     * and {@link BigDecimal} amounts that were used in the deposit attempt. 
     * 
     * @return map of amounts
     */
    public Map<Currency, BigDecimal> getAmounts() {
        return amounts;
    }

}
