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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * A catalog of different {@link AccountDeletionResult deletion results} that
 * could occur when deleting an {@link Account}.
 *
 * <p>The following must be registered by Sponge implementations, but
 * economy service implementors can implement their own as well.</p>
 *
 * @see AccountDeletionResult
 */
public final class AccountDeletionResults {

    // SORTFIELDS:ON

    /**
     * Specifies that the account did not exist when attempting deletion.
     */
    public static final Supplier<AccountDeletionResult> ABSENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "ABSENT");

    /**
     * Specifies that the account could not be deleted.
     */
    public static final Supplier<AccountDeletionResult> FAILED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "FAILED");

    /**
     * Specifies that the account was successfully deleted.
     */
    public static final Supplier<AccountDeletionResult> SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "SUCCESS");

    /**
     * Specifies that account is indelible, possibly due to being
     * a server account or necessary for plugin functionality.
     */
    public static final Supplier<AccountDeletionResult> UNDELETABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "UNDELETABLE");

    /**
     * If deletion is not supported by the economy service in general
     * or for this specific account.
     *
     * <p>This is better used only if your economy service does not support
     * deleting any type of economy accounts. More specific result types
     * would fit other cases better.</p>
     */
    public static final Supplier<AccountDeletionResult> UNSUPPORTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "UNSUPPORTED");

    // SORTFIELDS:OFF

    private AccountDeletionResults() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
