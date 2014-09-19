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

package org.spongepowered.api.math;

import java.io.Serializable;

/**
 * Represents a euler direction, made up of both a pitch and yaw component.
 *
 * Euler directions are most commonly used by entities to represent the direction they are looking in.
 */
public interface EulerDirection extends Cloneable, Comparable<EulerDirection>, Serializable {

    /**
     * Returns the pitch component.
     *
     * @return the pitch component
     */
    float getPitch();

    /**
     * Returns the yaw component.
     *
     * @return the yaw component
     */
    float getYaw();

    /**
     * Converts this Euler Direction into a {@link Vector2d}.
     *
     * The vector will represent the directions that this direction is facing in x, y, z coordinates, with a length of 1.
     *
     * @return the vector representation of this direction
     */
    Vector2d toVector();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    /**
     * Returns a deep copy of this direction.
     *
     * @return A deep copy
     */
    EulerDirection clone();

    /**
     * Returns a string representation of this direction in the form "(pitch, yaw)".
     *
     * @return This direction as a string
     */
    @Override
    String toString();
}
