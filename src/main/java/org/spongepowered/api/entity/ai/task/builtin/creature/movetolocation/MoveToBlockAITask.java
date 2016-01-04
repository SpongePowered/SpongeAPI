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
package org.spongepowered.api.entity.ai.task.builtin.creature.movetolocation;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.function.Predicate;

/**
 * An {@link AITask} which the executor finds a valid position and goes to that
 * position. (MCP name: EntityAIMoveToBlock)
 *
 * @param <O> The executor type
 * @param <A> The task type
 */
public interface MoveToBlockAITask<O extends Creature, A extends MoveToBlockAITask<O, A>> extends AITask<O> {

    /**
     * Get the range of the task searching for a location that is acceptable.
     *
     * @return The range
     */
    int getSearchRange();

    /**
     * Set the range of the task searching for a location that is acceptable.
     *
     * @param searchRange The range
     * @return The task for chaining
     */
    A setSearchRange(int searchRange);

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Set the moving speed of the executor.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    A setSpeed(double speed);

    /**
     * Get the destination selector used by this task.
     *
     * @return The destination selector
     */
    Predicate<Location<World>> getDestinationSelector();

    /**
     * Set the destination selector used by this task.
     *
     * @param destinationSelector The destination selector
     * @return The task for chaining
     */
    A setDestinationSelector(Predicate<Location<World>> destinationSelector);

    /**
     * Get the current destination of the task.
     *
     * @return The current destination of the task
     */
    Location<World> getDestination();

    /**
     * Get the frequency of update, means how many ticks it updates once.
     *
     * @return The frequency
     */
    int getUpdateFrequency();

    /**
     * Set the frequency of update, means how many ticks it updates once.
     *
     * @param updateFrequency The frequency
     * @return The task for chaining
     */
    A setUpdateFrequency(int updateFrequency);

    /**
     * Utility builder for {@link MoveToBlockAITask}.
     *
     * @param <O> The executor type
     * @param <A> The task type
     * @param <B> The builder type
     */
    interface MoveToBlockAITaskBuilder<O extends Creature, A extends MoveToBlockAITask<O, A>, B extends MoveToBlockAITaskBuilder<O, A, B>>
            extends AITaskBuilder<O, A, B> {

        /**
         * Set the range of the task searching for a location that is
         * acceptable.
         *
         * @param searchRange The range
         * @return The builder for chaining
         */
        B searchRange(int searchRange);

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        B speed(double speed);

        /**
         * Set the destination selector used by this task.
         *
         * @param destinationSelector The destination selector
         * @return The builder for chaining
         */
        B destinationSelector(Predicate<Location<World>> destinationSelector);

        /**
         * Set the frequency of update, means how many ticks it updates once.
         *
         * @param updateFrequency The frequency
         * @return The builder for chaining
         */
        B updateFrequency(int updateFrequency);

    }

}
