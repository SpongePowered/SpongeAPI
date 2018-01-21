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
 * A utility class for getting available {@link Art} pieces.
 */
public class Arts {

    // SORTFIELDS:ON

    public static final Art ALBAN = DummyObjectProvider.createFor(Art.class, "ALBAN");

    public static final Art AZTEC = DummyObjectProvider.createFor(Art.class, "AZTEC");

    public static final Art AZTEC_2 = DummyObjectProvider.createFor(Art.class, "AZTEC_2");

    public static final Art BOMB = DummyObjectProvider.createFor(Art.class, "BOMB");

    public static final Art BURNING_SKULL = DummyObjectProvider.createFor(Art.class, "BURNING_SKULL");

    public static final Art BUST = DummyObjectProvider.createFor(Art.class, "BUST");

    public static final Art COURBET = DummyObjectProvider.createFor(Art.class, "COURBET");

    public static final Art CREEBET = DummyObjectProvider.createFor(Art.class, "CREEBET");

    public static final Art DONKEY_KONG = DummyObjectProvider.createFor(Art.class, "DONKEY_KONG");

    public static final Art FIGHTERS = DummyObjectProvider.createFor(Art.class, "FIGHTERS");

    public static final Art GRAHAM = DummyObjectProvider.createFor(Art.class, "GRAHAM");

    public static final Art KEBAB = DummyObjectProvider.createFor(Art.class, "KEBAB");

    public static final Art MATCH = DummyObjectProvider.createFor(Art.class, "MATCH");

    public static final Art PIGSCENE = DummyObjectProvider.createFor(Art.class, "PIGSCENE");

    public static final Art PLANT = DummyObjectProvider.createFor(Art.class, "PLANT");

    public static final Art POINTER = DummyObjectProvider.createFor(Art.class, "POINTER");

    public static final Art POOL = DummyObjectProvider.createFor(Art.class, "POOL");

    public static final Art SEA = DummyObjectProvider.createFor(Art.class, "SEA");

    public static final Art SKELETON = DummyObjectProvider.createFor(Art.class, "SKELETON");

    public static final Art SKULL_AND_ROSES = DummyObjectProvider.createFor(Art.class, "SKULL_AND_ROSES");

    public static final Art STAGE = DummyObjectProvider.createFor(Art.class, "STAGE");

    public static final Art SUNSET = DummyObjectProvider.createFor(Art.class, "SUNSET");

    public static final Art VOID = DummyObjectProvider.createFor(Art.class, "VOID");

    public static final Art WANDERER = DummyObjectProvider.createFor(Art.class, "WANDERER");

    public static final Art WASTELAND = DummyObjectProvider.createFor(Art.class, "WASTELAND");

    public static final Art WITHER = DummyObjectProvider.createFor(Art.class, "WITHER");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Arts() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
