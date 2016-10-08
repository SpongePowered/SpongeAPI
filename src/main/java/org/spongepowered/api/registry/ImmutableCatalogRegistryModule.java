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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.CatalogType;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Simple implementation of the {@link CatalogRegistryModule} that does not
 * allow custom types to be added.
 *
 * @param <T> The type of catalog type that is maintained by this module
 */
public abstract class ImmutableCatalogRegistryModule<T extends CatalogType> implements AlternateCatalogRegistryModule<T> {

    private final Map<String, T> typesById;
    private final Set<T> types;

    /**
     * Creates a new instance with the given id to type mappings. All keys will
     * be stored in lower case.
     *
     * @param typesById The map containing all registered ids for all catalog
     *        types
     */
    protected ImmutableCatalogRegistryModule(Map<String, T> typesById) {
        checkNotNull(typesById, "typesById");
        ImmutableMap.Builder<String, T> builder = ImmutableMap.builder();
        typesById.forEach((key, value) -> builder.put(toLowerCase(key), checkNotNull(value, "value for key: %s", key)));
        this.typesById = builder.build();
        this.types = ImmutableSet.copyOf(typesById.values());
    }

    @Override
    public final Optional<T> getById(String id) {
        return Optional.ofNullable(this.typesById.get(toLowerCase(id)));
    }

    @Override
    public final Collection<T> getAll() {
        return this.types;
    }

    @Override
    public Map<String, T> provideCatalogMap() {
        return this.typesById;
    }

    // Registration needs to take place in the constructor
    @Override
    public final void registerDefaults() {
    }

    /**
     * Checks and converts the given key to its lower case equivalent, that can
     * be used to get a type from the key map.
     *
     * @param id The key to check and convert
     * @return The checked lower case key
     * @see #provideCatalogMap()
     */
    protected static String toLowerCase(String id) {
        return checkNotNull(id, "key").toLowerCase(Locale.ENGLISH);
    }

}
