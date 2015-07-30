package org.spongepowered.api.event.entity.player;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.entity.living.human.HumanMoveEvent;

/**
 * Called when a {@link Player} changes to/from sprint.
 */
public interface PlayerToggleSprintEvent extends PlayerEvent, HumanToggleSprintEvent {

}
