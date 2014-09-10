package org.spongepowered.api.event.player;

import org.spongepowered.api.Action;
import org.spongepowered.api.Game;
import org.spongepowered.api.block.Block;
import org.spongepowered.api.entity.Player;

/**
 * Event for when a player interacts with the world
 */
public class PlayerInteractEvent extends PlayerEvent{

    //The action
    private Action action;
    //The block that was clicked
    private Block block;

    public PlayerInteractEvent(Game game, Player player, Action action, Block block){
        super(game, player);
        this.action=action;
        this.block=block;
    }

    public Action getAction(){
        return this.action;
    }

    public Block getBlock(){
        return this.block;
    }
}
