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
package org.spongepowered.api.math;

import java.io.Serializable;

/**
 * Represent a 3 component vector using doubles.
 * It is immutable and all vectors returned by the methods are new instances.
 */
public interface Vector3d extends Comparable<Vector3d>, Serializable, Cloneable {
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
     * Returns the z component.
     *
     * @return The z component
     */
    double getZ();

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
     * Returns the floor of the z component as a long integer.
     *
     * @return The floor of the z component as a long integer
     */
    long getFloorZ();

    /**
     * Adds another Vector3d to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector3d add(Vector3d v);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d add(double x, double y, double z);

    /**
     * Subtracts another Vector3d to this one, returning the results as new vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector3d sub(Vector3d v);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d sub(double x, double y, double z);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3d mul(double a);

    /**
     * Multiplies each component of this vector by the corresponding component in another Vector3d,
     * returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3d mul(Vector3d v);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d mul(double x, double y, double z);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector3d div(double a);

    /**
     * Divides each component of this vector by the corresponding component in another Vector3d,
     * returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector3d div(Vector3d v);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d div(double x, double y, double z);

    /**
     * Dots another Vector3d with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    double dot(Vector3d v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    double dot(double x, double y, double z);

    /**
     * Crosses another Vector3d with this one.
     *
     * @param v The vector to cross with
     * @return The results of the operation
     */
    Vector3d cross(Vector3d v);

    /**
     * Crosses the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    Vector3d cross(double x, double y, double z);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector3d pow(double power);

    /**
     * Calculates the ceiling of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3d ceil();

    /**
     * Calculates the floor of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3d floor();

    /**
     * Rounds each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3d round();

    /**
     * Calculates the absolute value of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3d abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3d negate();

    /**
     * Finds the minimum between each component of this vector and the corresponding component in another Vector3d,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3d min(Vector3d v);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d min(double x, double y, double z);

    /**
     * Finds the maximum between each component of this vector and the corresponding component in another Vector3d,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3d max(Vector3d v);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3d max(double x, double y, double z);

    /**
     * Gets the square of the distance between this vector and another Vector3d.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    double distanceSquared(Vector3d v);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The square of the distance between the two
     */
    double distanceSquared(double x, double y, double z);

    /**
     * Gets the distance between this vector and another Vector3d.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    double distance(Vector3d v);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The distance between the two
     */
    double distance(double x, double y, double z);

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

    /**
     * Returns this vector as a Vector2d, discarding the component z.
     *
     * @return This vector as a Vector2d
     */
    Vector2d toVector2();

    /**
     * Returns this vector as a Vector2d, discarding either the y or z component.
     *
     * @param useZ Discard the y component and use z instead
     * @return This vector as a Vector2d
     */
    Vector2d toVector2(boolean useZ);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    double[] toArray();

    /**
     * Returns this vector as a Vector3i, by flooring the components.
     *
     * @return This vector as a Vector3i
     */
    Vector3i toInt();

    /**
     * Returns this vector as a Vector3f.
     *
     * @return This vector as a Vector3f
     */
    Vector3f toFloat();

    int compareTo(Vector3d v);

    boolean equals(Object o);

    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector3d clone();

    /**
     * Returns a string representation of this vector in the form "(x, y, z)".
     *
     * @return This vector as a string
     */
    String toString();
}
