package org.spongepowered.api.event.player;

public interface TeleportEvent {
	
	/**
	 * Gets the reason for teleportation.
	 * 
	 * @return The reason for teleportation.
	 */
	TeleportReason getReason();
	
	/**
	 * The possible reasons for a player being teleported.
	 */
	public enum TeleportReason {
		/**
		 * The player was teleported by an execute of a command.
		 */
		COMMAND,
		
		/**
		 * The player was teleported by entering an end portal.
		 */
		END_PORTAL,
		
		/**
		 * The player was teleported by the launching of an ender pearl.
		 */
		ENDER_PEARL,
		
		/**
		 * The player was teleported by entering a nether portal.
		 */
		NETHER_PORTAL,
		
		/**
		 * The player was teleported by an external plugin.
		 */
		PLUGIN
	}
}
