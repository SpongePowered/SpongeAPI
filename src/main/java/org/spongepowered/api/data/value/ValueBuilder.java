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

import com.google.common.base.Optional;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

public interface ValueBuilder {

    /**
     * Creates a new {@link Value} with the provided {@link Key} and the
     * <code>E</code> element.
     *
     * @param key The key for the value
     * @param element The element
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> Value<E> createValue(Key<Value<E>> key, E element);

    /**
     * Creates a new {@link Value} with the provided {@link Key} and the
     * <code>E</code> element and the provided <code>E</code> default value.
     *
     * @param key The key for the value
     * @param element The element
     * @param defaultValue The default value
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> Value<E> createValue(Key<Value<E>> key, E element, E defaultValue);

    /**
     * Creates a new {@link ListValue} with the provided {@link Key} and
     * {@link List} of elements.
     *
     * @param key The key for the value
     * @param elements The list of elements
     * @param <E> The type of element
     * @return The list value
     */
    <E> ListValue<E> createListValue(Key<ListValue<E>> key, List<E> elements);

    /**
     * Creates a new {@link ListValue} with the provided {@link Key} and
     * {@link List} of elements.
     *
     * @param key The key for the value
     * @param elements The list of elements
     * @param defaults The default list
     * @param <E> The type of element
     * @return The list value
     */
    <E> ListValue<E> createListValue(Key<ListValue<E>> key, List<E> elements, List<E> defaults);

    /**
     * Creates a new {@link SetValue} with the provided {@link Key} and
     * {@link Set} of elements.
     *
     * @param key The key for the value
     * @param elements The set of elements
     * @param <E> The type of element
     * @return The set value
     */
    <E> SetValue<E> createSetValue(Key<SetValue<E>> key, Set<E> elements);

    /**
     * Creates a new {@link SetValue} with the provided {@link Key} and
     * {@link Set} of elements.
     *
     * @param key The key for the value
     * @param elements The set of elements
     * @param defaults The default set
     * @param <E> The type of element
     * @return The set value
     */
    <E> SetValue<E> createSetValue(Key<SetValue<E>> key, Set<E> elements, Set<E> defaults);

    /**
     * Creates a new {@link MapValue} of the provided {@link Key} with the
     * types <code>K</code> and <code>V</code>.
     *
     * @param key The key for the value
     * @param map The map of elements
     * @param <K> The type of key
     * @param <V> The type of value
     * @return The map value
     */
    <K, V> MapValue<K, V> createMapValue(Key<MapValue<K, V>> key, Map<K, V> map);

    /**
     * Creates a new {@link MapValue} of the provided {@link Key} with the
     * types <code>K</code> and <code>V</code> along with the provided
     * {@link Map} defaults.
     *
     * @param key The key for the value
     * @param map The map of elements
     * @param defaults The default map
     * @param <K> The type of key
     * @param <V> The type of value
     * @return The map value
     */
    <K, V> MapValue<K, V> createMapValue(Key<MapValue<K, V>> key, Map<K, V> map, Map<K, V> defaults);

    /**
     * Creates a {@link MutableBoundedValue} for the provided {@link Key} with the provided
     * {@link Comparator} and <code>E</code> minimum and maximum values.
     *
     * @param key The key to the value
     * @param value The actual value
     * @param comparator The comparator
     * @param minimum The minimum limit
     * @param maximum The maximum limit
     * @param <E> The type of value
     * @return The newly created value
     */
    <E> MutableBoundedValue<E> createBoundedValue(Key<MutableBoundedValue<E>> key, E value, Comparator<E> comparator, E minimum, E maximum);

    /**
     * Creates a {@link MutableBoundedValue} for the provided {@link Key} with the provided
     * {@link Comparator} and <code>E</code> minimum and maximum values.
     *
     * @param key The key to the value
     * @param value The actual value
     * @param comparator The comparator
     * @param minimum The minimum limit
     * @param maximum The maximum limit
     * @param defaultElement The default value
     * @param <E> The type of value
     * @return The newly created value
     */
    <E> MutableBoundedValue<E> createBoundedValue(Key<MutableBoundedValue<E>> key, E value, Comparator<E> comparator, E minimum, E maximum, E defaultElement);

    /**
     * Creates an {@link OptionalValue} where even the default value may be
     * {@link Optional#absent()}. These types of values should be restricted
     * to values that are live, that can be potentially large to retain a
     * reference to, and otherwise, not thread safe.
     *
     * @param key The key to the value
     * @param element The element, if available
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> OptionalValue<E> createOptionalValue(Key<OptionalValue<E>> key, @Nullable E element);

    /**
     * Creates an {@link OptionalValue} where the default is NOT
     * <code>null</code>, such that the actual value may be retained as
     * <code>null</code>.
     *
     * @param key The key of the value
     * @param element The element
     * @param defaultElement The default value
     * @param <E> The type of element
     * @return The newly created value
     */
    <E> OptionalValue<E> createOptionalValue(Key<OptionalValue<E>> key, @Nullable E element, E defaultElement);

}
