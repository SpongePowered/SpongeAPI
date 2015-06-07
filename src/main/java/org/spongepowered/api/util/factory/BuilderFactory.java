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
package org.spongepowered.api.util.factory;

import com.google.common.base.Optional;
import org.spongepowered.api.attribute.AttributeBuilder;
import org.spongepowered.api.attribute.AttributeCalculator;
import org.spongepowered.api.attribute.AttributeModifierBuilder;
import org.spongepowered.api.effect.particle.ParticleEffectBuilder;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.item.FireworkEffectBuilder;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.item.merchant.TradeOfferBuilder;
import org.spongepowered.api.potion.PotionEffectBuilder;
import org.spongepowered.api.scoreboard.ScoreboardBuilder;
import org.spongepowered.api.scoreboard.TeamBuilder;
import org.spongepowered.api.scoreboard.objective.ObjectiveBuilder;
import org.spongepowered.api.statistic.*;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.statistic.achievement.AchievementBuilder;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldBuilder;
import org.spongepowered.api.world.WorldCreationSettings;

public interface BuilderFactory extends Factory {
    /**
     * Gets a builder of the desired class type, examples may include:
     * {@link org.spongepowered.api.attribute.AttributeBuilder},
     * {@link org.spongepowered.api.item.FireworkEffectBuilder}, etc.
     *
     * @param builderClass The class of the builder
     * @param <T> The type of builder
     * @return The builder, if available
     */
    <T> Optional<T> getBuilderOf(Class<T> builderClass);

    /**
     * Get an item stack builder.
     *
     * @return The item stack builder
     */
    ItemStackBuilder getItemBuilder();

    /**
     * Get a trade offer builder.
     *
     * @return The trade offer builder
     */
    TradeOfferBuilder getTradeOfferBuilder();

    /**
     * Gets a new {@link FireworkEffectBuilder}.
     *
     * @return A new firework effect builder
     */
    FireworkEffectBuilder getFireworkEffectBuilder();

    /**
     * Get a potion effect builder.
     *
     * @return The potion effect builder
     */
    PotionEffectBuilder getPotionEffectBuilder();

    /**
     * Get an objective builder.
     *
     * @return The objective builder
     */
    ObjectiveBuilder getObjectiveBuilder();

    /**
     * Get a team builder.
     *
     * @return The team builder
     */
    TeamBuilder getTeamBuilder();

    /**
     * Gets a scoreboard builder.
     *
     * @return The scoreboard builder
     */
    ScoreboardBuilder getScoreboardBuilder();

    /**
     * Creates a new {@link StatisticBuilder} which may be used to create custom
     * {@link Statistic}s.
     *
     * @return The newly created simple statistic builder
     */
    StatisticBuilder getStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.statistic.StatisticBuilder.EntityStatisticBuilder}
     * which may be used to create custom {@link EntityStatistic}s.
     *
     * @return The newly created entity statistic builder
     */
    StatisticBuilder.EntityStatisticBuilder getEntityStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.statistic.StatisticBuilder.BlockStatisticBuilder}
     * which may be used to create custom {@link BlockStatistic}s.
     *
     * @return The newly created block statistic builder
     */
    StatisticBuilder.BlockStatisticBuilder getBlockStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.statistic.StatisticBuilder.ItemStatisticBuilder}
     * which may be used to create custom {@link ItemStatistic}s.
     *
     * @return The newly created item statistic builder
     */
    StatisticBuilder.ItemStatisticBuilder getItemStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.statistic.StatisticBuilder.TeamStatisticBuilder}
     * which may be used to create custom {@link TeamStatistic}s.
     *
     * @return The newly created team statistic builder
     */
    StatisticBuilder.TeamStatisticBuilder getTeamStatisticBuilder();

    /**
     * Creates a new {@link AchievementBuilder} which may be used to create
     * custom {@link Achievement}s.
     *
     * @return The newly created achievement builder
     */
    AchievementBuilder getAchievementBuilder();

    /**
     * Gets a new {@link AttributeModifierBuilder}.
     *
     * @return A new AttributeModifierBuilder
     */
    AttributeModifierBuilder getAttributeModifierBuilder();

    /**
     * Gets the {@link AttributeCalculator}.
     *
     * @return The {@link AttributeCalculator}
     */
    AttributeCalculator getAttributeCalculator();

    /**
     * Gets a new {@link AttributeBuilder}.
     *
     * @return A new AttributeBuilder
     */
    AttributeBuilder getAttributeBuilder();

    /**
     * Gets a new {@link WorldBuilder} for creating {@link World}s or
     * {@link WorldCreationSettings}s.
     *
     * @return A new builder
     */
    WorldBuilder getWorldBuilder();

    /**
     * Gets a new particle builder for the {@link ParticleType}.
     *
     * @param particle The particle type
     * @return The particle effect builder
     */
    ParticleEffectBuilder getParticleEffectBuilder(ParticleType particle);
}
