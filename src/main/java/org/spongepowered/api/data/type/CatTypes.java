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
 * An enumeration of vanilla {@link CatType}s.
 */
public final class CatTypes {

    // SORTFIELDS:ON

    public static final Supplier<CatType> ALL_BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "ALL_BLACK");

    public static final Supplier<CatType> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "BLACK");

    public static final Supplier<CatType> BRITISH_SHORTHAIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "BRITISH_SHORTHAIR");

    public static final Supplier<CatType> CALICO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "CALICO");

    public static final Supplier<CatType> JELLIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "JELLIE");

    public static final Supplier<CatType> PERSIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "PERSIAN");

    public static final Supplier<CatType> RAGDOLL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "RAGDOLL");

    public static final Supplier<CatType> RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "RED");

    public static final Supplier<CatType> SIAMESE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "SIAMESE");

    public static final Supplier<CatType> WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatType.class, "WHITE");

    // SORTFIELDS:OFF

    private CatTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
