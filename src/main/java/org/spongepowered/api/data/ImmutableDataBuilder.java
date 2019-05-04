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
package org.spongepowered.api.data;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.value.Value;

/**
 * A builder, much like a normal {@link DataBuilder} except that it builds
 * {@link org.spongepowered.api.data.DataHolder.Immutable}s. While the {@link org.spongepowered.api.data.DataHolder.Immutable} is like
 * a {@link DataHolder}, it is immutable.
 *
 * @param <H> The type of {@link org.spongepowered.api.data.DataHolder.Immutable}
 * @param <E> The extended {@link ImmutableDataBuilder}
 */
public interface ImmutableDataBuilder<H extends DataHolder.Immutable<H>, E extends ImmutableDataBuilder<H, E>> extends DataBuilder<H> {

    /**
     * Adds the given {@link Value} to the builder. The
     * {@link Value} is copied when the {@link org.spongepowered.api.data.DataHolder.Immutable}
     * is created.
     *
     * @param value The value to add
     * @return This builder, for chaining
     */
    @SuppressWarnings("unchecked")
    default E add(Value<?> value) {
        return (E) add((Key) value.getKey(), value.get());
    }

    @SuppressWarnings("unchecked")
    default E add(DataManipulator manipulator) {
        manipulator.getValues().forEach(this::add);
        return (E) this;
    }

    /**
     * Adds the given {@link Key} with the given value.
     *
     * @param key The key to assign the value with
     * @param value The value to assign with the key
     * @param <V> The type of the value
     * @return This builder, for chaining
     */
    <V> E add(Key<? extends Value<V>> key, V value);

    /**
     * Copies all known {@link DataManipulator}s from the given
     * {@link org.spongepowered.api.data.DataHolder.Immutable}. This is a defensive copy as
     * {@link DataManipulator} is mutable.
     *
     * @param holder The {@link org.spongepowered.api.data.DataHolder.Immutable} to copy from
     * @return This builder for chaining
     */
    @Override
    E from(H holder);

    /**
     * Attempts to build a new {@link org.spongepowered.api.data.DataHolder.Immutable}.
     *
     * @return The new immutable data holder
     */
    H build();

    @Override
    E reset();
}
