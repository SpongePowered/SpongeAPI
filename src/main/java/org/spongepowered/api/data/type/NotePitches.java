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
 * An enumeration of vanilla {@link NotePitch}es.
 */
public final class NotePitches {

    // SORTFIELDS:ON

    public static final Supplier<NotePitch> A1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "A1");

    public static final Supplier<NotePitch> A2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "A2");

    public static final Supplier<NotePitch> A_SHARP1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "A_SHARP1");

    public static final Supplier<NotePitch> A_SHARP2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "A_SHARP2");

    public static final Supplier<NotePitch> B1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "B1");

    public static final Supplier<NotePitch> B2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "B2");

    public static final Supplier<NotePitch> C1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "C1");

    public static final Supplier<NotePitch> C2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "C2");

    public static final Supplier<NotePitch> C_SHARP1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "C_SHARP1");

    public static final Supplier<NotePitch> C_SHARP2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "C_SHARP2");

    public static final Supplier<NotePitch> D1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "D1");

    public static final Supplier<NotePitch> D2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "D2");

    public static final Supplier<NotePitch> D_SHARP1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "D_SHARP1");

    public static final Supplier<NotePitch> D_SHARP2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "D_SHARP2");

    public static final Supplier<NotePitch> E1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "E1");

    public static final Supplier<NotePitch> E2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "E2");

    public static final Supplier<NotePitch> F1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "F1");

    public static final Supplier<NotePitch> F2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "F2");

    public static final Supplier<NotePitch> F_SHARP0 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "F_SHARP0");

    public static final Supplier<NotePitch> F_SHARP1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "F_SHARP1");

    public static final Supplier<NotePitch> F_SHARP2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "F_SHARP2");

    public static final Supplier<NotePitch> G0 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "G0");

    public static final Supplier<NotePitch> G1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "G1");

    public static final Supplier<NotePitch> G_SHARP0 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "G_SHARP0");

    public static final Supplier<NotePitch> G_SHARP1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(NotePitch.class, "G_SHARP1");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private NotePitches() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
