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
 * An enumeration of vanilla {@link ArtType}s.
 */
public final class ArtTypes {

    // SORTFIELDS:ON

    public static final ArtType ALBAN = DummyObjectProvider.createFor(ArtType.class, "ALBAN");

    public static final ArtType AZTEC = DummyObjectProvider.createFor(ArtType.class, "AZTEC");

    public static final ArtType AZTEC_2 = DummyObjectProvider.createFor(ArtType.class, "AZTEC_2");

    public static final ArtType BOMB = DummyObjectProvider.createFor(ArtType.class, "BOMB");

    public static final ArtType BURNING_SKULL = DummyObjectProvider.createFor(ArtType.class, "BURNING_SKULL");

    public static final ArtType BUST = DummyObjectProvider.createFor(ArtType.class, "BUST");

    public static final ArtType COURBET = DummyObjectProvider.createFor(ArtType.class, "COURBET");

    public static final ArtType CREEBET = DummyObjectProvider.createFor(ArtType.class, "CREEBET");

    public static final ArtType DONKEY_KONG = DummyObjectProvider.createFor(ArtType.class, "DONKEY_KONG");

    public static final ArtType FIGHTERS = DummyObjectProvider.createFor(ArtType.class, "FIGHTERS");

    public static final ArtType GRAHAM = DummyObjectProvider.createFor(ArtType.class, "GRAHAM");

    public static final ArtType KEBAB = DummyObjectProvider.createFor(ArtType.class, "KEBAB");

    public static final ArtType MATCH = DummyObjectProvider.createFor(ArtType.class, "MATCH");

    public static final ArtType PIGSCENE = DummyObjectProvider.createFor(ArtType.class, "PIGSCENE");

    public static final ArtType PLANT = DummyObjectProvider.createFor(ArtType.class, "PLANT");

    public static final ArtType POINTER = DummyObjectProvider.createFor(ArtType.class, "POINTER");

    public static final ArtType POOL = DummyObjectProvider.createFor(ArtType.class, "POOL");

    public static final ArtType SEA = DummyObjectProvider.createFor(ArtType.class, "SEA");

    public static final ArtType SKELETON = DummyObjectProvider.createFor(ArtType.class, "SKELETON");

    public static final ArtType SKULL_AND_ROSES = DummyObjectProvider.createFor(ArtType.class, "SKULL_AND_ROSES");

    public static final ArtType STAGE = DummyObjectProvider.createFor(ArtType.class, "STAGE");

    public static final ArtType SUNSET = DummyObjectProvider.createFor(ArtType.class, "SUNSET");

    public static final ArtType VOID = DummyObjectProvider.createFor(ArtType.class, "VOID");

    public static final ArtType WANDERER = DummyObjectProvider.createFor(ArtType.class, "WANDERER");

    public static final ArtType WASTELAND = DummyObjectProvider.createFor(ArtType.class, "WASTELAND");

    public static final ArtType WITHER = DummyObjectProvider.createFor(ArtType.class, "WITHER");

    // SORTFIELDS:OFF

    private ArtTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
