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
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.ChunkPreGenerate;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.gamerule.GameRule;
import org.spongepowered.api.world.gamerule.GameRuleHolder;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.storage.WorldStorage;
import org.spongepowered.api.world.teleport.PortalAgent;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * A loaded Minecraft world.
 */
public interface World extends ProtoWorld<World>, LocationCreator<World>, PhysicsAwareMutableBlockVolume<World>, Identifiable, WeatherUniverse,
        Viewer, ContextSource, MessageReceiver, ChatTypeMessageReceiver, TrackedVolume, GameRuleHolder {

    /**
     * Gets an unmodifiable collection of {@link Player}s currently in this world.
     *
     * @return The players
     */
    Collection<Player> getPlayers();

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
        return createSnapshot(position.getX(), position.getY(), position.getZ());
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
        return restoreSnapshot(position.getX(), position.getY(), position.getZ(), snapshot, force, flag);
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
        return getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
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
        final Vector3i chunkPos = Sponge.getServer().getChunkLayout().forceToChunk(bx, by, bz);
        return getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
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
        return getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
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
        return loadChunkAsync(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), shouldGenerate);
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
     * Unloads the given chunk from the world. Returns a {@code boolean} flag
     * for whether the operation was successful.
     *
     * @param chunk The chunk to unload
     * @return Whether the operation was successful
     */
    boolean unloadChunk(Chunk chunk);

    /**
     * Returns a Collection of all actively loaded chunks in this world.
     *
     * <p>The ordering of the returned chunks is undefined.</p>
     *
     * @return The loaded chunks
     */
    Iterable<Chunk> getLoadedChunks();

    /**
     * Gets the world border for the world.
     *
     * @return The world border
     */
    WorldBorder getWorldBorder();

    /**
     * Returns a new builder for creating a task to pre-generate the chunks
     * inside a square border with a given center and diameter.
     *
     * @param center The center of the border
     * @param diameter The diameter of the border
     * @return The builder for the chunk pre-generate task
     * @see ChunkPreGenerate
     */
    ChunkPreGenerate.Builder newChunkPreGenerate(Vector3d center, double diameter);

    /**
     * Returns the {@link Dimension} of this world.
     *
     * @return The {@link Dimension}
     */
    Dimension getDimension();

    /**
     * Gets the {@link WorldGenerator} for this world.
     *
     * <p>Any changes made to the world generator will only affect newly
     * generated chunks.</p>
     *
     * @return The world generator
     */
    WorldGenerator getWorldGenerator();

    /**
     * Gets the properties for this world.
     *
     * @return The properties
     */
    WorldProperties getProperties();

    /**
     * Gets the {@link Path} pointing to the root of where the world's data
     * is being stored.
     *
     * @return The path
     */
    Path getDirectory();

    /**
     * Gets this {@link World}'s {@link UUID}.
     *
     * @see WorldProperties#getUniqueId()
     * @return The uuid for this world
     */
    @Override
    default UUID getUniqueId() {
        return getProperties().getUniqueId();
    }

    /**
     * Gets the name of this {@link World world}.
     *
     * @see WorldProperties#getWorldName()
     * @return The name for this world
     */
    default String getName() {
        return getProperties().getWorldName();
    }

    /**
     * Gets the current {@link Difficulty}.
     *
     * @see WorldProperties#getDifficulty()
     * @return The difficulty for this world
     */
    default Difficulty getDifficulty() {
        return getProperties().getDifficulty();
    }

    @Override
    default <V> V getGameRule(GameRule<V> gameRule) {
        return getProperties().getGameRule(gameRule);
    }

    @Override
    default <V> void setGameRule(GameRule<V> gameRule, V value) {
        getProperties().setGameRule(gameRule, value);
    }

    @Override
    default Map<GameRule<?>, ?> getGameRules() {
        return getProperties().getGameRules();
    }

    /**
     * Gets whether the spawn chunks should remain loaded.
     *
     * @see WorldProperties#doesKeepSpawnLoaded()
     * @return True if the spawn of this world should remain loaded
     */
    default boolean doesKeepSpawnLoaded() {
        return getProperties().doesKeepSpawnLoaded();
    }

    /**
     * Sets whether the spawn chunks should remain loaded.
     *
     * @see WorldProperties#setKeepSpawnLoaded(boolean)
     * @param keepLoaded Whether to keep spawn loaded
     */
    default void setKeepSpawnLoaded(boolean keepLoaded) {
        getProperties().setKeepSpawnLoaded(keepLoaded);
    }

    /**
     * Gets the {@link Location} of the spawn point.
     *
     * @return The location
     */
    default Location getSpawnLocation() {
        return new Location(this, getProperties().getSpawnPosition());
    }

    /**
     * Gets the {@link SerializationBehavior} to use.
     *
     * @see WorldProperties#getSerializationBehavior()
     * @return The serialization behavior of this world
     */
    default SerializationBehavior getSerializationBehavior() {
        return getProperties().getSerializationBehavior();
    }

    /**
     * Sets the {@link SerializationBehavior} for use.
     *
     * @see WorldProperties#setSerializationBehavior(SerializationBehavior)
     * @param behavior The serialization behavior to set
     */
    default void setSerializationBehavior(SerializationBehavior behavior) {
        getProperties().setSerializationBehavior(behavior);
    }

    /**
     * Gets the associated {@link WorldStorage} persisting this world.
     *
     * @return The associated world storage
     */
    WorldStorage getWorldStorage();

    /**
     * Causes an {@link Explosion} in a world.
     *
     * @param explosion The explosion to cause
     */
    void triggerExplosion(Explosion explosion);

    /**
     * Gets the portal agent, used for manipulating teleporters.
     *
     * @return The portal agent
     */
    PortalAgent getPortalAgent();

    /**
     * Gets the sea level of the world.
     *
     * @return The sea level
     */
    int getSeaLevel();


    /**
     * Instructs the world to save all data.
     *
     * @return True if save was successfull, or false if
     *     {@link SerializationBehavior} is {@link SerializationBehaviors#NONE}
     * @throws IOException If the save failed
     */
    boolean save() throws IOException;

    /**
     * Gets the view distance (in chunks) for this world.
     *
     * @return The view distance
     */
    int getViewDistance();

    /**
     * Sets the view distance (in chunks) for this world.
     *
     * <p>The view distance must be greater than or equal to 3,
     * and less than or equal to 32.</p>
     *
     * @param viewDistance The view distance
     */
    void setViewDistance(int viewDistance);

    /**
     * Resets the view distance to the default value for this world.
     */
    void resetViewDistance();

    boolean isLoaded();
}
