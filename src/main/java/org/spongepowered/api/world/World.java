/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import java.util.Map;
import java.util.UUID;

import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.storage.StorageContainer;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.ChunkData;
import org.spongepowered.api.world.chunk.ChunkDecorator;
import org.spongepowered.api.world.chunk.ChunkGenerator;
import org.spongepowered.api.world.chunk.ChunkPopulator;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.region.Region;
import org.spongepowered.api.world.weather.WeatherVolume;

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * A loaded Minecraft world
 */
public interface World extends Extent, Viewer, WeatherVolume {

    /**
     * Gets the unique identifier for this world.
     *
     * @return The unique id or UUID
     */
    UUID getUniqueID();

    /**
     * Gets the name of the world.
     *
     * <p>The world name may randomly generated or user-defined. It may or
     * may not be safe to be used in a filename.</p>
     *
     * @return The world name
     * @see #getUniqueID() A method to get a unique identifier
     */
    String getName();

    /**
     * Gets the chunk generator used to generate this world.
     *
     * @return The chunk generator used to generate this world
     */
    ChunkGenerator getChunkGenerator();

    /**
     * Gets the chunk populator used to populate this world.
     *
     * @return The chunk populator used to populate this world
     */
    ChunkPopulator getChunkPopulator();

    /**
     * Gets the chunk decorator used to decorate this world.
     *
     * @return The chunk decorator used to decorate this world
     */
    ChunkDecorator getChunkDecorator();

    /**
     * Gets the storage where all data belonging to this world are stored. May
     * be a folder, database or anything else. In vanilla minecraft this is the
     * world folder.
     *
     * @return The storage where all data belonging to this world are stored
     */
    StorageContainer getStorage();

    /**
     * Gets the storage where all region data belonging to this world are
     * stored. May be a folder, database or anything else. In vanilla minecraft
     * this is the world/region folder.
     *
     * @return The storage where all region data belonging to this world are
     *         stored
     */
    Optional<StorageContainer> getRegionsStorage();

    /**
     * Gets the region that would contain the chunk at the given location.
     *
     * @param position The position of the chunk.
     * @return The region that would contain the chunk.
     */
    Region getRegionForChunk(Vector2i position);

    /**
     * Gets an {@link Iterable} containing all regions in this world. Due to the
     * asynchronous nature of this method newly generated or deleted regions may
     * or may not be visible in the iterator, this only applies to regions that
     * have not been iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     *
     * @return An iterable containing all existing regions
     */
    Iterable<Region> getExistingRegionsAsynchronously();

    /**
     * Gets all existing chunks within the given bounds. Due to the asynchronous
     * nature of this method newly generated or deleted chunks may or may not be
     * visible in the iterator, this only applies to chunks that have not been
     * iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * If you don't need the actual blocks or entities in the chunk you should
     * consider using
     * {@link #getExistingChunkDataAsynchronously(Vector2i, Vector2i)}
     * 
     * @param min The minimum chunk position for the search
     * @param max The maximum chunk position for the search
     * @return An iterable containing all existing chunks within the given
     *         bounds
     */
    Iterable<Chunk> getExistingChunksAsynchronously(Vector2i min, Vector2i max);

    /**
     * Gets all existing chunks within the given bounds matching the given
     * filter. Due to the asynchronous nature of this method newly generated or
     * deleted chunks may or may not be visible in the iterator, this only
     * applies to chunks that have not been iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * If you don't need the actual blocks or entities in the chunk you should
     * consider using
     * {@link #getExistingChunkDataAsynchronously(Vector2i, Vector2i, Predicate)}
     * 
     * @param min The minimum chunk position for the search
     * @param max The maximum chunk position for the search
     * @param filter The filter used to exclude a chunk from the search
     * @return An iterable containing all existing chunks within the given
     *         bounds matching the given filter
     */
    Iterable<Chunk> getExistingChunksAsynchronously(Vector2i min, Vector2i max, Predicate<Vector2i> filter);

    /**
     * Gets all chunks within the given bounds. Due to the asynchronous nature
     * of this method newly generated or deleted chunks may or may not be
     * visible in the iterator, this only applies to chunks that have not been
     * iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * 
     * @param min The minimum chunk position for the search
     * @param max The maximum chunk position for the search
     * @return An iterable containing all existing chunk data within the given
     *         bounds
     */
    Iterable<ChunkData> getChunkDataAsynchronously(Vector2i min, Vector2i max);

    /**
     * Gets all chunk data within the given bounds matching the given filter.
     * Due to the asynchronous nature of this method newly generated or deleted
     * chunks may or may not be visible in the iterator, this only applies to
     * chunks that have not been iterated at that time.
     * <p>
     * <b>Warning: Long running process.</b> The process may have heavy impact
     * on the IO and may wait for the main/world thread to process the request.
     * </p>
     * 
     * @param min The minimum chunk position for the search
     * @param max The maximum chunk position for the search
     * @param filter The filter used to exclude a chunk from the search
     * @return An iterable containing all existing chunk data within the given
     *         bounds matching the given filter
     */
    Iterable<ChunkData> getChunkDataAsynchronously(Vector2i min, Vector2i max, Predicate<Vector2i> filter);

    /**
     * Get the loaded chunk at the given position.
     *
     * @param position The position in chunk coordinates
     * @return The chunk at the given position or {@link Optional#absent()} if
     *         not found
     */
    Optional<Chunk> getChunk(Vector2i position);

    /**
     * Get the chunk data for the chunk at the given position.
     *
     * @param position The position in chunk coordinates
     * @return The chunk data for the chunk
     */
    ChunkData getChunkData(Vector2i position);

    /**
     * Get the chunk at the given position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param position The position in chunk coordinates
     * @param shouldGenerate True to generate a new chunk if it does not exist
     *            yet
     * @return The loaded or generated chunk at the given position or
     *         {@link Optional#absent()} if not found and not generated
     */
    Optional<Chunk> loadChunk(Vector2i position, boolean shouldGenerate);

    /**
     * Get the chunk at the given position if it exists, generating it if the
     * chunk does not exist.
     *
     * @param position The position in chunk coordinates
     * @return The loaded or generated chunk
     */
    Chunk loadChunk(Vector2i position);

    /**
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existant.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method may return no entity if the entity is not
     * loaded.</p>
     *
     * @param uuid The unique id
     * @return An entity, if available
     */
    Optional<Entity> getEntityFromUUID(UUID uuid);

    /**
     * Gets the world border for the world.
     *
     * @return The world border
     */
    WorldBorder getWorldBorder();

    /**
     * Gets the specified GameRule value.
     **
     * @param gameRule The name of the GameRule.
     * @return The GameRule value, if it exists.
     */
    Optional<String> getGameRule(String gameRule);

    /**
     * Sets the specified GameRule value. If one with this name does not exist,
     * it will be created.
     *
     * @param gameRule The name of the GameRule.
     * @param value The value to set the GameRule to.
     */
    void setGameRule(String gameRule, String value);

    /**
     * Gets a {@link Map} of all GameRules with values in this world.
     **
     * @return A collection of GameRules.
     */
    Map<String, String> getGameRules();

    /**
     * Tries to safely unload the chunk at the given position if it is loaded
     * and then delete it.
     *
     * @param position The position to delete the chunk.
     * @return True, if the chunk has been deleted. False otherwise.
     */
    boolean deleteChunk(Vector2i position);

}
