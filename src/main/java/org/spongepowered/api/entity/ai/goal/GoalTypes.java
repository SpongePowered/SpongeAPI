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
package org.spongepowered.api.entity.ai.goal;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.animal.horse.Horse;

import java.util.function.Predicate;
import java.util.function.Supplier;

public final class GoalTypes {

    // SORTFIELDS:ON

    /**
     * {@link Goal} where {@link Creature}s avoid other {@link Agent}s based on a {@link Predicate}.
     */
    public static final Supplier<GoalType> AVOID_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GoalType.class, "avoid_entity");

    /**
     * {@link Goal} where {@link Horse}s run around while {@link Humanoid}s attempt to tame them.
     */
    public static final Supplier<GoalType> RUN_AROUND_LIKE_CRAZY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GoalType.class, "run_around_like_crazy");

    /**
     * {@link Goal} where {@link Agent}s swim in liquids.
     */
    public static final Supplier<GoalType> SWIMMING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GoalType.class, "swimming");

    /**
     * {@link Goal} where {@link Creature}s walk around.
     */
    public static final Supplier<GoalType> WANDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GoalType.class, "wander");

    /**
     * {@link Goal} where {@link Agent}s will "watch" other {@link Entity}s.
     */
    public static final Supplier<GoalType> WATCH_CLOSEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GoalType.class, "watch_closest");

    // SORTFIELDS:OFF

    private GoalTypes() {
    }
}
