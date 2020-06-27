package org.spongepowered.api.event.service;

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
public interface ProvideServiceEvent<T> extends GenericEvent<T> {

    /**
     * Provides a suggestion for the given service. <strong>This may only be
     * called once by any given plugin for a given service.</strong>
     *
     * @param serviceFactory A {@link Supplier} that can construct the service
     *      if this service is selected
     */
    void suggest(Supplier<T> serviceFactory);

}
