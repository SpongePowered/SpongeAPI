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

public interface Vector2d extends Comparable<Vector2d>, Serializable, Cloneable {
    double getX();

    double getY();

    int getFloorX();

    int getFloorY();

    Vector2d add(Vector2d v);

    Vector2d add(double x, double y);

    Vector2d sub(Vector2d v);

    Vector2d sub(double x, double y);

    Vector2d mul(float a);

    Vector2d mul(double a);

    Vector2d mul(Vector2d v);

    Vector2d mul(double x, double y);

    Vector2d div(float a);

    Vector2d div(double a);

    Vector2d div(Vector2d v);

    Vector2d div(double x, double y);

    double dot(Vector2d v);

    double dot(double x, double y);

    Vector2d pow(float pow);

    Vector2d pow(double power);

    Vector2d ceil();

    Vector2d floor();

    Vector2d round();

    Vector2d abs();

    Vector2d negate();

    Vector2d min(Vector2d v);

    Vector2d min(double x, double y);

    Vector2d max(Vector2d v);

    Vector2d max(double x, double y);

    double distanceSquared(Vector2d v);

    double distanceSquared(double x, double y);

    double distance(Vector2d v);

    double distance(double x, double y);

    double lengthSquared();

    double length();

    Vector2d normalize();

    /**
     * Return the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    int getMinAxis();

    /**
     * Return the axis with the maximum value.
     *
     * @return {@link int} axis with maximum value
     */
    int getMaxAxis();

    Vector3d toVector3();

    Vector3d toVector3(double z);

    double[] toArray();

    Vector2i toInt();

    Vector2f toFloat();

    int compareTo(Vector2d v);

    boolean equals(Object o);

    int hashCode();

    Vector2d clone();

    String toString();
}
