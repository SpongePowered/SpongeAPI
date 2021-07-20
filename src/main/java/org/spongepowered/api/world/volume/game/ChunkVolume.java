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
package org.spongepowered.api.world.volume.game;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.Server;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.WorldLike;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

/**
 * Presents a volume of {@link Chunk}s that can exist
 * without a {@link WorldLike} volume.
 */
public interface ChunkVolume extends Volume {

    /**
     * Returns information about the chunk layout used by this volume's
     * implementation. May differ based on the {@link Server#chunkLayout()}
     * used on the server.
     *
     * @return The chunk layout used by the implementation
     */
    ChunkLayout chunkLayout();

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the same as {@link Chunk#chunkPosition()}. The difference
     * between a block placed within a {@link WorldLike} is different from a
     * {@link Chunk}'s position, and therefore care should be taken when
     * requesting a chunk. It is not guaranteed that the returned {@link Chunk}
     * is {@link Chunk#isEmpty() empty} or not, nor the {@link Chunk#state() state}
     * of the chunk.
     *
     * <p>In Vanilla, the y coordinate will always be 0.</p>
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The chunk, may be empty
     */
    Chunk<@NonNull ?> chunk(int x, int y, int z);

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the same as {@link Chunk#chunkPosition()}. The difference
     * between a block placed within a {@link WorldLike} is different from a
     * {@link Chunk}'s position, and therefore care should be taken when
     * requesting a chunk. It is not guaranteed that the returned {@link Chunk}
     * is {@link Chunk#isEmpty() empty} or not, nor the {@link Chunk#state() state}
     * of the chunk.
     *
     * @param chunkPosition The position
     * @return The chunk, if available
     */
    default Chunk<@NonNull ?> chunk(final Vector3i chunkPosition) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
        return this.chunk(chunkPosition.x(), chunkPosition.y(), chunkPosition.z());
    }

    /**
     * Gets the loaded chunk at the given block coordinate position.
     *
     * @param blockPosition The position
     * @return The chunk, if available
     */
    default Chunk<@NonNull ?> chunkAtBlock(final Vector3i blockPosition) {
        Objects.requireNonNull(blockPosition, "blockPosition");
        return this.chunkAtBlock(blockPosition.x(), blockPosition.y(), blockPosition.z());
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the block position relative to the {@link Chunk#chunkPosition()},
     * and therefor is going to return a different chunk from {@link #chunk(Vector3i)}.
     * This is more usable from {@link ServerLocation}s or a {@link Locatable} that returns
     * a {@link Vector3i position} in relation to a {@link WorldLike}.
     *
     * @param bx The x coordinate
     * @param by The y coordinate
     * @param bz The z coordinate
     * @return The chunk, if available
     */
    Chunk<@NonNull ?> chunkAtBlock(final int bx, final int by, final int bz);

    /**
     * Gets whether a {@link Chunk} is loaded at the particular chunk
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @param allowEmpty Whether to allow empty chunks
     * @return Whether a chunk is loaded or not
     */
    boolean isChunkLoaded(int cx, int cy, int cz, boolean allowEmpty);


    /**
     * Gets whether a {@link Chunk} is loaded at the particular block
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param bx The block x coordinate
     * @param by The block y coordinate
     * @param bz The block z coordinate
     * @param allowEmpty Whether to allow empty chunks
     * @return Whether a chunk is loaded or not
     */
    default boolean isChunkLoadedAtBlock(final int bx, final int by, final int bz, final boolean allowEmpty) {
        return this.isChunkLoaded(this.chunkLayout().forceToChunk(bx, by, bz), allowEmpty);
    }

    /**
     * Gets whether a {@link Chunk} is loaded at the particular chunk
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param chunkPosition The chunk coordinates
     * @param allowEmpty Whether to allow empty chunks
     * @return Whether a chunk is loaded or not
     */
    default boolean isChunkLoaded(final Vector3i chunkPosition, final boolean allowEmpty) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
        return this.isChunkLoaded(chunkPosition.x(), chunkPosition.y(), chunkPosition.z(), allowEmpty);
    }

    /**
     * Gets whether a {@link Chunk} is loaded at the particular block
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param position The block coordinates
     * @param allowEmpty Whether to allow empty chunks
     * @return Whether a chunk is loaded or not
     */
    default boolean isChunkLoadedAtBlock(final Vector3i position, final boolean allowEmpty) {
        Objects.requireNonNull(position, "position");
        return this.isChunkLoaded(this.chunkLayout().forceToChunk(position), allowEmpty);
    }

    /**
     * Gets whether a {@link Chunk} exists at the particular chunk
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @return Whether a chunk exists
     */
    boolean hasChunk(int cx, int cy, int cz);

    /**
     * Gets whether a {@link Chunk} exists at the particular block
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param bx The block x coordinate
     * @param by The block y coordinate
     * @param bz The block z coordinate
     * @return Whether a chunk exists
     */
    default boolean hasChunkAtBlock(final int bx, final int by, final int bz) {
        return this.hasChunk(this.chunkLayout().forceToChunk(bx, by, bz));
    }

    /**
     * Gets whether a {@link Chunk} exists at the particular block
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param chunkPosition The chunk coordinates
     * @return Whether a chunk exists
     */
    default boolean hasChunk(final Vector3i chunkPosition) {
        return this.hasChunk(chunkPosition.x(), chunkPosition.y(), chunkPosition.z());
    }

    /**
     * Gets whether a {@link Chunk} exists at the particular block
     * coordinates. Note that chunk coordinates are distinctly different from
     * block coordinates, refer to the {@link #chunkLayout()} to convert back
     * and forth.
     *
     * @param blockPosition The block coordinates
     * @return Whether a chunk exists
     */
    default boolean hasChunkAtBlock(final Vector3i blockPosition) {
        return this.hasChunk(this.chunkLayout().forceToChunk(Objects.requireNonNull(blockPosition, "blockPosition")));
    }
}
