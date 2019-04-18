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

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Scopes;

import java.util.Optional;

/**
 * Represents a adapter for plugins. Adapters can be used to add support
 * to other programming languages for better support, to modify the
 * default instantiation behavior to add custom injections, etc.
 *
 * <p>A plugin needs to specify this in the {@link Plugin} annotation.</p>
 *
 * <p>The plugin adapter will be constructed globally by a
 * {@link Injector}. All injections that aren't plugin specific will
 * be available for the {@link PluginAdapter}.</p>
 */
public interface PluginAdapter {

    /**
     * Creates the global {@link Module} that will be used to construct
     * all plugin specific {@link Injector}s. The returned module will be
     * used to construct the plugin defined {@link Module}s.
     *
     * <p>All implicitly constructed objects for plugin defined modules
     * by this global module won't be retained when it's passed into the
     * plugin {@link Injector}. Everything that should be retained has
     * to be manually bound in the module.</p>
     *
     * @param defaultModule De default module
     * @return The global injector
     */
    default Module createGlobalModule(Module defaultModule) {
        return defaultModule;
    }

    /**
     * Creates the {@link Module} that will be used to construct a plugin instance. Proper
     * bindings should be applied to the {@link Module} so that
     * {@code injector.getInstance(pluginClass)} will return the plugin instance.
     *
     * <p>The provided default {@link Module} contains the default module and
     * all the plugin provided {@link Module}s.</p>
     *
     * <p>A {@link Scopes#SINGLETON singleton} scope is expected for the plugin instance, a
     * {@link IllegalStateException} will be thrown when constructing if this
     * isn't the case.</p>
     *
     * <p>Calling {@link PluginContainer#getInstance()} during the module construction
     * will always result in {@link Optional#empty()}.</p>
     *
     * @param pluginContainer The plugin container the injector is being created for
     * @param pluginClass The plugin class
     * @param defaultModule The default module
     * @return The plugin module
     */
    <T> Module createPluginModule(PluginContainer pluginContainer, Class<T> pluginClass, Module defaultModule);

    /**
     * Represents the default {@link PluginAdapter}.
     */
    interface Default extends PluginAdapter {
    }
}
