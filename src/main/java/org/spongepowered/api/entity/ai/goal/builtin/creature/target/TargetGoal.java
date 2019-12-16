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
package org.spongepowered.api.entity.ai.goal.builtin.creature.target;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.goal.Goal;
import org.spongepowered.api.entity.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;

public interface TargetGoal<A extends TargetGoal<A>> extends Goal<Creature> {

    /**
     * Gets whether the owning {@link Agent} can visibly "see" the
     * {@link Entity} being targeted such that any {@link BlockType}s that
     * are visibly opaque will prevent the owning {@link Agent} from
     * targeting that {@link Entity}.
     *
     * @return Whether line of sight is required to target an entity
     */
    boolean shouldCheckSight();

    /**
     * Sets whether the owning {@link Agent} can visibly "see" the
     * {@link Entity} being targeted such that any {@link BlockType}s that
     * are visibly opaque will prevent the owning {@link Agent} from
     * targeting that {@link Entity}.
     *
     * @param checkSight Whether line of sight is required to target
     * @return This goal, for chaining
     */
    A setCheckSight(boolean checkSight);

    /**
     * Gets whether an {@link Entity} can only be targeted within a "short"
     * radius from the owning {@link Agent}.
     *
     * @return Whether only nearby entities can be targeted
     */
    boolean shouldCheckOnlyNearby();

    /**
     * Sets whether an {@link Entity} can only be targeted within a "short"
     * radius from the owning {@link Agent}.
     *
     * @param nearby Whether only nearby entities can be targeted
     * @return This goal, for chaining
     */
    A setCheckOnlyNearby(boolean nearby);

    interface Builder<A extends TargetGoal<A>, B extends Builder<A, B>> extends GoalBuilder<Creature, A, B> {

        B checkSight(boolean state);

        B checkOnlyNearby(boolean state);

        @Override
        B reset();
    }
}
