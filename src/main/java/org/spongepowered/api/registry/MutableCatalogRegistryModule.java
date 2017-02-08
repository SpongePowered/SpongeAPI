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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.CatalogType;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Simple implementation of the {@link CatalogRegistryModule} that allows plugin
 * created types to be registered.
 *
 * @param <T> The type of catalog type that is maintained by this module
 */
public abstract class MutableCatalogRegistryModule<T extends CatalogType> implements AdditionalCatalogRegistryModule<T>, AlternateCatalogRegistryModule<T> {

    private final Map<String, T> typesById = new LinkedHashMap<>();
    @Nullable private Set<T> types;

    @Override
    public final Optional<T> getById(String id) {
        return Optional.ofNullable(this.typesById.get(toLowerCase(id)));
    }

    @Override
    public final Collection<T> getAll() {
        if (this.types == null) {
            this.types = ImmutableSet.copyOf(this.types);
        }
        return this.types;
    }

    @Override
    public Map<String, T> provideCatalogMap() {
        return Collections.unmodifiableMap(this.typesById);
    }

    /**
     * Checks and converts the given id to its lower case equivalent, that can
     * be used to get a type from the catalog map.
     *
     * @param id The id to check and convert
     * @return The checked lower case id
     * @see #provideCatalogMap()
     */
    protected static String toLowerCase(String id) {
        return checkNotNull(id, "id").toLowerCase(Locale.ENGLISH);
    }

    /**
     * Helper method to get a collection of calculated alias ids that will be
     * used to register additional ids for the given {@link CatalogType}
     * instance. This method is not required to return all possible ids that can
     * be used to obtain the type, but it should return all common ids.
     * Special/alias ids might be registered through
     * {@link #register(String, CatalogType)}.
     *
     * <p>This instance might return ids that are stripped of their prefix or
     * are enriched with a default prefix. Example: minecraft:sandStone -&gt
     * sandstone, sand_stone, minecraft:sand_stone.</p>
     *
     * @param type The catalog type instance to get the ids for
     * @return A collection containing the ids that uniquely map to the given
     *         type
     */
    protected Collection<String> aliasIdsForType(T type) {
        return Collections.emptySet();
    }

    @Override
    public final void registerAdditionalCatalog(T extraCatalog) {
        checkNotNull(extraCatalog, "extraCatalog");
        String id = toLowerCase(extraCatalog.getId());
        checkArgument(!this.typesById.containsKey(id), "Cannot register %s because the id %s is already registered.", id);
        Collection<String> aliasIds = checkNotNull(aliasIdsForType(extraCatalog), "idsForType");
        boolean foundConflict = aliasIds.stream()
                .map(aliasId -> toLowerCase(aliasId))
                .anyMatch(this.typesById::containsKey);
        checkArgument(!foundConflict, "Cannot register %s because the at least one of these alias ids is already registered: %s!", aliasIds,
                extraCatalog);
        this.typesById.put(id, extraCatalog);
        aliasIds.forEach(aliasId -> this.typesById.put(toLowerCase(aliasId), extraCatalog));
        this.types = null;
    }

    /**
     * Register an additional id to access the given type. This should only be
     * called during {@link #registerDefaults()}.
     *
     * @param id The new id to register
     * @param type The type to register the id for
     */
    protected final void register(String id, T type) {
        id = toLowerCase(id);
        checkArgument(!this.typesById.containsKey(id), "Cannot register %s because the id %s is already registered!", type, id);
        this.typesById.put(id, checkNotNull(type, "type"));
        this.types = null;
    }

    /**
     * Register an additional alias id to access the type that is already
     * registered with the other id.
     *
     * @param oldId The old id the type is already registered for
     * @param newId The new alias id to register
     */
    protected final void registerAlias(String oldId, String newId) {
        checkNotNull(oldId, "oldId");
        checkNotNull(newId, "newId");
        final T type = getById(oldId).orElseThrow(() -> new IllegalStateException("Could not find instance for id: " + oldId));
        register(newId, type);
    }

    /**
     * Forcefully register the given id for the given type. Great care should be
     * taken, when using this method as it will replace the given id to the
     * target, but others might still point to that instance.
     *
     * @param id The id to register
     * @param type The type to register the key for.
     */
    // TODO: Is such a method needed at all?
    protected final void forceRegister(String id, T type) {
        this.typesById.put(toLowerCase(id), checkNotNull(type, "type"));
        this.types = null;
    }

}
