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

package org.spongepowered.api.block;

import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.DataHolder;

/**
 * Describes a base type of block.
 *
 * <p>Blocks are further differentiated using a {@link BlockState}. Complex
 * data, such as inventory contents, are considered data, which is provided
 * via {@link DataHolder}.</p>
 */
public interface BlockType extends Translatable {

    /**
     * Return the internal ID for the block.
     *
     * <p>The format of the internal ID may vary between implementations
     * but in Minecraft, it follows the format of {@code domain:type}, an
     * example being {@code minecraft:stone}.</p>
     *
     * @return The id
     */
    String getId();

    /**
     * Return the default state for this block.
     *
     * @return The default state
     */
    BlockState getDefaultState();

    /**
     * Get the block state for a given data value.
     *
     * @param data The data value to extract into a block state
     * @return Block state with properties set according to the data value
     * @deprecated Exists for backwards-compatibility/transitional use
     */
    @Deprecated
    BlockState getStateFromDataValue(byte data);

    /**
     * Gets if this BlockType is set to receive random block ticks.
     *
     * <p>Random block ticks are most commonly used for growth of plants.</p>
     *
     * @return If the BlockType ticks randomly.
     */
    boolean getTickRandomly();

    /**
     * Sets if the BlockType should receive random block ticks.
     *
     * <p>Random block ticks are most commonly used for growth of plants.</p>
     *
     * @param tickRandomly If the BlockType should tick randomly.
     */
    void setTickRandomly(boolean tickRandomly);

    /**
     * Gets if the block type is representing a liquid.
     *
     * @return Is liquid
     */
    boolean isLiquid();

    /**
     * Gets if a block type is a full and solid block.
     *
     * @return Is solid block
     */
    boolean isSolidCube();

    /**
     * Gets if this block is affected by gravity (if it will fall when
     * unsupported).
     *
     * @return Is affected by gravity
     */
    boolean isAffectedByGravity();

    /**
     * Gets if a block should be counted for statistics gathering.
     * 
     * @return Is counted for statistics
     */
    boolean areStatisticsEnabled();

    /**
     * Gets the amount of light emitted by this block type. The returned value
     * is normalized to have a range of 0 to 1 (1 being the maximum light
     * value), although it is not clamped to this range.
     * 
     * @return The amount of light
     */
    float getEmittedLight();

}
