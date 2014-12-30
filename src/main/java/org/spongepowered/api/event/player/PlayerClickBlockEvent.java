package org.spongepowered.api.event.player;

import org.spongepowered.api.util.Direction;

public interface PlayerClickBlockEvent extends PlayerClickEvent {
    /**
     * Gets the face of the block that was clicked.
     *
     * @return The face of the block that was clicked
     */
    Direction getClickedFace();
}
