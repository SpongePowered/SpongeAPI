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

    public PlayerInteractEvent(Player player, Action action, Block block){
        super(player);
        this.action=action;
        this.block=block;
    }

    public Action getAction(){
        return this.action;
    }

    public Block getBlock(){
        return this.block;
    }

    public String getSimpleName(){
        return "PlayerInteractEvent";
    }
}
