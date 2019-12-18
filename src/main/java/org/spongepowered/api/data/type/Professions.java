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
 * An enumeration of vanilla {@link Profession}s.
 */
public final class Professions {

    // SORTFIELDS:ON

    public static final Supplier<Profession> ARMORER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "ARMORER");

    public static final Supplier<Profession> BUTCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "BUTCHER");

    public static final Supplier<Profession> CARTOGRAPHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "CARTOGRAPHER");

    public static final Supplier<Profession> CLERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "CLERIC");

    public static final Supplier<Profession> FARMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "FARMER");

    public static final Supplier<Profession> FISHERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "FISHERMAN");

    public static final Supplier<Profession> FLETCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "FLETCHER");

    public static final Supplier<Profession> LEATHERWORKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "LEATHERWORKER");

    public static final Supplier<Profession> LIBRARIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "LIBRARIAN");

    public static final Supplier<Profession> MASON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "MASON");

    public static final Supplier<Profession> NITWIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "NITWIT");

    public static final Supplier<Profession> NONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "NONE");

    public static final Supplier<Profession> SHEPHERD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "SHEPHERD");

    public static final Supplier<Profession> TOOLSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "TOOLSMITH");

    public static final Supplier<Profession> WEAPONSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Profession.class, "WEAPONSMITH");

    // SORTFIELDS:OFF

    private Professions() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
