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
package org.spongepowered.api.data.value.mutable;

import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import java.util.function.Function;

/**
 * Represents a type of {@link BaseValue} that is mutable. Simply put, the
 * underlying value can always be changed without creating a new {@link Value}.
 *
 * @param <E> The type of element
 */
public interface Value<E> extends BaseValue<E> {

    /**
     * Sets the underlying value to the provided {@code value}.
     *
     * @param value The value to set
     * @return The owning {@link ValueContainer}
     */
    Value<E> set(E value);

    /**
     * Attempts to transform the underlying value based on the provided
     * {@link Function} such that the result of {@link Function#apply(Object)}
     * will replace the underlying value.
     *
     * @param function The function to apply on the existing value
     * @return The owning {@link ValueContainer}
     */
    Value<E> transform(Function<E, E> function);

    /**
     * Gets the {@link ImmutableValue} version of this {@link Value} such that
     * all data is duplicated across to the new {@link ImmutableValue}. Note
     * that once created, the {@link ImmutableValue} is not going to change.
     *
     * @return A new {@link ImmutableValue} instance
     */
    ImmutableValue<E> asImmutable();

    /**
     * Makes an independent copy of this {@link Value} with the same initial
     * data. Both this value and the new value will refer to the same object
     * initially.
     *
     * @return A new copy of this {@link Value}
     */
    Value<E> copy();
}
