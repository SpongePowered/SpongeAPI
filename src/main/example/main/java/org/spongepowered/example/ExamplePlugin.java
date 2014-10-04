package org.spongepowered.example;

import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.BaseEvent;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.voxel.VoxelEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "ExamplePlugin", name = "Example")
public class ExamplePlugin {
    Logger logger;
    Game game;
    
    @SpongeEventHandler
    public void onConstruction(PreInitializationEvent event) {
        game = event.getGame();
        logger = event.getPluginLog();
        logger.info("Hey folks, this is PRE-INITIALIZATION!");
    }

    @SpongeEventHandler
    public void onServerStarting(ServerStartingEvent event) {
        logger.info("Hey...my implementation's server is starting?");
        
        logger.info("Sending custom event to EventManager");
        MyEvent e = new MyEvent("Custom event message");
        game.getEventManager().call(e);
        if (e.isCancelled()) {
            logger.info("Custom event was cancelled");
        }
    }
    
    @SpongeEventHandler
    public void onMyEvent(MyEvent event) {
        logger.info("Custom event received (" + event.getMessage() + "), cancelling");
        event.setCancelled(true);
    }
    
    @SpongeEventHandler
    public void onVoxelEvent(VoxelEvent event) {
        logger.info("A Block was broken");
    }
    
    public class MyEvent extends BaseEvent implements Cancellable {
        
        private final String message;
        
        public MyEvent(String message) {
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
    }
}
