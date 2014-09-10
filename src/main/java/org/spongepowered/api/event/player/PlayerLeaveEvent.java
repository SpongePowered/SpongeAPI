package org.spongepowered.api.event.player;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;

/**
 * Event for when player leaves the server
 */
public class PlayerLeaveEvent extends PlayerEvent{

    private String leaveMessage;

    public PlayerLeaveEvent(Game game, Player player, String message){
        super(game, player);
        this.leaveMessage=leaveMessage;
    }

    /**
     * Gets the players leave message
     * @return leaveMessage
     */
    public String getLeaveMessage(){
        return this.leaveMessage;
    }

    /**
     * Sets the players leave message
     * @param message The lace message
     */
    public void setLeaveMessage(String message){
        this.leaveMessage=message;
    }
}
