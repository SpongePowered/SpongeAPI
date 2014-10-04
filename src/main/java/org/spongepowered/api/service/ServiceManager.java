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

import org.spongepowered.api.util.Owner;

import javax.annotation.Nullable;

/**
 * A manager of services and their providers.
 *
 * <p>A <em>service</em> is a standard interface or class. A <em>provider</em>
 * is an implementation of that service. A manager tracks registered providers
 * with the service(s) that the provider implements.</p>
 *
 * <p>Providers are registered at runtime using
 * {@link #setProvider(Class, Object, boolean, Owner)}. Only one provider
 * can be registered for each service, but a provider can be marked as
 * replaceable if it can be replaced with a new provider.</p>
 */
public interface ServiceManager {

    /**
     * Register a provider with the service manager.
     *
     * <p>If a provider already exists for the given service, it will be
     * replaced if was flagged as replaceable. Otherwise, a
     * {@link ProviderExistsException} will be thrown. Plugins should provide
     * options to not install their providers if the plugin is not dedicated
     * to a single function (such as purely authorization).</p>
     *
     * <p>Services should only be registered during initialization. If services
     * are registered later, then they may not be utilized.</p>
     *
     * @param service The service
     * @param provider The implementation
     * @param replaceable Whether this provider can be replaced with another
     * @param owner The owner of the service
     * @param <T> The type of service
     * @throws ProviderExistsException Thrown if a provider already exists
     *                                 and cannot be replaced
     */
    <T> void setProvider(Class<T> service, T provider, boolean replaceable, Owner owner) throws ProviderExistsException;

    /**
     * Return a provider for the given service, if one is available.
     *
     * <p>The returned provider may be a proxy to the real underlying proxy,
     * depending on the implementation of the service manager.</p>
     *
     * @param service The service
     * @param <T> The type of service
     * @return A provider, or null if one is not registered
     */
    @Nullable
    <T> T provide(Class<T> service);

}
