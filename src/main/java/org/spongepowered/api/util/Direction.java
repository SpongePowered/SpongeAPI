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

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.spongepowered.api.data.type.StringRepresentable;
import org.spongepowered.math.GenericMath;
import org.spongepowered.math.TrigMath;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

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
public enum Direction implements StringRepresentable {
    NORTH(new Vector3d(0, 0, -1), Division.CARDINAL),
    NORTH_NORTHEAST(new Vector3d(C.S8, 0, -C.C8), Division.SECONDARY_ORDINAL),
    NORTHEAST(new Vector3d(1, 0, -1), Division.ORDINAL),
    EAST_NORTHEAST(new Vector3d(C.C8, 0, -C.S8), Division.SECONDARY_ORDINAL),

    EAST(new Vector3d(1, 0, 0), Division.CARDINAL),
    EAST_SOUTHEAST(new Vector3d(C.C8, 0, C.S8), Division.SECONDARY_ORDINAL),
    SOUTHEAST(new Vector3d(1, 0, 1), Division.ORDINAL),
    SOUTH_SOUTHEAST(new Vector3d(C.S8, 0, C.C8), Division.SECONDARY_ORDINAL),

    SOUTH(new Vector3d(0, 0, 1), Division.CARDINAL),
    SOUTH_SOUTHWEST(new Vector3d(-C.S8, 0, C.C8), Division.SECONDARY_ORDINAL),
    SOUTHWEST(new Vector3d(-1, 0, 1), Division.ORDINAL),
    WEST_SOUTHWEST(new Vector3d(-C.C8, 0, C.S8), Division.SECONDARY_ORDINAL),

    WEST(new Vector3d(-1, 0, 0), Division.CARDINAL),
    WEST_NORTHWEST(new Vector3d(-C.C8, 0, -C.S8), Division.SECONDARY_ORDINAL),
    NORTHWEST(new Vector3d(-1, 0, -1), Division.ORDINAL),
    NORTH_NORTHWEST(new Vector3d(-C.S8, 0, -C.C8), Division.SECONDARY_ORDINAL),

    UP(new Vector3d(0, 1, 0), Division.CARDINAL),
    DOWN(new Vector3d(0, -1, 0), Division.CARDINAL),

    NONE(new Vector3d(0, 0, 0), Division.NONE);

    private static final Direction[] SECONDARY_ORDINAL_SET = {
        Direction.NORTH, Direction.NORTH_NORTHEAST, Direction.NORTHEAST, Direction.EAST_NORTHEAST,
        Direction.EAST, Direction.EAST_SOUTHEAST, Direction.SOUTHEAST, Direction.SOUTH_SOUTHEAST,
        Direction.SOUTH, Direction.SOUTH_SOUTHWEST, Direction.SOUTHWEST, Direction.WEST_SOUTHWEST,
        Direction.WEST, Direction.WEST_NORTHWEST, Direction.NORTHWEST, Direction.NORTH_NORTHWEST,
    };
    private static final Direction[] ORDINAL_SET = {
        Direction.NORTH, Direction.NORTHEAST, Direction.EAST, Direction.SOUTHEAST,
        Direction.SOUTH, Direction.SOUTHWEST, Direction.WEST, Direction.NORTHWEST,
    };
    private static final Direction[] CARDINAL_SET = {
        Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST
    };
    private final Vector3d offset;
    private final Vector3i blockOffset;
    private final Division division;
    @SuppressWarnings("ImmutableEnumChecker")
    private @MonotonicNonNull Direction opposite;

    static {
        Direction.NORTH.opposite = Direction.SOUTH;
        Direction.EAST.opposite = Direction.WEST;
        Direction.SOUTH.opposite = Direction.NORTH;
        Direction.WEST.opposite = Direction.EAST;

        Direction.UP.opposite = Direction.DOWN;
        Direction.DOWN.opposite = Direction.UP;

        Direction.NONE.opposite = Direction.NONE;

        Direction.NORTHEAST.opposite = Direction.SOUTHWEST;
        Direction.NORTHWEST.opposite = Direction.SOUTHEAST;
        Direction.SOUTHEAST.opposite = Direction.NORTHWEST;
        Direction.SOUTHWEST.opposite = Direction.NORTHEAST;

        Direction.WEST_NORTHWEST.opposite = Direction.EAST_SOUTHEAST;
        Direction.WEST_SOUTHWEST.opposite = Direction.EAST_NORTHEAST;
        Direction.NORTH_NORTHWEST.opposite = Direction.SOUTH_SOUTHEAST;
        Direction.NORTH_NORTHEAST.opposite = Direction.SOUTH_SOUTHWEST;
        Direction.EAST_SOUTHEAST.opposite = Direction.WEST_NORTHWEST;
        Direction.EAST_NORTHEAST.opposite = Direction.WEST_SOUTHWEST;
        Direction.SOUTH_SOUTHEAST.opposite = Direction.NORTH_NORTHWEST;
        Direction.SOUTH_SOUTHWEST.opposite = Direction.NORTH_NORTHEAST;
    }

    Direction(Vector3d direction, Division division) {
        if (direction.lengthSquared() == 0) {
            // Prevent normalization of the zero direction
            this.offset = direction;
        } else {
            this.offset = direction.normalize();
        }
        this.blockOffset = direction.round().toInt();
        this.division = division;
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
    public static Direction closest(Vector3d vector) {
        return Direction.closest(vector, Division.SECONDARY_ORDINAL);
    }

    /**
     * Gets the closest direction from the given vector. If the vector is the
     * 0-Vector, this method returns {@link #NONE}. If the vector has the same
     * horizontal and vertical length, a horizontal direction will be returned.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @param smallestDivision The smallest compass division that can be
     *     returned
     * @return The closest horizontal direction.
     */
    public static Direction closest(Vector3d vector, Division smallestDivision) {
        if (vector.y() * vector.y() <= vector.x() * vector.x() + vector.z() * vector.z()) {
            return Direction.closestHorizontal(vector, smallestDivision);
        } else if (vector.y() > 0) {
            return Direction.UP;
        } else {
            return Direction.DOWN;
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
    public static Direction closestHorizontal(Vector3d vector) {
        return Direction.closestHorizontal(vector, Division.SECONDARY_ORDINAL);
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector (ignoring y), this method returns {@link #NONE}.
     * If the vector is halfway between two directions the clockwise next will
     * be selected.
     *
     * @param vector The vector to convert to a direction
     * @param smallestDivision The smallest compass division that can be
     *     returned
     * @return The closest horizontal direction.
     */
    public static Direction closestHorizontal(Vector3d vector, Division smallestDivision) {
        // Ignore vectors not in the xz plane
        if (Math.abs(vector.x()) <= GenericMath.DBL_EPSILON && Math.abs(vector.z()) <= GenericMath.DBL_EPSILON) {
            return Direction.NONE;
        }
        // Normalize so it lies on the unit circle in xz
        vector = vector.normalize();
        // Get the angle from the x component and correct for complement with z
        double angle = TrigMath.acos(vector.x());
        if (vector.z() < 0) {
            angle = TrigMath.TWO_PI - angle;
        }
        // Make the angle positive, offset for MC's system, then wrap in [0, 2pi)
        angle = (angle + TrigMath.TWO_PI + TrigMath.HALF_PI) % TrigMath.TWO_PI;
        // Use a direction set; it needs to be sorted and the directions evenly spaced
        final Direction[] set;
        switch (smallestDivision) {
            case CARDINAL:
                set = Direction.CARDINAL_SET;
                break;
            case ORDINAL:
                set = Direction.ORDINAL_SET;
                break;
            case SECONDARY_ORDINAL:
                set = Direction.SECONDARY_ORDINAL_SET;
                break;
            default:
                throw new IllegalArgumentException(smallestDivision.name());
        }
        // Round to the closest index in the direction set
        return set[(int) Math.round(angle * set.length / TrigMath.TWO_PI) % set.length];
    }

    /**
     * Gets the direction associated with the given axis.
     *
     * @param axis The axis
     * @return The direction
     */
    public static Direction fromAxis(final Axis axis) {
        switch (axis) {
            case X:
                return Direction.EAST;
            case Y:
                return Direction.UP;
            case Z:
                return Direction.SOUTH;
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
    public static Direction fromAxis(final Axis axis, final AxisDirection direction) {
        switch (direction) {
            case PLUS:
                return Direction.fromAxis(axis);
            case ZERO:
                return Direction.NONE;
            case MINUS:
                return Direction.fromAxis(axis).opposite();
            default:
                throw new IllegalArgumentException(axis.name());
        }
    }

    /**
     * Gets the opposite direction i.e. 180 degrees from this direction.
     *
     * @return The opposite direction
     */
    public Direction opposite() {
        return this.opposite;
    }

    /**
     * Returns whether the given direction is opposite this.
     *
     * @param d Direction to test
     * @return True if it is opposite
     */
    public boolean isOpposite(Direction d) {
        return this.opposite == d;
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
        return this.division == Division.CARDINAL;
    }

    /**
     * Return true if the direction is of an ordinal direction (northwest,
     * southwest, southeast, northeast).
     *
     * @return True if ordinal
     */
    public boolean isOrdinal() {
        return this.division == Division.ORDINAL;
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.).
     *
     * @return True if secondary ordinal
     */
    public boolean isSecondaryOrdinal() {
        return this.division == Division.SECONDARY_ORDINAL;
    }

    /**
     * Return whether Y component is non-zero.
     *
     * @return True if the Y component is non-zero
     */
    public boolean isUpright() {
        return this == Direction.UP || this == Direction.DOWN;
    }

    /**
     * Returns the direction as a unit offset vector.
     * This vector is also suitable as a unit direction vector.
     *
     * @return The direction as an offset
     */
    public Vector3d asOffset() {
        return this.offset;
    }

    /**
     * Returns the direction as a block offset vector.
     * For secondary ordinals the results are approximated to the nearest
     * block.
     *
     * <p>The difference between this offset and {@link #asOffset()} is that
     * a block offset has unit components instead of unit length.</p>
     *
     * @return The direction as a block offset
     */
    public Vector3i asBlockOffset() {
        return this.blockOffset;
    }

    @Override
    public String serializationString() {
        return this.name();
    }

    private interface C {

        double C8 = Math.cos(Math.PI / 8);
        double S8 = Math.sin(Math.PI / 8);

    }

    /**
     * The compass division supported by this direction implementation.
     */
    public enum Division {

        CARDINAL,
        ORDINAL,
        SECONDARY_ORDINAL,
        NONE

    }

}
