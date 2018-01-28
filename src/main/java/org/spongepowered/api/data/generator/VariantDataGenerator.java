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
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * This {@link DataGenerator} supports only one {@link Key}. The generated classes
 * will always extend {@link VariantData} and {@link ImmutableVariantData}.
 *
 * @param <V> The variant type
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
@SuppressWarnings("unchecked")
public interface VariantDataGenerator<V, M extends VariantData<V, M, I>, I extends ImmutableVariantData<V, I, M>>
        extends DataGenerator<M, I, VariantDataGenerator<V, M, I>, VariantDataGenerator<?,?,?>> {

    /**
     * Generates a {@link VariantDataGenerator}. Only one key will be registered in
     * this generator. The output extend the classes {@link VariantData}
     * and a {@link ImmutableVariantData}.
     *
     * @param <V> The value type
     * @return The variant data generator
     */
    static <V> VariantDataGenerator<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> builder() {
        return Sponge.getRegistry().createBuilder(VariantDataGenerator.class);
    }

    /**
     * Sets the {@link Key}.
     *
     * @param key Tke key
     * @param <NV> The value type
     * @return This builder, for chaining
     */
    <NV> VariantDataGenerator<NV, ? extends VariantData<NV, ?, ?>, ? extends ImmutableVariantData<NV, ?, ?>> key(
            Key<? extends Value<NV>> key);

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
    <NM extends VariantData<V, NM, NI>, NI extends ImmutableVariantData<V, NI, NM>> VariantDataGenerator<V, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default variant type, is required to be set.
     *
     * @param defaultVariant The default variant type
     * @return This builder, for chaining
     */
    VariantDataGenerator<V, M, I> defaultValue(V defaultVariant);
}
