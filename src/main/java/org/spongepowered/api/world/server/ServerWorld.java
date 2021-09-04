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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.ChunkRegenerateFlag;
import org.spongepowered.api.world.ChunkRegenerateFlags;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.WorldTypes;
import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.generation.ChunkGenerator;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;
import org.spongepowered.api.world.volume.game.InteractableVolume;
import org.spongepowered.api.world.weather.WeatherUniverse;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public interface ServerWorld extends World<ServerWorld, ServerLocation>, Identifiable, InteractableVolume,
        ServerLocationCreator, WeatherUniverse.Mutable {

    @Override
    Server engine();

    @Override
    ServerWorldProperties properties();

    ChunkGenerator generator();

    WorldTemplate asTemplate();

    /**
     * @see ServerWorldProperties#key()
     * @return The key
     */
    ResourceKey key();

    /**
     * @see ServerWorldProperties#uniqueId()
     * @return The unique id
     */
    @Override
    default UUID uniqueId() {
        return this.properties().uniqueId();
    }

    @Override
    default WorldChunk chunkAtBlock(final int bx, final int by, final int bz) {
        final Vector3i chunkPos = this.engine().chunkLayout().forceToChunk(bx, by, bz);
        return this.chunk(chunkPos.x(), chunkPos.y(), chunkPos.z());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param position The position of the block
     * @return A snapshot
     */
    default BlockSnapshot createSnapshot(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.createSnapshot(position.x(), position.y(), position.z());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return A snapshot
     */
    BlockSnapshot createSnapshot(int x, int y, int z);

    /**
     * Restores the given {@link BlockSnapshot} using the saved block position
     * stored within the snapshot.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return True if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType block types} do not match, false will be
     * returned. If notifyNeighbors is {@code true}, neighboring blocks will be notified
     * of changes at the restored block location triggering physics updates.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the the block type does
     *             not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return True if the restore was successful, false otherwise
     */
    default boolean restoreSnapshot(final Vector3i position, final BlockSnapshot snapshot, final boolean force, final BlockChangeFlag flag) {
        Objects.requireNonNull(position, "position");
        return this.restoreSnapshot(position.x(), position.y(), position.z(), Objects.requireNonNull(snapshot, "snapshot"), force, Objects.requireNonNull(flag, "flag"));
    }

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(int x, int y, int z, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * Gets the {@link Path} pointing to the root of where the world's data
     * is being stored.
     *
     * @return The path
     */
    Path directory();

    /**
     * Instructs the world to save all data.
     *
     * @return True if save was successful, or false if
     *     {@link SerializationBehavior} is {@link SerializationBehavior#NONE}
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
    boolean unloadChunk(WorldChunk chunk);

    /**
     * Causes an {@link Explosion} in a world.
     *
     * @param explosion The explosion to cause
     */
    void triggerExplosion(Explosion explosion);

    @Override
    Collection<ServerPlayer> players();
    
    /**
     * Gets all {@link Raid}s occuring in this {@link ServerWorld}.
     *
     * <p>Please note by default, some {@link WorldType}s such as {@link WorldTypes#THE_NETHER}
     * will not contain any Raids because the game prevents Raids from starting in the nether.</p>
     *
     * @return All the raids in this world.
     */
    Collection<Raid> raids();

    /**
     * Gets the {@link Raid} occurring at a position in the world.
     *
     * @param blockPosition The location of the Raid.
     * @return The raid at that location, if present
     */
    Optional<Raid> raidAt(Vector3i blockPosition);

    /**
     * Gets the {@link ChunkManager} for this world.
     *
     * @return The chunk manager.
     */
    ChunkManager chunkManager();

}
