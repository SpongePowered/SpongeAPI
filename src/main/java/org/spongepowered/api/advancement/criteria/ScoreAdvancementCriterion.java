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
 * Represents a {@link AdvancementCriterion} that requires a
 * specific score ({@link #getGoal()}) to be achieved.
 */
public interface ScoreAdvancementCriterion extends AdvancementCriterion {

    /**
     * Creates a new {@link Builder} which can be used to create
     * a {@link ScoreAdvancementCriterion}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the goal value.
     *
     * @return The goal value
     */
    int getGoal();

    /**
     * A builder to create {@link ScoreAdvancementCriterion}s.
     */
    interface Builder extends BaseBuilder<ScoreAdvancementCriterion, Builder> {

        /**
         * Sets the goal value. This value must be greater then zero.
         *
         * <p>Defaults to {@code 1}.</p>
         *
         * @param goal The goal value
         * @return This builder, for chaining
         */
        Builder goal(int goal);

    }

}
