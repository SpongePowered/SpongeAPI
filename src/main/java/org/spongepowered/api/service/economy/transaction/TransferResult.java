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
import java.util.Map;
import java.util.Set;

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Account;
import org.spongepowered.api.service.economy.Currency;

import com.google.common.base.Optional;

public final class TransferResult implements TransactionResult {

    private final Account accountTo;
    private final Account accountFrom;
    private final String message;
    private final ResultType result;
    private final Optional<Set<Context>> contexts;

    public TransferResult(Account from, Account to, Map<Currency, BigDecimal> amounts, Optional<Set<Context>> contexts, ResultType result, 
            String message) {

        this.accountTo = to;
        this.accountFrom = from;
        this.contexts = contexts;
        this.result = result;
        this.message = message;
    }

    @Override

    public TransactionType getType() {
        return TransactionType.TRANSFER;
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
     * returns the {@link Account} that the amounts of currencies are being deposited
     * into.
     * 
     * @return the to account
     */
    public Account getAccountTo() {
        return accountTo;
    }

    /**
     * Returns the {@link Account} that the amounts of currencies are being
     * withdrawn from.
     * 
     * @return the from account
     */
    public Account getAccountFrom() {
        return accountFrom;
    }

}
