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
package org.spongepowered.api.data.generator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.BoundedValue;

import java.util.Comparator;

/**
 * This {@link DataGenerator} supports multiple {@link Key}s and it's values.
 *
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
@SuppressWarnings("unchecked")
public interface GenericDataGenerator<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
        extends DataGenerator<M, I, GenericDataGenerator<M, I>, GenericDataGenerator<?,?>> {

    /**
     * Constructs a new {@link GenericDataGenerator}. This is the
     * only generator that supports multiple {@link Key}s.
     *
     * @return The generic data generator
     */
    static GenericDataGenerator<?,?> builder() {
        return Sponge.getRegistry().createBuilder(GenericDataGenerator.class);
    }

    /**
     * Sets the interfaces that the generated {@link DataManipulator} and
     * {@link ImmutableDataManipulator} classes should be implement.
     *
     * @param mutableClass The mutable interface
     * @param immutableClass The immutable interface
     * @param <NM> The type of the mutable interface
     * @param <NI> The type of the immutable interface
     * @return This builder, for chaining
     */
    <NM extends DataManipulator<NM, NI>, NI extends ImmutableDataManipulator<NI, NM>> GenericDataGenerator<NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Registers a {@link Key} with the specified default value.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T> GenericDataGenerator<M, I> key(Key<? extends BaseValue<T>> key, T defaultValue);

    /**
     * Registers a {@link Key} with a bounded value and specified default value.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param minimum The minimum value
     * @param maximum The maximum value
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T extends Comparable<T>> GenericDataGenerator<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum);

    /**
     * Registers a {@link Key} with a bounded value and specified
     * default value. The {@link Comparator} will be used to check whether
     * the value is between it's bounds.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param minimum The minimum value
     * @param maximum The maximum value
     * @param comparator The comparator
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T> GenericDataGenerator<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum, Comparator<T> comparator);
}
