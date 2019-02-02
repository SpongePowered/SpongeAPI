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
package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.property.LocationBasePropertyHolder;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.biome.MutableBiomeVolume;
import org.spongepowered.api.world.chunk.ChunkVolume;
import org.spongepowered.api.world.chunk.ProtoChunk;
import org.spongepowered.api.world.volume.InteractableVolume;
import org.spongepowered.api.world.volume.LightCalculatingVolume;
import org.spongepowered.api.world.volume.LocationCompositeValueStore;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.entity.CollisionAwareEntityVolume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;
import org.spongepowered.api.world.volume.tileentity.MutableTileEntityVolume;

public interface ProtoWorld<P extends ProtoWorld<P>> extends
        MutableBiomeVolume<P>,
        MutableBlockVolume<P>,
        MutableEntityVolume<P>,
        MutableTileEntityVolume<P>,
        ChunkVolume,
        CollisionAwareEntityVolume,
        InteractableVolume,
        LocationBasePropertyHolder,
        LocationCompositeValueStore,
        LightCalculatingVolume,
        UpdatableVolume,
        RandomProvider
{

    /**
     * Gets the loaded chunk at the given block coordinate position.
     *
     * @param blockPosition The position
     * @return The chunk, if available
     */
    default ProtoChunk<?> getChunkAtBlock(Vector3i blockPosition) {
        return getChunkAtBlock(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ());
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the block position relative to the {@link ProtoChunk#getChunkPosition()},
     * and therefor is going to return a different chunk from {@link #getChunk(Vector3i)}.
     * This is more usable from {@link Location}s or a {@link Locatable} that returns
     * a {@link Vector3i position} in relation to a {@link ProtoWorld}.
     *
     * @param bx The x coordinate
     * @param by The y coordinate
     * @param bz The z coordinate
     * @return The chunk, if available
     */
    default ProtoChunk<?> getChunkAtBlock(int bx, int by, int bz) {
        return getChunk(Sponge.getServer().getChunkLayout().forceToChunk(bx, by, bz));
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the same as {@link ProtoChunk#getChunkPosition()}. The difference
     * between a block placed within a {@link ProtoWorld} is different from a
     * {@link ProtoChunk}'s position, and therefore care should be taken when
     * requesting a chunk. It is not guaranteed that the returned {@link ProtoChunk}
     * is {@link ProtoChunk#isEmpty() empty} or not, nor the {@link ProtoChunk#getState() state}
     * of the chunk.
     *
     * @param chunkPosition The position
     * @return The chunk, if available
     */
    default ProtoChunk<?> getChunk(Vector3i chunkPosition) {
        return getChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ());
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position. The position
     * is the same as {@link ProtoChunk#getChunkPosition()}. The difference
     * between a block placed within a {@link ProtoWorld} is different from a
     * {@link ProtoChunk}'s position, and therefore care should be taken when
     * requesting a chunk. It is not guaranteed that the returned {@link ProtoChunk}
     * is {@link ProtoChunk#isEmpty() empty} or not, nor the {@link ProtoChunk#getState() state}
     * of the chunk.
     *
     * <p>In Vanilla, the y coordinate will always be 0.</p>
     *
     * @param cx The x coordinate
     * @param cy The y coordinate
     * @param cz The z coordinate
     * @return The chunk, if available
     */
    ProtoChunk<?> getChunk(int cx, int cy, int cz);

    default boolean hasWater(Vector3i pos) {
        return hasWater(pos.getX(), pos.getY(), pos.getZ());
    }

    boolean hasWater(int x, int y, int z);


    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param x The x column value
     * @param z The z column value
     * @return The y value of the highest opaque block
     */
    int getHighestYAt(int x, int z);

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param column The column value
     * @return The y value of the highest opaque block
     */
    default int getHighestYAt(Vector2i column) {
        return this.getHighestYAt(column.getX(), column.getY());
    }

    /**
     * Get the {@link Location} of the highest block that sunlight can reach in
     * the given column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param position The column position
     * @return The highest opaque position
     */
    default Vector3i getHighestPositionAt(Vector3i position) {
        return new Vector3i(position.getX(), getHighestYAt(position.getX(), position.getZ()), position.getZ());
    }

    WorldBorder getBorder();

    @Override
    P getView(Vector3i newMin, Vector3i newMax);
}
