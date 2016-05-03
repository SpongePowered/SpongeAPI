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
package org.spongepowered.api.entity.ai.task.builtin.creature.tameable;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.builtin.creature.target.TargetAITask;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.animal.Tameable;

import java.util.Optional;

/**
 * An {@link AITask} for {@link Tameable}s to attack the {@link Living} that its
 * owner attacks.
 */
public interface AttackAfterOwnerAITask<O extends Tameable, A extends AttackAfterOwnerAITask<O, A>> extends TargetAITask<O, A> {

    /**
     * Creates a new {@link Builder} to build an {@link AttackAfterOwnerAITask}.
     *
     * @return The new builder
     */
    @SuppressWarnings("unchecked")
    static <O extends Tameable, A extends AttackAfterOwnerAITask<O, A>, B extends Builder<O, A, B>> Builder<O, A, B> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the {@link Living} which the executor's owner attacks. May or may not
     * exist.
     *
     * @return The target in optional, or empty
     */
    Optional<Living> getEnemy();

    /**
     * Utility builder for {@link AttackAfterOwnerAITask}.
     */
    interface Builder<O extends Tameable, A extends AttackAfterOwnerAITask<O, A>, B extends Builder<O, A, B>> extends TargetAITask.Builder<O, A, B> {

    }

}
