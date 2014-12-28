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
 * blocks away.</p>
 *
 * <p>In Minecraft, a warning is displayed in the form of a reddish tint.</p>
 */
public interface WorldBorder {

    /**
     * Get the diameter the world border is expanding or contracting to.
     *
     * <p>This will return the same value as {@link #getDiameter} unless
     * {@link #getTimeRemaining} is greater than 0.</p>
     *
     * @return The diameter being changed to
     */
    double getNewDiameter();

    /**
     * Get the diameter of the world border.
     *
     * <p>The returned diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The diameter
     */
    double getDiameter();

    /**
     * Set the diameter of the world border.
     *
     * <p>The specified diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param diameter The diameter
     */
    void setDiameter(double diameter);

    /**
     * Set the diameter of the world border, over the given period of time.
     *
     * <p>The world border diameter increases/decrease linearly over the specified time.
     * The specified diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param diameter The diameter where the border will expand/contract to
     * @param time     The time over which to change, in milliseconds
     */
    void setDiameter(double diameter, long time);

    /**
     * Set the starting diameter and the ending diameter of the world border, over the given period of time.
     *
     * <p>The world border diameter increases/diameter linearly over the specified time.
     * The specified diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param startDiameter The diameter where the border will start
     * @param endDiameter   The diameter where the border will end
     * @param time          The time over which to change, in milliseconds
     */
    void setDiameter(double startDiameter, double endDiameter, long time);

    /**
     * Get the time remaining until the world border stops expanding or contracting.
     *
     * @return The time remaining, in milliseconds
     */
    long getTimeRemaining();

    /**
     * Set the center of the world border.
     *
     * @param x The x-axis center of the world border
     * @param z The z-axis center of the world border
     */
    void setCenter(double x, double z);

    /**
     * Get the center of the world border.
     *
     * <p>The returned position is three-dimensional. As the worldborder extends
     * over the entire y-axis, the returned position will always have
     * a {@code y} set to 0.</p>
     *
     * @return The center
     */
    Vector3d getCenter();

    /**
     * Get the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint.</p>
     *
     * @return The time, in seconds
     */
    int getWarningTime();

    /**
     * Set the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint.</p>
     *
     * @param time The time, in seconds
     */
    void setWarningTime(int time);

    /**
     * Get the distance when a contracting world border will warn a player for whom
     * the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint.</p>
     *
     * @return The distance, in blocks
     */
    int getWarningDistance();

    /**
     * Set the distance when a contracting world border will warn a player for whom
     * the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a
     * reddish tint.</p>
     *
     * @param distance The distance, in blocks
     */
    void setWarningDistance(int distance);

    /**
     * Get the distance a player may be outside the world border before
     * taking damage.
     *
     * @return The distance
     */
    double getDamageThreshold();

    /**
     * Set the distance a player may be be outside the world border before
     * taking damage.
     *
     * @param distance The distance
     */
    void setDamageThreshold(double distance);

    /**
     * Get the damage done to a player per second when outside the buffer.
     *
     * @return The damage amount
     */
    int getDamageAmount();

    /**
     * Set the damage done to a player per second when outside the buffer.
     *
     * @param damage The damage amount
     */
    void setDamageAmount(int damage);
}
