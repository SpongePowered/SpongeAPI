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
package org.spongepowered.api.data.manipulator;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedEntity;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * Represents the data associated with a mob spawner, including the spawn delay,
 * the spawn count, and the list of possible entities that can be spawned.
 */
public interface MobSpawnerData extends DataManipulator<MobSpawnerData> {

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
     * @return This instance, for chaining
     */
    MobSpawnerData setRemainingDelay(short delay);

    /**
     * Gets the minimum delay between batches of monsters.
     * 
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @return The minimum delay, in ticks
     */
    short getMinimumSpawnDelay();

    /**
     * Sets the minimum delay between batches of monsters.
     * 
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @param delay The new minimum delay, in ticks
     * @return This instance, for chaining
     */
    MobSpawnerData setMinimumSpawnDelay(short delay);

    /**
     * Gets the maximum delay between batches of monsters.
     * 
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @return The maximum delay, in ticks
     */
    short getMaximumSpawnDelay();

    /**
     * Sets the maximum delay between batches of monsters.
     * 
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @param delay The new maximum delay, in ticks
     * @return This instance, for chaining
     */
    MobSpawnerData setMaximumSpawnDelay(short delay);

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
     * @return This instance, for chaining
     */
    MobSpawnerData setSpawnCount(short count);

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
     * @return This instance, for chaining
     */
    MobSpawnerData setMaximumNearbyEntities(short count);

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
     * @return This instance, for chaining
     */
    MobSpawnerData setRequiredPlayerRange(short range);

    /**
     * Gets the range within which the monsters from each batch will be spawned.
     * 
     * <p> The total region within which the monster may be spawned is defined
     * by a cuboid with dimensions of {@code range*2+1 x 3 x range*2+1} centered
     * around the monster spawner. </p>
     *
     * @return The range
     */
    short getSpawnRange();

    /**
     * Sets the range within which the monsters from each batch will be spawned.
     * 
     * <p> The total region within which the monster may be spawned is defined
     * by a cuboid with dimensions of {@code range*2+1 x 3 x range*2+1} centered
     * around the monster spawner. </p>
     *
     * @param range The new range
     * @return This instance, for chaining
     */
    MobSpawnerData setSpawnRange(short range);

    /**
     * Sets the next entity type and properties to be spawned.
     *
     * @param type The entity type
     * @param additionalProperties Additional properties to apply to the entity,
     *        may be null
     * @return This instance, for chaining
     */
    MobSpawnerData setNextEntityToSpawn(EntityType type, @Nullable Collection<DataManipulator<?>> additionalProperties);

    /**
     * Sets the next {@link WeightedEntity} to be spawned.
     *
     * @param entity The random entity entry
     * @return This instance, for chaining
     */
    MobSpawnerData setNextEntityToSpawn(WeightedEntity entity);

    /**
     * Gets a mutable {@link WeightedCollection} of {@link WeightedEntity} from
     * which the type of each batch of spawned entities will be selected from.
     *
     * @return The possible entities
     */
    WeightedCollection<WeightedEntity> getPossibleEntitiesToSpawn();

}
