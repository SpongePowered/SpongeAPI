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
package org.spongepowered.api.entity;

import com.google.common.base.Optional;
import org.spongepowered.api.Game;
import org.spongepowered.api.data.LocateableSnapshot;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.UUID;

/**
 * Represents a snapshot of an {@link Entity} and all of it's related data in
 * the form of {@link ImmutableDataManipulator}s and {@link ImmutableValue}s.
 * While an {@link Entity} is a live instance and therefor residing in a
 * {@link World}, an {@link EntitySnapshot} may be snapshotted of a
 * {@link World} that is not currently loaded, or may not exist any longer.
 *
 * <p>All data associated with the {@link EntitySnapshot} should be separated
 * from the {@link Game} instance such that external processing, building,
 * and manipulation can take place.</p>
 */
public interface EntitySnapshot extends LocateableSnapshot<EntitySnapshot> {

    /**
     * Gets an {@link Optional} containing the {@link UUID} of the
     * {@link Entity} that this {@link EntitySnapshot} is representing. If the
     * {@link Optional} is {@link Optional#absent()}, then this snapshot must
     * have been created by an {@link EntitySnapshotBuilder} without an
     * {@link Entity} as a source.
     *
     * @return The Optional where the UUID may be present
     */
    Optional<UUID> getUniqueId();

    /**
     * Gets the {@link Transform} as an {@link Optional} as the
     * {@link Location} may be undefined if this {@link EntitySnapshot} was
     * built without a location. This method is linked to {@link #getLocation()}
     * such that if there is a {@link Location}, there is usually a
     * {@link Transform}.
     *
     * @return The transform, if available
     */
    Optional<Transform<World>> getTransform();

    /**
     * Gets the {@link EntityType}.
     *
     * @return The EntityType
     */
    EntityType getType();

}
