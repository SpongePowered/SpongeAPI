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

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface DataStore {

    /**
     * Gets the supported {@link DataHolder} type.
     *
     * @return The supported dataHolder type.
     */
    TypeToken<? extends DataHolder> getSupportedToken();

    /**
     * Serializes the values of the {@link DataManipulator}
     * into the {@link DataView}.
     *
     * @param dataManipulator The data manipulator
     * @param view The data view to serialize to
     * @return The view, for chaining
     */
    DataView serialize(DataManipulator dataManipulator, DataView view);

    /**
     * Serializes the passed in {@link Value values} to the {@link DataView view}.
     *
     * @param values The values to serialize
     * @param view The view
     * @return The view, for chaining
     */
    default DataView serialize(Iterable<Value<?>> values, DataView view) {
        return serialize(DataManipulator.immutableOf(values), view);
    }

    /**
     * Serializes the {@link Value}s.
     *
     * @param values The value container
     * @return This view, for chaining
     */
    default DataView serialize(Iterable<Value<?>> values) {
        return serialize(DataManipulator.immutableOf(values));
    }

    /**
     * Serializes the values of the {@link DataManipulator}.
     *
     * @param dataManipulator The data manipulator
     * @return This view, for chaining
     */
    default DataView serialize(DataManipulator dataManipulator) {
        final DataView dataView = DataContainer.createNew();
        serialize(dataManipulator, dataView);
        return dataView;
    }

    /**
     * Deserializes the data from the {@link DataView} and puts
     * it in the {@link org.spongepowered.api.data.DataManipulator.Mutable}.
     *
     * @param dataManipulator The mutable data manipulator
     * @param view The data view to deserialize
     */
    void deserialize(DataManipulator.Mutable dataManipulator, DataView view);

    /**
     * Deserializes the {@link DataView} as a {@link org.spongepowered.api.data.DataManipulator.Mutable}.
     *
     * @param view The data view to deserialize
     * @return The value store
     */
    default DataManipulator.Mutable deserialize(DataView view) {
        final DataManipulator.Mutable dataManipulator = DataManipulator.mutableOf();
        deserialize(dataManipulator, view);
        return dataManipulator;
    }

    /**
     * Provides a {@link DataStore} for a single {@link Key}.
     * <p>
     *     Note that default deserializers do not support {@link Collection}, {@link Map} or Array types!
     *     Use {@link Builder#key(Key, BiConsumer, Function)} for these.
     * </p>
     *
     * @param key The data key
     * @param dataQuery The dataQuery to serialize this key under
     * @param typeToken The dataHolder type

     * @return The new data store
     */
    static <T> DataStore of(Key<Value<T>> key, DataQuery dataQuery, TypeToken<? extends DataHolder> typeToken) {
        return builder().key(key, dataQuery).build(typeToken);
    }

    /**
     * Returns the {@link DataStore} builder.
     *
     * @return The dataStore builder.
     */
    static DataStore.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    interface Builder extends ResettableBuilder<DataStore, Builder> {

        /**
         * Adds the default implemented serializers for the given key.
         * <p>
         *     Note that default deserializers do not support {@link Collection}, {@link Map} or Array types!
         *     Use {@link #key(Key, BiConsumer, Function)} for these.
         * </p>
         *
         * @param key The data key
         * @param dataQueries The dataQuery to serialize this key under
         *
         * @return this builder for chaining
         */
        default <T> Builder key(Key<? extends Value<T>> key, String... dataQueries) {
            return this.key(key, DataQuery.of(dataQueries));
        }

        /**
         * Adds the default implemented serializers for the given key.
         * <p>
         *     Note that default deserializers do not support {@link Collection}, {@link Map} or Array types!
         *     Use {@link #key(Key, BiConsumer, Function)} for these.
         * </p>
         *
         * @param key The data key
         * @param dataQuery The dataQuery to serialize this key under
         *
         * @return this builder for chaining
         */
        <T> Builder key(Key<? extends Value<T>> key, DataQuery dataQuery);

        /**
         * Adds the serializers for the given key.
         *
         * @param key The data key
         * @param serializer the data serializer
         * @param deserializer the data serserializer
         *
         * @return this builder for chaining
         */
        <T> Builder key(Key<? extends Value<T>> key, BiConsumer<DataView, T> serializer, Function<DataView, Optional<T>> deserializer);

        /**
         * Builds a dataStore for given dataHolder type.
         *
         * @param typeToken The dataHolder type
         *
         * @return The new data store
         */
        DataStore build(TypeToken<? extends DataHolder> typeToken);
    }

}
