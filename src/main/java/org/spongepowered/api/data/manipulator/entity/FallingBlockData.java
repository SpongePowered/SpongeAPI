/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.data.manipulator.entity;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.FallingBlock;

/**
 * Represents the information for a {@link FallingBlock}.
 */
public interface FallingBlockData extends DataManipulator<FallingBlockData> {

    /**
     * Gets the current fall damage per block fallen.
     *
     * @return The current fall damage per block
     */
    Value<Double, FallingBlockData> fallDamagePerBlock();

    /**
     * Gets the maximum damage this block can deal to another entity
     * for falling on the entity.
     *
     * @return The maximum damage this block can deal
     */
    Value<Double, FallingBlockData> maxFallDamage();

    /**
     * Gets the {@link BlockState} this falling block is representing.
     *
     * @return The falling block's block state
     */
    Value<BlockState, FallingBlockData> blockState();

    /**
     * Gets whether this falling block will try to place itself where
     * it lands.
     *
     * @return True if this block will attempt to place itself when it lands
     */
    Value<Boolean, FallingBlockData> canPlaceAsBlock();

    /**
     * Gets whether this falling block can drop as an item if it lands in a
     * way that it can not be placed.
     *
     * @return Whether this falling block can drop as an item
     */
    Value<Boolean, FallingBlockData> canDropAsItem();

}
