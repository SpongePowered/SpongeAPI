package org.spongepowered.api.event.lifecycle;

import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.DataRegistration;

/**
 * Lifecycle event for registering custom {@link DataRegistration data} within the {@link DataManager}.
 */
public interface RegisterDataEvent extends LifecycleEvent {

    RegisterDataEvent register(DataRegistration registration);
}
