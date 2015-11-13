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

import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nullable;

/**
 * Represents a {@link Statistic} for an {@link EntityType}.
 */
public interface EntityStatistic extends Statistic {

    /**
     * Gets the {@link EntityType} this {@link Statistic} measures.
     *
     * @return The entity type this statistic measures
     */
    EntityType getEntityType();

    /**
     * Represents a builder to create new and custom instances of
     * {@link EntityStatistic}s.
     */
    interface Builder extends Statistic.Builder {

        /**
         * Sets the {@link EntityType} of this {@link EntityStatistic}.
         *
         * @param entity The entity
         * @return This builder, for chaining
         */
        Builder entity(EntityType entity);

        @Override
        Builder name(String name);

        @Override
        Builder translation(Translation translation);

        @Override
        Builder format(@Nullable StatisticFormat format);

        @Override
        Builder group(StatisticGroup group);

        @Override
        EntityStatistic buildAndRegister() throws IllegalStateException;

        @Override
        Builder reset();

    }
}
