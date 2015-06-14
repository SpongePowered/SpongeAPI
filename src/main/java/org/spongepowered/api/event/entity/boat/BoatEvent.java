package org.spongepowered.api.event.entity.boat;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.event.entity.EntityEvent;

/**
 * A event whose target happens to be a {@link Boat}.
 */
public interface BoatEvent extends EntityEvent {

    /**
     * Get the {@link Boat} associated with this event.
     *
     * @return The boat associated with this event.
     */
    Boat getBoat();

    /**
     * Get the {@link Entity} that is on the boat. If no entities are on the
     * boat, {@link Optional#absent()} is used.
     *
     * @return The entity on the boat, if any
     */

    @Override
    Entity getEntity();
}
