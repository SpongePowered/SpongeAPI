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

import org.spongepowered.api.service.persistence.data.DataContainer;
import org.spongepowered.api.world.Chunk;

import javax.annotation.Nullable;

/**
 * A chunk iterator represents a buffer for obtaining chunk data from
 * storage without having to explicitly load into memory all available
 * chunks.
 * <p>This avoid loading all chunks into memory at once, reducing the memory
 * footprint and persistence operations.</p>
 * <p>The chunks are loaded individually in sequence. Strong references to
 * the chunks represented by {@link DataContainer}s should be avoided
 * <strong>AT ALL COSTS</strong>. The data represented is a copy and
 * therefore shouldn't be considered synchronized to live data.</p>
 *
 * <p>This is a data stream from the chunk storage system and should be
 * used in an asynchronous thread from the main thread.</p>
 *
 */
public interface ChunkDataStream {

    /**
     * Gets the next {@link Chunk} represented by a read only {@link DataContainer}.
     *
     * <p>This method BLOCKS the thread until the next available data has been
     * read.</p>
     *
     * <p>This may not return a {@link DataContainer} in the event there is no
     * chunk data available to read.</p>
     *
     * @return The chunk data represented by a data container
     */
    @Nullable
    DataContainer next();

    /**
     * Checks if there is an available chunk to represent.
     *
     * @return Whether there is more data that can be read
     */
    boolean hasNext();

    /**
     * Gets the number of chunks available to read as {@link DataContainer}s.
     *
     * @return The number of remaining chunks available to read
     */
    int available();

    /**
     * Resets this stream to read from the beginning of the collection of
     * chunks.
     */
    void reset();

}
