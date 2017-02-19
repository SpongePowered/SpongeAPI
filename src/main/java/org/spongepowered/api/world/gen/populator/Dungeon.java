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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.mutable.MobSpawnerData;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.weighted.LootTable;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.gen.Populator;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a {@link Populator} which places 'Dungeon's randomly underground. Each dungeon has
 * some associated MobSpawnerData, and data regarding the contents of any chests
 * generated within the dungeon.
 */
public interface Dungeon extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Dungeon} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of attempts at randomly spawning a generator per chunk.
     * 
     * @return The number of attempts
     */
    VariableAmount getAttemptsPerChunk();

    /**
     * Sets the number of attempts at randomly spawning a generator per chunk.
     * 
     * @param attempts The new number of attempts
     */
    void setAttemptsPerChunk(VariableAmount attempts);

    /**
     * Sets the number of attempts at randomly spawning a generator per chunk.
     * 
     * @param attempts The new number of attempts
     */
    default void setAttemptsPerChunk(int attempts) {
        setAttemptsPerChunk(VariableAmount.fixed(attempts));
    }

    /**
     * <p>Gets the {@link MobSpawnerData} which represents the MobSpawner which
     * will be created within the dungeon.</p>
     *
     * <p><b>Note: </b> Only one of choices or mob spawner data
     * will be present.</p>
     *
     * @return The mob spawner data, if present
     */
    Optional<MobSpawnerData> getMobSpawnerData();

    /**
     * <p>Sets {@link MobSpawnerData} which will be used to create the spawner
     * within the dungeon.</p>
     *
     * <p><b>Note: </b> Only one of choices or mob spawner data
     * will be present.</p>
     * @param data MobSpawnerData to use
     */
    void setMobSpawnerData(MobSpawnerData data);

    /**
     * <p>Gets a weighted collection of possible
     * {@link EntityArchetype}s that could be spawned. One type is chosen when
     * creating the dungeon, for more complex spawners see
     * {@link #getMobSpawnerData()}.</p>
     *
     * <p><b>Note: </b> Only one of choices or mob spawner data
     * will be present.</p>
     *
     * @return Weighted table of possible types, if present
     */
    Optional<WeightedTable<EntityArchetype>> getChoices();

    /**
     * <p>Sets the possible {@link EntityArchetype}s that could be spawned.
     * One type is chosen when creating the dungeon, for more complex
     * spawners see {@link #setMobSpawnerData(MobSpawnerData)}</p>
     *
     * <p><b>Note: </b> Only one of choices or mob spawner data
     * will be present.</p>
     *
     * @param choices Weighted table of possible types
     */
    void setChoices(WeightedTable<EntityArchetype> choices);

    /**
     * Gets a mutable weighted collection of possible contents of the chests.
     * Items will be randomly selected from this list based on weight in order
     * to calculate the contents of chests placed within the dungeon.
     * 
     * @return The contents list
     */
    LootTable<ItemStackSnapshot> getPossibleContents();

    /**
     * A builder for constructing {@link Dungeon} populators.
     */
    interface Builder extends ResettableBuilder<Dungeon, Builder> {

        /**
         * Sets the number of attempts at randomly spawning a generator per
         * chunk.
         * 
         * @param attempts The new number of attempts
         * @return This builder, for chaining
         */
        Builder attempts(VariableAmount attempts);

        /**
         * Sets the number of attempts at randomly spawning a generator per
         * chunk.
         * 
         * @param attempts The new number of attempts
         * @return This builder, for chaining
         */
        default Builder attempts(int attempts) {
            return attempts(VariableAmount.fixed(attempts));
        }

        /**
         * <p>Sets {@link MobSpawnerData} that will be used to create the spawner
         * within the dungeon.</p>
         *
         * <p><b>Note: </b> Only one of choices or mob spawner data
         * will be present.</p>
         * @param data MobSpawnerData to use
         * @return This builder, for chaining
         */
        Builder mobSpawnerData(MobSpawnerData data);

        /**
         * <p>Sets the possible {@link EntityArchetype}s that could be spawned.
         * One type is chosen when creating the dungeon, for more complex
         * spawners see {@link #mobSpawnerData(MobSpawnerData)}}</p>
         *
         * <p>To use the default set of choices, pass <code>null</code> instead
         * of a table.</p>
         *
         * <p><b>Note: </b> Only one of choices or mob spawner data
         * will be present.</p>
         *
         * @param choices Weighted table of possible types
         * @return This builder, for chaining
         */
        Builder choices(@Nullable WeightedTable<EntityArchetype> choices);

        /**
         * Defines a {@link LootTable} of {@link ItemStackSnapshot}s from which
         * items will be randomly selected based on weight in order to calculate
         * the contents of chests placed within the dungeon.
         *
         * @param items The possible items
         * @return This builder, for chaining
         */
        Builder possibleItems(LootTable<ItemStackSnapshot> items);

        /**
         * Builds a new instance of a {@link Dungeon} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Dungeon build() throws IllegalStateException;

    }
}
