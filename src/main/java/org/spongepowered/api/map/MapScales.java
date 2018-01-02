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
package org.spongepowered.api.map;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the possible vanilla {@link MapScales}s.
 */
public final class MapScales {

    /**
     * The default scale of a newly crafted map, this scale represents a 1:1 block to pixel ratio.
     */
    public static final MapScale SCALE_BASE = DummyObjectProvider.createFor(MapScale.class, "SCALE_BASE");

    /**
     * Represents a 4:1 block to pixel ratio scaling.
     */
    public static final MapScale SCALE_4 = DummyObjectProvider.createFor(MapScale.class, "SCALE_4");

    /**
     * Represents a 16:1 block to pixel ratio scaling, 4x4 blocks (1/16 chunk) per map pixel.
     */
    public static final MapScale SCALE_16 = DummyObjectProvider.createFor(MapScale.class, "SCALE_16");

    /**
     * Represents a 64:1 block to pixel ratio scaling, 8x8 blocks (1/4 chunk) per map pixel.
     */
    public static final MapScale SCALE_64 = DummyObjectProvider.createFor(MapScale.class, "SCALE_64");

    /**
     * Represents a 256:1 block to pixel ratio scaling, 16x16 blocks (1 chunk) per map pixel.
     */
    public static final MapScale SCALE_256 = DummyObjectProvider.createFor(MapScale.class, "SCALE_256");

    private MapScales() {
    }

}
