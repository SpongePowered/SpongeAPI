package org.spongepowered.api.event.player;

import org.spongepowered.api.Game;
import org.spongepowered.api.Location;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.item.Item;

/**
 * Event for when player moves
 */
public class PlayerMoveEvent extends PlayerEvent{

    /**
     * Location Player starts at
     */
    private Location start;
    /**
     * Location player ends at
     */
    private Location end;

    public PlayerMoveEvent(Game game, Player player, Location start, Location end){
        super(game, player);
        this.start=start;
        this.end=end;
    }

    /**
     * Returns the starting location
     * @return start
     */
    public Location getStart(){
        return this.start;
    }

    /**
     * Returns the ending location
     * @return end
     */
    public Location getEnd(){
        return this.end;
    }

    /**
     * Sets the starting location
     * @param loc
     */
    public void setStart(Location loc){
        this.start=loc;
    }

    /**
     * Sets the ending location
     * @param loc
     */
    public void setEnd(Location loc){
        this.end=loc;
    }
}
