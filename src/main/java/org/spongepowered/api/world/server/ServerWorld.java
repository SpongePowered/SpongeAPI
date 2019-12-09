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
package org.spongepowered.api.world.server;

import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.ChunkRegenerateFlag;
import org.spongepowered.api.world.ChunkRegenerateFlags;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.SerializationBehaviors;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.storage.WorldStorage;
import org.spongepowered.api.world.volume.game.InteractableVolume;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ServerWorld extends World<ServerWorld>, Identifiable, InteractableVolume {

    @Override
    Server getServer();

    /**
     * Regenerates a chunk at the given chunk coordinate position.
     *
     * @param chunkPosition The chunk position to regenerate
     * @return The regenerated chunk, if available
     */
    default Optional<Chunk> regenerateChunk(Vector3i chunkPosition) {
        return regenerateChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), ChunkRegenerateFlags.ALL);
    }

    /**
     * Regenerates a chunk at the given chunk coordinates.
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @return The regenerated chunk, if available
     */
    default Optional<Chunk> regenerateChunk(int cx, int cy, int cz) {
        return regenerateChunk(cx, cy, cz, ChunkRegenerateFlags.ALL);
    }

    /**
     * Regenerates a chunk at the given chunk coordinate position.
     *
     * @param chunkPosition The chunk position to regenerate
     * @param flag The chunk regenerate flag to use
     * @return The regenerated chunk, if available
     */
    default Optional<Chunk> regenerateChunk(Vector3i chunkPosition, ChunkRegenerateFlag flag) {
        return regenerateChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), flag);
    }

    /**
     * Regenerates a chunk at the given chunk coordinates.
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @param flag The chunk regenerate flag to use
     * @return The regenerated chunk, if available
     */
    Optional<Chunk> regenerateChunk(int cx, int cy, int cz, ChunkRegenerateFlag flag);

    /**
     * Gets the {@link Path} pointing to the root of where the world's data
     * is being stored.
     *
     * @return The path
     */
    Path getDirectory();

    /**
     * Gets the associated {@link WorldStorage} persisting this world.
     *
     * @return The associated world storage
     */
    WorldStorage getWorldStorage();

    /**
     * Instructs the world to save all data.
     *
     * @return True if save was successfull, or false if
     *     {@link SerializationBehavior} is {@link SerializationBehaviors#NONE}
     * @throws IOException If the save failed
     */
    boolean save() throws IOException;

    /**
     * Unloads the given chunk from the world. Returns a {@code boolean} flag
     * for whether the operation was successful.
     *
     * @param chunk The chunk to unload
     * @return Whether the operation was successful
     */
    boolean unloadChunk(Chunk chunk);

    /**
     * Gets this {@link World}'s {@link UUID}.
     *
     * @see WorldProperties#getUniqueId()
     * @return The uuid for this world
     */
    @Override
    default UUID getUniqueId() {
        return this.getProperties().getUniqueId();
    }

    /**
     * Causes an {@link Explosion} in a world.
     *
     * @param explosion The explosion to cause
     */
    void triggerExplosion(Explosion explosion);

    @Override
    Collection<ServerPlayer> getPlayers();
}
