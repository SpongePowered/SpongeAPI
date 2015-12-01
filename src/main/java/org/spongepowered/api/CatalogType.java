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

/**
 * Represents a type of a catalog that can be used to identify types without
 * using an {@link Enum}.
 *
 * <p>All implementing classes, including those not listed in the catalog
 * specified by the {@link org.spongepowered.api.util.annotation.CatalogedBy
 * CatalogedBy} annotation, must meet the requirement that if any of
 * <code>`a.equals(b)`</code>, <code>`a == b`</code>, or
 * <code>`a.getId().equalsIgnoreCase(b.getId())`</code> are true then all must
 * be true.</p>
 */
public interface CatalogType {

    /**
     * Gets the unique identifier of this {@link CatalogType}. The identifier is
     * case insensitive, thus there cannot be another instance with a different
     * character case. The id of this instance must remain the same for the
     * entire duration of its existence. The identifier can be formatted however
     * needed.
     *
     * <p>A typical id format follows the pattern of <code>`modId:name`</code>
     * or <code>`minecraft:name`</code>. However the prefix may be omitted for
     * default/vanilla minecraft types.</p>
     *
     * @return The unique identifier of this catalog type
     */
    String getId();

    /**
     * Gets the human-readable name of this individual {@link CatalogType}. This
     * name is not guaranteed to be unique. This value should not be used for
     * serialization.
     *
     * @return The human-readable name of this catalog type
     */
    String getName();

}
