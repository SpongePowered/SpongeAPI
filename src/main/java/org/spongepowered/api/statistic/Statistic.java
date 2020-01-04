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
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.text.NumberFormat;
import java.util.Optional;

/**
 * Represents some statistic in minecraft.
 */
@CatalogedBy(Statistics.class)
public interface Statistic extends CatalogType {

    /**
     * Returns the objective {@link Criterion} for this statistic.
     *
     * @return Objective criterion
     */
    Optional<Criterion> getCriterion();

    /**
     * Returns the {@link NumberFormat} used to format the value of this
     * statistic.
     *
     * @return Statistic's number format
     */
    NumberFormat getFormat();

    /**
     * Represents a {@link Statistic} within a
     * {@link StatisticCategory.ForCatalog}
     * for a specific {@link CatalogType}.
     *
     * @param <T> The catalog type
     */
    interface TypeInstance<T extends CatalogType> extends Statistic {

        /**
         * Gets the {@link CatalogType}.
         *
         * @return The catalog type
         */
        T getType();
    }
}
