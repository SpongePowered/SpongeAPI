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
package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.FallingBlockData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.FallingBlock;

/**
 * An {@link ImmutableDataManipulator} for a {@link FallingBlock} with all
 * relative information associated, such as the {@link BlockState}, the
 * {@link #fallDamagePerBlock()}, etc.
 */
public interface ImmutableFallingBlockData extends ImmutableDataManipulator<ImmutableFallingBlockData, FallingBlockData> {

    /**
     * Gets the {@link ImmutableValue} for the damage to deal per block
     * the {@link FallingBlock} has fallen.
     *
     * @return The immutable value for the damage per block of falling
     */
    ImmutableValue<Double> fallDamagePerBlock();

    /**
     * Gets the maximum damage the {@link FallingBlock} can deal to another
     * entity for falling on the entity.
     *
     * @return The maximum damage the block can deal
     */
    ImmutableValue<Double> maxFallDamage();

    /**
     * Gets the {@link BlockState} the falling block is representing.
     *
     * @return The falling block's block state
     */
    ImmutableValue<BlockState> blockState();

    /**
     * Gets whether this falling block will try to place itself where
     * it lands.
     *
     * @return True if this block will attempt to place itself when it lands
     */
    ImmutableValue<Boolean> canPlaceAsBlock();

    /**
     * Gets whether this falling block can drop as an item if it lands in a
     * way that it can not be placed.
     *
     * @return Whether this falling block can drop as an item
     */
    ImmutableValue<Boolean> canDropAsItem();

    /**
     * Gets the time the block has been falling if spawning a entity in air
     * this will need to be set to 1 or it will be instantly removed.
     *
     * @return The time the block has been falling
     */
    ImmutableValue<Integer> fallTime();

    /**
     * Gets whether this falling block will damage entities where it lands.
     *
     * @return Whether this falling block will damage entities where it lands
     */
    ImmutableValue<Boolean> canHurtEntities();

}
