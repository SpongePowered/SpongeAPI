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
package org.spongepowered.api.data.value.memory;

import com.google.common.base.Optional;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeStrategy;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueStore;

import javax.annotation.Nullable;
import java.util.*;

public class MemoryValueStore<S extends ValueStore<S>> implements ValueStore<S> {


    @Override
    public <E> Optional<E> get(Key<E> key) {
        return null;
    }

    @Override
    public <E> E tryGet(Key<E> key) throws UnsupportedOperationException {
        return null;
    }

    @Nullable
    @Override
    public <E> E getOrNull(Key<E> key) {
        return null;
    }

    @Override
    public <E> E getOrElse(Key<E> key, E defaultValue) {
        return null;
    }

    @Override
    public <E> S set(Key<E> key, E value) {
        return null;
    }

    @Override
    public <E> Optional<Value<E, S>> bind(Key<E> key) {
        return null;
    }

    @Override
    public <E> Value<E, S> tryBind(Key<E> key) {
        return null;
    }

    @Override
    public boolean supports(Key<?> key) {
        return false;
    }

    @Override
    public boolean canMutate() {
        return false;
    }

    @Override
    public S copy() {
        return null;
    }

    @Override
    public S copyTo(ValueStore<?> that) {
        return null;
    }

    @Override
    public S copyFrom(ValueStore<?> that) {
        return null;
    }

    @Override
    public S copyTo(ValueStore<?> that, MergeStrategy strategy) {
        return null;
    }

    @Override
    public S copyFrom(ValueStore<?> that, MergeStrategy strategy) {
        return null;
    }

    @Override
    public <T extends ValueStore<T>> Optional<T> copyOf() {
        return null;
    }

    @Override
    public Set<Key<?>> getKeys() {
        return null;
    }

    @Override
    public Set<Value<?, S>> getValues() {
        return null;
    }
}
