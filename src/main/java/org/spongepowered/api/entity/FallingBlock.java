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
package org.spongepowered.api.entity;

import org.spongepowered.api.block.BlockState;

/**
 * Represents a falling block. A falling block may harm entities where it
 * lands, and optionally may place a block, or drop an item.
 */
public interface FallingBlock extends Entity {

    /**
     * Gets the current fall damage per block fallen.
     *
     * @return The current fall damage per block
     */
    double getFallDamagePerBlock();

    /**
     * Sets the fall damage per block.
     *
     * @param damage The fall damage per block
     */
    void setFallDamagePerBlock(double damage);

    /**
     * Gets the maximum damage this block can deal to another entity
     * for falling on the entity.
     *
     * @return The maximum damage this block can deal
     */
    double getMaxFallDamage();

    /**
     * Sets the maximum damage this block can deal to another entity
     * for falling on the entity.
     *
     * @param damage The maximum damage this block can deal
     */
    void setMaxFallDamage(double damage);

    /**
     * Gets the {@link BlockState} this falling block is representing.
     *
     * @return The falling block's block state
     */
    BlockState getBlockState();

    /**
     * Sets the block state for this falling block.
     *
     * @param blockState The block state of this falling block
     */
    void setBlockState(BlockState blockState);

    /**
     * Gets whether this falling block will try to place itself where
     * it lands.
     *
     * @return True if this block will attempt to place itself when it lands
     */
    boolean getCanPlaceAsBlock();

    /**
     * Sets whether this falling block can be placed as a block when it lands.
     *
     * @param placeable Whether this falling block will attempt to place
     *                  itself when it lands
     */
    void setCanPlaceAsBlock(boolean placeable);

    /**
     * Gets whether this falling block can drop as an item if it lands in a
     * way that it can not be placed.
     *
     * @return Whether this falling block can drop as an item
     */
    boolean getCanDropAsItem();

    /**
     * Sets whether this falling block will drop as an item if it lands in a
     * way that it can not be placed.
     *
     * @param droppable Whether this falling block will drop as an item
     */
    void setCanDropAsItem(boolean droppable);

}
