package org.spongepowered.example;

import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.SpongeInitializedEvent;
import org.spongepowered.api.event.state.SpongeServerStartingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    @SpongeEventHandler
    public void onInitialized(SpongeInitializedEvent event) {
        event.game.getLogger().info("Hey folks, I'm initialized!");
    }

    @SpongeEventHandler
    public void onServerStarting(SpongeServerStartingEvent event) {
        event.game.getLogger().info("Hey...my implementation's server is starting?");
    }
}
