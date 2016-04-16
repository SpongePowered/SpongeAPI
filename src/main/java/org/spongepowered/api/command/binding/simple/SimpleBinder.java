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

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import org.spongepowered.api.command.binding.Binder;
import org.spongepowered.api.command.binding.Binding;
import org.spongepowered.api.command.binding.BindingBuilder;
import org.spongepowered.api.command.binding.BindingKey;
import org.spongepowered.api.command.provider.Provider;

import java.lang.reflect.Type;
import java.util.Optional;

/**
 * A simple implementation of {@link Binder}.
 */
public final class SimpleBinder implements Binder {

    private final Multimap<Type, Binding<?>> bindings = Multimaps.newMultimap(Maps.newHashMap(), Sets::newTreeSet);

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<Binding<T>> getBinding(BindingKey<T> key) {
        for (Binding<?> binding : this.bindings.get(key.getType())) {
            if (binding.getKey().test(key)) {
                return Optional.of((Binding<T>) binding);
            }
        }

        return Optional.empty();
    }

    /**
     * Add a provider binding.
     *
     * @param key The binding key
     * @param provider The provider
     * @param <T> The bound type
     */
    <T> void addBinding(BindingKey<T> key, Provider<T> provider) {
        this.bindings.put(key.getType(), new SimpleBinding<>(key, provider));
    }

    @Override
    public <T> Optional<Provider<T>> getProvider(BindingKey<T> key) {
        return this.getBinding(key).map(Binding::getProvider);
    }

    @Override
    public <T> BindingBuilder<T> bind(BindingKey<T> key) {
        return new SimpleBindingBuilder<>(this, key);
    }

}
