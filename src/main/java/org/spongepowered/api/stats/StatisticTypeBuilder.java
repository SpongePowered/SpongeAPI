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

import com.google.common.base.Function;

import java.lang.reflect.Method;

/**
 * Represents a builder interface to create new instances of
 * {@link StatisticType}s.
 */
public interface StatisticTypeBuilder {

    /**
     * Sets the interfaces the {@link StatisticType} should implement.
     *
     * @param types The interfaces the statistic type should implement
     * @throws IllegalArgumentException If a class is unsupported or if a class
     *         is incompatible with another class
     */
    void type(Class<? extends StatisticType>... types) throws IllegalArgumentException;

    /**
     * Sets the base id for all {@link GroupedStatistic} that will be created
     * for the {@link StatisticType}.
     *
     * @param baseId The base id for the statistic type
     */
    void baseId(String baseId);

    /**
     * Sets the unit of the {@link GroupedStatistic} that will be created for
     * the {@link StatisticType} will be measured in.
     *
     * @param unit The unit for the statistic type
     */
    void unit(StatisticUnit unit);

    /**
     * Sets a method mapper for the {@link StatisticType} that will be used to
     * resolve all method calls to the statistic type to keys, that can will be
     * provided in the {@link StatisticBuilder.Grouped}. If the method mapper is
     * not available or it returns null for a method, then the method will be
     * mapped to the virtual fieldname (camelcase) the getter would address.
     *
     * @param methodMapper The method mapper to use
     */
    void methodMapper(Function<Method, String> methodMapper);

    /**
     * Builds the instance of a {@link StatisticType}.
     *
     * @return A new instance of a statistic type
     * @throws IllegalStateException If the statistic type is not completed
     */
    StatisticType build() throws IllegalStateException;

}
