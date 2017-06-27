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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableFoodData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.living.Humanoid;

/**
 * An {@link DataManipulator} handling the various aspects of "hunger"
 * which has various effects on health and speed of {@link Humanoid} entities.
 */
public interface FoodData extends DataManipulator<FoodData, ImmutableFoodData> {

    /**
     * Gets the current food level as an {@link MutableBoundedValue}.
     *
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @return The current food level
     * @see Keys#FOOD_LEVEL
     */
    MutableBoundedValue<Integer> foodLevel();

    /**
     * Gets the {@link MutableBoundedValue} for the "exhaustion" level.
     *
     * <p>When the exhaustion level reaches 0, saturation is usually diminished
     * such that saturation is decreased and then exhaustion is reset to the
     * maximum. This type of effect occurs over time and can be modified by
     * movements and actions performed by the {@link Humanoid} entity.</p>
     *
     * @return The immutable bounded value of exhaustion
     * @see Keys#EXHAUSTION
     */
    MutableBoundedValue<Double> exhaustion();

    /**
     * Gets the {@link MutableBoundedValue} for the "saturation" level.
     *
     * <p>When the saturation level reaches 0, the food level is usually
     * diminished such that the food level is decreased by 1, then
     * saturation is reset to the maximum value. This type of effect occurs
     * over time and can be modified by movements and actions performed by the
     * {@link Humanoid} entity.</p>
     *
     * @return The immutable bounded value of saturation
     * @see Keys#SATURATION
     */
    MutableBoundedValue<Double> saturation();

}
