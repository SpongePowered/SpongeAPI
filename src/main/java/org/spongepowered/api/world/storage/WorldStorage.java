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
package org.spongepowered.api.world.storage;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import org.spongepowered.api.service.persistence.data.DataContainer;
import org.spongepowered.api.world.Chunk;

/**
 * Represents the storage manager of a particular {@link org.spongepowered.api.world.World}.
 *
 * <p>It should be noted that this can have direct access to the underlying
 * storage system of the world and interface with deleting and modifying
 * chunks.</p>
 */
public interface WorldStorage {

    /**
     * Gets a {@link ChunkDataStream}.
     *
     * <p>Usage of a {@link ChunkDataStream} should be limited to asynchronous
     * tasks to avoid hanging the main thread.</p>
     *
     * @return An iterator of generated chunks
     */
    ChunkDataStream getGeneratedChunks();

    /**
     * Checks if the given chunk coordinates represented by {@link Vector3i}
     * exist in the world.
     *
     * <p>Note that this is an asynchronous check as the storage of chunks
     * can not be guaranteed to remain in synch with the server, let alone
     * on the server thread.</p>
     *
     * <p>It is imperative to avoid waiting for the {@link ListenableFuture} to complete
     * its task.</p>
     *
     * @param chunkCoords The chunk coordinates
     * @return Whether the chunk exists or not
     */
    ListenableFuture<Boolean> doesChunkExist(Vector3i chunkCoords);

    /**
     * Gets a {@link DataContainer} including all data related to a {@link Chunk}.
     *
     * <p>The container is a read only instance of the data, and therefor
     * should not be considered as mutable data. Changes are NOT saved, and
     * the data may not be in synch with the server if the chunk is currently
     * loaded.</p>
     *
     * <p>This may not return a {@link DataContainer} in the event there is no
     * chunk data generated at the desired coordinates.</p>
     *
     * <p>It is imperative to understand that the {@link ListenableFuture} task is
     * blocking, and should avoid using {@link ListenableFuture#get()} while on the main
     * thread.</p>
     *
     * @param chunkCoords The chunk coordinates
     * @return The data container representing the chunk data, if available
     */
    ListenableFuture<Optional<DataContainer>> getChunkData(Vector3i chunkCoords);

}
