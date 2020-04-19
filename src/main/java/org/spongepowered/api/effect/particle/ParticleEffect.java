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
package org.spongepowered.api.effect.particle;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.math.vector.Vector3d;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a particle effect that can be send to the Minecraft client.
 */
public interface ParticleEffect extends DataSerializable {

    /**
     * Creates a new {@link Builder} to build a {@link ParticleEffect}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the type of the particle effect.
     *
     * @return The particle type
     */
    ParticleType getType();

    /**
     * Gets the value for the specified {@link ParticleOption}.
     *
     * @param option The particle option
     * @param <V> The value type
     * @return The option value if present, otherwise {@link Optional#empty()}
     */
    default <V> Optional<V> getOption(Supplier<? extends ParticleOption<V>> option) {
        return this.getOption(option.get());
    }

    /**
     * Gets the value for the specified {@link ParticleOption}.
     *
     * @param option The particle option
     * @param <V> The value type
     * @return The option value if present, otherwise {@link Optional#empty()}
     */
    <V> Optional<V> getOption(ParticleOption<V> option);

    /**
     * Gets the value for the specified {@link ParticleOption} or
     * the default value if not present.
     *
     * @param option The particle option
     * @param <V> The value type
     * @return The option value if present, otherwise {@link Optional#empty()}
     */
    default <V> Optional<V> getOptionOrDefault(Supplier<? extends ParticleOption<V>> option) {
        return this.getOptionOrDefault(option.get());
    }

    /**
     * Gets the value for the specified {@link ParticleOption} or
     * the default value if not present.
     *
     * @param option The particle option
     * @param <V> The value type
     * @return The option value if present, otherwise {@link Optional#empty()}
     */
    default <V> Optional<V> getOptionOrDefault(ParticleOption<V> option) {
        final Optional<V> value = this.getOption(option);
        return value.isPresent() ? value : this.getType().getDefaultOption(option);
    }

    /**
     * Gets a immutable {@link Map} with all the available
     * {@link ParticleOption}s and their values.
     *
     * @return The default options
     */
    Map<ParticleOption<?>, Object> getOptions();

    /**
     * Represents a builder to create a {@link ParticleEffect}.
     */
    interface Builder extends CopyableBuilder<ParticleEffect, Builder>, DataBuilder<ParticleEffect> {

        /**
         * Sets the particle type for the particle effect.
         *
         * @param particleType The particle type
         * @return This builder for chaining
         */
        Builder type(ParticleType particleType);

        /**
         * Sets the particle type for the particle effect.
         *
         * @param particleType The particle type
         * @return This builder for chaining
         */
        default Builder type(Supplier<? extends ParticleType> particleType) {
            return this.type(particleType.get());
        }

        /**
         * Sets the value of the specified {@link ParticleOption}.
         *
         * @param option The option
         * @param value The value
         * @param <V> The type of option value
         * @return This builder for chaining
         * @throws IllegalArgumentException If the specified value isn't valid
         */
        <V> Builder option(ParticleOption<V> option, V value) throws IllegalArgumentException;

        /**
         * Sets the value of the specified {@link ParticleOption}.
         *
         * @param option The option
         * @param value The value
         * @param <V> The type of option value
         * @return This builder for chaining
         * @throws IllegalArgumentException If the specified value isn't valid
         */
        default <V> Builder option(Supplier<? extends ParticleOption<V>> option, V value) throws IllegalArgumentException {
            return this.option(option.get(), value);
        }

        /**
         * Sets the velocity of the particle effect.
         *
         * <p>The default velocity is {@link Vector3d#ZERO}.</p>
         *
         * @param velocity The velocity
         * @return This builder for chaining
         */
        default Builder velocity(Vector3d velocity) {
            return this.option(ParticleOptions.VELOCITY, velocity);
        }

        /**
         * Sets the offset of the particle effect.
         *
         * <p>The default offset is {@link Vector3d#ZERO}.</p>
         *
         * @param offset The offset
         * @return This builder for chaining
         */
        default Builder offset(Vector3d offset) {
            return this.option(ParticleOptions.OFFSET, offset);
        }

        /**
         * Sets the amount of particles of the particle effect.
         *
         * <p>The default quantity is 1.</p>
         *
         * @param quantity The quantity particles
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the quantity is less than one
         */
        default Builder quantity(int quantity) throws IllegalArgumentException {
            return this.option(ParticleOptions.QUANTITY, quantity);
        }

        /**
         * Builds an instance of a ParticleEffect.
         *
         * @return A new instance of a ParticleEffect
         */
        ParticleEffect build();
    }
}
