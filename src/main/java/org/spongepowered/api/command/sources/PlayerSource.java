package org.spongepowered.api.command.sources;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.Player;

/**
 * A player that executed a command. 
 * Further implementation will be added later on.
 */
public class PlayerSource implements CommandSource {

	/** The {@link Player} that send the command. */
	private Player sender;
	
	/**
	 * The source of a command coming from a player.
	 * 
	 * @param sender The player who send the command.
	 */
	public PlayerSource(Player sender) {
		this.sender = sender;
	}
	
	/**
	 * Gets the {@link Player} that sent the command.
	 * @return Player the sender
	 */
	public Player getSender() {
		return sender;
	}
	
}
