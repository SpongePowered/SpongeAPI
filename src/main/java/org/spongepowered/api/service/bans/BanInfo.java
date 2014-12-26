package org.spongepowered.api.service.bans;

import java.util.UUID;

public interface BanInfo {

	/**
	 * Gets the UUID of the player.
	 *
	 * @return The UUID of the player.
	 */
	UUID getUniqueIdentifier();

	/**
	 * Gets the name of the player.
	 *
	 * @return The name of the player.
	 */
	String getName();

	/**
	 * Gets the date of the ban.
	 *
	 * @return Creation date of the ban
	 */
	String getDateBanned();

	/**
	 * Gets the player who banned the player; returns "Server" if done from console.
	 *
	 * @return Banning player.
	 */
	String getSource();

	/**
	 * Gets the expiration time, formatted in long; if forever returns 0
	 *
	 * @return Expiration time of the ban.
	 */
	long getExpiration();

	/**
	 * Get the reason for the ban.
	 *
	 * @return The reason specified for the ban.
	 */
	String getReason();

}
