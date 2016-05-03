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
package org.spongepowered.api.entity.ai.task.builtin.creature.irongolem;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.builtin.creature.target.FindNearestAttackableTargetAITask;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.Creeper;

/**
 * A special {@link FindNearestAttackableTargetAITask} but it excluded
 * {@link Creeper}s in the filter.
 */
public interface AttackNearestNonCreeperTargetAITask<O extends IronGolem, A extends AttackNearestNonCreeperTargetAITask<O, A>>
        extends FindNearestAttackableTargetAITask<O, A> {

    /**
     * Creates a new {@link Builder} to build an {@link AttackNearestNonCreeperTargetAITask}.
     *
     * @return The new builder
     */
    @SuppressWarnings("unchecked")
    static <O extends IronGolem, A extends AttackNearestNonCreeperTargetAITask<O, A>, B extends Builder<O, A, B>> Builder<O, A, B> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Utility builder for {@link AttackNearestNonCreeperTargetAITask}.
     */
    interface Builder<O extends IronGolem, A extends AttackNearestNonCreeperTargetAITask<O, A>, B extends Builder<O, A, B>> extends
            FindNearestAttackableTargetAITask.Builder<O, A, B> {

    }

}
