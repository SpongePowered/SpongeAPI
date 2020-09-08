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
import org.spongepowered.api.entity.living.aquatic.fish.school.TropicalFish;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla shapes for {@link TropicalFish}.
 */
public class TropicalFishShapes {

    // SORTFIELDS:ON

    public static final Supplier<TropicalFishShape> BETTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "betty");

    public static final Supplier<TropicalFishShape> BLOCKFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "blockfish");

    public static final Supplier<TropicalFishShape> BRINELY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "brinely");

    public static final Supplier<TropicalFishShape> CLAYFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "clayfish");

    public static final Supplier<TropicalFishShape> DASHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "dasher");

    public static final Supplier<TropicalFishShape> FLOPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "flopper");

    public static final Supplier<TropicalFishShape> GLITTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "glitter");

    public static final Supplier<TropicalFishShape> KOB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "kob");

    public static final Supplier<TropicalFishShape> SNOOPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "snooper");

    public static final Supplier<TropicalFishShape> SPOTTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "spotty");

    public static final Supplier<TropicalFishShape> STRIPEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "stripey");

    public static final Supplier<TropicalFishShape> SUNSTREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TropicalFishShape.class, "sunstreak");

    // SORTFIELDS:OFF

    private TropicalFishShapes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
