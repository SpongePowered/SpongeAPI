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
 * An enumeration of vanilla known {@link SkinPart}s.
 */
public final class SkinParts {

    // SORTFIELDS:ON

    public static final SkinPart CAPE = DummyObjectProvider.createFor(SkinPart.class, "CAPE");

    public static final SkinPart HAT = DummyObjectProvider.createFor(SkinPart.class, "HAT");

    public static final SkinPart JACKET = DummyObjectProvider.createFor(SkinPart.class, "JACKET");

    public static final SkinPart LEFT_PANTS_LEG = DummyObjectProvider.createFor(SkinPart.class, "LEFT_PANTS_LEG");

    public static final SkinPart LEFT_SLEEVE = DummyObjectProvider.createFor(SkinPart.class, "LEFT_SLEEVE");

    public static final SkinPart RIGHT_PANTS_LEG = DummyObjectProvider.createFor(SkinPart.class, "RIGHT_PANTS_LEG");

    public static final SkinPart RIGHT_SLEEVE = DummyObjectProvider.createFor(SkinPart.class, "RIGHT_SLEEVE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SkinParts() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
