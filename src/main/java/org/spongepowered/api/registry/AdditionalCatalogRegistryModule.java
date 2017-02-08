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
 * Registry module that is used to maintain a list of catalog types of a certain
 * type. This module also accepts catalog type instances that are created by
 * plugins.
 *
 * @param <T> The type of catalog type that is maintained by this module
 */
public interface AdditionalCatalogRegistryModule<T extends CatalogType> extends CatalogRegistryModule<T> {

    /**
     * Registers the given catalog type instance in this registry module. The
     * ids that can be used to access this instance are chosen automatically.
     *
     * @param extraCatalog The catalog type to register
     * @throws IllegalArgumentException If there is an id conflict with the
     *         given type and an existing type
     */
    void registerAdditionalCatalog(T extraCatalog) throws IllegalArgumentException;

}
