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
package org.spongepowered.api.map.decoration;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * A pseudo-enum of {@link MapDecorationType}s that can be used on a
 * {@link MapCanvas}.
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public final class MapDecorationTypes {

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<MapDecorationType> BLUE_MARKER = MapDecorationTypes.key(ResourceKey.sponge("blue_marker"));

    public static final DefaultedRegistryReference<MapDecorationType> GREEN_MARKER = MapDecorationTypes.key(ResourceKey.sponge("frame"));

    public static final DefaultedRegistryReference<MapDecorationType> MANSION = MapDecorationTypes.key(ResourceKey.sponge("mansion"));

    public static final DefaultedRegistryReference<MapDecorationType> MONUMENT = MapDecorationTypes.key(ResourceKey.sponge("monument"));

    public static final DefaultedRegistryReference<MapDecorationType> PLAYER_MARKER = MapDecorationTypes.key(ResourceKey.sponge("player"));

    public static final DefaultedRegistryReference<MapDecorationType> PLAYER_OFF_LIMITS = MapDecorationTypes.key(ResourceKey.sponge("player_off_limits"));

    public static final DefaultedRegistryReference<MapDecorationType> PLAYER_OFF_MAP = MapDecorationTypes.key(ResourceKey.sponge("player_off_map"));

    public static final DefaultedRegistryReference<MapDecorationType> RED_MARKER = MapDecorationTypes.key(ResourceKey.sponge("red_marker"));

    public static final DefaultedRegistryReference<MapDecorationType> TARGET_POINT = MapDecorationTypes.key(ResourceKey.sponge("target_point"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_WHITE = MapDecorationTypes.key(ResourceKey.sponge("banner_white"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_ORANGE = MapDecorationTypes.key(ResourceKey.sponge("banner_orange"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_MAGENTA = MapDecorationTypes.key(ResourceKey.sponge("banner_magenta"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_LIGHT_BLUE = MapDecorationTypes.key(ResourceKey.sponge("banner_light_blue"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_YELLOW = MapDecorationTypes.key(ResourceKey.sponge("banner_yellow"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_LIME = MapDecorationTypes.key(ResourceKey.sponge("banner_lime"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_PINK = MapDecorationTypes.key(ResourceKey.sponge("banner_pink"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_GRAY = MapDecorationTypes.key(ResourceKey.sponge("banner_gray"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_LIGHT_GRAY = MapDecorationTypes.key(ResourceKey.sponge("banner_light_gray"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_CYAN = MapDecorationTypes.key(ResourceKey.sponge("banner_cyan"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_PURPLE = MapDecorationTypes.key(ResourceKey.sponge("banner_purple"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_BLUE = MapDecorationTypes.key(ResourceKey.sponge("banner_blue"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_BROWN = MapDecorationTypes.key(ResourceKey.sponge("banner_brown"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_GREEN = MapDecorationTypes.key(ResourceKey.sponge("banner_green"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_RED = MapDecorationTypes.key(ResourceKey.sponge("banner_red"));

    public static final DefaultedRegistryReference<MapDecorationType> BANNER_BLACK = MapDecorationTypes.key(ResourceKey.sponge("banner_black"));
    // SORTFIELDS:OFF

    private static DefaultedRegistryReference<MapDecorationType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.MAP_DECORATION_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
