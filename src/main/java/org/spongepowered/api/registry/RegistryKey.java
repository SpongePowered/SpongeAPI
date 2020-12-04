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

import java.util.function.Supplier;

/**
 * Similar to {@link ResourceKey} but with a defined type and id of the parent registry.
 *
 * <p>The inclusion of the type assists with compile-time type verification checks.</p>
 *
 * @param <T> The type
 */
public interface RegistryKey<T> {

    static <T> RegistryKey<T> of(final RegistryLocation registry, final ResourceKey location) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).create(registry, location);
    }

    /**
     * Gets the {@link RegistryLocation location} defining the parent registry.
     *
     * @return The location
     */
    RegistryLocation registry();

    /**
     * Gets the {@link ResourceKey key} defining the id. See the documentation on resource key for
     * more information on the composition of this key.
     *
     * @return The key
     */
    ResourceKey location();

    /**
     * Generates a utility {@link RegistryReference reference} used to assist in querying a value from this key
     *
     * @return The reference
     */
    RegistryReference<T> asReference();

    /**
     * Generates a utility {@link DefaultedRegistryReference reference} used to assist in querying a value from this key
     *
     * @return The reference
     */
    DefaultedRegistryReference<T> asDefaultedReference(Supplier<RegistryHolder> defaultHolder);

    interface Factory {

        <T> RegistryKey<T> create(RegistryLocation registry, ResourceKey location);
    }
}
