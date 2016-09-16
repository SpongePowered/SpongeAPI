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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Objects;
import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

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
     * @param <E> The type of element
     * @param <V> The inferred return type
     * @param elementToken The element class
     * @param valueToken The value class
     * @param query The query
     * @return The generated key
     */
    public static <E, V extends BaseValue<E>> Key<V> makeSingleKey(final TypeToken<E> elementToken, final TypeToken<V> valueToken,
            final DataQuery query, final String id, final String name) {
        validateId(id);
        return new Key<V>() {

            @Nullable private String string;


            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            private final int hash = Objects.hashCode(elementToken, valueToken, query);

            @SuppressWarnings("rawtypes")
            @Override
            public TypeToken<V> getValueToken() {
                return valueToken;
            }

            @Override
            public TypeToken<?> getElementToken() {
                return elementToken;
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
                if (this.string == null) {
                    this.string = "Key{Value:" + valueToken.getRawType().getSimpleName() + "<"
                                  + elementToken.getRawType().getSimpleName() + ">, Query: "
                                  + query.toString() + "}";
                }

                return this.string;
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link ListValue} of a type
     * <code>E</code> element along with the provided {@link DataQuery}.
     *
     * @param <E> The type of element
     * @param elementToken The element class
     * @param query The query to access the data
     * @return The generated key
     */
    public static <E> Key<ListValue<E>> makeListKey(final TypeToken<? extends List<E>> elementToken, final TypeToken<ListValue<E>> valueToken,
            final DataQuery query, final String id, final String name) {
        validateId(id);
        return new Key<ListValue<E>>() {
            @Nullable private String string;

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            private final int hash = Objects.hashCode(ListValue.class, elementToken, query);

            @SuppressWarnings("rawtypes")
            @Override
            public TypeToken<ListValue<E>> getValueToken() {
                return valueToken;
            }

            @Override
            public TypeToken<?> getElementToken() {
                return elementToken;
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
                if (this.string == null) {
                    this.string = "Key{Value:ListValue<" + elementToken.toString() + ">, Query: " + query.toString() + "}";
                }
                return this.string;
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link SetValue} of a type
     * <code>E</code> element along with the provided {@link DataQuery}.
     *
     * @param <E> The type of element
     * @param elementToken The element class
     * @param valueToken
     *@param query The query to access the data  @return The generated key
     */
    public static <E> Key<SetValue<E>> makeSetKey(final TypeToken<? extends Set<E>> elementToken, TypeToken<SetValue<E>> valueToken,
            final DataQuery query, final String id, final String name) {
        validateId(id);
        return new Key<SetValue<E>>() {

            @Nullable private String string;

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            private final int hash = Objects.hashCode(ListValue.class, elementToken, query);

            @SuppressWarnings("rawtypes")
            @Override
            public TypeToken<SetValue<E>> getValueToken() {
                return valueToken;
            }

            @Override
            public TypeToken<?> getElementToken() {
                return elementToken;
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
                if (this.string == null) {
                    this.string = "Key{Value:" + "SetValue<" + elementToken.toString() + ">, Query: " + query.toString() + "}";
                }
                return this.string;
            }
        };
    }

    /**
     * Creates a new {@link Key} based on a {@link MapValue} of the types
     * <code>K</code> keys and <code>V</code> values with the provided
     * {@link DataQuery} for accessing the {@link Map} in {@link DataView}s.
     *
     * @param <K> The type of keys
     * @param <V> The type of values
     * @param elementToken The element token
     * @param valueToken The value class of the map
     * @param query The query
     * @return The generated key
     */
    public static <K, V> Key<MapValue<K, V>> makeMapKey(final TypeToken<Map<K, V>> elementToken, final TypeToken<MapValue<K, V>> valueToken, final DataQuery query, final String id, final String name) {
        validateId(id);
        return new Key<MapValue<K, V>>() {

            @Nullable private String string;

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            private final int hash = Objects.hashCode(elementToken, valueToken, query);

            @SuppressWarnings("rawtypes")
            @Override
            public TypeToken<MapValue<K, V>> getValueToken() {
                return valueToken;
            }

            @SuppressWarnings("rawtypes")
            @Override
            public TypeToken<?> getElementToken() {
                return elementToken;
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
                if (this.string == null) {
                    this.string = "Key{Value:" + "MapValue<" + elementToken.toString() + ","
                                  + valueToken.toString() + ">, Query: " + query.toString() + "}";
                }
                return this.string;
            }
        };
    }

    /**
     * Creates a new {@link Key} based on an {@link OptionalValue} of the type
     * <code>E</code> element type with the provided {@link DataQuery} for
     * accessing the optionally null value in {@link DataView}s.
     *
     * @param <E> The element type
     * @param elementToken The element class
     * @param valueToken
     * @param query The query
     * @return The generated key
     */
    public static <E> Key<OptionalValue<E>> makeOptionalKey(final TypeToken<Optional<E>> elementToken, TypeToken<OptionalValue<E>> valueToken,
            final DataQuery query, final String id,
            final String name) {
        validateId(id);
        return new Key<OptionalValue<E>>() {
            @Nullable private String string;

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            private final int hash = Objects.hashCode(Optional.class, elementToken, query);

            @Override
            public TypeToken<OptionalValue<E>> getValueToken() {
                return valueToken;
            }

            @Override
            public TypeToken<?> getElementToken() {
                return elementToken;
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
                if (this.string == null) {
                    this.string = "Key{Value:" + "OptionalValue<" + elementToken.toString() + ">, Query: " + query.toString() + "}";
                }
                return this.string;
            }
        };
    }

    private static void validateId(String id) {
        checkArgument(id != null, "A Key's id cannot be null!");
        checkArgument(id.contains(":"), "A key must have a plugin id prefix with \":\" separating the plugin id and key id!");
    }

    static <E, V extends BaseValue<E>> Key<V> fake(final String keyName) {
        return new Key<V>() {
            @Override
            public String getId() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }

            @Override
            public String getName() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }

            @Override
            public TypeToken<V> getValueToken() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }

            @Override
            public TypeToken<?> getElementToken() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }

            @Override
            public DataQuery getQuery() {
                throw new UnsupportedOperationException("Key " + keyName + " is not implemented");
            }
        };
    }

}
