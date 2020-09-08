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
package org.spongepowered.api.command.parameter.managed.clientcompletion;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.parameter.managed.ValueParser;

import java.util.function.Supplier;

/**
 * Supported {@link ClientCompletionTypes}.
 */
public final class ClientCompletionTypes {

    // SORTFIELDS: ON

    /**
     * Indicates to the client that the {@link ValueParser} will parse a
     * decimal number.
     */
    public static final Supplier<ClientCompletionType> DECIMAL_NUMBER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "decimal_number");

    /**
     * Indicates to the client that the {@link ValueParser} will parse Json.
     */
    public static final Supplier<ClientCompletionType> JSON =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "json");

    /**
     * Hides this element from the client - useful for if the
     * {@link ValueParser} does not parse any part of the string.
     */
    public static final Supplier<ClientCompletionType> NONE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "none");

    /**
     * Indicates to the client that the {@link ValueParser} is a
     * {@link ResourceKey}.
     */
    public static final Supplier<ClientCompletionType> RESOURCE_KEY =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "resource_key");

    /**
     * Indicates to the client that the {@link ValueParser} is a standard
     * string.
     *
     * <p>This is the default behaviour for any custom {@link ValueParser}.</p>
     */
    public static final Supplier<ClientCompletionType> STRING =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "string");

    /**
     * Indicates to the client that the {@link ValueParser} accepts a whole
     * number.
     */
    public static final Supplier<ClientCompletionType> WHOLE_NUMBER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionType.class, "whole_number");

    // SORTFIELDS: OFF

    private ClientCompletionTypes() {
        throw new IllegalStateException("This should not be callable");
    }

}
