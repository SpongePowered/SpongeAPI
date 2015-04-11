package org.spongepowered.api.service.command;

import com.google.common.base.Optional;
import org.spongepowered.api.util.command.CommandSource;

/**
 * 
 * A function that determines what plugin, by ID should be used for a command
 * when sent by a certain source.
 *
 */
public interface AliasContext {

    /**
     * Gets the ID of the plugin to be used for the specified source
     * 
     * @param source The source of the command
     * @return The ID, or {@link Optional#absent()} if normal handling should
     *         continue
     */
    Optional<String> getPluginId(CommandSource source);

}
