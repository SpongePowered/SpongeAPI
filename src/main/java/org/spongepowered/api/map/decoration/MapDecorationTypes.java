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

import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.color.MapColorType;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * A pseudo-enum of {@link MapDecorationType}s that can be used on a
 * {@link MapCanvas}.
 */
public final class MapDecorationTypes {

    // SORTFIELDS:ON

    public static final MapDecorationType BLUE_MARKER = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "BLUE_MARKER");

    public static final MapDecorationType GREEN_MARKER = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "GREEN_MARKER");

    public static final MapDecorationType MANSION = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "MANSION");

    public static final MapDecorationType MONUMENT = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "MONUMENT");

    public static final MapDecorationType PLAYER_MARKER = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "PLAYER_MARKER");

    public static final MapDecorationType PLAYER_OFF_LIMITS = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "PLAYER_OFF_LIMITS");

    public static final MapDecorationType PLAYER_OFF_MAP = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "PLAYER_OFF_MAP");

    public static final MapDecorationType RED_MARKER = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "RED_MARKER");

    public static final MapDecorationType TARGET_POINT = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "TARGET_POINT");

    public static final MapDecorationType TARGET_X = DummyObjectProvider.createExtendedFor(MapDecorationType.class, "TARGET_X");

    // SORTFIELDS:OFF
}
