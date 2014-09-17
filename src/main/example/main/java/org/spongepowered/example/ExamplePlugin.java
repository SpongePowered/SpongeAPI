package org.spongepowered.example;

import org.apache.logging.log4j.Logger;
import org.spongepowered.api.event.EventHandler;
import org.spongepowered.api.event.state.ConstructionEvent;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.voxel.VoxelEvent;
import org.spongepowered.api.plugin.SpongePlugin;

@SpongePlugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    Logger logger;
    @EventHandler
    public void onConstruction(PreInitializationEvent event) {
        logger = event.getPluginLog();
        logger.info("Hey folks, this is PRE-INITIALIZATION!");
    }

    @EventHandler
    public void onServerStarting(ServerStartingEvent event) {
        logger.info("Hey...my implementation's server is starting?");
    }
    
    @EventHandler
    public void onVoxelEvent(VoxelEvent event) {
        logger.info("A Block was broken");
    }
}
