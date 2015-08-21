package org.spongepowered.api.event.server;

import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.Server;

/**
 * Base event where a {@link Server} is the source.
 */
public interface ServerEvent extends GameEvent {

    Server getServer();
}
