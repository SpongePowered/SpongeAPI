/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.stats;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder to create new and custom instances of {@link Statistic}
 * s.
 */
public interface StatisticBuilder {

    /**
     * Sets the internal name for the {@link Statistic}.
     *
     * @param name The name of this achievement
     * @return This builder, for chaining
     */
    StatisticBuilder name(String name);

    /**
     * Sets the translation for the {@link Statistic}.
     *
     * @param translation The translation for the statistic
     * @return This builder, for chaining
     */
    StatisticBuilder translation(Translation translation);

    /**
     * Sets the format of the {@link Statistic}. May be null in which case the
     * group default format will be used instead.
     *
     * @param format The format of the statistic
     * @return This builder, for chaining
     */
    StatisticBuilder format(@Nullable StatisticFormat format);

    /**
     * Sets the {@link StatisticGroup} the {@link Statistic} belongs to.
     *
     * @param group The statistic group the statistic belongs to
     * @return This builder, for chaining
     */
    StatisticBuilder group(StatisticGroup group);

    /**
     * Builds and registers an instance of a {@link Statistic}.
     *
     * @return A new instance of a statistic
     * @throws IllegalStateException If the statistic is not completed
     */
    Statistic buildAndRegister() throws IllegalStateException;

    /**
     * Represents a builder to create new and custom instances of
     * {@link EntityStatistic}s.
     */
    interface EntityStatisticBuilder extends StatisticBuilder {

        /**
         * Sets the {@link EntityType} of this {@link EntityStatistic}.
         * 
         * @param entity The entity
         * @return This builder, for chaining
         */
        EntityStatisticBuilder entity(EntityType entity);

        @Override
        EntityStatisticBuilder name(String name);

        @Override
        EntityStatisticBuilder translation(Translation translation);

        @Override
        EntityStatisticBuilder format(@Nullable StatisticFormat format);

        @Override
        EntityStatisticBuilder group(StatisticGroup group);

        @Override
        EntityStatistic buildAndRegister() throws IllegalStateException;

    }

    /**
     * Represents a builder to create new and custom instances of
     * {@link BlockStatistic}s.
     */
    interface BlockStatisticBuilder extends StatisticBuilder {

        /**
         * Sets the {@link BlockType} of this {@link BlockStatistic}.
         * 
         * @param block The block
         * @return This builder, for chaining
         */
        BlockStatisticBuilder block(BlockType block);

        @Override
        BlockStatisticBuilder name(String name);

        @Override
        BlockStatisticBuilder translation(Translation translation);

        @Override
        BlockStatisticBuilder format(@Nullable StatisticFormat format);

        @Override
        BlockStatisticBuilder group(StatisticGroup group);

        @Override
        BlockStatistic buildAndRegister() throws IllegalStateException;

    }

    /**
     * Represents a builder to create new and custom instances of
     * {@link ItemStatistic}s.
     */
    interface ItemStatisticBuilder extends StatisticBuilder {

        /**
         * Sets the {@link ItemType} of this {@link ItemStatistic}.
         * 
         * @param item The item
         * @return This builder, for chaining
         */
        ItemStatisticBuilder item(ItemType item);

        @Override
        ItemStatisticBuilder name(String name);

        @Override
        ItemStatisticBuilder translation(Translation translation);

        @Override
        ItemStatisticBuilder format(@Nullable StatisticFormat format);

        @Override
        ItemStatisticBuilder group(StatisticGroup group);

        @Override
        ItemStatistic buildAndRegister() throws IllegalStateException;

    }

    /**
     * Represents a builder to create new and custom instances of
     * {@link TeamStatistic}s.
     */
    interface TeamStatisticBuilder extends StatisticBuilder {

        /**
         * Sets the {@link TextColor} of this {@link TeamStatistic}.
         * 
         * @param color The color
         * @return This builder, for chaining
         */
        TeamStatisticBuilder teamColor(TextColor color);

        @Override
        TeamStatisticBuilder name(String name);

        @Override
        TeamStatisticBuilder translation(Translation translation);

        @Override
        TeamStatisticBuilder format(@Nullable StatisticFormat format);

        @Override
        TeamStatisticBuilder group(StatisticGroup group);

        @Override
        TeamStatistic buildAndRegister() throws IllegalStateException;

    }

}
