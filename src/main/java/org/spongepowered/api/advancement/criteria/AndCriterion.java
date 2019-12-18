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
package org.spongepowered.api.advancement.criteria;

import org.spongepowered.api.Sponge;

/**
 * A {@link AdvancementCriterion} that represents an AND operation. All
 * the criteria should be {@code true} in order for the final result
 * to be {@code true}.
 */
public interface AndCriterion extends OperatorCriterion {

    /**
     * Attempts to build a new AND operation with the
     * given {@link AdvancementCriterion}s.
     *
     * <p>There is no guarantee that the returned extends {@link AndCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The other criteria
     * @return The AND operation
     */
    static AdvancementCriterion of(AdvancementCriterion... criteria) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(criteria);
    }

    /**
     * Attempts to build a new AND operation with the
     * given {@link AdvancementCriterion}s.
     *
     * <p>There is no guarantee that the returned extends {@link AndCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The other criteria
     * @return The AND operation
     */
    static AdvancementCriterion of(Iterable<AdvancementCriterion> criteria) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(criteria);
    }

    interface Factory {

        AdvancementCriterion of(AdvancementCriterion... criteria);

        AdvancementCriterion of(Iterable<AdvancementCriterion> criteria);
    }
}
