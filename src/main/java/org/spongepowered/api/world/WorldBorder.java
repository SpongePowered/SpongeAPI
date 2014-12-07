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

package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector3d;

/**
 * A world border is a square boundary, extending through the entire y-axis.
 *
 * <p>It can gradually grow or shrink to a radius over a period of time.
 * A warning is displayed when a contracting world border will reach the player
 * in a certain amount of time, or when the player is a certain number of
 * blocks away.
 *
 * In Minecraft, a warning is displayed in the form of a reddish tint.</p>
 */
public interface WorldBorder {

    /**
     * Get the radius of the world border.
     *
     * <p>The returned radius applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The radius, in blocks
     */
    public double getRadius();

    /**
     * Set the radius of the world border.
     *
     * <p>The specified radius applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param radius The radius, in blocks
     */
    public void setRadius(double radius);

    /**
     * Set the radius of the world border, over the given period of time.
     *
     * <p>The world border radius increases linearly over the specified time.
     * The specified radius applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param radius The radius, in blocks
     * @param time The time over which to change, in seconds
     */
    public void setRadius(double radius, long time);

    /**
     * Get the time remaining until the world border stops expanding or contracting
     *
     * @return The time remaining, in seconds
     */
    public long getTimeRemaining();

    /**
     * Set the center of the world border.
     *
     * @param x The x-axis center of the world border
     * @param z The z-axis center of the world border
     */
    public void setCenter(double x, double y);

    /**
     * Get the center of the world border.
     *
     * <p>The returned position is three-dimensional. As the worldborder extends
     * over the entire y-axis, the returned position will always have
     * a {@code y} set to 0.</p>
     *
     * @return The center
     */
    public Vector3d getCenter();

    /**
     * Get the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint</p>
     *
     * @return The time, in seconds
     */
    public int getWarningTime();

    /**
     * Set the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint</p>
     *
     * @param time The time, in seconds
     */
    public void setWarningTime(int time);

    /**
     * Get the distance when a contracting world border will warn a player for whom
     * the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint</p>
     *
     * @return The distance, in blocks
     */
    public int getWarningDistance();

    /**
     * Set the distance when a contracting world border will warn a player for whom
     * the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint</p>
     *
     * @param distance The distance, in blocks
     */
    public void setWarningDistance(int distance);
}
