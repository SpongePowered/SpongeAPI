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

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Collection;

@CatalogedBy(StatisticCategories.class)
public interface StatisticCategory extends CatalogType {

    /**
     * Gets all the {@link Statistic}s that are listed
     * within this {@link StatisticCategory}.
     *
     * @return The statistics
     */
    Collection<? extends Statistic> getStatistics();

    /**
     * Represents a {@link StatisticCategory} that owns
     * {@link Statistic}s for all the {@link CatalogType}s
     * of a specific type.
     *
     * @param <T> The catalog type
     */
    interface ForCatalog<T extends CatalogType> extends StatisticCategory {

        @Override
        Collection<Statistic.TypeInstance<T>> getStatistics();

        /**
         * Gets the {@link CatalogType} type.
         *
         * @return The catalog type
         */
        TypeToken<T> getType();

        /**
         * Gets the {@link Statistic.TypeInstance} for the given {@link CatalogType}.
         *
         * @param catalogType The catalog type
         * @return The catalog statistic
         */
        Statistic.TypeInstance<T> getStatistic(T catalogType);
    }
}
