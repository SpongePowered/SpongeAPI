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

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.biome.BiomeManager;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.weather.WeatherVolume;

import java.util.Map;
import java.util.UUID;

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
     * Get the loaded chunk at the given position.
     *
     * @param position The position
     * @return The chunk, if available
     */
    Optional<Chunk> getChunk(Vector3i position);

    /**
     * Get the chunk at the given position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param position The position
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    Optional<Chunk> loadChunk(Vector3i position, boolean shouldGenerate);

    /**
     * Deletes the given chunk from the world. Returns a {@code boolean}
     * flag for whether the operation was successful.
     * 
     * @param chunk The chunk to delete
     * @return Whether the operation was successful
     */
    boolean deleteChunk(Chunk chunk);

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
     * Sets the specified GameRule value. If one with this name
     * does not exist, it will be created.
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
     * Returns the {@link Environment} of this world.
     *
     * @return The {@link Environment}
     */
    Environment getEnvironment();

    /**
     * Gets the random seed for this world.
     * 
     * @return The seed
     */
    long getWorldSeed();
    
    /**
     * Sets the random seed for this world.
     * 
     * @param seed The seed
     */
    void setSeed(long seed);

    /**
     * Gets the {@link WorldGenerator} for this world.
     * 
     * @return The world generator
     */
    WorldGenerator getWorldGenerator();
    
    /**
     * Sets the {@link WorldGenerator} for this world to use to create new
     * chunks.
     * 
     * @param generator The new generator
     */
    void setWorldGenerator(WorldGenerator generator);

    /**
     * Gets the {@link BiomeManager} for this world.
     * 
     * @return The biome manager
     */
    BiomeManager getBiomeManager();

}
