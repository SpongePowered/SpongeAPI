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
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.world.biome.Biome;

/**
 * A configuration for {@link SoundType sounds} playing in a {@link Biome}.
 */
public interface SoundConfig {

    static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    /**
     * Returns the sound to play.
     *
     * @return The sound
     */
    SoundType sound();

    /**
     * The mood configuration.
     */
    interface Mood extends SoundConfig {

        /**
         * Returns the tick delay.
         *
         * @return the tick delay
         */
        int tickDelay();

        /**
         * Returns the search range radius for mood increase
         *
         * @return The search range radius
         */
        int searchRadius();

        /**
         * Returns the distance modifier for playing the mood sound.
         * <p>The sound is played that many blocks farther away.</p>
         *
         * @return The distance modifier
         */
        double distanceModifier();
    }

    /**
     * The additional sound configuration.
     */
    interface Additional extends SoundConfig  {

        /**
         * Returns the chance to play the additional each tick.
         *
         * @return The chance
         */
        double tickChance();
    }

    /**
     * The background music configuration.
     */
    interface BackgroundMusic extends SoundConfig  {

        /**
         * Returns the mininum delay until the next song starts.
         *
         * @return The mininum delay.
         */
        int minDelay();

        /**
         * Returns the maximum delay until the next song starts.
         *
         * @return The maximum delay.
         */
        int maxDelay();

        /**
         * Returns whether the current music is replaced by the {@link Biome} music.
         *
         * @return Whether the current music is replaced.
         */
        boolean replacesCurrent();
    }

    interface Factory {

        SoundConfig.Mood ofAmbientMood(SoundType sound, int tickDelay, int searchRadius, double distanceModifier);

        SoundConfig.Additional ofAdditional(SoundType sound, double tickChance);

        SoundConfig.BackgroundMusic ofBackroundMusic(SoundType sound, int minDelay, int maxDelay, boolean replacesCurrent);

    }

}
