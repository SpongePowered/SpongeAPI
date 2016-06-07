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

import com.google.common.collect.Maps;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

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
            }
            return Maps.newHashMap(map);
        } catch (Exception e) {
            return Maps.newHashMap(map);
        }
    }



    private CollectionUtils() {
    }

}
