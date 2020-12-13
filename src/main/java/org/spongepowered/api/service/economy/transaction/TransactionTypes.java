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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class TransactionTypes {

    // @formatter:off

    // SORTFIELDS:ON
    /**
     * Represents a transaction where an {@link Account} received some amount of a {@link Currency}.
     */
    public static final DefaultedRegistryReference<TransactionType> DEPOSIT = TransactionTypes.key(ResourceKey.sponge("deposit"));

    /**
     * Represents a transaction where an {@link Account} transferred some amount of a currency to another {@link Account}.
     */
    public static final DefaultedRegistryReference<TransactionType> TRANSFER = TransactionTypes.key(ResourceKey.sponge("transfer"));

    /**
     * Represents a transaction where an {@link Account} lost some amount of a {@link Currency}.
     */
    public static final DefaultedRegistryReference<TransactionType> WITHDRAW = TransactionTypes.key(ResourceKey.sponge("withdraw"));

    // SORTFIELDS:OFF

    // @formatter:on

    private TransactionTypes() {
    }

    private static DefaultedRegistryReference<TransactionType> key(final ResourceKey location) {
        return RegistryKey.<TransactionType>of(Registries.TRANSACTION_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
