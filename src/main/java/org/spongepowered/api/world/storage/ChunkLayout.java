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

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Direction.Division;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.Optional;

/**
 * A class for information about the chunk coordinate space, aka the layout.
 * This can be used to obtain information about the chunk size and the space
 * bounds, validate coordinates, convert from chunk to world and vice-versa and
 * translate coordinates; among other things.
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
    default boolean isValidChunk(Vector3i coords) {
        Objects.requireNonNull(coords, "coords");
        return isValidChunk(coords.getX(), coords.getY(), coords.getZ());
    }

    /**
     * Returns true if the coordinates are valid chunk coordinates. False if
     * otherwise.
     *
     * @param x The x coordinate to validate
     * @param y The y coordinate to validate
     * @param z The z coordinate to validate
     * @return Whether or not the coordinates are valid for chunks
     */
    default boolean isValidChunk(int x, int y, int z) {
        return x >= getSpaceMin().getX() && x <= getSpaceMax().getX()
            && y >= getSpaceMin().getY() && y <= getSpaceMax().getY()
            && z >= getSpaceMin().getZ() && z <= getSpaceMax().getZ();
    }

    /**
     * Returns true if the local coordinates fit in a chunk. That is they are
     * positive and smaller than the chunk's size.
     *
     * @param localCoords The coordinates to check
     * @return Whether or not the coordinates fit in a chunk
     */
    default boolean isInChunk(Vector3i localCoords) {
        Objects.requireNonNull(localCoords, "localCoords");
        return isInChunk(localCoords.getX(), localCoords.getY(), localCoords.getZ());
    }

    /**
     * Returns true if the local coordinates fit in a chunk. That is they are
     * positive and smaller than the chunk's size.
     *
     * @param x The x local coordinate to validate
     * @param y The y local coordinate to validate
     * @param z The z local coordinate to validate
     * @return Whether or not the coordinates fit in a chunk
     */
    boolean isInChunk(int x, int y, int z);

    /**
     * Returns true if the world coordinates fit in the chunk at the given
     * coordinates.
     *
     * @param worldCoords The world coordinates to validate
     * @param chunkCoords The chunk coordinates in which they must fit
     * @return Whether or not the world coordinates fit in the chunk
     */
    default boolean isInChunk(Vector3i worldCoords, Vector3i chunkCoords) {
        Objects.requireNonNull(worldCoords, "worldCoords");
        Objects.requireNonNull(chunkCoords, "chunkCoords");
        return isInChunk(worldCoords.getX(), worldCoords.getY(), worldCoords.getZ(), chunkCoords.getX(), chunkCoords.getY(), chunkCoords.getZ());
    }

    /**
     * Returns true if the world coordinates fit in the chunk at the given
     * coordinates.
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
    default Optional<Vector3i> toChunk(Vector3i worldCoords) {
        Objects.requireNonNull(worldCoords, "worldCoords");
        return toChunk(worldCoords.getX(), worldCoords.getY(), worldCoords.getZ());
    }

    /**
     * Converts world coordinates to chunk coordinates. Returns nothing if the
     * conversion failed because the resulting chunk coordinates aren't valid.
     *
     * @param x The x world coordinate to convert to chunk coordinates
     * @param y The y world coordinate to convert to chunk coordinates
     * @param z The z world coordinate to convert to chunk coordinates
     * @return The chunk coordinates on success, else nothing
     */
    default Optional<Vector3i> toChunk(int x, int y, int z) {
        final Vector3i chunkCoords = forceToChunk(x, y, z);
        return isValidChunk(chunkCoords) ? Optional.of(chunkCoords) : Optional.empty();
    }

    /**
     * Converts chunk coordinates to world coordinates. Returns nothing if the
     * conversion failed because the given chunk coordinates aren't valid.
     *
     * @param chunkCoords The chunk coordinates to convert to world coordinates
     * @return The world coordinates on success, else nothing
     */
    default Optional<Vector3i> toWorld(Vector3i chunkCoords) {
        Objects.requireNonNull(chunkCoords, "chunkCoords");
        return toWorld(chunkCoords.getX(), chunkCoords.getY(), chunkCoords.getZ());
    }

    /**
     * Converts chunk coordinates to world coordinates. Returns nothing if the
     * conversion failed because the given chunk coordinates aren't valid.
     *
     * @param x The x chunk coordinate to convert to world coordinates
     * @param y The y chunk coordinate to convert to world coordinates
     * @param z The z chunk coordinate to convert to world coordinates
     * @return The world coordinates on success, else nothing
     */
    default Optional<Vector3i> toWorld(int x, int y, int z) {
        return isValidChunk(x, y, z) ? Optional.of(forceToWorld(x, y, z)) : Optional.empty();
    }

    /**
     * Converts world coordinates to chunk coordinates. This method never fails
     * and can returns invalid chunk coordinates.
     *
     * @param worldCoords The world coordinates to convert to chunk coordinates
     * @return The chunk coordinates
     */
    default Vector3i forceToChunk(Vector3i worldCoords) {
        Objects.requireNonNull(worldCoords, "worldCoords");
        return forceToChunk(worldCoords.getX(), worldCoords.getY(), worldCoords.getZ());
    }

    /**
     * Converts world coordinates to chunk coordinates. This method never fails
     * and can returns invalid chunk coordinates.
     *
     * @param x The x world coordinate to convert to chunk coordinates
     * @param y The y world coordinate to convert to chunk coordinates
     * @param z The z world coordinate to convert to chunk coordinates
     * @return The chunk coordinates
     */
    Vector3i forceToChunk(int x, int y, int z);

    /**
     * Converts chunk coordinates to world coordinates. This method never fails
     * and can returns invalid world coordinates.
     *
     * @param chunkCoords The chunk coordinates to convert to world coordinates
     * @return The world coordinates
     */
    default Vector3i forceToWorld(Vector3i chunkCoords) {
        Objects.requireNonNull(chunkCoords, "chunkCoords");
        return forceToWorld(chunkCoords.getX(), chunkCoords.getY(), chunkCoords.getZ());
    }

    /**
     * Converts chunk coordinates to world coordinates. This method never fails
     * and can returns invalid world coordinates.
     *
     * @param x The x chunk coordinate to convert to world coordinates
     * @param y The y chunk coordinate to convert to world coordinates
     * @param z The z chunk coordinate to convert to world coordinates
     * @return The world coordinates
     */
    Vector3i forceToWorld(int x, int y, int z);

    /**
     * Adds the chunk offset to the chunk coordinates. Returns nothing if the
     * new coordinates are not valid.
     *
     * @param chunkCoords The chunk coordinates to add to
     * @param chunkOffset The chunk offset to add to the chunk coordinates
     * @return The new chunk coordinates if they are valid
     */
    default Optional<Vector3i> addToChunk(Vector3i chunkCoords, Vector3i chunkOffset) {
        Objects.requireNonNull(chunkCoords, "chunkCoords");
        Objects.requireNonNull(chunkOffset, "chunkOffset");
        return addToChunk(chunkCoords.getX(), chunkCoords.getY(), chunkCoords.getZ(), chunkOffset.getX(), chunkOffset.getY(), chunkOffset.getZ());
    }

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
    default Optional<Vector3i> addToChunk(int cx, int cy, int cz, int ox, int oy, int oz) {
        final Vector3i newChunkCoords = new Vector3i(cx + ox, cy + oy, cz + oz);
        return isValidChunk(newChunkCoords) ? Optional.of(newChunkCoords) : Optional.empty();
    }

    /**
     * Moves chunk coordinates one step in the given direction. Returns nothing
     * if the new coordinates are not valid. {@link Division#SECONDARY_ORDINAL}
     * directions are not a valid argument. These will throw an exception.
     *
     * @param chunkCoords The chunk coordinates to move from
     * @param direction The direction in which to move a step
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     * {@link Division#SECONDARY_ORDINAL}
     */
    default Optional<Vector3i> moveToChunk(Vector3i chunkCoords, Direction direction) {
        return moveToChunk(chunkCoords, direction, 1);
    }

    /**
     * Moves chunk coordinates one step in the given direction. Returns nothing
     * if the new coordinates are not valid.
     * {@link Division#SECONDARY_ORDINAL} directions are not a valid
     * argument. These will throw an exception.
     *
     * @param x The x chunk coordinate to move from
     * @param y The y chunk coordinate to move from
     * @param z The z chunk coordinate to move from
     * @param direction The direction in which to move a step
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     * {@link Division#SECONDARY_ORDINAL}
     */
    default Optional<Vector3i> moveToChunk(int x, int y, int z, Direction direction) {
        return moveToChunk(new Vector3i(x, y, z), direction);
    }

    /**
     * Moves chunk coordinates a number of steps in the given direction. Returns
     * nothing if the new coordinates are not valid.
     * {@link Division#SECONDARY_ORDINAL} directions are not a valid
     * argument. These will throw an exception.
     *
     * @param chunkCoords The chunk coordinates to move from
     * @param direction The direction in which to move
     * @param steps The number of steps to take
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     * {@link Division#SECONDARY_ORDINAL}
     */
    default Optional<Vector3i> moveToChunk(Vector3i chunkCoords, Direction direction, int steps) {
        Objects.requireNonNull(direction, "direction");
        if (direction.isSecondaryOrdinal()) {
            throw new IllegalArgumentException("Secondary cardinal directions cannot be used here");
        }
        return addToChunk(chunkCoords, direction.asBlockOffset().mul(steps));
    }

    /**
     * Moves chunk coordinates a number of steps in the given direction. Returns
     * nothing if the new coordinates are not valid.
     * {@link Division#SECONDARY_ORDINAL} directions are not a valid
     * argument. These will throw an exception.
     *
     * @param x The x chunk coordinate to move from
     * @param y The y chunk coordinate to move from
     * @param z The z chunk coordinate to move from
     * @param direction The direction in which to move
     * @param steps The number of steps to take
     * @return The new chunk coordinates if they are valid
     * @throws IllegalArgumentException If the direction is a
     * {@link Division#SECONDARY_ORDINAL}
     */
    default Optional<Vector3i> moveToChunk(int x, int y, int z, Direction direction, int steps) {
        return moveToChunk(new Vector3i(x, y, z), direction, steps);
    }

}
