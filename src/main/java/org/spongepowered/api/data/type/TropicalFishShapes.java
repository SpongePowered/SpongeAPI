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
import org.spongepowered.api.entity.living.aquatic.fish.school.TropicalFish;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla shapes for {@link TropicalFish}.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class TropicalFishShapes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<TropicalFishShape> BETTY = TropicalFishShapes.key(ResourceKey.sponge("betty"));

    public static final DefaultedRegistryReference<TropicalFishShape> BLOCKFISH = TropicalFishShapes.key(ResourceKey.sponge("blockfish"));

    public static final DefaultedRegistryReference<TropicalFishShape> BRINELY = TropicalFishShapes.key(ResourceKey.sponge("brinely"));

    public static final DefaultedRegistryReference<TropicalFishShape> CLAYFISH = TropicalFishShapes.key(ResourceKey.sponge("clayfish"));

    public static final DefaultedRegistryReference<TropicalFishShape> DASHER = TropicalFishShapes.key(ResourceKey.sponge("dasher"));

    public static final DefaultedRegistryReference<TropicalFishShape> FLOPPER = TropicalFishShapes.key(ResourceKey.sponge("flopper"));

    public static final DefaultedRegistryReference<TropicalFishShape> GLITTER = TropicalFishShapes.key(ResourceKey.sponge("glitter"));

    public static final DefaultedRegistryReference<TropicalFishShape> KOB = TropicalFishShapes.key(ResourceKey.sponge("kob"));

    public static final DefaultedRegistryReference<TropicalFishShape> SNOOPER = TropicalFishShapes.key(ResourceKey.sponge("snooper"));

    public static final DefaultedRegistryReference<TropicalFishShape> SPOTTY = TropicalFishShapes.key(ResourceKey.sponge("spotty"));

    public static final DefaultedRegistryReference<TropicalFishShape> STRIPEY = TropicalFishShapes.key(ResourceKey.sponge("stripey"));

    public static final DefaultedRegistryReference<TropicalFishShape> SUNSTREAK = TropicalFishShapes.key(ResourceKey.sponge("sunstreak"));

    // SORTFIELDS:OFF

    // @formatter:on

    private TropicalFishShapes() {
    }

    private static DefaultedRegistryReference<TropicalFishShape> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.TROPICAL_FISH_SHAPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
