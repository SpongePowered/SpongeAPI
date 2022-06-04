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
package org.spongepowered.api.world.storage;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.border.WorldBorder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gamerule.GameRuleHolder;
import org.spongepowered.api.world.weather.WeatherUniverse;
import org.spongepowered.math.vector.Vector3i;

/**
 * Represents the properties of a {@link World} which are persisted across runtime instances.
 */
public interface WorldProperties extends WeatherUniverse, GameRuleHolder, DataHolder.Mutable {

    /**
     * Gets the default spawn position.
     *
     * @return The spawn position
     */
    default Vector3i spawnPosition() {
        return this.require(Keys.SPAWN_POSITION);
    }

    /**
     * Sets the default spawn position.
     *
     * @param position The spawn position
     */
    default void setSpawnPosition(Vector3i position) {
        this.offer(Keys.SPAWN_POSITION, position);
    }

    /**
     * Gets the {@link MinecraftDayTime} since the world was created.
     *
     * @return The total time
     */
    MinecraftDayTime gameTime(); // TODO data?

    /**
     * Gets the time of day.
     *
     * @return The time of day
     */
    MinecraftDayTime dayTime(); // TODO data?

    /**
     * Gets if this is in hardcore mode.
     *
     * @return Is hardcore
     */
    default boolean hardcore() {
        return this.require(Keys.HARDCORE);
    }

    /**
     * Gets the {@link Difficulty}.
     *
     * @return The difficulty
     */
    default Difficulty difficulty() {
        return this.require(Keys.WORLD_DIFFICULTY).get(Sponge.game());
    }

    /**
     * Gets the saved {@link WorldBorder} for this world.
     *
     * @return The world border
     */
    WorldBorder worldBorder(); // TODO data?

}
