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
package org.spongepowered.api.data.value.mutable;

import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

/**
 * Represents a specialized type of {@link MutableValue} that is different from
 * a {@link MutableCollectionValue} such that the "elements" are
 * {@link Entry}. Usually, this type of value is used to represent
 * a particular "type" of "key" that is associated to a particular "value".
 *
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public interface MutableMapValue<K, V> extends MapValue<K, V>, MutableValue<Map<K, V>, MutableMapValue<K, V>, ImmutableMapValue<K, V>> {


    /**
     * Associates the provided key to the provided value. If there already
     * exists a value for the provided key, the value is replaced.
     *
     * @param key The key to associate to the value
     * @param value The value associated with the key
     * @return This map value, for chaining
     */
    MutableMapValue<K, V> put(K key, V value);

    /**
     * Associates all provided {@link Entry} to this map value.
     *
     * @param map The map of key values to set
     * @return This map value, for chaining
     */
    MutableMapValue<K, V> putAll(Map<K, V> map);

    /**
     * Removes the association of the provided key to the value currently
     * associated.
     *
     * @param key The key to remove
     * @return This map value, for chaining
     */
    MutableMapValue<K, V> remove(K key);

    /**
     * Removes all key value associations of the provided keys.
     *
     * @param keys The keys to remove
     * @return This map value, for chaining
     */
    MutableMapValue<K, V> removeAll(Iterable<K> keys);

    /**
     * Applies the {@link Predicate} to all {@link Entry} within this
     * {@link MutableMapValue}. Any entries that are false will be removed from the
     * map value.
     *
     * @param predicate The predicate to filer
     * @return This map value, for chaining
     */
    MutableMapValue<K, V> removeAll(Predicate<Entry<K, V>> predicate);

    @Override
    default MutableMapValue<K, V> asMutable() {
        return this;
    }

    @Override
    ImmutableMapValue<K, V> asImmutable();
}
