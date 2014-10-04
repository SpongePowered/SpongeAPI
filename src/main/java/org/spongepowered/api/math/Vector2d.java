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
 * Represent a 2 component vector using doubles. It is immutable and all vectors
 * returned by the methods are new instances.
 */
public interface Vector2d extends Comparable<Vector2d>, Serializable, Cloneable {

    /**
     * Returns the x component.
     *
     * @return The x component
     */
    double getX();

    /**
     * Returns the y component.
     *
     * @return The y component
     */
    double getY();

    /**
     * Returns the floor of the x component as a long integer.
     *
     * @return The floor of the x component as a long integer
     */
    long getFloorX();


    /**
     * Returns the floor of the y component as a long integer.
     *
     * @return The floor of the y component as a long integer
     */
    long getFloorY();

    /**
     * Adds another Vector2d to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector2d add(Vector2d v);

    /**
     * Adds the vector components to this vector, returning the results as new
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d add(double x, double y);

    /**
     * Subtracts another Vector2d to this one, returning the results as new
     * vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector2d sub(Vector2d v);

    /**
     * Subtracts the vector components from this vector, returning the results
     * as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d sub(double x, double y);

    /**
     * Multiplies each component of this vector by the value, returning the
     * results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2d mul(double a);

    /**
     * Multiplies each component of this vector by the corresponding component
     * in another Vector2d, returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2d mul(Vector2d v);

    /**
     * Multiplies each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d mul(double x, double y);

    /**
     * Divides each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector2d div(double a);

    /**
     * Divides each component of this vector by the corresponding component in
     * another Vector2d, returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector2d div(Vector2d v);

    /**
     * Divides each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d div(double x, double y);

    /**
     * Dots another Vector2d with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    double dot(Vector2d v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation
     */
    double dot(double x, double y);

    /**
     * Raises each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param power The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector2d pow(double power);

    /**
     * Calculates the ceiling of each component, returning the result as a new
     * vector.
     *
     * @return The results of the operation
     */
    Vector2d ceil();

    /**
     * Calculates the floor of each component, returning the result as a new
     * vector.
     *
     * @return The results of the operation
     */
    Vector2d floor();

    /**
     * Rounds each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2d round();

    /**
     * Calculates the absolute value of each component, returning the result as
     * a new vector.
     *
     * @return The results of the operation
     */
    Vector2d abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2d negate();

    /**
     * Finds the minimum between each component of this vector and the
     * corresponding component in another Vector2d, returning the results as new
     * vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2d min(Vector2d v);

    /**
     * Finds the minimum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d min(double x, double y);

    /**
     * Finds the maximum between each component of this vector and the
     * corresponding component in another Vector2d, returning the results as new
     * vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2d max(Vector2d v);

    /**
     * Finds the maximum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2d max(double x, double y);

    /**
     * Gets the square of the distance between this vector and another
     * Vector2d.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    double distanceSquared(Vector2d v);

    /**
     * Gets the square of the distance between this vector and the components of
     * another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The square of the distance between the two
     */
    double distanceSquared(double x, double y);

    /**
     * Gets the distance between this vector and another Vector2d.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    double distance(Vector2d v);

    /**
     * Gets the distance between this vector and the components of another
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The distance between the two
     */
    double distance(double x, double y);

    /**
     * Calculates the square of the length of this vector.
     *
     * @return The results of the operation
     */
    double lengthSquared();

    /**
     * Calculates the length of this vector.
     *
     * @return The results of the operation
     */
    double length();

    /**
     * Normalizes the length of this vector without altering the orientation.
     *
     * @return The results of the operation
     */
    Vector2d normalize();

    /**
     * Return the axis with the minimal value.
     *
     * @return The axis with minimal value
     */
    int getMinAxis();

    /**
     * Return the axis with the maximum value.
     *
     * @return The axis with maximum value
     */
    int getMaxAxis();

    /**
     * Returns this vector as a Vector3d, using the value 0 for component z.
     *
     * @return This vector as a Vector3d
     */
    Vector3d toVector3();

    /**
     * Returns this vector as a Vector3d, using the provided value for component
     * z.
     *
     * @param z The z component value to be used
     * @return This vector as a Vector3d
     */
    Vector3d toVector3(double z);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    double[] toArray();

    /**
     * Returns this vector as a Vector2i, by flooring the components.
     *
     * @return This vector as a Vector2i
     */
    Vector2i toInt();

    /**
     * Returns this vector as a Vector2f.
     *
     * @return This vector as a Vector2f
     */
    Vector2f toFloat();

    @Override
    int compareTo(Vector2d v);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector2d clone();

    /**
     * Returns a string representation of this vector in the form "(x, y)".
     *
     * @return This vector as a string
     */
    @Override
    String toString();

}
