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
package org.spongepowered.api.util;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.translation.Translation;

/**
 * A base builder to construct {@link CatalogType}s.
 *
 * @param <C> The catalog type
 * @param <B> The builder type for chaining
 */
public interface CatalogBuilder<C extends CatalogType, B extends ResettableBuilder<C, B>> extends ResettableBuilder<C, B> {

    /**
     * Sets the {@link CatalogKey} of the {@link CatalogType}.
     *
     * <p>Formatting for the namespace and value are lowercased as
     * usual.</p>
     *
     * @param key The key
     * @return This builder for chaining
     */
    B key(CatalogKey key);

    /**
     * Sets the key of the {@link CatalogType}, the provided id is the value
     * and the namespace is the id of the {@link PluginContainer} that is
     * currently in the {@link CauseStackManager}.
     *
     * <p>Formatting for the id is lowercased as usual.</p>
     *
     * @param id The id
     * @return This builder for chaining
     * @throws IllegalStateException If this method is accessed asynchronously, the {@link CauseStackManager}
     *                               which is required to retrieve the plugin id cannot be accessed off the
     *                               main thread(s).
     */
    B id(String id);

    /**
     * Sets the name of the {@link CatalogType}. Defaults to the
     * {@link CatalogKey#getValue() catalog key value}.
     *
     * @param name The name
     * @return This builder for chaining
     */
    B name(String name);

    /**
     * Sets the name of the {@link CatalogType} as a {@link Translation}. Defaults
     * to the {@link CatalogKey#getValue() catalog key value}.
     *
     * @param translation The name translation
     * @return This builder for chaining
     */
    B name(Translation translation);

    /**
     * Builds the {@link CatalogType} of type {@link C}.
     *
     * @return The built catalog type
     * @throws IllegalStateException If not all required options were specified, this includes
     *                               the {@link #key(CatalogKey)} (or the {@link #id(String)}).
     */
    C build() throws IllegalStateException;

    /**
     * @deprecated It's not allowed to duplicate catalog types.
     */
    @Deprecated
    @Override
    default B from(C value) {
        throw new UnsupportedOperationException("Duplicating catalog types isn't allowed.");
    }
}
