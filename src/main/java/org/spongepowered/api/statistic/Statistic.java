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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents some statistic in Minecraft with a string ID.
 */
@CatalogedBy(Statistics.class)
public interface Statistic extends CatalogType, Translatable {

    /**
     * Creates a new {@link StatisticBuilder} to build a {@link Statistic}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Gets the {@link StatisticFormat} of this statistic. If this is not
     * present that this statistic's format is deferred to its group's default
     * format.
     *
     * @return The format of this statistic, if available
     */
    Optional<StatisticFormat> getStatisticFormat();

    /**
     * Gets the {@link StatisticGroup} this {@link Statistic} belongs to.
     *
     * @return The statistic group this statistic belongs to
     */
    StatisticGroup getGroup();

    interface Builder extends StatisticBuilder<Statistic, Builder> {

    }

    /**
     * Represents a builder to create new and custom instances of {@link Statistic}
     * s.
     */
    interface StatisticBuilder<T extends Statistic, B extends StatisticBuilder<T, B>> extends ResettableBuilder<T, B> {

        /**
         * Sets the internal name for the {@link Statistic}.
         *
         * @param name The name of this achievement
         * @return This builder, for chaining
         */
        B name(String name);

        /**
         * Sets the translation for the {@link Statistic}.
         *
         * @param translation The translation for the statistic
         * @return This builder, for chaining
         */
        B translation(Translation translation);

        /**
         * Sets the format of the {@link Statistic}. May be null in which case the
         * group default format will be used instead.
         *
         * @param format The format of the statistic
         * @return This builder, for chaining
         */
        B format(@Nullable StatisticFormat format);

        /**
         * Sets the {@link StatisticGroup} the {@link Statistic} belongs to.
         *
         * @param group The statistic group the statistic belongs to
         * @return This builder, for chaining
         */
        B group(StatisticGroup group);

        /**
         * Builds and registers an instance of a {@link Statistic}.
         *
         * @return A new instance of a statistic
         * @throws IllegalStateException If the statistic is not completed
         */
        T buildAndRegister() throws IllegalStateException;

        @Override
        B from(T value);

        @Override
        B reset();
    }
}
