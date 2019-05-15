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
package org.spongepowered.api.data.persistence;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * Represents a builder that can take a {@link DataContainer} and create a
 * new instance of a {@link DataSerializable}. The builder should be a
 * singleton and may not exist for every data serializable.
 *
 * <p>It is <strong>HIGHLY</strong> recommended to extend
 * {@link AbstractDataBuilder} as it implements content updating</p>
 *
 * @param <T> The type of data serializable this builder can build
 */
public interface DataBuilder<T extends DataSerializable> extends CopyableBuilder<T, DataBuilder<T>> {

    /**
     * Attempts to build the provided {@link DataSerializable} from the given
     * {@link DataView}. If the {@link DataView} is invalid or
     * missing necessary information to complete building the
     * {@link DataSerializable}, {@link Optional#empty()} may be returned.
     *
     * @param container The container containing all necessary data
     * @return The instance of the {@link DataSerializable}, if successful
     * @throws InvalidDataException In the event that the builder is unable to
     *     properly construct the data serializable from the data view
     */
    Optional<T> build(DataView container) throws InvalidDataException;

    @Override
    default DataBuilder<T> reset() {
        return this;
    }

    @Override
    default DataBuilder<T> from(T value) {
        return this;
    }

    /**
     * A builder, much like a normal {@link DataBuilder} except that it builds
     * {@link DataHolder.Immutable}s. While the {@link DataHolder.Immutable} is like
     * a {@link DataHolder}, it is immutable.
     *
     * @param <H> The type of {@link DataHolder.Immutable}
     * @param <E> The extended {@link Immutable}
     */
    interface Immutable<H extends DataHolder.Immutable<H>, E extends Immutable<H, E>> extends DataBuilder<H> {

        /**
         * Adds the given {@link Value} to the builder. The
         * {@link Value} is copied when the {@link DataHolder.Immutable}
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
         * {@link DataHolder.Immutable}. This is a defensive copy as
         * {@link DataManipulator} is mutable.
         *
         * @param holder The {@link DataHolder.Immutable} to copy from
         * @return This builder for chaining
         */
        @Override
        E from(H holder);

        /**
         * Attempts to build a new {@link DataHolder.Immutable}.
         *
         * @return The new immutable data holder
         */
        H build();

        @Override
        E reset();
    }
}
