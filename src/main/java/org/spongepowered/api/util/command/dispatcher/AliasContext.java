package org.spongepowered.api.util.command.dispatcher;

import org.spongepowered.api.util.command.CommandSource;

public interface AliasContext {
	
	/**
	 * Gets if this alias context should be used when running from the specified command source.
	 * @param source The command source to check.
	 * @return If this alias context should be used when running from the specified command source.
	 */
	public boolean appliesTo(CommandSource source);
	
	/**
	 * Gets the ID of the plugin to use when running from the specified command source.
	 * @param source The command source to check.
	 * @return The ID of the plugin to use when running from the specified command source.
	 */
	public String getPluginId(CommandSource source);
	
}
