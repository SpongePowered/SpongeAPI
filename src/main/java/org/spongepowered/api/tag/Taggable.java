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
package org.spongepowered.api.tag;

import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.registry.RegistryHolder;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * A type that may be included in one or more {@link Tag} collections.
 */
@SuppressWarnings("unchecked")
public interface Taggable<T extends Taggable<T>> extends DefaultedRegistryValue<T> {

    /**
     * Gets all {@link Tag}s that have been associated
     * with this object in the default {@link #registryType()}.
     *
     * @return THe {@link Stream} of {@link Tag}s
     */
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
}
