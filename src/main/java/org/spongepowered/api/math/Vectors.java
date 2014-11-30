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

/**
 * Utility methods to work with vectors.
 */
public final class Vectors {

    private static final VectorFactory factory = null;

    private Vectors() {
    }

    /**
     * Create a new 2D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @return A new vector
     */
    public static Vector2d create2d(double x, double y) {
        return factory.create2d(x, y);
    }

    /**
     * Create a new 2D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @return A vector
     */
    public static Vector2f create2f(float x, float y) {
        return factory.create2f(x, y);
    }

    /**
     * Create a new 2D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @return A vector
     */
    public static Vector2i create2i(int x, int y) {
        return factory.create2i(x, y);
    }

    /**
     * Create a new 3D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @return A vector
     */
    public static Vector3d create3d(double x, double y, double z) {
        return factory.create3d(x, y, z);
    }

    /**
     * Create a new 3D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @return A vector
     */
    public static Vector3f create3f(float x, float y, float z) {
        return factory.create3f(x, y, z);
    }

    /**
     * Create a new 3D vector.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @return A vector
     */
    public static Vector3i create3i(int x, int y, int z) {
        return factory.create3i(x, y, z);
    }

}
