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
package org.spongepowered.api.registry;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public interface RegistryRegistrationSet<T> {

    RegistryType<T> registryType();

    Map<ResourceKey, Function<RegistryHolder, T>> values();

    static <T> Builder<T> builder(RegistryType<T> registryType, Supplier<RegistryHolder> defaultHolder) {
        return Sponge.game().factoryProvider().provide(Factory.class).builder(registryType, defaultHolder);
    }

    interface Builder<T> extends org.spongepowered.api.util.Builder<RegistryRegistrationSet<T>, Builder<T>> {

        default <V extends T> DefaultedRegistryReference<V> register(ResourceKey key, Supplier<V> value) {
            return this.register(key, (h) -> value.get());
        }

        <V extends T> DefaultedRegistryReference<V> register(ResourceKey key, Function<RegistryHolder, V> value);
    }

    interface Factory {

        <T> Builder<T> builder(RegistryType<T> registryType, Supplier<RegistryHolder> defaultHolder);
    }
}
