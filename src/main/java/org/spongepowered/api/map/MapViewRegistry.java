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

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.UUID;

/**
 * Represents a container for {@link MapView}s. Provides methods to create new
 * {@link MapView}s and to retrieve existing {@link MapView}s without attaching
 * them to a specific {@link ItemStack}.
 */
public interface MapViewRegistry {

    /**
     * Returns a new {@link MapView} that is stored on the disk like a standard
     * map.
     *
     * @param centerPos The world relative x and z center coordinates to use
     *        for the map
     * @return The map view
     */
    MapView createStoredMap(Vector2i centerPos);

    /**
     * Returns an unmodifiable collection of all the {@link MapView}s available
     * the {@link MapView}s themselves are modifiable and are not copies.
     *
     * @return The collection of all the maps available
     */
    ImmutableCollection<MapView> getAllMaps();

    /**
     * Returns a {@link MapView} by it's {@link UUID} this allows easy storage
     * of {@link MapView}s for plugins.
     *
     * @param mapUUID The UUID of the map view
     * @return The {@link MapView} if found or {@link Optional#absent()} if missing
     */
    Optional<MapView> get(UUID mapUUID);

    /**
     * Removes a stored {@link MapView}, this will also delete the file from the
     * disk.
     *
     * @param view The {@link MapView} to delete
     * @return True if the operation was successful, false otherwise
     */
    boolean remove(MapView view);
}
