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
package org.spongepowered.api.data.type;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of known {@link SlabType}s.
 */
public final class SlabTypes {

    // SORTFIELDS:ON

    public static final SlabType BRICK = DummyObjectProvider.createFor(SlabType.class, "BRICK");

    public static final SlabType COBBLESTONE = DummyObjectProvider.createFor(SlabType.class, "COBBLESTONE");

    public static final SlabType NETHERBRICK = DummyObjectProvider.createFor(SlabType.class, "NETHERBRICK");

    public static final SlabType QUARTZ = DummyObjectProvider.createFor(SlabType.class, "QUARTZ");

    public static final SlabType RED_SAND = DummyObjectProvider.createFor(SlabType.class, "RED_SAND");

    public static final SlabType SAND = DummyObjectProvider.createFor(SlabType.class, "SAND");

    public static final SlabType SMOOTH_BRICK = DummyObjectProvider.createFor(SlabType.class, "SMOOTH_BRICK");

    public static final SlabType STONE = DummyObjectProvider.createFor(SlabType.class, "STONE");

    public static final SlabType WOOD = DummyObjectProvider.createFor(SlabType.class, "WOOD");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SlabTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
