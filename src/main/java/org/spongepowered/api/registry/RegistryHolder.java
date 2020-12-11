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

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A holder of {@link Registry registries}.
 */
public interface RegistryHolder {

    /**
     * Gets the {@link Registry} by a {@link RegistryKey key}.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if the key will exist in the holder. Should the key lack a value, a
     * {@link ValueNotFoundException}</p> will be thrown. Therefore, it is advised to call
     * {@link RegistryHolder#findRegistry(RegistryKey)} instead.</p>
     *
     * @param key The key
     * @param <T> The type
     * @return The registry
     */
    <T> Registry<T> registry(RegistryKey<T> key);

    /**
     * Gets the {@link Registry} by a {@link RegistryKey key}, if found.
     *
     * @param key The key
     * @param <T> The type
     * @return The registry or {@link Optional#empty()}
     */
    default <T> Optional<Registry<T>> findRegistry(final RegistryKey<T> key) {
        Objects.requireNonNull(key, "key");

        return this.findRegistry(key.location());
    }

    /**
     * Gets the {@link Registry} by a {@link RegistryKey key}, if found.
     *
     * @param key The key
     * @param <T> The type
     * @return The registry or {@link Optional#empty()}
     */
    <T> Optional<Registry<T>> findRegistry(ResourceKey key);

    /**
     * Gets a {@link Stream} of the {@link Registry registries} in this holder.
     *
     * @return The stream
     */
    Stream<Registry<?>> stream();
}
