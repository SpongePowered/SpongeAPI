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

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A {@link RegistryReference reference} where the {@link RegistryHolder holder} is
 * given to us to search within a no-args {@code get()} method.
 *
 * <p>Purely for convenience so that most default references in the API are not always
 * calling out to the global holder simply by using it.</p>
 *
 * @param <T> The type
 */
public interface DefaultedRegistryReference<T> extends RegistryReference<T>, Supplier<T> {

    /**
     * Gets the value from the default {@link RegistryHolder holder} given when constructing
     * this reference.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if this reference will exist in the holder. Should this reference lack a value, a
     * {@link ValueNotFoundException} will be thrown. Therefore, it is advised to call
     * {@link RegistryReference#find(RegistryHolder)} instead.</p>
     *
     * @return The value
     */
    @Override
    T get();

    Optional<T> find();

    Supplier<RegistryHolder> defaultHolder();
}
