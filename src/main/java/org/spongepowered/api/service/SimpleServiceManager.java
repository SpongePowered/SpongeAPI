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
package org.spongepowered.api.service;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.MapMaker;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * The default implementation of {@link ServiceManager}.
 */
public class SimpleServiceManager implements ServiceManager {

    private final ConcurrentMap<Class<?>, ProviderRegistration<?>> providers =
            new MapMaker().concurrencyLevel(3).makeMap();
    private final PluginManager pluginManager;

    /**
     * Construct a simple {@link ServiceManager}.
     * @param pluginManager
     */
    @Inject
    public SimpleServiceManager(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public <T> void setProvider(Object plugin, Class<T> service, T provider) {
        checkNotNull(plugin, "plugin");
        checkNotNull(service, "service");
        checkNotNull(provider, "provider");
        Optional<PluginContainer> container = this.pluginManager.fromInstance(plugin);
        if (!container.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?)");
        }
        Cause cause = Cause.of(NamedCause.source(container));
        ProviderRegistration<?> oldProvider = this.providers.put(service, new Provider<>(service, provider, cause));
        Sponge.getEventManager().post(SpongeEventFactory.createChangeServiceProviderEvent(cause, this.providers.get(service),
                Optional.ofNullable(oldProvider)));
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> provide(Class<T> service) {
        checkNotNull(service, "service");
        @Nullable ProviderRegistration<T> provider = (ProviderRegistration<T>) this.providers.get(service);
        return provider != null ? Optional.of(provider.getProvider()) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> provideFirst(Class<T> service) {
        checkNotNull(service, "service");
        for (Map.Entry<Class<?>, ProviderRegistration<?>> entry : this.providers.entrySet()) {
            Class<?> s = entry.getKey();
            ProviderRegistration<?> provider = entry.getValue();
            if (s.isAssignableFrom(service)) {
                return Optional.of((T) provider.getProvider());
            }
        }
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<ProviderRegistration<T>> getRegistration(Class<T> service) {
        return Optional.ofNullable((ProviderRegistration) this.providers.get(service));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        checkNotNull(service, "service");
        @Nullable ProviderRegistration<T> provider = (ProviderRegistration<T>) this.providers.get(service);
        if (provider != null) {
            return provider.getProvider();
        } else {
            throw new ProvisioningException("No provider is registered for the service '" + service.getName() + "'", service);
        }
    }

    private static class Provider<T> implements ProviderRegistration<T> {

        private final Class<T> service;
        private final T provider;
        private final Cause cause;

        private Provider(Class<T> service, T provider, Cause cause) {
            this.service = service;
            this.provider = provider;
            this.cause = cause;
        }

        @Override
        public Class<T> getService() {
            return this.service;
        }

        @Override
        public T getProvider() {
            return this.provider;
        }

        @Override
        public Cause getCause() {
            return this.cause;
        }
    }

}
