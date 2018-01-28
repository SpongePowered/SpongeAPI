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
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * This {@link DataGenerator} supports only one {@link Key} with a {@link BaseValue}
 * of the type {@link MapValue}. The generated classes will
 * always extend {@link MappedData} and {@link ImmutableMappedData}.
 *
 * @param <K> The key type of the map
 * @param <V> The value type of the map
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
@SuppressWarnings("unchecked")
public interface MappedDataGenerator<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
        extends DataGenerator<M, I, MappedDataGenerator<K, V, M, I>, MappedDataGenerator<?,?,?,?>> {

    /**
     * Generates a {@link MappedDataGenerator}. Only one key will be
     * registered in this generator and it's {@link Value} type must
     * be a {@link MapValue}. The output extend the classes
     * {@link MappedData} and a {@link ImmutableMappedData}.
     *
     * @param <K> The map key type
     * @param <V> The map value type
     * @return The map data builder
     */
    static <K, V> MappedDataGenerator<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> builder() {
        return Sponge.getRegistry().createBuilder(MappedDataGenerator.class);
    }

    /**
     * Sets the {@link Key}.
     *
     * @param key Tke key
     * @param <NK> The map key type
     * @param <NV> The map value type
     * @return The builder as a mapped data builder, for chaining
     */
    <NK, NV> MappedDataGenerator<NK, NV, ? extends MappedData<NK, NV, ?, ?>, ? extends ImmutableMappedData<NK, NV, ?, ?>> key(
            Key<? extends MapValue<NK, NV>> key);

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
    <NM extends MappedData<K, V, NM, NI>, NI extends ImmutableMappedData<K, V, NI, NM>> MappedDataGenerator<K, V, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default {@link Map} value. Defaults to
     * {@link HashMap#HashMap()}.
     *
     * @param defaultMap The default map value
     * @return This builder, for chaining
     */
    MappedDataGenerator<K, V, M, I> defaultValue(Map<K, V> defaultMap);
}
