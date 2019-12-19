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

import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolumeCreator;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.game.TrackedVolume;
import org.spongepowered.api.world.weather.WeatherUniverse;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Predicate;

/**
 * A loaded Minecraft world.
 */
public interface World<W extends World<W>> extends ProtoWorld<W>,
    LocationCreator,
    PhysicsAwareMutableBlockVolume<BoundedWorldView<W>>,
    WeatherUniverse,
    ContextSource,
    ChatTypeMessageReceiver,
    TrackedVolume,
    Viewer,
    ArchetypeVolumeCreator
{

    /**
     * Gets the {@link Server} that is managing this world.
     *
     * @return The server
     */
    Server getServer();

    /**
     * Gets if this world is currently loaded.
     *
     * <p>
     *     An assumption can be made that if this returns false, this is considered a stale object.
     * </p>
     * @return True if loaded, false if not
     */
    boolean isLoaded();

    /**
     * Gets an unmodifiable collection of {@link Player}s currently in this world.
     *
     * @return The players
     */
    @Override
    Collection<? extends Player> getPlayers();

    default Optional<? extends Player> getClosestPlayer(Vector3i position, double distance) {
        return getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(Vector3i position, double distance, Predicate<? super Player> predicate) {
        return getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(Entity entity, double distance) {
        final Vector3d position = entity.getLocation().getPosition();
        return getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(Entity entity, double distance, Predicate<? super Player> predicate) {
        final Vector3d position = entity.getLocation().getPosition();
        return getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(int x, int y, int z, double distance) {
        return getClosestPlayer(x, y, z, distance, player -> true);
    }

    Optional<? extends Player> getClosestPlayer(int x, int y, int z, double distance, Predicate<? super Player> predicate);

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param position The position of the block
     * @return A snapshot
     */
    default BlockSnapshot createSnapshot(Vector3i position) {
        return this.createSnapshot(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
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
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return true if the restore was successful, false otherwise
     */
    default boolean restoreSnapshot(Vector3i position, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag) {
        return this.restoreSnapshot(position.getX(), position.getY(), position.getZ(), snapshot, force, flag);
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
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * <p>Note that this is still different from {@link #getChunk(Vector3i)}
     * due to the relative block position dictated by {@link Server#getChunkLayout()},
     * which can vary depending on implementation and other mods installed.</p>
     *
     * @param blockPosition The block position to be transformed for relative chunk position
     * @return The available chunk at that position
     */
    @Override
    default Chunk getChunkAtBlock(Vector3i blockPosition) {
        final Vector3i chunkPos = Sponge.getServer().getChunkLayout().forceToChunk(blockPosition);
        return this.getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
    }

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * <p>Note that this is still different from {@link #getChunk(Vector3i)}
     * due to the relative block position dictated by {@link Server#getChunkLayout()},
     * which can vary depending on implementation and other mods installed.</p>
     *
     * @param bx The block x coordinate
     * @param by The block y coordinate
     * @param bz The block z coordinate
     * @return The available chunk at that position
     */
    @Override
    default Chunk getChunkAtBlock(int bx, int by, int bz) {
        final Vector3i chunkPos = this.getServer().getChunkLayout().forceToChunk(bx, by, bz);
        return this.getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
    }

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * @param chunkPos The chunk position relative to the {@link Server#getChunkLayout() chunk layout}
     * @return The available chunk at that position
     */
    @Override
    default Chunk getChunk(Vector3i chunkPos) {
        return this.getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
    }

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * @param cx The x chunk coordinate
     * @param cy The y coordinate
     * @param cz The z chunk coordinate
     * @return The available chunk at the chunk position
     */
    @Override
    Chunk getChunk(int cx, int cy, int cz);

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param chunkPosition The position
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    default Optional<Chunk> loadChunk(Vector3i chunkPosition, boolean shouldGenerate) {
        return this.loadChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), shouldGenerate);
    }

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * <p>In Vanilla, the y coordinate will always be 0.</p>
     *
     * @param cx The x coordinate
     * @param cy The y coordinate
     * @param cz The z coordinate
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    Optional<Chunk> loadChunk(int cx, int cy, int cz, boolean shouldGenerate);

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * <p>Unlike {@link #loadChunk(Vector3i, boolean)} this method allows the
     * implementation to load the chunk asynchronously without blocking the
     * main server thread. The {@link Future} will be called with the chunk once
     * the operation was completed.</p>
     *
     * <p><b>Note:</b> If asynchronous chunk loading is not supported by
     * the implementation, the chunk will be loaded synchronously and the
     * {@link Future} will be called immediately.</p>
     *
     * @param chunkPosition The position
     * @param shouldGenerate True to generate a new chunk
     * @return The future callback for the loaded chunk
     */
    default CompletableFuture<Optional<Chunk>> loadChunkAsync(Vector3i chunkPosition, boolean shouldGenerate) {
        return this.loadChunkAsync(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), shouldGenerate);
    }

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * <p>Unlike {@link #loadChunk(Vector3i, boolean)} this method allows the
     * implementation to load the chunk asynchronously without blocking the
     * main server thread. The {@link Future} will be called with the chunk once
     * the operation was completed.</p>
     *
     * <p><b>Note:</b> If asynchronous chunk loading is not supported by
     * the implementation, the chunk will be loaded synchronously and the
     * {@link Future} will be called immediately.</p>
     *
     * @param cx The x coordinate
     * @param cy The y coordinate
     * @param cz The z coordinate
     * @param shouldGenerate True to generate a new chunk
     * @return The future callback for the loaded chunk
     */
    default CompletableFuture<Optional<Chunk>> loadChunkAsync(int cx, int cy, int cz, boolean shouldGenerate) {
        return CompletableFuture.completedFuture(loadChunk(cx, cy, cz, shouldGenerate));
    }

    /**
     * Returns a Collection of all actively loaded chunks in this world.
     *
     * <p>The ordering of the returned chunks is undefined.</p>
     *
     * @return The loaded chunks
     */
    Iterable<Chunk> getLoadedChunks();

    /**
     * Gets the {@link Location} of the spawn point.
     *
     * @return The location
     */
    default Location getSpawnLocation() {
        return Location.of(this, this.getProperties().getSpawnPosition());
    }
}
