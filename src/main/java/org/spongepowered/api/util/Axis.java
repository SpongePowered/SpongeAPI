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

package org.spongepowered.api.util;

import com.flowpowered.math.vector.Vector3d;

/**
 * Represents a three dimensional cartesian axis.
 */
public enum Axis {

    X(new Vector3d(1, 0, 0)),
    Y(new Vector3d(0, 1, 0)),
    Z(new Vector3d(0, 0, 1));

    private final Vector3d direction;

    private Axis(final Vector3d vector3d) {
        this.direction = vector3d;
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector, this method returns {@link #X}. If the vector has
     * the same length in a horizontal and vertical direction, a horizontal axis
     * will be returned. If the vector has the same length in x and in z
     * direction {@link #X} will be returned.
     *
     * @param vector The vector to convert to a axis
     * @return The closest axis.
     */
    public static Axis getClosest(final Vector3d vector) {
        double x = Math.abs(vector.getX());
        double y = Math.abs(vector.getY());
        double z = Math.abs(vector.getZ());
        if (x < y) {
            if (z < y) {
                return Y;
            } else {
                return Z;
            }
        } else if (x < z) {
            return Z;
        } else {
            return X;
        }
    }

    /**
     * Returns whether the given vector is along this axis.
     *
     * @param vector The vector to test
     * @return True if it is along this axis
     */
    public boolean isVectorAlongAxis(final Vector3d vector) {
        return vector.abs().normalize().sub(this.direction).lengthSquared() == 0;
    }

    /**
     * Gets the component of the vector denoted by this axis.
     *
     * @param vector3d The vector
     * @return The value of the component
     */
    public double getComponent(final Vector3d vector3d) {
        switch (this) {
            case X:
                return this.direction.getX();
            case Y:
                return this.direction.getY();
            case Z:
                return this.direction.getZ();
            default:
                throw new IllegalStateException("Not capable of handling the " + name() + " axis!");
        }
    }

    /**
     * Gets the direction of the vector's component denoted by this axis.
     *
     * @param vector3d The vector
     * @return The direction of the component
     */
    public AxisDirection getDirection(final Vector3d vector3d) {
        final double component = getComponent(vector3d);
        if (component > 0) {
            return AxisDirection.PLUS;
        } else if (component == 0) {
            return AxisDirection.ZERO;
        } else {
            return AxisDirection.MINUS;
        }
    }

    /**
     * Gets the Vector3d backing this axis.
     *
     * @return the Vector3d
     */
    public Vector3d toVector3d() {
        return this.direction;
    }

    /**
     * Gets the Vector3d with the given {@link AxisDirection}.
     *
     * @param axisDirection The direction along the axis.
     * @return the Vector3d
     */
    public Vector3d toVector3dWithDirection(final AxisDirection axisDirection) {
        return this.direction.mul(axisDirection.getSignum());
    }

}
