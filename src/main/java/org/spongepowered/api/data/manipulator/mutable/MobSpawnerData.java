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
package org.spongepowered.api.data.manipulator.mutable;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMobSpawnerData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.data.value.mutable.WeightedCollectionValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

/**
 * Represents the data associated with a mob spawner, including the spawn delay,
 * the spawn count, and the list of possible entities that can be spawned.
 */
public interface MobSpawnerData extends DataManipulator<MobSpawnerData, ImmutableMobSpawnerData> {

    /**
     * Gets the {@link MutableBoundedValue} for the remaining delay before
     * a new attempt at spawning an {@link Entity} is made.
     *
     * @return The immutable bounded value for the remaining delay
     * @see Keys#SPAWNER_REMAINING_DELAY
     */
    MutableBoundedValue<Short> remainingDelay();

    /**
     * Gets the {@link MutableBoundedValue} for the minimum spawn delay
     * required between attempts to spawn an {@link Entity}.
     *
     * @return The bounded value of the minimum spawn delay
     * @see Keys#SPAWNER_MINIMUM_DELAY
     */
    MutableBoundedValue<Short> minimumSpawnDelay();

    /**
     * Gets the {@link MutableBoundedValue} for the maximum spawn delay
     * required between attempts to spawn an {@link Entity}.
     *
     * @return The bounded value of the maximum spawn delay
     * @see Keys#SPAWNER_MAXIMUM_DELAY
     */
    MutableBoundedValue<Short> maximumSpawnDelay();

    /**
     * Gets the {@link MutableBoundedValue} for the count of successful
     * spawns of all {@link Entity} instances from the owning spawner. This
     * count is simply a total count, there is no limitation on how many
     * attempts are made to spawn an {@link Entity}.
     *
     * @return The immutable bounded value
     * @see Keys#SPAWNER_SPAWN_COUNT
     */
    MutableBoundedValue<Short> spawnCount();

    /**
     * Gets the {@link MutableBoundedValue} for the limitation on the number
     * of nearby {@link Entity} instances can exist near the owning spawner. The
     * limitation is that if there are more {@link Entity} instances than the
     * provided value, no attempts to spawn a new {@link Entity} will be made.
     *
     * @return The bounded value of the maximum supported nearby entities
     * @see Keys#SPAWNER_MAXIMUM_NEARBY_ENTITIES
     */
    MutableBoundedValue<Short> maximumNearbyEntities();

    /**
     * Gets the {@link MutableBoundedValue} for the minimum range a
     * {@link Player} must remain in proximity of the spawner, such that if a
     * {@link Player} is NOT within the provided range, no attempts to spawn an
     * {@link Entity} is made.
     *
     * @return The value of the required player range to spawn entities
     * @see Keys#SPAWNER_REQUIRED_PLAYER_RANGE
     */
    MutableBoundedValue<Short> requiredPlayerRange();

    /**
     * Gets the {@link MutableBoundedValue} for the maximum range that an
     * {@link Entity} can be spawned from the spawner.
     *
     * @return The immutable value of the maximum spawn range an entity can be
     *     spawned
     * @see Keys#SPAWNER_SPAWN_RANGE
     */
    MutableBoundedValue<Short> spawnRange();

    /**
     * Gets the {@link NextEntityToSpawnValue} for the overridden
     * {@link WeightedSerializableObject}{@code <EntitySnapshot>} to spawn
     * next. If possible, the next entity to spawn may be chosen from the
     * already provided {@link #possibleEntitiesToSpawn()}.
     *
     * @return The next possible entity to spawn
     * @see Keys#SPAWNER_NEXT_ENTITY_TO_SPAWN
     */
    NextEntityToSpawnValue nextEntityToSpawn();

    /**
     * Gets the {@link WeightedCollectionValue} of all possible
     * {@link Entity} instances that can be spawned by the spawner. As they
     * are all {@link WeightedSerializableObject}{@code <EntitySnapshot>}
     * instances, their weight is defined as a {@link Random} to determine
     * the next {@link Entity} that will be spawned, unless overriden by
     * {@link #nextEntityToSpawn()}.
     *
     * @return The immutable weighted entity collection value of entities
     * @see Keys#SPAWNER_ENTITIES
     */
    WeightedCollectionValue<EntitySnapshot> possibleEntitiesToSpawn();

    /**
     * Represents a custom {@link Value} dealing with the next
     * {@link WeightedSerializableObject}{@code <EntitySnapshot>} such that
     * the next {@link Entity} to spawn may be pulled from the owning
     * {@link #possibleEntitiesToSpawn()} with a default {@link Random},
     * or it may be custom defined on a case by case basis.
     */
    interface NextEntityToSpawnValue extends Value<WeightedSerializableObject<EntitySnapshot>> {

        /**
         * Sets this value with the provided {@link EntityType} and
         * {@link Collection} of {@link DataManipulator}s.
         *
         * @param type The type of {@link Entity}
         * @param additionalProperties Any additional properties to spawn the
         *     {@link Entity} with
         * @return The new value, for chaining
         */
        NextEntityToSpawnValue set(EntityType type, @Nullable Collection<DataManipulator<?, ?>> additionalProperties);

        @Override
        ImmutableMobSpawnerData.ImmutableNextEntityToSpawnValue asImmutable();
    }

}
