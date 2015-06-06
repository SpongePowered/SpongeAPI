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
package org.spongepowered.api.data.token;


import com.google.common.base.Function;
import org.spongepowered.api.data.DataHolder;

/**
 * A helper class of various {@link Function}s that can be used with
 * {@link DataHolder#transform(Token, Function)}
 */
public class TokenFunctions {

    public static <V extends Number> Function<V, V> add(final V number) {
        return new Function<V, V>() {
            @SuppressWarnings("unchecked")
            @Override
            public V apply(V v) {
                if(v instanceof Double || v instanceof Float) {
                    return (V) Double.valueOf(v.doubleValue() + number.doubleValue());
                } else if(v instanceof Long) {
                    return (V) Long.valueOf(v.longValue() + number.longValue());
                } else {
                    return (V) Integer.valueOf(v.intValue() + number.intValue());
                }
            }
        };
    }

    public static <V extends Number> Function<V, V> sub(final V number) {
        return new Function<V, V>() {
            @SuppressWarnings("unchecked")
            @Override
            public V apply(V v) {
                if(v instanceof Double || v instanceof Float) {
                    return (V) Double.valueOf(v.doubleValue() - number.doubleValue());
                } else if(v instanceof Long) {
                    return (V) Long.valueOf(v.longValue() - number.longValue());
                } else {
                    return (V) Integer.valueOf(v.intValue() - number.intValue());
                }
            }
        };
    }

    public static <V extends Number> Function<V, V> mult(final V number) {
        return new Function<V, V>() {
            @SuppressWarnings("unchecked")
            @Override
            public V apply(V v) {
                if(v instanceof Double || v instanceof Float) {
                    return (V) Double.valueOf(v.doubleValue() * number.doubleValue());
                } else if(v instanceof Long) {
                    return (V) Long.valueOf(v.longValue() * number.longValue());
                } else {
                    return (V) Integer.valueOf(v.intValue() * number.intValue());
                }
            }
        };
    }

}
