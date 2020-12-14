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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class GeneratorModifierTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<GeneratorModifierType> AMPLIFIED = GeneratorModifierTypes.key(ResourceKey.sponge("amplified"));

    public static final DefaultedRegistryReference<GeneratorModifierType> DEBUG = GeneratorModifierTypes.key(ResourceKey.sponge("debug"));

    public static final DefaultedRegistryReference<GeneratorModifierType> NONE = GeneratorModifierTypes.key(ResourceKey.sponge("none"));

    public static final DefaultedRegistryReference<GeneratorModifierType> FLAT = GeneratorModifierTypes.key(ResourceKey.sponge("flat"));

    public static final DefaultedRegistryReference<GeneratorModifierType> LARGE_BIOMES = GeneratorModifierTypes.key(ResourceKey.sponge("large_biomes"));

    // SORTFIELDS:OFF

    // @formatter:on

    private GeneratorModifierTypes() {
    }

    private static DefaultedRegistryReference<GeneratorModifierType> key(final ResourceKey location) {
        return RegistryKey.of(Registries.GENERATOR_MODIFIER_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
