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
package org.spongepowered.api.event.lifecycle;

import org.spongepowered.api.Engine;
import org.spongepowered.api.event.GenericEvent;

import java.util.function.Supplier;

/**
 * An event that allows plugins to suggest their own implementation for a given
 * service.
 *
 * <p>Service providers should <strong>not</strong> construct the service object
 * prior to selection. Instead, they should wait for if, and only if, their
 * service factory as supplied in {@link #suggest(Supplier)} has been called.
 * Further, each plugin may only supply <strong>one</strong> service provider
 * for each service.</p>
 *
 * <p>It is not guaranteed that this event will fire for the indicated service
 * for a plugin that registers this listener. This may happen if the server
 * is configured to select a particular service, or that another plugin has
 * already been offered the chance to provide the implementation and has done
 * so.</p>
 *
 * @param <T> The service to provide.
 */
public interface ProvideServiceEvent<T> extends GenericEvent<T>, LifecycleEvent {

    /**
     * Provides a suggestion for the given service. <strong>This may only be
     * called once by any given plugin for a given service and event.</strong>
     *
     * @param serviceFactory A {@link Supplier} that can construct the service
     *      if this service is selected
     */
    void suggest(Supplier<T> serviceFactory);

    /**
     * Supplies a service that is scoped to the given {@link Engine}.
     *
     * <p>Engine scoped services have a lifetime of the attached Engine. If the
     * engine is restarted, plugins will be asked to provide a new service.</p>
     *
     * <p>It is up to the provider to determine which engine a service is to be
     * supplied for. Services that are engine scoped may not support all
     * engines. Plugins can check to see what {@link Engine} the service will
     * be provided for via the {@link #getEngine()} method, and can choose to
     * forgo providing a service based on this information.</p>
     *
     * @param <T> The service to provide.
     */
    interface EngineScoped<T> extends ProvideServiceEvent<T> {

        /**
         * Gets the {@link Engine} that is associated with this event.
         *
         * @return The engine.
         */
        Engine getEngine();

    }

}
