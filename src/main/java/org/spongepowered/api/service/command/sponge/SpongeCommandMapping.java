package org.spongepowered.api.service.command.sponge;

import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.ImmutableCommandMapping;

import java.util.Collection;

public class SpongeCommandMapping extends ImmutableCommandMapping {

    private String registrar;

    public SpongeCommandMapping(CommandCallable callable, String primary, String registrar, Collection<String> aliases) {
        super(callable, primary, aliases);
        this.registrar = registrar;
    }

    public SpongeCommandMapping(CommandCallable callable, String primary, String registrar, String... aliases) {
        super(callable, primary, aliases);
        this.registrar = registrar;
    }

    public String getRegistrar() {
        return registrar;
    }
}
