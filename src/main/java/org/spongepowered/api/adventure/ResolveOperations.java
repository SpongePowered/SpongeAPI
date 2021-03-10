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
package org.spongepowered.api.adventure;

import net.kyori.adventure.translation.GlobalTranslator;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Types of rendering that can be applied to components.
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public class ResolveOperations {

    // @formatter:off
    // SORTFIELDS:ON

    /**
     * Resolve contextual components.
     *
     * <p>Some components (Selectors, NBT, and Score) must be resolved based on
     * server information before being sent to the client. This performs that
     * resolution.</p>
     */
    public static final DefaultedRegistryReference<ResolveOperation> CONTEXTUAL_COMPONENTS = ResolveOperations.key(ResourceKey.sponge("contextual_components"));

    /**
     * Apply custom translations.
     *
     * <p>These are translations registered by plugins, <em>not</em> Vanilla or
     * resource pack-provided translations. Those translations are already
     * resolved clientside, so the information is not loaded on the server.</p>
     *
     * <p>In normal message sending to players and consoles, custom translations
     * are automatically resolved. This resolution operation is primarily
     * intended for performing analysis of components
     * before (or without) sending.</p>
     *
     * @see GlobalTranslator to register translations
     */
    public static final DefaultedRegistryReference<ResolveOperation> CUSTOM_TRANSLATIONS = ResolveOperations.key(ResourceKey.sponge("custom_translations"));

    // SORTFIELDS:OFF
    // @formatter:ON

    private ResolveOperations() {
    }

    private static DefaultedRegistryReference<ResolveOperation> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.RESOLVE_OPERATION, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }

}
