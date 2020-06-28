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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.List;

public interface ResourcePath extends Comparable<ResourcePath> {

    String SEPARATOR = "/";

    /**
     * Creates a new {@link Builder} for creating {@link ResourcePath}s. The builder
     * can be used for creating keys based on {@link PluginContainer}s, {@link Object}s
     * of plugins, and {@link String} namespaces.
     *
     * @return The new builder instance
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Creates a catalog key.
     *
     * @param namespace The namespace
     * @param value     The value
     * @return A new catalog key
     */
    static ResourcePath of(final String namespace, final String value) {
        return builder().namespace(namespace).path(value).build();
    }

    /**
     * Creates a catalog key
     *
     * @param container The container
     * @param value     The value
     * @return A new catalog key
     */
    static ResourcePath of(final PluginContainer container, final String value) {
        return builder().namespace(container).path(value).build();
    }

    /**
     * Parses a path from a string.
     *
     * <p>If no namespace is found in {@code string} then
     * {@code minecraft} will be the namespace.</p>
     *
     * @param value The value
     * @return A new catalog key
     */
    static ResourcePath parse(final String value) {
        return builder().path(value).build();
    }

    /**
     * Gets the namespace portion of this resource path.
     *
     * @return The namespace
     */
    String getNamespace();

    /**
     * Gets the path portion of this resource path.
     *
     * @return The path
     */
    String getPath();

    // resolution methods

    /**
     * Resolves this resource path's parent.
     *
     * @return The parent path
     * @throws ResourcePathException If the parent normalizes to null
     */
    ResourcePath getParent() throws ResourcePathException;

    /**
     * Resolves a single file as a child of this path.
     *
     * @param child The child path's name
     * @return The resolved path
     * @throws ResourcePathException If the path is invalid or could not be normalized
     * @see #resolve(String...)
     */
    default ResourcePath resolve(String child) throws ResourcePathException {
        return resolve(new String[]{child});
    }

    /**
     * Resolves a path from the current location using the specified children.
     *
     * @param children The children paths
     * @return The resolved path
     * @throws ResourcePathException If the path is invalid or could not be normalized
     */
    ResourcePath resolve(String... children) throws ResourcePathException;

    /**
     * @param sibling The sibling's name
     * @return The sibling resource path
     * @throws ResourcePathException If the path is invalid or could not be normalized
     */
    ResourcePath resolveSibling(String sibling) throws ResourcePathException;

    // path utility methods

    /**
     * Gets all the parts of this path. i.e. the full path split by {@link #SEPARATOR}.
     *
     * @return The path parts
     */
    List<String> getPathParts();

    /**
     * Gets the parent of this path or root if it is root.
     *
     * @return The parent path
     */
    String getParentPath();

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
     * Gets the extension of the file if any. If the file has no extension, an empty string is returned.
     *
     * @return The file extension
     */
    String getExtension();

    interface Builder extends ResettableBuilder<ResourcePath, Builder> {

        Builder namespace(String namespace);

        Builder namespace(PluginContainer container);

        Builder path(String path);

        Builder paths(String... paths);

        Builder paths(Collection<String> paths);

        ResourcePath build() throws ResourcePathException;
    }
}
