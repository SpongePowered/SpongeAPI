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
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.worker.MutableBiomeVolumeWorker;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;
import org.spongepowered.api.world.gamerule.DefaultGameRules;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.storage.WorldStorage;
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
public interface World extends Extent, WeatherUniverse, Viewer, ContextSource, MessageReceiver, ChatTypeMessageReceiver {

    /**
     * Gets an unmodifiable collection of {@link Player}s currently in this world.
     *
     * @return The players
     */
    Collection<Player> getPlayers();

    @Override
    default Location<World> getLocation(Vector3i position) {
        return new Location<>(this, position);
    }

    @Override
    default Location<World> getLocation(int x, int y, int z) {
        return getLocation(new Vector3i(x, y, z));
    }

    @Override
    default Location<World> getLocation(Vector3d position) {
        return new Location<>(this, position);
    }

    @Override
    default Location<World> getLocation(double x, double y, double z) {
        return getLocation(new Vector3d(x, y, z));
    }

    /**
     * Gets a {@link LocatableBlock} for the desired {@link Vector3i} position.
     *
     * @param position The position to get the locatable block
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(Vector3i position) {
        return LocatableBlock.builder().world(this).position(position).build();
    }

    /**
     * Gets a {@link LocatableBlock} for the desired {@code x, y, z} coordinates.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(int x, int y, int z) {
        return LocatableBlock.builder().world(this).position(x, y, z).build();
    }

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
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existent.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method may return no entity if the entity is not
     * loaded.</p>
     *
     * @param uuid The unique id
     * @return An entity, if available
     */
    @Override
    Optional<Entity> getEntity(UUID uuid);

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

    /**
     * Gets a set game rule's current value, if available and set.
     *
     * @see WorldProperties#getGameRule(String)
     * @param gameRule The game rule
     * @return the game rule, if available
     */
    default Optional<String> getGameRule(String gameRule) {
        return getProperties().getGameRule(gameRule);
    }

    /**
     * Gets the current {@link Map map} of game rules and their
     * values. Most game rules can be found in {@link DefaultGameRules}.
     *
     * @see WorldProperties#getGameRules()
     * @return The map of game rules and their values
     */
    default Map<String, String> getGameRules() {
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
    default Location<World> getSpawnLocation() {
        return new Location<>(this, getProperties().getSpawnPosition());
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
     * @param cause The cause for the explosion
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

    @Override
    MutableBiomeVolumeWorker<World> getBiomeWorker();

    @Override
    MutableBlockVolumeWorker<World> getBlockWorker();

    /**
     * Instructs the world to save all data.
     *
     * @return True if save was successfull, false if {@link SerializationBehavior} is {@link SerializationBehaviors#NONE}.
     * @throws IOException If the save failed
     */
    boolean save() throws IOException;
}
