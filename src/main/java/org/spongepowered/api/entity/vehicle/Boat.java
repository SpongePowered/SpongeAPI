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
package org.spongepowered.api.entity.vehicle;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.BoatType;
import org.spongepowered.api.data.value.Value;

/**
 * Represents a Boat entity.
 */
public interface Boat extends Vehicle {

    /**
     * {@link Keys#BOAT_TYPE}
     * @return The type of the boat
     */
    default Value.Mutable<BoatType> type() {
        return this.requireValue(Keys.BOAT_TYPE).asMutable();
    }

    /**
     * {@link Keys#IS_IN_WATER}
     * @return Whether this boat is in water
     */
    default Value.Mutable<Boolean> inWater() {
        return this.requireValue(Keys.IS_IN_WATER).asMutable();
    }

    /**
     * {@link Keys#CAN_MOVE_ON_LAND}
     * @return Whether this boat can travel over land
     */
    default Value.Mutable<Boolean> moveOnLand() {
        return this.requireValue(Keys.CAN_MOVE_ON_LAND).asMutable();
    }

    /**
     * {@link Keys#MAX_SPEED}
     * @return The maximum speed a boat can go
     */
    default Value.Mutable<Double> maxSpeed() {
        return this.requireValue(Keys.MAX_SPEED).asMutable();
    }

    /**
     * {@link Keys#UNOCCUPIED_DECELERATION}
     * @return The deceleration value when unoccupied
     */
    default Value.Mutable<Double> unoccupiedDeceleration() {
        return this.requireValue(Keys.UNOCCUPIED_DECELERATION).asMutable();
    }

    /**
     * {@link Keys#OCCUPIED_DECELERATION}
     * @return The deceleration value when occupied
     */
    default Value.Mutable<Double> occupiedDeceleration() {
        return this.requireValue(Keys.OCCUPIED_DECELERATION).asMutable();
    }
}
