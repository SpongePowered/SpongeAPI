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
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link DyeColor}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DyeColors {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<DyeColor> BLACK = DyeColors.key(ResourceKey.sponge("black"));

    public static final DefaultedRegistryReference<DyeColor> BLUE = DyeColors.key(ResourceKey.sponge("blue"));

    public static final DefaultedRegistryReference<DyeColor> BROWN = DyeColors.key(ResourceKey.sponge("brown"));

    public static final DefaultedRegistryReference<DyeColor> CYAN = DyeColors.key(ResourceKey.sponge("cyan"));

    public static final DefaultedRegistryReference<DyeColor> GRAY = DyeColors.key(ResourceKey.sponge("gray"));

    public static final DefaultedRegistryReference<DyeColor> GREEN = DyeColors.key(ResourceKey.sponge("green"));

    public static final DefaultedRegistryReference<DyeColor> LIGHT_BLUE = DyeColors.key(ResourceKey.sponge("light_blue"));

    public static final DefaultedRegistryReference<DyeColor> LIGHT_GRAY = DyeColors.key(ResourceKey.sponge("light_gray"));

    public static final DefaultedRegistryReference<DyeColor> LIME = DyeColors.key(ResourceKey.sponge("lime"));

    public static final DefaultedRegistryReference<DyeColor> MAGENTA = DyeColors.key(ResourceKey.sponge("magenta"));

    public static final DefaultedRegistryReference<DyeColor> ORANGE = DyeColors.key(ResourceKey.sponge("orange"));

    public static final DefaultedRegistryReference<DyeColor> PINK = DyeColors.key(ResourceKey.sponge("pink"));

    public static final DefaultedRegistryReference<DyeColor> PURPLE = DyeColors.key(ResourceKey.sponge("purple"));

    public static final DefaultedRegistryReference<DyeColor> RED = DyeColors.key(ResourceKey.sponge("red"));

    public static final DefaultedRegistryReference<DyeColor> WHITE = DyeColors.key(ResourceKey.sponge("white"));

    public static final DefaultedRegistryReference<DyeColor> YELLOW = DyeColors.key(ResourceKey.sponge("yellow"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DyeColors() {
    }

    private static DefaultedRegistryReference<DyeColor> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DYE_COLOR, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
