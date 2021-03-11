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
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.plugin.PluginContainer;

import java.util.Objects;

/**
 * An object representation of a location or pointer to resources.
 * The key can be represented as a {@link String} by {@link Object#toString()}.
 *
 * The key is built with two parts:
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
     * The brigadier namespace.
     */
    String BRIGADIER_NAMESPACE = "brigadier";
    /**
     * The minecraft namespace.
     */
    String MINECRAFT_NAMESPACE = "minecraft";
    /**
     * The sponge namespace.
     */
    String SPONGE_NAMESPACE = "sponge";

    /**
     * Creates a resource key with a namespace of {@link #BRIGADIER_NAMESPACE brigadier}.
     *
     * @param value The value
     * @return A new resource key
     */
    @NonNull
    static ResourceKey brigadier(final String value) {
        return ResourceKey.of(ResourceKey.BRIGADIER_NAMESPACE, value);
    }

    /**
     * Creates a resource key with a namespace of {@link #MINECRAFT_NAMESPACE minecraft}.
     *
     * @param value The value
     * @return A new resource key
     */
    @NonNull
    static ResourceKey minecraft(final String value) {
        return ResourceKey.of(ResourceKey.MINECRAFT_NAMESPACE, value);
    }

    /**
     * Creates a resource key with a namespace of {@link #SPONGE_NAMESPACE sponge}.
     *
     * @param value The value
     * @return A new resource key
     */
    @NonNull
    static ResourceKey sponge(final String value) {
        return ResourceKey.of(ResourceKey.SPONGE_NAMESPACE, value);
    }

    /**
     * Creates a new {@link Builder} for creating {@link ResourceKey}s. The builder
     * can be used for creating keys based on {@link PluginContainer}s, {@link Object}s
     * of plugins, and {@link String} namespaces.
     *
     * @return The new builder instance
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Creates a resource key.
     *
     * @param namespace The namespace
     * @param value The value
     * @return A new resource key
     */
    static ResourceKey of(final String namespace, final String value) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(Objects.requireNonNull(namespace, "mamespace"), Objects.requireNonNull(value, "value"));
    }

    /**
     * Creates a resource key.
     *
     * @param plugin The plugin
     * @param value The value
     * @return A new resource key
     */
    static ResourceKey of(final PluginContainer plugin, final String value) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(Objects.requireNonNull(plugin, "plugin"), Objects.requireNonNull(value, "value"));
    }

    /**
     * Resolves a resource key from a string.
     *
     * <p>If no namespace is found in {@code formatted} then
     * {@link #MINECRAFT_NAMESPACE} will be the namespace.</p>
     *
     * @param formatted The formatted string to parse
     * @return A new resource key
     */
    static ResourceKey resolve(final String formatted) {
        return Sponge.game().factoryProvider().provide(Factory.class).resolve(formatted);
    }

    /**
     * Gets this key as a formatted value.
     *
     * <p>It is up to the implementation to determine the formatting. In
     * vanilla Minecraft, keys are formatted as "namespace:value". For example,
     * "minecraft:carrot".</p>
     *
     * @return The key, formatted
     */
    default String formatted() {
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

    /**
     * A builder to create {@link ResourceKey}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<ResourceKey, Builder> {

        /**
         * Sets the key's namespace.
         *
         * <p>If using a {@link #MINECRAFT_NAMESPACE} or
         * {@link #SPONGE_NAMESPACE}, it is preferable to use
         * {@link ResourceKey#minecraft(String)} or
         * {@link ResourceKey#sponge(String)} instead.</p>
         *
         * @param namespace The namespace to use
         * @return This builder, for chaining
         */
        Builder namespace(String namespace);

        /**
         * Sets the key's namespace based on the provided
         * {@link PluginContainer}'s identifier.
         *
         * @param container The plugin container to fetch from
         * @return This builder, for chaining
         */
        default Builder namespace(PluginContainer container) {
            return this.namespace(container.getMetadata().getId());
        }

        /**
         * Sets the key's value.
         *
         * @param value The value to use
         * @return This builder, for chaining
         */
        Builder value(String value);

        /**
         * Builds the {@link ResourceKey}.
         *
         * @return The built resource key
         * @throws IllegalStateException If {@link Builder#namespace(String)} or {@link Builder#value(String)} are not set.
         */
        ResourceKey build() throws IllegalStateException;
    }

    /**
     * A factory to generate {@link ResourceKey}s.
     */
    interface Factory {

        ResourceKey of(String namespace, String value);

        ResourceKey of(PluginContainer plugin, String value);

        /**
         * Resolves a resource key from a string, using
         * {@link #MINECRAFT_NAMESPACE} if no namespace is found within
         * {@code formatted}.
         *
         * @param formatted The formatted string to parse
         * @return A new resource key
         */
        ResourceKey resolve(String formatted);
    }
}
