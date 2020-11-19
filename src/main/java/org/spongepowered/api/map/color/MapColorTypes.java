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

    public static final Supplier<MapColorType> ADOBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "ADOBE");

    public static final Supplier<MapColorType> AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "AIR");

    public static final Supplier<MapColorType> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BLACK");

    public static final Supplier<MapColorType> BLACK_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BLACK_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BLUE");

    public static final Supplier<MapColorType> BLUE_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BLUE_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BROWN");

    public static final Supplier<MapColorType> BROWN_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "BROWN_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "CLAY");

    public static final Supplier<MapColorType> CYAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "CYAN");

    public static final Supplier<MapColorType> CYAN_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "CYAN_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> DIAMOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "DIAMOND");

    public static final Supplier<MapColorType> DIRT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "DIRT");

    public static final Supplier<MapColorType> EMERALD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "EMERALD");

    public static final Supplier<MapColorType> FOLIAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "FOLIAGE");

    public static final Supplier<MapColorType> GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GOLD");

    public static final Supplier<MapColorType> GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GRASS");

    public static final Supplier<MapColorType> GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GRAY");

    public static final Supplier<MapColorType> GRAY_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GRAY_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GREEN");

    public static final Supplier<MapColorType> GREEN_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "GREEN_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> ICE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "ICE");

    public static final Supplier<MapColorType> IRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "IRON");

    public static final Supplier<MapColorType> LAPIS_LAZULI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "LAPIS_LAZULI");

    public static final Supplier<MapColorType> LIGHT_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "LIGHT_BLUE");

    public static final Supplier<MapColorType> LIGHT_BLUE_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "LIGHT_BLUE_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> LIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "LIME");

    public static final Supplier<MapColorType> LIME_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "LIME_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> MAGENTA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "MAGENTA");

    public static final Supplier<MapColorType> MAGENTA_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "MAGENTA_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> NETHERRACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "NETHERRACK");

    public static final Supplier<MapColorType> OBSIDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "OBSIDIAN");

    public static final Supplier<MapColorType> ORANGE_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "ORANGE_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> PINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "PINK");

    public static final Supplier<MapColorType> PINK_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "PINK_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "PURPLE");

    public static final Supplier<MapColorType> PURPLE_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "PURPLE_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> QUARTZ = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "QUARTZ");

    public static final Supplier<MapColorType> RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "RED");

    public static final Supplier<MapColorType> RED_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "RED_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> SAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "SAND");

    public static final Supplier<MapColorType> SILVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "SILVER");

    public static final Supplier<MapColorType> SILVER_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "SILVER_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> SNOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "SNOW");

    public static final Supplier<MapColorType> STONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "STONE");

    public static final Supplier<MapColorType> TNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "TNT");

    public static final Supplier<MapColorType> WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "WATER");

    public static final Supplier<MapColorType> WHITE_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "WHITE_STAINED_HARDENED_CLAY");

    public static final Supplier<MapColorType> WOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "WOOD");

    public static final Supplier<MapColorType> WOOL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "WOOL");

    public static final Supplier<MapColorType> YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "YELLOW");

    public static final Supplier<MapColorType> YELLOW_STAINED_HARDENED_CLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapColorType.class, "YELLOW_STAINED_HARDENED_CLAY");

    // SORTFIELDS:OFF

    private MapColorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
