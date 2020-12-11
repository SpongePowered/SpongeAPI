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
package org.spongepowered.api.util;

import org.spongepowered.api.Sponge;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.Optional;

/**
 * An axis aligned bounding box. That is, an un-rotated cuboid.
 * It is represented by its minimum and maximum corners.
 *
 * <p>The box will never be degenerate: the corners are always not equal and
 * respect the minimum and maximum properties.</p>
 *
 * <p>This class is immutable, all objects returned are either new instances or
 * itself.</p>
 */
public interface AABB {
    /**
     * Creates a new bounding box from two opposite corners.
     *
     * <p>Fails the resulting box would be degenerate (a dimension is 0).</p>
     *
     * @param v1 The first corner
     * @param v2 The second corner
     * @return An AABB
     */
    static AABB of(final Vector3d v1, final Vector3d v2) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).create(v1, v2);
    }

    /**
     * Creates a new bounding box from two opposite corners.
     *
     * <p>Fails the resulting box would be degenerate (a dimension is 0).</p>
     *
     * @param v1 The first corner
     * @param v2 The second corner
     * @return An AABB
     */
    static AABB of(final Vector3i v1, final Vector3i v2) {
        return AABB.of(Objects.requireNonNull(v1, "v1").toDouble(), Objects.requireNonNull(v2, "v2").toDouble());
    }

    /**
     * Creates a new bounding box from two opposite corners.
     *
     * <p>Fails the resulting box would be degenerate (a dimension is 0).</p>
     *
     * @param x1 The first corner x coordinate
     * @param y1 The first corner y coordinate
     * @param z1 The first corner z coordinate
     * @param x2 The second corner x coordinate
     * @param y2 The second corner y coordinate
     * @param z2 The second corner z coordinate
     */
    static AABB of(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return AABB.of(new Vector3d(x1, y1, z1), new Vector3d(x2, y2, z2));
    }

    /**
     * The minimum corner of the box.
     *
     * @return The minimum corner
     */
    Vector3d getMin();

    /**
     * The maximum corner of the box.
     *
     * @return The maximum corner
     */
    Vector3d getMax();

    /**
     * Returns the center of the box, halfway between each corner.
     *
     * @return The center
     */
    Vector3d getCenter();

    /**
     * Gets the size of the box.
     *
     * @return The size
     */
    Vector3d getSize();

    /**
     * Checks if the bounding box contains a point.
     *
     * @param point The point to check
     * @return Whether or not the box contains the point
     */
    default boolean contains(final Vector3i point) {
        Objects.requireNonNull(point, "point");
        return this.contains(point.getX(), point.getY(), point.getZ());
    }

    /**
     * Checks if the bounding box contains a point.
     *
     * @param point The point to check
     * @return Whether or not the box contains the point
     */
    default boolean contains(final Vector3d point) {
        Objects.requireNonNull(point, "point");
        return this.contains(point.getX(), point.getY(), point.getZ());
    }

    /**
     * Checks if the bounding box contains a point.
     *
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     * @param z The z coordinate of the point
     * @return Whether or not the box contains the point
     */
    boolean contains(final double x, final double y, final double z);

    /**
     * Checks if the bounding box intersects another.
     *
     * @param other The other bounding box to check
     * @return Whether this bounding box intersects with the other
     */
    boolean intersects(final AABB other);

    /**
     * Tests for intersection between the box and a ray defined by a starting
     * point and a direction.
     *
     * @param start The starting point of the ray
     * @param direction The direction of the ray
     * @return An intersection point its normal, if any
     */
    Optional<Tuple<Vector3d, Vector3d>> intersects(final Vector3d start, final Vector3d direction);

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param offset The offset to apply
     * @return The new offset box
     */
    default AABB offset(final Vector3i offset) {
        Objects.requireNonNull(offset, "offset");
        return this.offset(offset.getX(), offset.getY(), offset.getZ());
    }

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param offset The offset to apply
     * @return The new offset box
     */
    default AABB offset(final Vector3d offset) {
        Objects.requireNonNull(offset, "offset");
        return this.offset(offset.getX(), offset.getY(), offset.getZ());
    }

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param x The amount of offset for the x coordinate
     * @param y The amount of offset for the y coordinate
     * @param z The amount of offset for the z coordinate
     * @return The new offset box
     */
    AABB offset(final double x, final double y, final double z);

    /**
     * Expands this bounding box by a given amount in both directions and
     * returns a new box. The expansion is applied half and half to the
     * minimum and maximum corners.
     *
     * @param amount The amount of expansion to apply
     * @return The new expanded box
     */
    default AABB expand(final Vector3i amount) {
        Objects.requireNonNull(amount, "amount");
        return this.expand(amount.getX(), amount.getY(), amount.getZ());
    }

    /**
     * Expands this bounding box by a given amount in both directions and
     * returns a new box. The expansion is applied half and half to the
     * minimum and maximum corners.
     *
     * @param amount The amount of expansion to apply
     * @return The new expanded box
     */
    default AABB expand(final Vector3d amount) {
        Objects.requireNonNull(amount, "amount");
        return this.expand(amount.getX(), amount.getY(), amount.getZ());
    }

    /**
     * Expands this bounding box by a given amount in both directions and
     * returns a new box. The expansion is applied half and half to the
     * minimum and maximum corners.
     *
     * @param x The amount of expansion for the x coordinate
     * @param y The amount of expansion for the y coordinate
     * @param z The amount of expansion for the z coordinate
     * @return The new expanded box
     */
    AABB expand(final double x, final double y, final double z);

    interface Factory {
        AABB create(final Vector3d v1, final Vector3d v2);
    }
}
