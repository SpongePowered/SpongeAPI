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
package org.spongepowered.api.statistic.achievement;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents an in-game achievement which may be earned by or given to players.
 */
@CatalogedBy(Achievements.class)
public interface Achievement extends CatalogType, Translatable {

    /**
     * Creates a new {@link Builder} to build a {@link Achievement}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Returns the description that describes this achievement.
     *
     * @return The description of this achievement
     */
    Translation getDescription();

    /**
     * Returns the parent of this achievement, if there is one.
     *
     * @return The parent of this achievement
     */
    Optional<Achievement> getParent();

    /**
     * Returns the children of this achievement.
     *
     * @return An immutable collection of all children this achievement has
     */
    Collection<Achievement> getChildren();

    /**
     * Gets the {@link Statistic} which this achievement is backed by if it is available.
     *
     * @return The source statistic, if available
     */
    Optional<Statistic> getSourceStatistic();

    /**
     * If this achievement is backed by a statistic (eg. if
     * {@link #getSourceStatistic()} is not absent) then this will return the
     * target value which must be reached for this achievement to be awarded to
     * a player.
     *
     * @return The target value, if available
     */
    Optional<Long> getStatisticTargetValue();

    /**
     * Represents a builder interface to create new and custom instances of
     * {@link Achievement}s.
     */
    interface Builder extends ResettableBuilder<Achievement, Builder> {

        /**
         * Sets the internal name for the {@link Achievement}.
         *
         * @param name The name of this achievement
         * @return This builder, for chaining
         */
        Builder name(String name);

        /**
         * Sets the translation for the {@link Achievement}.
         *
         * @param translation The translation for the achievement
         * @return This builder, for chaining
         */
        Builder translation(Translation translation);

        /**
         * Sets the description that describes this {@link Achievement}.
         *
         * @param description The description of this achievement
         * @return This builder, for chaining
         */
        Builder description(Translation description);

        /**
         * Sets the parent of this {@link Achievement}, if there is one.
         *
         * @param parent The parent of this achievement
         * @return This builder, for chaining
         */
        Builder parent(@Nullable Achievement parent);

        /**
         * Sets a statistic which will be used for tracking this achievement. May be
         * null if this achievement is not backed by a statistic but is manually
         * awarded instead. If the statistic is not null then the
         * {@link #targetValue(long)} must be set as well. This defaults to null if
         * not set.
         *
         * @param stat The statistic, or null if not backed by a statistic
         * @return This builder, for chaining
         */
        Builder sourceStatistic(@Nullable Statistic stat);

        /**
         * Sets the target value of the statistic backing this achievement. If the
         * source statistic is not set then this value will be ignored if set.
         * Defaults to 1 if not set.
         *
         * @param value The target value
         * @return This builder, for chaining
         */
        Builder targetValue(long value);

        /**
         * Builds and registers an instance of an {@link Achievement}.
         *
         * @return A new instance of a achievement
         * @throws IllegalStateException If the achievement is not completed
         */
        Achievement buildAndRegister() throws IllegalStateException;

    }
}
