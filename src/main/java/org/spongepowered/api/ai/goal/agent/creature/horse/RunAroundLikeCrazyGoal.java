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
package org.spongepowered.api.ai.goal.agent.creature.horse;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.ai.goal.Goal;
import org.spongepowered.api.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.RideableHorse;

public interface RunAroundLikeCrazyGoal<O extends RideableHorse> extends Goal<O> {

    /**
     * Creates a new {@link Builder} to build a new
     * {@link RunAroundLikeCrazyGoal}.
     *
     * @return A new builder
     */
    static <O extends RideableHorse, B extends Builder<O, RunAroundLikeCrazyGoal<O>, B>> B builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the speed modifier at which when an {@link Entity} is running
     * around, the movement speed is amplified by this modifier.
     *
     * @return The speed modifier
     */
    double getSpeed();

    /**
     * Sets the speed modifier at which when an {@link Entity} is running
     * around, the movement speed is amplified by this modifier.
     *
     * @param speed The speed modifier at which an entity is "running around"
     * @return This goal, for chaining
     */
    RunAroundLikeCrazyGoal<O> setSpeed(double speed);

    interface Builder<O extends RideableHorse, A extends RunAroundLikeCrazyGoal<O>, B extends Builder<O, A, B>> extends GoalBuilder<O, A, B> {

        B speed(double speed);

    }
}
