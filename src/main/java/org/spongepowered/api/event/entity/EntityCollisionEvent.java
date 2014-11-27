package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.util.event.Cancellable;

/**
 * Called when an {@link Entity} collides with something.
 */
public interface EntityCollisionEvent extends EntityEvent, Cancellable, CauseTracked {

}
