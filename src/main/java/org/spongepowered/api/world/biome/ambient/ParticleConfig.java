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
package org.spongepowered.api.world.biome.ambient;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.world.biome.Biome;

/**
 * The configuration for ambient particles in a {@link Biome}.
 */
public interface ParticleConfig {

    static ParticleConfig of(ParticleType type, float probability) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type, probability);
    }

    /**
     * Returns the probability
     *
     * @return The probability
     */
    float probability();

    /**
     * Returns the particle type.
     *
     * @return The particle type
     */
    ParticleType type();

    interface Factory {
        ParticleConfig of(ParticleType type, float probability);
    }
}
