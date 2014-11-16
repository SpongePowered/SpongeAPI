package org.spongepowered.api.event.player;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.misc.Achievements;

/**
 * Called when {@link Player} gains an achievement.
 */
public interface PlayerGainAchievementEvent extends PlayerEvent, Cancellable {
	
	/**
	 * Gives {@link Player} a selected achievement.
	 * 
	 * @param player The {@link Player} receiving the achievement
	 * @param achievement The {@link Achievements} being given
	 */
	void gainAchievement(Player player, Achievements achievement);
	
}
