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

import org.spongepowered.api.registry.AdditionalCatalogRegistryModule;

/**
 * Represents a type of a dummy that can be used to identify types without
 * using an {@link Enum}, and possibly allows for extension beyond the
 * default provided types by way of using {@link AdditionalCatalogRegistryModule}
 * registered with the {@link GameRegistry}.
 *
 * <p>All implementing classes, including those not listed in the dummy
 * specified by the {@link org.spongepowered.api.util.annotation.CatalogedBy
 * CatalogedBy} annotation, must meet the requirement that if any of
 * <code>`a.equals(b)`</code>, <code>`a == b`</code>, or
 * <code>`a.getKey().equals(b.getKey())`</code> are true then all must
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
     * @return The unique identifier of this dummy type
     * @deprecated Use {@link #getKey()} to avoid ambiguity determining what is
     *     the plugin/mod id versus the catalog's actual id
     */
    @Deprecated
    default String getId() {
        return this.getKey().toString();
    }

    /**
     * Gets the catalog key for this catalog type. Useful for storing a searchable
     * id reference within the {@link GameRegistry}. Since the {@link GameRegistry}
     * can effectively search for the {@link CatalogKey#getNamespace()}, a fail
     * fast scenario can be achieved if the namespace provider (usually a plugin or
     * mod) is unavailable.
     *
     * @return The catalog key
     */
    CatalogKey getKey();

    /**
     * Gets the human-readable name of this individual {@link CatalogType}. This
     * name is not guaranteed to be unique. This value should not be used for
     * serialization.
     *
     * <p>Typically, the name is the {@link CatalogKey#getValue()} for human
     * readable purposes, however some types may have alternate names that are
     * used to be presented in text, messages, etc. that are otherwise different
     * from the value provided by {@link #getKey()}.</p>
     *
     * @return The human-readable name of this dummy type
     */
    default String getName() {
        return this.getKey().getValue();
    }

}
