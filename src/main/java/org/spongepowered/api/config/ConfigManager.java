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
package org.spongepowered.api.config;

import org.spongepowered.configurate.reference.WatchServiceListener;
import org.spongepowered.configurate.serialize.TypeSerializerCollection;
import org.spongepowered.plugin.PluginContainer;

/**
 * Provides configuration for plugins.
 *
 * <p>Plugins can choose between two places to store their configuration:</p>
 *
 * <ul>
 *     <li>A shared configuration folder, which is preferred for plugins with
 *     little configuration. These plugins can simply use {@code plugin_id.conf}.</li>
 *     <li>A configuration folder specific for the plugin, which is preferred
 *     for plugins with a lot of configuration data.</li>
 * </ul>
 *
 * <p>In either case, a "default configuration file" is provided in both
 * scenarios. It is not required that plugins use this, but it does ensure
 * consistency.</p>
 *
 * <p>Call either {@link #getSharedConfig(PluginContainer)} or
 * {@link #getPluginConfig(PluginContainer)} to get an object that represents one of
 * the two outlined choices.</p>
 */
public interface ConfigManager {

    /**
     * Gets the configuration root for a plugin that utilizes the shared
     * configuration folder.
     *
     * <p>The shared configuration folder <em>may</em> refer to
     * "config/" but this may vary between implementations and
     * configurations.</p>
     *
     * <p>The plugin parameter is used to determine the filename for
     * {@link ConfigRoot#getConfigPath()}.</p>
     *
     * @param plugin The plugin instance
     * @return A shared configuration root
     */
    ConfigRoot getSharedConfig(PluginContainer plugin);

    /**
     * Gets the configuration root for a plugin that utilizes a configuration
     * folder specific to the plugin, which <em>may</em> also be a
     * sub-directory of the shared configuration folder.
     *
     * <p>The provided plugin is used to determine the folder name.</p>
     *
     * @param plugin The plugin instance
     * @return A plugin-specific configuration root
     */
    ConfigRoot getPluginConfig(PluginContainer plugin);

    /**
     * Get a type serializer collection supporting Sponge types.
     *
     * <p>This collection is expected to handle:</p>
     * <ul>
     *     <li>Every type built-in to Configurate</li>
     *     <li>Registered subtypes of {@link org.spongepowered.api.CatalogType}</li>
     *     <li>{@link org.spongepowered.api.ResourceKey}s</li>
     *     <li>Registered implementations of {@link org.spongepowered.api.data.persistence.DataSerializable}</li>
     *     <li>All Adventure types including {@link net.kyori.adventure.text.Component}</li>
     *     <li>Any type with a {@link org.spongepowered.api.data.persistence.DataTranslator} (see
     *         {@link org.spongepowered.api.data.persistence.DataTranslators})</li>
     * </ul>
     *
     * @return A type serializer collection aware of Sponge serializers
     */
    TypeSerializerCollection getSerializers();

    /**
     * Get a file watch listener using the game executor.
     *
     * <p>This can be used to get {@link org.spongepowered.configurate.reference.ConfigurationReference auto-reloading references}
     * to configuration files.</p>
     *
     * @return The game watch service listener
     */
    WatchServiceListener getWatchServiceListener();

}
