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
package org.spongepowered.api.data.manipulator.immutable;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Represents a type of {@link ImmutableDataManipulator} handling a specific
 * type of element, usually {@link CatalogType}s. The advantage is that
 * {@link #type()} will always return the same type as an
 * {@link ImmutableValue}.
 *
 * @param <E> The type of element value being represented
 * @param <I> The type of immutable variant data being extended
 * @param <M> The type of mutable variant data for mutability
 */
public interface ImmutableVariantData<E, I extends ImmutableVariantData<E, I, M>, M extends VariantData<E, M, I>>
    extends ImmutableDataManipulator<I, M> {

    /**
     * Gets the {@link ImmutableValue} of the the element type.
     *
     * @return The immutable value of the element type
     */
    ImmutableValue<E> type();

}
