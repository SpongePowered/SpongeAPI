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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.goal.GoalExecutor;
import org.spongepowered.api.entity.ai.goal.GoalExecutorType;
import org.spongepowered.api.entity.ai.goal.builtin.creature.target.TargetGoal;
import org.spongepowered.api.item.inventory.ArmorEquipable;

import java.util.Optional;

/**
 * An Agent represents a {@link Living} that has AI. In the future Sponge will
 * allow for custom AIs, but for now vanilla behavior can only be disabled.
 */
public interface Agent extends Living, ArmorEquipable {

    /**
     * {@link Keys#TARGET_ENTITY}
     *
     * @return The targeted entity
     * @see TargetGoal
     */
    default Optional<Value.Mutable<Entity>> targetEntity() {
        return this.getValue(Keys.TARGET_ENTITY).map(Value::asMutable);
    }

    /**
     * {@link Keys#IS_AI_ENABLED}
     *
     * @return Whether AI modules are enabled on this entity or it's a "dumb" entity
     */
    default Value.Mutable<Boolean> aiEnabled() {
        return this.requireValue(Keys.IS_AI_ENABLED).asMutable();
    }

    /**
     * {@link Keys#DOMINANT_HAND}
     *
     * @return The dominant HandPreference of the agent
     */
    default Value.Mutable<HandPreference> dominantHand() {
        return this.requireValue(Keys.DOMINANT_HAND).asMutable();
    }

    /**
     * {@link Keys#IS_PERSISTENT}
     *
     * @return Whether the entity will be prevented from despawning
     */
    default Value.Mutable<Boolean> persistent() {
        return this.requireValue(Keys.IS_PERSISTENT).asMutable();
    }

    /**
     * {@link Keys#LEASH_HOLDER}
     *
     * @return The holder of the leashed agent
     */
    default Optional<Value.Mutable<Entity>> leashHolder() {
        return this.getValue(Keys.LEASH_HOLDER).map(Value::asMutable);
    }

    /**
     * Gets a {@link GoalExecutor} based on the {@link GoalExecutorType}.
     *
     * @param type GoalType to lookup
     * @param <T> Inferred agent type
     * @return The goal or {@link Optional#empty()} if not found.
     */
    <T extends Agent> Optional<GoalExecutor<T>> goal(GoalExecutorType type);
}
