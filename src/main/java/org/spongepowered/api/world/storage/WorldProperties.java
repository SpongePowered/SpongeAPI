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

import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.gamerule.GameRuleHolder;
import org.spongepowered.api.world.weather.WeatherUniverse;
import org.spongepowered.math.vector.Vector3i;

/**
 * Represents the properties of a {@link World} which are persisted across runtime instances.
 */
public interface WorldProperties extends WeatherUniverse, GameRuleHolder {

    /**
     * Gets the default spawn position.
     *
     * @return The spawn position
     */
    Vector3i getSpawnPosition();

    /**
     * Sets the default spawn position.
     *
     * @param position The spawn position
     */
    void setSpawnPosition(Vector3i position);

    /**
     * Gets the {@link MinecraftDayTime} since the world was created.
     *
     * @return The total time
     */
    MinecraftDayTime getGameTime();

    /**
     * Gets the time of day.
     *
     * @return The time of day
     */
    MinecraftDayTime getDayTime();

    /**
     * Gets the {@link DimensionType}.
     *
     * @return The dimension type
     */
    DimensionType getDimensionType();

    /**
     * Gets the default {@link GameMode}.
     *
     * @return The game mode
     */
    GameMode getGameMode();

    /**
     * Gets if this is in hardcore mode.
     *
     * @return Is hardcore
     */
    boolean isHardcore();

    /**
     * Gets the {@link Difficulty}.
     *
     * @return The difficulty
     */
    Difficulty getDifficulty();
}
