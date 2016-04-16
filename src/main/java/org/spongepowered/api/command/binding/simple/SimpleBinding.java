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
package org.spongepowered.api.command.binding.simple;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.command.binding.Binding;
import org.spongepowered.api.command.binding.BindingKey;
import org.spongepowered.api.command.provider.Provider;

/**
 * A simple implementation of {@link Binding}.
 *
 * @param <T> The bound type
 */
final class SimpleBinding<T> implements Binding<T> {

    private final BindingKey<T> key;
    private final Provider<T> provider;

    /**
     * Constructs a new simple binding.
     *
     * @param key The binding key
     * @param provider The provider
     */
    SimpleBinding(BindingKey<T> key, Provider<T> provider) {
        this.key = checkNotNull(key, "key");
        this.provider = checkNotNull(provider, "provider");
    }

    @Override
    public BindingKey<T> getKey() {
        return this.key;
    }

    @Override
    public Provider<T> getProvider() {
        return this.provider;
    }

    @Override
    public int compareTo(Binding<?> that) {
        return this.getKey().compareTo(that.getKey());
    }

}
