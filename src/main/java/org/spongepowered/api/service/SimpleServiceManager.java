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
import com.google.inject.Singleton;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * The default implementation of {@link ServiceManager}.
 */
@Singleton
public class SimpleServiceManager implements ServiceManager {

    private final ConcurrentMap<Class<?>, ProviderRegistration<?>> providers =
            new MapMaker().concurrencyLevel(3).makeMap();
    private final PluginManager pluginManager;

    /**
     * Construct a simple {@link ServiceManager}.
     *
     * @param pluginManager The plugin manager to get the
     *            {@link PluginContainer} for a given plugin
     */
    @Inject
    public SimpleServiceManager(PluginManager pluginManager) {
        checkNotNull(pluginManager, "pluginManager");
        this.pluginManager = pluginManager;
    }

    @Override
    public <T> void setProvider(Object plugin, Class<T> service, T provider) {
        checkNotNull(plugin, "plugin");
        checkNotNull(service, "service");
        checkNotNull(provider, "provider");

        Optional<PluginContainer> containerOptional = this.pluginManager.fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?)");
        }

        PluginContainer container = containerOptional.get();
        ProviderRegistration<?> oldProvider = this.providers.put(service, new Provider<>(container, service, provider));
        Object frame = Sponge.getCauseStackManager().pushCauseFrame();
        Sponge.getCauseStackManager().addContext(EventContextKeys.SERVICE_MANAGER, this);
        Sponge.getCauseStackManager().pushCause(container);
        Sponge.getEventManager().post(SpongeEventFactory.createChangeServiceProviderEvent(Sponge.getCauseStackManager().getCurrentCause(),
                this.providers.get(service), Optional.ofNullable(oldProvider)));
        Sponge.getCauseStackManager().popCauseFrame(frame);
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
    public <T> Optional<ProviderRegistration<T>> getRegistration(Class<T> service) {
        return Optional.ofNullable((ProviderRegistration<T>) this.providers.get(service));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        checkNotNull(service, "service");
        @Nullable ProviderRegistration<T> provider = (ProviderRegistration<T>) this.providers.get(service);
        if (provider == null) {
            throw new ProvisioningException("No provider is registered for the service '" + service.getName() + "'", service);
        }
        return provider.getProvider();
    }

    private static class Provider<T> implements ProviderRegistration<T> {

        private final PluginContainer container;
        private final Class<T> service;
        private final T provider;

        Provider(PluginContainer container, Class<T> service, T provider) {
            this.container = container;
            this.service = service;
            this.provider = provider;
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
        public PluginContainer getPlugin() {
            return this.container;
        }
    }

}
