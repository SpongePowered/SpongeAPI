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

package org.spongepowered.api.stats.achievement;

import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create new and custom instances of
 * {@link Achievement}s.
 */
public interface AchievementBuilder {

    /**
     * Sets the internal name for the {@link Achievement}.
     *
     * @param name The name of this achievement
     * @return This builder, for chaining
     */
    AchievementBuilder name(String name);

    /**
     * Sets the translation for the {@link Achievement}.
     *
     * @param translation The translation for the achievement
     * @return This builder, for chaining
     */
    AchievementBuilder translation(Translation translation);

    /**
     * Sets the description that describes this {@link Achievement}.
     *
     * @param description The description of this achievement
     * @return This builder, for chaining
     */
    AchievementBuilder description(Translation description);

    /**
     * Sets the parent of this {@link Achievement}, if there is one.
     *
     * @param parent The parent of this achievement
     * @return This builder, for chaining
     */
    AchievementBuilder parent(@Nullable Achievement parent);
    
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
    AchievementBuilder sourceStatistic(@Nullable Statistic stat);
    
    /**
     * Sets the target value of the statistic backing this achievement. If the
     * source statistic is not set then this value will be ignored if set.
     * Defaults to 1 if not set.
     * 
     * @param value The target value
     * @return This builder, for chaining
     */
    AchievementBuilder targetValue(long value);

    /**
     * Builds and registers an instance of an {@link Achievement}.
     *
     * @return A new instance of a achievement
     * @throws IllegalStateException If the achievement is not completed
     */
    Achievement buildAndRegister() throws IllegalStateException;

}
