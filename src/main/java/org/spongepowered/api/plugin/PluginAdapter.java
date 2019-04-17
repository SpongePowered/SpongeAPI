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

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * Represents a adapter for plugins. Adapters can be used to add support
 * to other programming languages for better support, to modify the
 * default instantiation behavior to add custom injections, etc.
 *
 * <p>A plugin needs to specify this in the {@link Plugin} annotation.</p>
 *
 * <p>A plugin adapter requires a empty and public constructor.</p>
 */
public interface PluginAdapter {

    /**
     * Gets the {@link Injector} that will be used to construct a plugin using
     * this adapter.
     *
     * <p>Calling {@link PluginContainer#getInstance()} during this
     * method will result in a {@link IllegalStateException}.</p>
     *
     * @param pluginContainer The plugin container the injector is being created for
     * @param defaultInjector The default injector
     * @param pluginClass The plugin class
     * @return The injector
     */
    <T> Injector getInjector(PluginContainer pluginContainer, Injector defaultInjector, Class<T> pluginClass);

    /**
     * Gets the plugin instance for the target plugin.
     *
     * <p>Calling {@link PluginContainer#getInstance()} during this
     * method will result in a {@link IllegalStateException}.</p>
     *
     * @param pluginContainer The plugin container
     * @param injector The injector that should be used to populate the plugin with injections
     * @param pluginClass The plugin class
     * @return The plugin instance
     */
    <T> T getInstance(PluginContainer pluginContainer, Injector injector, Class<T> pluginClass);

    /**
     * Represents the default {@link PluginAdapter}.
     */
    final class Default implements PluginAdapter {

        @Override
        public <T> Injector getInjector(PluginContainer pluginContainer, Injector defaultInjector, Class<T> pluginClass) {
            final Module module = new AbstractModule() {
                @Override
                protected void configure() {
                    bind(pluginClass).in(Scopes.SINGLETON);
                }
            };
            return defaultInjector.createChildInjector(module);
        }

        @Override
        public <T> T getInstance(PluginContainer pluginContainer, Injector injector, Class<T> pluginClass) {
            return injector.getInstance(pluginClass);
        }
    }
}
