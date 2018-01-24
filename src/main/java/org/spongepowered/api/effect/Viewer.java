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
package org.spongepowered.api.effect;

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.SoundCategories;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.record.RecordType;
import org.spongepowered.api.text.BookView;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.world.World;

/**
 * A Viewer is something that sees effects.
 * The Viewer class contains methods for spawning particles and playing sound
 * effects.
 */
public interface Viewer {

    /**
     * Spawn a {@link ParticleEffect} at a given position.
     * All players within a default radius around the position will see the
     * particles.
     *
     * @param particleEffect The particle effect to spawn
     * @param position The position at which to spawn the particle effect
     */
    void spawnParticles(ParticleEffect particleEffect, Vector3d position);

    /**
     * Spawn a {@link ParticleEffect} at a given position.
     * All players within a given radius around the position will see the
     * particles.
     *
     * @param particleEffect The particle effect to spawn
     * @param position The position at which to spawn the particle effect
     * @param radius The radius around the position where the particles can be
     *            seen by players
     */
    void spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius);

    /**
     * Plays the given {@link SoundType} at the given position, with the
     * category {@link SoundCategories#MASTER}. All players within range
     * will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     */
    default void playSound(SoundType sound, Vector3d position, double volume) {
        this.playSound(sound, SoundCategories.MASTER, position, volume);
    }

    /**
     * Plays the given {@link SoundType} at the given position. All
     * players within range will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param category The category to play the sound with
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     */
    void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume);

    /**
     * Plays the given {@link SoundType} at the given position, with the
     * category {@link SoundCategories#MASTER}. All players within range
     * will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0
     *        and 2
     */
    default void playSound(SoundType sound, Vector3d position, double volume, double pitch) {
        this.playSound(sound, SoundCategories.MASTER, position, volume, pitch);
    }

    /**
     * Plays the given {@link SoundType} at the given position, with the
     * category {@link SoundCategories#MASTER}. All players within range
     * will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param category The category to play the sound with
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0
     *        and 2
     */
    void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch);

    /**
     * Plays the given {@link SoundType} at the given position, with the
     * category {@link SoundCategories#MASTER}. All players within range
     * will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0
     *        and 2
     * @param minVolume The minimum volume to play the sound at, usually between
     *        0 and 2
     */
    default void playSound(SoundType sound, Vector3d position, double volume, double pitch, double minVolume) {
        this.playSound(sound, SoundCategories.MASTER, position, volume, pitch, minVolume);
    }

    /**
     * Plays the given {@link SoundType} at the given position. All
     * players within range will hear the sound with the given volume.
     *
     * @param sound The sound to play
     * @param category The category to play the sound with
     * @param position The position to play the sound
     * @param volume The volume to play the sound at, usually between 0 and 2
     * @param pitch The modulation of the sound to play at, usually between 0
     *        and 2
     * @param minVolume The minimum volume to play the sound at, usually between
     *        0 and 2
     */
    void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch, double minVolume);

    /**
     * Stops all the sounds.
     */
    void stopSounds();

    /**
     * Stops all the sounds of the given {@link SoundType}.
     *
     * @param sound The sound type
     */
    void stopSounds(SoundType sound);

    /**
     * Stops all the sounds that are played in the
     * given {@link SoundCategory}.
     *
     * @param category The sound category
     */
    void stopSounds(SoundCategory category);

    /**
     * Stops all the sounds of the given {@link SoundType} that
     * are played in the given {@link SoundCategory}.
     *
     * @param sound The sound type
     * @param category The sound category
     */
    void stopSounds(SoundType sound, SoundCategory category);

    /**
     * Plays the given {@link RecordType} at the given position. The benefit of playing
     * {@link RecordType} instead of a {@link SoundType} allows you to stop them through
     * the {@link #stopRecord(Vector3i)}. Playing a new {@link RecordType} at the same
     * position will cancel the currently playing one.
     *
     * @param position The position
     * @param recordType The record type
     */
    void playRecord(Vector3i position, RecordType recordType);

    /**
     * Stops the record that is playing at the given position.
     *
     * @param position The position
     */
    void stopRecord(Vector3i position);

    /**
     * Sends a {@link Title} to this player.
     *
     * @param title The {@link Title} to send to the player
     */
    void sendTitle(Title title);

    /**
     * Removes the currently displayed {@link Title} from the player and resets
     * all settings back to default values.
     */
    default void resetTitle() {
        sendTitle(Title.RESET);
    }

    /**
     * Removes the currently displayed {@link Title} from the player's screen.
     */
    default void clearTitle() {
        sendTitle(Title.CLEAR);
    }

    /**
     * Sends a {@link BookView} to this viewer.
     *
     * @param bookView BookView to send
     */
    void sendBookView(BookView bookView);

    /**
     * Sends a client-only block change.
     *
     * <p>This will not change the {@link World} in any way.</p>
     *
     * @param vec The position
     * @param state The block state
     */
    default void sendBlockChange(Vector3i vec, BlockState state) {
        checkNotNull(vec, "vec");
        this.sendBlockChange(vec.getX(), vec.getY(), vec.getZ(), state);
    }

    /**
     * Sends a client-only block change.
     *
     * <p>This will not change the {@link World} in any way.</p>
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param state The block state
     */
    void sendBlockChange(int x, int y, int z, BlockState state);

    /**
     * Resets the client's view of the provided position to what
     * actually exists in the {@link World}.
     *
     * <p>This is useful for resetting what the client sees
     * after sending a {@link #sendBlockChange block change}.</p>
     *
     * @param vec The position
     */
    default void resetBlockChange(Vector3i vec) {
        checkNotNull(vec, "vec");
        this.resetBlockChange(vec.getX(), vec.getY(), vec.getZ());
    }

    /**
     * Resets the client's view of the provided position to what
     * actually exists in the {@link World}.
     *
     * <p>This is useful for resetting what the client sees
     * after sending a {@link #sendBlockChange block change}.</p>
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    void resetBlockChange(int x, int y, int z);

}
