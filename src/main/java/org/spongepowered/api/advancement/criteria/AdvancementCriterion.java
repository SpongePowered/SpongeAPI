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
import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.criteria.trigger.Trigger;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Set;

/**
 * Represents a criterion that should be acquired
 * to unlock a {@link Advancement}.
 */
public interface AdvancementCriterion {

    /**
     * Represents an empty criterion, this means that nothing has to be achieved to
     * unlock a {@link Advancement}.
     */
    AdvancementCriterion EMPTY = DummyObjectProvider.createFor(AdvancementCriterion.class, "EMPTY");

    /**
     * Creates a new {@link Builder} to create {@link AdvancementCriterion}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the name of this criterion.
     *
     * @return The name
     */
    String getName();

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an AND operation.
     * <p>
     * There is no guarantee that the returned extends {@link AndCriterion}, this depends
     * on if there are duplicate criteria, {@link #EMPTY} is present or when no
     * extra criteria are provided.
     *
     * @param criteria The criteria
     * @return The and operation
     */
    AdvancementCriterion and(AdvancementCriterion... criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an AND operation.
     * <p>
     * There is no guarantee that the returned extends {@link AndCriterion}, this depends
     * on if there are duplicate criteria, {@link #EMPTY} is present or when no
     * extra criteria are provided.
     *
     * @param criteria The criteria
     * @return The and operation
     */
    AdvancementCriterion and(Iterable<AdvancementCriterion> criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an OR operation.
     * <p>
     * There is no guarantee that the returned extends {@link OrCriterion}, this depends
     * on if there are duplicate criteria, {@link #EMPTY} is present or when no
     * extra criteria are provided.
     *
     * @param criteria The criteria
     * @return The or operation
     */
    AdvancementCriterion or(AdvancementCriterion... criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an OR operation.
     * <p>
     * There is no guarantee that the returned extends {@link OrCriterion}, this depends
     * on if there are duplicate criteria, {@link #EMPTY} is present or when no
     * extra criteria are provided.
     *
     * @param criteria The criteria
     * @return The or operation
     */
    AdvancementCriterion or(Iterable<AdvancementCriterion> criteria);

    /**
     * Gets the {@link Trigger}s of this {@link AdvancementCriterion}. The
     * {@link Set} can be empty.
     *
     * @return The triggers
     */
    Set<Trigger> getTriggers();

    /**
     * A builder to create {@link AdvancementCriterion}s.
     */
    interface Builder extends BaseBuilder<AdvancementCriterion, Builder> {

    }

    /**
     * A base builder to create {@link AdvancementCriterion}s.
     */
    interface BaseBuilder<T extends AdvancementCriterion, B extends BaseBuilder<T, B>> extends ResettableBuilder<T, B> {

        /**
         * Builds a new {@link AdvancementCriterion} with the specified
         * name. Names can be shared between multiple criteria, although
         * it should be avoided when using them for the same {@link Advancement}.
         *
         * @param name The name
         * @return The criterion
         */
        T build(String name);
    }
}
