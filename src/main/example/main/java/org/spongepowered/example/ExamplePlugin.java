package org.spongepowered.example;

import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.SpongeInitializationEvent;
import org.spongepowered.api.event.state.SpongeServerStartingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    @SpongeEventHandler
    public void onInitialization(SpongeInitializationEvent event) {
        event.game.getLogger().info("Hey folks, this is INITIALIZATION!");
    }

    @SpongeEventHandler
    public void onServerStarting(SpongeServerStartingEvent event) {
        event.game.getLogger().info("Hey...my implementation's server is starting?");
    }
}
