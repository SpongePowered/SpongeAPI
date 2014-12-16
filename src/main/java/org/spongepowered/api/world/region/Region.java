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

package org.spongepowered.api.world.region;

import org.spongepowered.api.util.storage.StorageContainer;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.ChunkData;

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * Represents a chunk container also known as region.
 * <p />
 * <p>
 * Some important facts about regions:
 * </p>
 * <ul>
 * <li>Represent the internal grouping of one or more chunks.</li>
 * <li>A region contains at least one chunk although its not required that the
 * chunk is loaded or any file or data hint to its existence.</li>
 * <li>There is no limit how many chunks can be contained in a region.</li>
 * <li>The shape is not required to be squarish.</li>
 * <li>A chunk is bound to a single region and every time it is regenerated it
 * will be bound to the same region.</li>
 * <li>Contained chunks may or may not have shared borders.</li>
 * </ul>
 *
 * @see SymmetricSquareRegion
 */
public interface Region {

    /**
     * Gets the world this region belongs to.
     *
     * @return The world this region belongs to.
     */
    World getWorld();

    /**
     * Gets the storage this region stores its data in. In vanilla minecraft
     * this is the region file.
     *
     * @return The storage this region stores its data in or
     *         {@link Optional#absent()} if it not available
     */
    Optional<StorageContainer> getStorage();

    /**
     * Checks whether the given region exist/has any data associated to it.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     *
     * @return True, if the given region exists. False otherwise.
     */
    boolean exists();

    /**
     * Gets all existing chunks within the given bounds. Due to the asynchronous
     * nature of this method newly generated or deleted chunks may or may not be
     * visible in the iterator, this only applies to chunks that have not been
     * iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * If you don't need the actual blocks or entities in the chunk you should
     * consider using
     * {@link #getChunkDataAsynchronously()}
     *
     * @return An iterable containing all existing chunks within the given
     *         bounds
     */
    Iterable<Chunk> getExistingChunksAsynchronously();

    /**
     * Gets all existing chunks within the given bounds matching the given
     * filter. Due to the asynchronous nature of this method newly generated or
     * deleted chunks may or may not be visible in the iterator, this only
     * applies to chunks that have not been iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * If you don't need the actual blocks or entities in the chunk you should
     * consider using
     * {@link #getChunkDataAsynchronously(Predicate)}
     *
     * @param filter The filter used to exclude a chunk from the search
     * @return An iterable containing all existing chunks within the given
     *         bounds matching the given filter
     */
    Iterable<Chunk> getExistingChunksAsynchronously(Predicate<Vector2i> filter);

    /**
     * Gets all chunks within the given bounds. Due to the asynchronous nature
     * of this method newly generated or deleted chunks may or may not be
     * visible in the iterator, this only applies to chunks that have not been
     * iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     *
     * @return An iterable containing all existing chunk data within the given
     *         bounds
     */
    Iterable<ChunkData> getChunkDataAsynchronously();

    /**
     * Gets all chunk data within the given bounds matching the given filter.
     * Due to the asynchronous nature of this method newly generated or deleted
     * chunks may or may not be visible in the iterator, this only applies to
     * chunks that have not been iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     *
     * @param filter The filter used to exclude a chunk from the search
     * @return An iterable containing all existing chunk data within the given
     *         bounds matching the given filter
     */
    Iterable<ChunkData> getChunkDataAsynchronously(Predicate<Vector2i> filter);

}
