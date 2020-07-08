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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.plugin.PluginContainer;

/**
 * A base builder to construct {@link CatalogType}s.
 *
 * @param <C> The catalog type
 * @param <B> The builder type for chaining
 */
public interface CatalogBuilder<C extends CatalogType, B extends ResettableBuilder<C, B>> extends ResettableBuilder<C, B> {

    /**
     * Sets the {@link ResourceKey} of the {@link CatalogType}.
     *
     * @param key The key
     * @return This builder for chaining
     */
    B key(ResourceKey key);

    /**
     * Builds the {@link CatalogType} of type {@code C}.
     *
     * <p>The last {@link PluginContainer} in the cause stack will be used to
     * determine which plugin was used to construct the {@link CatalogType}.</p>
     *
     * @return The built catalog type
     * @throws IllegalStateException If not all required options were specified
     */
    C build() throws IllegalStateException;
}
