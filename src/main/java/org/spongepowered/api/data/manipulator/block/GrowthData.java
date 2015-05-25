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
package org.spongepowered.api.data.manipulator.block;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.IntData;

/**
 * Represents the "growth" of a block. Usually applicable to
 * {@link BlockTypes#WHEAT}, {@link BlockTypes#PUMPKIN_STEM}, etc.
 */
public interface GrowthData extends IntData<GrowthData> {

    /**
     * Gets the current growth stage.
     *
     * <p>The growth stage can have multiple meanings, but usually,
     * the higher the stage, the closer the holder is ready for
     * harvesting.</p>
     *
     * @return The current growth stage.
     */
    int getGrowthStage();

    /**
     * Sets the growth stage.
     *
     * <p>The growth stage can have multiple meanings, but usually,
     * the higher the stage, the closer the holder is ready for
     * harvesting.</p>
     *
     * @param stage The stage to set
     * @return This instance, for chaining
     */
    GrowthData setGrowthStage(int stage);

    /**
     * Gets the maximum growth stage for the relative owner of this data.
     *
     * <p>{@link GrowthData} can be compared, however, the maximum stage
     * can define that the holder is ready for harvesting.</p>
     *
     * @return The maximum stage of growth
     */
    int getMaxStage();

}
