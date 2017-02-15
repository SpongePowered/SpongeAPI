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

import org.spongepowered.api.CatalogType;

/**
 * An enhanced {@link AdditionalCatalogRegistryModule} that explicitly
 * has registrations of it's {@link CatalogType} based on a per-{@link Class}
 * registration basis.
 *
 * @param <T> The type of catalog type
 * @param <TExtra> The class
 */
public interface ExtraClassCatalogRegistryModule<T extends CatalogType, TExtra> extends AdditionalCatalogRegistryModule<T> {

    /**
     * Gets whether the provided {@link Class} is already registered.
     *
     * @param mappedClass The mapped class to check for registration
     * @return Whether the class has a registration already or not
     */
    boolean hasRegistrationFor(Class<? extends TExtra> mappedClass);

    /**
     * Gets the {@link CatalogType} based on the provided {@link Class}.
     *
     * @param clazz The class to get the catalog type for
     * @return The catalog type
     */
    T getForClass(Class<? extends TExtra> clazz);

}
