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
package org.spongepowered.api.entity.ai.task.builtin.creature.target;

import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Living;

import java.util.function.Predicate;

public interface FindNearestAttackableTargetAITask<A extends FindNearestAttackableTargetAITask<A, B>, B extends Creature> extends TargetAITask<A, B> {
    
    Class<? extends Living> getTargetClass();

    A setTargetClass(Class<? extends Living> targetClass);

    int getChance();

    A setChance(int chance);

    A filter(Predicate<Living> predicate);

    Predicate<Living> getFilter();

    interface Builder<O extends Creature, A extends FindNearestAttackableTargetAITask<A, O>, B extends Builder<O, A, B>>
            extends TargetAITask.Builder<O, A, B> {

        B target(Class<? extends Living> targetClass);

        B chance(int chance);

        B filter(Predicate<? extends Living> predicate);

    }
}
