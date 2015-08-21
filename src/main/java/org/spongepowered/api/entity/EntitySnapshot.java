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

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import org.spongepowered.api.data.ImmutableDataHolder;
import org.spongepowered.api.world.World;

import java.util.UUID;

public interface EntitySnapshot extends ImmutableDataHolder<EntitySnapshot> {

    /**
     * Gets the {@link UUID} of a {@link World} where this snapshot was created from.
     *
     * @return The World UUID
     */
    UUID getWorldUniqueId();

    /**
     * Gets an {@link Optional} containing the {@link UUID}.
     *
     * <p>
     *     A value of {@link Optional#absent()} means the UUID cannot be found. This means
     *     this snapshot was made from {@link EntitySnapshotBuilder} without an {@link Entity}
     *     as a source.
     * </p>
     *
     * @return The Optional where the UUID may be present
     */
    Optional<UUID> getUniqueId();

    /**
     * Gets the {@link EntityType}.
     *
     * @return The EntityType
     */
    EntityType getType();

    /**
     * Gets the position from which the {@link Entity} was at when snapshot (as {@link Vector3i}).
     *
     * @return The coordinates as a Vector3i
     */
    Vector3i getPosition();


}
