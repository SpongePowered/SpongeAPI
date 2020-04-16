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
     * Resolves a catalog key from a string.
     *
     * <p>If no namespace is found in {@code string} then
     * {@link org.spongepowered.api.CatalogKey#MINECRAFT_NAMESPACE} will be the namespace.</p>
     *
     * @param value The value
     * @return A new catalog key
     */
    static ResourcePath resolve(final String value) {
        return builder().path(value).build();
    }

    String getNamespace();

    String getPath();

    List<String> getPathParts();

    ResourcePath getParent();

    ResourcePath resolve(String... children);

    default Builder copy() {
        return builder().namespace(this.getNamespace()).path(this.getPath());
    }

    interface Builder extends ResettableBuilder<ResourcePath, Builder> {

        Builder namespace(String namespace);

        Builder namespace(PluginContainer container);

        Builder path(String path);

        Builder paths(String... paths);

        Builder paths(Collection<String> paths);

        ResourcePath build();
    }
}
