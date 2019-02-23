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
package org.spongepowered.api;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.block.BlockTags;

import java.util.Collection;

/**
 * Represents a tag which can be applied to a specific {@link CatalogType}.
 *
 * @param <C> The catalog type
 * @see BlockTags
 */
public interface Tag<C extends CatalogType> extends CatalogType {

    /**
     * Gets the {@link TypeToken} of the target catalog type.
     *
     * @return The target catalog type
     */
    TypeToken<C> getTargetType();

    /**
     * Gets whether this tag is applied to the given catalog type.
     *
     * @param catalog The catalog type
     * @return Whether this tag is applied to the catalog type
     */
    boolean contains(C catalog);

    /**
     * Gets a unmodifiable {@link Collection} with all the catalog
     * types this tag is applied to.
     *
     * @return The collection with catalog types
     */
    Collection<C> getAll();
}
