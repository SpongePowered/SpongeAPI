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
package org.spongepowered.api.event.cause.entity.spawn;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;

public interface BlockSpawnCause extends SpawnCause {

    /**
     * Creates a new {@link Builder builder} to build a
     * {@link BlockSpawnCause}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockSnapshot} representing the direct block that caused
     * the spawn.
     *
     * @return The snapshot of the block that caused the spawn
     */
    BlockSnapshot getBlockSnapshot();

    /**
     * An abstract builder for building {@link BlockSpawnCause block spawn causes}
     * and potential derivatives.
     *
     * @param <T> The type extending BlockSpawnCause
     * @param <B> The type of builder extending block spawn cause builder
     */
    interface BlockSpawnCauseBuilder<T extends BlockSpawnCause, B extends BlockSpawnCauseBuilder<T, B>> extends
            SpawnCauseBuilder<T, B> {

        /**
         * Sets the {@link BlockSnapshot} to be used for building a
         * {@link BlockSpawnCause}. The snapshot is <b>required</b>.
         *
         * @param blockSnapshot The block snapshot
         * @return This builder, for chaining
         */
        B block(BlockSnapshot blockSnapshot);

    }

    /**
     * The root builder specific to {@link BlockSpawnCause}.
     */
    interface Builder extends BlockSpawnCauseBuilder<BlockSpawnCause, Builder> {

    }
}
