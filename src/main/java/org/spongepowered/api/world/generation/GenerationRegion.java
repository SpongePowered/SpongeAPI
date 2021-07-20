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
package org.spongepowered.api.world.generation;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.WorldLike;
import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

/**
 * A region of {@link GenerationChunk}s that are being generated for a
 * {@link ServerWorld}. Upon completion, the chunks in this region will be
 * converted into {@link WorldChunk}s and inserted into the target
 * {@link #worldKey() world}.
 *
 * <p>A region is similar to a world in that there are {@link GenerationChunk}s
 * available, {@link BlockState}s are used in this region, and likewise, the
 * region can contain and store {@link BlockEntity} instances being generated,
 * {@link Entity} instances being generated or spawned by generation, etc.
 * The major differences are that a generation region cannot be utilized for
 * {@link ServerLocation}s, they are not considered to be viewable by
 * {@link Player}s and they are not accessible by the {@link Server}
 * or {@link ServerWorld}(s).
 */
public interface GenerationRegion extends WorldLike<GenerationRegion> {

    /**
     * The {@link ResourceKey} of the {@link ServerWorld} that this region will
     * be placed into.
     *
     * <p>As generation regions are designed to be thread-safe with regards to
     * world generation, it is entirely possible that you may retrieve a region
     * off the main server thread. As {@link ServerWorld} instances are
     * <strong>not</strong> thread safe, you should ensure that
     * {@link Server#onMainThread()} is {@code true} before retreving the world.
     * </p>
     *
     * @return The {@link ResourceKey} that represents the target
     * {@link ServerWorld}
     */
    ResourceKey worldKey();

    /**
     * Gets the {@link Server} engine.
     *
     * @return The {@link Server}
     */
    @Override
    Server engine();

    /**
     * The minimum chunk co-ordinate of this region.
     *
     * @return The chunk co-ordinate as a {@link Vector3i}
     */
    Vector3i chunkMin();

    /**
     * The maximum chunk co-ordinate of this region.
     *
     * @return The chunk co-ordinate as a {@link Vector3i}
     */
    Vector3i chunkMax();

    /**
     * Gets the {@link GenerationChunk} at the given block co-ordinates
     *
     * @param position The block position
     * @return The {@link GenerationChunk}
     * @throws IllegalArgumentException if the provided co-ordinates are out of
     *                                  bounds.
     */
    @Override
    default GenerationChunk chunkAtBlock(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.chunkAtBlock(position.x(), position.y(), position.z());
    }

    /**
     * Gets the {@link GenerationChunk} at the given block co-ordinates
     *
     * @param x The x co-ordinate
     * @param y The y co-ordinate
     * @param z The z co-ordinate
     * @return The {@link GenerationChunk}
     * @throws IllegalArgumentException if the provided co-ordinates are out of
     *                                  bounds.
     */
    @Override
    default GenerationChunk chunkAtBlock(final int x, final int y, final int z) {
        return this.chunk(this.engine().chunkLayout().toChunk(x, y, z).orElseThrow(() -> new IllegalArgumentException(String.format("Cannot convert (%s, %s, %s) to chunk coordinates.", x, y, z))));
    }

    /**
     * Gets the {@link GenerationChunk} at the given chunk co-ordinates
     *
     * @param chunkPosition The chunk co-ordinates
     * @return The {@link GenerationChunk}
     * @throws IllegalArgumentException if the provided co-ordinates are out of
     *                                  bounds.
     */
    @Override
    default GenerationChunk chunk(final Vector3i chunkPosition) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
        return this.chunk(chunkPosition.x(), chunkPosition.y(), chunkPosition.z());
    }

    /**
     * Gets the {@link GenerationChunk} at the given chunk co-ordinates
     *
     * @param cx The x co-ordinate
     * @param cy The y co-ordinate
     * @param cz The z co-ordinate
     * @return The {@link GenerationChunk}
     * @throws IllegalArgumentException if the provided co-ordinates are out of
     *                                  bounds.
     */
    @Override
    GenerationChunk chunk(int cx, int cy, int cz);

}
