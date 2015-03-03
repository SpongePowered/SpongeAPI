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

import java.util.Map;

/**
 * Represents a builder interface to create new instances of {@link Statistic}s.
 */
public interface StatisticBuilder {

    /**
     * Sets the translation for the {@link Statistic}.
     *
     * @param translation The translation for the statistic
     */
    void translation(Translation translation);

    /**
     * Sets the id used to save the current values of the {@link Statistic}.
     *
     * @param id The id used to save the current values of the statistic
     */
    void id(String id);

    /**
     * Builds and registers an instance of a {@link Statistic}.
     *
     * @return A new instance of a statistic
     * @throws IllegalStateException If the statistic is not completed
     */
    Statistic buildAndRegister() throws IllegalStateException;

    /**
     * Represents a builder interface to create new instances of simple
     * {@link Statistic}s (none grouped).
     */
    interface Simple extends StatisticBuilder {

        /**
         * Sets the unit the {@link Statistic} will be measured in.
         *
         * @param unit The unit the statistic will be measured in
         */
        void unit(StatisticUnit unit);

    }

    /**
     * Represents a builder interface to create new instances of
     * {@link GroupedStatistic}s.
     */
    interface Grouped extends StatisticBuilder {

        /**
         * Sets the {@link StatisticType} the {@link GroupedStatistic} belongs
         * to.
         *
         * @param type The statistic type the grouped statistic belongs to
         */
        void type(StatisticType type);

        /**
         * Sets the builder to append the sub id to the {@link StatisticType}s
         * base id.
         *
         * @param subId The sub id used to save the current values of the
         *        statistic
         */
        void subId(String subId);

        /**
         * Attaches required data to the {@link GroupedStatistic}.
         *
         * @param key The key for the data to attach
         * @param value The value to attach
         * @throws IllegalArgumentException If the value does not meet the
         *         requirements or another value is already present for that key
         */
        void data(String key, Object value) throws IllegalArgumentException;

        /**
         * Attaches required data to the {@link GroupedStatistic}.
         *
         * @param values The values to attach
         * @throws IllegalArgumentException If the value does not meet the
         *         requirements or another value is already present for that key
         */
        void data(Map<String, ?> values) throws IllegalArgumentException;

        @Override
        GroupedStatistic buildAndRegister() throws IllegalStateException;

    }

}
