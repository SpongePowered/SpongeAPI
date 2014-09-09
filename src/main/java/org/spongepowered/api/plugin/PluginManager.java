/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

import org.apache.logging.log4j.Logger;

import java.util.Collection;

public interface PluginManager {
    /**
     * Retrieves a {@link org.spongepowered.api.plugin.PluginContainer} based on its name.
     *
     * @param name The name
     * @return The plugin or null if not found
     */
    PluginContainer getPlugin(String name);

    /**
     * Gets the {@link org.apache.logging.log4j.Logger} for the {@link org.spongepowered.api.plugin.PluginContainer}.
     *
     * @param plugin The plugin
     * @return The logger
     */
    Logger getLogger(PluginContainer plugin);

    /**
     * Gets a {@link java.util.Collection} of all {@link org.spongepowered.api.plugin.PluginContainer}s
     *
     * @return The plugins
     */
    Collection<PluginContainer> getPlugins();
}
