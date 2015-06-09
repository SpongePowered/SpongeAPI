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
package org.spongepowered.api.world.gen.populator;

import org.spongepowered.api.data.manipulator.mutable.MobSpawnerData;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedEntity;
import org.spongepowered.api.util.weighted.WeightedItem;
import org.spongepowered.api.world.gen.Populator;

import java.util.Collection;

/**
 * Represents a which places 'Dungeon's randomly underground. Each dungeon has
 * some associated MobSpawnerData, and data regarding the contents of any chests
 * generated within the dungeon.
 */
public interface Dungeon extends Populator {

    /**
     * Gets the number of attempts at randomly spawning a generator per chunk.
     * 
     * @return The number of attempts
     */
    int getAttemptsPerChunk();

    /**
     * Sets the number of attempts at randomly spawning a generator per chunk.
     * The default is 8.
     * 
     * @param attempts The new number of attempts
     */
    void setAttemptsPerChunk(int attempts);

    /**
     * Gets the {@link MobSpawnerData} which represents the MobSpawner which
     * will be created within the dungeon.
     * 
     * @return The mob spawner data
     */
    MobSpawnerData getSpawnerData();

    /**
     * Gets a mutable List of possible contents of the chests. Items will be
     * randomly selected from this list based on weight in order to calculate
     * the contents of chests placed within the dungeon.
     * 
     * @return The contents list
     */
    WeightedCollection<WeightedItem> getPossibleContents();

    /**
     * Gets the number of items which will spawn per chest.
     * 
     * @return The number of items
     */
    int itemCount();

    /**
     * Sets the number of items which will spawn per chest.
     * 
     * @param count The new item count
     */
    void setItemCount(int count);

    /**
     * A builder for constructing {@link Dungeon} populators.
     */
    interface Builder {

        /**
         * Sets the number of attempts at randomly spawning a generator per
         * chunk. The default is 8.
         * 
         * @param attempts The new number of attempts
         * @return This builder, for chaining
         */
        Builder attempts(int attempts);

        /**
         * Sets the {@link MobSpawnerData} which represents the MobSpawner which
         * will be created within the dungeon. Setting this directly will
         * overwrite the related builder methods.
         * 
         * @param data The mob spawner data to use
         * @return This builder, for chaining
         */
        Builder mobSpawnerData(MobSpawnerData data);

        /**
         * Sets the minimum delay between batches of monsters. <p> Each time the
         * timer is reset the new delay is chosen randomly from between the
         * minimum (inclusive) and maximum (exclusive) delays. </p>
         *
         * @param delay The new minimum delay, in ticks
         * @return This builder, for chaining
         */
        Builder minimumSpawnDelay(short delay);

        /**
         * Sets the maximum delay between batches of monsters. <p> Each time the
         * timer is reset the new delay is chosen randomly from between the
         * minimum (inclusive) and maximum (exclusive) delays. </p>
         *
         * @param delay The new maximum delay, in ticks
         * @return This builder, for chaining
         */
        Builder maximumSpawnDelay(short delay);

        /**
         * Sets the number of monsters that will attempt to spawn in each batch.
         *
         * <p>The actual number of monsters spawned may be less than the
         * attempted amount if the maximum number of entities allowed in the
         * area is reached. </p>
         *
         * @param count The new count
         * @return This builder, for chaining
         */
        Builder spawnCount(short count);

        /**
         * Sets the maximum amount of entities that may be within the spawn
         * range. This monster spawner will cease spawning new entities if this
         * cap is reached.
         *
         * @param count The new maximum amount of nearby entities
         * @return This builder, for chaining
         */
        Builder maximumNearbyEntities(short count);

        /**
         * Sets the minimum range to the nearest player before this monster
         * spawner will activate.
         *
         * @param range The new required range
         * @return This builder, for chaining
         */
        Builder requiredPlayerRange(short range);

        /**
         * Sets the range within which the monsters from each batch will be
         * spawned. <p> The total region within which the monster may be spawned
         * is defined by a cuboid with dimensions of
         * {@code range*2+1 x 3 x range*2+1} centered around the monster
         * spawner. </p>
         *
         * @param range The new range
         * @return This builder, for chaining
         */
        Builder spawnRange(short range);

        /**
         * Defines a number of {@link WeightedEntity}s from which the type
         * of each batch will be randomly selected based on the weighting value.
         *
         * @param entities The possible entities
         * @return This builder, for chaining
         */
        Builder possibleEntities(WeightedEntity... entities);

        /**
         * Defines a number of {@link WeightedEntity}s from which the type
         * of each batch will be randomly selected based on the weighting value.
         *
         * @param entities The possible entities
         * @return This builder, for chaining
         */
        Builder possibleEntities(Collection<WeightedEntity> entities);

        /**
         * Defines a number of {@link WeightedItem}s from which items
         * will be randomly selected based on weight in order to calculate the
         * contents of chests placed within the dungeon.
         *
         * @param items The possible items
         * @return This builder, for chaining
         */
        Builder possibleItems(WeightedItem... items);

        /**
         * Defines a number of {@link WeightedItem}s from which items
         * will be randomly selected based on weight in order to calculate the
         * contents of chests placed within the dungeon.
         *
         * @param items The possible items
         * @return This builder, for chaining
         */
        Builder possibleItems(Collection<WeightedItem> items);

        /**
         * Sets the number of items which will spawn per chest.
         * 
         * @param count The new item count
         * @return This builder, for chaining
         */
        Builder itemsQuantity(int count);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Dungeon} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Dungeon build() throws IllegalStateException;

    }
}
