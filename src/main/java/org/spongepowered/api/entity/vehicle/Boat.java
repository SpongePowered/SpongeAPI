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
package org.spongepowered.api.entity.vehicle;

import org.spongepowered.api.entity.Entity;

/**
 * Represents a Boat entity.
 */
public interface Boat extends Entity {

    /**
     * Gets whether this boat is currently in
     * water.
     *
     * @return If the boat is in water
     */
    boolean isInWater();

    /**
     * Gets the maximum speed that this boat is
     * allowed to travel at.
     *
     * <p>The Default value is 0.4.</p>
     *
     * @return The maximum speed
     */
    double getMaxSpeed();

    /**
     * Sets the maximum speed that this boat is
     * allowed to travel at.
     *
     * <p>The Default value is 0.4.</p>
     *
     * @param maxSpeed The new max speed
     */
    void setMaxSpeed(double maxSpeed);

    /**
     * Gets whether or not the boat is able to
     * move freely on land.
     *
     * @return If the boat can move on land
     */
    boolean canMoveOnLand();

    /**
     * Gets whether or not the boat is able to
     * move freely on land.
     *
     * @param moveOnLand If the boat can move on land
     */
    void setMoveOnLand(boolean moveOnLand);

    /**
     * Gets the rate at which occupied boats decelerate.
     *
     * @return The occupied deceleration rate
     */
    double getOccupiedDeceleration();

    /**
     * Sets the rate at which occupied boats decelerate.
     *
     * @param occupiedDeceleration The new occupied deceleration rate
     */
    void setOccupiedDeceleration(double occupiedDeceleration);

    /**
     * Gets the rate at which unoccupied boats decelerate.
     *
     * @return The unoccupied deceleration rate
     */
    double getUnoccupiedDeceleration();

    /**
     * Sets the rate at which unoccupied boats decelerate.
     *
     * @param unoccupiedDeceleration The new unoccupied deceleration rate
     */
    void setUnoccupiedDeceleration(double unoccupiedDeceleration);
}
