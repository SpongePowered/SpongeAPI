/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.world.volume;

import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public interface Volume {

    Vector3i blockMin();

    Vector3i blockMax();

    Vector3i blockSize();

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #blockMin()} &lt;= position &lt;=
     * {@link #blockMax()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position has a block in this volume
     */
    default boolean containsBlock(final Vector3i position) {
        Objects.requireNonNull(position, "position");

        return this.containsBlock(position.x(), position.y(), position.z());
    }

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #blockMin()} &lt;= (x, y, z)
     * &gt;= {@link #blockMax()}</code>
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position has a block in this volume
     */
    boolean containsBlock(int x, int y, int z);

    default boolean isAreaAvailable(final Vector3i position) {
        Objects.requireNonNull(position, "position");

        return this.isAreaAvailable(position.x(), position.y(), position.z());
    }

    boolean isAreaAvailable(int x, int y, int z);
}
