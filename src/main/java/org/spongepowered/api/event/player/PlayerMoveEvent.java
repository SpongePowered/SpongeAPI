/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
