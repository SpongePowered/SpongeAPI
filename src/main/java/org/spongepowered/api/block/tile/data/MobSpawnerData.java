/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.block.tile.data;

import com.google.common.base.Optional;
import org.spongepowered.api.block.tile.MobSpawner;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.service.persistence.data.DataContainer;
import org.spongepowered.api.util.WeightedRandomEntity;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * Represents the data associated with a mob spawner, including the spawn
 * delay, the spawn count, and the list of possible entities that can be
 * spawned.
 */
public interface MobSpawnerData extends TileEntityData<MobSpawner, MobSpawnerData> {

    /**
     * Gets the remaining delay until the next batch of monsters is spawned.
     *
     * @return The remaining delay, in ticks
     */
    short getRemainingDelay();

    /**
     * Sets the remaining delay until the next batch of monsters is spawned.
     * Setting this to zero will cause the monsters to be spawned upon the next
     * tick.
     *
     * @param delay The new delay, in ticks
     */
    void setRemainingDelay(short delay);

    /**
     * Gets the minimum delay between batches of monsters.
     * <p>
     * Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays.
     * </p>
     *
     * @return The minimum delay, in ticks
     */
    short getMinimumSpawnDelay();

    /**
     * Gets the minimum delay between batches of monsters.
     * <p>
     * Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays.
     * </p>
     *
     * @param delay The new minimum delay, in ticks
     */
    void setMinimumSpawnDelay(short delay);

    /**
     * Gets the maximum delay between batches of monsters.
     * <p>
     * Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays.
     * </p>
     *
     * @return The maximum delay, in ticks
     */
    short getMaximumSpawnDelay();

    /**
     * Gets the maximum delay between batches of monsters.
     * <p>
     * Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays.
     * </p>
     *
     * @param delay The new maximum delay, in ticks
     */
    void setMaximumSpawnDelay(short delay);

    /**
     * Gets the number of monsters that will attempt to spawn with each batch.
     *
     * <p>The actual number of monsters spawned may be less than the attempted
     * amount if the maximum number of entities allowed in the area is reached.
     * </p>
     *
     * @return The count
     */
    short getSpawnCount();

    /**
     * Sets the number of monsters that will attempt to spawn in each batch.
     *
     * <p>The actual number of monsters spawned may be less than the attempted
     * amount if the maximum number of entities allowed in the area is reached.
     * </p>
     *
     * @param count The new count
     */
    void setSpawnCount(short count);

    /**
     * Gets the maximum amount of entities that may be within the spawn range.
     * This monster spawner will cease spawning new entities if this cap is
     * reached.
     *
     * @return The maximum amount of nearby entities
     */
    short getMaximumNearbyEntities();

    /**
     * Sets the maximum amount of entities that may be within the spawn range.
     * This monster spawner will cease spawning new entities if this cap is
     * reached.
     *
     * @param count The new maximum amount of nearby entities
     */
    void setMaximumNearbyEntities(short count);

    /**
     * Gets the minimum range to the nearest player before this monster spawner
     * will activate.
     *
     * @return The required range
     */
    short getRequiredPlayerRange();

    /**
     * Sets the minimum range to the nearest player before this monster spawner
     * will activate.
     *
     * @param range The new required range
     */
    void setRequiredPlayerRange(short range);

    /**
     * Gets the range within which the monsters from each batch will be spawned.
     * <p>
     * The total region within which the monster may be spawned is defined by a
     * cuboid with dimensions of {@code range*2+1 x 3 x range*2+1} centered
     * around the monster spawner.
     * </p>
     *
     * @return The range
     */
    short getSpawnRange();

    /**
     * Sets the range within which the monsters from each batch will be spawned.
     * <p>
     * The total region within which the monster may be spawned is defined by a
     * cuboid with dimensions of {@code range*2+1 x 3 x range*2+1} centered
     * around the monster spawner.
     * </p>
     *
     * @param range The new range
     */
    void setSpawnRange(short range);

    /**
     * Sets the next entity type and properties to be spawned.
     *
     * @param type The entity type
     * @param additionalProperties Additional properties to apply to the entity, may be null
     */
    void setNextEntityToSpawn(EntityType type, @Nullable DataContainer additionalProperties);

    /**
     * Sets the next {@link WeightedRandomEntity} to be spawned.
     *
     * @param entity The random entity entry
     */
    void setNextEntityToSpawn(WeightedRandomEntity entity);

    /**
     * Gets the collection of {@link WeightedRandomEntity} from which the type
     * of each batch of spawned entities will be selected from.
     *
     * @return The possible entities
     */
    Collection<WeightedRandomEntity> getPossibleEntitiesToSpawn();

    /**
     * Creates a {@link WeightedRandomEntity} with the given properties and
     * returns the {@link WeightedRandomEntity} if validation passed.
     *
     * <p>If there is invalid data, either the entity type, the weight, or
     * the additional properties are not valid to apply to the entity, the
     * {@link WeightedRandomEntity} is not created.</p>
     *
     * @param entityType The entity type
     * @param weight The weight of the priority to spawn the entity
     * @param additionalProperties Any additional properties customizing the
     *     entity
     * @return The weighted entity if it was created
     */
    Optional<WeightedRandomEntity> addWeightedEntity(EntityType entityType, int weight, @Nullable DataContainer additionalProperties);

    /**
     * Removes the given {@link WeightedRandomEntity} from the possible
     * entities to spawn by the mob spawner.
     *
     * @param weightedEntity The weighted entity to remove
     */
    void removeWeightedEntity(WeightedRandomEntity weightedEntity);

    /**
     * Defines a number of {@link WeightedRandomEntity}s from which the type of
     * each batch will be randomly selected based on the weighting value.
     *
     * @param entities The possible entities
     */
    void setPossibleEntitiesToSpawn(WeightedRandomEntity... entities);

    /**
     * Defines a number of {@link WeightedRandomEntity}s from which the type of
     * each batch will be randomly selected based on the weighting value.
     *
     * @param entities The possible entities
     */
    void setPossibleEntitiesToSpawn(Collection<WeightedRandomEntity> entities);


}
