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

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A store of {@link RegistryEntry registry entries} with a well defined type.
 *
 * @param <T> The type
 */
@DoNotStore
public interface Registry<T> {

    /**
     * Gets the {@link ResourceKey key} identifying this registry.
     *
     * @return The key
     */
    RegistryType<T> type();

    /**
     * Gets the {@link ResourceKey key} for a particular value.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if the key will exist. Should the value lack a key, a
     * {@link IllegalStateException} will be thrown. Therefore, it is advised to call
     * {@link Registry#findValueKey(Object)} instead.</p>
     *
     * @param value The value
     * @return The key
     */
    ResourceKey valueKey(T value);

    /**
     * Gets the {@link ResourceKey key} for a particular value, if found.
     *
     * <p>The value must be registered within to be retrieved by key.</p>
     *
     * @param value The value
     * @return The key or {@link Optional#empty()}
     */
    Optional<ResourceKey> findValueKey(T value);

    /**
     * Gets the {@link RegistryEntry entry} for a particular {@link ResourceKey key}, if found.
     *
     * <p>The value must be registered within to be retrieved by key.</p>
     *
     * @param key The key
     * @return The entry or {@link Optional#empty()}
     */
    <V extends T> Optional<RegistryEntry<V>> findEntry(ResourceKey key);

    /**
     * {@link Registry#findEntry(ResourceKey)}, provided for convenience when using {@link RegistryKey}.
     *
     * @param key The key
     * @return The entry or {@link Optional#empty()}
     */
    default <V extends T> Optional<RegistryEntry<V>> findEntry(final RegistryKey<T> key) {
        return this.findEntry(Objects.requireNonNull(key, "key").location());
    }

    /**
     * Gets the {@link T value} for a particular {@link ResourceKey key}, if found.
     *
     * @param key The key
     * @return The value or {@link Optional#empty()}
     */
    <V extends T> Optional<V> findValue(ResourceKey key);

    /**
     * {@link Registry#findValue(ResourceKey)}, provided for convenience when using {@link RegistryKey}.
     *
     * @param key The key
     * @return The value or {@link Optional#empty()}
     */
    default <V extends T> Optional<V> findValue(final RegistryKey<T> key) {
        return this.findValue(Objects.requireNonNull(key, "key").location());
    }

    /**
     * Gets the {@link T value} for a particular {@link ResourceKey key}.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if the key will exist. Should this key lack a value, a
     * {@link ValueNotFoundException} will be thrown. Therefore, it is advised to call
     * {@link Registry#findValue(ResourceKey)} or {@link Registry#findValue(RegistryKey)} instead.</p>
     *
     * @param key The key
     * @return The value
     */
    <V extends T> V value(ResourceKey key);

    /**
     * {@link Registry#value(ResourceKey)}, provided for convenience when using {@link RegistryKey}.
     *
     * @param key The key
     * @return The value
     */
    default <V extends T> V value(final RegistryKey<T> key) {
        return this.value(Objects.requireNonNull(key, "key").location());
    }

    /**
     * Gets a {@link Stream} of all {@link RegistryEntry entries} within.
     *
     * @return The stream
     */
    Stream<RegistryEntry<T>> streamEntries();

    /**
     * Gets a {@link Stream} of all registry values within.
     *
     * @return The stream
     */
    Stream<T> stream();

    /**
     * Returns if this registry supports adding additional values.
     *
     * @return True if the registry can add additional values
     */
    boolean isDynamic();

    /**
     * Registers a new value to this registry.
     *
     * <p>If this registry is not {@link Registry#isDynamic() dynamic} or the provided key is already registered,
     * {@link Optional#empty()} is returned instead.</p>
     *
     * @param key The key
     * @param value The value
     * @return The newly added entry, {@link Optional#empty()} otherwise
     */
    <V extends T> Optional<RegistryEntry<V>> register(ResourceKey key, V value);
}
