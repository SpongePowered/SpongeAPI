/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package com.flowpowered.math.vector;

import java.io.Serializable;

public interface Vector3d extends Comparable<Vector3d>, Serializable, Cloneable {
    double getX();

    double getY();

    double getZ();

    int getFloorX();

    int getFloorY();

    int getFloorZ();

    Vector3d add(Vector3d v);

    Vector3d add(double x, double y, double z);

    Vector3d sub(Vector3d v);

    Vector3d sub(double x, double y, double z);

    Vector3d mul(float a);

    Vector3d mul(double a);

    Vector3d mul(Vector3d v);

    Vector3d mul(double x, double y, double z);

    Vector3d div(float a);

    Vector3d div(double a);

    Vector3d div(Vector3d v);

    Vector3d div(double x, double y, double z);

    double dot(Vector3d v);

    double dot(double x, double y, double z);

    Vector3d cross(Vector3d v);

    Vector3d cross(double x, double y, double z);

    Vector3d pow(float pow);

    Vector3d pow(double power);

    Vector3d ceil();

    Vector3d floor();

    Vector3d round();

    Vector3d abs();

    Vector3d negate();

    Vector3d min(Vector3d v);

    Vector3d min(double x, double y, double z);

    Vector3d max(Vector3d v);

    Vector3d max(double x, double y, double z);

    double distanceSquared(Vector3d v);

    double distanceSquared(double x, double y, double z);

    double distance(Vector3d v);

    double distance(double x, double y, double z);

    double lengthSquared();

    double length();

    Vector3d normalize();

    /**
     * Returns the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    int getMinAxis();

    /**
     * Returns the axis with the maximum value.
     *
     * @return {@link int} axis with maximum value
     */
    int getMaxAxis();

    Vector2d toVector2();

    Vector2d toVector2(boolean useZ);

    double[] toArray();

    Vector3i toInt();

    Vector3f toFloat();

    int compareTo(Vector3d v);

    boolean equals(Object o);

    int hashCode();

    Vector3d clone();

    String toString();
}
