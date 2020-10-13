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
package org.spongepowered.api.world.volume.game;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;
import java.util.UUID;

public interface TrackedVolume extends ReadableBlockVolume, LocationBaseDataHolder.Mutable {

    /**
     * Gets the {@link UUID}, if available, of the user who created the
     * {@link BlockSnapshot} at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getCreator(final Vector3i pos) {
        return this.getCreator(pos.getX(), pos.getY(), pos.getZ());
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
    default Optional<UUID> getCreator(final int x, final int y, final int z) {
        return this.get(x, y, z, Keys.CREATOR);
    }

    /**
     * Gets the {@link UUID}, if available, of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getNotifier(final Vector3i pos) {
        return this.getNotifier(pos.getX(), pos.getY(), pos.getZ());
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
    default Optional<UUID> getNotifier(final int x, final int y, final int z) {
        return this.get(x, y, z, Keys.NOTIFIER);
    }

    /**
     * Sets the {@link UUID} of the user who created the {@link BlockSnapshot}
     * located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as creator
     */
    default void setCreator(final Vector3i pos, @Nullable final UUID uuid) {
        this.setCreator(pos.getX(), pos.getY(), pos.getZ(), uuid);
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
    default void setCreator(final int x, final int y, final int z, @Nullable final UUID uuid) {
        if (uuid == null) {
            this.remove(x, y, z, Keys.CREATOR);
        } else {
            this.offer(x, y, z, Keys.CREATOR, uuid);
        }
    }

    /**
     * Sets the {@link UUID} of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as notifier
     */
    default void setNotifier(final Vector3i pos, @Nullable final UUID uuid) {
        this.setNotifier(pos.getX(), pos.getY(), pos.getZ(), uuid);
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
    default void setNotifier(final int x, final int y, final int z, @Nullable final UUID uuid) {
        if (uuid == null) {
            this.remove(x, y, z, Keys.NOTIFIER);
        } else {
            this.offer(x, y, z, Keys.NOTIFIER, uuid);
        }
    }
}
