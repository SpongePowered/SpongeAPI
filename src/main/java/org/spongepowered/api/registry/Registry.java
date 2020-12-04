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
import org.spongepowered.api.util.annotation.DoNotStore;

import java.util.Optional;
import java.util.stream.Stream;

@DoNotStore
public interface Registry<V> extends Iterable<RegistryEntry<V>> {

    RegistryHolder holder();

    ResourceKey key();

    Optional<ResourceKey> findKey(V value);

    Optional<RegistryEntry<V>> findEntry(ResourceKey key);

    Optional<V> findValue(ResourceKey key);

    V value(ResourceKey key);

    Stream<RegistryEntry<V>> stream();

    /**
     * Returns if this registry supports adding additional values.
     *
     * @return True if the registry can add additional values
     */
    boolean isDynamic();

    /**
     * Registers a new value to this registry.
     *
     * <p>It is recommended to check if {@link Registry#isDynamic()} returns {@code TRUE}
     * before registering the new value. If it is not dynamic, this will throw an
     * {@link IllegalStateException}.</p>
     *
     * <p>If the key already exists in the registry, a {@link DuplicateRegistrationException}
     * will be thrown.</p>
     *
     * @param key The key to register under
     * @param value The value to register
     * @return The added {@link RegistryEntry}
     */
    RegistryEntry<V> register(ResourceKey key, V value);
}
