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

import net.kyori.adventure.key.Key;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.registry.GameRegistry;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.plugin.PluginContainer;

/**
 * An object representation of a location or pointer to various resources, such
 * as {@link CatalogType}, that can be used to retrieve from various places such as
 * the {@link GameRegistry}. The key can be represented as a {@link String} by
 * {@link Object#toString()}. The key is built with two parts:
 * <ol>
 *     <li>The Namespace</li>
 *     <li>The Value</li>
 * </ol>
 * Normally, the namespace is lowercased and likewise, so is the value. This
 * is a uniform format for all uses of {@link ResourceKey}, including but
 * not restricted to {@link DataRegistration}s, {@link ConfigurationNode}s,
 * {@link DataTranslator}s, and {@link DataSerializable}s.
 *
 * <p>Note that the methods {@link #minecraft(String)} and
 * {@link #sponge(String)} should only be used by the implementations for
 * creating new keys and usage by plugins <strong>may</strong> result in
 * a crash condition by the implementation.
 */
public interface ResourceKey extends Key {

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
    static ResourceKey minecraft(final String value) {
        return of(MINECRAFT_NAMESPACE, value);
    }

    /**
     * Creates a catalog key with a namespace of {@link #SPONGE_NAMESPACE sponge}.
     *
     * @param value The value
     * @return A new catalog key
     */
    static ResourceKey sponge(final String value) {
        return of(SPONGE_NAMESPACE, value);
    }

    /**
     * Creates a new {@link Builder} for creating {@link ResourceKey}s. The builder
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
     * @param value The value
     * @return A new catalog key
     */
    static ResourceKey of(final String namespace, final String value) {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class).namespace(namespace).value(value).build();
    }

    /**
     * Creates a catalog key
     *
     * @param container The container
     * @param value The value
     * @return A new catalog key
     */
    static ResourceKey of(final PluginContainer container, final String value) {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class).namespace(container).value(value).build();
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
    static ResourceKey resolve(final String value) {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class).value(value).build();
    }

    /**
     * Gets the namespace.
     *
     * @return The namespace
     */
    default String getNamespace() {
        return this.namespace();
    }

    /**
     * Gets the value.
     *
     * @return The value
     */
    default String getValue() {
        return this.value();
    }

    /**
     * Gets this key as a formatted value.
     *
     * <p>
     *     It is up to the implementation to determine the formatting. In vanilla Minecraft,
     *     keys are formatted as "namespace:value". For example, "minecraft:carrot".
     * </p>
     * @return The key, formatted
     */
    default String getFormatted() {
        return this.asString();
    }

    @Override
    default String asString() {
        return this.namespace() + ':' + this.value();
    }

    @Override
    default int compareTo(Key o) {
        return Key.super.compareTo(o);
    }

    interface Builder extends ResettableBuilder<ResourceKey, Builder> {

        Builder namespace(String namespace);

        Builder namespace(PluginContainer container);

        Builder value(String value);

        ResourceKey build() throws IllegalStateException;
    }
}
