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
 * Represent a 2 component vector using floats.
 * It is immutable and all vectors returned by the methods are new instances.
 */
public interface Vector2f extends Comparable<Vector2f>, Serializable, Cloneable {

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
     * Adds another Vector2f to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector2f add(Vector2f v);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f add(double x, double y);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f add(float x, float y);

    /**
     * Subtracts another Vector2f to this one, returning the results as new vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector2f sub(Vector2f v);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f sub(double x, double y);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f sub(float x, float y);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2f mul(double a);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2f mul(float a);

    /**
     * Multiplies each component of this vector by the corresponding component in another Vector2f,
     * returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2f mul(Vector2f v);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f mul(double x, double y);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f mul(float x, float y);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector2f div(double a);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector2f div(float a);

    /**
     * Divides each component of this vector by the corresponding component in another Vector2f,
     * returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector2f div(Vector2f v);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f div(double x, double y);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f div(float x, float y);

    /**
     * Dots another Vector2f with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    float dot(Vector2f v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation
     */
    float dot(double x, double y);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation
     */
    float dot(float x, float y);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param pow The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector2f pow(double pow);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param power The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector2f pow(float power);

    /**
     * Calculates the ceiling of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2f ceil();

    /**
     * Calculates the floor of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2f floor();

    /**
     * Rounds each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2f round();

    /**
     * Calculates the absolute value of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2f abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2f negate();

    /**
     * Finds the minimum between each component of this vector and the corresponding component in another Vector2f,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2f min(Vector2f v);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f min(double x, double y);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f min(float x, float y);

    /**
     * Finds the maximum between each component of this vector and the corresponding component in another Vector2f,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2f max(Vector2f v);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f max(double x, double y);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2f max(float x, float y);

    /**
     * Gets the square of the distance between this vector and another Vector2f.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    float distanceSquared(Vector2f v);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The square of the distance between the two
     */
    float distanceSquared(double x, double y);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The square of the distance between the two
     */
    float distanceSquared(float x, float y);

    /**
     * Gets the distance between this vector and another Vector2f.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    float distance(Vector2f v);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The distance between the two
     */
    float distance(double x, double y);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The distance between the two
     */
    float distance(float x, float y);

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
    Vector2f normalize();

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
     * Returns this vector as a Vector3f, using the value 0 for component z.
     *
     * @return This vector as a Vector3f
     */
    Vector3f toVector3();

    /**
     * Returns this vector as a Vector3f, using the provided value for component z.
     * 
     * @param z The z component value to be used
     *
     * @return This vector as a Vector3f
     */
    Vector3f toVector3(double z);

    /**
     * Returns this vector as a Vector3f, using the provided value for component z.
     * 
     * @param z The z component value to be used
     *
     * @return This vector as a Vector3f
     */
    Vector3f toVector3(float z);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    float[] toArray();

    /**
     * Returns this vector as a Vector2i, by flooring the components.
     *
     * @return This vector as a Vector2i
     */
    Vector2i toInt();

    /**
     * Returns this vector as a Vector2d.
     *
     * @return This vector as a Vector2d
     */
    Vector2d toDouble();

    @Override
    int compareTo(Vector2f v);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector2f clone();

    /**
     * Returns a string representation of this vector in the form "(x, y)".
     *
     * @return This vector as a string
     */
    @Override
    String toString();

}
