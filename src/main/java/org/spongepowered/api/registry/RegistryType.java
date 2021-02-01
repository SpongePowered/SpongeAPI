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

import java.util.Objects;
import java.util.function.Supplier;

public interface RegistryType<T> {

    static <T> RegistryType<T> of(final ResourceKey root, final ResourceKey location) {
        return Sponge.game().getFactoryProvider().provide(Factory.class).create(Objects.requireNonNull(root, "root"),
                Objects.requireNonNull(location, "location"));
    }

    ResourceKey root();

    ResourceKey location();

    default ResourceKey keyFor(final RegistryHolder holder, final T value) {
        return Objects.requireNonNull(holder, "RegistryHolder cannot be null!").registry(this).valueKey(Objects.requireNonNull(value, "Value cannot be null!"));
    }

    default RegistryReference<T> referenced(final ResourceKey key) {
        return RegistryKey.of(this, Objects.requireNonNull(key, "key")).asReference();
    }

    /**
     * Gets a utility {@link DefaultedRegistryType defaulted type} for easier querying of the intention of where the registry is contained.
     *
     * @param defaultHolder The default holder
     * @param <V> The type
     * @return The defaulted type
     */
    <V extends T> DefaultedRegistryType<V> asDefaultedType(Supplier<RegistryHolder> defaultHolder);

    interface Factory {

        <T> RegistryType<T> create(final ResourceKey root, ResourceKey location);
    }
}
