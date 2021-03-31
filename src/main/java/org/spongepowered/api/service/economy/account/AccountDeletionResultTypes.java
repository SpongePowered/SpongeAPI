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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Common {@link AccountDeletionResultType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class AccountDeletionResultTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<AccountDeletionResultType> ABSENT = AccountDeletionResultTypes.key(ResourceKey.sponge("absent"));

    public static final DefaultedRegistryReference<AccountDeletionResultType> FAILED = AccountDeletionResultTypes.key(ResourceKey.sponge("failed"));

    public static final DefaultedRegistryReference<AccountDeletionResultType> SUCCESS = AccountDeletionResultTypes.key(ResourceKey.sponge("success"));

    public static final DefaultedRegistryReference<AccountDeletionResultType> UNDELETABLE = AccountDeletionResultTypes.key(ResourceKey.sponge("undeletable"));

    // SORTFIELDS:OFF

    // @formatter:on

    private AccountDeletionResultTypes() {
    }

    private static DefaultedRegistryReference<AccountDeletionResultType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ACCOUNT_DELETION_RESULT_TYPE, location).asDefaultedReference(() -> Sponge
                .game().registries());
    }
}
