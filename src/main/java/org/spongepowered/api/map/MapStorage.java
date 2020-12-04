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
package org.spongepowered.api.map;

import org.spongepowered.api.map.MapInfo;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the storage manager for the maps of the {@link org.spongepowered.api.Server}
 *
 * This allows you to get {@link MapInfo}s and create them.
 */
public interface MapStorage {

	/**
	 * Get all {@link MapInfo}s that exist
	 * on this server.
	 * @return Set of MapInfos
	 */
	Collection<MapInfo> getAllMapInfos();

	/**
	 * Gets a MapInfo by its UUID.
	 * @param uuid UUID of map to get
	 * @return The map with given uuid, or empty if it doesn't exist.
	 */
	Optional<MapInfo> getMapInfo(final UUID uuid);

	/**
	 * Creates a new {@link MapInfo}.
	 *
	 * <p>The {@link MapInfo} will </p>
	 *
	 * <p>The MapInfo will not be successfully created if
	 * the fired {@link org.spongepowered.api.event.action.CreateMapEvent} is cancelled.
	 * This can happen due to either a plugin cancelling it, or
	 * running out of room for maps.
	 * (Max amount of maps is {@value java.lang.Integer#MAX_VALUE})</p>
	 *
	 * @return {@link MapInfo} the new MapInfo if available
	 */
	Optional<MapInfo> createNewMapInfo();
}
