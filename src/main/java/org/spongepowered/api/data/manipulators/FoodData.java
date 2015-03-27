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

package org.spongepowered.api.data.manipulators;

import org.spongepowered.api.data.DataManipulator;

public interface FoodData extends DataManipulator<FoodData> {

    /**
     * Gets the exhastion value of this human entity.
     *
     * <p>When exhaustion level reaches 0, saturation may begin to diminish.
     * </p>
     *
     * @return The current exhaustion level
     */
    double getExhaustion();

    /**
     * Sets the exhaustion value of this human entity.
     *
     * <p>When exhaustion level reaches 0, saturation may begin to diminish.
     * </p>
     *
     * @param exhaustion The new exhaustion level
     */
    void setExhaustion(double exhaustion);

    /**
     * Gets the current saturation level of this human entity.
     *
     * <p>Saturation acts as a buffer for food level. Food level will not
     * decrease while the saturation level is greater than zero.</p>
     *
     * @return The current saturation level
     */
    double getSaturation();

    /**
     * Sets the saturation level of this human entity.
     *
     * <p>Saturation acts as a buffer for food level. Food level will not
     * decrease while the saturation level is greater than zero.</p>
     *
     * @param saturation The new saturation level
     */
    void setSaturation(double saturation);

    /**
     * Gets the current food saturation of this human entity.
     *
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @return The current food level
     */
    double getFoodLevel();

    /**
     * Sets the current food saturation of this human entity.
     *
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @param foodLevel The new food level
     */
    void setFoodLevel(double foodLevel);

}
