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

import net.kyori.adventure.bossbar.BossBar;
import org.spongepowered.api.data.type.RaidStatus;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.monster.raider.Raider;
import org.spongepowered.api.world.server.ServerWorld;
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
     * Gets the {@link BossBar} being displayed to clients of this raid.
     *
     * @return The boss bar
     */
    BossBar getBossBar();

    /**
     * Sets the {@link BossBar} being displayed to clients of this raid.
     *
     * @param bossBar The boss bar
     */
    void setBossBar(BossBar bossBar);

    /**
     * Gets the {@link RaidStatus} of this raid.
     *
     * @return The raid status
     */
    RaidStatus getStatus();

    /**
     * Gets the current {@link RaidWave} of this raid.
     *
     * @return The current wave or {@link Optional#empty()} if no waves are currently running
     */
    Optional<RaidWave> getCurrentWave();

    /**
     * Gets all of the {@link RaidWave waves} that have occurred or are occurring in this raid.
     *
     * @return The waves
     */
    List<RaidWave> getWaves();

    /**
     * Gets the amount of {@link RaidWave waves} this raid plans to execute.
     *
     * <p>
     *     In vanilla, a raid determines wave amounts based on difficulty:
     *     <ul>
     *         <li>{@link Difficulties#EASY}: 3</li>
     *         <li>{@link Difficulties#NORMAL}: 5</li>
     *         <li>{@link Difficulties#HARD}: 7</li>
     *     </ul>
     *     Keep in mind that wave amount will be affected by waves added by plugins
     * @return The total wave amount
     */
    int getTotalWaveAmount();

    /**
     * Gets the health of this raid. Health is calculated by the sum of all of the {@link Raider Raider's}
     * {@link Living#health()}. As long as the raider was added to a {@link RaidWave} as part of the health.
     *
     * @return The health
     */
    double getHealth();
}
