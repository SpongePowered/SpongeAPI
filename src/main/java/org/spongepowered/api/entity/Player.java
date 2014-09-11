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
package org.spongepowered.api.entity;

public interface Player extends HumanEntity {

    /**
     * Gets the players last known username
     *
     * @return The player's last known username
     */
    String getName();

    /**
     * Gets the player's display name. If none set,
     * returns their current username.
     *
     * @return The player's display name
     */
    String getDisplayName();
    
    /**
     * Sets flight speed of player
     * @param speed new flight speed for player
     */
    void setFlightSpeed(float speed);
    
    /**
     * Gets flight speed.
     * @return flight speed
     */
    float getFlightSpeed();
    
    /**
     * Sets can player fly.
     * @param canFly can player fly
     */
    void setCanFly(boolean canFly);
    
    /**
     * Gets can the player fly. Will always return true for creative/spectator players.
     * @return true if player can fly
     */
    boolean canFly();
    
    /**
     * Checks is player currently flying.
     * @return true if player is flying
     */
    boolean isFlying();
}
