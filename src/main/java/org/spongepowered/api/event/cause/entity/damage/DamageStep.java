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

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

/**
 * A step represent an operation made by the platform (vanilla and mods) or modifiers added by plugins.
 * Steps are structured as trees where children modify the input or output of the parent step.
 * A damage calculation is made of multiple trees of steps.
 */
public interface DamageStep {

    /**
     * Gets the {@link DamageStepType} of this step.
     *
     * @return the step type
     */
    DamageStepType type();

    /**
     * Gets the {@link Cause} of this step.
     *
     * @return The cause of this step
     */
    Cause cause();

    /**
     * Gets whether this step is skipped.
     * When skipped, only the step itself and its side effects are ignored, children are still applied.
     * A modifier willing to ignore every previous children should revert the damage to {@link #damageBeforeChildren()},
     * or call {@link #skip} on each child.
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
     * Sets whether parts of this step are skipped.
     * This has no effect on steps already finished.
     *
     * @see #isSkipped()
     */
    default void trySetSkipped(Set<Part> parts, boolean skipped) {
        if (parts.contains(Part.CHILDREN_BEFORE) && this.damageBeforeSelf().isEmpty()) {
            for (DamageStep child : this.childrenBefore()) {
                child.trySetSkipped(Part.ALL, skipped);
            }
        }
        if (parts.contains(Part.SELF) && this.damageAfterSelf().isEmpty()) {
            this.setSkipped(skipped);
        }
        if (parts.contains(Part.CHILDREN_AFTER) && this.damageAfterChildren().isEmpty()) {
            for (DamageStep child : this.childrenAfter()) {
                child.trySetSkipped(Part.ALL, skipped);
            }
        }
    }

    /**
     * Skips parts of this step.
     * This has no effect on steps already finished.
     *
     * @see #isSkipped()
     */
    default void trySkip(Set<Part> parts) {
        this.trySetSkipped(parts, true);
    }

    /**
     * The damage just before the children of this step.
     * Returns empty if the value is not known yet.
     *
     * @return The damage before the children of this step
     */
    OptionalDouble damageBeforeChildren();

    /**
     * The damage just before this step.
     * Returns empty if the value is not known yet.
     *
     * @return The damage before this step
     */
    OptionalDouble damageBeforeSelf();

    /**
     * The damage just after this step.
     * Returns empty if the value is not known yet.
     *
     * @return The damage after this step
     */
    OptionalDouble damageAfterSelf();

    /**
     * The damage just after the children of this step.
     * Returns empty if the value is not known yet.
     *
     * @return The damage after this step
     */
    OptionalDouble damageAfterChildren();

    /**
     * Gets the {@link DamageStepHistory} this step belongs to.
     *
     * @return The history containing this step.
     */
    DamageStepHistory history();

    /**
     * Gets the parent of this step.
     * Returns empty if this step is the root of its tree.
     *
     * @return The parent of this step
     */
    Optional<DamageStep> parent();

    /**
     * Gets the root of this step.
     *
     * @return The root of this step
     */
    default DamageStep root() {
        DamageStep step = this;
        Optional<DamageStep> parent;
        while ((parent = step.parent()).isPresent()) {
            step = parent.get();
        }
        return step;
    }

    /**
     * Gets an immutable list of all children steps that applies just before this step.
     *
     * @return The list of children steps
     */
    List<DamageStep> childrenBefore();

    /**
     * Gets an immutable list of all children steps that applies just after this step.
     *
     * @return The list of children steps
     */
    List<DamageStep> childrenAfter();

    /**
     * The parts composing a step.
     */
    enum Part {
        SELF, CHILDREN_BEFORE, CHILDREN_AFTER;

        public static final EnumSet<Part> ALL = EnumSet.allOf(Part.class);
    }
}
