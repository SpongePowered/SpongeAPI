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
package org.spongepowered.api.world.storage;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Direction.Flag;

/**
 * A class for information about the chunk coordinate space, aka the layout.
 * This can be used to obtain information about the chunk size and the
 * space bounds, validate coordinates, convert from chunk to world and
 * vice-versa and translate coordinates; among other things.
 */
public interface ChunkLayout {

    /**
     * Returns the size of the chunks in blocks. The axes are matched to the
     * corresponding vector components.
     *
     * @return The size of chunks
     */
    Vector3i getChunkSize();

    /**
     * Returns the maximum coordinates for chunks for each axis. The axes are
     * matched to the corresponding vector components. Due to the limited
     * precision of 32bit integers, there always is a practical limit.
     *
     * @return The maximum coordinates of chunks
     */
    Vector3i getSpaceMax();

    /**
     * Returns the minimum coordinates for chunks for each axis. The axes are
     * matched to the corresponding vector components. Due to the limited
     * precision of 32bit integers, there always is a practical limit.
     *
     * @return The minimum coordinates of chunks
     */
    Vector3i getSpaceMin();

    /**
     * Gets the total size of the chunk space, which is equivalent to
     * {@link #getSpaceMax()} - {@link #getSpaceMin()} + 1.
     *
     * @return The total size of the chunk space
     */
    Vector3i getSpaceSize();

    /**
     * Returns the origin of the chunk coordinate space. Normally
     * {@link Vector3i#ZERO}.
     *
     * @return The origin of the chunk coordinate space
     */
    Vector3i getSpaceOrigin();

    /**
     * Returns true if the coordinates are valid chunk coordinates. False if
     * otherwise.
     *
     * @param coords The coordinates to validate
     * @return Whether or not the coordinates are valid for chunks
     */
    boolean isValidChunk(Vector3i coords);

    /**
     * Returns true if the coordinates are valid chunk coordinates. False if
     * otherwise.
     *
     * @param x The x coordinate to validate
     * @param y The y coordinate to validate
     * @param z The z coordinate to validate
     * @return Whether or not the coordinates are valid for chunks
     */
    boolean isValidChunk(int x, int y, int z);

    /**
     * Returns true if the local coordinates fit in a chunk. That is
     * they are positive and smaller than the chunk's size.
     *
     * @param localCoords The coordinates to check
     * @return Whether or not the coordinates fit in a chunk
     */
    boolean isInChunk(Vector3i localCoords);

    /**
     * Returns true if the local coordinates fit in a chunk. That is
     * they are positive and smaller than the chunk's size.
     *
     * @param x The x local coordinate to validate
     * @param y The y local coordinate to validate
     * @param z The z local coordinate to validate
     * @return Whether or not the coordinates fit in a chunk
     */
    boolean isInChunk(int x, int y, int z);

    /**
     * Returns true if the world coordinates fit in the chunk at the
     * given coordinates.
     *
     * @param worldCoords The world coordinates to validate
     * @param chunkCoords The chunk coordinates in which they must fit
     * @return Whether or not the world coordinates fit in the chunk
     */
    boolean isInChunk(Vector3i worldCoords, Vector3i chunkCoords);

    /**
     * Returns true if the world coordinates fit in the chunk at the
     * given coordinates.
     *
     * @param wx The x world coordinate to validate
     * @param wy The y world coordinate to validate
     * @param wz The z world coordinate to validate
     * @param cx The x chunk coordinate in which they must fit
     * @param cy The y chunk coordinate in which they must fit
     * @param cz The z chunk coordinate in which they must fit
     * @return Whether or not the world coordinates fit in the chunk
     */
    boolean isInChunk(int wx, int wy, int wz, int cx, int cy, int cz);

    /**
     * Converts world coordinates to chunk coordinates. Returns nothing if the
     * conversion failed because the resulting chunk coordinates aren't valid.
     *
     * @param worldCoords The world coordinates to convert to chunk coordinates
     * @return The chunk coordinates on success, else nothing
     */
    Optional<Vector3i> toChunk(Vector3i worldCoords);

    /**
     * Converts world coordinates to chunk coordinates. Returns nothing if the
     * conversion failed because the resulting chunk coordinates aren't valid.
     *
     * @param x The x world coordinate to convert to chunk coordinates
     * @param y The y world coordinate to convert to chunk coordinates
     * @param z The z world coordinate to convert to chunk coordinates
     * @return The chunk coordinates on success, else nothing
     */
    Optional<Vector3i> toChunk(int x, int y, int z);

    /**
     * Converts chunk coordinates to world coordinates. Returns nothing if the
     * conversion failed because the given chunk coordinates aren't valid.
     *
     * @param chunkCoords The chunk coordinates to convert to world coordinates
     * @return The world coordinates on success, else nothing
     */
    Optional<Vector3i> toWorld(Vector3i chunkCoords);

    /**
     * Converts chunk coordinates to world coordinates. Returns nothing if the
     * conversion failed because the given chunk coordinates aren't valid.
     *
     * @param x The x chunk coordinate to convert to world coordinates
     * @param y The y chunk coordinate to convert to world coordinates
     * @param z The z chunk coordinate to convert to world coordinates
     * @return The world coordinates on success, else nothing
     */
    Optional<Vector3i> toWorld(int x, int y, int z);

    /**
     * Adds the chunk offset to the chunk coordinates. Returns nothing if the
     * new coordinates are not valid.
     *
     * @param chunkCoords The chunk coordinates to add to
     * @param chunkOffset The chunk offset to add to the chunk coordinates
     * @return The new chunk coordinates if they are valid
     */
    Optional<Vector3i> addToChunk(Vector3i chunkCoords, Vector3i chunkOffset);

    /**
     * Adds the chunk offset to the chunk coordinates. Returns nothing if the
     * new coordinates are not valid.
     *
     * @param cx The x chunk coordinate to add to
     * @param cy The y chunk coordinate to add to
     * @param cz The z chunk coordinate to add to
     * @param ox The x chunk offset to add to the chunk coordinates
     * @param oy The y chunk offset to add to the chunk coordinates
     * @param oz The z chunk offset to add to the chunk coordinates
     * @return The new chunk coordinates if they are valid
     */
    Optional<Vector3i> addToChunk(int cx, int cy, int cz, int ox, int oy, int oz);

    /**
     * Moves chunk coordinates one step in the given direction. Returns nothing
     * if the new coordinates are not valid. {@link Flag#SECONDARY_ORDINAL}
     * directions are not a valid argument. These will throw an exception.
     *
     * @param chunkCoords The chunk coordinates to move from
     * @param direction The direction in which to move a step
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     *     {@link Flag#SECONDARY_ORDINAL}
     */
    Optional<Vector3i> moveToChunk(Vector3i chunkCoords, Direction direction);

    /**
     * Moves chunk coordinates one step in the given direction. Returns nothing
     * if the new coordinates are not valid. {@link Flag#SECONDARY_ORDINAL}
     * directions are not a valid argument. These will throw an exception.
     *
     * @param x The x chunk coordinate to move from
     * @param y The y chunk coordinate to move from
     * @param z The z chunk coordinate to move from
     * @param direction The direction in which to move a step
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     *     {@link Flag#SECONDARY_ORDINAL}
     */
    Optional<Vector3i> moveToChunk(int x, int y, int z, Direction direction);

    /**
     * Moves chunk coordinates a number of steps in the given direction.
     * Returns nothing if the new coordinates are not valid.
     * {@link Flag#SECONDARY_ORDINAL} directions are not a valid argument.
     * These will throw an exception.
     *
     * @param chunkCoords The chunk coordinates to move from
     * @param direction The direction in which to move
     * @param steps The number of steps to take
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     *     {@link Flag#SECONDARY_ORDINAL}
     */
    Optional<Vector3i> moveToChunk(Vector3i chunkCoords, Direction direction, int steps);

    /**
     * Moves chunk coordinates a number of steps in the given direction.
     * Returns nothing if the new coordinates are not valid.
     * {@link Flag#SECONDARY_ORDINAL} directions are not a valid argument.
     * These will throw an exception.
     *
     * @param x The x chunk coordinate to move from
     * @param y The y chunk coordinate to move from
     * @param z The z chunk coordinate to move from
     * @param direction The direction in which to move
     * @param steps The number of steps to take
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     *      {@link Flag#SECONDARY_ORDINAL}
     */
    Optional<Vector3i> moveToChunk(int x, int y, int z, Direction direction, int steps);

}
