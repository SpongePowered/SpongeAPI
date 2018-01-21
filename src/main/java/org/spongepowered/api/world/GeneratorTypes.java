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

/**
 * An enumeration of default {@link GeneratorType}s.
 */
public final class GeneratorTypes {

    // SORTFIELDS:ON

    public static final GeneratorType AMPLIFIED = DummyObjectProvider.createFor(GeneratorType.class, "AMPLIFIED");

    public static final GeneratorType DEBUG = DummyObjectProvider.createFor(GeneratorType.class, "DEBUG");

    public static final GeneratorType DEFAULT = DummyObjectProvider.createFor(GeneratorType.class, "DEFAULT");

    public static final GeneratorType FLAT = DummyObjectProvider.createFor(GeneratorType.class, "FLAT");

    public static final GeneratorType LARGE_BIOMES = DummyObjectProvider.createFor(GeneratorType.class, "LARGE_BIOMES");

    public static final GeneratorType NETHER = DummyObjectProvider.createFor(GeneratorType.class, "NETHER");

    public static final GeneratorType OVERWORLD = DummyObjectProvider.createFor(GeneratorType.class, "OVERWORLD");

    public static final GeneratorType THE_END = DummyObjectProvider.createFor(GeneratorType.class, "THE_END");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private GeneratorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
