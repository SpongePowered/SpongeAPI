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
package org.spongepowered.api.world.volume.entity;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityPredicates;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.world.volume.ImmutableVolume;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.BlockVolumeFactory;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface EntityVolume extends Volume {

    /**
     * Gets a {@link List} of available {@link Player players} within this volume.
     * The provided list may be a copy or an unmodifiable collection.
     *
     * @return An unmodifiable or copied collection of available players
     */
    Collection<? extends Player> players();

    /**
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existent.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method may return no entity if the entity is not
     * loaded.</p>
     *
     * @param uuid The unique id
     * @return An entity, if available
     */
    Optional<Entity> entity(UUID uuid);

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order.
     *
     * @param box The intersection box
     * @return All the intersecting entities
     */
    default Collection<? extends Entity> entities(AABB box) {
        Objects.requireNonNull(box);

        return this.entities(box, entity -> true);
    }

    <T extends Entity> Collection<? extends T> entities(Class<? extends T> entityClass, AABB box, @Nullable Predicate<? super T> predicate);

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order, as long as the pass the given filter test.
     *
     * @param box The intersection box
     * @param filter The filter test
     * @return All the intersecting entities that pass the filter test
     */
    Collection<? extends Entity> entities(AABB box, Predicate<? super Entity> filter);

    default <T extends Entity> Collection<? extends T> entities(Class<? extends T> entityClass, AABB box) {
        return this.entities(entityClass, box, EntityPredicates.NO_SPECTATOR);
    }

    default Optional<? extends Player> nearestPlayer(double x, double y, double z, double distance, @Nullable Predicate<? super Entity> predicate) {
        Player nearest = null;
        double closest = -1.0D;
        for (Player player : this.players()) {
            if (predicate == null || predicate.test(player)) {
                final double dist = player.position().distanceSquared(x, y, z);
                if ((closest < 0 || dist < distance * distance) && (closest == -1 || dist < distance)) {
                    nearest = player;
                    closest = dist;
                }
            }
        }
        return Optional.ofNullable(nearest);
    }

    /**
     * Return a collection of entities contained within {@code distance} blocks
     * of the specified location. This uses a sphere to test distances.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @param location The location at the center of the search radius
     * @param distance The search radius
     * @return A collection of nearby entities
     */
    default Collection<? extends Entity> nearbyEntities(Vector3d location, double distance) {
        Objects.requireNonNull(location);
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be a positive number!");
        }

        return this.entities(AABB.of(location.x() - distance, location.y() - distance, location.z() - distance,
                location.x() + distance, location.y() + distance, location.z() + distance),
            entity -> entity.location().position().distanceSquared(location) <= distance * distance);
    }

    interface Streamable<E extends Streamable<E>> extends EntityVolume {

        /**
         * Gets a {@link VolumeStream}&lt;{@code B, }{@link Entity}&gt;
         * from this volume such that the {@code min} and {@code max} are contained
         * within this volume.
         *
         * @param min The minimum coordinate set
         * @param max The maximum coordinate set
         * @param options The options to construct the stream
         * @return The volume stream
         */
        VolumeStream<E, Entity> entityStream(Vector3i min, Vector3i max, StreamOptions options);

    }

    interface Modifiable<M extends Modifiable<M>> extends Streamable<M>, MutableVolume, BlockVolume.Modifiable<M> {

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *      valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        <E extends Entity> E createEntity(EntityType<E> type, Vector3d position) throws IllegalArgumentException, IllegalStateException;

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type supplier
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *      valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntity(Supplier<EntityType<E>> type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
            return this.createEntity(type.get(), position);
        }

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *      valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntity(EntityType<E> type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
            Objects.requireNonNull(position, "position");
            return this.createEntity(type, position.toDouble());
        }

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type supplier
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *      valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntity(Supplier<EntityType<E>> type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
            return this.createEntity(type.get(), position);
        }

        /**
         * Create an entity instance at the given position with the default
         * equipment.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *     valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        <E extends Entity> E createEntityNaturally(EntityType<E> type, Vector3d position) throws IllegalArgumentException, IllegalStateException;

        /**
         * Create an entity instance at the given position with the default
         * equipment.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type supplier
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *     valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntityNaturally(Supplier<EntityType<E>> type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
            return this.createEntityNaturally(type.get(), position);
        }

        /**
         * Create an entity instance at the given position with the default
         * equipment.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *     valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntityNaturally(EntityType<E> type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
            Objects.requireNonNull(position, "position");
            return this.createEntityNaturally(type, position.toDouble());
        }

        /**
         * Create an entity instance at the given position with the default
         * equipment.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param type The type supplier
         * @param position The position
         * @return An entity, if one was created
         * @throws IllegalArgumentException If the position or entity type is not
         *     valid to create
         * @throws IllegalStateException If a constructor cannot be found
         */
        default <E extends Entity> E createEntityNaturally(Supplier<EntityType<E>> type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
            return this.createEntityNaturally(type.get(), position);
        }

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param entityContainer The data container of the entity
         * @return An entity, if one was created
         */
        Optional<Entity> createEntity(DataContainer entityContainer);

        /**
         * Create an entity instance at the given position.
         *
         * <p>Creating an entity does not spawn the entity into the world. An entity
         * created means the entity can be spawned at the given location. If
         * {@link Optional#empty()} was returned, the entity is not able to spawn at
         * the given location. Furthermore, this allows for the {@link Entity} to be
         * customized further prior to traditional "ticking" and processing by core
         * systems.</p>
         *
         * @param entityContainer The data container of the entity
         * @param position The position of the entity to spawn at
         * @return An entity, if one was created
         */
        Optional<Entity> createEntity(DataContainer entityContainer, Vector3d position);

        /**
         * Spawns an {@link Entity} using the already set properties (extent,
         * position, rotation) and applicable {@link Value}s for spawning
         * the entity.
         *
         * <p>The requirements involve that all necessary setup of states and data
         * is already preformed on the entity retrieved from the various
         * {@link #createEntity(EntityType,Vector3d)} methods. Calling this will
         * make the now-spawned entity able to be processed by various systems.</p>
         *
         * <p>If the entity was unable to spawn, the entity is not removed, but it
         * should be taken note that there can be many reasons for a failure.</p>
         *
         * @param entity The entity to spawn
         * @return True if successful, false if not
         */
        boolean spawnEntity(Entity entity);

        /**
         * Similar to {@link #spawnEntity(Entity)} except where multiple entities
         * can be attempted to be spawned.
         *
         * @param entities The created entities you wish to spawn
         * @return The entities which spawned correctly, or empty if none
         */
        Collection<Entity> spawnEntities(Iterable<? extends Entity> entities);

    }

    interface Mutable extends Modifiable<Mutable> {

        static EntityVolume.Mutable empty(Vector3i min, Vector3i max) {
            return Sponge.game().factoryProvider().provide(EntityVolumeFactory.class).empty(min, max);
        }

    }

    interface EntityVolumeFactory {

        EntityVolume.Mutable empty(Vector3i min, Vector3i max);

    }

    interface Immutable extends Unmodifiable<Immutable>, ImmutableVolume {

    }

    interface Unmodifiable<U extends Unmodifiable<U>> extends EntityVolume, Streamable<U>,
        UnmodifiableVolume, BlockVolume.Unmodifiable<U> {

    }
}
