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
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <p>A resource path should contain a namespace. If one is not provided,
 * {@code minecraft} will be used instead. The namespace and path must not
 * contain any special characters or uppercase letters.
 *
 * <p>In the pack, the path will point to a resource. The resource should
 * be located roughly at {@code data/namespace/path}</p>
 *
 * <p>A resource path should be usable in a {@link Map}, so implementations
 * should override {@link #hashCode()} and {@link #equals(Object)}.</p>
 */
public interface ResourcePath extends Comparable<ResourcePath>, Iterable<ResourcePath> {

    /**
     * Creates a new {@link Builder} to build a {@link ResourcePath}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link ResourcePath} using the given namespace and path.
     *
     * @param namespace The namespace to use
     * @param path The path to use
     * @return A new ResourcePath
     */
    static ResourcePath of(String namespace, String path) throws IllegalArgumentException {
        return builder().namespace(namespace).path(path).build();
    }

    /**
     * Parses a new {@link ResourcePath} from the given string representation.
     * The representation should include both the namespace and path, separated
     * by a colon (:). Path items should be separated by a forward slash (/).
     * If the namespace is excluded, the default of minecraft is used instead.
     *
     * <p>e.g. {@code lagmeter:functions/lm.json} points to the
     * functions/lm.json file in the lagmeter namespace.</p>
     *
     * @param path The path
     * @return A new ResourcePath
     */
    static ResourcePath parse(String path) throws IllegalArgumentException {
        return builder().parse(path).build();
    }

    /**
     * Gets the namespace portion of this resource path.
     *
     * @return The namespace
     */
    String getNamespace();

    /**
     * Gets the path portion of this resource path
     *
     * @return The path
     */
    String getPath();

    /**
     * Gets the root path from this path.
     *
     * @return The root path
     */
    ResourcePath getRoot();

    /**
     * Gets the immediate parent for this {@link ResourcePath}. If this path is
     * the root path, itself is returned.
     *
     * @return The parent path
     * @see #getRoot()
     */
    ResourcePath getParent();

    /**
     * Gets a list of paths for this {@link ResourcePath}. Order of parts will
     * be closest first, with the first element being this element and the root
     * being the last element.
     *
     * @return The list of paths
     */
    List<ResourcePath> getParts();

    /**
     * Creates a new stream of all the paths in this {@link ResourcePath}.
     *
     * @return A new stream
     * @see #getParts()
     */
    Stream<ResourcePath> stream();

    /**
     * Gets the file name portion of this {@link ResourcePath}.
     *
     * @return The file name of the path
     */
    String getName();

    /**
     * Resolves a new {@link ResourcePath} with this one as the parent.
     *
     * @param name The file name of the new path
     * @return A new path
     */
    ResourcePath resolve(String name);

    /**
     * Resolves a new {@link ResourcePath} with the parent of this one as the
     * parent.
     *
     * @param name The file name of the new path
     * @return A new path
     */
    ResourcePath resolveSibling(String name);

    /**
     * Represents a builder to create {@link ResourcePath} instances.
     */
    interface Builder extends ResettableBuilder<ResourcePath, Builder> {

        /**
         * Sets the namespace of the {@link ResourcePath}.
         *
         * @param namespace The namespace
         * @return This builder
         * @throws IllegalArgumentException if the namespace contains illegal characters
         */
        Builder namespace(String namespace) throws IllegalArgumentException;

        /**
         * Sets the namespace of the {@link ResourcePath} using the given
         * plugin's id.
         *
         * @param plugin The owning plugin
         * @return This builder
         */
        Builder plugin(Object plugin);

        /**
         * Sets the path of the {@link ResourcePath}.
         *
         * @param path The path
         * @return This builder
         */
        Builder path(String path) throws IllegalArgumentException;

        /**
         * Parses a string which represents a {@link ResourcePath}. This
         * completes the builder.
         *
         * @param path The string representation of a resource path
         * @return This builder
         * @see ResourcePath#parse(String)
         */
        Builder parse(String path) throws IllegalArgumentException;

        /**
         * Builds an instance of a {@link ResourcePath}.
         *
         * @return A new instance of a {@link ResourcePath}
         * @throws IllegalStateException if a path was not provided
         */
        ResourcePath build() throws IllegalStateException;

    }
}
