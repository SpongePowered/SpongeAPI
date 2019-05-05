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
package org.spongepowered.api.data.manipulator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.ImmutableValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;

import java.util.function.Function;

/**
 * An {@code ImmutableDataManipulator} is an immutable {@link ValueContainer}
 * such that once it is created, any {@link Value}s exist as
 * {@link Value.Immutable}s. Any modification methods result in new instances of
 * the same typed {@link ImmutableDataManipulator}.
 */
public interface ImmutableDataManipulator extends DataManipulator {

    /**
     * Gets a empty {@link ImmutableValueStore}.
     *
     * @return The empty immutable data manipulator
     */
    static ImmutableDataManipulator empty() {
        return Sponge.getRegistry().requireFactory(Factory.class).of();
    }

    /**
     * Gets a {@link ImmutableValueStore} with the given values.
     *
     * @param values The values
     * @return The immutable data manipulator
     */
    static ImmutableDataManipulator of(Iterable<? extends Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(values);
    }

    /**
     * Gets whether the {@link Key} is supported, which is always
     * {@code true} in {@link ImmutableDataManipulator}s.
     *
     * @param key The key to check
     * @return Whether the key is supported
     */
    @Override
    default boolean supports(Key<?> key) {
        return true;
    }

    /**
     * Creates a new {@link ImmutableDataManipulator} with the provided value
     * if the {@link Key} is supported by this {@link ImmutableDataManipulator}
     * without exception.
     *
     * @param key The key to use
     * @param value The value to set
     * @param <E> The type of value
     * @return The new immutable data manipulator
     */
    default <E> ImmutableDataManipulator with(Key<? extends Value<E>> key, E value) {
        return asMutable().set(key, value).asImmutable();
    }

    /**
     * Creates a new {@link ImmutableDataManipulator} without the given {@link Key}.
     *
     * @param key The key to use
     * @return The new immutable data manipulator
     */
    default ImmutableDataManipulator without(Key<?> key) {
        return asMutable().remove(key).asImmutable();
    }

    /**
     * Creates a new {@link ImmutableDataManipulator} with the provided
     * {@link Value} provided that the {@link Value} is supported by
     * this {@link ImmutableDataManipulator}.
     *
     * @param value The value to set
     * @return The new immutable data manipulator
     */
    default <E> ImmutableDataManipulator with(Value<E> value) {
        return with(value.getKey(), value.get());
    }

    /**
     * Applies a transformation on the provided value if the key is available. This
     * is the same as {@link ImmutableValueStore#transform(Key, Function)}.
     *
     * @param key The key to use
     * @param function The function to apply
     * @param <E> The type of element
     * @return This manipulator, for chaining
     */
    default <E> ImmutableDataManipulator transform(Key<? extends Value<E>> key, Function<E, E> function) {
        checkNotNull(function, "function");
        return get(key).map(element -> with(key, checkNotNull(function.apply(element)))).orElse(this);
    }

    @Override
    default ImmutableDataManipulator copy() {
        return this;
    }

    @Override
    default ImmutableDataManipulator asImmutable() {
        return this;
    }

    interface Factory {

        ImmutableDataManipulator of();

        ImmutableDataManipulator of(Iterable<? extends Value<?>> values);
    }
}
