package org.spongepowered.api.event.resource;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.resource.pack.Pack;
import org.spongepowered.api.resource.pack.PackList;

/**
 * Base {@link Pack} event.
 */
public interface PackEvent extends Event {

    PackList getPackList();

}
