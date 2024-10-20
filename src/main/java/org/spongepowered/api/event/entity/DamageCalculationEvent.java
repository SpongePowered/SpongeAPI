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
import org.spongepowered.api.event.cause.entity.damage.DamageStepType;
import org.spongepowered.api.event.impl.entity.AbstractDamageCalculationEventPre;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.world.difficulty.Difficulty;

import java.util.List;

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
 * simply an an attribute. Given that {@link Cause} has a unique capability of
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
     * Gets the original base damage to deal to the targeted {@link Entity}.
     *
     * @see #baseDamage()
     * @return The original base damage
     */
    double originalBaseDamage();

    /**
     * Gets the base damage to deal to the targeted {@link Entity}.
     * The base damage is the value before the calculation and its {@link DamageStep}s.
     *
     * @return The base damage
     */
    double baseDamage();

    /**
     * Fires before the damage steps and their side effects are applied.
     * The final damage is still unknown.
     */
    @ImplementedBy(AbstractDamageCalculationEventPre.class)
    interface Pre extends DamageCalculationEvent {

        /**
         * Sets the base damage to deal to the targeted {@link Entity}.
         *
         * @see #baseDamage()
         * @param baseDamage The base damage
         */
        void setBaseDamage(double baseDamage);

        /**
         * Gets a mutable list of all modifiers that applies just before the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        List<DamageModifier> modifiersBefore(DamageStepType type);

        /**
         * Gets a mutable list of all modifiers that applies just after the step.
         *
         * @param type The step type
         * @return The list of modifiers
         */
        List<DamageModifier> modifiersAfter(DamageStepType type);
    }

    /**
     * Fires after the damage steps and their side effects have been applied.
     * The steps have been captured and can't be changed.
     * The final damage can still be changed.
     */
    interface Post extends DamageCalculationEvent {

        /**
         * Gets the original final damage to deal to the targeted {@link Entity}.
         *
         * @see #finalDamage()
         * @return The final amount of damage to originally deal
         */
        double originalFinalDamage();

        /**
         * Gets the final damage to deal to the targeted {@link Entity}.
         * The final damage is the value after the calculation and its {@link DamageStep}s.
         * The final damage is the amount of health being lost by the {@link Entity}, if health is tracked.
         *
         * @return The final damage
         */
        double finalDamage();

        /**
         * Sets the final damage to deal to the targeted {@link Entity}.
         *
         * @see #finalDamage()
         * @param finalDamage The base damage
         */
        void setFinalDamage(double finalDamage);

        /**
         * Gets the list of the captured steps during the damage calculation in the order they have been applied.
         * Note that this list is not an exhaustive representation of all the operations applied,
         * especially in a modded environment.
         *
         * @return The list of steps
         */
        List<DamageStep> steps();
    }
}
