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

package org.spongepowered.api.world.chunk;

import org.spongepowered.api.util.AxisDirection;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.region.Region;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;

/**
 * Represents chunk data belongig to a single chunk in a single world. The chunk
 * for this chunk data may not exist yet.
 */
public interface ChunkData {

    /**
     * Gets the world this chunk data belongs to.
     *
     * @return The world this chunk data belongs to
     */
    World getWorld();

    /**
     * Gets the region this chunk data belongs to.
     *
     * @return The world this chunk data belongs to
     */
    Region getRegion();

    /**
     * Gets the chunk belonging to this chunk data if it exists.
     *
     * @return The chunk belonging to this chunk data or
     *         {@link Optional#absent()} if not loaded
     */
    Optional<Chunk> getChunk();

    /**
     * Get the chunk belonging to this chunk data if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param shouldGenerate True to generate a new chunk if it does not exist
     *            yet
     * @return The loaded or generated chunk at the given position or
     *         {@link Optional#absent()} if not found and not generated
     */

    Optional<Chunk> loadChunk(boolean generate);

    /**
     * Get the chunk belonging to this chunk data if it exists, generating it if
     * the chunk does not exist.
     *
     * @return The loaded or generated chunk
     */
    Chunk loadChunk();

    /**
     * Gets the chunks position.
     *
     * @return The chunks position
     */
    Vector2i getChunkPosition();

    /**
     * Gets the minimal block's position located in this chunk.
     *
     * @return The minimal block's position
     */
    Vector3d getMinBlockPosition();

    /**
     * Gets the maximal block's position located in this chunk.
     *
     * @return The maximal block's position
     */
    Vector3d getMaxBlockPosition();

    /**
     * Gets the block's position matching to the given {@link AxisDirection}s.
     *
     * <ul>
     * <li>{@link AxisDirection#MINUS} for the minimal block's position within
     * this chunk for the given axis.</li>
     * <li>{@link AxisDirection#ZERO} for the middle block's position within
     * this chunk for the given axis. If there are two blocks matching this
     * condition the lower one will be returned.</li>
     * <li>{@link AxisDirection#PLUS} for the maximal block's position within
     * this chunk for the given axis.</li>
     * </ul>
     *
     * @param xDirection The direction for the given x-axis
     * @param yDirection The direction for the given y-axis
     * @param zDirection The direction for the given z-axis
     * @return The blocks's position matching the given specifications
     */
    Vector3d geBlockPosition(AxisDirection xDirection, AxisDirection yDirection, AxisDirection zDirection);

    /**
     * Gets the chunk state for the chunk this chunk data belongs to.
     *
     * @return The chunk state for the chunk
     */
    ChunkState getChunkState();

}
