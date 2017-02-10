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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableFallingBlockData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.FallingBlock;

/**
 * Represents the information for a {@link FallingBlock}.
 */
public interface FallingBlockData extends DataManipulator<FallingBlockData, ImmutableFallingBlockData> {

    /**
     * Gets the {@link Value} for the damage to deal per block
     * the {@link FallingBlock} has fallen.
     *
     * @return The immutable value for the damage per block of falling
     * @see Keys#FALL_DAMAGE_PER_BLOCK
     */
    Value<Double> fallDamagePerBlock();

    /**
     * Gets the maximum damage the {@link FallingBlock} can deal to another
     * entity for falling on the entity.
     *
     * @return The maximum damage the block can deal
     * @see Keys#MAX_FALL_DAMAGE
     */
    Value<Double> maxFallDamage();

    /**
     * Gets the {@link BlockState} the falling block is representing.
     *
     * @return The falling block's block state
     * @see Keys#FALLING_BLOCK_STATE
     */
    Value<BlockState> blockState();

    /**
     * Gets whether this falling block will try to place itself where
     * it lands.
     *
     * @return True if this block will attempt to place itself when it lands
     * @see Keys#CAN_PLACE_AS_BLOCK
     */
    Value<Boolean> canPlaceAsBlock();

    /**
     * Gets whether this falling block can drop as an item if it lands in a
     * way that it can not be placed.
     *
     * @return Whether this falling block can drop as an item
     * @see Keys#CAN_DROP_AS_ITEM
     */
    Value<Boolean> canDropAsItem();

    /**
     * Gets the number of ticks the block has been falling for.
     *
     * @return The time the block has been falling
     * @see Keys#FALL_TIME
     */
    Value<Integer> fallTime();

    /**
     * Gets whether this falling block will damage entities where it lands.
     *
     * @return Whether this falling block will damage entities where it lands
     * @see Keys#FALLING_BLOCK_CAN_HURT_ENTITIES
     */
    Value<Boolean> canHurtEntities();

}
