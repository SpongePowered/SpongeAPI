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

import org.spongepowered.api.Sponge;

import java.util.Objects;
import java.util.Optional;

/**
 * A utility {@link RegistryKey key} with handy methods to make retrieval of values
 * from a {@link RegistryHolder holder} easier.
 *
 * @param <T> The type
 */
public interface RegistryReference<T> extends RegistryKey<T> {

    static <T> RegistryReference<T> referenced(final RegistryHolder holder, final RegistryType<T> registry, final T value) {
        return Sponge.game().factoryProvider().provide(Factory.class).referenced(Objects.requireNonNull(holder, "holder"),
                Objects.requireNonNull(registry, "registry"), Objects.requireNonNull(value, "value"));
    }

    /**
     * Gets the value from the {@link RegistryHolder holders}.
     *
     * <p>Behavior wise, the first holder that has a type of {@link Registry registry} within
     * will be queried for this reference. If the registry is present, no additional holders will be
     * queried.</p>
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if this reference will exist in the holders. Should this reference lack a value, a
     * {@link ValueNotFoundException}</p> will be thrown. Therefore, it is advised
     * to call {@link RegistryReference#find(RegistryHolder...)} instead.
     *
     * @param holders The holders to look against
     * @return The value
     */
    T get(RegistryHolder... holders);

    /**
     * Gets the value from the {@link RegistryHolder holders}.
     *
     * <p>Behavior wise, the first holder that has a type of {@link Registry registry} within
     * will be queried for this reference. If the registry is present, no additional holders will be
     * queried.</p>
     *
     * @param holders The holders to look against
     * @return The value
     */
    Optional<T> find(final RegistryHolder... holders);

    interface Factory {

        <T> RegistryReference<T> referenced(RegistryHolder holder, RegistryType<T> registry, T value);
    }
}