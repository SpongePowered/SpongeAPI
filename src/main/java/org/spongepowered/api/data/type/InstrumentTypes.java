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

public final class InstrumentTypes {

    // SORTFIELDS:ON

    public static final InstrumentType BASS_ATTACK = DummyObjectProvider.createFor(InstrumentType.class, "BASS_ATTACK");

    public static final InstrumentType BASS_DRUM = DummyObjectProvider.createFor(InstrumentType.class, "BASS_DRUM");

    public static final InstrumentType BELL = DummyObjectProvider.createFor(InstrumentType.class, "BELL");

    public static final InstrumentType CHIME = DummyObjectProvider.createFor(InstrumentType.class, "CHIME");

    public static final InstrumentType FLUTE = DummyObjectProvider.createFor(InstrumentType.class, "FLUTE");

    public static final InstrumentType GUITAR = DummyObjectProvider.createFor(InstrumentType.class, "GUITAR");

    public static final InstrumentType HARP = DummyObjectProvider.createFor(InstrumentType.class, "HARP");

    public static final InstrumentType HIGH_HAT = DummyObjectProvider.createFor(InstrumentType.class, "HIGH_HAT");

    public static final InstrumentType SNARE = DummyObjectProvider.createFor(InstrumentType.class, "SNARE");

    public static final InstrumentType XYLOPHONE = DummyObjectProvider.createFor(InstrumentType.class, "XYLOPHONE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private InstrumentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
