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
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.extent.LightCalculatingVolume;
import org.spongepowered.api.world.extent.LocationCompositeValueStore;
import org.spongepowered.api.world.biome.MutableBiomeVolume;
import org.spongepowered.api.world.extent.block.MutableBlockVolume;
import org.spongepowered.api.world.extent.entity.CollisionAwareEntityVolume;
import org.spongepowered.api.world.extent.entity.MutableEntityVolume;

import java.util.Optional;

public interface ProtoWorld<P extends ProtoWorld<P>>
    extends
    MutableBiomeVolume<P>,
    MutableBlockVolume<P>,
    MutableEntityVolume<P>,
    CollisionAwareEntityVolume,
    InteractableVolume,
    LocationBasePropertyHolder,
    LocationCompositeValueStore,
    LightCalculatingVolume
{

    /**
     * Gets the loaded chunk at the given block coordinate position.
     *
     * @param blockPosition The position
     * @return The chunk, if available
     */
    default Optional<Chunk> getChunkAtBlock(Vector3i blockPosition) {
        return getChunkAtBlock(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ());
    }

    /**
     * Gets the loaded chunk at the given block coordinate position.
     *
     * @param bx The x coordinate
     * @param by The y coordinate
     * @param bz The z coordinate
     * @return The chunk, if available
     */
    default Optional<Chunk> getChunkAtBlock(int bx, int by, int bz) {
        return getChunk(Sponge.getServer().getChunkLayout().forceToChunk(bx, by, bz));
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position.
     *
     * @param chunkPosition The position
     * @return The chunk, if available
     */
    default Optional<Chunk> getChunk(Vector3i chunkPosition) {
        return getChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ());
    }

    /**
     * Gets the loaded chunk at the given chunk coordinate position.
     *
     * <p>In Vanilla, the y coordinate will always be 0.</p>
     *
     * @param cx The x coordinate
     * @param cy The y coordinate
     * @param cz The z coordinate
     * @return The chunk, if available
     */
    Optional<Chunk> getChunk(int cx, int cy, int cz);


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
