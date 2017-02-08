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
import org.spongepowered.api.registry.util.RegisterCatalog;

import java.util.Map;

/**
 * Registry module that is used to maintain a list of catalog types of a certain
 * type. Implementations must also annotate the class or a field in the class
 * with the {@link RegisterCatalog} annotation, to indicate which catalog type
 * pseudo enum class should be populated with the given values. The
 * {@link #provideCatalogMap()} method takes precedence before any fields
 * annotated with the {@link RegisterCatalog} annotation.
 *
 * @param <T> The type of catalog type that is maintained by this module
 */
public interface AlternateCatalogRegistryModule<T extends CatalogType> extends CatalogRegistryModule<T> {

    /**
     * Returns a view of the internal id to instance mapping that can be used to
     * populate the catalog type pseudo enums.
     *
     * @return The map that should be used to populate the pseudo enums.
     */
    Map<String, T> provideCatalogMap();

}
