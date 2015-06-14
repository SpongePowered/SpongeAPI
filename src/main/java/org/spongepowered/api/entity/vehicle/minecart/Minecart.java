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
package org.spongepowered.api.entity.vehicle.minecart;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.entity.Entity;

/**
 * Represents a Minecart entity.
 */
public interface Minecart extends Entity {

    /**
     * Gets whether or not the minecart is currently on a valid rail block.
     *
     * @return If the cart is on a rail
     */
    boolean isOnRail();

    /**
     * Gets the absolute maximum speed that this cart is allowed to travel at.
     *
     * <p>The default value is 0.4.</p>
     *
     * @return The maximum speed
     */
    double getSwiftness();

    /**
     * Sets the absolute maximum speed that this cart is allowed to travel at.
     *
     * <p>The default value is 0.4.</p>
     *
     * @param swiftness The new maximum speed
     */
    void setSwiftness(double swiftness);

    /**
     * Gets the maximum speed that this cart is allowed to travel at the instant
     * this method is called.
     *
     * <p>This differs from {@link Minecart#getSwiftness()} in that its value is
     * affected by the block/rail beneath the cart. However, it is still
     * impacted and limited by the cart's swiftness.</p>
     *
     * @return The maximum speed at which the minecart may travel at the instant
     *     this method is called
     */
    double getPotentialMaxSpeed();

    /**
     * Gets whether or not the minecart slows down faster without a passenger.
     *
     * @return If the cart slows when empty
     */
    boolean doesSlowWhenEmpty();

    /**
     * Sets whether or not the minecart slows down faster without a passenger.
     *
     * @param slowWhenEmpty If the cart should slow when emoty
     */
    void setSlowWhenEmpty(boolean slowWhenEmpty);

    /**
     * Gets the velocity modifier applied when the minecart is airborne.
     *
     * @return Airborne velocity modifier
     */
    Vector3d getAirborneVelocityMod();

    /**
     * Sets the velocity modifier applied when the minecart is airborne.
     *
     * @param airborneVelocityMod The new airborne velocity modifier
     */
    void setAirborneVelocityMod(Vector3d airborneVelocityMod);

    /**
     * Gets the velocity modifier applied when the minecart is not on rails.
     *
     * @return Derailed velocity modifier
     */
    Vector3d getDerailedVelocityMod();

    /**
     * Sets the velocity modifier applied when the minecart is not on rails.
     *
     * @param derailedVelocityMod The new derailed velocity modifier
     */
    void setDerailedVelocityMod(Vector3d derailedVelocityMod);
}
