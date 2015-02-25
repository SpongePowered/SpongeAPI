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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.event.block.BulkBlockEvent;
import org.spongepowered.api.world.Location;

/**
 * Represents an event when an explosion already has taken place and blocks
 * are about to be broken/affected.
 */
public interface EntityExplosionEvent extends EntityEvent, BulkBlockEvent {

    /**
     * Gets the location of the explosion. This is separate from the
     * entity as the entity already blew up.
     *
     * @return The location of detonation
     */
    Location getExplosionLocation();

    /**
     * Gets the damaging yield of the explosion to affect blocks.
     *
     * <p>The higher the yield, the more blocks are broken. The yield
     * is between 0 and 100.</p>
     *
     * @return The damaging yield of the explosion
     */
    double getYield();

    /**
     * Sets the damaging yield of the explosion to affect blocks.
     *
     * <p>The higher the yield, the more blocks are broken. The yield
     * is between 0 and 100.</p>
     *
     * @param yield The damaging yield of the explosion
     */
    void setYield(double yield);

}
