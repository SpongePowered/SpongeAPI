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
package org.spongepowered.api.command.selector;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * All {@link SelectorType}s available in Minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class SelectorTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Selects all entities.
     *
     * <p>Equivalent to {@code @e}.</p>
     */
    public static final DefaultedRegistryReference<SelectorType> ALL_ENTITIES = SelectorTypes.key(ResourceKey.sponge("all_entities"));

    /**
     * Selects all players.
     *
     * <p>Equivalent to {@code @a}.</p>
     */
    public static final DefaultedRegistryReference<SelectorType> ALL_PLAYERS = SelectorTypes.key(ResourceKey.sponge("all_players"));

    /**
     * Selects the nearest player.
     *
     * <p>Equivalent to {@code @p}.</p>
     */
    public static final DefaultedRegistryReference<SelectorType> NEAREST_PLAYER = SelectorTypes.key(ResourceKey.sponge("nearest_player"));

    /**
     * Selects the nearest player.
     *
     * <p>Equivalent to {@code @r}.</p>
     */
    public static final DefaultedRegistryReference<SelectorType> RANDOM_PLAYER = SelectorTypes.key(ResourceKey.sponge("random_player"));

    /**
     * Selects the context of the selector, if the context is an entity.
     *
     * <p>Equivalent to {@code @s}.</p>
     */
    public static final DefaultedRegistryReference<SelectorType> SOURCE = SelectorTypes.key(ResourceKey.sponge("source"));

    // SORTFIELDS:OFF

    // @formatter:on

    private SelectorTypes() {
    }

    public static Registry<SelectorType> registry() {
        return Sponge.game().registry(RegistryTypes.SELECTOR_TYPE);
    }

    private static DefaultedRegistryReference<SelectorType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.SELECTOR_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
