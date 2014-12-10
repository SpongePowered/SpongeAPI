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
package org.spongepowered.api.potion;

/**
 * Represents a builder interface to create a {@link PotionEffect}.
 */
public interface PotionEffectBuilder {

    /**
     * Sets the {@link PotionEffectType} of the potion.
     *
     * @param potionEffectType The type of item
     * @return This builder
     */
    PotionEffectBuilder potionType(PotionEffectType potionEffectType);

    /**
     * Sets the duration of the potion effect.
     *
     * @param duration The duration of this effect
     * @return This builder
     */
    PotionEffectBuilder duration(int duration);

    /**
     * Sets the amplifier power of the potion effect.
     *
     * <p>Amplifiers must be above zero.</p>
     *
     * @param amplifier The amplifier power
     * @return This builder
     * @throws IllegalArgumentException If the amplifier is less than zero
     */
    PotionEffectBuilder amplifier(int amplifier) throws IllegalArgumentException;

    /**
     * Sets the potion effect to be ambient or not.
     *
     * @param ambience Whether the potion effect is ambient
     * @return This builder
     */
    PotionEffectBuilder ambience(boolean ambience);

    /**
     * Sets the potion effect to show particles when applied or not.
     *
     * @param showsParticles Whether the potion effect will show particles
     * @return This builder
     */
    PotionEffectBuilder particles(boolean showsParticles);

    /**
     * Resets all information regarding the item stack to be created.
     *
     * @return This builder
     */
    PotionEffectBuilder reset();

    /**
     * Builds an instance of a PotionEffect.
     *
     * @return A new instance of a PotionEffect
     * @throws IllegalStateException If the potion effect is not completed
     */
    PotionEffect build() throws IllegalStateException;
    
}
