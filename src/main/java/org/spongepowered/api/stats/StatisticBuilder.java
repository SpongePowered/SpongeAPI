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

import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create new and custom instances of
 * {@link Statistic}s.
 */
public interface StatisticBuilder {

    /**
     * Sets the translation for the {@link Statistic}.
     *
     * @param translation The translation for the statistic
     * @return This builder
     */
    StatisticBuilder translation(Translation translation);

    /**
     * Sets the id used to save the current values of the {@link Statistic}.
     *
     * @param id The id used to save the current values of the statistic
     * @return This builder
     */
    StatisticBuilder id(String id);

    /**
     * Sets the format of the {@link Statistic}. May be null in which case the
     * group default format will be used instead.
     *
     * @param format The format of the statistic
     * @return This builder
     */
    StatisticBuilder format(@Nullable StatisticFormat format);

    /**
     * Sets the {@link StatisticGroup} the {@link Statistic} belongs
     * to.
     *
     * @param type The statistic group the grouped statistic belongs to
     * @return This builder
     */
    StatisticBuilder group(StatisticGroup type);

    /**
     * Builds and registers an instance of a {@link Statistic}.
     *
     * @return A new instance of a statistic
     * @throws IllegalStateException If the statistic is not completed
     */
    Statistic buildAndRegister() throws IllegalStateException;

}
