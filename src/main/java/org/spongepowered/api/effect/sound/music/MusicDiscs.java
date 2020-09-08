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
package org.spongepowered.api.effect.sound.music;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public final class MusicDiscs {

    // SORTFIELDS:ON

    public static final Supplier<MusicDisc> BLOCKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "blocks");

    public static final Supplier<MusicDisc> CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "cat");

    public static final Supplier<MusicDisc> CHIRP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "chirp");

    public static final Supplier<MusicDisc> ELEVEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "eleven");

    public static final Supplier<MusicDisc> FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "far");

    public static final Supplier<MusicDisc> MALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "mall");

    public static final Supplier<MusicDisc> MELLOHI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "mellohi");

    public static final Supplier<MusicDisc> STAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "stal");

    public static final Supplier<MusicDisc> STRAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "strad");

    public static final Supplier<MusicDisc> THIRTEEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "thirteen");

    public static final Supplier<MusicDisc> WAIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "wait");

    public static final Supplier<MusicDisc> WARD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MusicDisc.class, "ward");

    // SORTFIELDS:OFF

    private MusicDiscs() {
    }

}
