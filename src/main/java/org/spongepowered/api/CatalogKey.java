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
package org.spongepowered.api;

import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * An object representation of a location or pointer to a {@link CatalogType}
 * that can be used to retrieve said type from the {@link GameRegistry}. The
 * key can be represented as a {@link String} by {@link Object#toString()}. The key
 * is built with two parts:
 * <ol>
 *     <li>The Namespace</li>
 *     <li>The Value</li>
 * </ol>
 * Normally, the namespace is lowercased and likewise, so is the value. This
 * is have a uniform format for all uses of {@link CatalogKey}, including but
 * not restricted to {@link DataRegistration}s, {@link ConfigurationNode}s,
 * {@link DataTranslator}s, and {@link DataSerializable}s.
 *
 * <p>Note that the methods {@link #minecraft(String)} and
 * {@link #sponge(String)} should only be used by the implementations for
 * creating new keys for new {@link CatalogType}s. Plugins using these to create
 * their own {@link CatalogType}s and registering them is not recommended as it
 * prevents missing plugin detection by users from taking place.</p>
 */
public interface CatalogKey extends Comparable<CatalogKey> {

    /**
     * The minecraft namespace.
     */
    String MINECRAFT_NAMESPACE = "minecraft";
    /**
     * The sponge namespace.
     */
    String SPONGE_NAMESPACE = "sponge";

    /**
     * Creates a catalog key with a namespace of {@link #MINECRAFT_NAMESPACE minecraft}.
     *
     * @param value The value
     * @return A new catalog key
     */
    static CatalogKey minecraft(final String value) {
        return of(MINECRAFT_NAMESPACE, value);
    }

    /**
     * Creates a catalog key with a namespace of {@link #SPONGE_NAMESPACE sponge}.
     *
     * @param value The value
     * @return A new catalog key
     */
    static CatalogKey sponge(final String value) {
        return of(SPONGE_NAMESPACE, value);
    }

    /**
     * Creates a new {@link Builder} for creating {@link CatalogKey}s. The builder
     * can be used for creating keys based on {@link PluginContainer}s, {@link Object}s
     * of plugins, and {@link String} namespaces.
     *
     * @return The new builder instance
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a catalog key.
     *
     * @param namespace The namespace
     * @param value The value
     * @return A new catalog key
     */
    static CatalogKey of(final String namespace, final String value) {
        return Sponge.getRegistry().createBuilder(Builder.class).namespace(namespace).value(value).build();
    }

    /**
     * Creates a catalog key
     *
     * @param container The container
     * @param value The value
     * @return A new catalog key
     */
    static CatalogKey of(final PluginContainer container, final String value) {
        return Sponge.getRegistry().createBuilder(Builder.class).namespace(container).value(value).build();
    }

    /**
     * Resolves a catalog key from a string.
     *
     * <p>If no namespace is found in {@code string} then
     * {@link #MINECRAFT_NAMESPACE} will be the namespace.</p>
     *
     * @param value The value
     * @return A new catalog key
     */
    static CatalogKey resolve(final String value) {
        return Sponge.getRegistry().resolveKey(value);
    }

    /**
     * Gets the namespace.
     *
     * @return The namespace
     */
    String getNamespace();

    /**
     * Gets the value.
     *
     * @return The value
     */
    String getValue();

    @Override
    int compareTo(CatalogKey o);

    interface Builder extends ResettableBuilder<CatalogKey, Builder> {

        Builder namespace(String namespace);

        Builder namespace(PluginContainer container);

        Builder value(String value);

        CatalogKey build() throws IllegalStateException;
    }
}
