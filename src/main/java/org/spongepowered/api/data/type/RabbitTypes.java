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
package org.spongepowered.api.data.type;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of vanilla {@link RabbitType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class RabbitTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<RabbitType> BLACK = RabbitTypes.key(ResourceKey.sponge("black"));

    public static final DefaultedRegistryReference<RabbitType> BLACK_AND_WHITE = RabbitTypes.key(ResourceKey.sponge("black_and_white"));

    public static final DefaultedRegistryReference<RabbitType> BROWN = RabbitTypes.key(ResourceKey.sponge("brown"));

    public static final DefaultedRegistryReference<RabbitType> GOLD = RabbitTypes.key(ResourceKey.sponge("gold"));

    public static final DefaultedRegistryReference<RabbitType> KILLER = RabbitTypes.key(ResourceKey.sponge("killer"));

    public static final DefaultedRegistryReference<RabbitType> SALT_AND_PEPPER = RabbitTypes.key(ResourceKey.sponge("salt_and_pepper"));

    public static final DefaultedRegistryReference<RabbitType> WHITE = RabbitTypes.key(ResourceKey.sponge("white"));

    // SORTFIELDS:OFF

    // @formatter:on

    private RabbitTypes() {
    }

    public static Registry<RabbitType> registry() {
        return Sponge.game().registry(RegistryTypes.RABBIT_TYPE);
    }

    private static DefaultedRegistryReference<RabbitType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.RABBIT_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
