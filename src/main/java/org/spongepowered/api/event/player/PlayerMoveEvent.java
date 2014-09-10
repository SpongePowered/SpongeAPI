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
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.item.Item;
import org.spongepowered.api.math.Vector3d;

/**
 * Event for when player moves
 */
public class PlayerMoveEvent extends PlayerEvent{

    /**
     * Vector3d Player starts at
     */
    private Vector3d start;
    /**
     * Vector3d player ends at
     */
    private Vector3d end;

    public PlayerMoveEvent(Game game, Player player, Vector3d start, Vector3d end){
        super(game, player);
        this.start=start;
        this.end=end;
    }

    /**
     * Returns the starting Vector3d
     * @return start
     */
    public Vector3d getStart(){
        return this.start;
    }

    /**
     * Returns the ending Vector3d
     * @return end
     */
    public Vector3d getEnd(){
        return this.end;
    }

    /**
     * Sets the starting Vector3d
     * @param loc
     */
    public void setStart(Vector3d loc){
        this.start=loc;
    }

    /**
     * Sets the ending Vector3d
     * @param loc
     */
    public void setEnd(Vector3d loc){
        this.end=loc;
    }

    public String getSimpleName(){
        return "PlayerMoveEvent";
    }
}
