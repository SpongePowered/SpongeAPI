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
 * An enumeration of vanilla {@link PandaGene}s.
 */
public final class PandaGenes {

    // SORTFIELDS:ON

    public static final Supplier<PandaGene> AGGRESSIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "AGGRESSIVE");

    public static final Supplier<PandaGene> BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "BROWN");

    public static final Supplier<PandaGene> LAZY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "LAZY");

    public static final Supplier<PandaGene> NORMAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "NORMAL");

    public static final Supplier<PandaGene> PLAYFUL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "PLAYFUL");

    public static final Supplier<PandaGene> WEAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "WEAK");

    public static final Supplier<PandaGene> WORRIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PandaGene.class, "WORRIED");

    // SORTFIELDS:OFF

    private PandaGenes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
