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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a particle effect that can be send to the Minecraft client.
 */
public interface ParticleEffect {

    /**
     * Creates a new {@link Builder} to build a {@link ParticleEffect}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Gets the type of the particle effect.
     *
     * @return The particle type
     */
    ParticleType getType();

    /**
     * Gets the motion vector of the particle effect.
     *
     * @return The motion vector
     */
    Vector3d getMotion();

    /**
     * Gets the offset vector of the particle effect.
     *
     * @return The offset vector
     */
    Vector3d getOffset();

    /**
     * Gets the amount of particles that will be spawned.
     *
     * @return The count of particles
     */
    int getCount();

    /**
     * Represents a builder to create a {@link ParticleEffect}.
     */
    interface Builder extends ParticleBuilder<ParticleEffect, ParticleType, Builder> {

    }

    /**
     * An inherently abstract builder for building a particular type of
     * {@link ParticleEffect}.
     *
     * @param <P> The type of the particle effect
     * @param <T> The type of particle type
     * @param <B> The self referencing builder
     */
    interface ParticleBuilder<P extends ParticleEffect,T extends ParticleType, B extends ParticleBuilder<P,T, B>> extends ResettableBuilder<P, B> {

        /**
         * Sets the particle type for the particle effect.
         *
         * @param particleType The particle type
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the particle type is not
         *     compatible with this builder
         */
        B type(T particleType);

        /**
         * Sets the motion vector of the particle effect.
         *
         * <p>The default motion vector is {@link Vector3d#ZERO}.</p>
         *
         * @param motion The motion vector
         * @return This builder, for chaining
         */
        B motion(Vector3d motion);

        /**
         * Sets the offset vector of the particle effect.
         *
         * <p>The default offset vector is {@link Vector3d#ZERO}.</p>
         *
         * @param offset The offset vector
         * @return This builder, for chaining
         */
        B offset(Vector3d offset);

        /**
         * Sets the amount of particles of the particle effect.
         *
         * <p>The default count is 1.</p>
         *
         * @param count The count particles
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the count is less than one
         */
        B count(int count) throws IllegalArgumentException;

        /**
         * Builds an instance of a ParticleEffect.
         *
         * @return A new instance of a ParticleEffect
         */
        P build();
    }
}
