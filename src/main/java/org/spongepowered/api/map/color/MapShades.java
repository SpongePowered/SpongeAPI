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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the possible {@link MapShade}s.
 */
public final class MapShades {

    // SORTFIELDS:ON

    /**
     * Represents the default mapping, no modification to the color.
     */
    public static final MapShade BASE = DummyObjectProvider.createFor(MapShade.class, "BASE");

    /**
     * Represents a multiplication by 220 to each RGB component, the remainder
     * out of 255 is taken as the new component for each color channel.
     */
    public static final MapShade DARK = DummyObjectProvider.createFor(MapShade.class, "DARK");

    /**
     * Represents a multiplication by 180 to each RGB component, the remainder
     * out of 255 is taken as the new component for each color channel.
     */
    public static final MapShade DARKER = DummyObjectProvider.createFor(MapShade.class, "DARKER");

    /**
     * Represents a multiplication by 135 to each RGB component, the remainder
     * out of 255 is taken as the new component for each color channel.
     */
    public static final MapShade DARKEST = DummyObjectProvider.createFor(MapShade.class, "DARKEST");

    // SORTFIELDS:OFF

    private MapShades() {
    }

}
