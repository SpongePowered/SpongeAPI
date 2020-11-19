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

    public static final Supplier<MapDecorationType> BLUE_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "BLUE_MARKER");

    public static final Supplier<MapDecorationType> GREEN_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "GREEN_MARKER");

    public static final Supplier<MapDecorationType> MANSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "MANSION");

    public static final Supplier<MapDecorationType> MONUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "MONUMENT");

    public static final Supplier<MapDecorationType> PLAYER_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "PLAYER_MARKER");

    public static final Supplier<MapDecorationType> PLAYER_OFF_LIMITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "PLAYER_OFF_LIMITS");

    public static final Supplier<MapDecorationType> PLAYER_OFF_MAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "PLAYER_OFF_MAP");

    public static final Supplier<MapDecorationType> RED_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "RED_MARKER");

    public static final Supplier<MapDecorationType> TARGET_POINT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "TARGET_POINT");

    public static final Supplier<MapDecorationType> TARGET_X = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MapDecorationType.class, "TARGET_X");

    // SORTFIELDS:OFF
}
