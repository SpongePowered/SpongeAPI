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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.registry.DefaultedRegistryType;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.ValueNotFoundException;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A {@link Tag} paired with the {@link RegistryHolder}.
 */
public interface DefaultedTag<T> extends Tag<T> {

    static <T> DefaultedTag<T> of(final DefaultedRegistryType<T> registryType, final ResourceKey location) {
        return Tag.of(registryType, location).asDefaultedTag(registryType.defaultHolder());
    }

    Supplier<RegistryHolder> defaultHolder();

    /**
     * Returns the {@link Stream} of values tagged by this tag.
     *
     * <p>Great care needs to be made in calling this method with any uncertainty as to
     * if the {@link #registry()} will exist in the holder. Should the key lack a value,
     * a {@link ValueNotFoundException} will be thrown. Therefore, it is advised to call
     * {@link #findValues()} instead.</p>
     *
     * @return The {@link Stream} of values
     */
    default Stream<T> values() {
        return this.defaultHolder().get().registry(this.registry()).taggedValues(this);
    }

    /**
     * Returns the {@link Stream} of values tagged by this tag in the holder
     * if it contains this tag's {@link #registry()}, or {@link Stream#empty()} otherwise.
     *
     * @return The {@link Stream} of values
     */
    default Stream<T> findValues() {
        return this.defaultHolder().get().findRegistry(this.registry()).map(r -> r.taggedValues(this)).orElseGet(Stream::empty);
    }

    /**
     * Returns whether this tag is associated with the given value.
     *
     * @param value The value
     * @return true if this tag is associated with the given value
     */
    boolean contains(T value);
}
