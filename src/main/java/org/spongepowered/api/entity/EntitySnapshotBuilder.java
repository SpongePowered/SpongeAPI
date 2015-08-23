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
import org.spongepowered.api.data.ImmutableDataBuilder;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.UUID;

/**
 * An {@link ImmutableDataBuilder} for building {@link EntitySnapshot}s. The
 * requirements
 */
public interface EntitySnapshotBuilder extends ImmutableDataBuilder<EntitySnapshot, EntitySnapshotBuilder> {

    /**
     * Sets the {@link WorldProperties} for this {@link EntitySnapshot}.
     *
     * <p>
     *     This is used to grab the {@link UUID} of the World for this snapshot.
     * </p>
     *
     * @param worldProperties The WorldProperties
     * @return This builder, for chaining
     */
    EntitySnapshotBuilder world(WorldProperties worldProperties);

    /**
     * Sets the {@link EntityType} for this {@link EntitySnapshot}.
     *
     * @param entityType The EntityType
     * @return This builder, for chaining
     */
    EntitySnapshotBuilder type(EntityType entityType);

    /**
     * Sets the coordinates of this {@link EntitySnapshot} from a {@link Vector3i}.
     *
     * @param position The Vector3i representing the coordinates
     * @return This builder, for chaining
     */
    EntitySnapshotBuilder position(Vector3i position);

    /**
     * Copies over data from an {@link Entity}.
     *
     * @param entity The Entity
     * @return This builder, for chaining
     */
    EntitySnapshotBuilder from(Entity entity);
}
