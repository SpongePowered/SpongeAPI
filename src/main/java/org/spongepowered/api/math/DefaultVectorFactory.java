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

class DefaultVectorFactory implements VectorFactory {

    @Override
    public Vector2d create2d(final double x, final double y) {
        return new DefaultVector2d(x, y);
    }

    @Override
    public Vector2f create2f(final float x, final float y) {
        return new DefaultVector2f(x, y);
    }

    @Override
    public Vector2i create2i(final int x, final int y) {
        return new DefaultVector2i(x, y);
    }

    @Override
    public Vector3d create3d(final double x, final double y, final double z) {
        return new DefaultVector3d(x, y, z);
    }

    @Override
    public Vector3f create3f(final float x, final float y, final float z) {
        return new DefaultVector3f(x, y, z);
    }

    @Override
    public Vector3i create3i(final int x, final int y, final int z) {
        return new DefaultVector3i(x, y, z);
    }

}
