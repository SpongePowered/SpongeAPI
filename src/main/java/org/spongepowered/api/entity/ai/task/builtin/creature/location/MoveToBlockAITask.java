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
package org.spongepowered.api.entity.ai.task.builtin.creature.location;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.function.Predicate;

/**
 * An {@link AITask} which uses a predicate to determine the movement target
 * location for an entity.
 */
public interface MoveToBlockAITask extends AITask<Creature> {

    /**
     * Creates a new {@link Builder} to build a new {@link MoveToBlockAITask}.
     *
     * @return A new builder
     */
    static MoveToBlockAITask.Builder builder() {
        return Sponge.getRegistry().createBuilder(MoveToBlockAITask.Builder.class);
    }

    /**
     * Gets the movement speed modifier for moving towards a location target.
     *
     * @return The movement speed modifier
     */
    double getSpeed();

    /**
     * Sets the movement speed modifier for moving towards a location target.
     *
     * @param speed The movement speed modifier
     * @return This task, for chaining
     */
    MoveToBlockAITask setSpeed(double speed);

    /**
     * Gets the range for which the entity will search for a valid destination.
     *
     * @return The search range
     */
    int getSearchRange();

    /**
     * Sets the range for which the entity will search for a valid destination.
     *
     * @param searchRange The search range
     * @return This task, for chaining
     */
    MoveToBlockAITask setSearchRange(int searchRange);

    /**
     * Gets the current destination position as a {@link Vector3i} for this task.
     *
     * @return The current destination position
     */
    Vector3i getDestination();

    /**
     * Sets the current destination for this task.
     *
     * @param destination The destination position
     * @return This task, for chaining
     */
    MoveToBlockAITask setDestination(Vector3i destination);

    /**
     * Gets the {@link Predicate} that this task uses to determine valid destinations.
     *
     * @return The destination predicate
     */
    Predicate<Location<World>> getDestinationPredicate();

    interface Builder extends AITaskBuilder<Creature, MoveToBlockAITask, MoveToBlockAITask.Builder> {

        MoveToBlockAITask.Builder speed(double speed);

        MoveToBlockAITask.Builder searchRange(int searchRange);

        MoveToBlockAITask.Builder destinationPredicate(Predicate<Location<World>> destinationPredicate);

    }

}
