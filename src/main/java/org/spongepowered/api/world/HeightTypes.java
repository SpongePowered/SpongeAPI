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
package org.spongepowered.api.world;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class HeightTypes {

    // SORTFIELDS:ON
    public static final HeightType WORLD_SURFACE_WG = DummyObjectProvider.createFor(HeightType.class, "WORLD_SURFACE_WG");
    public static final HeightType OCEAN_FLOOR_WG = DummyObjectProvider.createFor(HeightType.class, "OCEAN_FLOOR_WG");
    public static final HeightType LIGHT_BLOCKING = DummyObjectProvider.createFor(HeightType.class, "LIGHT_BLOCKING");
    public static final HeightType MOTION_BLOCKING = DummyObjectProvider.createFor(HeightType.class, "MOTION_BLOCKING");
    public static final HeightType MOTION_BLOCKING_NO_LEAVES = DummyObjectProvider.createFor(HeightType.class, "MOTION_BLOCKING_NO_LEAVES");
    public static final HeightType OCEAN_FLOOR = DummyObjectProvider.createFor(HeightType.class, "OCEAN_FLOOR");
    public static final HeightType WORLD_SURFACE = DummyObjectProvider.createFor(HeightType.class, "WORLD_SURFACE");
    // SORTFIELDS:OFF

    private HeightTypes() { }

}
