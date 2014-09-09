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

public interface Vector2i extends Comparable<Vector2i>, Serializable, Cloneable {
    int getX();

    int getY();

    Vector2i add(Vector2i v);

    Vector2i add(double x, double y);

    Vector2i add(int x, int y);

    Vector2i sub(Vector2i v);

    Vector2i sub(double x, double y);

    Vector2i sub(int x, int y);

    Vector2i mul(double a);

    Vector2i mul(int a);

    Vector2i mul(Vector2i v);

    Vector2i mul(double x, double y);

    Vector2i mul(int x, int y);

    Vector2i div(double a);

    Vector2i div(int a);

    Vector2i div(Vector2i v);

    Vector2i div(double x, double y);

    Vector2i div(int x, int y);

    int dot(Vector2i v);

    int dot(double x, double y);

    int dot(int x, int y);

    Vector2i pow(double pow);

    Vector2i pow(int power);

    Vector2i abs();

    Vector2i negate();

    Vector2i min(Vector2i v);

    Vector2i min(double x, double y);

    Vector2i min(int x, int y);

    Vector2i max(Vector2i v);

    Vector2i max(double x, double y);

    Vector2i max(int x, int y);

    int distanceSquared(Vector2i v);

    int distanceSquared(double x, double y);

    int distanceSquared(int x, int y);

    int distance(Vector2i v);

    int distance(double x, double y);

    int distance(int x, int y);

    int lengthSquared();

    int length();

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

    Vector3i toVector3();

    Vector3i toVector3(double z);

    Vector3i toVector3(int z);

    int[] toArray();

    Vector2f toFloat();

    Vector2d toDouble();

    int compareTo(Vector2i v);

    boolean equals(Object o);

    int hashCode();

    Vector2i clone();

    String toString();
}
