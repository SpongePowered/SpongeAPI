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
package org.spongepowered.api.resource;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.plugin.PluginContainer;

/**
 * A namespaced path object used to get {@link Resource}s from the
 * {@link ResourceManager}.
 *
 * @see ResourceKey
 */
public interface ResourcePath extends Comparable<ResourcePath> {

    /**
     * The path separator string.
     */
    String SEPARATOR = "/";

    /**
     * Creates a resource path.
     *
     * @param namespace The namespace
     * @param value     The value
     * @return A new resource path
     * @see ResourceKey#of(String, String)
     */
    static ResourcePath of(final String namespace, final String value) {
        return ResourcePath.of(ResourceKey.of(namespace, value));
    }

    /**
     * Creates a resource path from a plugin container.
     *
     * @param container The plugin container
     * @param value     The value
     * @return A new resource path
     * @see ResourceKey#of(PluginContainer, String)
     */
    static ResourcePath of(final PluginContainer container, final String value) {
        return ResourcePath.of(ResourceKey.of(container, value));
    }

    /**
     * Parses a path from a string.
     *
     * <p>If no namespace is found in {@code value} then
     * {@code minecraft} will be the namespace.</p>
     *
     * @param value The value
     * @return A new resource path
     * @see ResourceKey#resolve(String)
     */
    static ResourcePath parse(final String value) {
        return ResourcePath.of(ResourceKey.resolve(value));
    }

    /**
     * Creates a new path using the given {@link ResourceKey}.
     *
     * @param key The key object
     * @return A new path
     */
    static ResourcePath of(final ResourceKey key) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).of(key);
    }

    /**
     * Gets the backing {@link ResourceKey} for this path object.
     *
     * @return The key object
     */
    ResourceKey key();

    /**
     * Gets the namespace portion of this resource path.
     *
     * @return The namespace
     * @see ResourceKey#getNamespace()
     */
    default String getNamespace() {
        return this.key().getNamespace();
    }

    /**
     * Gets the path portion of this resource path.
     *
     * @return The path
     * @see ResourceKey#getValue()
     */
    default String getPath() {
        return this.key().getValue();
    }

    // resolution methods

    /**
     * Resolves this resource path's parent.
     *
     * @return The parent path
     * @throws IllegalStateException If the path has no parent
     */
    ResourcePath getParent();

    /**
     * Resolves a path from the current location using the specified children.
     *
     * @param first    The first child
     * @param children The rest of the children
     * @return The resolvedIllegalArgumentException path
     * @throws IllegalArgumentException If the path is invalid
     */
    ResourcePath resolve(String first, String... children);

    /**
     * Resolves a sibling of this path.
     *
     * @param sibling  The sibling's name
     * @param children The optional children of the sibling
     * @return The sibling resource path
     * @throws IllegalArgumentException If the path is invalid
     */
    ResourcePath resolveSibling(String sibling, String... children);

    // path utility methods

    /**
     * Gets the name of the file without any parent elements.
     *
     * @return The file name
     */
    String getName();

    /**
     * Gets the base name of the file without any parent elements or extensions.
     *
     * @return The base file name
     */
    String getBaseName();

    /**
     * Gets the extension of the file if any. If the file has no extension, an
     * empty string is returned.
     *
     * @return The file extension
     */
    String getExtension();

    /**
     * Gets the string representation of this path as {@code "namspace:path"}
     *
     * @return The string representation
     * @see ResourceKey#asString()
     */
    String asString();

    /**
     * A factory to create {@link ResourcePath}s.
     */
    interface Factory {
        /**
         * Creates a new {@link ResourcePath} using the given
         * {@link ResourceKey}.
         *
         * @param key The key object
         * @return A new path object
         */
        ResourcePath of(ResourceKey key);
    }
}
