package org.spongepowered.example;

import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    @SpongeEventHandler
    public void onInitialization(InitializationEvent event) {
        event.getGame().getLogger().info("Hey folks, this is INITIALIZATION!");
    }

    @SpongeEventHandler
    public void onServerStarting(ServerStartingEvent event) {
        event.getGame().getLogger().info("Hey...my implementation's server is starting?");
    }
}
