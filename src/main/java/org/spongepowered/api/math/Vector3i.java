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

public interface Vector3i extends Comparable<Vector3i>, Serializable, Cloneable {
    int getX();

    int getY();

    int getZ();

    Vector3i add(Vector3i v);

    Vector3i add(double x, double y, double z);

    Vector3i add(int x, int y, int z);

    Vector3i sub(Vector3i v);

    Vector3i sub(double x, double y, double z);

    Vector3i sub(int x, int y, int z);

    Vector3i mul(double a);

    Vector3i mul(int a);

    Vector3i mul(Vector3i v);

    Vector3i mul(double x, double y, double z);

    Vector3i mul(int x, int y, int z);

    Vector3i div(double a);

    Vector3i div(int a);

    Vector3i div(Vector3i v);

    Vector3i div(double x, double y, double z);

    Vector3i div(int x, int y, int z);

    int dot(Vector3i v);

    int dot(double x, double y, double z);

    int dot(int x, int y, int z);

    Vector3i cross(Vector3i v);

    Vector3i cross(double x, double y, double z);

    Vector3i cross(int x, int y, int z);

    Vector3i pow(double pow);

    Vector3i pow(int power);

    Vector3i abs();

    Vector3i negate();

    Vector3i min(Vector3i v);

    Vector3i min(double x, double y, double z);

    Vector3i min(int x, int y, int z);

    Vector3i max(Vector3i v);

    Vector3i max(double x, double y, double z);

    Vector3i max(int x, int y, int z);

    int distanceSquared(Vector3i v);

    int distanceSquared(double x, double y, double z);

    int distanceSquared(int x, int y, int z);

    int distance(Vector3i v);

    int distance(double x, double y, double z);

    int distance(int x, int y, int z);

    int lengthSquared();

    int length();

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

    Vector2i toVector2();

    Vector2i toVector2(boolean useZ);

    int[] toArray();

    Vector3i toInt();

    Vector3f toFloat();

    int compareTo(Vector3i v);

    boolean equals(Object o);

    int hashCode();

    Vector3i clone();

    String toString();
}
