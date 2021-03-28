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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of vanilla {@link ArtType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ArtTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ArtType> ALBAN = ArtTypes.key(ResourceKey.minecraft("alban"));

    public static final DefaultedRegistryReference<ArtType> AZTEC = ArtTypes.key(ResourceKey.minecraft("aztec"));

    public static final DefaultedRegistryReference<ArtType> AZTEC2 = ArtTypes.key(ResourceKey.minecraft("aztec2"));

    public static final DefaultedRegistryReference<ArtType> BOMB = ArtTypes.key(ResourceKey.minecraft("bomb"));

    public static final DefaultedRegistryReference<ArtType> BURNING_SKULL = ArtTypes.key(ResourceKey.minecraft("burning_skull"));

    public static final DefaultedRegistryReference<ArtType> BUST = ArtTypes.key(ResourceKey.minecraft("bust"));

    public static final DefaultedRegistryReference<ArtType> COURBET = ArtTypes.key(ResourceKey.minecraft("courbet"));

    public static final DefaultedRegistryReference<ArtType> CREEBET = ArtTypes.key(ResourceKey.minecraft("creebet"));

    public static final DefaultedRegistryReference<ArtType> DONKEY_KONG = ArtTypes.key(ResourceKey.minecraft("donkey_kong"));

    public static final DefaultedRegistryReference<ArtType> FIGHTERS = ArtTypes.key(ResourceKey.minecraft("fighters"));

    public static final DefaultedRegistryReference<ArtType> GRAHAM = ArtTypes.key(ResourceKey.minecraft("graham"));

    public static final DefaultedRegistryReference<ArtType> KEBAB = ArtTypes.key(ResourceKey.minecraft("kebab"));

    public static final DefaultedRegistryReference<ArtType> MATCH = ArtTypes.key(ResourceKey.minecraft("match"));

    public static final DefaultedRegistryReference<ArtType> PIGSCENE = ArtTypes.key(ResourceKey.minecraft("pigscene"));

    public static final DefaultedRegistryReference<ArtType> PLANT = ArtTypes.key(ResourceKey.minecraft("plant"));

    public static final DefaultedRegistryReference<ArtType> POINTER = ArtTypes.key(ResourceKey.minecraft("pointer"));

    public static final DefaultedRegistryReference<ArtType> POOL = ArtTypes.key(ResourceKey.minecraft("pool"));

    public static final DefaultedRegistryReference<ArtType> SEA = ArtTypes.key(ResourceKey.minecraft("sea"));

    public static final DefaultedRegistryReference<ArtType> SKELETON = ArtTypes.key(ResourceKey.minecraft("skeleton"));

    public static final DefaultedRegistryReference<ArtType> SKULL_AND_ROSES = ArtTypes.key(ResourceKey.minecraft("skull_and_roses"));

    public static final DefaultedRegistryReference<ArtType> STAGE = ArtTypes.key(ResourceKey.minecraft("stage"));

    public static final DefaultedRegistryReference<ArtType> SUNSET = ArtTypes.key(ResourceKey.minecraft("sunset"));

    public static final DefaultedRegistryReference<ArtType> VOID = ArtTypes.key(ResourceKey.minecraft("void"));

    public static final DefaultedRegistryReference<ArtType> WANDERER = ArtTypes.key(ResourceKey.minecraft("wanderer"));

    public static final DefaultedRegistryReference<ArtType> WASTELAND = ArtTypes.key(ResourceKey.minecraft("wasteland"));

    public static final DefaultedRegistryReference<ArtType> WITHER = ArtTypes.key(ResourceKey.minecraft("wither"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ArtTypes() {
    }

    private static DefaultedRegistryReference<ArtType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ART_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
