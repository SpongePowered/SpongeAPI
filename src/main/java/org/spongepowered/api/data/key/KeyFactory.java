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
package org.spongepowered.api.data.key;

import com.google.common.base.Objects;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Map;
import java.util.Optional;

/**
 * A factory of {@link Key}s, useful for both the implementation of SpongeAPI,
 * and for plugins wishing to provide their own {@link Key}s without having
 * to remain afraid of having to cast back and forth.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public final class KeyFactory {

    private KeyFactory() {}

    /**
     * Creates a new {@link Key} with the provided <code>E</code> element
     * class and <code>V</code> {@link Value} class along with the provided
     * default {@link DataQuery} to be used with the generated {@link Key}.
     *
     * <p>Note that {@link Key}s are not registered, but it is recommended
     * to avoid generating {@link Key}s of potentially conflicting
     * {@link DataQuery}(s).</p>
     *
     * @param elementClass The element class
     * @param valueClass The value class
     * @param query The query
     * @param <E> The type of element
     * @param <T> The type of base value class
     * @param <V> The inferred return type
     * @return The generated key
     */
    public static <E, T extends BaseValue, V extends BaseValue<E>> Key<V> makeSingleKey(final Class<E> elementClass, final Class<T> valueClass,
            final DataQuery query) {
        return new Key<V>() {

            private final int hash = Objects.hashCode(elementClass, valueClass, query);

            @SuppressWarnings("rawtypes")
            @Override
            public Class<V> getValueClass() {
                return (Class<V>) (Class) valueClass;
            }

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public String toString() {
                return "Key{Value:" + valueClass.getSimpleName() + "<" + elementClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link ListValue} of a type
     * <code>E</code> element along with the provided {@link DataQuery}.
     *
     * @param elementClass The element class
     * @param query The query to access the data
     * @param <E> The type of element
     * @return The generated key
     */
    public static <E> Key<ListValue<E>> makeListKey(final Class<E> elementClass, final DataQuery query) {
        return new Key<ListValue<E>>() {
            private final int hash = Objects.hashCode(ListValue.class, elementClass, query);

            @SuppressWarnings("rawtypes")
            @Override
            public Class<ListValue<E>> getValueClass() {
                return (Class<ListValue<E>>) (Class) ListValue.class;
            }

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public String toString() {
                return "Key{Value:" + "ListValue<" + elementClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link SetValue} of a type
     * <code>E</code> element along with the provided {@link DataQuery}.
     *
     * @param elementClass The element class
     * @param query The query to access the data
     * @param <E> The type of element
     * @return The generated key
     */
    public static <E> Key<SetValue<E>> makeSetKey(final Class<E> elementClass, final DataQuery query) {
        return new Key<SetValue<E>>() {
            private final int hash = Objects.hashCode(ListValue.class, elementClass, query);

            @SuppressWarnings("rawtypes")
            @Override
            public Class<SetValue<E>> getValueClass() {
                return (Class<SetValue<E>>) (Class) SetValue.class;
            }

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public String toString() {
                return "Key{Value:" + "SetValue<" + elementClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link MapValue} of the types
     * <code>K</code> keys and <code>V</code> values with the provided
     * {@link DataQuery} for accessing the {@link Map} in {@link DataView}s.
     *
     * @param keyClass The key class of the map
     * @param valueclass The value class of the map
     * @param query The query
     * @param <K> The type of keys
     * @param <V> The type of values
     * @return The generated key
     */
    public static <K, V> Key<MapValue<K, V>> makeMapKey(final Class<K> keyClass, final Class<V> valueclass, final DataQuery query) {
        return new Key<MapValue<K, V>>() {

            private final int hash = Objects.hashCode(keyClass, valueclass, query);

            @SuppressWarnings("rawtypes")
            @Override
            public Class<MapValue<K, V>> getValueClass() {
                return (Class<MapValue<K, V>>) (Class) MapValue.class;
            }

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public String toString() {
                return "Key{Value:" + "MapValue<" + keyClass.getSimpleName() + "," + valueclass.getSimpleName() + ">, Query: " + query.toString()
                       + "}";
            }
        };
    }

    /**
     * Creates a new {@link Key} based on an {@link OptionalValue} of the type
     * <code>E</code> element type with the provided {@link DataQuery} for
     * accessing the optionally null value in {@link DataView}s.
     *
     * @param elementClass The element class
     * @param query The query
     * @param <E> The element type
     * @return The generated key
     */
    public static <E> Key<OptionalValue<E>> makeOptionalKey(final Class<E> elementClass, final DataQuery query) {
        return new Key<OptionalValue<E>>() {

            private final int hash = Objects.hashCode(Optional.class, elementClass, query);

            @Override
            public Class<OptionalValue<E>> getValueClass() {
                return (Class<OptionalValue<E>>) (Class<?>) OptionalValue.class;
            }

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public String toString() {
                return "Key{Value:" + "OptionalValue<" + elementClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    static <E, V extends BaseValue<E>> Key<V> fake(final String keyName) {
        return new Key<V>() {
            @Override
            public Class<V> getValueClass() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }

            @Override
            public DataQuery getQuery() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }
        };
    }

}
