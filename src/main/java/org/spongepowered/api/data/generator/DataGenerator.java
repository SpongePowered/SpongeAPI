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
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A generator that allows a {@link DataRegistration} to be constructed with
 * generated {@link DataManipulator} and {@link ImmutableDataManipulator} classes.
 */
public interface DataGenerator extends ResettableBuilder<DataRegistration<?, ?>, DataGenerator.TypeBuilder> {

    /**
     * Constructs a new {@link TypeBuilder}.
     *
     * @return The builder
     */
    static TypeBuilder builder() {
        return Sponge.getRegistry().createBuilder(TypeBuilder.class);
    }

    /**
     * Constructs a new {@link KeysBuilder}. This is the only {@link DataBuilder}
     * that supports multiple {@link Key}s.
     *
     * @return The key values data builder
     */
    static KeysBuilder keysBuilder() {
        return builder().keys();
    }

    /**
     * Generates a {@link VariantBuilder}. Only one key will be registered in
     * this {@link DataBuilder}. The output extend the classes
     * {@link VariantData} and a {@link ImmutableVariantData}.
     *
     * @param key Tke key
     * @param <V> The value type
     * @return The variant data builder
     */
    static <V> VariantBuilder<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> variantBuilder(
            Key<? extends Value<V>> key) {
        return builder().variant(key);
    }

    /**
     * Generates a {@link ListBuilder}. Only one key will be registered in
     * this {@link DataBuilder} and it's {@link Value} type must be a
     * {@link ListValue}. The output extend the classes
     * {@link ListData} and a {@link ImmutableListData}.
     *
     * @param key Tke key
     * @param <E> The element type
     * @return The list data builder
     */
    static <E> ListBuilder<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> listBuilder(
            Key<? extends ListValue<E>> key) {
        return builder().list(key);
    }

    /**
     * Generates a {@link MapBuilder}. Only one key will be registered in
     * this {@link DataBuilder} and it's {@link Value} type must be a
     * {@link MapValue}. The output extend the classes
     * {@link MappedData} and a {@link ImmutableMappedData}.
     *
     * @param key Tke key
     * @param <K> The map key type
     * @param <V> The map value type
     * @return The map data builder
     */
    static <K, V> MapBuilder<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> mapBuilder(
            Key<? extends MapValue<K, V>> key) {
        return builder().map(key);
    }

    /**
     * The nature of the builder doesn't allow values of data registration to be
     * reused. It is also unlikely that {@link Key}s names and manipulator types
     * will be reused in multiple {@link DataRegistration}s. Use {@link #reset()}
     * and resupply the builder instead.
     *
     * @param value The built object
     * @return This builder, for chaining
     */
    @Deprecated
    @Override
    TypeBuilder from(DataRegistration<?, ?> value) throws UnsupportedOperationException;

    /**
     * The {@link TypeBuilder}, this builder will construct a {@link DataBuilder}
     * based on the type of {@link DataManipulator} and {@link ImmutableDataManipulator}
     * as output.
     */
    interface TypeBuilder extends DataGenerator {

        /**
         * Constructs a new {@link KeysBuilder}. This is the only {@link DataBuilder}
         * that supports multiple {@link Key}s.
         *
         * @return The key values data builder
         */
        KeysBuilder<?, ?> keys();

        /**
         * Generates a {@link VariantBuilder}. Only one key will be registered in
         * this {@link DataBuilder}. The output extend the classes
         * {@link VariantData} and a {@link ImmutableVariantData}.
         *
         * @param key Tke key
         * @param <V> The value type
         * @return This builder as a variant builder, for chaining
         */
        <V> VariantBuilder<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> variant(
                Key<? extends Value<V>> key);

        /**
         * Generates a {@link ListBuilder}. Only one key will be registered in
         * this {@link DataBuilder} and it's {@link Value} type must be a
         * {@link ListValue}. The output extend the classes
         * {@link ListData} and a {@link ImmutableListData}.
         *
         * @param key Tke key
         * @param <E> The element type
         * @return The builder as a list data builder, for chaining
         */
        <E> ListBuilder<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> list(
                Key<? extends ListValue<E>> key);

        /**
         * Generates a {@link MapBuilder}. Only one key will be registered in
         * this {@link DataBuilder} and it's {@link Value} type must be a
         * {@link MapValue}. The output extend the classes
         * {@link MappedData} and a {@link ImmutableMappedData}.
         *
         * @param key Tke key
         * @param <K> The map key type
         * @param <V> The map value type
         * @return The builder as a map data builder, for chaining
         */
        <K, V> MapBuilder<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> map(
                Key<? extends MapValue<K, V>> key);
    }

    /**
     * The base interface for all the types of builders that generate
     * {@link DataManipulator} and {@link ImmutableDataManipulator} classes.
     *
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     * @param <B> The builder type
     */
    interface DataBuilder<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>, B extends DataBuilder<M, I, B>>
            extends DataGenerator {

        /**
         * Sets a more generalized name to refer to the registered
         * {@link DataManipulator} as a common name.
         *
         * <p>As an example: if I have a DummyTestData, a name could be "Dummy".</p>
         *
         * @param name The data name
         * @return This builder, for chaining
         */
        B name(String name);

        /**
         * Sets the content version of the constructed
         * {@link DataManipulator}s. Defaults to {@code 1}.
         *
         * @param contentVersion The content version
         * @return This builder, for chaining
         */
        B version(int contentVersion);

        /**
         * Defines a {@link Predicate} that checks whether the supplied
         * {@link DataManipulator} type is supported by the {@link DataHolder}.
         *
         * @param predicate The predicate
         * @return This builder, for chaining
         */
        B predicate(Predicate<? extends DataHolder> predicate);

        /**
         * Builds and registers the {@link DataRegistration} with the specified
         * plugin instance and manipulator id.
         *
         * @param pluginInstance The plugin instance
         * @param id The manipulator id
         * @return The constructed data registration
         */
        DataRegistration<M, I> buildAndRegister(Object pluginInstance, String id);
    }

    /**
     * This {@link DataBuilder} supports multiple {@link Key}s and it's values.
     *
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     */
    interface KeysBuilder<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
            extends DataBuilder<M, I, KeysBuilder<M, I>> {

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
        <NM extends DataManipulator<NM, NI>, NI extends ImmutableDataManipulator<NI, NM>> KeysBuilder<NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Registers a {@link Key} with the specified default value.
         *
         * @param key The key
         * @param defaultValue The default value
         * @param <T> The type of the value
         * @return This builder, for chaining
         */
        <T> KeysBuilder<M, I> key(Key<? extends BaseValue<T>> key, T defaultValue);

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
        <T extends Comparable<T>> KeysBuilder<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum);

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
        <T> KeysBuilder<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum, Comparator<T> comparator);
    }

    /**
     * This {@link DataBuilder} supports only one {@link Key}. The generated classes
     * will always extend {@link VariantData} and {@link ImmutableVariantData}.
     *
     * @param <V> The variant type
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     */
    interface VariantBuilder<V, M extends VariantData<V, M, I>, I extends ImmutableVariantData<V, I, M>>
            extends DataBuilder<M, I, VariantBuilder<V, M, I>> {

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
        <NM extends VariantData<V, NM, NI>, NI extends ImmutableVariantData<V, NI, NM>> VariantBuilder<V, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Sets the default variant type, is required to be set.
         *
         * @param defaultVariant The default variant type
         * @return This builder, for chaining
         */
        VariantBuilder<V, M, I> defaultValue(V defaultVariant);
    }

    /**
     * This {@link DataBuilder} supports only one {@link Key} with a {@link BaseValue}
     * of the type {@link ListValue}. The generated classes will
     * always extend {@link ListData} and {@link ImmutableListData}.
     *
     * @param <E> The element type of the list
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     */
    interface ListBuilder<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>>
            extends DataBuilder<M, I, ListBuilder<E, M, I>> {

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
        <NM extends ListData<E, NM, NI>, NI extends ImmutableListData<E, NI, NM>> ListBuilder<E, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Sets the default {@link List} value. Defaults to
         * {@link ArrayList#ArrayList()}.
         *
         * @param defaultList The default list
         * @return This builder, for chaining
         */
        ListBuilder<E, M, I> defaultValue(List<E> defaultList);
    }

    /**
     * This {@link DataBuilder} supports only one {@link Key} with a {@link BaseValue}
     * of the type {@link MapValue}. The generated classes will
     * always extend {@link MappedData} and {@link ImmutableMappedData}.
     *
     * @param <K> The key type of the map
     * @param <V> The value type of the map
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     */
    interface MapBuilder<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
            extends DataBuilder<M, I, MapBuilder<K, V, M, I>> {

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
        <NM extends MappedData<K, V, NM, NI>, NI extends ImmutableMappedData<K, V, NI, NM>> MapBuilder<K, V, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Sets the default {@link Map} value. Defaults to
         * {@link HashMap#HashMap()}.
         *
         * @param defaultMap The default map value
         * @return This builder, for chaining
         */
        MapBuilder<K, V, M, I> defaultValue(Map<K, V> defaultMap);
    }
}
