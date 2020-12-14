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
package org.spongepowered.api.world.border;

import java.time.Duration;
import org.spongepowered.math.vector.Vector2d;

/**
 * A world border is a square boundary, extending through the entire y-axis.
 *
 * <p>It can gradually grow or shrink to a radius over a period of time. A
 * warning is displayed when a contracting world border will reach the player in
 * a certain amount of time, or when the player is a certain number of blocks
 * away.</p>
 *
 * <p>In Minecraft, a warning is displayed in the form of a reddish tint.</p>
 */
public interface WorldBorder {

    /**
     * Gets the center of the world border.
     *
     * <p>The x coordinated can be retrieved through {@link Vector2d#getX()}, while
     * the z coordinated can be retrieved through {@link Vector2d#getY()}.</p>
     *
     * @return The center
     */
    Vector2d getCenter();

    /**
     * Gets the lerp size targer the world border is expanding or contracting to.
     *
     * <p>This will return the same value as {@link #getSize()} unless
     * {@link #getLerpSizeTimeRemaining} is greater than 0.</p>
     *
     * @return The diameter being changed to
     */
    double getLerpSizeTarget();

    /**
     * Gets the time remaining until the world border stops expanding or
     * contracting.
     *
     * @return The time remaining
     */
    Duration getLerpSizeTimeRemaining();

    /**
     * Gets the size of the world border.
     *
     * <p>The returned size applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The size
     */
    double getSize();

    /**
     * Gets the distance a player may be outside the world border before taking
     * damage.
     *
     * @return The distance
     */
    double getSafeZone();

    /**
     * Gets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @return The damage amount
     */
    double getDamagePerBlock();

    /**
     * Gets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The warning time
     */
    Duration getWarningTime();

    /**
     * Gets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The distance
     */
    int getWarningBlocks();
}
