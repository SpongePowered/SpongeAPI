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
package org.spongepowered.api.util;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class CollectionUtils {

    /**
     * Attempts to use native {@link Object#clone()} methods on available map
     * types. If a map cannot be properly cloned, a new {@link HashMap} is
     * returned.
     *
     * @param map The map input
     * @param <K> The key type
     * @param <V> The value type
     * @return A copied map
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> copyMap(Map<? extends K, ? extends V> map) {
        try {
            if (map instanceof HashMap) {
                return (Map<K, V>) ((HashMap<? extends K, ? extends V>) map).clone();
            } else if (map instanceof IdentityHashMap) {
                return (Map<K, V>) ((IdentityHashMap<?, ?>) map).clone();
            } else if (map instanceof EnumMap) {
                return (Map<K, V>) ((EnumMap<?, V>) map).clone();
            } else if (map instanceof TreeMap) {
                return (Map<K, V>) ((TreeMap<K, V>) map).clone();
            } else if (map instanceof ConcurrentHashMap) {
                return (Map<K, V>) new ConcurrentHashMap<>(map);
            }
        } catch (Exception ignored) {
        }
        return new HashMap<>(map);
    }

    /**
     * Attempts to use native {@link Object#clone()} methods on available map
     * types. If a list cannot be properly cloned, a new {@link ArrayList} is
     * returned.
     *
     * @param list The list input
     * @param <T> The value type
     * @return A copied list
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> copyList(List<? extends T> list) {
        try {
            if (list instanceof ArrayList) {
                return (List<T>) ((ArrayList<? extends T>) list).clone();
            } else if (list instanceof LinkedList) {
                return (List<T>) ((LinkedList<? extends T>) list).clone();
            } else if (list instanceof CopyOnWriteArrayList) {
                return (List<T>) ((CopyOnWriteArrayList<T>) list).clone();
            }
        } catch (Exception ignored) {
        }
        return new ArrayList<>(list);
    }

    // Suppress default constructor to ensure non-instantiability.
    private CollectionUtils() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
