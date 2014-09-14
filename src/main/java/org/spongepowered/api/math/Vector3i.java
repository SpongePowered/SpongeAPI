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
 * Represent a 3 component vector using ints.
 * It is immutable and all vectors returned by the methods are new instances.
 * Double overloads are floored to ints before the operation, and int vectors are returned.
 */
public interface Vector3i extends Comparable<Vector3i>, Serializable, Cloneable {

    /**
     * Returns the x component.
     *
     * @return The x component
     */
    int getX();

    /**
     * Returns the y component.
     *
     * @return The y component
     */
    int getY();

    /**
     * Returns the z component.
     *
     * @return The z component
     */
    int getZ();

    /**
     * Adds another Vector3i to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector3i add(Vector3i v);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i add(double x, double y, double z);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i add(int x, int y, int z);

    /**
     * Subtracts another Vector3i to this one, returning the results as new vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector3i sub(Vector3i v);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i sub(double x, double y, double z);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i sub(int x, int y, int z);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3i mul(double a);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3i mul(int a);

    /**
     * Multiplies each component of this vector by the corresponding component in another Vector3i,
     * returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3i mul(Vector3i v);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i mul(double x, double y, double z);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i mul(int x, int y, int z);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector3i div(double a);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector3i div(int a);

    /**
     * Divides each component of this vector by the corresponding component in another Vector3i,
     * returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector3i div(Vector3i v);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i div(double x, double y, double z);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i div(int x, int y, int z);

    /**
     * Dots another Vector3i with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    int dot(Vector3i v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    int dot(double x, double y, double z);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    int dot(int x, int y, int z);

    /**
     * Crosses another Vector3i with this one.
     *
     * @param v The vector to cross with
     * @return The results of the operation
     */
    Vector3i cross(Vector3i v);

    /**
     * Crosses the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    Vector3i cross(double x, double y, double z);

    /**
     * Crosses the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    Vector3i cross(int x, int y, int z);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param pow The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector3i pow(double pow);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param power The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector3i pow(int power);

    /**
     * Calculates the absolute value of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3i abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3i negate();

    /**
     * Finds the minimum between each component of this vector and the corresponding component in another Vector3i,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3i min(Vector3i v);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i min(double x, double y, double z);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i min(int x, int y, int z);

    /**
     * Finds the maximum between each component of this vector and the corresponding component in another Vector3i,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3i max(Vector3i v);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i max(double x, double y, double z);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3i max(int x, int y, int z);

    /**
     * Gets the square of the distance between this vector and another Vector3i.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    int distanceSquared(Vector3i v);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The square of the distance between the two
     */
    int distanceSquared(double x, double y, double z);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The square of the distance between the two
     */
    int distanceSquared(int x, int y, int z);

    /**
     * Gets the distance between this vector and another Vector3i.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    int distance(Vector3i v);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The distance between the two
     */
    int distance(double x, double y, double z);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The distance between the two
     */
    int distance(int x, int y, int z);

    /**
     * Calculates the square of the length of this vector.
     *
     * @return The results of the operation
     */
    int lengthSquared();

    /**
     * Calculates the length of this vector.
     *
     * @return The results of the operation
     */
    int length();

    /**
     * Returns the axis with the minimal value.
     *
     * @return The axis with minimal value
     */
    int getMinAxis();

    /**
     * Returns the axis with the maximum value.
     *
     * @return The axis with maximum value
     */
    int getMaxAxis();

    /**
     * Returns this vector as a Vector2i, discarding the component z.
     *
     * @return This vector as a Vector2i
     */
    Vector2i toVector2();

    /**
     * Returns this vector as a Vector2i, discarding either the y or z component.
     *
     * @param useZ Discard the y component and use z instead
     * @return This vector as a Vector2i
     */
    Vector2i toVector2(boolean useZ);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    int[] toArray();

    /**
     * Returns this vector as a Vector3f.
     *
     * @return This vector as a Vector3f
     */
    Vector3f toFloat();

    /**
     * Returns this vector as a Vector3d.
     *
     * @return This vector as a Vector3d
     */
    Vector3d toDouble();

    @Override
    int compareTo(Vector3i v);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector3i clone();

    /**
     * Returns a string representation of this vector in the form "(x, y, z)".
     *
     * @return This vector as a string
     */
    @Override
    String toString();

}
