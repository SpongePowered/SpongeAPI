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
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.tag.Taggable;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A Utility marker that assists in getting a {@link ResourceKey} for values
 * that generally can be within a single {@link DefaultedRegistryType defaulted registry}
 * and therefore this registry can be considered as "default".
 */
@SuppressWarnings("unchecked")
public interface DefaultedRegistryValue<T extends DefaultedRegistryValue<T>> extends Taggable<T> {

    /**
     * Gets the default {@link RegistryType} for
     * the type that implements this interface.
     *
     * @return The {@link RegistryType}
     */
    DefaultedRegistryType<T> registryType();

    /**
     * Gets all {@link Tag}s that have been associated
     * with this object in the default {@link #registryType()}.
     *
     * @return THe {@link Stream} of {@link Tag}s
     */
    @Override
    default Stream<Tag<T>> tags() {
        return this.registryType().get().tags().filter(this::is);
    }

    /**
     * Gets all {@link Tag}s that have been associated
     * with this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}.
     *
     * @return THe {@link Stream} of {@link Tag}s
     */
    default Stream<Tag<T>> tags(final RegistryHolder holder) {
        return Objects.requireNonNull(holder, "holder").registry(this.registryType()).tags().filter(tag -> this.is(holder, tag));
    }

    /**
     * Returns whether the given {@link Tag} is associated with
     * this object in the default {@link #registryType()}.
     *
     * @param tag The tag
     * @return true if the given {@link Tag} is associated with
     * this object in the default {@link #registryType()}
     */
    @Override
    default boolean is(final Tag<T> tag) {
        return this.registryType().get().taggedValues(tag).contains((T) this);
    }

    /**
     * Returns whether the given {@link Tag} is associated with
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}.
     *
     * @param tag The tag
     * @return true if the given {@link Tag} is associated with
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}
     */
    default boolean is(final RegistryHolder holder, final Tag<T> tag) {
        return Objects.requireNonNull(holder, "holder").registry(this.registryType()).taggedValues(tag).contains((T) this);
    }

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}
     */
    default ResourceKey registryKey() {
        return this.registryType().get().valueKey((T) this);
    }

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}
     */
    default ResourceKey registryKey(final RegistryHolder holder) {
        return Objects.requireNonNull(holder, "holder").registry(this.registryType()).valueKey((T) this);
    }

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}, if found.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}, if found
     */
    default Optional<ResourceKey> findRegistryKey() {
        return this.registryType().find().flatMap(r -> r.findValueKey((T) this));
    }

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}.
     * for the given {@link RegistryHolder}, if found.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}, if found
     */
    default Optional<ResourceKey> findRegistryKey(final RegistryHolder holder) {
        return Objects.requireNonNull(holder, "holder").findRegistry(this.registryType()).flatMap(r -> r.findValueKey((T) this));
    }

    /**
     * Returns the {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}.
     *
     * @return The {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}
     */
    default DefaultedRegistryReference<T> asDefaultedReference() {
        return RegistryKey.of(this.registryType(), this.registryKey()).asDefaultedReference(this.registryType().defaultHolder());
    }

    /**
     * Returns the {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}.
     *
     * @return The {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}
     * for the given {@link RegistryHolder}
     */
    default DefaultedRegistryReference<T> asDefaultedReference(final RegistryHolder holder) {
        return RegistryKey.of(this.registryType(), this.registryKey(holder)).asDefaultedReference(() -> holder);
    }
}
