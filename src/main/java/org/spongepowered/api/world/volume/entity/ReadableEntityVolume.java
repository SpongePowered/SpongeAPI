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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityPredicates;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

public interface ReadableEntityVolume extends Volume {

    @Override
    ReadableEntityVolume getView(Vector3i newMin, Vector3i newMax);

    UnmodifiableEntityVolume<?> asUnmodifiableEntityVolume();

    ImmutableEntityVolume asImmutableEntityVolume();

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
    Optional<Entity> getEntity(UUID uuid);

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order.
     *
     * @param box The intersection box
     * @return All the intersecting entities
     */
    default Collection<? extends Entity> getEntities(AABB box) {
        return getEntities(box, entity -> true);
    }


    /**
     * Gets a {@link List} of available {@link Player players} within this volume.
     * The provided list may be a copy or an unmodifiable collection.
     *
     * @return An unmodifiable or copied collection of available players
     */
    Collection<? extends Player> getPlayers();

    /**
     * Gets all the entities that intersect the bounding box, in no particular
     * order, as long as the pass the given filter test.
     *
     * @param box The intersection box
     * @param filter The filter test
     * @return All the intersecting entities that pass the filter test
     */
    Collection<? extends Entity> getEntities(AABB box, Predicate<? super Entity> filter);

    default <T extends Entity> Collection<? extends T> getEntities(Class<? extends T> entityClass, AABB box) {
        return getEntities(entityClass, box, EntityPredicates.NO_SPECTATOR);
    }

    <T extends Entity> Collection<? extends T> getEntities(Class<? extends T> entityClass, AABB box, @Nullable Predicate<? super T> predicate);

    default <T extends Entity> Collection<? extends T> getLoadedEntities(Class<? extends T> entityClass, AABB box) {
        return getLoadedEntities(entityClass, box,  EntityPredicates.NO_SPECTATOR);
    }

    default <T extends Entity> Collection<? extends T> getLoadedEntities(Class<? extends T> entityClass, AABB box, @Nullable Predicate<? super T> predicate) {
        return getEntities(entityClass, box, predicate);
    }

    default Optional<? extends Player> getNearestPlayer(double x, double y, double z, double distance, @Nullable Predicate<? super Entity> predicate) {
        Player nearest = null;
        double closest = -1.0D;
        for (Player player : this.getPlayers()) {
            if (predicate == null || predicate.test(player)) {
                final double dist = player.getPosition().distanceSquared(x, y, z);
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
    default Collection<? extends Entity> getNearbyEntities(Vector3d location, double distance) {
        checkNotNull(location, "location");
        checkArgument(distance > 0, "distance must be > 0");
        return this.getEntities(new AABB(location.getX() - distance, location.getY() - distance, location.getZ() - distance,
                location.getX() + distance, location.getY() + distance, location.getZ() + distance),
            entity -> entity.getLocation().getPosition().distanceSquared(location) <= distance * distance);
    }

}
