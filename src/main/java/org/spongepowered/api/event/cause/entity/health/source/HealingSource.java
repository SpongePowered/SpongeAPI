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
package org.spongepowered.api.event.cause.entity.health.source;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.health.HealingType;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.difficulty.Difficulty;

/**
 * Represents a {@link Cause} for damage on the {@link Entity} being
 * healed. This will help inform what type of healing
 */
public interface HealingSource {

    /**
     * Creates a new {@link Builder} to construct a new {@link HealingSource}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link HealingType} for this source.
     *
     * @return The healing type for this source
     */
    HealingType getHealingType();

    /**
     * Gets whether this {@link HealingSource}'s healing amount is scaled by
     * {@link Difficulty}.
     *
     * @return True if the damage from this source is scaled
     */
    boolean isDifficultyScaled();

    /**
     * Gets whether this {@link HealingSource} is considered to be magical
     * healing, such as potions, or other sources.
     *
     * @return If this healing is magic based
     */
    boolean isMagic();

    /**
     * A builder to build {@link HealingSource} specifically.
     */
    interface Builder extends HealingSourceBuilder<HealingSource, Builder> {

    }

    /**
     * An abstract builder to build an extension of {@link HealingSource}.
     *
     * @param <T> The type of HealingSource
     * @param <B> The builder type
     */
    interface HealingSourceBuilder<T extends HealingSource, B extends HealingSourceBuilder<T, B>> extends ResettableBuilder<T, B> {

        /**
         * Sets for the built {@link HealingSource} to have scaled with
         * difficulty, usually meaning that the amount is scaled.
         *
         * @return This builder, for chaining
         */
        B scalesWithDifficulty();

        /**
         * Sets that the built {@link HealingSource} to have been a "magical"
         * source.
         *
         * @return This builder, for chaining
         */
        B magical();

        /**
         * Sets the {@link HealingType}.
         *
         * @param healingType The healing type
         * @return This builder, for chaining
         */
        B type(HealingType healingType);

        T build() throws IllegalStateException;

    }
}
