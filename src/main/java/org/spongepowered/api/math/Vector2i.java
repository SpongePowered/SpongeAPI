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
 * Represent a 2 component vector using ints.
 * It is immutable and all vectors returned by the methods are new instances.
 * Double overloads are floored to ints before the operation, and int vectors are returned.
 */
public interface Vector2i extends Comparable<Vector2i>, Serializable, Cloneable {
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
     * Adds another Vector2i to this one, returning the results as new vector.
     *
     * @param v The vector to add
     * @return The results of the operation as a new vector
     */
    Vector2i add(Vector2i v);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i add(double x, double y);

    /**
     * Adds the vector components to this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i add(int x, int y);

    /**
     * Subtracts another Vector2i to this one, returning the results as new vector.
     *
     * @param v The vector to subtract
     * @return The results of the operation as a new vector
     */
    Vector2i sub(Vector2i v);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i sub(double x, double y);

    /**
     * Subtracts the vector components from this vector, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i sub(int x, int y);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2i mul(double a);

    /**
     * Multiplies each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2i mul(int a);

    /**
     * Multiplies each component of this vector by the corresponding component in another Vector2i,
     * returning the results as new vector.
     *
     * @param v The vector to multiply by
     * @return The results of the operation as a new vector
     */
    Vector2i mul(Vector2i v);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i mul(double x, double y);

    /**
     * Multiplies each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i mul(int x, int y);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector2i div(double a);

    /**
     * Divides each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to divide by
     * @return The results of the operation as a new vector
     */
    Vector2i div(int a);

    /**
     * Divides each component of this vector by the corresponding component in another Vector2i,
     * returning the results as new vector.
     *
     * @param v The vector to divide by
     * @return The results of the operation as a new vector
     */
    Vector2i div(Vector2i v);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i div(double x, double y);

    /**
     * Divides each component of this vector by the corresponding component, returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i div(int x, int y);

    /**
     * Dots another Vector2i with this one.
     *
     * @param v The vector to dot with
     * @return The results of the operation
     */
    int dot(Vector2i v);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation
     */
    int dot(double x, double y);

    /**
     * Dots the vector components with this vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation
     */
    int dot(int x, int y);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector2i pow(double pow);

    /**
     * Raises each component of this vector by the value, returning the results as new vector.
     *
     * @param a The value to raise by
     * @return The results of the operation as a new vector
     */
    Vector2i pow(int power);

    /**
     * Calculates the absolute value of each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2i abs();

    /**
     * Negates each component, returning the result as a new vector.
     *
     * @return The results of the operation
     */
    Vector2i negate();

    /**
     * Finds the minimum between each component of this vector and the corresponding component in another Vector2i,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2i min(Vector2i v);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i min(double x, double y);

    /**
     * Finds the minimum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i min(int x, int y);

    /**
     * Finds the maximum between each component of this vector and the corresponding component in another Vector2i,
     * returning the results as new vector.
     *
     * @param v The vector to compare
     * @return The results of the operation as a new vector
     */
    Vector2i max(Vector2i v);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i max(double x, double y);

    /**
     * Finds the maximum between each component of this vector and the corresponding component,
     * returning the results as new vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The results of the operation as a new vector
     */
    Vector2i max(int x, int y);

    /**
     * Gets the square of the distance between this vector and another Vector2i.
     *
     * @param v The other vector
     * @return The square of the distance between the two
     */
    int distanceSquared(Vector2i v);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The square of the distance between the two
     */
    int distanceSquared(double x, double y);

    /**
     * Gets the square of the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The square of the distance between the two
     */
    int distanceSquared(int x, int y);

    /**
     * Gets the distance between this vector and another Vector2i.
     *
     * @param v The other vector
     * @return The distance between the two
     */
    int distance(Vector2i v);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The distance between the two
     */
    int distance(double x, double y);

    /**
     * Gets the distance between this vector and the components of another vector.
     *
     * @param x The x component
     * @param y The y component
     * @return The distance between the two
     */
    int distance(int x, int y);

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

    /**
     * Returns this vector as a Vector3i, using the value 0 for component z.
     *
     * @return This vector as a Vector3i
     */
    Vector3i toVector3();

    /**
     * Returns this vector as a Vector3i, using the provided value for component z.
     *
     * @return This vector as a Vector3i
     */
    Vector3i toVector3(double z);

    /**
     * Returns this vector as a Vector3i, using the provided value for component z.
     *
     * @return This vector as a Vector3i
     */
    Vector3i toVector3(int z);

    /**
     * Returns this vector as an array.
     *
     * @return This vector as an array.
     */
    int[] toArray();

    /**
     * Returns this vector as a Vector2f.
     *
     * @return This vector as a Vector2f
     */
    Vector2f toFloat();

    /**
     * Returns this vector as a Vector2d.
     *
     * @return This vector as a Vector2d
     */
    Vector2d toDouble();

    int compareTo(Vector2i v);

    boolean equals(Object o);

    int hashCode();

    /**
     * Returns a deep copy of this vector.
     *
     * @return A deep copy
     */
    Vector2i clone();

    /**
     * Returns a string representation of this vector in the form "(x, y)".
     *
     * @return This vector as a string
     */
    String toString();
}
