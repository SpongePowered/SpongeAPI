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
import org.spongepowered.api.data.value.CompositeValueStore;
import org.spongepowered.api.data.value.ValueStore;

public class MemoryCompositeValueStore<S extends CompositeValueStore<S>> extends MemoryValueStore<S> implements CompositeValueStore<S> {

    @Override
    public <T extends ValueStore<T>> Optional<T> get(Class<T> storeClass) {
        return null;
    }

    @Override
    public <T extends ValueStore<T>> T tryGet(Class<T> storeClass) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public <T extends ValueStore<T>> T getOrElse(Class<T> storeClass, T defaultStore) {
        return null;
    }

    @Override
    public boolean supports(Class<? extends ValueStore<?>> storeClass) {
        return false;
    }
}
