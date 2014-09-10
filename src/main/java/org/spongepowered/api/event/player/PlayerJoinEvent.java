package org.spongepowered.api.event.player;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;

/**
 * Event for when player joins the server
 */
public class PlayerJoinEvent extends PlayerEvent{

    //Message for when player joins
    private String joinMessage;

    public PlayerJoinEvent(Game game, Player player, String message){
        super(game, player);
        this.joinMessage=message;
    }

    /**
     * Gets the join message for the player
     * @return the join message
     */
    public String getJoinMessage(){
        return this.joinMessage;
    }

    /**
     * Sets the players join message
     * @param message The players join message
     */
    public void setJoinMessage(String message){
        this.joinMessage=message;
    }
}
