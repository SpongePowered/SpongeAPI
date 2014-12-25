/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import java.util.List;

import com.google.common.base.Optional;

public interface ParticleFactory {

    /**
     * Gets the particle type from it's name.
     * 
     * @param name The name
     * @return The particle type or Optional.absent() if not found
     */
    Optional<Particle> getFromName(String name);

    /**
     * Gets a list with all the particle types.
     * 
     * @return The particle types
     */
    List<Particle> getParticles();

    /**
     * Gets a new particle builder for the particle type.
     * 
     * @param particle The particle type
     * @return The builder
     */
    ParticleEffectBuilder newBuilder(Particle particle);

    /**
     * Gets a new particle builder for the particle type.
     * 
     * @param particle The particle type
     * @return The builder
     */
    ParticleEffectBuilder.Colorable newBuilder(Particle.Colorable particle);

    /**
     * Gets a new particle builder for the particle type.
     * 
     * @param particle The particle type
     * @return The builder
     */
    ParticleEffectBuilder.Material newBuilder(Particle.Material particle);

    /**
     * Gets a new particle builder for the particle type.
     * 
     * @param particle The particle type
     * @return The builder
     */
    ParticleEffectBuilder.Note newBuilder(Particle.Note particle);

    /**
     * Gets a new particle builder for the particle type.
     * 
     * @param particle The particle type
     * @return The builder
     */
    ParticleEffectBuilder.Resizable newBuilder(Particle.Resizable particle);

}