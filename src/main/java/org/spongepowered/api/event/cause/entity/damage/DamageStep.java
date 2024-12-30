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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.event.Cause;

import java.util.List;

/**
 * Represents a step in the damage calculation.
 */
public interface DamageStep {

    /**
     * Gets the {@link DamageStepType} for this {@link DamageStep}.
     *
     * @return The damage step type
     */
    DamageStepType type();

    /**
     * Gets the cause of this {@link DamageStep}.
     *
     * @return The cause of this step
     */
    Cause cause();

    /**
     * Gets whether this step is skipped.
     * When skipped, only the step and its side effects are ignored, modifiers are still applied.
     * A modifier willing to ignore every previous modifiers should revert the damage to {@link #damageBeforeModifiers()}.
     *
     * @return Whether this step is skipped
     */
    boolean isSkipped();

    /**
     * Sets whether this step is skipped.
     *
     * @see #isSkipped()
     * @throws IllegalStateException if called after the step has finished.
     */
    void setSkipped(boolean skipped);

    /**
     * Skips this step.
     *
     * @see #isSkipped()
     * @throws IllegalStateException if called after the step has finished.
     */
    default void skip() {
        this.setSkipped(true);
    }

    /**
     * The damage just before the modifiers of this step.
     *
     * @return The damage before this step
     */
    double damageBeforeModifiers();

    /**
     * The damage just before this step.
     *
     * @return The damage before this step
     * @throws IllegalStateException if called before the "before" modifiers have finished.
     */
    double damageBeforeStep();

    /**
     * The damage just after this step.
     *
     * @return The damage after this step
     * @throws IllegalStateException if called before this step has finished
     */
    double damageAfterStep();

    /**
     * The damage just after the modifiers of this step.
     *
     * @return The damage after this step
     * @throws IllegalStateException if called before the modifiers have finished.
     */
    double damageAfterModifiers();

    /**
     * Gets an immutable list of all modifiers that applies just before this step.
     *
     * @return The list of modifiers
     */
    List<DamageModifier> modifiersBefore();

    /**
     * Gets an immutable list of all modifiers that applies just after this step.
     *
     * @return The list of modifiers
     */
    List<DamageModifier> modifiersAfter();
}
