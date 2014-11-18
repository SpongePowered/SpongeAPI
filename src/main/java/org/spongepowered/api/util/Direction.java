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

public enum Direction {

    NORTH(create3d(0, 0, -1), Flag.CARDINAL),
    EAST(create3d(1, 0, 0), Flag.CARDINAL),
    SOUTH(create3d(0, 0, 1), Flag.CARDINAL),
    WEST(create3d(-1, 0, 0), Flag.CARDINAL),

    UP(create3d(0, 1, 0), Flag.UPRIGHT),
    DOWN(create3d(0, -1, 0), Flag.UPRIGHT),

    NORTHEAST(create3d(1, 0, -1), Flag.ORDINAL),
    NORTHWEST(create3d(-1, 0, -1), Flag.ORDINAL),
    SOUTHEAST(create3d(1, 0, 1), Flag.ORDINAL),
    SOUTHWEST(create3d(-1, 0, 1), Flag.ORDINAL),

    WEST_NORTHWEST(create3d(-Math.cos(Math.PI / 8), 0, Math.sin(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    WEST_SOUTHWEST(create3d(-Math.cos(Math.PI / 8), 0, Math.sin(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    NORTH_NORTHWEST(create3d(Math.sin(Math.PI / 8), 0, -Math.cos(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    NORTH_NORTHEAST(create3d(Math.sin(Math.PI / 8), 0, -Math.cos(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    EAST_NORTHEAST(create3d(Math.cos(Math.PI / 8), 0, Math.sin(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    EAST_SOUTHEAST(create3d(Math.cos(Math.PI / 8), 0, Math.sin(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    SOUTH_SOUTHEAST(create3d(Math.sin(Math.PI / 8), 0, Math.cos(Math.PI / 8)), Flag.SECONDARY_ORDINAL),
    SOUTH_SOUTHWEST(create3d(Math.sin(Math.PI / 8), 0, Math.cos(Math.PI / 8)), Flag.SECONDARY_ORDINAL);

    private final Vector3d direction;
    private final int flags;

    private Direction(Vector3d vector3d, int flags) {
        this.direction = vector3d.normalize();
        this.flags = flags;
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
