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
package org.spongepowered.api.world.chunk;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.World;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

/**
 * A chunk is a specific grid-aligned partition of a {@link World}.
 *
 * <p>In Minecraft, the chunk is 16 by 16 blocks on the X and Z axes. The height
 * of each chunk varies between worlds.</p>
 */
@DoNotStore
public interface Chunk extends ProtoChunk<Chunk> {

    /**
     * Gets the world the chunk is in.
     *
     * @return The world
     */
    @Override
    World<?> getWorld();

    /**
     * Loads this chunk, and generates if specified and required.
     *
     * @param generate Whether or not to generate the chunk if it does not yet
     *     exist
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
    long getInhabitedTime();


    /**
     * Gets the chunk in the given direction from this chunk, if it exists.
     *
     * @param direction The cardinal or ordinal direction to get the chunk from
     * @return The neighbor chunk, if available
     */
    default Optional<Chunk> getNeighbor(final Direction direction) {
        return this.getNeighbor(direction, false);
    }

    /**
     * Gets the chunk in the given direction from this chunk.
     *
     * @param direction The cardinal or ordinal direction to get the chunk from
     * @param shouldLoad Whether the server should load or generate the chunk
     *     if unavailable
     * @return The neighbor chunk, if available or if {@code shouldLoad} is true
     */
    default Optional<Chunk> getNeighbor(final Direction direction, final boolean shouldLoad) {
        final Optional<Vector3i> neighborPosition = Sponge.getServer().getChunkLayout().moveToChunk(this.getChunkPosition(), direction);
        return neighborPosition.flatMap(vector3i -> this.getWorld().loadChunk(vector3i, shouldLoad));
    }

}
