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
package org.spongepowered.api.data.value.immutable;

import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.mutable.MutableMapValue;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

/**
 * Represents a specialized type of {@link ImmutableValue} that is different
 * from an {@link ImmutableCollectionValue} such that the "elements" are
 * {@link Entry}. Usually, this type of value is used to represent
 * a particular "type" of "key" that is associated to a particular "value".
 *
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public interface ImmutableMapValue<K, V> extends MapValue<K, V>, ImmutableValue<Map<K, V>, ImmutableMapValue<K, V>, MutableMapValue<K, V>> {


    /**
     * Associates the provided key to the provided value in the new map. If
     * there already exists a value for the provided key, the value is
     * replaced.
     *
     * @param key The key to associate to the value
     * @param value The value associated with the key
     * @return The new value, for chaining
     */
    ImmutableMapValue<K, V> with(K key, V value);

    @Override
    ImmutableMapValue<K, V> with(Map<K, V> value);

    /**
     * Associates all provided {@link Entry} along with all pre-existing
     * map entries in a new {@link ImmutableMapValue}.
     *
     * @param map The map of key values to set
     * @return The new value, for chaining
     */
    ImmutableMapValue<K, V> withAll(Map<K, V> map);

    /**
     * Creates a new {@link ImmutableMapValue} without the provided key and the
     * associated value.
     *
     * @param key The key to exclude the association
     * @return The new value, for chaining
     */
    ImmutableMapValue<K, V> without(K key);

    /**
     * Creates a new {@link ImmutableMapValue} without the provided keys and
     * their associated values.
     *
     * @param keys The keys to exclude
     * @return The new value, for chaining
     */
    ImmutableMapValue<K, V> withoutAll(Iterable<K> keys);

    /**
     * Creates a new {@link ImmutableMapValue} such that all entries are
     * filtered by the provided {@link Predicate}, any that return
     * {@code true} are retained in the new value. Elements that return
     * <code>true</code> from {@link Predicate#test(Object)} are kept, and
     * those that return <code>false</code> are excluded.
     *
     * @param predicate The predicate to filter
     * @return The new value, for chaining
     */
    ImmutableMapValue<K, V> withoutAll(Predicate<Entry<K, V>> predicate);

    @Override
    MutableMapValue<K, V> asMutable();

    @Override
    default ImmutableMapValue<K, V> asImmutable() {
        return this;
    }
}
