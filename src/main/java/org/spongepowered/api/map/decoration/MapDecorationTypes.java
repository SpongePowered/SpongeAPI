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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.map.MapCanvas;

import java.util.function.Supplier;

/**
 * A pseudo-enum of {@link MapDecorationType}s that can be used on a
 * {@link MapCanvas}.
 */
public final class MapDecorationTypes {

    // SORTFIELDS:ON

    public static final Supplier<MapDecorationType> BLUE_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "blue_marker");

    public static final Supplier<MapDecorationType> GREEN_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "frame");

    public static final Supplier<MapDecorationType> MANSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "mansion");

    public static final Supplier<MapDecorationType> MONUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "monument");

    public static final Supplier<MapDecorationType> PLAYER_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "player");

    public static final Supplier<MapDecorationType> PLAYER_OFF_LIMITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "player_off_limits");

    public static final Supplier<MapDecorationType> PLAYER_OFF_MAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "player_off_map");

    public static final Supplier<MapDecorationType> RED_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "red_marker");

    public static final Supplier<MapDecorationType> TARGET_POINT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "target_point");

    public static final Supplier<MapDecorationType> BANNER_WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_white");

    public static final Supplier<MapDecorationType> BANNER_ORANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_orange");

    public static final Supplier<MapDecorationType> BANNER_MAGENTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_magenta");

    public static final Supplier<MapDecorationType> BANNER_LIGHT_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_light_blue");

    public static final Supplier<MapDecorationType> BANNER_YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_yellow");

    public static final Supplier<MapDecorationType> BANNER_LIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_lime");

    public static final Supplier<MapDecorationType> BANNER_PINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_pink");

    public static final Supplier<MapDecorationType> BANNER_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_gray");

    public static final Supplier<MapDecorationType> BANNER_LIGHT_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_light_gray");

    public static final Supplier<MapDecorationType> BANNER_CYAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_cyan");

    public static final Supplier<MapDecorationType> BANNER_PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_purple");

    public static final Supplier<MapDecorationType> BANNER_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_blue");

    public static final Supplier<MapDecorationType> BANNER_BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_brown");

    public static final Supplier<MapDecorationType> BANNER_GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_green");

    public static final Supplier<MapDecorationType> BANNER_RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_red");

    public static final Supplier<MapDecorationType> BANNED_BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "banner_black");
    // SORTFIELDS:OFF
}
