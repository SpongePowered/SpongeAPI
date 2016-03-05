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

import java.util.Optional;

/**
 * A manager of services and their providers.
 *
 * <p>A <em>service</em> is a standard interface or class. A <em>provider</em>
 * is an implementation of that service. A manager tracks registered providers
 * with the service(s) that the provider implements.</p>
 *
 * <p>Providers are registered at runtime using
 * {@link #setProvider(Object, Class, Object)}. Only one provider
 * can be registered for each service, but a provider can be marked as
 * replaceable if it can be replaced with a new provider.</p>
 */
public interface ServiceManager {

    /**
     * Register a provider with the service manager.
     *
     * <p>Services are by definition replaceable at any given time.</p>
     *
     * <p>Services should only be registered during initialization. If services
     * are registered later, then they may not be utilized.</p>
     *
     * @param <T> The type of service
     * @param plugin The cause of the provider change.
     * @param service The service
     * @param provider The implementation
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a
     *     plugin instance
     */
    <T> void setProvider(Object plugin, Class<T> service, T provider);

    /**
     * Return a provider for the given service, if one is available.
     *
     * <p>The returned provider may be a proxy to the real underlying proxy,
     * depending on the implementation of the service manager.</p>
     *
     * @param service The service
     * @param <T> The type of service
     * @return A provider, if available
     */
    <T> Optional<T> provide(Class<T> service);

    /**
     * Returns the first provider that is derived from the specified service.
     *
     * @param service The service
     * @param <T> The type of service
     * @return A provider, if available
     */
    <T> Optional<T> provideFirst(Class<T> service);

    /**
     * Gets the {@link ProviderRegistration} for the given service, if available.
     *
     * @param service The service
     * @param <T> The type of service
     * @return The {@link ProviderRegistration}, if available.
     */
    <T> Optional<ProviderRegistration<T>> getRegistration(Class<T> service);

    /**
     * Gets whether the class of the type of service is already registered with
     * this manager. This does not register or unregister any services.
     *
     * @param service The service class
     * @return True if there is a provider for the desired service
     */
    default boolean isRegistered(Class<?> service) {
        return provide(service).isPresent();
    }

    /**
     * Return a provider for the given service, raising an unchecked exception
     * if a provider does not exist.
     *
     * <p>The returned provider may be a proxy to the real underlying proxy,
     * depending on the implementation of the service manager.</p>
     *
     * @param service The service
     * @param <T> The type of service
     * @return A provider
     * @throws ProvisioningException Thrown if a provider cannot be provisioned
     */
    <T> T provideUnchecked(Class<T> service) throws ProvisioningException;

}
