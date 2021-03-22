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
import java.util.Set;

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
     * Gets the value from the {@link RegistryHolder holder}.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if this reference will exist in the holder. Should this reference lack a value, a
     * {@link ValueNotFoundException}</p> will be thrown. Therefore, it is advised to call
     * {@link RegistryReference#find(RegistryHolder)} instead.
     *
     * <p>The contract leaves a large amount of flexibility in how this value is retrieved
     * from the holder. As there are no defined rules, an implementation may choose to only
     * query the passed in holder or may choose to run through various {@link RegistryScope scopes}
     * for retrieval. As such, no assumption should be made whatsoever that the returned value
     * originated from the holder. If this is important to the consumer, consider using
     * {@link RegistryReference#get(RegistryHolder, Set)} with well defined holders instead.</p>
     *
     * @param holder The holder
     * @return The value
     */
    T get(RegistryHolder holder);

    /**
     * Gets the value from the {@link RegistryHolder holder} or alternatives on a first come basis.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if this reference will exist in the holder or the alternatives. Should this reference
     * lack a value, a {@link ValueNotFoundException}</p> will be thrown. Therefore, it is advised
     * to call {@link RegistryReference#find(RegistryHolder)} instead.
     *
     * @param holder The holder
     * @param alternatives Alternatives holders to search
     * @return The value
     */
    T get(RegistryHolder holder, Set<RegistryHolder> alternatives);

    /**
     * Gets the value from the {@link RegistryHolder holder}, if found.
     *
     * <p>The contract leaves a large amount of flexibility in how this value is retrieved
     * from the holder. As there are no defined rules, an implementation may choose to only
     * query the passed in holder or may choose to run through various {@link ScopedRegistryHolder holders}
     * for retrieval. As such, no assumption should be made whatsoever that the returned value
     * originated from the holder.</p>
     *
     * @param holder The holder
     * @return The value
     */
    default Optional<T> find(final RegistryHolder holder) {
        return holder.findRegistry(this.registry()).flatMap(r -> r.findValue(this));
    }

    interface Factory {

        <T> RegistryReference<T> referenced(RegistryHolder holder, RegistryType<T> registry, T value);
    }
}