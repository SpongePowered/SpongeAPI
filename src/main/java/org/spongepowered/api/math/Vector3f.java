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

public interface Vector3f extends Comparable<Vector3f>, Serializable, Cloneable {
    float getX();

    float getY();

    float getZ();

    int getFloorX();

    int getFloorY();

    int getFloorZ();

    Vector3f add(Vector3f v);

    Vector3f add(double x, double y, double z);

    Vector3f add(float x, float y, float z);

    Vector3f sub(Vector3f v);

    Vector3f sub(double x, double y, double z);

    Vector3f sub(float x, float y, float z);

    Vector3f mul(double a);

    Vector3f mul(float a);

    Vector3f mul(Vector3f v);

    Vector3f mul(double x, double y, double z);

    Vector3f mul(float x, float y, float z);

    Vector3f div(double a);

    Vector3f div(float a);

    Vector3f div(Vector3f v);

    Vector3f div(double x, double y, double z);

    Vector3f div(float x, float y, float z);

    float dot(Vector3f v);

    float dot(double x, double y, double z);

    float dot(float x, float y, float z);

    Vector3f cross(Vector3f v);

    Vector3f cross(double x, double y, double z);

    Vector3f cross(float x, float y, float z);

    Vector3f pow(double pow);

    Vector3f pow(float power);

    Vector3f ceil();

    Vector3f floor();

    Vector3f round();

    Vector3f abs();

    Vector3f negate();

    Vector3f min(Vector3f v);

    Vector3f min(double x, double y, double z);

    Vector3f min(float x, float y, float z);

    Vector3f max(Vector3f v);

    Vector3f max(double x, double y, double z);

    Vector3f max(float x, float y, float z);

    float distanceSquared(Vector3f v);

    float distanceSquared(double x, double y, double z);

    float distanceSquared(float x, float y, float z);

    float distance(Vector3f v);

    float distance(double x, double y, double z);

    float distance(float x, float y, float z);

    float lengthSquared();

    float length();

    Vector3f normalize();

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

    Vector2f toVector2();

    Vector2f toVector2(boolean useZ);

    float[] toArray();

    Vector3i toInt();

    Vector3d toDouble();

    int compareTo(Vector3f v);

    boolean equals(Object o);

    int hashCode();

    Vector3f clone();

    String toString();
}
