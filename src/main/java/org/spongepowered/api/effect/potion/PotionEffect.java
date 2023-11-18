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
package org.spongepowered.api.effect.potion;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.Ticks;

import java.util.function.Supplier;

/**
 * Represents an effect of a {@link PotionEffectType} for a specified
 * {@link #duration()}, {@link #amplifier()}, {@link #showsParticles()}
 * and {@link #showsIcon()}. The {@link PotionEffect} itself is immutable
 * once created and can be offered to {@link Entity} instances through
 * the {@link Keys#POTION_EFFECTS}.
 */
public interface PotionEffect extends DataSerializable {

    /**
     * Creates a new {@link Builder} to build a {@link PotionEffect}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Creates a new {@link PotionEffect} with the provided
     * {@link PotionEffectType}, the provided amplifier, and the provided
     * duration in ticks.
     *
     * @param type The potion type
     * @param amplifier The zero-indexed amplifier
     * @param duration The duration in ticks
     * @return The potion effect
     * @throws IllegalArgumentException If the duration is not positive
     */
    static PotionEffect of(final PotionEffectType type, final int amplifier, final Ticks duration) throws IllegalArgumentException {
        return PotionEffect.builder().potionType(type).amplifier(amplifier).duration(duration).build();
    }

    /**
     * Creates a new {@link PotionEffect} with the provided
     * {@link PotionEffectType}, the provided amplifier, and the provided
     * duration in ticks.
     *
     * @param type The potion type
     * @param amplifier The amplifier
     * @param duration The duration in ticks
     * @return The potion effect
     * @throws IllegalArgumentException If the duration is not positive
     */
    static PotionEffect of(final Supplier<? extends PotionEffectType> type, final int amplifier, final Ticks duration) throws IllegalArgumentException {
        return PotionEffect.builder().potionType(type).amplifier(amplifier).duration(duration).build();
    }

    /**
     * Gets the {@link PotionEffectType} of this potion.
     *
     * @return The type.
     */
    PotionEffectType type();

    /**
     * Gets the duration in ticks for which this potion effect
     * will apply for.
     *
     * @return The duration in ticks.
     */
    Ticks duration();

    /**
     * Gets the amplifier at which this potion effect
     * will apply effects.
     *
     * <p>A potion amplifier dictates the potion level <strong>as a zero based
     * index</strong>. An amplifier of zero will produce a potion effect of
     * level 1 (e.g. Strength I), while an amplifier of four will produce a
     * potion effect corresponding to a potion of level 4 (e.g. Strength V).</p>
     *
     * @return The amplifier as a zero-indexed integer.
     */
    int amplifier();

    /**
     * Gets whether or not this potion effect is an ambient effect.
     * Ambient potions emit more translucent particles.
     *
     * @return If the effect should be ambient.
     */
    boolean isAmbient();

    /**
     * Gets whether or not this potion effect is
     * showing particles.
     *
     * @return If particles should be shown.
     */
    boolean showsParticles();

    /**
     * Gets whether or not this potion effect is
     * showing its icon.
     *
     * @return If the icon should be shown.
     */
    boolean showsIcon();

    /**
     * Represents a builder interface to create a {@link PotionEffect}.
     */
    interface Builder extends org.spongepowered.api.util.Builder<PotionEffect, Builder>, CopyableBuilder<PotionEffect, Builder>,
            DataBuilder<PotionEffect> {

        /**
         * Sets the {@link PotionEffectType} of the potion.
         *
         * @param potionEffectType The type of item
         * @return This builder, for chaining
         */
        Builder potionType(PotionEffectType potionEffectType);

        /**
         * Sets the {@link PotionEffectType} of the potion.
         *
         * @param potionEffectType The type of item
         * @return This builder, for chaining
         */
        default Builder potionType(final Supplier<? extends PotionEffectType> potionEffectType) {
            return this.potionType(potionEffectType.get());
        }

        /**
         * Sets the duration in ticks of the potion effect.
         *
         * <p>The duration must be greater than zero ticks.</p>
         *
         * @param duration The duration in ticks of this effect
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the duration is less than or equal to zero
         */
        Builder duration(Ticks duration) throws IllegalArgumentException;

        /**
         * Sets the amplifier power of the potion effect.
         *
         * <p>See
         * {@link #amplifier()} for an explanation of what the amplifier means.
         * </p>
         *
         * @param amplifier The amplifier power
         * @return This builder, for chaining
         */
        Builder amplifier(int amplifier);

        /**
         * Sets whether the potion effect is ambient.
         * Ambient potions emit more translucent particles.
         *
         * @param ambient Whether the potion effect is ambient
         * @return This builder, for chaining
         */
        Builder ambient(boolean ambient);

        /**
         * Sets whether the potion effect should show particles when applied.
         *
         * @param showParticles Whether the potion effect will show particles
         * @return This builder, for chaining
         */
        Builder showParticles(boolean showParticles);

        /**
         * Sets whether the potion effect should show its icon when applied.
         *
         * @param showIcon Whether the potion effect will show its icon
         * @return This builder, for chaining
         */
        Builder showIcon(boolean showIcon);

        /**
         * Builds an instance of a PotionEffect.
         *
         * @return A new instance of a PotionEffect
         * @throws IllegalStateException If the potion effect is not completed
         */
        @Override
        PotionEffect build() throws IllegalStateException;
    }
}
