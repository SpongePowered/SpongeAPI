package org.spongepowered.api.event.entity.boat;

import org.spongepowered.api.world.Location;

/**
 * An event that is fired when a boat collides with an object
 */
public interface BoatCrashEvent extends BoatEvent {

    /**
     * Get the location where the boat crashed.
     *
     * @return The location
     */
    Location getLocation();
}
