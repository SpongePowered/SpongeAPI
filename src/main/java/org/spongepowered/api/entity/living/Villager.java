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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.CareerData;
import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.item.merchant.Merchant;

/**
 * Represents a Villager.
 */
public interface Villager extends Ageable, Merchant {

    /**
     * Returns true if this villager is currently trading with another
     * {@link Humanoid}. A villager is normally
     * unable to trade with multiple HumanEntities at the same time.
     *
     * @return True if this villager is trading with another player
     */
    boolean isTrading();

    /**
     * Gets a copy of the current {@link CareerData} for this {@link Villager}
     * entity.
     *
     * @return A copy of the career data
     */
    default CareerData getCareerData() {
        return get(CareerData.class).get();
    }

    /**
     * Gets the current {@link Career} of this villager.
     *
     * @return The current career value
     */
    default Value<Career> career() {
        return getValue(Keys.CAREER).get();
    }

}
