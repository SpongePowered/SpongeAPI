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
package org.spongepowered.api.util.provider;

import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.statistic.*;
import org.spongepowered.api.text.format.TextColor;

import java.util.Collection;

public interface StatisticProvider extends Provider {
    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link EntityType}. If the statistic group is not a valid
     * {@link EntityStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param entityType The entity type for the statistic to return
     * @return The entity statistic or Optional.absent() if not found
     */
    Optional<EntityStatistic> getEntityStatistic(StatisticGroup statisticGroup, EntityType entityType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link ItemType}. If the statistic group is not a valid
     * {@link ItemStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param itemType The item type for the statistic to return
     * @return The item statistic or Optional.absent() if not found
     */
    Optional<ItemStatistic> getItemStatistic(StatisticGroup statisticGroup, ItemType itemType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link BlockType}. If the statistic group is not a valid
     * {@link BlockStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param blockType The block type for the statistic to return
     * @return The block statistic or Optional.absent() if not found
     */
    Optional<BlockStatistic> getBlockStatistic(StatisticGroup statisticGroup, BlockType blockType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * team's {@link TextColor}. If the {@link StatisticGroup} is not a valid
     * {@link TeamStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param teamColor The team's color for the statistic to return
     * @return The team statistic or Optional.absent() if not found
     */
    Optional<TeamStatistic> getTeamStatistic(StatisticGroup statisticGroup, TextColor teamColor);

    /**
     * Gets a list of all available {@link Statistic}s which belong to the given
     * {@link StatisticGroup}.
     *
     * @param statisticGroup The statisticType to return
     * @return An immutable collection containing all statistics in the group
     */
    Collection<Statistic> getStatistics(StatisticGroup statisticGroup);

    /**
     * Registers a custom statistic.
     *
     * @param stat The custom statistic
     */
    void registerStatistic(Statistic stat);
}
