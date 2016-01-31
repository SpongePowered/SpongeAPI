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
package org.spongepowered.api.entity.ai.task.builtin.creature;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.builtin.GroundNavigationOnly;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * An {@link AITask} which the executor gets attracted by an {@link ItemStack}
 * held in the hand of a {@link Humanoid} and follows that humanoid.
 */
public interface TemptAITask extends GroundNavigationOnly<Creature> {

    /**
     * Creates a new {@link Builder} to build an {@link TemptAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get whether the executor will stop execution if the humanoid makes a big
     * movement.
     *
     * @return Whether the executor will stop execution
     */
    boolean getScaredByPlayer();

    /**
     * Set whether the executor will stop execution if the humanoid makes a big
     * movement.
     *
     * @param scaredByPlayer Whether the executor will stop execution
     * @return The task for chaining
     */
    TemptAITask setScaredByPlayer(boolean scaredByPlayer);

    /**
     * Get the moving speed of the executor during the execution.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Set the moving speed of the executor during the execution.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    TemptAITask setSpeed(double speed);

    /**
     * Get the {@link Predicate} which tests that if the {@link ItemStack} in
     * the {@link Humanoid}'s hand is tempt item stack.
     *
     * @return The predicate
     */
    Predicate<ItemStackSnapshot> getTemptItemFilter();

    /**
     * Set the {@link Predicate} which tests that if the {@link ItemStack} in
     * the {@link Humanoid}'s hand is tempt item stack.
     *
     * @param temptItemFilter The predicate
     * @return The task for chaining
     */
    TemptAITask setTemptItemFilter(Predicate<ItemStackSnapshot> temptItemFilter);

    /**
     * Get the current {@link Humanoid} that attracts the executor. Sometimes it
     * does not exist.
     *
     * @return The optional result of the tempter
     */
    Optional<Humanoid> getCurrentTempter();

    /**
     * Get the behavior of the executor which it will go into water if it gets
     * attracted. Default to {@code false}.
     *
     * @return The boolean that represents the behavior
     */
    boolean getAvoidingWater();

    /**
     * Set the behavior of the executor which it will go into water if it gets
     * attracted. Default to {@code false}.
     *
     * @param avoidingWater The boolean that represents the behavior
     * @return The task for chaining
     */
    TemptAITask setAvoidingWater(boolean avoidingWater);

    /**
     * Get the time delay between the two executions of this task. Default to
     * 100 ticks.
     *
     * @return The time delay
     */
    int getDelay();

    /**
     * Set the time delay between the two executions of this task. Default to
     * 100 ticks.
     *
     * @param delay The time delay
     * @return The task for chaining
     */
    TemptAITask setDelay(int delay);

    /**
     * Get the range of the executor finding the tempter. Default to
     * {@code 10.0D}.
     *
     * @return The range
     */
    double getTemptingRange();

    /**
     * Set the range of the executor finding the tempter. Default to
     * {@code 10.0D}.
     *
     * @param temptingRange The range
     * @return The task for chaining
     */
    TemptAITask setTemptingRange(double temptingRange);

    /**
     * Utility builder for {@link TemptAITask}.
     */
    interface Builder extends GroundNavigationOnly.Builder<Creature, TemptAITask, Builder> {

        /**
         * Set whether the executor will stop execution if the humanoid makes a
         * big movement.
         *
         * @param scaredByPlayer Whether the executor will stop execution
         * @return The builder for chaining
         */
        Builder scaredByPlayer(boolean scaredByPlayer);

        /**
         * Set the moving speed of the executor during the execution.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the {@link Predicate} which tests that if the {@link ItemStack}
         * in the {@link Humanoid}'s hand is tempt item stack.
         *
         * @param temptItemFilter The predicate
         * @return The builder for chaining
         */
        Builder temptItemFilter(Predicate<ItemStackSnapshot> temptItemFilter);

        /**
         * Set the behavior of the executor which it will go into water if it
         * gets attracted. Default to {@code false}.
         *
         * @param avoidingWater The boolean that represents the behavior
         * @return The builder for chaining
         */
        Builder avoidingWater(boolean avoidingWater);

        /**
         * Set the time delay between the two executions of this task. Default
         * to 100 ticks.
         *
         * @param delay The time delay
         * @return The builder for chaining
         */
        Builder delay(int delay);

        /**
         * Set the range of the executor finding the tempter. Default to
         * {@code 10.0D}.
         *
         * @param temptingRange The range
         * @return The builder for chaining
         */
        Builder temptingRange(double temptingRange);

    }

}
