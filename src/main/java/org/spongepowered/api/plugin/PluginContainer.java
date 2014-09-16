/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.plugin;

import org.spongepowered.api.configuration.Configuration;

import java.io.File;


/**
 * A wrapper around a class marked with an {@link Plugin} annotation to retrieve
 * information from the annotation for easier use.
 */
public interface PluginContainer {

    /**
     * Gets the id of the {@link Plugin} within this container.
     *
     * @return The id
     */
    String getID();

    /**
     * Gets the name of the {@link Plugin} within this container.
     *
     * @return The name
     */
    String getName();

    /**
     * Gets the version of the {@link Plugin} within this container.
     *
     * @return The name
     */
    String getVersion();

    /**
     * Returns the created instance of {@link Plugin}.
     *
     * @return The instance
     */
    Object getInstance();

    /**
     * Returns resource folder of the {@link org.spongepowered.api.plugin.Plugin} within this container.
     * 
     * @param createIfAbsent If true, creates folder if it doesn't exist on disk
     * @return The plugin's resource folder
     */
    File getResourceFolder(boolean createIfAbsent);

    /**
     * Gets the default config for the plugin.
     * 
     * TODO Document default config name
     * 
     * @return The default configuration
     */
    Configuration getConfiguration();

    /**
     * Gets a config with the given name.
     * 
     * @param name Name of the config.
     * @return A custom named configuration.
     */
    Configuration getConfiguration(String name);
}
