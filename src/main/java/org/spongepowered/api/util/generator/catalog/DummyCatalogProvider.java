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
package org.spongepowered.api.util.generator.catalog;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.spongepowered.api.CatalogType;

/**
 * This class dynamically generates a dummy class for a given interface (usually a {@link CatalogType}).
 *
 * <p>The generated class implements all of the interface's methods, but
 * throws an {@link UnsupportedOperationException} with an informative error message.</p>
 */
public final class DummyCatalogProvider {

    private static final DummyClassGeneratorProvider factoryProvider = new DummyClassGeneratorProvider("org.spongepowered.api.util.dummy");

    private static final LoadingCache<Class<?>, Class<?>> factories = CacheBuilder.newBuilder().build(
            new CacheLoader<Class<?>, Class<?>>() {

                @Override
                public Class<?> load(Class<?> type) {
                    return factoryProvider.create(type, UnsupportedOperationException.class);
                }
            });

    /**
     * Creates a new dummy class implementing the specified interface
     *
     * @param type The interface to generate a dummy class for
     * @param <T> The type of class to be created
     * @return The generated dummy class
     */
    @SuppressWarnings("unchecked")
    public static <T> T createFor(Class<T> type) {
        try {
            return (T) factories.getUnchecked(type).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("Failed to instantiate dummy class for class %s", type), e);
        }
    }

}
