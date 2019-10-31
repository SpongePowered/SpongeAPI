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

import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;
import java.util.UUID;

/**
 * A type of {@link org.spongepowered.api.data.DataHolder.Immutable} that may be linked to a particular
 * {@link Location}. Being that a {@link LocatableSnapshot} may be built
 * by an {@link org.spongepowered.api.data.DataHolderBuilder.Immutable}, the {@link Location} may be
 * <code>null</code> such that {@link #getLocation()} returns
 * {@link Optional#empty()}.
 *
 * @param <T> The type of location snapshot for self referencing
 */
public interface LocatableSnapshot<T extends LocatableSnapshot<T>> extends SerializableDataHolder.Immutable<T> {

    /**
     * Gets the {@link UUID} of the world.
     *
     * @return The world unique Id
     */
    UUID getWorldUniqueId();

    /**
     * Gets the saved block position.
     *
     * @return The saved block position
     */
    Vector3i getPosition();

    /**
     * Gets the {@link Location} of the snapshot at which it may have been
     * taken from. The {@link Location} being immutable signifies that the
     * {@link LocatableSnapshot} can be re-created at the desired
     * {@link Location}.
     *
     * @return The location of where the snapshot was taken, if available
     */
    Optional<Location> getLocation();

    /**
     * Creates a copy of the snapshot with the provided
     * {@link Location}.
     *
     * @param location The location
     * @return The new snapshot
     */
    T withLocation(Location location);
}
