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
import org.spongepowered.api.event.world.ChunkPreGenerationEvent;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.storage.WorldProperties;

import java.time.Duration;
import java.util.function.Consumer;

import javax.annotation.Nullable;

/**
 * Represents an ongoing chunk pre-generation.
 */
public interface ChunkPreGenerate {

    /**
     * The {@link WorldProperties} of the world that this task is operating on.
     *
     * @return The {@link WorldProperties}
     */
    WorldProperties getWorldProperties();

    /**
     * The total number of chunks generated during this generation.
     *
     * @return The number of chunks.
     */
    int getTotalGeneratedChunks();

    /**
     * The total number of chunks skipped during this generation.
     *
     * @return The number of chunks.
     */
    int getTotalSkippedChunks();

    /**
     * The target number of chunks that will be generated or skipped
     * during this generation. This includes chunks already generated
     * or skipped.
     *
     * @return The total number of chunks to be generated.
     */
    int getTargetTotalChunks();

    /**
     * Gets the total wall clock time it has taken (so far) to generate
     * chunks.
     *
     * @return A {@link Duration} representing the amount of time taken
     *         so far.
     */
    Duration getTotalTime();

    /**
     * Gets whether the task for this world has been cancelled
     * (or completed).
     *
     * @return True if cancelled.
     */
    boolean isCancelled();

    /**
     * Cancels this pre-generation if it is still running.
     */
    void cancel();

    /**
     * A builder for submitting a task to pre-generate chunks.
     *
     * <p>The task is synchronous and repeating with a given interval and either
     * a target number of chunks per ticks and/or a percentage of the tick
     * time.</p>
     *
     * <p>Chunk order is not defined but a proper implementation should use and
     * "inside-out" strategy for better results if the task is cancelled.</p>
     *
     * @see WorldBorder#newChunkPreGenerate(World)
     * @see World#newChunkPreGenerate(Vector3d, double)
     */
    interface Builder extends ResettableBuilder<ChunkPreGenerate, Builder> {

        /**
         * Sets the owner of the resulting task.
         *
         * <p>Mandatory.</p>
         *
         * @param plugin The owner plugin
         * @return This for chained calls
         */
        Builder owner(Object plugin);

        /**
         * Adds a logger for logging generator efforts.
         *
         * <p>Optional. No effect if null is passed.</p>
         *
         * @param logger A logger for the generator
         * @return This for chained calls
         */
        Builder logger(@Nullable Logger logger);

        /**
         * Sets the number of ticks between generation runs.
         *
         * <p>Must be greater than 0.</p>
         *
         * <p>Optional.</p>
         *
         * <p>Default is 4.</p>
         *
         * @param tickInterval The tick interval
         * @return This for chained calls
         */
        Builder tickInterval(int tickInterval);

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
        Builder chunksPerTick(int chunkCount);

        /**
         * Sets the limit of tick time that can be used to generate chunks as a
         * percentage of {@link Scheduler#getPreferredTickInterval()}. The
         * percentage must be a value in the range (0, 1]. No estimation is
         * used to decide when to stop so the actual value will always be
         * somewhere above the given percentage.
         *
         * <p>Use a value smaller or equal to 0 to disable.</p>
         *
         * <p>Optional if {@link #chunksPerTick(int)} is used.</p>
         *
         * <p>Default is 80%.</p>
         *
         * @param tickPercent The maximum percentage of the tick time to use
         *                    for this generation pass.
         * @return This for chained calls
         */
        Builder tickPercentLimit(float tickPercent);

        /**
         * Adds a {@link ChunkPreGenerationEvent} listener callback that will be
         * called for this, and only this, pre-generation routine. Note that
         * this does not change whether the various {@link ChunkPreGenerationEvent}
         * events will be called, this is a convenience method to simply setup
         * a listener bound to this pre-generation.
         *
         * @param listener The {@link Consumer} that will handle the events.
         *
         * @return This for chained calls
         */
        Builder addListener(Consumer<ChunkPreGenerationEvent> listener);

        /**
         * Schedules the task with the {@link Game#getScheduler()}.
         *
         * @return The resulting {@link ChunkPreGenerate} that can be used
         *         obtain progress
         */
        ChunkPreGenerate start();

    }
}
