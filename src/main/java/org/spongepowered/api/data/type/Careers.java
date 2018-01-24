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
 * A utility class for getting all available {@link Career}s.
 */
public final class Careers {

    // SORTFIELDS:ON

    public static final Career ARMORER = DummyObjectProvider.createFor(Career.class, "ARMORER");

    public static final Career BUTCHER = DummyObjectProvider.createFor(Career.class, "BUTCHER");

    public static final Career CARTOGRAPHER = DummyObjectProvider.createFor(Career.class, "CARTOGRAPHER");

    public static final Career CLERIC = DummyObjectProvider.createFor(Career.class, "CLERIC");

    public static final Career FARMER = DummyObjectProvider.createFor(Career.class, "FARMER");

    public static final Career FISHERMAN = DummyObjectProvider.createFor(Career.class, "FISHERMAN");

    public static final Career FLETCHER = DummyObjectProvider.createFor(Career.class, "FLETCHER");

    public static final Career LEATHERWORKER = DummyObjectProvider.createFor(Career.class, "LEATHERWORKER");

    public static final Career LIBRARIAN = DummyObjectProvider.createFor(Career.class, "LIBRARIAN");

    public static final Career SHEPHERD = DummyObjectProvider.createFor(Career.class, "SHEPHERD");

    public static final Career TOOL_SMITH = DummyObjectProvider.createFor(Career.class, "TOOL_SMITH");

    public static final Career WEAPON_SMITH = DummyObjectProvider.createFor(Career.class, "WEAPON_SMITH");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Careers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
