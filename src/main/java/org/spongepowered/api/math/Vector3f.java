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
 * Represent a 3 component vector using floats. It is immutable and all vectors
 * returned by the methods are new instances.
 */
public interface Vector3f extends Comparable<Vector3f>, Serializable, Cloneable {

    /**
     * Returns the x component.
     *
     * @return The x component
     */
    float getX();

    /**
     * Returns the y component.
     *
     * @return The y component
     */
    float getY();

    /**
     * Returns the z component.
     *
     * @return The z component
     */
    float getZ();

    /**
     * Returns the floor of the x component as an integer.
     *
     * @return The floor of the x component as an integer
     */
    int getFloorX();

    /**
     * Returns the floor of the y component as an integer.
     *
     * @return The floor of the y component as an integer
     */
    int getFloorY();

    /**
     * Returns the floor of the z component as an integer.
     *
     * @return The floor of the z component as an integer
     */
    int getFloorZ();

    /**
     * Adds another Vector3f to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector3f add(Vector3f v);

    /**
     * Adds the vector components to this vector, returning the results as new
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f add(double x, double y, double z);

    /**
     * Adds the vector components to this vector, returning the results as new
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f add(float x, float y, float z);

    /**
     * Subtracts another Vector3f to this one, returning the results as new
     * vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector3f sub(Vector3f v);

    /**
     * Subtracts the vector components from this vector, returning the results
     * as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f sub(double x, double y, double z);

    /**
     * Subtracts the vector components from this vector, returning the results
     * as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f sub(float x, float y, float z);

    /**
     * Multiplies each component of this vector by the value, returning the
     * results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3f mul(double a);

    /**
     * Multiplies each component of this vector by the value, returning the
     * results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3f mul(float a);

    /**
     * Multiplies each component of this vector by the corresponding component
     * in another Vector3f, returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector3f mul(Vector3f v);

    /**
     * Multiplies each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f mul(double x, double y, double z);

    /**
     * Multiplies each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f mul(float x, float y, float z);

    /**
     * Divides each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector3f div(double a);

    /**
     * Divides each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector3f div(float a);

    /**
     * Divides each component of this vector by the corresponding component in
     * another Vector3f, returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector3f div(Vector3f v);

    /**
     * Divides each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f div(double x, double y, double z);

    /**
     * Divides each component of this vector by the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f div(float x, float y, float z);

    /**
     * Dots another Vector3f with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    float dot(Vector3f v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    float dot(double x, double y, double z);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    float dot(float x, float y, float z);

    /**
     * Crosses another Vector3f with this one.
     *
     * @param v The vector to cross with
     * @return The results of the operation
     */
    Vector3f cross(Vector3f v);

    /**
     * Crosses the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    Vector3f cross(double x, double y, double z);

    /**
     * Crosses the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation
     */
    Vector3f cross(float x, float y, float z);

    /**
     * Raises each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param pow The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector3f pow(double pow);

    /**
     * Raises each component of this vector by the value, returning the results
     * as new vector.
     *
     * @param power The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector3f pow(float power);

    /**
     * Calculates the ceiling of each component, returning the result as a new
     * vector.
     *
     * @return The results of the operation
     */
    Vector3f ceil();

    /**
     * Calculates the floor of each component, returning the result as a new
     * vector.
     *
     * @return The results of the operation
     */
    Vector3f floor();

    /**
     * Rounds each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3f round();

    /**
     * Calculates the absolute value of each component, returning the result as
     * a new vector.
     *
     * @return The results of the operation
     */
    Vector3f abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector3f negate();

    /**
     * Finds the minimum between each component of this vector and the
     * corresponding component in another Vector3f, returning the results as new
     * vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3f min(Vector3f v);

    /**
     * Finds the minimum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f min(double x, double y, double z);

    /**
     * Finds the minimum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f min(float x, float y, float z);

    /**
     * Finds the maximum between each component of this vector and the
     * corresponding component in another Vector3f, returning the results as new
     * vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector3f max(Vector3f v);

    /**
     * Finds the maximum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f max(double x, double y, double z);

    /**
     * Finds the maximum between each component of this vector and the
     * corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The results of the operation as a new vector
     */
    Vector3f max(float x, float y, float z);

    /**
     * Gets the square of the distance between this vector and another
     * Vector3f.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    float distanceSquared(Vector3f v);

    /**
     * Gets the square of the distance between this vector and the components of
     * another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The square of the distance between the two
     */
    float distanceSquared(double x, double y, double z);

    /**
     * Gets the square of the distance between this vector and the components of
     * another vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The square of the distance between the two
     */
    float distanceSquared(float x, float y, float z);

    /**
     * Gets the distance between this vector and another Vector3f.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    float distance(Vector3f v);

    /**
     * Gets the distance between this vector and the components of another
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The distance between the two
     */
    float distance(double x, double y, double z);

    /**
     * Gets the distance between this vector and the components of another
     * vector.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return The distance between the two
     */
    float distance(float x, float y, float z);

    /**
     * Calculates the square of the length of this vector.
     *
     * @return The results of the operation
     */
    float lengthSquared();

    /**
     * Calculates the length of this vector.
     *
     * @return The results of the operation
     */
    float length();

    /**
     * Normalizes the length of this vector without altering the orientation.
     *
     * @return The results of the operation
     */
    Vector3f normalize();

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
     * Returns this vector as a Vector2f, discarding the component z.
     *
     * @return This vector as a Vector2f
     */
    Vector2f toVector2();

    /**
     * Returns this vector as a Vector2f, discarding either the y or z
     * component.
     *
     * @param useZ Discard the y component and use z instead
     * @return This vector as a Vector2f
     */
    Vector2f toVector2(boolean useZ);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    float[] toArray();

    /**
     * Returns this vector as a Vector3i, by flooring the components.
     *
     * @return This vector as a Vector3i
     */
    Vector3i toInt();

    /**
     * Returns this vector as a Vector3d.
     *
     * @return This vector as a Vector3d
     */
    Vector3d toDouble();

    @Override
    int compareTo(Vector3f v);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector3f clone();

    /**
     * Returns a string representation of this vector in the form "(x, y, z)".
     *
     * @return This vector as a string
     */
    @Override
    String toString();

}
