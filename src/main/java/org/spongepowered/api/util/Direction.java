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

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.vector.Vector3d;

/**
 * Represent the 16 main and secondary cardinal directions plus up and down.
 * With the following assumptions:
 * <ul>
 * <li>{@link #NORTH} targeting towards -Z</li>
 * <li>{@link #EAST}  targeting towards +X</li>
 * <li>{@link #SOUTH} targeting towards +Z</li>
 * <li>{@link #WEST}  targeting towards -X</li>
 * <li>{@link #UP}    targeting towards +Y</li>
 * <li>{@link #DOWN}  targeting towards -Y</li>
 * </ul>
 */
public enum Direction {
    NORTH(new Vector3d(0, 0, -1), Flag.CARDINAL),
    NORTH_NORTHEAST(new Vector3d(C.S8, 0, -C.C8), Flag.SECONDARY_ORDINAL),
    NORTHEAST(new Vector3d(1, 0, -1), Flag.ORDINAL),
    EAST_NORTHEAST(new Vector3d(C.C8, 0, -C.S8), Flag.SECONDARY_ORDINAL),

    EAST(new Vector3d(1, 0, 0), Flag.CARDINAL),
    EAST_SOUTHEAST(new Vector3d(C.C8, 0, C.S8), Flag.SECONDARY_ORDINAL),
    SOUTHEAST(new Vector3d(1, 0, 1), Flag.ORDINAL),
    SOUTH_SOUTHEAST(new Vector3d(C.S8, 0, C.C8), Flag.SECONDARY_ORDINAL),

    SOUTH(new Vector3d(0, 0, 1), Flag.CARDINAL),
    SOUTH_SOUTHWEST(new Vector3d(-C.S8, 0, C.C8), Flag.SECONDARY_ORDINAL),
    SOUTHWEST(new Vector3d(-1, 0, 1), Flag.ORDINAL),
    WEST_SOUTHWEST(new Vector3d(-C.C8, 0, C.S8), Flag.SECONDARY_ORDINAL),

    WEST(new Vector3d(-1, 0, 0), Flag.CARDINAL),
    WEST_NORTHWEST(new Vector3d(-C.C8, 0, -C.S8), Flag.SECONDARY_ORDINAL),
    NORTHWEST(new Vector3d(-1, 0, -1), Flag.ORDINAL),
    NORTH_NORTHWEST(new Vector3d(-C.S8, 0, -C.C8), Flag.SECONDARY_ORDINAL),

    UP(new Vector3d(0, 1, 0), Flag.UPRIGHT),
    DOWN(new Vector3d(0, -1, 0), Flag.UPRIGHT),

    NONE(new Vector3d(0, 0, 0), 0);

    private static final Direction[] FULL_COMPASS = {
            NORTH, NORTH_NORTHEAST, NORTHEAST, EAST_NORTHEAST,
            EAST, EAST_SOUTHEAST, SOUTHEAST, SOUTH_SOUTHEAST,
            SOUTH, SOUTH_SOUTHWEST, SOUTHWEST, WEST_SOUTHWEST,
            WEST, WEST_NORTHWEST, NORTHWEST, NORTH_NORTHWEST,
    };
    private static final Direction[] CARDINAL_ONLY = {
            NORTH, EAST, SOUTH, WEST
    };
    private final Vector3d direction;
    private final int flags;
    private Direction opposite;

    static {
        NORTH.opposite = SOUTH;
        EAST.opposite = WEST;
        SOUTH.opposite = NORTH;
        WEST.opposite = EAST;

        UP.opposite = DOWN;
        DOWN.opposite = UP;

        NONE.opposite = NONE;

        NORTHEAST.opposite = SOUTHWEST;
        NORTHWEST.opposite = SOUTHEAST;
        SOUTHEAST.opposite = NORTHWEST;
        SOUTHWEST.opposite = NORTHEAST;

        WEST_NORTHWEST.opposite = EAST_SOUTHEAST;
        WEST_SOUTHWEST.opposite = EAST_NORTHEAST;
        NORTH_NORTHWEST.opposite = SOUTH_SOUTHEAST;
        NORTH_NORTHEAST.opposite = SOUTH_SOUTHWEST;
        EAST_SOUTHEAST.opposite = WEST_NORTHWEST;
        EAST_NORTHEAST.opposite = WEST_SOUTHWEST;
        SOUTH_SOUTHEAST.opposite = NORTH_NORTHWEST;
        SOUTH_SOUTHWEST.opposite = NORTH_NORTHEAST;
    }

    Direction(Vector3d vector3d, int flags) {
        if (vector3d.lengthSquared() == 0) {
            // Prevent normalization of the zero direction
            this.direction = vector3d;
        } else {
            this.direction = vector3d.normalize();
        }
        this.flags = flags;
    }

    /**
     * Gets the closest direction from the given vector. If the vector is the
     * 0-Vector, this method returns {@link #NONE}. If the vector has the same
     * horizontal and vertical length, a horizontal direction will be returned.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @return The closest horizontal direction.
     */
    public static Direction getClosest(Vector3d vector) {
        return getClosest(vector, false);
    }

    /**
     * Gets the closest direction from the given vector. If the vector is the
     * 0-Vector, this method returns {@link #NONE}. If the vector has the same
     * horizontal and vertical length, a horizontal direction will be returned.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @param cardinalOnly Only return cardinal directions
     * @return The closest horizontal direction.
     */
    public static Direction getClosest(Vector3d vector, boolean cardinalOnly) {
        if (vector.getY() * vector.getY() <= vector.getX() * vector.getX() + vector.getZ() * vector.getZ()) {
            return getClosestHorizontal(vector, cardinalOnly);
        } else if (vector.getY() > 0) {
            return UP;
        } else {
            return DOWN;
        }
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector (ignoring y), this method returns {@link #NONE}.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @return The closest horizontal direction.
     */
    public static Direction getClosestHorizontal(Vector3d vector) {
        return getClosestHorizontal(vector, false);
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector (ignoring y), this method returns {@link #NONE}.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @param cardinalOnly Only return cardinal directions
     * @return The closest horizontal direction.
     */
    public static Direction getClosestHorizontal(Vector3d vector, boolean cardinalOnly) {
        // Ignore vectors not in the xz plane
        if (Math.abs(vector.getX()) <= GenericMath.DBL_EPSILON && Math.abs(vector.getZ()) <= GenericMath.DBL_EPSILON) {
            return NONE;
        }
        // Normalize so it lies on the unit circle in xz
        vector = vector.normalize();
        // Get the angle from the x component and correct for complement with z
        double angle = TrigMath.acos(vector.getX());
        if (vector.getZ() < 0) {
            angle = TrigMath.TWO_PI - angle;
        }
        // Make the angle positive, offset for MC's system, then wrap in [0, 2pi)
        angle = (angle + TrigMath.TWO_PI + TrigMath.HALF_PI) % TrigMath.TWO_PI;
        // Use a direction set; it needs to be sorted and the directions evenly spaced
        final Direction[] set = cardinalOnly ? CARDINAL_ONLY : FULL_COMPASS;
        // Round to the closest index in the direction set
        return set[(int) Math.round(angle * set.length / TrigMath.TWO_PI)];
    }

    /**
     * Gets the direction associated with the given axis.
     *
     * @param axis The axis
     * @return The direction
     */
    public static Direction getFromAxis(final Axis axis) {
        switch (axis) {
            case X:
                return EAST;
            case Y:
                return UP;
            case Z:
                return SOUTH;
            default:
                throw new IllegalArgumentException(axis.name());
        }
    }

    /**
     * Gets the direction of the axis along the given {@link AxisDirection}.
     *
     * @param axis The axis
     * @param direction The direction along the axis
     * @return The direction
     */
    public static Direction getFromAxis(final Axis axis, final AxisDirection direction) {
        switch (direction) {
            case PLUS:
                return getFromAxis(axis);
            case ZERO:
                return NONE;
            case MINUS:
                return getFromAxis(axis).getOpposite();
            default:
                throw new IllegalArgumentException(axis.name());
        }
    }

    /**
     * Gets the opposite direction i.e. 180 degrees from this direction.
     *
     * @return The opposite direction
     */
    public Direction getOpposite() {
        return this.opposite;
    }

    /**
     * Returns whether the given direction is opposite this.
     *
     * @param d Direction to test
     * @return True if it is opposite
     */
    public boolean isOpposite(Direction d) {
        return this.opposite.equals(d);
    }

    /**
     * Return true if the direction is of a cardinal direction (north, west
     * east, and south).
     *
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component.</p>
     *
     * @return True if cardinal
     */
    public boolean isCardinal() {
        return (this.flags & Flag.CARDINAL) > 0;
    }

    /**
     * Return true if the direction is of an ordinal direction (northwest,
     * southwest, southeast, northeaast).
     *
     * @return True if ordinal
     */
    public boolean isOrdinal() {
        return (this.flags & Flag.ORDINAL) > 0;
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.).
     *
     * @return True if secondary ordinal
     */
    public boolean isSecondaryOrdinal() {
        return (this.flags & Flag.SECONDARY_ORDINAL) > 0;
    }

    /**
     * Return whether Y component is non-zero.
     *
     * @return True if the Y component is non-zero
     */
    public boolean isUpright() {
        return (this.flags & Flag.UPRIGHT) > 0;
    }

    /**
     * Get the Vector3d.
     *
     * @return The Vector3d
     */
    public Vector3d toVector3d() {
        return this.direction;
    }

    private interface C {

        double C8 = Math.cos(Math.PI / 8);
        double S8 = Math.sin(Math.PI / 8);
    }

    public static final class Flag {

        public static final int CARDINAL = 0x1;
        public static final int ORDINAL = 0x2;
        public static final int SECONDARY_ORDINAL = 0x4;
        public static final int UPRIGHT = 0x8;

        public static final int ALL = CARDINAL | ORDINAL | SECONDARY_ORDINAL | UPRIGHT;

        private Flag() {
        }
    }

}
