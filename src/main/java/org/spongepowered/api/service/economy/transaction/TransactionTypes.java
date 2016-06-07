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

import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class TransactionTypes {
    // SORTFIELDS:ON

    /**
     * Represents a transaction where an {@link Account} received some amount of a {@link Currency}.
     */
    public static final TransactionType DEPOSIT = DummyObjectProvider.createFor(TransactionType.class, "DEPOSIT");

    /**
     * Represents a transaction where an {@link Account} transferred some amount of a currency to another {@link Account}.
     */
    public static final TransactionType TRANSFER = DummyObjectProvider.createFor(TransactionType.class, "TRANSFER");

    /**
     * Represents a transaction where an {@link Account} lost some amount of a {@link Currency}.
     */
    public static final TransactionType WITHDRAW = DummyObjectProvider.createFor(TransactionType.class, "WITHDRAW");

    // SORTFIELDS:OFF

    private TransactionTypes() {
    }

}
