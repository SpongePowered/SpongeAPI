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

import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolderBuilder;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.world.LocatableSnapshot;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.schematic.Schematic;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Represents a snapshot of an {@link Entity} and all of it's related data in
 * the form of {@link org.spongepowered.api.data.DataManipulator.Immutable}s and {@link org.spongepowered.api.data.value.Value.Immutable}s.
 * While an {@link Entity} is a live instance and resides in a
 * {@link World}, an {@link EntitySnapshot} may be snapshotted of a
 * {@link World} that is not currently loaded, or may not exist any longer.
 *
 * <p>All data associated with the {@link EntitySnapshot} should be separated
 * from the {@link Game} instance such that external processing, building,
 * and manipulation can take place.</p>
 */
public interface EntitySnapshot extends LocatableSnapshot<EntitySnapshot> {

    /**
     * Creates a new {@link Builder} to build an {@link EntitySnapshot}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets an {@link Optional} containing the {@link UUID} of the
     * {@link Entity} that this {@link EntitySnapshot} is representing. If the
     * {@link Optional} is {@link Optional#empty()}, then this snapshot must
     * have been created by an {@link Builder} without an {@link Entity} as a
     * source.
     *
     * @return The Optional where the UUID may be present
     */
    Optional<UUID> getUniqueId();

    /**
     * Gets the {@link Transform} as an {@link Optional} as the {@link ServerLocation}
     * may be undefined if this {@link EntitySnapshot} was built without a
     * location. This method is linked to {@link #getLocation()} such that if
     * there is a {@link ServerLocation}, there is usually a {@link Transform}.
     *
     * @return The transform, if available
     */
    Optional<Transform> getTransform();

    /**
     * Gets the {@link EntityType}.
     *
     * @return The EntityType
     */
    EntityType<?> getType();

    /**
     * Restores the {@link EntitySnapshot} to the {@link ServerLocation} stored within
     * the snapshot. If the {@link ServerLocation} is not available, the snapshot will
     * not be restored.
     *
     * @return the restored entity if successful
     */
    Optional<Entity> restore();

    /**
     * Creates a new {@link EntityArchetype} for use with {@link Schematic}s and
     * placing the archetype in multiple locations.
     *
     * @return The created archetype for re-creating this entity
     */
    EntityArchetype createArchetype();

    /**
     * An {@link org.spongepowered.api.data.DataHolderBuilder.Immutable} for building {@link EntitySnapshot}s. The
     * requirements
     */
    interface Builder extends DataHolderBuilder.Immutable<EntitySnapshot, Builder> {

        /**
         * Sets the {@link WorldProperties} for this {@link EntitySnapshot}.
         *
         * <p>This is used to grab the {@link UUID} of the World for this
         * snapshot.</p>
         *
         * @param worldProperties The WorldProperties
         * @return This builder, for chaining
         */
        Builder world(WorldProperties worldProperties);

        /**
         * Sets the {@link EntityType} for this {@link EntitySnapshot}.
         *
         * @param entityType The EntityType
         * @return This builder, for chaining
         */
        default Builder type(Supplier<? extends EntityType<?>> entityType) {
            return this.type(entityType.get());
        }

        /**
         * Sets the {@link EntityType} for this {@link EntitySnapshot}.
         *
         * @param entityType The EntityType
         * @return This builder, for chaining
         */
        Builder type(EntityType<?> entityType);

        /**
         * Sets the coordinates of this {@link EntitySnapshot} from a
         * {@link Vector3i}.
         *
         * @param position The Vector3i representing the coordinates
         * @return This builder, for chaining
         */
        Builder position(Vector3d position);

        /**
         * Copies over data from an {@link Entity}.
         *
         * @param entity The Entity
         * @return This builder, for chaining
         */
        Builder from(Entity entity);

    }

}
