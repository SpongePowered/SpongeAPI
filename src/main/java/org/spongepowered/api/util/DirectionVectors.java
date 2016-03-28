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

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.vector.Vector3d;

public final class DirectionVectors {

    private static final double P8 = Math.PI / 8;
    private static final double C8 = Math.cos(P8);
    private static final double S8 = Math.sin(P8);

    // simple directions that have understandable values
    public static final Vector3d NORTH = Vector3d.UNIT_Z.negate();
    public static final Vector3d EAST = Vector3d.UNIT_X;
    public static final Vector3d SOUTH = Vector3d.UNIT_Z;
    public static final Vector3d WEST = Vector3d.UNIT_X.negate();

    public static final Vector3d UP = Vector3d.UP;
    public static final Vector3d NONE = Vector3d.ZERO;
    public static final Vector3d DOWN = Vector3d.UP.negate();

    public static final Vector3d NORTHEAST = NORTH.add(EAST).normalize();
    public static final Vector3d SOUTHEAST = SOUTH.add(EAST).normalize();
    public static final Vector3d SOUTHWEST = SOUTH.add(WEST).normalize();
    public static final Vector3d NORTHWEST = NORTH.add(WEST).normalize();

    public static final Vector3d NORTH_NORTHEAST = new Vector3d(S8, 0, -C8);
    public static final Vector3d EAST_NORTHEAST = new Vector3d(C8, 0, -S8);
    public static final Vector3d EAST_SOUTHEAST = new Vector3d(C8, 0, S8);
    public static final Vector3d SOUTH_SOUTHEAST = new Vector3d(S8, 0, C8);
    public static final Vector3d SOUTH_SOUTHWEST = new Vector3d(-S8, 0, C8);
    public static final Vector3d WEST_SOUTHWEST = new Vector3d(-C8, 0, S8);
    public static final Vector3d WEST_NORTHWEST = new Vector3d(-C8, 0, -S8);
    public static final Vector3d NORTH_NORTHWEST = new Vector3d(-S8, 0, -C8);

    public static final Vector3d HALFUP_NORTH = NORTH.add(UP).normalize();
    public static final Vector3d HALFUP_EAST = EAST.add(UP).normalize();
    public static final Vector3d HALFUP_SOUTH = SOUTH.add(UP).normalize();
    public static final Vector3d HALFUP_WEST = WEST.add(UP).normalize();
    public static final Vector3d HALFDOWN_NORTH = NORTH.add(DOWN).normalize();
    public static final Vector3d HALFDOWN_EAST = EAST.add(DOWN).normalize();
    public static final Vector3d HALFDOWN_SOUTH = SOUTH.add(DOWN).normalize();
    public static final Vector3d HALFDOWN_WEST = WEST.add(DOWN).normalize();

    // complex directions that need to be calculated with the angles to be certain and clear
    public static final Vector3d QUARTERUP_NORTH = minecraftVectorDeg(180, -22.5);
    public static final Vector3d QUARTERUP_EAST = minecraftVectorDeg(-90, -22.5);
    public static final Vector3d QUARTERUP_SOUTH = minecraftVectorDeg(0, -22.5);
    public static final Vector3d QUARTERUP_WEST = minecraftVectorDeg(90, -22.5);
    public static final Vector3d THREEQUARTERSUP_NORTH = minecraftVectorDeg(180, -67.5);
    public static final Vector3d THREEQUARTERSUP_EAST = minecraftVectorDeg(-90, -67.5);
    public static final Vector3d THREEQUARTERSUP_SOUTH = minecraftVectorDeg(0, -67.5);
    public static final Vector3d THREEQUARTERSUP_WEST = minecraftVectorDeg(90, -67.5);
    public static final Vector3d QUARTERDOWN_NORTH = minecraftVectorDeg(180, 22.5);
    public static final Vector3d QUARTERDOWN_EAST = minecraftVectorDeg(-90, 22.5);
    public static final Vector3d QUARTERDOWN_SOUTH = minecraftVectorDeg(0, 22.5);
    public static final Vector3d QUARTERDOWN_WEST = minecraftVectorDeg(90, 22.5);
    public static final Vector3d THREEQUARTERSDOWN_NORTH = minecraftVectorDeg(180, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_EAST = minecraftVectorDeg(-90, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_SOUTH = minecraftVectorDeg(0, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_WEST = minecraftVectorDeg(90, 67.5);

    public static final Vector3d HALFUP_NORTHEAST = minecraftVectorDeg(-135, -45);
    public static final Vector3d HALFUP_SOUTHEAST = minecraftVectorDeg(-45, -45);
    public static final Vector3d HALFUP_SOUTHWEST = minecraftVectorDeg(45, -45);
    public static final Vector3d HALFUP_NORTHWEST = minecraftVectorDeg(135, -45);
    public static final Vector3d HALFDOWN_NORTHEAST = minecraftVectorDeg(-135, 45);
    public static final Vector3d HALFDOWN_SOUTHEAST = minecraftVectorDeg(-45, 45);
    public static final Vector3d HALFDOWN_SOUTHWEST = minecraftVectorDeg(45, 45);
    public static final Vector3d HALFDOWN_NORTHWEST = minecraftVectorDeg(135, 45);

    public static final Vector3d QUARTERUP_NORTHEAST = minecraftVectorDeg(-135, -22.5);
    public static final Vector3d QUARTERUP_SOUTHEAST = minecraftVectorDeg(-45, -22.5);
    public static final Vector3d QUARTERUP_SOUTHWEST = minecraftVectorDeg(45, -22.5);
    public static final Vector3d QUARTERUP_NORTHWEST = minecraftVectorDeg(135, -22.5);
    public static final Vector3d QUARTERDOWN_NORTHEAST = minecraftVectorDeg(-135, 22.5);
    public static final Vector3d QUARTERDOWN_SOUTHEAST = minecraftVectorDeg(-45, 22.5);
    public static final Vector3d QUARTERDOWN_SOUTHWEST = minecraftVectorDeg(45, 22.5);
    public static final Vector3d QUARTERDOWN_NORTHWEST = minecraftVectorDeg(135, 22.5);

    public static final Vector3d THREEQUARTERSUP_NORTHEAST = minecraftVectorDeg(-135, -67.5);
    public static final Vector3d THREEQUARTERSUP_SOUTHEAST = minecraftVectorDeg(-45, -67.5);
    public static final Vector3d THREEQUARTERSUP_SOUTHWEST = minecraftVectorDeg(45, -67.5);
    public static final Vector3d THREEQUARTERSUP_NORTHWEST = minecraftVectorDeg(135, -67.5);
    public static final Vector3d THREEQUARTERSDOWN_NORTHEAST = minecraftVectorDeg(-135, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_SOUTHEAST = minecraftVectorDeg(-45, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_SOUTHWEST = minecraftVectorDeg(45, 67.5);
    public static final Vector3d THREEQUARTERSDOWN_NORTHWEST = minecraftVectorDeg(135, 67.5);

    public static final Vector3d HALFUPNORTH_NORTHEAST = minecraftVectorDeg(-157.5, -45);
    public static final Vector3d HALFUPEAST_NORTHEAST = minecraftVectorDeg(-112.5, -45);
    public static final Vector3d HALFUPEAST_SOUTHEAST = minecraftVectorDeg(-67.5, -45);
    public static final Vector3d HALFUPSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, -45);
    public static final Vector3d HALFUPSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, -45);
    public static final Vector3d HALFUPWEST_SOUTHWEST = minecraftVectorDeg(67.5, -45);
    public static final Vector3d HALFUPWEST_NORTHWEST = minecraftVectorDeg(112.5, -45);
    public static final Vector3d HALFUPNORTH_NORTHWEST = minecraftVectorDeg(157.5, -45);
    public static final Vector3d HALFDOWNNORTH_NORTHEAST = minecraftVectorDeg(-157.5, 45);
    public static final Vector3d HALFDOWNEAST_NORTHEAST = minecraftVectorDeg(-112.5, 45);
    public static final Vector3d HALFDOWNEAST_SOUTHEAST = minecraftVectorDeg(-67.5, 45);
    public static final Vector3d HALFDOWNSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, 45);
    public static final Vector3d HALFDOWNSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, 45);
    public static final Vector3d HALFDOWNWEST_SOUTHWEST = minecraftVectorDeg(67.5, 45);
    public static final Vector3d HALFDOWNWEST_NORTHWEST = minecraftVectorDeg(112.5, 45);
    public static final Vector3d HALFDOWNNORTH_NORTHWEST = minecraftVectorDeg(157.5, 45);

    public static final Vector3d QUARTERUPNORTH_NORTHEAST = minecraftVectorDeg(-157.5, -22.5);
    public static final Vector3d QUARTERUPEAST_NORTHEAST = minecraftVectorDeg(-112.5, -22.5);
    public static final Vector3d QUARTERUPEAST_SOUTHEAST = minecraftVectorDeg(-67.5, -22.5);
    public static final Vector3d QUARTERUPSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, -22.5);
    public static final Vector3d QUARTERUPSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, -22.5);
    public static final Vector3d QUARTERUPWEST_SOUTHWEST = minecraftVectorDeg(67.5, -22.5);
    public static final Vector3d QUARTERUPWEST_NORTHWEST = minecraftVectorDeg(112.5, -22.5);
    public static final Vector3d QUARTERUPNORTH_NORTHWEST = minecraftVectorDeg(157.5, -22.5);
    public static final Vector3d QUARTERDOWNNORTH_NORTHEAST = minecraftVectorDeg(-157.5, 22.5);
    public static final Vector3d QUARTERDOWNEAST_NORTHEAST = minecraftVectorDeg(-112.5, 22.5);
    public static final Vector3d QUARTERDOWNEAST_SOUTHEAST = minecraftVectorDeg(-67.5, 22.5);
    public static final Vector3d QUARTERDOWNSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, 22.5);
    public static final Vector3d QUARTERDOWNSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, 22.5);
    public static final Vector3d QUARTERDOWNWEST_SOUTHWEST = minecraftVectorDeg(67.5, 22.5);
    public static final Vector3d QUARTERDOWNWEST_NORTHWEST = minecraftVectorDeg(112.5, 22.5);
    public static final Vector3d QUARTERDOWNNORTH_NORTHWEST = minecraftVectorDeg(157.5, 22.5);

    public static final Vector3d THREEQUARTERSUPNORTH_NORTHEAST = minecraftVectorDeg(-157.5, -67.5);
    public static final Vector3d THREEQUARTERSUPEAST_NORTHEAST = minecraftVectorDeg(-112.5, -67.5);
    public static final Vector3d THREEQUARTERSUPEAST_SOUTHEAST = minecraftVectorDeg(-67.5, -67.5);
    public static final Vector3d THREEQUARTERSUPSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, -67.5);
    public static final Vector3d THREEQUARTERSUPSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, -67.5);
    public static final Vector3d THREEQUARTERSUPWEST_SOUTHWEST = minecraftVectorDeg(67.5, -67.5);
    public static final Vector3d THREEQUARTERSUPWEST_NORTHWEST = minecraftVectorDeg(112.5, -67.5);
    public static final Vector3d THREEQUARTERSUPNORTH_NORTHWEST = minecraftVectorDeg(157.5, -67.5);
    public static final Vector3d THREEQUARTERSDOWNNORTH_NORTHEAST = minecraftVectorDeg(-157.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNEAST_NORTHEAST = minecraftVectorDeg(-112.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNEAST_SOUTHEAST = minecraftVectorDeg(-67.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNSOUTH_SOUTHEAST = minecraftVectorDeg(-22.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNSOUTH_SOUTHWEST = minecraftVectorDeg(22.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNWEST_SOUTHWEST = minecraftVectorDeg(67.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNWEST_NORTHWEST = minecraftVectorDeg(112.5, 67.5);
    public static final Vector3d THREEQUARTERSDOWNNORTH_NORTHWEST = minecraftVectorDeg(157.5, 67.5);

    /**
     * Gets the unit vector of a certain yaw and pitch. This uses the Minecraft coordinate system,
     * NOT the standard math spherical coordinate system.
     *
     * @param yaw The yaw in degrees counterclockwise from positive Z
     * @param pitch The pitch in degrees, where 0 is straight ahead, and 90 is straight down
     * @return A {@link Vector3d} representing the angles supplied
     * @see Vector3d#createDirectionRad(double, double)
     */
    public static Vector3d minecraftVectorDeg(double yaw, double pitch) {
        return minecraftVectorRad(Math.toRadians(yaw), Math.toRadians(pitch));
    }

    /**
     * Gets the unit vector of a certain yaw and pitch. This uses the Minecraft coordinate system,
     * NOT the standard math spherical coordinate system.
     *
     * @param yaw The yaw in radians counterclockwise from positive Z
     * @param pitch The pitch in radians, where 0 is straight ahead, and pi/2 is straight down
     * @return A {@link Vector3d} representing the angles supplied
     * @see Vector3d#createDirectionRad(double, double)
     */
    public static Vector3d minecraftVectorRad(double yaw, double pitch) {
        double f = TrigMath.cos(Math.abs(pitch));
        double x = f * TrigMath.cos(yaw);
        double y = TrigMath.sin(-pitch);
        double z = f * TrigMath.sin(yaw);
        /*
         * round off decimals about 10 decimal places away from zero, one, cos(pi/8), and sin(pi/8)
         * this fixes Math.sin(Math.PI) returning a non-zero number
         */
        x = Math.abs(x) > 0.0000000009 ? x : 0;
        y = Math.abs(y) > 0.0000000009 ? y : 0;
        z = Math.abs(z) > 0.0000000009 ? z : 0;
        x = Math.abs(Math.abs(x) - 1) > 0.0000000001 ? x : 1;
        y = Math.abs(Math.abs(y) - 1) > 0.0000000001 ? y : 1;
        z = Math.abs(Math.abs(z) - 1) > 0.0000000001 ? z : 1;
        x = Math.abs(Math.abs(x) - C8) > 0.0000000001 ? x : C8;
        y = Math.abs(Math.abs(y) - C8) > 0.0000000001 ? y : C8;
        z = Math.abs(Math.abs(z) - C8) > 0.0000000001 ? z : C8;
        x = Math.abs(Math.abs(x) - S8) > 0.0000000001 ? x : S8;
        y = Math.abs(Math.abs(y) - S8) > 0.0000000001 ? y : S8;
        z = Math.abs(Math.abs(z) - S8) > 0.0000000001 ? z : S8;
        return new Vector3d(x, y, z);
    }

    private DirectionVectors() {
    }

}
