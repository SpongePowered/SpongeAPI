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
package org.spongepowered.api.world;

import org.spongepowered.api.block.BlockType;

import com.flowpowered.math.vector.Vector3i;

/**
 * 
 * Represents a tile tick. Tile ticks cause a block to update after a certain
 * number of ticks. Tile ticks with higher priorities are processed first.
 *
 */
public interface TileTick {

    /**
     * Gets the block type used to update the block.
     * 
     * @return The block type used to update the block
     */
    BlockType getBlockType();

    /**
     * Gets the amount of ticks until this tile tick should update.
     * 
     * @return The amount of ticks until this tile tick should update
     */
    int getTicks();

    /**
     * Sets the amount of ticks until this tile tick should update.
     * 
     * @param ticks The new amount of ticks until this tile tick should update
     */
    void setTicks(int ticks);

    /**
     * Gets the priority of this tile tick.
     * 
     * @return The priority of this tile tick
     */
    int getPriority();

    /**
     * Sets the priority of this tile tick.
     * 
     * @param priority The new priority of this tile tick
     */
    void setPriority(int priority);

    /**
     * Gets the position of this tile tick.
     * 
     * @return the position of this tile tick
     */
    Vector3i getPosition();

}
