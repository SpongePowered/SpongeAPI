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
package org.spongepowered.api.event.service;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.service.ProviderRegistration;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.Optional;

/**
 * Fired when the provider has been changed for a service in the {@link ServiceManager}.
 *
 * <p>This event is fired after the replacement has taken place. Calling
 * {@link ServiceManager#provideUnchecked(Class)} with the service will return
 * {@link #getNewProviderRegistration()}.</p>
 *
 * <p>This can occur when a provider is registered for a serivce for the first
 * time, or when the provider for a service is replaced.</p>
 */
public interface ChangeServiceProviderEvent extends Event {

    /**
     * Gets the previous provider registration for the service, if available
     *
     * <p>If a provider is being registered for the first time for the service,
     * this will return {@link Optional#empty()}.</p>
     *
     * <p>If this is present, then it will always have the same
     * provider as {@link #getNewProviderRegistration()}.</p>
     *
     * @return The previous provider registration, if available
     */
    Optional<ProviderRegistration<?>> getPreviousProviderRegistration();

    /**
     * Gets the new provider registration for the service.
     *
     * @return The new provider registration
     */
    ProviderRegistration<?> getNewProviderRegistration();

    /**
     * Gets whether a previous provider existed, which was replaced by the new
     * provider.
     *
     * @return Whether a provider was replaced.
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default boolean isReplacement() {
        return this.getPreviousProviderRegistration().isPresent();
    }

    /**
     * Gets the service that a provider is being registered for.
     *
     * @return The service
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default Class<?> getService() {
        return this.getNewProviderRegistration().getService();
    }

    /**
     * Gets the new provider being registered.
     *
     * @return The provider
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default Object getNewProvider() {
        return this.getNewProviderRegistration().getProvider();
    }

}
