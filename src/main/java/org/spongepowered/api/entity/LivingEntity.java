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

public interface LivingEntity extends Entity, Damageable {
  
   /**
     * Gets the hunger level of the entity
     *
     * @return The entity's food level (if -1 , the entity doesn't have a food level or is dead)
     */
    int getHungerLevel();
    
    /**
     * Gets the maximum hunger level of the entity
     * The minimum hunger level should always be 0
     *
     * @return The entity's maximum food level (if -1 , the entity doesn't have a food level)
     */
    int getMaximumHungerLevel();
    
    /**
     * Sets the hunger level of the entity
     * If the provided hunger level is bigger than maximum level , it will
     * be floored to the maximum hunger level. If it is smaller than the
     * minimum allowed level , it will
     * be turned to 0
     * 
     * @param the entity's food level
     * @return true if operation is successful and the arguments match expectations
     */
    boolean setHungerLevel(int foodLevel);
  
}
