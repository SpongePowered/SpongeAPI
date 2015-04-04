package org.spongepowered.api.service.command.sponge;

import com.google.common.base.Optional;
import org.spongepowered.api.util.command.CommandSource;

import java.util.Set;

public interface AliasContext {

    Optional<CommandRegistrar> getRegistrar(String alias, CommandSource source, Set<CommandRegistrar> registrars);

}
