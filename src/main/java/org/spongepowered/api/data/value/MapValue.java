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

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.mutable.MutableMapValue;

import java.util.Map;

public interface MapValue<K, V> extends Value<Map<K, V>> {


    /**
     * Gets the size of this map.
     *
     * @return The size of this map
     */
    int size();

    /**
     * Checks if the provided key is contained within this map.
     *
     * @param key The key to check
     * @return True if the key is contained
     */
    boolean containsKey(K key);

    /**
     * Checks if the provided value is contained within this map.
     *
     * @param value The value to check
     * @return True if the value is contained
     */
    boolean containsValue(V value);

    /**
     * Gets an {@link ImmutableSet} of all keys contained in this map value.
     *
     * @return The set of keys
     */
    ImmutableSet<K> keySet();

    /**
     * Retrieves an {@link ImmutableSet} of the {@link Map.Entry}s contained
     * within this map value.
     *
     * @return The immutable set of entries
     */
    ImmutableSet<Map.Entry<K, V>> entrySet();

    /**
     * Retrieves an {@link ImmutableCollection} of all available values within
     * this map.
     *
     * @return The collection of values
     */
    ImmutableCollection<V> values();

    @Override
    MutableMapValue<K, V> asMutable();

    @Override
    ImmutableMapValue<K, V> asImmutable();

}
