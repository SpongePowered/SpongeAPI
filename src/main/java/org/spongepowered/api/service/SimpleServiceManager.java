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
import com.google.common.base.Predicate;
import com.google.common.collect.MapMaker;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * The default implementation of {@link ServiceManager}.
 */
public class SimpleServiceManager implements ServiceManager {

    private final ConcurrentMap<Class<?>, Provider> providers =
            new MapMaker().concurrencyLevel(3).makeMap();
    private final ConcurrentMap<Class<?>, SimpleServiceReference<?>> potentials =
            new MapMaker().concurrencyLevel(3).weakKeys().makeMap();
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
    public <T> void setProvider(Object plugin, Class<T> service, T provider) throws ProviderExistsException {
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

        Provider existing = this.providers.putIfAbsent(service, new Provider(container, provider));
        if (existing != null) {
            throw new ProviderExistsException("Provider for service " + service.getCanonicalName() + " has already been registered!");
        }
        @SuppressWarnings("unchecked")
        SimpleServiceReference<T> ref = (SimpleServiceReference<T>) this.potentials.remove(service);
        if (ref != null) {
            ref.registered(provider);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ServiceReference<T> potentiallyProvide(Class<T> service) {
        SimpleServiceReference<T> ref = new SimpleServiceReference<T>(provide(service));
        @SuppressWarnings("rawtypes")
        SimpleServiceReference newRef = this.potentials.putIfAbsent(service, ref);
        if (newRef != null) {
            ref = newRef;
        }
        if (ref.ref().isPresent()) {
            this.potentials.remove(service, ref);
        }
        return ref;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> provide(Class<T> service) {
        checkNotNull(service, "service");
        @Nullable Provider provider = this.providers.get(service);
        return provider != null ? (Optional<T>) Optional.of(provider.provider) : Optional.<T>absent();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        checkNotNull(service, "service");
        @Nullable Provider provider = this.providers.get(service);
        if (provider != null) {
            return (T) provider.provider;
        } else {
            throw new ProvisioningException("No provider is registered for the service '" + service.getName() + "'", service);
        }
    }

    private static class Provider {

        @SuppressWarnings("unused")
        private final PluginContainer container;
        private final Object provider;

        private Provider(PluginContainer container, Object provider) {
            this.container = container;
            this.provider = provider;
        }
    }

    private static class SimpleServiceReference<T> implements ServiceReference<T> {

        private final List<Predicate<T>> actionsOnPresent = new CopyOnWriteArrayList<Predicate<T>>();
        private final Lock waitLock = new ReentrantLock();
        private final Condition waitCondition = this.waitLock.newCondition();
        private volatile Optional<T> service;

        public SimpleServiceReference(Optional<T> service) {
            this.service = service;
        }

        @Override
        public Optional<T> ref() {
            return this.service;
        }

        @Override
        public T await() throws InterruptedException {
            while (true) {
                this.waitLock.lock();
                try {
                    Optional<T> service = this.service;
                    if (service.isPresent()) {
                        return service.get();
                    }
                    this.waitCondition.await();
                } finally {
                    this.waitLock.unlock();
                }
            }
        }

        @Override
        public void executeWhenPresent(Predicate<T> run) {
            if (!this.service.isPresent()) {
                this.actionsOnPresent.add(run);
            } else {
                run.apply(this.service.get());
            }
        }

        public void registered(T service) {
            this.service = Optional.of(service);
            this.waitLock.lock();
            try {
                this.waitCondition.signalAll();
            } finally {
                this.waitLock.unlock();
            }
            for (Predicate<T> func : this.actionsOnPresent) {
                func.apply(service);
            }
            this.actionsOnPresent.clear();

        }
    }

}
