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

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.TypeTokens;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Represents a key to an underlying {@link Value} such that the underlying
 * value can be retrieved from a {@link ValueContainer}. As well, a {@link Key}
 * can be used for {@link DataSerializable}s with the included
 * {@link #getQuery()} to retrieve the recommended {@link DataQuery} to use.
 *
 * @param <V> The type of {@link Value}
 */
@CatalogedBy(Keys.class)
public interface Key<V extends Value<?>> extends CatalogType {

    /**
     * Creates a {@link Key.Builder} which allows creation of a {@link Key}
     * to later be registered for accessing values from
     * a {@link ValueContainer}.
     *
     * @return The key builder
     */
    @SuppressWarnings("unchecked")
    static Builder<?, ?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the class of the {@link Value} this {@link Key} is representing.
     *
     * @return The value class
     */
    TypeToken<V> getValueToken();

    /**
     * Gets the class of the element of the {@link Value} this {@link Key}
     * is representing. On occasion, if the element is a {@link Collection} type,
     * one can occasionally use {@link TypeToken#resolveType(Type)} with
     * {@link Class#getTypeParameters()} as the type parameter of a collection
     * is retrievable, such as the element type parameter for {@link List} or
     * {@link Map}.
     *
     * @return The element class
     */
    TypeToken<?> getElementToken();

    /**
     * Gets the {@link DataQuery} for recommended use with
     * {@link DataContainer}s.
     *
     * @return The recommended {@link DataQuery} for use
     */
    DataQuery getQuery();

    /**
     * Register an event listener which listens to the value the key accesses
     * changing.
     *
     * @param holderFilter The data holder to filter with
     * @param listener The event listener
     * @param <E> The class type of the data holder
     */
    <E extends DataHolder> void registerEvent(Class<E> holderFilter, EventListener<ChangeDataHolderEvent.ValueChange> listener);

    interface Builder<E, V extends Value<E>> extends CatalogBuilder<Key<V>, Builder<E, V>> {

        /**
         * Starter method for the builder, to be used immediately after
         * {@link Key#builder()} is called. This defines the generics for the
         * builder itself to provide the properly generified {@link Key}.
         *
         * <p>Common {@link TypeToken TypeTokens} can be found in
         * {@link TypeTokens}. If a new TypeToken is to be created, it is
         * recommended to create an anonymous class instance of a token,
         * as recommended by Guava's wiki found
         * <a href="https://github.com/google/guava/wiki/ReflectionExplained#introduction">here</a>.
         * </p>
         *
         * @param token The type token, preferably an anonymous
         * @param <T> The element type of the Key
         * @param <B> The base value type of the key
         * @return This builder, generified
         */
        <T, B extends Value<T>> Builder<T, B> type(TypeToken<B> token);

        /**
         * Sets the {@link DataQuery} recommended for use with
         * {@link DataContainer}s. See {@link Key#getQuery()}.
         *
         * @param query The DataQuery
         * @return This builder, for chaining
         */
        Builder<E, V> query(DataQuery query);

        /**
         * Builds the {@link Key}.
         *
         * @return The built key
         * @throws IllegalStateException If not all required options were specified; {@link #key(CatalogKey)},
         *                               {@link #type(TypeToken)} and {@link #query(DataQuery)}.
         */
        @Override
        Key<V> build();
    }

}
