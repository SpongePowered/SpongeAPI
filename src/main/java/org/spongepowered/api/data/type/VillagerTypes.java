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

public final class VillagerTypes {

    // SORTFIELDS:ON

    public static final Supplier<VillagerType> DESERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "desert");

    public static final Supplier<VillagerType> JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "jungle");

    public static final Supplier<VillagerType> PLAINS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "plains");

    public static final Supplier<VillagerType> SAVANNA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "savanna");

    public static final Supplier<VillagerType> SNOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "snow");

    public static final Supplier<VillagerType> SWAMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "swamp");

    public static final Supplier<VillagerType> TAIGA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(VillagerType.class, "taiga");

    // SORTFIELDS:OFF

    private VillagerTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
