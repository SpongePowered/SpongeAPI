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
 * An enumeration of known vanilla {@link RabbitType}s.
 */
public final class RabbitTypes {

    // SORTFIELDS:ON

    public static final RabbitType BLACK = DummyObjectProvider.createFor(RabbitType.class, "BLACK");

    public static final RabbitType BLACK_AND_WHITE = DummyObjectProvider.createFor(RabbitType.class, "BLACK_AND_WHITE");

    public static final RabbitType BROWN = DummyObjectProvider.createFor(RabbitType.class, "BROWN");

    public static final RabbitType GOLD = DummyObjectProvider.createFor(RabbitType.class, "GOLD");

    public static final RabbitType KILLER = DummyObjectProvider.createFor(RabbitType.class, "KILLER");

    public static final RabbitType SALT_AND_PEPPER = DummyObjectProvider.createFor(RabbitType.class, "SALT_AND_PEPPER");

    public static final RabbitType WHITE = DummyObjectProvider.createFor(RabbitType.class, "WHITE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private RabbitTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
