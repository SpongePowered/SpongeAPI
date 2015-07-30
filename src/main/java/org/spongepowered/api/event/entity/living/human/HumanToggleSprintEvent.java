package org.spongepowered.api.event.entity.living.human;

import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.event.Cancellable;

/**
 * Called when a {@link Human} changes to/from sprint.
 */
public interface HumanToggleSprintEvent extends HumanEvent, Cancellable{
	boolean isNowSprinting();
}
