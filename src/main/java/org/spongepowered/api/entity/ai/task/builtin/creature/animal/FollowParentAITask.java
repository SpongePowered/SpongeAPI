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
package org.spongepowered.api.entity.ai.task.builtin.creature.animal;

import org.spongepowered.api.entity.ai.task.builtin.VanillaAITask;
import org.spongepowered.api.entity.ai.task.builtin.VanillaAITaskBuilder;
import org.spongepowered.api.entity.living.animal.Animal;

import java.util.Optional;

import javax.annotation.Nullable;

public interface FollowParentAITask extends VanillaAITask<Animal> {

    double getSpeed();

    FollowParentAITask setSpeed(double speed);

    Optional<Animal> getParent();

    /**
     * Sets the parent animal that the task executor is following.
     * This is not {@link Nullable} because it might cause a NPE if this is set at
     * inappropriate time.
     *
     * @param parent The parent of the executor of the task
     * @return The task itself, for chaining
     */
    FollowParentAITask setParent(Animal parent);

    interface Builder extends VanillaAITaskBuilder<Animal, FollowParentAITask, Builder> {

        Builder speed(double speed);

    }
}
