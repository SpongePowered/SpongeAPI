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
package org.spongepowered.api.data.value;

import org.spongepowered.api.data.key.Key;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

public interface ValueFactory {

    /**
     * Creates a new {@link Value.Mutable} with the provided {@link Key} and the
     * <code>E</code> element and the provided <code>E</code> default value.
     *
     * @param key The key for the value
     * @param element The element
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> Value.Mutable<E> createValue(Key<? extends Value<E>> key, E element);

    /**
     * Creates a new {@link ListValue.Mutable} with the provided {@link Key} and
     * {@link List} of elements. The default value will be an empty list.
     *
     * @param key The key for the value
     * @param elements The list of elements
     * @param <E> The type of element
     * @return The list value
     */
    <E> ListValue.Mutable<E> createListValue(Key<? extends Value<List<E>>> key, List<E> elements);

    /**
     * Creates a new {@link SetValue.Mutable} with the provided {@link Key} and
     * {@link Set} of elements.
     *
     * @param key The key for the value
     * @param elements The set of elements
     * @param <E> The type of element
     * @return The set value
     */
    <E> SetValue.Mutable<E> createSetValue(Key<? extends Value<Set<E>>> key, Set<E> elements);

    /**
     * Creates a new {@link MapValue.Mutable} of the provided {@link Key} with the
     * types <code>K</code> and <code>V</code>.
     *
     * @param key The key for the value
     * @param map The map of elements
     * @param <K> The type of key
     * @param <V> The type of value
     * @return The map value
     */
    <K, V> MapValue.Mutable<K, V> createMapValue(Key<? extends Value<Map<K, V>>> key, Map<K, V> map);

    /**
     * Creates a {@link BoundedValueBuilder}.
     *
     * @param key The key to the value
     * @param <E> The type of value
     * @return The newly created value
     */
    <E> BoundedValueBuilder<E> createBoundedValueBuilder(Key<? extends BoundedValue<E>> key);

    /**
     * Creates an {@link OptionalValue.Mutable} where even the default value may be
     * {@link Optional#empty()}. These types of values should be restricted
     * to values that are live, that can be potentially large to retain a
     * reference to, and otherwise, not thread safe.
     *
     * @param key The key to the value
     * @param element The element, if available
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> OptionalValue.Mutable<E> createOptionalValue(Key<? extends OptionalValue<E>> key, @Nullable E element);

    /**
     * A builder pattern for constructing {@link BoundedValue.Mutable}s without the hassle of
     * keeping track of the order of arguments.
     *
     * @param <E> The type of element
     */
    interface BoundedValueBuilder<E> {

        /**
         * If <code>E</code> is not {@link Comparable}, a {@link Comparator}
         * is required. The builder by default will attempt to check if
         * the type is a {@link Comparable} and delegate to the default
         * {@link Comparable#compareTo(Object)} for comparisons. In short, the
         * {@link Comparator} is only required if the element is not
         * {@link Comparable}, or custom comparisons are required.
         *
         * @param comparator The comparator to use
         * @return This builder, for chaining
         */
        BoundedValueBuilder<E> comparator(Comparator<E> comparator);

        /**
         * Sets the minimum supported value.
         *
         * @param min The minimum supported value
         * @return This builder, for chaining
         */
        BoundedValueBuilder<E> minimum(E min);

        /**
         * Sets the maximum supported value.
         *
         * @param max The maximum supported value
         * @return This builder, for chaining
         */
        BoundedValueBuilder<E> maximum(E max);

        /**
         * Sets the actual value.
         *
         * @param actual The actual value
         * @return This builder, for chaining
         */
        BoundedValueBuilder<E> value(E actual);

        /**
         * Builds a new {@link BoundedValue.Mutable}. The requirements are
         * that the {@link #minimum(Object)}, {@link #maximum(Object)},
         * {@link #value(Object)} are set, and if the <code>E</code> is
         * not {@link Comparable}, {@link #comparator(Comparator)} is set.
         *
         * @return The newly constructed value
         */
        BoundedValue.Mutable<E> build();
    }
}
