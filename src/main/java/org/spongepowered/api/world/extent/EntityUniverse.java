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

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.property.entity.EyeLocationProperty;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.AABB;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * A container of {@link Entity} instances.
 */
public interface EntityUniverse {

    /**
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existant.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method may return no entity if the entity is not
     * loaded.</p>
     *
     * @param uuid The unique id
     * @return An entity, if available
     */
    Optional<Entity> getEntity(UUID uuid);

    /**
     * Return a collection of entities contained within this universe, possibly
     * only returning entities only in loaded areas.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @return A collection of entities
     */
    Collection<Entity> getEntities();

    /**
     * Return a collection of entities contained within this universe, possibly
     * only returning entities only in loaded areas. The returned entities are
     * filtered by the given {@link Predicate} before being returned.
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
    Entity createEntity(EntityType type, Vector3d position) throws IllegalArgumentException, IllegalStateException;

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
    default Entity createEntity(EntityType type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
        checkNotNull(position, "position");
        return createEntity(type, position.toDouble());
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
    Entity createEntityNaturally(EntityType type, Vector3d position) throws IllegalArgumentException, IllegalStateException;

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
    default Entity createEntityNaturally(EntityType type, Vector3i position) throws IllegalArgumentException, IllegalStateException {
        checkNotNull(position, "position");
        return createEntityNaturally(type, position.toDouble());
    }

    /**
     * Creates and restores an {@link Entity} from the provided
     * {@link EntitySnapshot} at the provided {@link Vector3d} position.
     *
     * <p>Creating an entity does not spawn the entity into the world. An entity
     * created means the entity can be spawned at the given location. If
     * {@link Optional#empty()} was returned, the entity is not able to spawn at
     * the given location. Furthermore, this allows for the {@link Entity} to be
     * customized further prior to traditional "ticking" and processing by core
     * systems.</p>
     *
     * @param snapshot The entity snapshot of the entity
     * @param position The position of the entity to spawn at
     * @return An entity, if one was created
     */
    Optional<Entity> restoreSnapshot(EntitySnapshot snapshot, Vector3d position);

    /**
     * Spawns an {@link Entity} using the already set properties (extent,
     * position, rotation) and applicable {@link DataManipulator}s for spawning
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
     * @param entities The entities to be spawned
     * @return True if any of the entities were successfully spawned
     */
    boolean spawnEntities(Iterable<? extends Entity> entities);

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order.
     *
     * @param box The intersection box
     * @return All the intersecting entities
     */
    default Set<Entity> getIntersectingEntities(AABB box) {
        return getIntersectingEntities(box, entity -> true);
    }

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order, as long as the pass the given filter test.
     *
     * @param box The intersection box
     * @param filter The filter test
     * @return All the intersecting entities that pass the filter test
     */
    Set<Entity> getIntersectingEntities(AABB box, Predicate<Entity> filter);

    /**
     * Gets all the entities that intersect the ray (by their bounding box)
     * The ray is defined by its start and end point.
     *
     * @param start The start of the ray
     * @param end The end of the ray
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    default Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d end) {
        return getIntersectingEntities(start, end, hit -> true);
    }

    /**
     * Gets all the entities that intersect the ray (by their bounding box)
     * The ray is defined by its start and end point. Only the entities that
     * pass the filter test are added.
     *
     * @param start The start of the ray
     * @param end The end of the ray
     * @param filter The filter test
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d end, Predicate<EntityHit> filter);

    /**
     * Gets all the entities that are in the line of sight of the given entity,
     * up to a given distance. This ignores occluders like blocks or other
     * entities. That is to say, the returned entities might not actually be
     * visible.
     *
     * @param looker The looking entity
     * @param distance The distance of the ray (from the start)
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    default Set<EntityHit> getIntersectingEntities(Entity looker, double distance) {
        return getIntersectingEntities(looker, distance, hit -> true);
    }

    /**
     * Gets all the entities that are in the line of sight of the given entity,
     * up to a given distance. This ignores occluders like blocks or other
     * entities. That is to say, the returned entities might not actually be
     * visible. Only the entities that pass the filter test are added.
     *
     * @param looker The looking entity
     * @param distance The distance of the ray (from the start)
     * @param filter The filter test
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    default Set<EntityHit> getIntersectingEntities(Entity looker, double distance, Predicate<EntityHit> filter) {
        checkNotNull(looker, "looker");
        final Vector3d rotation = looker.getRotation();
        final Vector3d direction = Quaterniond.fromAxesAnglesDeg(rotation.getX(), -rotation.getY(), rotation.getZ()).getDirection();
        final Optional<EyeLocationProperty> data = looker.getProperty(EyeLocationProperty.class);
        final Vector3d start = data.map(EyeLocationProperty::getValue).orElse(looker.getLocation().getPosition());
        return getIntersectingEntities(start, direction, distance, filter);
    }

    /**
     * Gets all the entities that intersect the ray (by their bounding box)
     * The ray is defined by its start, direction and distance.
     *
     * @param start The start of the ray
     * @param direction The direction of the ray
     * @param distance The distance of the ray (from the start)
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    default Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d direction, double distance) {
        return getIntersectingEntities(start, direction, distance, hit -> true);
    }

    /**
     * Gets all the entities that intersect the ray (by their bounding box)
     * The ray is defined by its start, direction and distance. Only the
     * entities that pass the filter test are added.
     *
     * @param start The start of the ray
     * @param direction The direction of the ray
     * @param distance The distance of the ray (from the start)
     * @param filter The filter test
     * @return The intersecting entities in no particular order, with the
     *      associated intersection point and normal
     */
    Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d direction, double distance, Predicate<EntityHit> filter);

    /**
     * The result of an intersection between a ray and an entity.
     */
    class EntityHit {

        private final Entity entity;
        private final Vector3d intersection;
        private final Vector3d normal;
        private final double distance;

        /**
         * Creates a new entity hit from the entity, the intersection point and
         * the normal.
         *
         * @param entity The intersected entity
         * @param intersection The intersection point
         * @param normal The intersection normal
         * @param distance The distance from the start to the intersection
         */
        public EntityHit(Entity entity, Vector3d intersection, Vector3d normal, double distance) {
            this.entity = checkNotNull(entity, "entity");
            this.intersection = checkNotNull(intersection, "intersection");
            this.normal = checkNotNull(normal, "normal");
            this.distance = distance;
        }

        /**
         * Gets the intersected entity.
         *
         * @return The intersected entity
         */
        public Entity getEntity() {
            return this.entity;
        }

        /**
         * Gets the intersection point.
         *
         * @return The point of intersection
         */
        public Vector3d getIntersection() {
            return this.intersection;
        }

        /**
         * Gets the intersection normal.
         *
         * @return The normal of intersection
         */
        public Vector3d getNormal() {
            return this.normal;
        }

        /**
         * Gets the distance from the start to the intersection.
         *
         * @return The distance from the start to the intersection
         */
        public double getDistance() {
            return this.distance;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EntityHit)) {
                return false;
            }
            final EntityHit entityHit = (EntityHit) other;
            return this.entity.equals(entityHit.entity) && this.intersection.equals(entityHit.intersection) && this.normal.equals(entityHit.normal)
                    && this.distance == entityHit.distance;

        }

        @Override
        public int hashCode() {
            int result = this.entity.hashCode();
            result = 31 * result + this.intersection.hashCode();
            result = 31 * result + this.normal.hashCode();
            result = 31 * result + Double.hashCode(this.distance);
            return result;
        }

        @Override
        public String toString() {
            return "EntityHit(" + this.entity + " at " + this.intersection + " on " + this.normal + ")";
        }

    }

}
