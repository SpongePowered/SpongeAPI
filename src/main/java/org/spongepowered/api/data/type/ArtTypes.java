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
 * An enumeration of vanilla {@link ArtType}s.
 */
public final class ArtTypes {

    // SORTFIELDS:ON

    public static final Supplier<ArtType> ALBAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "alban");

    public static final Supplier<ArtType> AZTEC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "aztec");

    public static final Supplier<ArtType> AZTEC2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "aztec2");

    public static final Supplier<ArtType> BOMB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "bomb");

    public static final Supplier<ArtType> BURNING_SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "burning_skull");

    public static final Supplier<ArtType> BUST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "bust");

    public static final Supplier<ArtType> COURBET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "courbet");

    public static final Supplier<ArtType> CREEBET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "creebet");

    public static final Supplier<ArtType> DONKEY_KONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "donkey_kong");

    public static final Supplier<ArtType> FIGHTERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "fighters");

    public static final Supplier<ArtType> GRAHAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "graham");

    public static final Supplier<ArtType> KEBAB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "kebab");

    public static final Supplier<ArtType> MATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "match");

    public static final Supplier<ArtType> PIGSCENE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "pigscene");

    public static final Supplier<ArtType> PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "plant");

    public static final Supplier<ArtType> POINTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "pointer");

    public static final Supplier<ArtType> POOL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "pool");

    public static final Supplier<ArtType> SEA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "sea");

    public static final Supplier<ArtType> SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "skeleton");

    public static final Supplier<ArtType> SKULL_AND_ROSES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "skull_and_roses");

    public static final Supplier<ArtType> STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "stage");

    public static final Supplier<ArtType> SUNSET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "sunset");

    public static final Supplier<ArtType> VOID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "void");

    public static final Supplier<ArtType> WANDERER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "wanderer");

    public static final Supplier<ArtType> WASTELAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "wasteland");

    public static final Supplier<ArtType> WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ArtType.class, "wither");

    // SORTFIELDS:OFF

    private ArtTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
