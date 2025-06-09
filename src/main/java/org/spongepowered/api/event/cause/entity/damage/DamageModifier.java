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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.CauseStackManager;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * A damage modifier that will create a {@link DamageStep}.
 */
public interface DamageModifier {

    /**
     * Gets the {@link DamageStepType} of this modifier.
     *
     * @return the step type
     */
    DamageStepType type();

    /**
     * Gets the consumer that will modify the cause frame.
     *
     * @return The cause frame modifier
     */
    Optional<Consumer<CauseStackManager.StackFrame>> frameModifier();

    /**
     * Gets the function that will modify the damage.
     * The function may be absent if the sole purpose of this modifier is to apply children steps.
     *
     * @return the damage modifier
     */
    Optional<Function> damageFunction();

    @FunctionalInterface
    interface Function {
        /**
         * Modifies the damage.
         *
         * @param step   The damage step this modifier is associated with.
         * @param damage The current damage value.
         * @return The next damage value
         */
        double modify(DamageStep step, double damage);
    }

    /**
     * Creates a new {@link Builder} to create {@link DamageModifier}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * A builder to create {@link DamageModifier}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<DamageModifier, Builder> {

        /**
         * Sets the {@link DamageStepType} for this modifier.
         *
         * @param type The damage step type
         * @return this builder for chaining
         */
        Builder type(DamageStepType type);

        /**
         * Sets the cause frame modifier.
         *
         * @param frameModifier The frame modifier
         * @return this builder for chaining
         */
        Builder frameModifier(Consumer<CauseStackManager.StackFrame> frameModifier);

        /**
         * Sets the {@link Function} for this modifier.
         *
         * @param function The damage function
         * @return this builder for chaining
         */
        Builder damageFunction(Function function);
    }
}
