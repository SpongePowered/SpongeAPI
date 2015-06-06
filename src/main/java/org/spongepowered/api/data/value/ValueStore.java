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
import org.spongepowered.api.data.merge.MergeStrategy;

import javax.annotation.Nullable;
import java.util.Set;

public interface ValueStore<S extends ValueStore<S>> {

    <E> Optional<E> get(Key<? extends Value<E, ?>> key);

    <E> E tryGet(Key<? extends Value<E, ?>> key) throws UnsupportedOperationException;

    @Nullable
    <E> E getOrNull(Key<? extends Value<E, ?>> key);

    <E> E getOrElse(Key<? extends Value<E, ?>> key, E defaultValue);

    <E> S set(Key<? extends Value<E, ?>> key, E value);

    <E, V extends Value<E, ?>> Optional<V> bind(Key<V> key);

    <E, V extends Value<E, ?>> V tryBind(Key<V> key);

    boolean supports(Key<?> key);

    boolean canMutate();

    S copy();

    S copyTo(ValueStore<?> that);

    S copyTo(ValueStore<?> that, MergeStrategy strategy);

    S copyFrom(ValueStore<?> that);

    S copyFrom(ValueStore<?> that, MergeStrategy strategy);

    <T extends ValueStore<T>> Optional<T> copyOf();

    Set<Key<?>> getKeys();

    Set<Value<?, S>> getValues();

}
