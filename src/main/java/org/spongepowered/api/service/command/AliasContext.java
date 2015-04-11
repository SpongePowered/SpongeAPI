package org.spongepowered.api.service.command;

import com.google.common.base.Optional;
import org.spongepowered.api.util.command.CommandSource;


public interface AliasContext {

    Optional<String> getPluginId(CommandSource source);

}
