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

import java.util.Optional;

/**
 * A {@link RegistryValue} that usually resides in a single {@link RegistryType}
 * and therefore this registry can be considered as "default".
 */
public interface DefaultedRegistryValue<T extends DefaultedRegistryValue<T>> extends RegistryValue<T> {

    /**
     * Gets the default {@link RegistryType} for
     * the type that implements this interface.
     *
     * @return The {@link RegistryType}
     */
    DefaultedRegistryType<T> registryType();

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}
     */
    default ResourceKey registryKey() {
        return this.key(this.registryType());
    }

    /**
     * Returns the {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}, if found.
     *
     * @return The {@link ResourceKey} associated with
     * this object in the default {@link #registryType()}, if found
     */
    default Optional<ResourceKey> findRegistryKey() {
        return this.findKey(this.registryType());
    }

    /**
     * Returns the {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}.
     *
     * @return The {@link DefaultedRegistryReference} for
     * this object in the default {@link #registryType()}
     */
    default DefaultedRegistryReference<T> asDefaultedReference() {
        return this.asDefaultedReference(this.registryType());
    }
}
