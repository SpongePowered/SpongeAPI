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
package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector3d;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nullable;

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
     * Get the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @return The damage amount
     */
    double getDamageAmount();

    /**
     * Set the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @param damage The damage amount
     */
    void setDamageAmount(double damage);

    /**
     * Returns a new builder for creating a task to pre-generate the chunks
     * inside the border. The current state of the border is "snapshoted" for
     * the builder. It is not backed by this instance. If the border size is
     * changing then the target size is used.
     *
     * @param world The target world
     * @return The builder for the chunk pre-generate task
     * @see ChunkPreGenerate
     */
    ChunkPreGenerate newChunkPreGenerate(World world);

    /**
     * A builder for submitting a task to pre-generate chunks inside a world
     * border.
     *
     * <p>The task is synchronous and repeating with a given interval and
     * either a target number of chunks per ticks and/or a percentage of the
     * tick time.</p>
     *
     * <p>Chunk order is not defined but a proper implementation should use
     * and "inside-out" strategy for better results if the task is
     * cancelled.</p>
     *
     * @see WorldBorder#newChunkPreGenerate(World)
     * @see World#newChunkPreGenerate(Vector3d, double)
     */
    interface ChunkPreGenerate extends ResettableBuilder<Task, ChunkPreGenerate> {

        /**
         * Sets the owner of the resulting task.
         *
         * <p>Mandatory.</p>
         *
         * @param plugin The owner plugin
         * @return This for chained calls
         */
        ChunkPreGenerate owner(Object plugin);

        /**
         * Sets the logger for logging generator efforts.
         *
         * <p>Optional.</p>
         *
         * @param logger A logger for the generator
         * @return This for chained calls
         */
        ChunkPreGenerate logger(@Nullable Logger logger);

        /**
         * Sets the interval between generation runs.
         *
         * <p>Must be greater than 0.</p>
         *
         * <p>Optional.</p>
         *
         * <p>Default is 10.</p>
         *
         * @param tickInterval The tick interval
         * @return This for chained calls
         */
        ChunkPreGenerate tickInterval(int tickInterval);

        /**
         * Sets maximum number of chunks per tick to generate.
         *
         * <p>Use a value smaller or equal to 0 to disable.</p>
         *
         * <p>Optional if {@link #tickPercentLimit(float)} is used.</p>
         *
         * <p>Default is disabled.</p>
         *
         * @param chunkCount The maximum number of chunks to generate
         * @return This for chained calls
         */
        ChunkPreGenerate chunksPerTick(int chunkCount);

        /**
         * Sets the limit of tick time that can be used to generate chunks
         * as a percentage of {@link Scheduler#getPreferredTickInterval()}. The
         * percentage should be a value in the range (0, 1]. No estimation is
         * used to decide when to stop so the actual value will always be
         * somewhere above the given percentage.
         *
         * <p>Use a value smaller or equal to 0 to disable.</p>
         *
         * <p>Optional if {@link #chunksPerTick(int)} is used.</p>
         *
         * <p>Default is 15%.</p>
         *
         * @param tickPercent The
         * @return This for chained calls
         */
        ChunkPreGenerate tickPercentLimit(float tickPercent);

        /**
         * Schedules the task with the {@link Game#getScheduler()}.
         *
         * @return The resulting task
         */
        Task start();

    }

}
