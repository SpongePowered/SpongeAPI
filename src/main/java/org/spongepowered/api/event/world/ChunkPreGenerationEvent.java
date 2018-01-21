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
package org.spongepowered.api.event.world;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.world.ChunkPreGenerate;

import java.time.Duration;

/**
 * Base event for when a {@link ChunkPreGenerate} task
 * is underway.
 */
public interface ChunkPreGenerationEvent extends TargetWorldEvent {

    /**
     * The object that contains the progress information for the
     * current {@link ChunkPreGenerate}.
     *
     * @return The {@link ChunkPreGenerate}
     */
    ChunkPreGenerate getChunkPreGenerate();

    /**
     * Event fired when chunks are about to be generated. Cancelling this task
     * will cancel the entire pre-generation.
     */
    interface Pre extends ChunkPreGenerationEvent, Cancellable {

        /**
         * Returns whether the chunk generator will skip generation this time
         * around. This only prevents the next step from being performed.
         *
         * <p>Use {@link #isCancelled()} to check for cancellation of the
         * entire generation task.</p>
         *
         * @return {@code true} if the next step will be skipped.
         */
        boolean getSkipStep();

        /**
         * Sets whether the next step should be skipped.
         *
         * <p>Use {@link #setCancelled(boolean)} to cancel the entire pre
         * generation task.</p>
         *
         * @param skipStep If set to {@code true}, the next step will be
         *                 skipped.
         */
        void setSkipStep(boolean skipStep);

    }

    /**
     * Event fired when a step has completed. Cancelling this task
     * will cancel the entire pre-generation.
     */
    interface Post extends ChunkPreGenerationEvent, Cancellable {

        /**
         * The number of chunks generated during the previous step.
         *
         * @return The number of chunks that were generated.
         */
        int getChunksGeneratedThisStep();

        /**
         * The number of chunks generated that did not need to be generated and
         * were skipped over.
         *
         * @return The number of chunks that were generated.
         */
        int getChunksSkippedThisStep();

        /**
         * The {@link Duration} of the previous step.
         *
         * @return The {@link Duration}
         */
        Duration getTimeTakenForStep();

    }

    /**
     * Event fired when the pre generation has been completed.
     */
    interface Complete extends ChunkPreGenerationEvent {}

    /**
     * Event fired when the pre generation has been cancelled.
     */
    interface Cancelled extends ChunkPreGenerationEvent {}
}
