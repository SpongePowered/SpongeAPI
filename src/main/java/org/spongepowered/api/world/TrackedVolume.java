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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.world.extent.block.ReadableBlockVolume;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

public interface TrackedVolume extends ReadableBlockVolume {

    /**
     * Gets the {@link UUID}, if available, of the user who created the
     * {@link BlockSnapshot} at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getCreator(Vector3i pos) {
        return getCreator(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the {@link UUID}, if available, of the user who created the
     * {@link BlockSnapshot} at passed block position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The {@link UUID} if one exists
     */
    Optional<UUID> getCreator(int x, int y, int z);

    /**
     * Gets the {@link UUID}, if available, of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getNotifier(Vector3i pos) {
        return getNotifier(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the {@link UUID}, if available, of the user who last notified the
     * {@link BlockSnapshot} located at passed block coordinates.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The {@link UUID} if available
     */
    Optional<UUID> getNotifier(int x, int y, int z);

    /**
     * Sets the {@link UUID} of the user who created the {@link BlockSnapshot}
     * located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as creator
     */
    default void setCreator(Vector3i pos, @Nullable UUID uuid) {
        setCreator(pos.getX(), pos.getY(), pos.getZ(), uuid);
    }

    /**
     * Sets the {@link UUID} of the user who created the {@link BlockSnapshot}
     * located at passed block coordinates.
     *
     * @param x The x coordinate where the user data should be applied
     * @param y The y coordinate where the user data should be applied
     * @param z The z coordinate where the user data should be applied
     * @param uuid The {@link UUID} to set as creator
     */
    void setCreator(int x, int y, int z, @Nullable UUID uuid);

    /**
     * Sets the {@link UUID} of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as notifier
     */
    default void setNotifier(Vector3i pos, @Nullable UUID uuid) {
        setNotifier(pos.getX(), pos.getY(), pos.getZ(), uuid);
    }

    /**
     * Sets the {@link UUID} of the user who last notified the
     * {@link BlockSnapshot} located at passed block coordinates.
     *
     * @param x The x coordinate where the user data should be applied
     * @param y The y coordinate where the user data should be applied
     * @param z The z coordinate where the user data should be applied
     * @param uuid The {@link UUID} to set as notifier
     */
    void setNotifier(int x, int y, int z, @Nullable UUID uuid);

}
