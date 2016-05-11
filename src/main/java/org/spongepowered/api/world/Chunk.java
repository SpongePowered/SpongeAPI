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

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.worker.MutableBiomeAreaWorker;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;

import java.util.Optional;

/**
 * A chunk is a specific grid-aligned partition of a {@link Extent}.
 *
 * <p>In Minecraft, the chunk is 16 by 16 blocks on the X and Z axes. The height
 * of each chunk varies between worlds.</p>
 */
public interface Chunk extends Extent {

    @Override
    default Location<Chunk> getLocation(Vector3i position) {
        return new Location<>(this, position);
    }

    @Override
    default Location<Chunk> getLocation(int x, int y, int z) {
        return getLocation(new Vector3i(x, y, z));
    }

    @Override
    default Location<Chunk> getLocation(Vector3d position) {
        return new Location<>(this, position);
    }

    @Override
    default Location<Chunk> getLocation(double x, double y, double z) {
        return getLocation(new Vector3d(x, y, z));
    }

    /**
     * Get the position of the chunk.
     *
     * <p>The returned position is 3-dimensional with the Y-coordinate set to be
     * the base (lowest) Y-position of the chunk. As 3-dimensional chunks do not
     * yet exist in Minecraft, the returned position will always have a
     * {@code y} set to 0.</p>
     *
     * @return The position
     */
    Vector3i getPosition();

    /**
     * Gets the world the chunk is in.
     *
     * @return The world
     */
    World getWorld();

    /**
     * Gets if the chunk has been populated by the generator.
     *
     * @return Whether or not the chunk has been populated.
     */
    boolean isPopulated();

    /**
     * Loads this chunk, and generates if specified and required.
     *
     * @param generate Whether or not to generate the chunk if it does not yet
     * exist
     * @return If the chunk was successfully loaded
     */
    boolean loadChunk(boolean generate);

    /**
     * Unloads this chunk, if possible.
     *
     * @return Whether or not the chunk unloaded
     */
    boolean unloadChunk();

    /**
     * Gets the number of ticks players have been present in this chunk, used
     * for calculation of the regional difficulty factor. In vanilla, it is
     * increased by the number of players in the chunk every tick, and is capped
     * at 3,600,000 ticks (50 hours).
     *
     * @return The number of ticks
     */
    int getInhabittedTime();

    /**
     * Gets the regional difficulty factor for this chunk. In vanilla, it is
     * dependent on the playtime of the world, inhabited time of the chunk, the
     * phase of the moon, and the current difficulty setting. This number ranges
     * from 0.75-1.5 on easy, 1.5-4.0 on normal, and 2.25-6.75 on hard.
     *
     * <p>This value is used for display only in vanilla.</p>
     *
     * @return The regional difficulty factor for this chunk
     */
    double getRegionalDifficultyFactor();

    /**
     * Gets the regional difficulty percentage for this chunk. It is calculated
     * by taking the regional difficulty factor and using the following rules:
     * If the factor is less than 2.0, the percentage is 0%. If the factor is
     * greater than 4.0, the percentage is 100%. Otherwise, the percentage is
     * the factor minus 2.0, divided by 2.0.
     *
     * <p>This is the value that is used in vanilla to find which effects are
     * caused by the regional difficulty.</p>
     *
     * @return The regional difficulty percentage for this chunk
     */
    double getRegionalDifficultyPercentage();

    /**
     * Gets the chunk in the given direction from this chunk, if it exists.
     *
     * @param direction The cardinal or ordinal direction to get the chunk from
     * @return The neighbor chunk, if available
     */
    default Optional<Chunk> getNeighbor(Direction direction) {
        return getNeighbor(direction, false);
    }

    /**
     * Gets the chunk in the given direction from this chunk.
     *
     * @param direction The cardinal or ordinal direction to get the chunk from
     * @param shouldLoad Whether the server should load or generate the chunk if unavailable
     * @return The neighbor chunk, if available or if {@code shouldLoad} is true
     */
    default Optional<Chunk> getNeighbor(Direction direction, boolean shouldLoad) {
        Optional<Vector3i> neighborPosition = Sponge.getServer().getChunkLayout().moveToChunk(getPosition(), direction);
        return neighborPosition.isPresent() ? getWorld().loadChunk(neighborPosition.get(), shouldLoad) : Optional.empty();
    }

    @Override
    MutableBiomeAreaWorker<Chunk> getBiomeWorker();

    @Override
    MutableBlockVolumeWorker<Chunk> getBlockWorker(Cause cause);

}
