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
package org.spongepowered.api.map.color;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.util.Color;

/**
 * A pseudo-enum of supported elements on a {@link MapCanvas}.
 *
 * <p>The {@link Color colors} that these represent can be retrieved via the
 * {@link MapColorType#getColor()} method.</p>
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public final class MapColorTypes {

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<MapColorType> NONE = MapColorTypes.key(ResourceKey.sponge("none"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_BLACK = MapColorTypes.key(ResourceKey.sponge("color_black"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_BLACK = MapColorTypes.key(ResourceKey.sponge("terracotta_black"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_BLUE = MapColorTypes.key(ResourceKey.sponge("color_blue"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_BLUE = MapColorTypes.key(ResourceKey.sponge("terracotta_blue"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_BROWN = MapColorTypes.key(ResourceKey.sponge("color_brown"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_BROWN = MapColorTypes.key(ResourceKey.sponge("terracotta_brown"));

    public static final DefaultedRegistryReference<MapColorType> CLAY = MapColorTypes.key(ResourceKey.sponge("clay"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_CYAN = MapColorTypes.key(ResourceKey.sponge("color_cyan"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_CYAN = MapColorTypes.key(ResourceKey.sponge("terracotta_cyan"));

    public static final DefaultedRegistryReference<MapColorType> DIAMOND = MapColorTypes.key(ResourceKey.sponge("diamond"));

    public static final DefaultedRegistryReference<MapColorType> DIRT = MapColorTypes.key(ResourceKey.sponge("dirt"));

    public static final DefaultedRegistryReference<MapColorType> EMERALD = MapColorTypes.key(ResourceKey.sponge("emerald"));

    public static final DefaultedRegistryReference<MapColorType> PLANT = MapColorTypes.key(ResourceKey.sponge("plant"));

    public static final DefaultedRegistryReference<MapColorType> GOLD = MapColorTypes.key(ResourceKey.sponge("gold"));

    public static final DefaultedRegistryReference<MapColorType> GRASS = MapColorTypes.key(ResourceKey.sponge("grass"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_GRAY = MapColorTypes.key(ResourceKey.sponge("color_gray"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_GRAY = MapColorTypes.key(ResourceKey.sponge("terracotta_gray"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_GREEN = MapColorTypes.key(ResourceKey.sponge("color_green"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_GREEN = MapColorTypes.key(ResourceKey.sponge("terracotta_green"));

    public static final DefaultedRegistryReference<MapColorType> ICE = MapColorTypes.key(ResourceKey.sponge("ice"));

    public static final DefaultedRegistryReference<MapColorType> METAL = MapColorTypes.key(ResourceKey.sponge("metal"));

    public static final DefaultedRegistryReference<MapColorType> LAPIS_LAZULI = MapColorTypes.key(ResourceKey.sponge("lapis_lazuli"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_LIGHT_BLUE = MapColorTypes.key(ResourceKey.sponge("color_light_blue"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_LIGHT_BLUE = MapColorTypes.key(ResourceKey.sponge("terracotta_light_blue"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_LIGHT_GREEN = MapColorTypes.key(ResourceKey.sponge("color_light_green"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_LIGHT_GREEN = MapColorTypes.key(ResourceKey.sponge("terracotta_light_green"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_MAGENTA = MapColorTypes.key(ResourceKey.sponge("color_magenta"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_MAGENTA = MapColorTypes.key(ResourceKey.sponge("terracotta_magenta"));

    public static final DefaultedRegistryReference<MapColorType> NETHER = MapColorTypes.key(ResourceKey.sponge("nether"));

    public static final DefaultedRegistryReference<MapColorType> PODZOL = MapColorTypes.key(ResourceKey.sponge("podzol"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_ORANGE = MapColorTypes.key(ResourceKey.sponge("color_orange"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_ORANGE = MapColorTypes.key(ResourceKey.sponge("terracotta_orange"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_PINK = MapColorTypes.key(ResourceKey.sponge("color_pink"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_PINK = MapColorTypes.key(ResourceKey.sponge("terracotta_pink"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_PURPLE = MapColorTypes.key(ResourceKey.sponge("color_purple"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_PURPLE = MapColorTypes.key(ResourceKey.sponge("terracotta_purple"));

    public static final DefaultedRegistryReference<MapColorType> QUARTZ = MapColorTypes.key(ResourceKey.sponge("quartz"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_RED = MapColorTypes.key(ResourceKey.sponge("color_red"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_RED = MapColorTypes.key(ResourceKey.sponge("terracotta_red"));

    public static final DefaultedRegistryReference<MapColorType> SAND = MapColorTypes.key(ResourceKey.sponge("sand"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_LIGHT_GRAY = MapColorTypes.key(ResourceKey.sponge("color_light_gray"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_LIGHT_GRAY = MapColorTypes.key(ResourceKey.sponge("terracotta_light_gray"));

    public static final DefaultedRegistryReference<MapColorType> SNOW = MapColorTypes.key(ResourceKey.sponge("snow"));

    public static final DefaultedRegistryReference<MapColorType> STONE = MapColorTypes.key(ResourceKey.sponge("stone"));

    public static final DefaultedRegistryReference<MapColorType> FIRE = MapColorTypes.key(ResourceKey.sponge("fire"));

    public static final DefaultedRegistryReference<MapColorType> WATER = MapColorTypes.key(ResourceKey.sponge("water"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_WHITE = MapColorTypes.key(ResourceKey.sponge("terracotta_white"));

    public static final DefaultedRegistryReference<MapColorType> WOOD = MapColorTypes.key(ResourceKey.sponge("wood"));

    public static final DefaultedRegistryReference<MapColorType> WOOL = MapColorTypes.key(ResourceKey.sponge("wool"));

    public static final DefaultedRegistryReference<MapColorType> COLOR_YELLOW = MapColorTypes.key(ResourceKey.sponge("color_yellow"));

    public static final DefaultedRegistryReference<MapColorType> TERRACOTTA_YELLOW = MapColorTypes.key(ResourceKey.sponge("terracotta_yellow"));

    public static final DefaultedRegistryReference<MapColorType> CRIMSON_NYLIUM = MapColorTypes.key(ResourceKey.sponge("crimson-nylium"));

    public static final DefaultedRegistryReference<MapColorType> CRIMSON_STEM = MapColorTypes.key(ResourceKey.sponge("crimson-stem"));

    public static final DefaultedRegistryReference<MapColorType> CRIMSON_HYPHAE = MapColorTypes.key(ResourceKey.sponge("crimson-hyphae"));

    public static final DefaultedRegistryReference<MapColorType> WARPED_NYLIUM = MapColorTypes.key(ResourceKey.sponge("warped-nylium"));

    public static final DefaultedRegistryReference<MapColorType> WARPED_STEM = MapColorTypes.key(ResourceKey.sponge("warped-stem"));

    public static final DefaultedRegistryReference<MapColorType> WARPED_HYPHAE = MapColorTypes.key(ResourceKey.sponge("warped-hyphae"));

    public static final DefaultedRegistryReference<MapColorType> WARPED_WART_BLOCK = MapColorTypes.key(ResourceKey.sponge("warped-wart-block"));

    // SORTFIELDS:OFF

    private MapColorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

    private static DefaultedRegistryReference<MapColorType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.MAP_COLOR_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
