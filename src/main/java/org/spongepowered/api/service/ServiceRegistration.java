package org.spongepowered.api.service;

import org.spongepowered.plugin.PluginContainer;

/**
 * Provides information about the registration of a service.
 *
 * @param <T> The type of service
 */
public interface ServiceRegistration<T> {

    /**
     * A {@link Class} that represents the service that has been implemented.
     *
     * @return A {@link Class}
     */
    Class<T> serviceClass();

    /**
     * The implementation of the service.
     *
     * @return The implementation
     */
    T service();

    /**
     * The {@link PluginContainer} that registered the service.
     *
     * @return The {@link PluginContainer}
     */
    PluginContainer pluginContainer();

}
