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
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Predicate;

/**
 * A generator that allows a {@link DataRegistration} to be constructed with
 * generated {@link DataManipulator} and {@link ImmutableDataManipulator} classes.
 */
public interface DataGenerator extends ResettableBuilder<DataRegistration<?, ?>, DataGenerator.TypeStep> {

    /**
     * Constructs a new {@link TypeStep}.
     *
     * @return The builder
     */
    static TypeStep builder() {
        return Sponge.getRegistry().createBuilder(TypeStep.class);
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
    TypeStep from(DataRegistration<?, ?> value) throws UnsupportedOperationException;

    /**
     * The {@link TypeStep}, this builder will construct a {@link FinalStep}
     * based on the type of {@link DataManipulator} and {@link ImmutableDataManipulator}
     * as output.
     */
    interface TypeStep extends DataGenerator {

        /**
         * Constructs a new {@link GenericDataGenerator}. This is the only generator
         * that supports multiple {@link Key}s.
         *
         * @return This generator as a generic data generator, for chaining
         */
        GenericDataGenerator<?, ?> generic();

        /**
         * Generates a {@link VariantDataGenerator}. Only one key will be registered in
         * this generator. The output extend the classes {@link VariantData} and
         * a {@link ImmutableVariantData}.
         *
         * @param key Tke key
         * @param <V> The value type
         * @return This generator as a variant data generator, for chaining
         */
        <V> VariantDataGenerator<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> variant(
                Key<? extends Value<V>> key);

        /**
         * Generates a {@link ListDataGenerator}. Only one key will be registered in
         * this {@link FinalStep} and it's {@link Value} type must be a
         * {@link ListValue}. The output extend the classes
         * {@link ListData} and a {@link ImmutableListData}.
         *
         * @param key Tke key
         * @param <E> The element type
         * @return The builder as a list data builder, for chaining
         */
        <E> ListDataGenerator<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> list(
                Key<? extends ListValue<E>> key);

        /**
         * Generates a {@link MappedDataGenerator}. Only one key will be registered in
         * this generator and it's {@link Value} type must be a {@link MapValue}.
         * The output extend the classes {@link MappedData} and a {@link ImmutableMappedData}.
         *
         * @param key Tke key
         * @param <K> The map key type
         * @param <V> The map value type
         * @return The builder as a mapped data builder, for chaining
         */
        <K, V> MappedDataGenerator<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> mapped(
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
    interface FinalStep<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>, B extends FinalStep<M, I, B>>
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
         * Builds the {@link DataRegistration} with the specified manipulator
         * id and the {@link PluginContainer} in the current context.
         *
         * @param id The manipulator id (without the namespace)
         * @return The constructed data registration
         */
        DataRegistration<M, I> build(String id);
    }

}
