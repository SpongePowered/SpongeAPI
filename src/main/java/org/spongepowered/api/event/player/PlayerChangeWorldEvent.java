package org.spongepowered.api.event.player;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.world.World;

/**
 * Called when the {@link Player} changes {@link World}.
 */
public interface PlayerChangeWorldEvent extends PlayerEvent, Cancellable {

    /**
     * Gets the {@link World} the player is leaving.
     *
     * @return The from world.
     */
    World getFromWorld();

    /**
     * Gets the {@link World} the player is entering.
     *
     * @return The to world.
     */
    World getToWorld();
}
