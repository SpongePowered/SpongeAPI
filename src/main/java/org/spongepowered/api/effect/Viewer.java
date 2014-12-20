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
package org.spongepowered.api.effect;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.item.ItemType;

/**
 * A Viewer is something that sees effects.
 * The Viewer class contains methods for spawning particles and playing sound effects.
 */
public interface Viewer {

    /**
     * Spawn some {@link Particle}s at a given position.
     * All players within a default radius around the position will see the
     * particles.
     *
     * @param particle The particle to create
     * @param particleCount The number of particle to create
     * @param position The position at which to create the particle
     * @param offset The offset to apply to each individual particle
     * @param speed The speed of the particle, must be at least 0
     */
    void spawnParticles(Particle particle, int particleCount, Vector3d position, Vector3d offset, double speed);

    /**
     * Spawn some {@link Particle}s at a given position.
     * All players within a given radius around the position will see the
     * particles.
     *
     * @param particle The particle to create
     * @param particleCount The number of particle to create
     * @param position The position at which to create the particle
     * @param offset The offset to apply to each individual particle
     * @param speed The speed of the particle, must be at least 0
     * @param radius The radius around the position where the particles can
     * be seen by players
     */
    void spawnParticles(Particle particle, int particleCount, Vector3d position, Vector3d offset, double speed, int radius);

    /**
     * Spawn some {@link Particle}s at a given position. All
     * players within a default radius around the position will see the particles.
     * <p>Some particles like {@link Particles#ITEM_CRACK},
     * {@link Particles#BLOCK_CRACK} and {@link Particles#BLOCK_DUST}
     * require the item type to render correctly.</p>
     *
     * @param particle The particle to create
     * @param particleCount The number of particle to create
     * @param position The position at which to create the particle
     * @param offset The offset to apply to each individual particle
     * @param speed The speed of the particle, must be at least 0
     * @param itemType The type of item the particle will base off from
     */
    void spawnParticles(Particle particle, int particleCount, Vector3d position, Vector3d offset, double speed, ItemType itemType);

    /**
     * Spawn some {@link Particle}s at a given position. All
     * players within a given radius around the position will see the particles.
     * <p>Some particles like {@link Particles#ITEM_CRACK},
     * {@link Particles#BLOCK_CRACK} and {@link Particles#BLOCK_DUST}
     * require the item type to render correctly.</p>
     *
     * @param particle The particle to create
     * @param particleCount The number of particle to create
     * @param position The position at which to create the particle
     * @param offset The offset to apply to each individual particle
     * @param speed The speed of the particle, must be at least 0
     * @param radius The radius around the position where the particles can
     * be seen by players
     * @param itemType The type of item the particle will base off from
     */
    void spawnParticles(Particle particle, int particleCount, Vector3d position, Vector3d offset, double speed, int radius, ItemType itemType);

    /**
     * Plays the given {@link Sound} at the given position. All
     * players within range will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     */
    void playSound(Sound sound, Vector3d position, double volume);

    /**
     * Plays the given {@link Sound} at the given position. All
     * players within range will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0 and 2
     */
    void playSound(Sound sound, Vector3d position, double volume, double pitch);

    /**
     * Plays the given {@link Sound} at the given position. All
     * players within range will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0 and 2
     * @param minVolume The minimum volume to play the sound at, usually between 0 and 2
     */
    void playSound(Sound sound, Vector3d position, double volume, double pitch, double minVolume);

}
