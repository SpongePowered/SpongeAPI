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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import javax.annotation.Nullable;

import com.flowpowered.math.vector.Vector3d;

/**
 * Represents all unit vector directions, exactly 22.5 degrees apart from at least one other direction
 * in only one of either yaw or pitch. This also includes a {@link #NONE} vector.
 * <p/>
 * Using the Minecraft direction system:
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
    // NORTH
    THREEQUARTERSUPNORTH_NORTHWEST(DirectionVectors.THREEQUARTERSUPNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSUP_NORTH(DirectionVectors.THREEQUARTERSUP_NORTH, Division.CARDINAL, true),
    THREEQUARTERSUPNORTH_NORTHEAST(DirectionVectors.THREEQUARTERSUPNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFUPNORTH_NORTHWEST(DirectionVectors.HALFUPNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFUP_NORTH(DirectionVectors.HALFUP_NORTH, Division.CARDINAL, true),
    HALFUPNORTH_NORTHEAST(DirectionVectors.HALFUPNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERUPNORTH_NORTHWEST(DirectionVectors.QUARTERUPNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERUP_NORTH(DirectionVectors.QUARTERUP_NORTH, Division.CARDINAL, true),
    QUARTERUPNORTH_NORTHEAST(DirectionVectors.QUARTERUPNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),

    NORTH_NORTHWEST(DirectionVectors.NORTH_NORTHWEST, Division.SECONDARY_ORDINAL, false),
    NORTH(DirectionVectors.NORTH, Division.CARDINAL, false),
    NORTH_NORTHEAST(DirectionVectors.NORTH_NORTHEAST, Division.SECONDARY_ORDINAL, false),

    QUARTERDOWNNORTH_NORTHWEST(DirectionVectors.QUARTERDOWNNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERDOWN_NORTH(DirectionVectors.QUARTERDOWN_NORTH, Division.CARDINAL, true),
    QUARTERDOWNNORTH_NORTHEAST(DirectionVectors.QUARTERDOWNNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFDOWNNORTH_NORTHWEST(DirectionVectors.HALFDOWNNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFDOWN_NORTH(DirectionVectors.HALFDOWN_NORTH, Division.CARDINAL, true),
    HALFDOWNNORTH_NORTHEAST(DirectionVectors.HALFDOWNNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWNNORTH_NORTHWEST(DirectionVectors.THREEQUARTERSDOWNNORTH_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWN_NORTH(DirectionVectors.THREEQUARTERSDOWN_NORTH, Division.CARDINAL, true),
    THREEQUARTERSDOWNNORTH_NORTHEAST(DirectionVectors.THREEQUARTERSDOWNNORTH_NORTHEAST, Division.SECONDARY_ORDINAL, true),

    // NORTHEAST
    THREEQUARTERSUP_NORTHEAST(DirectionVectors.THREEQUARTERSUP_NORTHEAST, Division.ORDINAL, true),
    HALFUP_NORTHEAST(DirectionVectors.HALFUP_NORTHEAST, Division.ORDINAL, true),
    QUARTERUP_NORTHEAST(DirectionVectors.QUARTERUP_NORTHEAST, Division.ORDINAL, true),
    NORTHEAST(DirectionVectors.NORTHEAST, Division.ORDINAL, false),
    QUARTERDOWN_NORTHEAST(DirectionVectors.QUARTERDOWN_NORTHEAST, Division.ORDINAL, true),
    HALFDOWN_NORTHEAST(DirectionVectors.HALFDOWN_NORTHEAST, Division.ORDINAL, true),
    THREEQUARTERSDOWN_NORTHEAST(DirectionVectors.THREEQUARTERSDOWN_NORTHEAST, Division.ORDINAL, true),

    // EAST
    THREEQUARTERSUPEAST_NORTHEAST(DirectionVectors.THREEQUARTERSUPEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSUP_EAST(DirectionVectors.THREEQUARTERSUP_NORTH, Division.CARDINAL, true),
    THREEQUARTERSUPEAST_SOUTHEAST(DirectionVectors.THREEQUARTERSUPEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFUPEAST_NORTHEAST(DirectionVectors.HALFUPEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFUP_EAST(DirectionVectors.HALFUP_NORTH, Division.CARDINAL, true),
    HALFUPEAST_SOUTHEAST(DirectionVectors.HALFUPEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERUPEAST_NORTHEAST(DirectionVectors.QUARTERUPEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERUP_EAST(DirectionVectors.QUARTERUP_NORTH, Division.CARDINAL, true),
    QUARTERUPEAST_SOUTHEAST(DirectionVectors.QUARTERUPEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),

    EAST_NORTHEAST(DirectionVectors.EAST_NORTHEAST, Division.SECONDARY_ORDINAL, false),
    EAST(DirectionVectors.NORTH, Division.CARDINAL, false),
    EAST_SOUTHEAST(DirectionVectors.EAST_SOUTHEAST, Division.SECONDARY_ORDINAL, false),

    QUARTERDOWNEAST_NORTHEAST(DirectionVectors.QUARTERDOWNEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERDOWN_EAST(DirectionVectors.QUARTERDOWN_NORTH, Division.CARDINAL, true),
    QUARTERDOWNEAST_SOUTHEAST(DirectionVectors.QUARTERDOWNEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFDOWNEAST_NORTHEAST(DirectionVectors.HALFDOWNEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFDOWN_EAST(DirectionVectors.HALFDOWN_NORTH, Division.CARDINAL, true),
    HALFDOWNEAST_SOUTHEAST(DirectionVectors.HALFDOWNEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWNEAST_NORTHEAST(DirectionVectors.THREEQUARTERSDOWNEAST_NORTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWN_EAST(DirectionVectors.THREEQUARTERSDOWN_NORTH, Division.CARDINAL, true),
    THREEQUARTERSDOWNEAST_SOUTHEAST(DirectionVectors.THREEQUARTERSDOWNEAST_SOUTHEAST, Division.SECONDARY_ORDINAL, true),

    // SOUTHEAST
    THREEQUARTERSUP_SOUTHEAST(DirectionVectors.THREEQUARTERSUP_SOUTHEAST, Division.ORDINAL, true),
    HALFUP_SOUTHEAST(DirectionVectors.HALFUP_SOUTHEAST, Division.ORDINAL, true),
    QUARTERUP_SOUTHEAST(DirectionVectors.QUARTERUP_SOUTHEAST, Division.ORDINAL, true),
    SOUTHEAST(DirectionVectors.SOUTHEAST, Division.ORDINAL, false),
    QUARTERDOWN_SOUTHEAST(DirectionVectors.QUARTERDOWN_SOUTHEAST, Division.ORDINAL, true),
    HALFDOWN_SOUTHEAST(DirectionVectors.HALFDOWN_SOUTHEAST, Division.ORDINAL, true),
    THREEQUARTERSDOWN_SOUTHEAST(DirectionVectors.THREEQUARTERSDOWN_SOUTHEAST, Division.ORDINAL, true),

    // SOUTH
    THREEQUARTERSUPSOUTH_SOUTHEAST(DirectionVectors.THREEQUARTERSUPSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSUP_SOUTH(DirectionVectors.THREEQUARTERSUP_NORTH, Division.CARDINAL, true),
    THREEQUARTERSUPSOUTH_SOUTHWEST(DirectionVectors.THREEQUARTERSUPSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFUPSOUTH_SOUTHEAST(DirectionVectors.HALFUPSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFUP_SOUTH(DirectionVectors.HALFUP_NORTH, Division.CARDINAL, true),
    HALFUPSOUTH_SOUTHWEST(DirectionVectors.HALFUPSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERUPSOUTH_SOUTHEAST(DirectionVectors.QUARTERUPSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERUP_SOUTH(DirectionVectors.QUARTERUP_NORTH, Division.CARDINAL, true),
    QUARTERUPSOUTH_SOUTHWEST(DirectionVectors.QUARTERUPSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),

    SOUTH_SOUTHEAST(DirectionVectors.SOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, false),
    SOUTH(DirectionVectors.NORTH, Division.CARDINAL, false),
    SOUTH_SOUTHWEST(DirectionVectors.SOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, false),

    QUARTERDOWNSOUTH_SOUTHEAST(DirectionVectors.QUARTERDOWNSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    QUARTERDOWN_SOUTH(DirectionVectors.QUARTERDOWN_NORTH, Division.CARDINAL, true),
    QUARTERDOWNSOUTH_SOUTHWEST(DirectionVectors.QUARTERDOWNSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFDOWNSOUTH_SOUTHEAST(DirectionVectors.HALFDOWNSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    HALFDOWN_SOUTH(DirectionVectors.HALFDOWN_NORTH, Division.CARDINAL, true),
    HALFDOWNSOUTH_SOUTHWEST(DirectionVectors.HALFDOWNSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWNSOUTH_SOUTHEAST(DirectionVectors.THREEQUARTERSDOWNSOUTH_SOUTHEAST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWN_SOUTH(DirectionVectors.THREEQUARTERSDOWN_NORTH, Division.CARDINAL, true),
    THREEQUARTERSDOWNSOUTH_SOUTHWEST(DirectionVectors.THREEQUARTERSDOWNSOUTH_SOUTHWEST, Division.SECONDARY_ORDINAL, true),

    // SOUTHWEST
    THREEQUARTERSUP_SOUTHWEST(DirectionVectors.THREEQUARTERSUP_SOUTHWEST, Division.ORDINAL, true),
    HALFUP_SOUTHWEST(DirectionVectors.HALFUP_SOUTHWEST, Division.ORDINAL, true),
    QUARTERUP_SOUTHWEST(DirectionVectors.QUARTERUP_SOUTHWEST, Division.ORDINAL, true),
    SOUTHWEST(DirectionVectors.SOUTHWEST, Division.ORDINAL, false),
    QUARTERDOWN_SOUTHWEST(DirectionVectors.QUARTERDOWN_SOUTHWEST, Division.ORDINAL, true),
    HALFDOWN_SOUTHWEST(DirectionVectors.HALFDOWN_SOUTHWEST, Division.ORDINAL, true),
    THREEQUARTERSDOWN_SOUTHWEST(DirectionVectors.THREEQUARTERSDOWN_SOUTHWEST, Division.ORDINAL, true),

    // WEST`
    THREEQUARTERSUPWEST_SOUTHWEST(DirectionVectors.THREEQUARTERSUPWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSUP_WEST(DirectionVectors.THREEQUARTERSUP_NORTH, Division.CARDINAL, true),
    THREEQUARTERSUPWEST_NORTHWEST(DirectionVectors.THREEQUARTERSUPWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFUPWEST_SOUTHWEST(DirectionVectors.HALFUPWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFUP_WEST(DirectionVectors.HALFUP_NORTH, Division.CARDINAL, true),
    HALFUPWEST_NORTHWEST(DirectionVectors.HALFUPWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERUPWEST_SOUTHWEST(DirectionVectors.QUARTERUPWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERUP_WEST(DirectionVectors.QUARTERUP_NORTH, Division.CARDINAL, true),
    QUARTERUPWEST_NORTHWEST(DirectionVectors.QUARTERUPWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),

    WEST_SOUTHWEST(DirectionVectors.WEST_SOUTHWEST, Division.SECONDARY_ORDINAL, false),
    WEST(DirectionVectors.NORTH, Division.CARDINAL, false),
    WEST_NORTHWEST(DirectionVectors.WEST_NORTHWEST, Division.SECONDARY_ORDINAL, false),

    QUARTERDOWNWEST_SOUTHWEST(DirectionVectors.QUARTERDOWNWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    QUARTERDOWN_WEST(DirectionVectors.QUARTERDOWN_NORTH, Division.CARDINAL, true),
    QUARTERDOWNWEST_NORTHWEST(DirectionVectors.QUARTERDOWNWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFDOWNWEST_SOUTHWEST(DirectionVectors.HALFDOWNWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    HALFDOWN_WEST(DirectionVectors.HALFDOWN_NORTH, Division.CARDINAL, true),
    HALFDOWNWEST_NORTHWEST(DirectionVectors.HALFDOWNWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWNWEST_SOUTHWEST(DirectionVectors.THREEQUARTERSDOWNWEST_SOUTHWEST, Division.SECONDARY_ORDINAL, true),
    THREEQUARTERSDOWN_WEST(DirectionVectors.THREEQUARTERSDOWN_NORTH, Division.CARDINAL, true),
    THREEQUARTERSDOWNWEST_NORTHWEST(DirectionVectors.THREEQUARTERSDOWNWEST_NORTHWEST, Division.SECONDARY_ORDINAL, true),

    // NORTHWEST
    THREEQUARTERSUP_NORTHWEST(DirectionVectors.THREEQUARTERSUP_NORTHWEST, Division.ORDINAL, true),
    HALFUP_NORTHWEST(DirectionVectors.HALFUP_NORTHWEST, Division.ORDINAL, true),
    QUARTERUP_NORTHWEST(DirectionVectors.QUARTERUP_NORTHWEST, Division.ORDINAL, true),
    NORTHWEST(DirectionVectors.NORTHWEST, Division.ORDINAL, false),
    QUARTERDOWN_NORTHWEST(DirectionVectors.QUARTERDOWN_NORTHWEST, Division.ORDINAL, true),
    HALFDOWN_NORTHWEST(DirectionVectors.HALFDOWN_NORTHWEST, Division.ORDINAL, true),
    THREEQUARTERSDOWN_NORTHWEST(DirectionVectors.THREEQUARTERSDOWN_NORTHWEST, Division.ORDINAL, true),

    // CENTER
    UP(DirectionVectors.UP, Division.CARDINAL, true),
    NONE(DirectionVectors.NONE, Division.NONE, false),
    DOWN(DirectionVectors.DOWN, Division.CARDINAL, true);

    private final Vector3d vector;
    private final Division division;
    @SuppressWarnings("NullableProblems")
    private Direction opposite;
    private final boolean isUpright;

    static {
        // NORTH
        THREEQUARTERSUPNORTH_NORTHWEST.opposite = THREEQUARTERSDOWNSOUTH_SOUTHEAST;
        THREEQUARTERSUP_NORTH.opposite = THREEQUARTERSDOWN_SOUTH;
        THREEQUARTERSUPNORTH_NORTHEAST.opposite = THREEQUARTERSDOWN_SOUTHWEST;
        HALFUPNORTH_NORTHWEST.opposite = HALFDOWNSOUTH_SOUTHEAST;
        HALFUP_NORTH.opposite = HALFDOWN_SOUTH;
        HALFUPNORTH_NORTHEAST.opposite = HALFDOWNSOUTH_SOUTHWEST;
        QUARTERUPNORTH_NORTHWEST.opposite = QUARTERDOWNSOUTH_SOUTHEAST;
        QUARTERUP_NORTH.opposite = QUARTERDOWN_SOUTH;
        QUARTERUPNORTH_NORTHEAST.opposite = QUARTERDOWNSOUTH_SOUTHWEST;

        NORTH_NORTHWEST.opposite = SOUTH_SOUTHEAST;
        NORTH.opposite = SOUTH;
        NORTH_NORTHEAST.opposite = SOUTH_SOUTHWEST;

        QUARTERDOWNNORTH_NORTHWEST.opposite = QUARTERUPSOUTH_SOUTHEAST;
        QUARTERDOWN_NORTH.opposite = QUARTERUP_SOUTH;
        QUARTERDOWNNORTH_NORTHEAST.opposite = QUARTERUPSOUTH_SOUTHWEST;
        HALFDOWNNORTH_NORTHWEST.opposite = HALFUPSOUTH_SOUTHEAST;
        HALFDOWN_NORTH.opposite = HALFUP_SOUTH;
        HALFDOWNNORTH_NORTHEAST.opposite = HALFUPSOUTH_SOUTHWEST;
        THREEQUARTERSDOWNNORTH_NORTHWEST.opposite = THREEQUARTERSUPSOUTH_SOUTHEAST;
        THREEQUARTERSDOWN_NORTH.opposite = THREEQUARTERSUP_SOUTH;
        THREEQUARTERSDOWNNORTH_NORTHEAST.opposite = THREEQUARTERSUPSOUTH_SOUTHWEST;

        // NORTHEAST;
        THREEQUARTERSUP_NORTHEAST.opposite = THREEQUARTERSDOWN_SOUTHWEST;
        HALFUP_NORTHEAST.opposite = HALFDOWN_SOUTHWEST;
        QUARTERUP_NORTHEAST.opposite = QUARTERDOWN_SOUTHWEST;
        NORTHEAST.opposite = SOUTHWEST;
        QUARTERDOWN_NORTHEAST.opposite = QUARTERUP_SOUTHWEST;
        HALFDOWN_NORTHEAST.opposite = HALFUP_SOUTHWEST;
        THREEQUARTERSDOWN_NORTHEAST.opposite = THREEQUARTERSUP_SOUTHWEST;

        // EAST;
        THREEQUARTERSUPEAST_NORTHEAST.opposite = THREEQUARTERSDOWNWEST_SOUTHWEST;
        THREEQUARTERSUP_EAST.opposite = THREEQUARTERSDOWN_WEST;
        THREEQUARTERSUPEAST_SOUTHEAST.opposite = THREEQUARTERSDOWNWEST_NORTHWEST;
        HALFUPEAST_NORTHEAST.opposite = HALFDOWNWEST_SOUTHWEST;
        HALFUP_EAST.opposite = HALFDOWN_WEST;
        HALFUPEAST_SOUTHEAST.opposite = HALFDOWNWEST_NORTHWEST;
        QUARTERUPEAST_NORTHEAST.opposite = QUARTERDOWNWEST_SOUTHWEST;
        QUARTERUP_EAST.opposite = QUARTERDOWN_WEST;
        QUARTERUPEAST_SOUTHEAST.opposite = QUARTERDOWNWEST_NORTHWEST;

        EAST_NORTHEAST.opposite = WEST_SOUTHWEST;
        EAST.opposite = WEST;
        EAST_SOUTHEAST.opposite = WEST_NORTHWEST;

        QUARTERDOWNEAST_NORTHEAST.opposite = QUARTERUPWEST_SOUTHWEST;
        QUARTERDOWN_EAST.opposite = QUARTERUP_WEST;
        QUARTERDOWNEAST_SOUTHEAST.opposite = QUARTERUPWEST_NORTHWEST;
        HALFDOWNEAST_NORTHEAST.opposite = HALFUPWEST_SOUTHWEST;
        HALFDOWN_EAST.opposite = HALFUP_WEST;
        HALFDOWNEAST_SOUTHEAST.opposite = HALFUPWEST_NORTHWEST;
        THREEQUARTERSDOWNEAST_NORTHEAST.opposite = THREEQUARTERSUPWEST_SOUTHWEST;
        THREEQUARTERSDOWN_EAST.opposite = THREEQUARTERSUP_WEST;
        THREEQUARTERSDOWNEAST_SOUTHEAST.opposite = THREEQUARTERSUPWEST_NORTHWEST;

        // SOUTHEAST;
        THREEQUARTERSUP_SOUTHEAST.opposite = THREEQUARTERSDOWN_NORTHWEST;
        HALFUP_SOUTHEAST.opposite = HALFDOWN_NORTHWEST;
        QUARTERUP_SOUTHEAST.opposite = QUARTERDOWN_NORTHWEST;
        SOUTHEAST.opposite = NORTHWEST;
        QUARTERDOWN_SOUTHEAST.opposite = QUARTERUP_NORTHWEST;
        HALFDOWN_SOUTHEAST.opposite = HALFUP_NORTHWEST;
        THREEQUARTERSDOWN_SOUTHEAST.opposite = THREEQUARTERSUP_NORTHWEST;

        // SOUTH;
        THREEQUARTERSUPSOUTH_SOUTHEAST.opposite = THREEQUARTERSDOWNNORTH_NORTHWEST;
        THREEQUARTERSUP_SOUTH.opposite = THREEQUARTERSDOWN_NORTH;
        THREEQUARTERSUPSOUTH_SOUTHWEST.opposite = THREEQUARTERSDOWNNORTH_NORTHEAST;
        HALFUPSOUTH_SOUTHEAST.opposite = HALFDOWNNORTH_NORTHWEST;
        HALFUP_SOUTH.opposite = HALFDOWN_NORTH;
        HALFUPSOUTH_SOUTHWEST.opposite = HALFDOWNNORTH_NORTHEAST;
        QUARTERUPSOUTH_SOUTHEAST.opposite = QUARTERDOWNNORTH_NORTHWEST;
        QUARTERUP_SOUTH.opposite = QUARTERDOWN_NORTH;
        QUARTERUPSOUTH_SOUTHWEST.opposite = QUARTERDOWNNORTH_NORTHEAST;

        SOUTH_SOUTHEAST.opposite = NORTH_NORTHWEST;
        SOUTH.opposite = NORTH;
        SOUTH_SOUTHWEST.opposite = NORTH_NORTHEAST;

        QUARTERDOWNSOUTH_SOUTHEAST.opposite = QUARTERUPNORTH_NORTHWEST;
        QUARTERDOWN_SOUTH.opposite = QUARTERUP_NORTH;
        QUARTERDOWNSOUTH_SOUTHWEST.opposite = QUARTERUPNORTH_NORTHEAST;
        HALFDOWNSOUTH_SOUTHEAST.opposite = HALFUPNORTH_NORTHWEST;
        HALFDOWN_SOUTH.opposite = HALFUP_NORTH;
        HALFDOWNSOUTH_SOUTHWEST.opposite = HALFUPNORTH_NORTHEAST;
        THREEQUARTERSDOWNSOUTH_SOUTHEAST.opposite = THREEQUARTERSUPNORTH_NORTHWEST;
        THREEQUARTERSDOWN_SOUTH.opposite = THREEQUARTERSUP_NORTH;
        THREEQUARTERSDOWNSOUTH_SOUTHWEST.opposite = THREEQUARTERSUPNORTH_NORTHEAST;

        // SOUTHWEST;
        THREEQUARTERSUP_SOUTHWEST.opposite = THREEQUARTERSDOWN_NORTHEAST;
        HALFUP_SOUTHWEST.opposite = HALFDOWN_NORTHEAST;
        QUARTERUP_SOUTHWEST.opposite = QUARTERDOWN_NORTHEAST;
        SOUTHWEST.opposite = NORTHEAST;
        QUARTERDOWN_SOUTHWEST.opposite = QUARTERUP_NORTHEAST;
        HALFDOWN_SOUTHWEST.opposite = HALFUP_NORTHEAST;
        THREEQUARTERSDOWN_SOUTHWEST.opposite = THREEQUARTERSUP_NORTHEAST;

        // WEST;
        THREEQUARTERSUPWEST_SOUTHWEST.opposite = THREEQUARTERSDOWNEAST_NORTHEAST;
        THREEQUARTERSUP_WEST.opposite = THREEQUARTERSDOWN_EAST;
        THREEQUARTERSUPWEST_NORTHWEST.opposite = THREEQUARTERSDOWNEAST_SOUTHEAST;
        HALFUPWEST_SOUTHWEST.opposite = HALFDOWNEAST_NORTHEAST;
        HALFUP_WEST.opposite = HALFDOWN_EAST;
        HALFUPWEST_NORTHWEST.opposite = HALFDOWNEAST_SOUTHEAST;
        QUARTERUPWEST_SOUTHWEST.opposite = QUARTERDOWNEAST_NORTHEAST;
        QUARTERUP_WEST.opposite = QUARTERDOWN_EAST;
        QUARTERUPWEST_NORTHWEST.opposite = QUARTERDOWNEAST_SOUTHEAST;

        WEST_SOUTHWEST.opposite = EAST_NORTHEAST;
        WEST.opposite = EAST;
        WEST_NORTHWEST.opposite = EAST_SOUTHEAST;

        QUARTERDOWNWEST_SOUTHWEST.opposite = QUARTERUPEAST_NORTHEAST;
        QUARTERDOWN_WEST.opposite = QUARTERUP_EAST;
        QUARTERDOWNWEST_NORTHWEST.opposite = QUARTERUPEAST_SOUTHEAST;
        HALFDOWNWEST_SOUTHWEST.opposite = HALFUPEAST_NORTHEAST;
        HALFDOWN_WEST.opposite = HALFUP_EAST;
        HALFDOWNWEST_NORTHWEST.opposite = HALFUPEAST_SOUTHEAST;
        THREEQUARTERSDOWNWEST_SOUTHWEST.opposite = THREEQUARTERSUPEAST_NORTHEAST;
        THREEQUARTERSDOWN_WEST.opposite = THREEQUARTERSUP_EAST;
        THREEQUARTERSDOWNWEST_NORTHWEST.opposite = THREEQUARTERSUPEAST_SOUTHEAST;

        // NORTHWEST;
        THREEQUARTERSUP_NORTHWEST.opposite = THREEQUARTERSDOWN_SOUTHEAST;
        HALFUP_NORTHWEST.opposite = HALFDOWN_SOUTHEAST;
        QUARTERUP_NORTHWEST.opposite = QUARTERDOWN_SOUTHEAST;
        NORTHWEST.opposite = SOUTHEAST;
        QUARTERDOWN_NORTHWEST.opposite = QUARTERUP_SOUTHEAST;
        HALFDOWN_NORTHWEST.opposite = HALFUP_SOUTHEAST;
        THREEQUARTERSDOWN_NORTHWEST.opposite = THREEQUARTERSUP_SOUTHEAST;

        // CENTER
        UP.opposite = DOWN;
        NONE.opposite = NONE;
        DOWN.opposite = UP;
    }

    Direction(Vector3d vector3d, Division division, boolean isUpright) {
        this.vector = vector3d;
        this.division = division;
        this.isUpright = isUpright;
    }

    /**
     * Gets the closest direction from the given vector. If the vector is the
     * 0-Vector, this method returns {@link #NONE}.
     * If the vector is halfway between two directions, it is undefined which one will be selected
     *
     * @param vector The vector to convert to a direction
     * @return The closest direction that is not {@link #NONE} if the supplied vector is not the zero vector,
     *         the {@link #NONE} direction if it is
     */
    public static Direction getClosest(Vector3d vector) {
        return getClosest(vector, Division.SECONDARY_ORDINAL);
    }

    /**
     * Gets the closest direction from the given vector. If the vector is the
     * 0-Vector, this method returns {@link #NONE}.
     * If the vector is halfway between two directions, it is undefined which one will be selected
     *
     * @param vector The vector to convert to a direction
     * @param smallestDivision The smallest compass division that can be returned
     * @return The closest direction that is not {@link #NONE} if the supplied vector is not the zero vector,
     *         the {@link #NONE} direction if it is
     */
    public static Direction getClosest(Vector3d vector, Division smallestDivision) {
        return getClosest(vector, smallestDivision, true);
    }

    /**
     * Gets the closest horizontal direction from the given vector.
     * If the vector is halfway between two directions, it is undefined which one will be selected
     *
     * @param vector The vector to convert to a direction
     * @return The closest horizontal direction that is not {@link #NONE} if the supplied vector has zero X and Z,
     *         the {@link #NONE} direction if it is
     */
    public static Direction getClosestHorizontal(Vector3d vector) {
        return getClosestHorizontal(vector, Division.SECONDARY_ORDINAL);
    }

    /**
     * Gets the closest horizontal direction from the given vector.
     * If the vector is halfway between two directions, it is undefined which one will be selected
     *
     * @param vector The vector to convert to a direction
     * @param smallestDivision The smallest compass division that can be returned
     * @return The closest horizontal direction that is not {@link #NONE} if the supplied vector is not the zero vector,
     *         the {@link #NONE} direction if it is
     */
    public static Direction getClosestHorizontal(Vector3d vector, Division smallestDivision) {
        return getClosest(vector, smallestDivision, false);
    }

    /**
     * Gets the closest direction from the given vector.
     * If the vector is halfway between two directions, it is undefined which one will be selected
     *
     * @param vector The vector to convert to a direction
     * @param smallestDivision The smallest compass division that can be returned
     * @param allowUpright If false, if the vector would have returned a upright direction,
     *                     that direction's corresponding horizontal one will be returned.
     * @return The closest direction that is not {@link #NONE} if the supplied vector is not the zero vector,
     *         the {@link #NONE} direction if it is
     */
    public static Direction getClosest(Vector3d vector, Division smallestDivision, boolean allowUpright) {
        checkNotNull(vector, "Vector cannot be null!");
        if ((allowUpright ? vector : vector.mul(1, 0, 1)).equals(DirectionVectors.NONE)) {
            return NONE;
        }
        checkNotNull(smallestDivision, "Division cannot be null!");
        checkArgument(smallestDivision != Division.NONE, "Division cannot be NONE!");
        // Normalize, and have one floating point inaccuracy here, instead of every time the distance is calculated
        vector = vector.normalize();
        double distance = Double.MAX_VALUE;
        Direction result = null;
        for (Direction direction : Direction.values()) {
            if ((direction.isUpright && !allowUpright) || (direction.division.ordinal() < smallestDivision.ordinal())) {
                continue;
            }
            double newDistance = direction.vector.distance(vector);
            if (newDistance < distance) {
                distance = newDistance;
                result = direction;
            }
        }
        assert result != null;
        return result;
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
        return this.opposite == d;
    }

    /**
     * Return true if the direction is of a cardinal direction (north, west
     * east, and south).
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component</p>
     * @return True if cardinal
     */
    public boolean isCardinal() {
        return isCardinal(false);
    }

    /**
     * Return true if the direction is of a cardinal direction (north, west
     * east, and south).
     *
     * @param allowUpright If false and the directions has a non-zero Y component,
     *                     this will return false regardless of the {@link Division division}
     * @return True if cardinal
     */
    public boolean isCardinal(boolean allowUpright) {
        return (allowUpright || !this.isUpright) && divisionMatches(Division.CARDINAL);
    }

    /**
     * Return true if the direction is of an ordinal direction (northwest,
     * southwest, southeast, northeast).
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component</p>
     *
     * @return True if ordinal
     */
    public boolean isOrdinal() {
        return isOrdinal(false);
    }

    /**
     * Return true if the direction is of an ordinal direction (northwest,
     * southwest, southeast, northeast), or less specific.
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component</p>
     *
     * @return True if ordinal
     */
    public boolean encompassedByOrdinal() {
        return encompassedByOrdinal(false);
    }

    /**
     * Return true if the direction is of a ordinal direction (northwest,
     * southwest, southeast, northeast).
     *
     * @param allowUpright If false and the directions has a non-zero Y component,
     *                     this will return false regardless of the {@link Division division}
     * @return True if ordinal
     */
    public boolean isOrdinal(boolean allowUpright) {
        return (allowUpright || !this.isUpright) && divisionMatches(Division.ORDINAL);
    }

    /**
     * Return true if the direction is of a ordinal direction (northwest,
     * southwest, southeast, northeast), or less specific.
     *
     * @param allowUpright If false and the directions has a non-zero Y component,
     *                     this will return false regardless of the {@link Division division}
     * @return True if ordinal
     */
    public boolean encompassedByOrdinal(boolean allowUpright) {
        return (allowUpright || !this.isUpright) && containedBy(Division.ORDINAL);
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.).
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component</p>
     *
     * @return True if secondary ordinal
     */
    public boolean isSecondaryOrdinal() {
        return isSecondaryOrdinal(false);
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.), or less specific
     * <p>This evaluates as false for directions that have a non-zero
     * Y-component</p>
     *
     * @return True if secondary ordinal
     */
    public boolean encompassedBySecondaryOrdinal() {
        return encompassedBySecondaryOrdinal(false);
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.).
     *
     * @param allowUpright If false and the directions has a non-zero Y component,
     *                     this will return false regardless of the {@link Division division}
     * @return True if secondary ordinal
     */
    public boolean isSecondaryOrdinal(boolean allowUpright) {
        return (allowUpright || !this.isUpright) && divisionMatches(Division.SECONDARY_ORDINAL);
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.), or less specific.
     *
     * @param allowUpright If false and the directions has a non-zero Y component,
     *                     this will return false regardless of the {@link Division division}
     * @return True if secondary ordinal
     */
    public boolean encompassedBySecondaryOrdinal(boolean allowUpright) {
        return (allowUpright || !this.isUpright) && containedBy(Division.SECONDARY_ORDINAL);
    }

    /**
     * Determines whether the supplied {@link Division division} encompasses this direction.
     *
     * @param division The division to compare
     * @return True, if the supplied division is not null and contains this direction
     */
    public boolean containedBy(@Nullable Division division) {
        return division != null && this.division.ordinal() >= division.ordinal();
    }

    /**
     * Determines whether this direction's {@link Division division} is the same as the supplied division.
     *
     * @param division The division to compare
     * @return True, if the divisions are the same
     */
    public boolean divisionMatches(@Nullable Division division) {
        return this.division == division;
    }

    /**
     * Gets the {@link Division division} of this direction (cardinal, ordinal, secondary ordinal, or none).
     *
     * @return The division
     */
    public Division getDivision() {
        return this.division;
    }

    /**
     * Return whether Y component is non-zero.
     *
     * @return True if the Y component is non-zero
     */
    public boolean isUpright() {
        return this.isUpright;
    }

    /**
     * Get the Vector3d.
     *
     * @return The Vector3d
     */
    public Vector3d toVector3d() {
        return this.vector;
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
