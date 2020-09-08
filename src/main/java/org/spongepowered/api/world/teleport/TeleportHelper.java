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
package org.spongepowered.api.world.teleport;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;
import org.spongepowered.api.world.teleport.TeleportHelperFilters;

import java.util.Optional;

/**
 * Finds safe {@link ServerLocation}s for {@link Entity}s (typically ones that won't
 * hurt them).
 *
 * <p>Typically, the teleport helper will first determine whether the requested
 * location is a safe one. If not, it will investigate locations close by,
 * favouring spots closer, and favouring a location above or below over the
 * x-z plane if two locations are equidistant.</p>
 */
public interface TeleportHelper {

    /** The default height radius to scan for safe locations. */
    int DEFAULT_HEIGHT = 3;

    /** The default width radius to scan for safe locations. */
    int DEFAULT_WIDTH = 9;

    /**
     * The default distance to check for a suitable floor below any candidate
     * location.
     */
    int DEFAULT_FLOOR_CHECK_DISTANCE = 2;

    /**
     * Gets the next safe {@link ServerLocation} around the given location.
     *
     * <p>Safe entails that the returned location will not be somewhere that
     * would harm an {@link Entity}. This method will use the default height and
     * width for a search area, and will check for a suitable floor up to two
     * blocks below any selected block.</p>
     *
     * <p>It's possible the same location will be returned that was passed in.
     * This means it was safe.</p>
     *
     * @param location The location to search nearby.
     * @return A safe location near the original location or the original
     *         location if it is deemed safe. If no safe location can be found,
     *         {@link Optional#empty()} will be returned.
     */
    default Optional<ServerLocation> getSafeLocation(ServerLocation location) {
        return getSafeLocation(location, DEFAULT_HEIGHT, DEFAULT_WIDTH, DEFAULT_FLOOR_CHECK_DISTANCE, TeleportHelperFilters.DEFAULT.get());
    }

    /**
     * Gets the next safe {@link ServerLocation} around the given location with a
     * given tolerance and search radius.
     *
     * <p>Safe entails that the returned location will not be somewhere that
     * would harm an {@link Entity}.</p>
     *
     * <p>It's possible the same location will be returned that was passed in.
     * This means it was safe.</p>
     *
     * <p>This method will check for a suitable floor up to two blocks below
     * any selected block.</p>
     *
     * <p>This method will use the default {@link TeleportHelperFilter}</p>
     *
     * @param location The location to search nearby.
     * @param height The radius of blocks on the y-axis to search.
     * @param width The radius of blocks on the x and z-axis to search.
     * @return A safe location near the original location or the original
     *         location if it is deemed safe. If no safe location can be found,
     *         {@link Optional#empty()} will be returned
     */
    default Optional<ServerLocation> getSafeLocation(ServerLocation location, int height, int width) {
        return getSafeLocation(location, height, width, DEFAULT_FLOOR_CHECK_DISTANCE, TeleportHelperFilters.DEFAULT.get());
    }

    /**
     * Gets the next safe {@link ServerLocation} around the given location with a
     * given tolerance and search radius.
     *
     * <p>Safe entails that the returned location will not be somewhere that
     * would harm an {@link Entity}.</p>
     *
     * <p>It's possible the same location will be returned that was passed in.
     * This means it was safe.</p>
     *
     * <p>This method will use the default {@link TeleportHelperFilter} and will
     * respect the blacklist.</p>
     *
     * @param location The location to search nearby.
     * @param height The radius of blocks on the y-axis to search.
     * @param width The radius of blocks on the x and z-axis to search.
     * @param floorDistance The number of blocks below a selected block to
     *                      search for a suitable floor, that is, the
     *                      maximum distance to a floor that the selected
     *                      point can be. If this is zero or negative, a floor
     *                      check will not be performed.
     * @return A safe location near the original location or the original
     *         location if it is deemed safe. If no safe location can be found,
     *         {@link Optional#empty()} will be returned
     */
    default Optional<ServerLocation> getSafeLocation(ServerLocation location, int height, int width, int floorDistance) {
        return getSafeLocation(location, height, width, floorDistance, TeleportHelperFilters.DEFAULT.get(), TeleportHelperFilters.CONFIG.get());
    }

    /**
     * Gets the next safe {@link ServerLocation} around the given location with a
     * given tolerance and search radius.
     *
     * <p>Safe entails that the returned location will not be somewhere that
     * would harm an {@link Entity}.</p>
     *
     * <p>It's possible the same location will be returned that was passed in.
     * This means it was safe.</p>
     *
     * @param location The location to search nearby.
     * @param height The radius of blocks on the y-axis to search.
     * @param width The radius of blocks on the x and z-axis to search.
     * @param floorDistance The number of blocks below a selected block to
     *                      search for a suitable floor, that is, the
     *                      maximum distance to a floor that the selected
     *                      point can be. If this is zero or negative, a floor
     *                      check will not be performed.
     * @param filter The {@link TeleportHelperFilter} to use to determine if a
     *               location is safe.
     * @param additionalFilters Additional {@link TeleportHelperFilter}s to
     *                          check. All filters must match for a location to
     *                          be marked as safe.
     * @return A safe location near the original location or the original
     *         location if it is deemed safe. If no safe location can be found,
     *         {@link Optional#empty()} will be returned
     */
    Optional<ServerLocation> getSafeLocation(ServerLocation location, int height, int width, int floorDistance, TeleportHelperFilter filter,
        TeleportHelperFilter... additionalFilters);

    /**
     * Gets the next safe {@link ServerLocation} around the given location with a
     * given tolerance and search radius.
     *
     * <p>Safe entails that the returned location will not be somewhere that
     * would harm an {@link Entity}.</p>
     *
     * <p>It's possible the same location will be returned that was passed in.
     * This means it was safe.</p>
     *
     * <p>This method will use the defined blacklist, effectively an equivalent
     * to adding {@link TeleportHelperFilters#CONFIG} to the filter set.</p>
     *
     * @param location The location to search nearby.
     * @param height The radius of blocks on the y-axis to search.
     * @param width The radius of blocks on the x and z-axis to search.
     * @param floorDistance The number of blocks below a selected block to
     *                      search for a suitable floor, that is, the
     *                      maximum distance to a floor that the selected
     *                      point can be. If this is zero or negative, a floor
     *                      check will not be performed.
     * @param filters The {@link TeleportHelperFilter}s to check, in addition
     *                to {@link TeleportHelperFilters#CONFIG}. All filters must
     *                match for a location to be marked as safe.
     * @return A safe location near the original location or the original
     *         location if it is deemed safe. If no safe location can be found,
     *         {@link Optional#empty()} will be returned
     */
    default Optional<ServerLocation> getSafeLocationWithBlacklist(ServerLocation location, int height, int width, int floorDistance,
            TeleportHelperFilter... filters) {
        return getSafeLocation(location, height, width, floorDistance, TeleportHelperFilters.CONFIG.get(), filters);
    }

}
