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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link InstrumentType}s.
 */
public final class InstrumentTypes {

    // SORTFIELDS:ON

    public static final Supplier<InstrumentType> BASS_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "BASS_ATTACK");

    public static final Supplier<InstrumentType> BASS_DRUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "BASS_DRUM");

    public static final Supplier<InstrumentType> BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "BELL");

    public static final Supplier<InstrumentType> CHIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "CHIME");

    public static final Supplier<InstrumentType> FLUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "FLUTE");

    public static final Supplier<InstrumentType> GUITAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "GUITAR");

    public static final Supplier<InstrumentType> HARP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "HARP");

    public static final Supplier<InstrumentType> HIGH_HAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "HIGH_HAT");

    public static final Supplier<InstrumentType> SNARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "SNARE");

    public static final Supplier<InstrumentType> XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(InstrumentType.class, "XYLOPHONE");

    // SORTFIELDS:OFF

    private InstrumentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
