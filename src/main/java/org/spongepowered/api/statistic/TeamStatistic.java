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
package org.spongepowered.api.statistic;

import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a {@link Statistic} for a team's {@link TextColor}.
 */
public interface TeamStatistic extends Statistic {

    /**
     * Gets the team's {@link TextColor} this {@link Statistic} measures.
     *
     * @return The team's text color this statistic measures
     */
    TextColor getTeamColor();

    /**
     * Represents a builder to create new and custom instances of
     * {@link TeamStatistic}s.
     */
    interface Builder extends Statistic.Builder {

        /**
         * Sets the {@link TextColor} of this {@link TeamStatistic}.
         *
         * @param color The color
         * @return This builder, for chaining
         */
        Builder teamColor(TextColor color);

        @Override
        Builder name(String name);

        @Override
        Builder translation(Translation translation);

        @Override
        Builder format(@Nullable StatisticFormat format);

        @Override
        Builder group(StatisticGroup group);

        @Override
        TeamStatistic buildAndRegister() throws IllegalStateException;

        @Override
        Builder reset();

    }
}
