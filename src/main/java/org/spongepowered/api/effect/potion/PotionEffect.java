/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

public interface PotionEffect {

    /**
     * Gets the {@link org.spongepowered.api.effect.potion.EffectType} for this potion effect
     *
     * @return The effect
     */
    EffectType getType();

    /**
     * Gets the potion effect duration in ticks (1/20 sec)
     *
     * @return The duration
     */
    int getDuration();

    /**
     * Gets the potion effect power
     *
     * @return The power
     */
    int getPower();

    /**
     * Gets if the particles are enabled
     *
     * @return
     */
    boolean hasParticles();

    /**
     * Sets the duration of the potion effect to the new duration
     *
     * @param duration The duration in ticks (1/20 sec)
     */
    void setDuration(int duration);

    /**
     * Sets the potion effect power
     *
     * @param power The power
     */
    void setPower(int power);

    /**
     * Sets the particle state of {@link org.spongepowered.api.effect.potion.PotionEffect}
     *
     * @param particles The particles
     */
    void setParticles(boolean particles);
}
