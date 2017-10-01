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
package org.spongepowered.api.block;

import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.living.Living;

/**
 * Represents sounds for a block.
 */
public interface BlockSoundGroup {

    /**
     * Gets the volume used when playing sounds.
     *
     * @return The volume
     */
    double getVolume();

    /**
     * Gets the pitch used when playing sounds.
     *
     * @return The pitch
     */
    double getPitch();

    /**
     * Gets the sound played when the block is breaking.
     *
     * @return The break sound
     */
    SoundType getBreakSound();

    /**
     * Gets the sound played when the block is stepped on.
     *
     * @return The step sound
     */
    SoundType getStepSound();

    /**
     * Gets the sound played when the block is placed.
     *
     * @return The place sound
     */
    SoundType getPlaceSound();

    /**
     * Gets the sound played when the block is hit.
     *
     * @return The hit sound
     */
    SoundType getHitSound();

    /**
     * Gets the sound played when a {@link Living} entity falls onto the block.
     *
     * @return The fall sound
     */
    SoundType getFallSound();
}
