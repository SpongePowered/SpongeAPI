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
import org.spongepowered.api.data.manipulator.mutable.entity.AgeableData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;

/**
 * Represents a living entity that can change in size as it ages
 * and can spawn children.
 */
public interface Ageable extends Creature {

    /**
     * Sets the scaling to be 1 if this entity is an adult and 0.5 if it is
     * a baby.
     */
    void setScaleForAge();

    /**
     * Gets the {@link AgeableData} that represents age determining whether an
     * {@link Entity} is a child or an adult.
     *
     * @return The ageable data
     */
    default AgeableData getAgeData() {
        return get(AgeableData.class).get();
    }

    /**
     * Gets the {@link MutableBoundedValue} for the "age" state.
     *
     * @return The mutable bounded value for the "age"
     */
    default MutableBoundedValue<Integer> age() {
        return getValue(Keys.AGE).get();
    }

    /**
     * Gets the {@link Value} for the "adult" state.
     *
     * @return The value for the "adult" state
     */
    default Value<Boolean> adult() {
        return getValue(Keys.IS_ADULT).get();
    }

}
