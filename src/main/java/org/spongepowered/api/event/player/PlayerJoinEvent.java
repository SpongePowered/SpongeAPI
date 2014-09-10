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

/**
 * Event for when player joins the server
 */
public class PlayerJoinEvent extends PlayerEvent{

    //Message for when player joins
    private String joinMessage;

    public PlayerJoinEvent(Player player, String message){
        super(player);
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

    public String getSimpleName(){
        return "PlayerJoinEvent";
    }
}
