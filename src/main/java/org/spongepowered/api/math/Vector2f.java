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

public interface Vector2f extends Comparable<Vector2f>, Serializable, Cloneable {
    float getX();

    float getY();

    int getFloorX();

    int getFloorY();

    Vector2f add(Vector2f v);

    Vector2f add(double x, double y);

    Vector2f add(float x, float y);

    Vector2f sub(Vector2f v);

    Vector2f sub(double x, double y);

    Vector2f sub(float x, float y);

    Vector2f mul(double a);

    Vector2f mul(float a);

    Vector2f mul(Vector2f v);

    Vector2f mul(double x, double y);

    Vector2f mul(float x, float y);

    Vector2f div(double a);

    Vector2f div(float a);

    Vector2f div(Vector2f v);

    Vector2f div(double x, double y);

    Vector2f div(float x, float y);

    float dot(Vector2f v);

    float dot(double x, double y);

    float dot(float x, float y);

    Vector2f pow(double pow);

    Vector2f pow(float power);

    Vector2f ceil();

    Vector2f floor();

    Vector2f round();

    Vector2f abs();

    Vector2f negate();

    Vector2f min(Vector2f v);

    Vector2f min(double x, double y);

    Vector2f min(float x, float y);

    Vector2f max(Vector2f v);

    Vector2f max(double x, double y);

    Vector2f max(float x, float y);

    float distanceSquared(Vector2f v);

    float distanceSquared(double x, double y);

    float distanceSquared(float x, float y);

    float distance(Vector2f v);

    float distance(double x, double y);

    float distance(float x, float y);

    float lengthSquared();

    float length();

    Vector2f normalize();

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

    Vector3f toVector3();

    Vector3f toVector3(double z);

    Vector3f toVector3(float z);

    float[] toArray();

    Vector2i toInt();

    Vector2d toDouble();

    int compareTo(Vector2f v);

    boolean equals(Object o);

    int hashCode();

    Vector2f clone();

    String toString();
}
