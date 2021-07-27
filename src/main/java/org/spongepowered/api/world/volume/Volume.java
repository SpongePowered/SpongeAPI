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

import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

/**
 * A volume is a bounded cuboid that is a view to some collection of objects
 * with position. Such a cuboid is always aligned along the cartesian axes
 * in 3D space with the bounds specified in block-position space.
 */
public interface Volume {

    /**
     * The minimum valid position in this volume.
     *
     * @return The minimum valid position
     */
    Vector3i min();

    /**
     * The maximum valid position in this volume.
     *
     * @return The maximum valid position
     */
    Vector3i max();

    /**
     * The size of this region, defined as the difference between {@link #max()}
     * and {@link #min()}, plus {@link Vector3i#ONE}.
     *
     * @return The size of the volume.
     */
    default Vector3i size() {
        return this.max().sub(this.min()).add(Vector3i.ONE);
    }

    /**
     * Returns true if the supplied co-ordinate is valid within this
     * volume. This is defined as <code>{{@link #min()} &lt;= (x, y, z)
     * &gt;= {@link #max()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position is within this volume
     */
    default boolean contains(final Vector3i position) {
        Objects.requireNonNull(position, "position");

        return this.contains(position.x(), position.y(), position.z());
    }

    /**
     * Returns true if the supplied co-ordinate is valid within this
     * volume. This is defined as <code>{{@link #min()} &lt;= (x, y, z)
     * &gt;= {@link #max()}</code>
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position is within this volume
     */
    boolean contains(int x, int y, int z);

    /**
     * Returns true if {@link #contains(Vector3i)} is true and the
     * backing data is actually loaded - e.g. for a {@link ServerWorld}, this
     * will only return true if the {@link WorldChunk} that contains this co-ordinate
     * is fully loaded.
     *
     * @param position The position to check
     * @return Whether or not the position is within this volume
     *         <strong>and</strong> the location is loaded.
     */
    default boolean available(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.isAreaAvailable(position.x(), position.y(), position.z());
    }

    /**
     * Returns true if {@link #contains(int, int, int)} is true and the
     * backing data is actually loaded - e.g. for a {@link ServerWorld}, this
     * will only return true if the {@link WorldChunk} that contains this co-ordinate
     * is fully loaded.
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position is within this volume
     *         <strong>and</strong> the location is loaded.
     */
    boolean isAreaAvailable(int x, int y, int z);
}
