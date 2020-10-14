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
package org.spongepowered.api.data;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.TypeTokens;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.plugin.PluginContainer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * Represents a key to an underlying {@link Value} such that the underlying
 * value can be retrieved from a {@link ValueContainer}. For the key to be used
 * through retrieval of {@link DataHolder}s, it's required to use a
 * {@link DataRegistration} if the data is needed to be serialized, or dynamically
 * provided for through external mechanisms, through {@link DataProvider}s.
 *
 * <p>If dynamic or persistent retention of the {@link Value Values} by
 * {@link Key keys} is not desired, a registration with {@link DataRegistration}
 * is optional. This would mean that any submitted {@link Value}s of a
 * {@link Key} without an associated {@link DataRegistration} will be only
 * stored on a
 * {@link org.spongepowered.api.data.DataHolder.Mutable mutable DataHolder} for
 * the duration that that holder exists. The value would not persist between
 * reloads, restarts, etc.</p>
 *
 * @param <V> The type of {@link Value}
 */
@CatalogedBy(Keys.class)
public interface Key<V extends Value<?>> extends CatalogType {

    /**
     * Creates a {@link Key.Builder} which allows creation of a {@link Key}
     * to later be registered for accessing values from
     * a {@link ValueContainer}. It is the default policy that a
     * custom created {@link Key} is <strong>NOT PERSISTENT</strong> by
     * Sponge. If custom keys for {@link DataHolder}s is desired to be
     * persisted, a {@link DataRegistration} is required.
     *
     * <p>Registration of a custom created {@link Key} is required through
     * {@link org.spongepowered.api.event.lifecycle.RegisterCatalogEvent}. The
     * registration of a {@link DataRegistration} is done separately.
     * </p>
     *
     * @see DataRegistration
     * @return The key builder
     */
    @SuppressWarnings("unchecked")
    static Builder<?, ?> builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the type of the {@link Value} this {@link Key} is representing.
     *
     * @return The value generic type
     */
    Type getValueType();

    /**
     * Gets the type of the element of the {@link Value} this {@link Key}
     * is representing. On occasion, if the element is a {@link Collection} type,
     * one can use {@link ParameterizedType#getActualTypeArguments()} to access
     * type parameters, such as the element type parameter for {@link List} or
     * {@link Map} values.
     *
     * @return The element generic type
     */
    Type getElementType();

    /**
     * Gets the {@link Comparator} to
     * compare values of this key.
     *
     * @return The value comparator
     */
    Comparator<?> getElementComparator();

    /**
     * Gets the includes tester {@link BiPredicate}. This predicate should
     * return {@code true} when the second parameter (the key value)
     * is included in the first one (the matcher value).
     *
     * <p>The default tester will always return {@code false}.</p>
     *
     * @return The includes tester bi predicate
     * @see KeyValueMatcher.Operator#INCLUDES
     * @see KeyValueMatcher.Operator#EXCLUDES
     */
    BiPredicate<?, ?> getElementIncludesTester();

    /**
     * Register an event listener which listens to the value the key accesses
     * changing.
     *
     * @param holderFilter The data holder to filter with
     * @param listener The event listener
     * @param <E> The class type of the data holder
     */
    <E extends DataHolder> void registerEvent(PluginContainer plugin, Class<E> holderFilter, EventListener<ChangeDataHolderEvent.ValueChange> listener);

    static <E, V extends Value<E>> Key<V> of(PluginContainer plugin, String name, TypeToken<V> type) {
        return Key.builder().key(ResourceKey.of(plugin, name)).type(type).build();
    }

    interface Builder<E, V extends Value<E>> extends CatalogBuilder<Key<V>, Builder<E, V>> {

        /**
         * Starter method for the builder, to be used immediately after
         * {@link Key#builder()} is called. This defines the generics for the
         * builder itself to provide the properly generified {@link Key}.
         *
         * <p>Common {@link TypeToken TypeTokens} can be found in
         * {@link TypeTokens}. If a new TypeToken is to be created, it is
         * recommended to create an anonymous class instance of a token,
         * as described in <a hrep="https://github.com/leangen/geantyref#creating-type-literals-using-typetoken">the GeAnTyRef documentation</a>
         * </p>
         *
         * @param token The type token
         * @param <T> The element type of the Key
         * @param <B> The base value type of the key
         * @return This builder, generified
         */
        <T, B extends Value<T>> Builder<T, B> type(TypeToken<B> token);


        /**
         * Starter method for the builder, to be used immediately after
         * {@link Key#builder()} is called. This defines the generics for the
         * builder itself to provide the properly generified {@link Key}.
         *
         * <p>This overload is provided for simple cases where a plain
         * {@link Value} is used.</p>
         *
         * @param type The element type
         * @param <T> The element type of the Key
         * @return This builder, generified
         */
        <T> Builder<T, Value<T>> elementType(Class<T> type);

        /**
         * Sets the {@link Comparator} that can be used to compare
         * the elements.
         *
         * <p>Setting the comparator is a <strong>requirement</strong>
         * if the element type isn't {@link Comparable}.</p>
         *
         * @param comparator The comparator
         * @return This builder, for chaining
         */
        Builder<E, V> comparator(Comparator<? super E> comparator);

        /**
         * Sets the includes tester {@link BiPredicate}. This predicate should
         * return {@code true} when the second parameter is included in the first one.
         *
         * <p>The default tester will always return {@code false}.</p>
         *
         * @param predicate The tester bi predicate
         * @return This builder, for chaining
         * @see KeyValueMatcher.Operator#INCLUDES
         * @see KeyValueMatcher.Operator#EXCLUDES
         */
        Builder<E, V> includesTester(BiPredicate<? super E, ? super E> predicate);

        @Override
        Builder<E, V> key(ResourceKey key);

        /**
         * Builds the {@link Key}.
         *
         * @return The built key
         * @throws IllegalStateException If not all required options were specified;
         *                               {@link #key(ResourceKey)} and {@link #type(TypeToken)}.
         */
        @Override
        Key<V> build();
    }
}
