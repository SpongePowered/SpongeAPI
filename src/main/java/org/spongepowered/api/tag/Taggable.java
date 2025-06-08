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

import org.spongepowered.api.registry.DefaultedRegistryType;
import org.spongepowered.api.registry.DefaultedRegistryValue;

import java.util.stream.Stream;

/**
 * A type that may be included in one or more {@link Tag} collections.
 */
public interface Taggable<T extends Taggable<T>> extends DefaultedRegistryValue<T> {

    /**
     * Gets all {@link Tag}s that have been associated with this object in the given registry.
     *
     * @return The {@link Stream} of {@link Tag}s.
     */
    Stream<Tag<T>> tags(DefaultedRegistryType<T> registryType);

    /**
     * Returns whether the given tag is associated with this object.
     *
     * @param tag The tag
     * @return true if the given tag is associated with this object
     */
    @SuppressWarnings("unchecked")
    default boolean is(DefaultedTag<T> tag) {
        return tag.contains((T) this);
    }
}
