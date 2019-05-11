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
package org.spongepowered.api.ai.goal.agent;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.ai.goal.Goal;
import org.spongepowered.api.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.Agent;

public interface SwimmingGoal<O extends Agent> extends Goal<O> {

    /**
     * Creates a new {@link Builder} to build a new
     * {@link SwimmingGoal}.
     *
     * @return A new builder
     */
    static <O extends Agent, B extends Builder<O, SwimmingGoal<O>, B>> B builder(O type) {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the chance that the owning {@link Agent} will perform
     * a "jump". The chance is limited between {@code 0} and {@code 1},
     * to where the higher the chance, the more likely the entity will
     * "jump" to appear "swimming".
     *
     * @return The chance that the owning entity will "swim"
     */
    float getSwimChance();

    /**
     * Sets the chance that the owning {@link Agent} will perform
     * a "jump". The chance is limited between {@code 0} and {@code 1},
     * to where the higher the chance, the more likely the entity will
     * "jump" to appear "swimming".
     *
     * @param chance The chance that the entity will "swim"
     */
    SwimmingGoal<O> setSwimChance(float chance);

    interface Builder<O extends Agent, A extends SwimmingGoal<O>, B extends Builder<O, A, B>> extends GoalBuilder<O, A, B> {

        B swimChance(float chance);

    }
}
