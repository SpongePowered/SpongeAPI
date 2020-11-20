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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.util.Color;

import java.util.function.Supplier;

/**
 * A pseudo-enum of supported elements on a {@link MapCanvas}.
 *
 * <p>The {@link Color colors} that these represent can be retrieved via the
 * {@link MapColorType#getColor()} method.</p>
 */
public final class MapColorTypes {

    // SORTFIELDS:ON

    public static final Supplier<MapColorType> ADOBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "adobe");

    public static final Supplier<MapColorType> AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "air");

    public static final Supplier<MapColorType> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "black");

    public static final Supplier<MapColorType> BLACK_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "black_terracotta");

    public static final Supplier<MapColorType> BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "blue");

    public static final Supplier<MapColorType> BLUE_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "blue_terracotta");

    public static final Supplier<MapColorType> BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "brown");

    public static final Supplier<MapColorType> BROWN_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "brown_terracotta");

    public static final Supplier<MapColorType> CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "clay");

    public static final Supplier<MapColorType> CYAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "cyan");

    public static final Supplier<MapColorType> CYAN_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "cyan_terracotta");

    public static final Supplier<MapColorType> DIAMOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "diamond");

    public static final Supplier<MapColorType> DIRT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "dirt");

    public static final Supplier<MapColorType> EMERALD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "emerald");

    public static final Supplier<MapColorType> FOLIAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "foliage");

    public static final Supplier<MapColorType> GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "gold");

    public static final Supplier<MapColorType> GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "grass");

    public static final Supplier<MapColorType> GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "gray");

    public static final Supplier<MapColorType> GRAY_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "gray_terracotta");

    public static final Supplier<MapColorType> GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "green");

    public static final Supplier<MapColorType> GREEN_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "green_terracotta");

    public static final Supplier<MapColorType> ICE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "ice");

    public static final Supplier<MapColorType> IRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "iron");

    public static final Supplier<MapColorType> LAPIS_LAZULI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "lapis_lazuli");

    public static final Supplier<MapColorType> LIGHT_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "light_blue");

    public static final Supplier<MapColorType> LIGHT_BLUE_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "light_blue_terracotta");

    public static final Supplier<MapColorType> LIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "lime");

    public static final Supplier<MapColorType> LIME_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "lime_terracotta");

    public static final Supplier<MapColorType> MAGENTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "magenta");

    public static final Supplier<MapColorType> MAGENTA_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "magenta_terracotta");

    public static final Supplier<MapColorType> NETHERRACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "netherrack");

    public static final Supplier<MapColorType> OBSIDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "obsidian");

    public static final Supplier<MapColorType> ORANGE_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "orange_terracotta");

    public static final Supplier<MapColorType> PINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "pink");

    public static final Supplier<MapColorType> PINK_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "pink_terracotta");

    public static final Supplier<MapColorType> PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "purple");

    public static final Supplier<MapColorType> PURPLE_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "purple_terracotta");

    public static final Supplier<MapColorType> QUARTZ = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "quartz");

    public static final Supplier<MapColorType> RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "red");

    public static final Supplier<MapColorType> RED_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "red_terracotta");

    public static final Supplier<MapColorType> SAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "sand");

    public static final Supplier<MapColorType> SILVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "silver");

    public static final Supplier<MapColorType> SILVER_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "silver_terracotta");

    public static final Supplier<MapColorType> SNOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "snow");

    public static final Supplier<MapColorType> STONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "stone");

    public static final Supplier<MapColorType> TNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "tnt");

    public static final Supplier<MapColorType> WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "water");

    public static final Supplier<MapColorType> WHITE_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "white_terracotta");

    public static final Supplier<MapColorType> WOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "wood");

    public static final Supplier<MapColorType> WOOL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "wool");

    public static final Supplier<MapColorType> YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "yellow");

    public static final Supplier<MapColorType> YELLOW_TERRACOTTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "yellow_terracotta");

    // SORTFIELDS:OFF

    private MapColorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
