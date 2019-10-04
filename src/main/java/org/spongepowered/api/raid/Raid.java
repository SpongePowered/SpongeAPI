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
package org.spongepowered.api.raid;

import org.spongepowered.api.boss.ServerBossBar;
import org.spongepowered.api.data.type.RaidStatus;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.monster.raider.Raider;
import org.spongepowered.api.server.ServerWorld;
import org.spongepowered.api.world.difficulty.Difficulties;

import java.util.List;
import java.util.Optional;

public interface Raid {

    /**
     * Gets the {@link ServerWorld} this raid is taking place in.
     *
     * @return The world
     */
    ServerWorld getWorld();

    /**
     * Gets the {@link ServerBossBar} being displayed to clients of this raid.
     *
     * @return The boss bar
     */
    ServerBossBar getBossBar();

    /**
     * Sets the {@link ServerBossBar} being displayed to clients of this raid.
     *
     * @param bossBar The boss bar
     */
    void setBossBar(ServerBossBar bossBar);

    /**
     * Gets the {@link RaidStatus} of this raid.
     *
     * @return The raid status
     */
    RaidStatus getStatus();

    /**
     * Gets the current {@link Wave} of this raid.
     *
     * @return The current wave or {@link Optional#empty()} if no waves are currently running
     */
    Optional<Wave> getCurrentWave();

    /**
     * Gets all of the {@link Wave waves} that have occurred or are occurring in this raid.
     *
     * @return The waves
     */
    List<Wave> getWaves();

    /**
     * Gets the amount of {@link Wave waves} this raid plans to execute.
     *
     * <p>
     *     In vanilla, a raid determines wave amounts based on difficulty:
     *     <p><u1>
     *         <i1>{@link Difficulties#EASY}: 3</i1>
     *         <i1>{@link Difficulties#NORMAL}: 5</i1>
     *         <i1>{@link Difficulties#HARD}: 7</i1>
     *     </u1><p>
     *
     *     Keep in mind that wave amount will be affected by waves added by plugins
     * </p>
     * @return The total wave amount
     */
    int getTotalWaveAmount();

    /**
     * Gets the health of this raid. Health is calculated by the sum of all of the {@link Raider Raider's} {@link Living#health()}
     * @return
     */
    double getHealth();
}
