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

import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurationOptions;
import org.spongepowered.configurate.loader.ConfigurationLoader;

import java.nio.file.Path;

/**
 * A configuration root is a representation of where configuration
 * data can be stored, which is ultimately mapped to a directory on disk.
 *
 * <p>The underlying directory may refer to a shared directory (shared
 * by many plugins) or one that is specific to a plugin. Be mindful
 * of simply storing data in {@link #getDirectory()} depending on the
 * type of configuration root.</p>
 *
 * <p>A default configuration file is provided via both
 * {@link #getConfigPath()} and {@link #getConfig()}, but other or additional
 * configuration files can be stored in the directory returned by
 * {@link #getDirectory()} (as long as it's
 * not the shared configuration folder).</p>
 *
 * @see ConfigManager A provider of configuration root
 */
public interface ConfigRoot {

    /**
     * Gets the pathname to the default configuration file for the plugin.
     *
     * <p>If the configuration root is shared, then the returned pathname will
     * refer to the path {@code $config/$plugin_id.conf} (where "$config" is the
     * shared configuration directory). Otherwise, the returned pathname will
     * refer to a file named "config.conf" stored in a directory specific to
     * the plugin.</p>
     *
     * <p>The returned pathname may refer to a file that does not yet exist.
     * It is up to the caller of this method to create the file if desired.</p>
     *
     * @return A file, which may not yet exist
     * @see DefaultConfig
     */
    Path getConfigPath();

    /**
     * Gets the configuration file that utilizes the default configuration
     * pathname.
     *
     * <p>The returned loader will default to using options that:</p>
     * <ul>
     *     <li>Copy default values to the configuration</li>
     *     <li>Implicitly initialize values (so will provide an empty value if
     *     no default is provided)</li>
     *     <li>Use the Sponge default {@link org.spongepowered.configurate.serialize.TypeSerializer TypeSerializers},
     *     as described in {@link ConfigManager#getSerializers()}.</li>
     * </ul>
     *
     * @return A configuration object
     * @see #getConfigPath()
     */
    ConfigurationLoader<CommentedConfigurationNode> getConfig();

    /**
     * Gets the configuration file that utilizes the default configuration
     * pathname.
     *
     * <p>The returned loader will default to using the provided options.</p>
     *
     * @param options Default options to be used when loading
     * @return A configuration object
     * @see #getConfigPath()
     */
    ConfigurationLoader<CommentedConfigurationNode> getConfig(final ConfigurationOptions options);

    /**
     * Gets the directory that this configuration root refers to.
     *
     * <p>The returned pathname may not refer to a directory that exists
     * yet.</p>
     *
     * @return A directory
     */
    Path getDirectory();
}
