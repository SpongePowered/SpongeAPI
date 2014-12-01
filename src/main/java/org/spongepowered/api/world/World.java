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

import com.google.common.base.Optional;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.math.Vector2i;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.weather.WeatherVolume;

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
     * <p>If the chunk has not been loaded at the given position, then
     * {@code null} will be returned.</p>
     *
     * @param position The position
     * @return The chunk, if available
     */
    Optional<Chunk> getChunk(Vector2i position);

    /**
     * Get the chunk at the given position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param position The position
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    Optional<Chunk> loadChunk(Vector2i position, boolean shouldGenerate);

    /**
     * Get the chunk at the given position if it exists, generating it
     * if the chunk does not exist.
     *
     * @param position The position
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

}
