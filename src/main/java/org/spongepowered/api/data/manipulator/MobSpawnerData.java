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
import org.spongepowered.api.data.value.CollectionValue;
import org.spongepowered.api.data.value.Value;
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
     * Sets the remaining delay until the next batch of monsters is spawned.
     * Setting this to zero will cause the monsters to be spawned upon the next
     * tick.
     *
     * @return The remaining delay, in ticks
     */
    Value<Short, MobSpawnerData> remainingDelay();

    /**
     * Gets the minimum delay between batches of monsters.
     *
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @return The minimum delay, in ticks
     */
    Value<Short, MobSpawnerData> minimumSpawnDelay();

    /**
     * Gets the maximum delay between batches of monsters.
     *
     * <p> Each time the timer is reset the new delay is chosen randomly from
     * between the minimum (inclusive) and maximum (exclusive) delays. </p>
     *
     * @return The maximum delay, in ticks
     */
    Value<Short, MobSpawnerData> maximumSpawnDelay();

    /**
     * Gets the number of monsters that will attempt to spawn with each batch.
     *
     * <p>The actual number of monsters spawned may be less than the attempted
     * amount if the maximum number of entities allowed in the area is reached.
     * </p>
     *
     * @return The count
     */
    Value<Short, MobSpawnerData> spawnCount();

    /**
     * Gets the maximum amount of entities that may be within the spawn range.
     * This monster spawner will cease spawning new entities if this cap is
     * reached.
     *
     * @return The maximum amount of nearby entities
     */
    Value<Short, MobSpawnerData> maximumNearbyEntities();

    /**
     * Gets the minimum range to the nearest player before this monster spawner
     * will activate.
     *
     * @return The required range
     */
    Value<Short, MobSpawnerData> requiredPlayerRange();

    /**
     * Gets the range within which the monsters from each batch will be spawned.
     *
     * <p> The total region within which the monster may be spawned is defined
     * by a cuboid with dimensions of {@code range*2+1 x 3 x range*2+1} centered
     * around the monster spawner. </p>
     *
     * @return The range
     */
    Value<Short, MobSpawnerData> spawnRange();

    /**
     * Sets the next {@link WeightedEntity} to be spawned.
     *
     * @return The next entity to spawn
     */
    NextEntityToSpawnValue nextEntityToSpawn();

    /**
     * Gets a mutable {@link WeightedCollection} of {@link WeightedEntity} from
     * which the type of each batch of spawned entities will be selected from.
     *
     * @return The possible entities
     */
    PossibleEntitiesToSpawnValue possibleEntitiesToSpawn();

    interface PossibleEntitiesToSpawnValue extends CollectionValue<WeightedEntity, WeightedCollection<WeightedEntity>, PossibleEntitiesToSpawnValue, MobSpawnerData> {

    }

    interface NextEntityToSpawnValue extends Value<WeightedEntity, MobSpawnerData> {

        MobSpawnerData set(EntityType type, @Nullable Collection<DataManipulator<?>> additionalProperties);

    }

}
