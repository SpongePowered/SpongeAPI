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

import org.checkerframework.checker.nullness.qual.Nullable;

@FunctionalInterface
public interface ElementMergeFunction<E> {

    E merge(@Nullable E original, @Nullable E replacement);

    default <V extends ValueLike<E>> E merge(@Nullable V original, @Nullable V replacement) {
        return this.merge(original != null ? original.get() : null, replacement != null ? replacement.get() : null);
    }

    default <V extends ValueLike<E>> E merge(E original, Iterable<? extends V> replacement) {
        E merged = original;
        for (V value : replacement) {
            merged = this.merge(merged, value.get());
        }
        return merged;
    }

    interface Defaulted<E> extends ElementMergeFunction<E> {

        <V extends ValueLike<E>> E merge(Iterable<? extends V> replacement);
    }
}
