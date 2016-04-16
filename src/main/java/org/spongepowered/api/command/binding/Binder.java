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
package org.spongepowered.api.command.binding;

import org.spongepowered.api.command.provider.Provider;

import java.util.Optional;

/**
 * A {@link Binding} manager.
 */
public interface Binder {

    /**
     * Gets the binding for the given binding key.
     *
     * @param key The binding key
     * @param <T> The bound type
     * @return The binding, or {@link Optional#empty()} if one was not found
     */
    <T> Optional<Binding<T>> getBinding(BindingKey<T> key);

    /**
     * Gets the binding for the given class.
     *
     * @param clazz The class
     * @param <T> The bound type
     * @return The binding, or {@link Optional#empty()} if one was not found
     */
    default <T> Optional<Binding<T>> getBinding(Class<T> clazz) {
        return this.getBinding(BindingKey.of(clazz));
    }

    /**
     * Gets the provider for the given binding key.
     *
     * @param key The binding key
     * @param <T> The provided type
     * @return The provider, or {@link Optional#empty()} if one was not found
     */
    <T> Optional<Provider<T>> getProvider(BindingKey<T> key);

    /**
     * Gets the provider for the given binding key.
     *
     * @param clazz The class
     * @param <T> The provided type
     * @return The provider, or {@link Optional#empty()} if one was not found
     */
    default <T> Optional<Provider<T>> getProvider(Class<T> clazz) {
        return this.getProvider(BindingKey.of(clazz));
    }

    /**
     * Create a binding builder from a class type.
     *
     * @param clazz The class
     * @param <T> The bound type
     * @return A binding builder
     */
    default <T> BindingBuilder<T> bind(Class<T> clazz) {
        return this.bind(BindingKey.of(clazz));
    }

    /**
     * Create a binding builder from a binding key.
     *
     * @param key The binding key
     * @param <T> The bound type
     * @return A binding builder
     */
    <T> BindingBuilder<T> bind(BindingKey<T> key);

}
