package org.spongepowered.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Platform;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginManager;

public final class SpongeGame implements Game {
    private final Logger logger = LogManager.getLogger("sponge");

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public Platform getPlatform() {
        return null;
    }

    @Override
    public PluginManager getPluginManager() {
        return null;
    }

    @Override
    public EventManager getEventManager() {
        return null;
    }
}
