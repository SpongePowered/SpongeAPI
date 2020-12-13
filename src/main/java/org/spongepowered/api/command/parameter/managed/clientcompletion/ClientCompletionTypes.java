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
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * Supported {@link ClientCompletionTypes}.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ClientCompletionTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Indicates to the client that the {@link ValueParser} will parse a
     * decimal number.
     */
    public static final DefaultedRegistryReference<ClientCompletionType> DECIMAL_NUMBER = ClientCompletionTypes.key(ResourceKey.sponge("decimal_number"));

    /**
     * Indicates to the client that the {@link ValueParser} will parse Json.
     */
    public static final DefaultedRegistryReference<ClientCompletionType> JSON = ClientCompletionTypes.key(ResourceKey.sponge("json"));

    /**
     * Hides this element from the client - useful for if the
     * {@link ValueParser} does not parse any part of the string.
     */
    public static final DefaultedRegistryReference<ClientCompletionType> NONE = ClientCompletionTypes.key(ResourceKey.sponge("none"));

    /**
     * Indicates to the client that the {@link ValueParser} is a
     * {@link ResourceKey}.
     */
    public static final DefaultedRegistryReference<ClientCompletionType> RESOURCE_KEY = ClientCompletionTypes.key(ResourceKey.sponge("resource_key"));

    /**
     * Indicates to the client that the {@link ValueParser} is a standard
     * string.
     *
     * <p>This is the default behaviour for any custom {@link ValueParser}.</p>
     */
    public static final DefaultedRegistryReference<ClientCompletionType> STRING = ClientCompletionTypes.key(ResourceKey.sponge("string"));

    /**
     * Indicates to the client that the {@link ValueParser} accepts a whole
     * number.
     */
    public static final DefaultedRegistryReference<ClientCompletionType> WHOLE_NUMBER = ClientCompletionTypes.key(ResourceKey.sponge("whole_number"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ClientCompletionTypes() {
    }

    private static DefaultedRegistryReference<ClientCompletionType> key(final ResourceKey location) {
        return RegistryKey.<ClientCompletionType>of(Registries.CLIENT_COMPLETION_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
