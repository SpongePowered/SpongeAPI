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
package org.spongepowered.api.data.value.immutable;

import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.function.Function;

/**
 * Represents an immutable representation of a {@link BaseValue} where any
 * modifications of the underlying value result in a new instance of an
 * {@link ImmutableValue} and/or the {@link ValueContainer} if the
 * {@link ValueContainer} too is immutable.
 *
 * <p>The basis for immutability is that once created, the value can not be
 * changed for any reason. Change requires a new instance to be created. As the
 * {@link ImmutableValue} always has a {@link ValueContainer}, it is
 * recommended that the owning {@link ValueContainer} too is immutable, unless
 * the {@link ImmutableValue} is being passed around for data processing. The
 * underlying value of an {@link ImmutableValue} may be itself mutable, however
 * utilizing any provided methods by any of the {@link ImmutableValue} classes
 * is recommended.</p>
 *
 * @param <E> The type of value
 */
public interface ImmutableValue<E> extends BaseValue<E> {

    /**
     * Creates a new {@link ImmutableValue} with the given <code>E</code> typed
     * value, such that if the owning {@link ValueContainer} is immutable, the
     * {@link ValueContainer} too is recreated as a new instance with the new
     * {@link ImmutableValue}.
     *
     * @param value The value to replace
     * @return The owning {@link ValueContainer}, a new instance if it too is
     *     immutable
     */
    ImmutableValue<E> with(E value);

    /**
     * Retrieves the underlying value for this {@link ImmutableValue} and
     * applies the given {@link Function} onto that value, after which, the
     * product is sent to a new {@link ImmutableValue} replacing this one.
     *
     * <p>If the {@link ValueContainer} too is immutable, a new instance of
     * the {@link ValueContainer} may be created. If the {@link ValueContainer}
     * is mutable, the same instance of the {@link ValueContainer} is retained.
     * </p>
     *
     * @param function The function to apply onto the existing value
     * @return The owning {@link ValueContainer}, a new instance if it too is
     *     immutable
     */
    ImmutableValue<E> transform(Function<E, E> function);

    /**
     * Creates a mutable {@link Value} for this {@link ImmutableValue}.
     *
     * @return A mutable value
     */
    Value<E> asMutable();
}
