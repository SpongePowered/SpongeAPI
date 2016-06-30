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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;

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
public class AABB {

    private final Vector3d min;
    private final Vector3d max;

    /**
     * Constructs a new bounding box from two opposite corners.
     * Fails the resulting box would be degenerate (a dimension is 0).
     *
     * @param firstCorner The first corner
     * @param secondCorner The second corner
     */
    public AABB(Vector3i firstCorner, Vector3i secondCorner) {
        this(firstCorner.toDouble(), secondCorner.toDouble());
    }

    /**
     * Constructs a new bounding box from two opposite corners.
     * Fails the resulting box would be degenerate (a dimension is 0).
     *
     * @param x1 The first corner x coordinate
     * @param y1 The first corner y coordinate
     * @param z1 The first corner z coordinate
     * @param x2 The second corner x coordinate
     * @param y2 The second corner y coordinate
     * @param z2 The second corner z coordinate
     */
    public AABB(double x1, double y1, double z1, double x2, double y2, double z2) {
        this(new Vector3d(x1, y1, z1), new Vector3d(x2, y2, z2));
    }

    /**
     * Constructs a new bounding box from two opposite corners.
     * Fails the resulting box would be degenerate (a dimension is 0).
     *
     * @param firstCorner The first corner
     * @param secondCorner The second corner
     */
    public AABB(Vector3d firstCorner, Vector3d secondCorner) {
        checkNotNull(firstCorner, "firstCorner");
        checkNotNull(secondCorner, "secondCorner");
        this.min = firstCorner.min(secondCorner);
        this.max = firstCorner.max(secondCorner);
        checkArgument(this.min.getX() != this.max.getX(), "The box is degenerate on x");
        checkArgument(this.min.getY() != this.max.getY(), "The box is degenerate on y");
        checkArgument(this.min.getZ() != this.max.getZ(), "The box is degenerate on z");
    }

    /**
     * The minimum corner of the box.
     *
     * @return The minimum corner
     */
    public Vector3d getMin() {
        return this.min;
    }

    /**
     * The maximum corner of the box.
     *
     * @return The maximum corner
     */
    public Vector3d getMax() {
        return this.max;
    }

    /**
     * Gets the size of the box.
     *
     * @return The size
     */
    public Vector3d getSize() {
        return this.max.sub(this.min);
    }

    /**
     * Checks if the bounding box contains a point.
     *
     * @param point The point to check
     * @return Whether or not the box contains the point
     */
    public boolean contains(Vector3i point) {
        checkNotNull(point, "point");
        return contains(point.getX(), point.getY(), point.getZ());
    }

    /**
     * Checks if the bounding box contains a point.
     *
     * @param point The point to check
     * @return Whether or not the box contains the point
     */
    public boolean contains(Vector3d point) {
        checkNotNull(point, "point");
        return contains(point.getX(), point.getY(), point.getZ());
    }

    /**
     * Checks if the bounding box contains a point.
     *
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     * @param z The z coordinate of the point
     * @return Whether or not the box contains the point
     */
    public boolean contains(double x, double y, double z) {
        return this.min.getX() <= x && this.max.getX() >= x &&
            this.min.getY() <= y && this.max.getY() >= y &&
            this.min.getZ() <= z && this.max.getZ() >= z;
    }

    /**
     * Checks if the bounding box intersects another.
     *
     * @param other The other bounding box to check
     * @return Whether this bounding box intersects with the other
     */
    public boolean intersects(AABB other) {
        checkNotNull(other, "other");
        return this.max.getX() >= other.getMin().getX() && other.getMax().getX() >= this.min.getX() &&
            this.max.getY() >= other.getMin().getY() && other.getMax().getY() >= this.min.getY() &&
            this.max.getZ() >= other.getMin().getZ() && other.getMax().getZ() >= this.min.getZ();
    }

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param offset The offset to apply
     * @return The new offset box
     */
    public AABB offset(Vector3i offset) {
        checkNotNull(offset, "offset");
        return offset(offset.getX(), offset.getY(), offset.getZ());
    }

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param offset The offset to apply
     * @return The new offset box
     */
    public AABB offset(Vector3d offset) {
        checkNotNull(offset, "offset");
        return offset(offset.getX(), offset.getY(), offset.getZ());
    }

    /**
     * Offsets this bounding box by a given amount and returns a new box.
     *
     * @param x The amount of offset for the x coordinate
     * @param y The amount of offset for the y coordinate
     * @param z The amount of offset for the z coordinate
     * @return The new offset box
     */
    public AABB offset(double x, double y, double z) {
        return new AABB(this.min.add(x, y, z), this.max.add(x, y, z));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AABB)) {
            return false;
        }
        final AABB aabb = (AABB) other;
        return this.min.equals(aabb.min) && this.max.equals(aabb.max);

    }

    @Override
    public int hashCode() {
        int result = this.min.hashCode();
        result = 31 * result + this.max.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AABB(" + this.min + " to " + this.max + ")";
    }

}
