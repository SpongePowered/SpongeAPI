package org.spongepowered.api.event.player;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.entity.LivingEntityEvent;

/**
 * Event for everything to do with players
 */
public abstract class PlayerEvent extends LivingEntityEvent{

    private Player player;

    public PlayerEvent(Game game, Player player){
        super(game, player);
        this.player=player;
    }

    public Player getPlayer(){
        return this.player;
    }
}
