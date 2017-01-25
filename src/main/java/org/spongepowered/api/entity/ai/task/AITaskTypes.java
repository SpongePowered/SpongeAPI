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
package org.spongepowered.api.entity.ai.task;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.animal.RideableHorse;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.Location;

import java.util.function.Predicate;

public final class AITaskTypes {

    // SORTFIELDS:ON

    /**
     * {@link AITask} where {@link Creature}s avoid other {@link Agent}s based on a {@link Predicate}.
     */
    public static final AITaskType AVOID_ENTITY = DummyObjectProvider.createFor(AITaskType.class, "AVOID_ENTITY");

    /**
     * {@link AITask} where {@link Creature}s move to a {@link Location} based on a {@link Predicate}.
     */
    public static final AITaskType MOVE_TO_BLOCK = DummyObjectProvider.createFor(AITaskType.class, "MOVE_TO_BLOCK");

    /**
     * {@link AITask} where {@link RideableHorse}s run around while {@link Humanoid}s attempt to tame them.
     */
    public static final AITaskType RUN_AROUND_LIKE_CRAZY = DummyObjectProvider.createFor(AITaskType.class, "RUN_AROUND_LIKE_CRAZY");

    /**
     * {@link AITask} where {@link Agent}s swim in liquids.
     */
    public static final AITaskType SWIMMING = DummyObjectProvider.createFor(AITaskType.class, "SWIMMING");

    /**
     * {@link AITask} where {@link Creature}s walk around.
     */
    public static final AITaskType WANDER = DummyObjectProvider.createFor(AITaskType.class, "WANDER");

    /**
     * {@link AITask} where {@link Agent}s will "watch" other {@link Entity}s.
     */
    public static final AITaskType WATCH_CLOSEST = DummyObjectProvider.createFor(AITaskType.class, "WATCH_CLOSEST");

    // SORTFIELDS:OFF

    private AITaskTypes() {
    }
}
