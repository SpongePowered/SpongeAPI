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
import org.spongepowered.api.advancement.criteria.trigger.FilteredTrigger;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * Represents a criterion that should be acquired
 * to unlock a {@link Advancement}.
 */
public interface AdvancementCriterion {

    /**
     * Gets a {@link AdvancementCriterion} which is empty, this means that
     * nothing has to be achieved to unlock a {@link Advancement}.
     *
     * @return The empty advancement criterion
     */
    static AdvancementCriterion empty() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).empty();
    }

    /**
     * Gets a dummy {@link AdvancementCriterion}, this criterion will never
     * be triggered by vanilla minecraft.
     *
     * @return The dummy advancement criterion
     */
    static AdvancementCriterion dummy() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).dummy();
    }

    /**
     * Creates a new {@link Builder} to create {@link AdvancementCriterion}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
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
     *
     * <p>There is no guarantee that the returned extends {@link AndCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The criteria
     * @return The AND operation
     */
    AdvancementCriterion and(AdvancementCriterion... criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an AND operation.
     *
     * <p>There is no guarantee that the returned extends {@link AndCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The criteria
     * @return The AND operation
     */
    AdvancementCriterion and(Iterable<AdvancementCriterion> criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an OR operation.
     *
     * <p>There is no guarantee that the returned extends {@link OrCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The criteria
     * @return The OR operation
     */
    AdvancementCriterion or(AdvancementCriterion... criteria);

    /**
     * Combines this {@link AdvancementCriterion} with the other criteria
     * to create an OR operation.
     *
     * <p>There is no guarantee that the returned extends {@link OrCriterion},
     * this depends on if there are duplicate criteria, {@link #empty()}
     * is present, or when no extra criteria are provided.</p>
     *
     * @param criteria The criteria
     * @return The OR operation
     */
    AdvancementCriterion or(Iterable<AdvancementCriterion> criteria);

    /**
     * Gets the {@link FilteredTrigger} of this
     * {@link AdvancementCriterion}, if present.
     *
     * @return The trigger
     */
    Optional<FilteredTrigger<?>> getTrigger();

    /**
     * A builder to create {@link AdvancementCriterion}s.
     */
    interface Builder extends BaseBuilder<AdvancementCriterion, Builder> {

    }

    /**
     * A base builder to create {@link AdvancementCriterion}s.
     */
    interface BaseBuilder<T extends AdvancementCriterion, B extends BaseBuilder<T, B>> extends CopyableBuilder<T, B> {

        /**
         * Sets the {@link FilteredTrigger}.
         *
         * @param trigger The filtered trigger
         * @return This builder, for chaining
         */
        B trigger(FilteredTrigger<?> trigger);

        /**
         * Sets the name of the {@link AdvancementCriterion}. Names can be
         * shared between multiple criteria, although it isn't allowed when
         * using them for the same {@link Advancement}.
         *
         * @param name The name
         * @return This builder, for chaining
         */
        B name(String name);

        /**
         * Builds a new {@link AdvancementCriterion}.
         *
         * @return The criterion
         */
        T build();
    }

    interface Factory {

        AdvancementCriterion empty();

        AdvancementCriterion dummy();
    }
}
