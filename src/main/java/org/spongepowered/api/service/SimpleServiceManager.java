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

package org.spongepowered.api.service;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;
import com.google.common.collect.MapMaker;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class SimpleServiceManager implements ServiceManager {

    private final ConcurrentMap<Class<?>, Provider> providers =
            new MapMaker().concurrencyLevel(3).makeMap();
    private final PluginManager pluginManager;

    @Inject
    public SimpleServiceManager(PluginManager pluginManager) {
        checkNotNull(pluginManager, "pluginManager");
        this.pluginManager = pluginManager;
    }

    @Override
    public <T> void setProvider(Object plugin, Class<T> service, T provider) throws ProviderExistsException {
        checkNotNull(plugin, "plugin");
        checkNotNull(service, "service");
        checkNotNull(provider, "provider");

        Optional<PluginContainer> containerOptional = pluginManager.fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?");
        }

        PluginContainer container = containerOptional.get();

        providers.put(service, new Provider(container, provider));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> provide(Class<T> service) {
        checkNotNull(service, "service");
        @Nullable Provider provider = providers.get(service);
        return provider != null ? (Optional<T>) Optional.of(provider.provider) : Optional.<T>absent();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        checkNotNull(service, "service");
        @Nullable Provider provider = providers.get(service);
        if (provider != null) {
            return (T) provider.provider;
        } else {
            throw new ProvisioningException("No provider is registered for the service '" + service.getName() + "'", service);
        }
    }

    private static class Provider {
        private final PluginContainer container;
        private final Object provider;

        private Provider(PluginContainer container, Object provider) {
            this.container = container;
            this.provider = provider;
        }
    }

}
