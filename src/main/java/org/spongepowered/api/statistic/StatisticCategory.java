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

import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Collection;
import java.util.Optional;

@CatalogedBy(StatisticCategories.class)
public interface StatisticCategory<T> extends Iterable<Statistic<T>> {

    /**
     * Gets the {@link Statistic} for the given {@link T value}.
     *
     * @param value The value
     * @return The instance or {@link Optional#empty()} if not found
     */
    Optional<Statistic<T>> statistic(T value);

    /**
     * Gets the {@link Statistic} for the given {@link T value}. If it doesn't exist, a new
     * {@link Statistic statistic} will be registered for this category using the {@link StatisticFormatters#DEFAULT}
     * formatter.
     *
     * @param value The value
     * @return The instance
     */
    Statistic<T> statisticOrCreate(T value);

    /**
     * Gets the {@link Statistic} for the given {@link T value}. If it doesn't exist, a new
     * {@link Statistic statistic} will be registered for this category using the provided
     * {@link StatisticFormatter formatter}.
     *
     * @param value The value
     * @param formatter The formatter
     * @return The instance
     */
    Statistic<T> statisticOrCreate(T value, StatisticFormatter formatter);

    /**
     * Gets all the {@link Statistic}s that are listed
     * within this {@link StatisticCategory}.
     *
     * @return The statistics
     */
    Collection<Statistic<T>> statistics();
}
