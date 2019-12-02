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

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.math.vector.Vector3d;

/**
 * Represents a Minecart.
 */
public interface MinecartEntity extends Entity {

    /**
     * {@link Keys#MINECART_IS_ON_RAIL}
     * @return Whether this minecart is on a rail or not
     */
    default Value.Mutable<Boolean> onRail() {
        return this.getValue(Keys.MINECART_IS_ON_RAIL).get().asMutable();
    }

    /**
     * {@link Keys#MINECART_SWIFTNESS}
     * @return The current swiftness of the minecart
     */
    default Value.Mutable<Double> swiftness() {
        return this.getValue(Keys.MINECART_SWIFTNESS).get().asMutable();
    }

    /**
     * {@link Keys#MINECART_POTENTIAL_MAX_SPEED}
     *
     * <p>This differs from {@link Minecart#swiftness()} in that its value is
     * affected by the block/rail beneath the cart. However, it is still
     * impacted and limited by the cart's swiftness.</p>
     * @return The potential maximum speed
     */
    default Value.Mutable<Double> potentialMaxSpeed() {
        return this.getValue(Keys.MINECART_POTENTIAL_MAX_SPEED).get().asMutable();
    }

    /**
     * {@link Keys#MINECART_SLOWS_UNOCCUPIED}
     * @return Whether this minecart will slow when unoccupied
     */
    default Value.Mutable<Boolean> slowsUnoccupied() {
        return this.getValue(Keys.MINECART_SLOWS_UNOCCUPIED).get().asMutable();
    }

    /**
     * {@link Keys#MINECART_AIRBORNE_VELOCITY_MODIFIER}
     * @return The airborne velocity modifier
     */
    default Value.Mutable<Vector3d> airborneVelocityModifier() {
        return this.getValue(Keys.MINECART_AIRBORNE_VELOCITY_MODIFIER).get().asMutable();
    }

    /**
     * {@link Keys#MINECART_DERAILED_VELOCITY_MODIFIER}
     * @return The derailed velocity modifier
     */
    default Value.Mutable<Vector3d> derailedVelocityModifier() {
        return this.getValue(Keys.MINECART_DERAILED_VELOCITY_MODIFIER).get().asMutable();
    }
}
