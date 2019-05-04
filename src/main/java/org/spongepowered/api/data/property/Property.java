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
package org.spongepowered.api.data.property;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Comparator;
import java.util.function.BiPredicate;

/**
 * Represents a property type that can be used to
 * retrieve immutable data from a {@link PropertyHolder}.
 */
@SuppressWarnings("unchecked")
@CatalogedBy(Properties.class)
public interface Property<V> extends CatalogType {

    /**
     * Constructs a new {@link Builder}.
     *
     * <p>Calling {@link Builder#valueType(TypeToken)} or {@link Builder#valueType(Class)} returns the
     * builder as a generified version based in the type. This should be the first step when building
     * a property.</p>
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the value {@link TypeToken}.
     *
     * @return The type token
     */
    TypeToken<V> getValueType();

    /**
     * Gets the {@link Comparator} to
     * compare values of this property.
     *
     * @return The value comparator
     */
    Comparator<V> getValueComparator();

    /**
     * Gets the includes tester {@link BiPredicate}. This predicate should
     * return {@code true} when the second parameter (the property value)
     * is included in the first one (the matcher value).
     *
     * <p>The default tester will always return {@code false}.</p>
     *
     * @return The includes tester bi predicate
     * @see PropertyMatcher.Operator#INCLUDES
     * @see PropertyMatcher.Operator#EXCLUDES
     */
    BiPredicate<V, V> getValueIncludesTester();

    /**
     * Builds a {@link PropertyMatcher} for this property
     * type and the given value type and operator.
     *
     * @param value The value type
     * @param operator The operator
     * @return The property query
     */
    default PropertyMatcher<V> buildMatcher(V value, PropertyMatcher.Operator operator) {
        return PropertyMatcher.of(this, value, operator);
    }

    /**
     * A builder to create {@link Property}s.
     *
     * @param <V> The value type
     */
    interface Builder<V> extends CatalogBuilder<Property<V>, Builder<V>> {

        /**
         * Sets the value type of the property.
         *
         * <p>Setting the value type will reset the {@link Comparator}.</p>
         *
         * @param type The value type
         * @return This builder, for chaining
         */
        default <NV> Builder<NV> valueType(Class<NV> type) {
            return valueType(TypeToken.of(type));
        }

        /**
         * Sets the value {@link TypeToken} of the property.
         *
         * <p>Setting the value type will reset the {@link Comparator}.</p>
         *
         * @param typeToken The value type token
         * @return This builder, for chaining
         */
        <NV> Builder<NV> valueType(TypeToken<NV> typeToken);

        /**
         * Sets the {@link Comparator} that will be
         * used to compare the values.
         *
         * <p>Setting the value comparator is optional if the
         * value type {@code V} is {@link Comparable}.</p>
         *
         * @param comparator The value comparator
         * @return This builder, for chaining
         * @see PropertyMatcher.Operator
         */
        Builder<V> valueComparator(Comparator<V> comparator);

        /**
         * Sets the includes tester {@link BiPredicate}. This predicate should
         * return {@code true} when the second parameter is included in the first one.
         *
         * <p>The default tester will always return {@code false}.</p>
         *
         * @param predicate The tester bi predicate
         * @return This builder, for chaining
         * @see PropertyMatcher.Operator#INCLUDES
         * @see PropertyMatcher.Operator#EXCLUDES
         */
        Builder<V> valueIncludesTester(BiPredicate<V, V> predicate);

        /**
         * Builds the {@link Property}.
         *
         * @return The built property
         * @throws IllegalStateException If not all required options were specified; {@link #key(CatalogKey)},
         *                               {@link #valueType(TypeToken)} and {@link #valueComparator(Comparator)}.
         */
        @Override
        Property<V> build();
    }
}
