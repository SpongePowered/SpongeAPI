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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnCause;
import org.spongepowered.api.event.target.entity.SpawnEntityEvent;

import java.util.Collection;

/**
 * A container of {@link Entity} instances.
 */
public interface EntityUniverse {

    /**
     * Return a collection of entities contained within this universe,
     * possibly only returning entities only in loaded areas.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @return A collection of entities
     */
    Collection<Entity> getEntities();

    /**
     * Return a collection of entities contained within this universe,
     * possibly only returning entities only in loaded areas. The returned
     * entities are filtered by the given {@link Predicate} before being
     * returned.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @param filter The filter to apply to the returned entities
     * @return A collection of filtered entities
     */
    Collection<Entity> getEntities(Predicate<Entity> filter);

    /**
     * Create an entity instance at the given position.
     *
     * <p>Creating an entity does not spawn the entity into the world. An entity
     * created means the entity can be spawned at the given location. If
     * {@link Optional#absent()} was returned, the entity is not able to spawn
     * at the given location. Furthermore, this allows for the {@link Entity} to
     * be customized further prior to traditional "ticking" and processing by
     * core systems.</p>
     *
     * @param type The type
     * @param position The position
     * @return An entity, if one was created
     */
    Optional<Entity> createEntity(EntityType type, Vector3d position);

    /**
     * Create an entity instance at the given position.
     *
     * <p>Creating an entity does not spawn the entity into the world. An entity
     * created means the entity can be spawned at the given location. If
     * {@link Optional#absent()} was returned, the entity is not able to spawn
     * at the given location. Furthermore, this allows for the {@link Entity} to
     * be customized further prior to traditional "ticking" and processing by
     * core systems.</p>
     *
     * @param type The type
     * @param position The position
     * @return An entity, if one was created
     */
    Optional<Entity> createEntity(EntityType type, Vector3i position);

    /**
     * Create an entity instance at the given position.
     *
     * <p>Creating an entity does not spawn the entity into the world. An entity
     * created means the entity can be spawned at the given location. If
     * {@link Optional#absent()} was returned, the entity is not able to spawn
     * at the given location. Furthermore, this allows for the {@link Entity} to
     * be customized further prior to traditional "ticking" and processing by
     * core systems.</p>
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
     * {@link Optional#absent()} was returned, the entity is not able to spawn
     * at the given location. Furthermore, this allows for the {@link Entity} to
     * be customized further prior to traditional "ticking" and processing by
     * core systems.</p>
     *
     * @param entityContainer The data container of the entity
     * @param position The position of the entity to spawn at
     * @return An entity, if one was created
     */
    Optional<Entity> createEntity(DataContainer entityContainer, Vector3d position);

    /**
     * Spawns an {@link Entity} using the already set properties (extent,
     * position, rotation) and applicable {@link DataManipulator}s with the
     * specified {@link Cause} for spawning the entity.
     *
     * <p>Note that for the
     * {@link Cause} to be useful in the expected {@link SpawnEntityEvent},
     * a {@link SpawnCause} should be provided in the {@link Cause} for other
     * plugins to understand and have finer control over the event.</p>
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
     * @param cause The cause for the entity spawn
     * @return True if successful, false if not
     */
    boolean spawnEntity(Entity entity, Cause cause);
}
