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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.DamageStep;
import org.spongepowered.api.event.cause.entity.damage.DamageStepHistory;
import org.spongepowered.api.event.cause.entity.damage.DamageStepType;
import org.spongepowered.api.event.cause.entity.damage.DamageStepTypes;
import org.spongepowered.api.event.impl.entity.AbstractDamageCalculationEventPre;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.eventgen.annotations.ImplementedBy;

import java.util.List;
import java.util.function.Supplier;

/**
 * The base event for when some damage is calculated,
 * whether it is the damage output of an attack, or the damage inflicted to an entity.
 *
 * <p>The damage calculation starts with a base damage which is modified
 * by a series of operations to obtain a final value.
 * Some of these operations are captured as {@link DamageStep}s and are modifiable.</p>
 *
 * <p>Optimally, these steps can be traced to a
 * particular object, be it an {@link ItemStack}, {@link Difficulty}, or
 * simply an attribute. Given that {@link Cause} has a unique capability of
 * storing any and every {@link Object} willing to be passed into it, we
 * can easily represent these "sources" of "steps" in a {@link Cause}.
 * Now, knowing the "source" will not provide enough information, so a
 * {@link DamageStepType} is provided with a {@link DamageStep} to
 * paint the fullest picture of "explaining" the {@link DamageStep} as to
 * why it is present, and why it is modifying the base damage.</p>
 */
public interface DamageCalculationEvent extends Event, Cancellable {

    /**
     * Gets the targeted {@link Entity}.
     *
     * @return The targeted entity
     */
    Entity entity();

    /**
     * Gets the base damage to deal to the targeted {@link Entity}.
     * The base damage is the value before the calculation and its {@link DamageStep}s.
     * To modify the base damage, add a modifier to the step associated to {@link DamageStepTypes#START}.
     *
     * @return The base damage
     */
    double baseDamage();

    /**
     * Fires before the damage steps and their side effects are applied.
     */
    @ImplementedBy(AbstractDamageCalculationEventPre.class)
    interface Pre extends DamageCalculationEvent {

        /**
         * Gets an unmodifiable list of all modifiers that applies just before the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        default List<DamageModifier> modifiersBefore(Supplier<DamageStepType> type) {
            return this.modifiersBefore(type.get());
        }

        /**
         * Gets an unmodifiable list of all modifiers that applies just before the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        List<DamageModifier> modifiersBefore(DamageStepType type);

        /**
         * Adds a modifier that applies just before the step.
         *
         * @param type The step type
         * @param modifier The modifier
         */
        default void addModifierBefore(Supplier<DamageStepType> type, DamageModifier modifier) {
            this.addModifierBefore(type.get(), modifier);
        }

        /**
         * Adds a modifier that applies just before the step.
         *
         * @param type The step type
         * @param modifier The modifier
         */
        void addModifierBefore(DamageStepType type, DamageModifier modifier);

        /**
         * Gets an unmodifiable list of all modifiers that applies just after the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        default List<DamageModifier> modifiersAfter(Supplier<DamageStepType> type) {
            return this.modifiersAfter(type.get());
        }

        /**
         * Gets an unmodifiable list of all modifiers that applies just after the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        List<DamageModifier> modifiersAfter(DamageStepType type);

        /**
         * Adds a modifier that applies just after the step.
         *
         * @param type The step type
         * @param modifier The modifier
         */
        default void addModifierAfter(Supplier<DamageStepType> type, DamageModifier modifier) {
            this.addModifierAfter(type.get(), modifier);
        }

        /**
         * Adds a modifier that applies just after the step.
         *
         * @param type The step type
         * @param modifier The modifier
         */
        void addModifierAfter(DamageStepType type, DamageModifier modifier);
    }

    /**
     * Fires after the damage steps and their side effects have been applied.
     * The steps have been captured and can't be changed.
     */
    interface Post extends DamageCalculationEvent {

        /**
         * Gets the final damage to deal to the targeted {@link Entity}.
         * The final damage is the value after the calculation and its {@link DamageStep}s.
         * The final damage is the amount of health being lost by the {@link Entity}, if health is tracked.
         * To modify the final damage, add a modifier to the step associated to {@link DamageStepTypes#END}.
         *
         * @return The final damage
         */
        double finalDamage();

        /**
         * Gets the {@link DamageStepHistory} of this damage calculation.
         *
         * @return The history.
         */
        DamageStepHistory history();
    }
}
