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
package org.spongepowered.api.util;

import static org.spongepowered.api.math.Vectors.create3d;
import org.spongepowered.api.math.Vector3d;

/**
 * Represent the 16 main and secondary cardinal directions plus up and down.
 * With the following assumptions:
 * <ul>
 * <li>{@link #NORTH} targeting towards -X</li>
 * <li>{@link #EAST}  targeting towards +Z</li>
 * <li>{@link #SOUTH} targeting towards +X</li>
 * <li>{@link #WEST}  targeting towards -Z</li>
 * <li>{@link #UP}    targeting towards +Y</li>
 * <li>{@link #DOWN}  targeting towards -Y</li>
 * </ul>
 */
public enum Direction {
    NORTH           (create3d( 0,       0, -1       ), Flag.CARDINAL         ),
    NORTH_NORTHEAST (create3d( C.S8,    0, -C.C8    ), Flag.SECONDARY_ORDINAL),
    NORTHEAST       (create3d( 1,       0, -1       ), Flag.ORDINAL          ),
    EAST_NORTHEAST  (create3d( C.C8,    0, -C.S8    ), Flag.SECONDARY_ORDINAL),

    EAST            (create3d( 1,       0,  0       ), Flag.CARDINAL         ),
    EAST_SOUTHEAST  (create3d( C.C8,    0,  C.S8    ), Flag.SECONDARY_ORDINAL),
    SOUTHEAST       (create3d( 1,       0,  1       ), Flag.ORDINAL          ),
    SOUTH_SOUTHEAST (create3d( C.S8,    0,  C.C8    ), Flag.SECONDARY_ORDINAL),

    SOUTH           (create3d( 0,       0,  1       ), Flag.CARDINAL         ),
    SOUTH_SOUTHWEST (create3d(-C.S8,    0,  C.C8    ), Flag.SECONDARY_ORDINAL),
    SOUTHWEST       (create3d(-1,       0,  1       ), Flag.ORDINAL          ),
    WEST_SOUTHWEST  (create3d(-C.C8,    0,  C.S8    ), Flag.SECONDARY_ORDINAL),

    WEST            (create3d(-1,       0,  0       ), Flag.CARDINAL         ),
    WEST_NORTHWEST  (create3d(-C.C8,    0, -C.S8    ), Flag.SECONDARY_ORDINAL),
    NORTHWEST       (create3d(-1,       0, -1       ), Flag.ORDINAL          ),
    NORTH_NORTHWEST (create3d(-C.S8,    0, -C.C8    ), Flag.SECONDARY_ORDINAL),

    UP              (create3d( 0,       1,  0       ), Flag.UPRIGHT          ),
    DOWN            (create3d( 0,      -1,  0       ), Flag.UPRIGHT          ),

    NONE            (create3d( 0,       0,  0       ), 0                     );

    private interface C {
        public static final double C8 = Math.cos(Math.PI / 8);
        public static final double S8 = Math.sin(Math.PI / 8);
    }

    private final Vector3d direction;
    private final int flags;
    private Direction opposite;

    private Direction(Vector3d vector3d, int flags) {
        this.direction = vector3d.normalize();
        this.flags = flags;
    }

    static {
        NORTH.opposite = SOUTH;
        EAST.opposite  = WEST;
        SOUTH.opposite = NORTH;
        WEST.opposite  = EAST;

        UP.opposite    = DOWN;
        DOWN.opposite  = UP;

        NONE.opposite = NONE;

        NORTHEAST.opposite = SOUTHWEST;
        NORTHWEST.opposite = SOUTHEAST;
        SOUTHEAST.opposite = NORTHWEST;
        SOUTHWEST.opposite = NORTHEAST;

        WEST_NORTHWEST.opposite  = EAST_SOUTHEAST;
        WEST_SOUTHWEST.opposite  = EAST_NORTHEAST;
        NORTH_NORTHWEST.opposite = SOUTH_SOUTHEAST;
        NORTH_NORTHEAST.opposite = SOUTH_SOUTHWEST;
        EAST_SOUTHEAST.opposite  = WEST_NORTHWEST;
        EAST_NORTHEAST.opposite  = WEST_SOUTHWEST;
        SOUTH_SOUTHEAST.opposite = NORTH_NORTHWEST;
        SOUTH_SOUTHWEST.opposite = NORTH_NORTHEAST;
    }

    public Direction getOpposite() {
        return this.opposite;
    }

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
     * @return true if cardinal
     */
    public boolean isCardinal() {
        return (flags & Flag.CARDINAL) > 0;
    }

    /**
     * Return true if the direction is of an ordinal direction (northwest,
     * southwest, southeast, northeaast).
     *
     * @return true if ordinal
     */
    public boolean isOrdinal() {
        return (flags & Flag.ORDINAL) > 0;
    }

    /**
     * Return true if the direction is of a secondary ordinal direction
     * (north-northwest, north-northeast, south-southwest, etc.).
     *
     * @return true if secondary ordinal
     */
    public boolean isSecondaryOrdinal() {
        return (flags & Flag.SECONDARY_ORDINAL) > 0;
    }

    /**
     * Return whether Y component is non-zero.
     *
     * @return true if the Y component is non-zero
     */
    public boolean isUpright() {
        return (flags & Flag.UPRIGHT) > 0;
    }

    /**
     * Get the Vector3d.
     *
     * @return the Vector3d
     */
    public Vector3d toVector3d() {
        return direction;
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector, this method returns {@link #NONE}. If the vector
     * has the same horizontal and vertical length, a horizontal direction will
     * be returned. If the vector has the same angle to two directions the
     * clockwise next will be selected.
     * 
     * @param vector The vector to convert to a direction
     * @return The closest horizontal direction.
     */
    public static Direction getClosest(Vector3d vector) {
        if (Math.pow(vector.getY(), 2) <= Math.pow(vector.getX(), 2) + Math.pow(vector.getZ(), 2)) {
            return getClosestHorizonal(vector);
        } else if (vector.getY() > 0) {
            return UP;
        } else {
            return DOWN;
        }
    }

    /**
     * Gets the closest horizontal direction from the given vector. If the
     * vector is the 0-Vector, this method returns {@link #NONE}. If the vector
     * has the same angle to two directions the clockwise next will be selected.
     * 
     * @param vector The vector to convert to a direction
     * @return The closest horizontal direction.
     */
    public static Direction getClosestHorizonal(Vector3d vector) {
        if (vector.getX() == 0) {
            if (vector.getZ() == 0) {
                return NONE;
            } else if (vector.getZ() < 0) {
                return NORTH;
            } else {
                return SOUTH;
            }
        } else {
            final double angle = Math.atan(vector.getZ() / -vector.getX());
            final int ordinal = (int) (angle * 8 / Math.PI + 16.5) % 16;
            return values()[ordinal];
        }
    }

    public static Direction getFromAxis(final Axis axis) {
        switch (axis) {
            case X :
                return SOUTH;
            case Y :
                return UP;
            case Z :
                return EAST;
            default :
                throw new IllegalStateException("Not capable of handling the " + axis.name() + " axis!");
        }
    }

    public static Direction getFromAxis(final Axis axis, final AxisDirection direction) {
        switch (direction) {
            case PLUS :
                return getFromAxis(axis);
            case ZERO :
                return NONE;
            case MINUS :
                return getFromAxis(axis).getOpposite();
            default :
                throw new IllegalStateException("Not capable of handling the " + direction.name() + " direction!");
        }
    }

    public static final class Flag {

        public static int CARDINAL = 0x1;
        public static int ORDINAL = 0x2;
        public static int SECONDARY_ORDINAL = 0x4;
        public static int UPRIGHT = 0x8;

        public static int ALL = CARDINAL | ORDINAL | SECONDARY_ORDINAL | UPRIGHT;

        private Flag() {
        }
    }

}
