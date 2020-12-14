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

import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public interface MutableEntityVolume<M extends MutableEntityVolume<M>> extends StreamableEntityVolume<M>, MutableVolume, MutableBlockVolume<M> {

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
