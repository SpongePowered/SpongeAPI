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
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueStore;

public class MemoryValue<E, S extends ValueStore<S>> implements Value<E, S> {

    private final Key<E> key;
    private final S valueStore;

    public MemoryValue(Key<E> key, S valueStore) {

        if (!valueStore.supports(key)) {
            throw new UnsupportedOperationException("MemoryValue key must exist within the containing store");
        }

        this.key = key;
        this.valueStore = valueStore;
    }

    @Override
    public E get() {
        return valueStore.tryGet(key);
    }

    @Override
    public S set(E value) {
        return valueStore.set(key, value);
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public Optional<E> getDirect() {
        return null;
    }

    @Override
    public Value<E, S> replace(E value) {
        set(value);
        return this;
    }

    @Override
    public Key<E> getKey() {
        return key;
    }

    @Override
    public S getStore() {
        return valueStore;
    }

}
