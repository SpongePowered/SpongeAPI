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
package org.spongepowered.api.world.extent.entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.property.entity.EyeLocationProperty;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.world.extent.EntityHit;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface CollisionAwareEntityVolume extends ReadableEntityVolume {

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
    default Collection<Entity> getNearbyEntities(Vector3d location, double distance) {
        checkNotNull(location, "location");
        checkArgument(distance > 0, "distance must be > 0");
        return this.getIntersectingEntities(new AABB(location.getX() - distance, location.getY() - distance, location.getZ() - distance,
                location.getX() + distance, location.getY() + distance, location.getZ() + distance),
            entity -> entity.getLocation().getPosition().distanceSquared(location) <= distance * distance);
    }


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
     * Gets the bounding box used to select blocks, which appears
     * as a black outline on a vanilla client.
     *
     * @param pos The position of the block from which to get the selection box
     * @return The selection box
     */
    default Optional<AABB> getBlockSelectionBox(Vector3i pos) {
        checkNotNull(pos, "pos");
        return getBlockSelectionBox(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the bounding box used to select blocks, which appears
     * as a black outline on a vanilla client.
     *
     * @param x The x coord of the block from which to get the selection box
     * @param y The y coord of the block from which to get the selection box
     * @param z The z coord of the block from which to get the selection box
     * @return The selection box
     */
    Optional<AABB> getBlockSelectionBox(int x, int y, int z);

    /**
     * Gets all the block collision boxes that intersect the bounding box, in
     * no particular order. There may be more than one box per block.
     *
     * @param box The intersection box
     * @return All the intersecting block collision boxes
     */
    Set<AABB> getIntersectingBlockCollisionBoxes(AABB box);

    /**
     * Gets all the collision boxes that intersect the bounding box owned by
     * the entity, in no particular order. There may be more than one box per
     * block. This also includes entities. Will return an empty set if the
     * owner does not have a bounding box.
     *
     * @param owner The entity that owns the bounding box
     * @return All the intersecting collision boxes
     */
    default Set<AABB> getIntersectingCollisionBoxes(Entity owner) {
        checkNotNull(owner, "owner");
        return owner.getBoundingBox()
            .map(box -> getIntersectingCollisionBoxes(owner, box))
            .orElse(Collections.emptySet());
    }

    /**
     * Gets all the collision boxes that intersect the bounding box owned by
     * the entity, in no particular order. There may be more than one box per
     * block. This also includes entities.
     *
     * @param owner The entity that owns the bounding box
     * @param box The intersection box
     * @return All the intersecting collision boxes
     */
    Set<AABB> getIntersectingCollisionBoxes(Entity owner, AABB box);

}
