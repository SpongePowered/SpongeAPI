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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

/**
 * A generating region of {@link PrimitiveChunk}s that are in the
 * stages of being generated for a {@link World} and eventually will
 * become {@link Chunk} instances. A region is similar to a {@link World}
 * in that there are {@link PrimitiveChunk}s available, {@link BlockState}s
 * are used in this region, and likewise, the region can contain and store
 * {@link BlockEntity} instances being generated, {@link Entity} instances
 * being generated or spawned by generation, etc. The major difference
 * is that a generation region cannot be utilized for {@link ServerLocation}s,
 * nor is it considered to be viewable by {@link Player}s or accessible
 * by the {@link Server} or {@link World}(s).
 */
public interface GenerationRegion extends ProtoWorld<GenerationRegion> {

    Vector3i getCenterChunkPos();

    default int getCenterChunkX() {
        return getCenterChunkPos().getX();
    }

    default int getCenterChunkY() {
        return getCenterChunkPos().getY();
    }

    default int getCenterChunkZ() {
        return getCenterChunkPos().getZ();
    }

    @Override
    default PrimitiveChunk getChunkAtBlock(Vector3i position) {
        return getChunkAtBlock(position.getX(), position.getY(), position.getZ());
    }

    @Override
    default PrimitiveChunk getChunkAtBlock(int x, int y, int z) {
        return getChunk(Sponge.getServer().getChunkLayout().toChunk(x, y, z)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Cannot convert (%s, %s, %s) to chunk coordinates.", x, y, z))));
    }

    @Override
    default PrimitiveChunk getChunk(Vector3i chunkPosition) {
        return getChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ());
    }

    @Override
    PrimitiveChunk getChunk(int cx, int cy, int cz);

    ServerWorld getWorld();
}
