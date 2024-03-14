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
package org.spongepowered.api.entity.ai.goal.builtin.creature;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.goal.Goal;
import org.spongepowered.api.entity.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.Ranger;
import org.spongepowered.api.util.Ticks;

/**
 * An {@link Goal} which uses the ranging aspect of the Ranger to attack
 * the target.
 */
public interface RangedAttackAgainstAgentGoal extends Goal<Ranger> {

    /**
     * Creates a new {@link Builder} to build a new {@link RangedAttackAgainstAgentGoal}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets the movement speed modifier for moving towards a targeted
     * {@link Entity}.
     *
     * @return The movement speed modifier
     */
    double moveSpeed();

    /**
     * Sets the movement speed modifier for moving towards a targeted
     * {@link Entity}.
     *
     * @param speed The movement speed modifier
     * @return This goal, for chaining
     */
    RangedAttackAgainstAgentGoal setMoveSpeed(double speed);

    /**
     * Gets the delay in ticks between attempts to attack the targeted
     * {@link Entity}.
     *
     * @return The delay in ticks between attempts to attack
     */
    Ticks delayBetweenAttacks();

    /**
     * The time, in ticks, this {@link Ranger} will wait before attacking
     * again.
     *
     * @param delay The delay, in ticks
     * @return This goal, for chaining
     * @throws IllegalArgumentException if the delay is infinite
     */
    RangedAttackAgainstAgentGoal setDelayBetweenAttacks(Ticks delay);

    /**
     * Gets the radius of which the owning {@link Ranger} will attempt to
     * attack a targeted {@link Entity}.
     *
     * @return The radius of which the owning entity will attempt to attack
     */
    float attackRadius();

    /**
     * Sets the radius of which the owning {@link Ranger} will attempt to
     * attack a targeted {@link Entity}.
     *
     * @param radius The radius of which the owning entity will attempt to
     *     attack
     * @return This goal, for chaining
     */
    RangedAttackAgainstAgentGoal setAttackRadius(float radius);

    interface Builder extends GoalBuilder<Ranger, RangedAttackAgainstAgentGoal, Builder> {

        Builder moveSpeed(double speed);

        Builder delayBetweenAttacks(Ticks delay);

        Builder attackRadius(float radius);
    }

}
