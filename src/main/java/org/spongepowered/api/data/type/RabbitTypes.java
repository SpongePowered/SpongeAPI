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
 * An enumeration of vanilla {@link RabbitType}s.
 */
public final class RabbitTypes {

    // SORTFIELDS:ON

    public static final Supplier<RabbitType> BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "black");

    public static final Supplier<RabbitType> BLACK_AND_WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "black_and_white");

    public static final Supplier<RabbitType> BROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "brown");

    public static final Supplier<RabbitType> GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "gold");

    public static final Supplier<RabbitType> KILLER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "killer");

    public static final Supplier<RabbitType> SALT_AND_PEPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "salt_and_pepper");

    public static final Supplier<RabbitType> WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RabbitType.class, "white");

    // SORTFIELDS:OFF

    private RabbitTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
