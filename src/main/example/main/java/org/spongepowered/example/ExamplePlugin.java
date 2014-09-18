package org.spongepowered.example;

import org.apache.logging.log4j.Logger;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.ConstructionEvent;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.voxel.VoxelEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    Logger logger;
    @SpongeEventHandler
    public void onConstruction(PreInitializationEvent event) {
        logger = event.getPluginLog();
        logger.info("Hey folks, this is PRE-INITIALIZATION!");
    }

    @SpongeEventHandler
    public void onServerStarting(ServerStartingEvent event) {
        logger.info("Hey...my implementation's server is starting?");
    }
    
    @SpongeEventHandler
    public void onVoxelEvent(VoxelEvent event) {
        logger.info("A Block was broken");
    }
}
