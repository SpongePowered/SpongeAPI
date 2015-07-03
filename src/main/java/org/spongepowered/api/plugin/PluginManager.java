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
package org.spongepowered.api.plugin;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.spongepowered.api.GameState;
import org.spongepowered.api.event.plugin.PluginLoadedEvent;
import org.spongepowered.api.event.plugin.PluginUnloadingEvent;
import org.spongepowered.api.event.state.StateEvent;

import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Set;

/**
 * The manager that manages plugins. This manager can retrieve
 * {@link PluginContainer}s from {@link Plugin} instances, getting
 * {@link Logger}s, etc.
 */
public interface PluginManager {

    /**
     * Get the plugin container from an instance.
     *
     * @param instance The instance
     * @return The container
     */
    Optional<PluginContainer> fromInstance(Object instance);

    /**
     * Retrieves a {@link PluginContainer} based on its ID.
     *
     * @param id The plugin ID
     * @return The plugin, if available
     */
    Optional<PluginContainer> getPlugin(String id);

    /**
     * Gets the {@link Logger} for the {@link PluginContainer}.
     *
     * @param plugin The plugin
     * @return The logger
     */
    Logger getLogger(PluginContainer plugin);

    /**
     * Gets a {@link Collection} of all {@link PluginContainer}s.
     *
     * @return The plugins
     */
    Collection<PluginContainer> getPlugins();

    /**
     * Checks if a plugin is loaded based on its ID.
     * This may contain plugins/mods from other systems in some implementations.
     *
     * @param id the id of the {@link Plugin}
     * @return {@code true} if loaded {@code false} if not loaded.
     */
    boolean isLoaded(String id);

    // TODO Sponge team: Would you prefer the following two methods in another interface à la DynamicPluginManager extends PluginManager, which some (Vanilla) but not all (other) implement, or is this OK like this?

    /**
     * Load an additional plugin instance.
     * 
     * This will fire a {@link PluginLoadedEvent} (but NOT the {@link StateEvent} notifications for {@link GameState}, because the Game may already be running since a long time).
     *
     * @param pluginClass some class annotated with {@link Plugin}
     * @param source some identification of where this pluginClass is from, just for logging
     * @return the {@link PluginContainer} descriptor for this Plugin
     */
	PluginContainer loadPlugin(Class<?> pluginClass, String source);

    /**
     * Load additional plugins, by finding all annotated Plugin classes.
     * 
     * This will fire a {@link PluginLoadedEvent} (but NOT the {@link StateEvent} notifications for {@link GameState}, because the Game may already be running since a long time).
     *
     * @param classLoader a ClassLoader to scan for classes annotated with {@link Plugin}
     * @return the {@link PluginContainer}s which were successfully loaded from the given ClassLoader
     */
	Set<PluginContainer> loadPlugins(URLClassLoader classLoader);

	/**
	 * Unload a previously loaded plugin.
	 * 
	 * This will fire a {@link PluginUnloadingEvent} (but NOT the {@link StateEvent} notifications for {@link GameState}, because the Game may continue running long after).
	 * 
	 * @param pluginContainer the {@link PluginContainer} to unload
	 * @return {@code true} if successfully unloaded, {@code false} if not
	 */
	boolean unloadPlugin(PluginContainer pluginContainer);

}
