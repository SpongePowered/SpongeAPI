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
package org.spongepowered.api.data.manipulator.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.entity.Entity;

/**
 * Represents the current velocity of an entity. Applicable to all
 * {@link Entity}.
 */
public interface VelocityData extends SingleValueData<Vector3d, VelocityData> {

    /**
     * Gets the current velocity of this entity.
     *
     * @return The current velocity of this entity
     */
    Vector3d getVelocity();

    /**
     * Sets the velocity of this entity.
     *
     * @param velocity The velocity to set this entity
     * @return This instance, for chaining
     */
    VelocityData setVelocity(Vector3d velocity);

}
