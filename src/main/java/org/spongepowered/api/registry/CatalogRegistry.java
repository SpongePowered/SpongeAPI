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

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.plugin.PluginManager;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface CatalogRegistry {

    /**
     * Creates a {@link Supplier} that will be used to get {@link CatalogType} instances.
     *
     * <p>
     *     The suggested id parameter may or may not be used and is left up to the implementation
     *     to determine the composition of the supplied {@link CatalogType reference's} {@link ResourceKey}
     * </p>
     * @param catalogClass The catalog class
     * @param suggestedId The suggested id to use
     * @param <T> The type of catalog
     * @param <E> The generic of the catalog (if applicable)
     * @throws UnknownTypeException If the type provided has not been registered
     * @return The supplier
     */
    <T extends CatalogType, E extends T> Supplier<E> provideSupplier(Class<T> catalogClass, String suggestedId) throws UnknownTypeException;

    /**
     * Attempts to retrieve the specific type of {@link CatalogType} based on
     * the key given.
     *
     * <p>Some types may not be available for various reasons including but not
     * restricted to: mods adding custom types, plugins providing custom types,
     * game version changes.</p>
     *
     * @param typeClass The class of the type of {@link CatalogType}
     * @param key The catalog key
     * @param <T> The type of dummy type
     * @return The found dummy type, if available
     * @see CatalogType
     */
    <T extends CatalogType> Optional<T> get(Class<T> typeClass, Key key);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * <p>The presented {@link CatalogType}s may not exist in default catalogs
     * due to various reasons including but not restricted to: mods, plugins,
     * game changes.</p>
     *
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllOf(Class<T> typeClass);

    /**
     * Gets a {@link Stream} of all available found specific types of
     * {@link CatalogType} requested.
     *
     * <p>The presented {@link CatalogType}s may not exist in default catalogs
     * due to various reasons including but not restricted to: mods, plugins,
     * game changes.</p>
     *
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A stream of all known types of the requested catalog type
     */
    <T extends CatalogType> Stream<T> streamAllOf(Class<T> typeClass);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * @param typeClass The class of {@link CatalogType}
     * @param namespace The namespace to check for types
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllFor(Class<T> typeClass, String namespace);

    /**
     * Gets a {@link Stream} of all available found specific types of
     * {@link CatalogType} requested.
     *
     * @param typeClass The class of {@link CatalogType}
     * @param namespace The namespace to check for types
     * @param <T> The type of {@link CatalogType}
     * @return A stream of all known types of the requested catalog type
     */
    <T extends CatalogType> Stream<T> streamAllFor(Class<T> typeClass, String namespace);

    /**
     * Gets all {@link CatalogType types} as a collection for Minecraft as a base mod. Note that
     * some {@link CatalogType}s are not originally from the game itself, and
     * may be provided by Sponge.
     *
     * @param typeClass The type of catalog type
     * @param <T> The type of catalog type
     * @return The collection of all known types of the requested catalog type
     */
    default <T extends CatalogType> Collection<T> getAllForMinecraft(Class<T> typeClass) {
        return this.getAllFor(typeClass, PluginManager.MINECRAFT_PLUGIN_ID);
    }

    /**
     * Gets all {@link CatalogType types} as a {@link Stream} for Minecraft as a base mod. Note that
     * some {@link CatalogType}s are not originally from the game itself, and
     * may be provided by Sponge.
     *
     * @param typeClass The type of catalog type
     * @param <T> The type of catalog type
     * @return The stream of all known types of the requested catalog type
     */
    default <T extends CatalogType> Stream<T> streamAllForMinecraft(Class<T> typeClass) {
        return this.streamAllFor(typeClass, PluginManager.MINECRAFT_PLUGIN_ID);
    }

    /**
     * Gets all {@link CatalogType types} as a {@link Stream} for Sponge as a base mod.
     *
     * @param typeClass The type of catalog type
     * @param <T> The type of catalog type
     * @return The collection of all known types of the requested catalog type
     */
    default <T extends CatalogType> Collection<T> getAllForSponge(Class<T> typeClass) {
        return this.getAllFor(typeClass, PluginManager.SPONGE_PLUGIN_ID);
    }

    /**
     * Gets all {@link CatalogType types} as a collection for Sponge as a base mod.
     *
     * @param typeClass The type of catalog type
     * @param <T> The type of catalog type
     * @return The stream of all known types of the requested catalog type
     */
    default <T extends CatalogType> Stream<T> streamAllForSponge(Class<T> typeClass) {
        return this.streamAllFor(typeClass, PluginManager.SPONGE_PLUGIN_ID);
    }
}
