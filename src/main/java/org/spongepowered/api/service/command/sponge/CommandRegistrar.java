package org.spongepowered.api.service.command.sponge;

import java.util.Set;

public interface CommandRegistrar {

    Set<String> getPrefixes();

    String getName();

}
