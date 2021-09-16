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
package org.spongepowered.api.placeholder;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Contains Sponge provided {@link PlaceholderParser}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class PlaceholderParsers {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * A parser that returns the associated source's current world, if
     * applicable, else the default world.
     */
    public static final DefaultedRegistryReference<PlaceholderParser> CURRENT_WORLD = PlaceholderParsers.key(ResourceKey.sponge("current_world"));

    /**
     * A parser that returns the associated source's name.
     */
    public static final DefaultedRegistryReference<PlaceholderParser> NAME = PlaceholderParsers.key(ResourceKey.sponge("name"));

    // SORTFIELDS:OFF

    // @formatter:on

    private PlaceholderParsers() {
    }

    private static DefaultedRegistryReference<PlaceholderParser> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.PLACEHOLDER_PARSER, location).asDefaultedReference(Sponge::game);
    }
}
