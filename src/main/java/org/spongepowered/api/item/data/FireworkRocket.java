/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
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
package org.spongepowered.api.item.data;

import org.spongepowered.api.item.meta.FireworkExplosion;

import java.util.Collection;

/**
 * Represents a firework rocket in an inventory.
 */
public interface FireworkRocket extends ItemData {

    /**
     * Gets the explosions this firework will cause. Not read-only.
     * 
     * @return The explosions this firework will cause
     */
    Collection<FireworkExplosion> getExplosions();

    /**
     * Adds an explosion to this firewwork.
     * 
     * @param explosion The explosion to add
     */
    void addExplosion(FireworkExplosion explosion);

    /**
     * Removes an explosion from this firework.
     * 
     * @param explosion The explosion to remove
     */
    void removeExplosion(FireworkExplosion explosion);

    /**
     * Gets how long this rocket will fly before exploding, in multiples of half
     * seconds, though the actual value of a created Firework is randomized
     * more.
     * 
     * @return How long this rocket will fly before exploding
     */
    int getFlightTime();

    /**
     * Gets how long this rocket will fly before exploding, in multiples of half
     * seconds, though the actual value of a created Firework is randomized
     * more.
     * 
     * @param time How long this rocket will now fly before exploding
     */
    void setFlightTime(int time);

}
