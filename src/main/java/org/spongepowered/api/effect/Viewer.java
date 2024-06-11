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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.sound.Sound;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.WorldTypes;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

/**
 * A Viewer is something that sees effects.
 * E.g. the Viewer class contains methods for spawning particles and playing
 * sound effects.
 */
public interface Viewer extends Audience {

    /**
     * Sends the effect of being in a particular world environment, such as the Nether,
     * as an effect to the viewer.
     *
     * <p>For example, specifying {@link WorldTypes#THE_NETHER} will create an empty skybox
     * and hazy fog on the vanilla minecraft client</p>
     *
     * @param worldType The world type
     */
    void sendWorldType(WorldType worldType);

    /**
     * Spawn the given {@link ParticleEffect} at the given position.
     *
     * @param particleEffect The particle effect to spawn
     * @param position The position
     */
    default void spawnParticles(final ParticleEffect particleEffect, final Vector3d position) {
        Objects.requireNonNull(position, "position");
        this.spawnParticles(particleEffect, position.x(), position.y(), position.z());
    }

    /**
     * Spawn the given {@link ParticleEffect} at the given position.
     *
     * @param particleEffect The particle effect to spawn
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    void spawnParticles(ParticleEffect particleEffect, double x, double y, double z);

    /**
     * Plays the given {@link Sound} at the given position.
     *
     * @param sound The sound
     * @param position The position
     */
    default void playSound(final @NonNull Sound sound, final Vector3d position) {
        Objects.requireNonNull(position, "position");
        this.playSound(sound, position.x(), position.y(), position.z());
    }

    /**
     * Plays the given {@link MusicDisc} at the given position. The benefit of playing
     * {@link MusicDisc} instead of a {@link SoundType} allows you to stop them through
     * the {@link #stopMusicDisc(Vector3i)}. Playing a new {@link MusicDisc} at the same
     * position will cancel the currently playing one.
     *
     * @param position The position
     * @param musicDisc The music disc
     */
    default void playMusicDisc(final Vector3i position, final MusicDisc musicDisc) {
        Objects.requireNonNull(position, "position");
        this.playMusicDisc(position.x(), position.y(), position.z(), musicDisc);
    }

    /**
     * Plays the given {@link MusicDisc} at the given position. The benefit of playing
     * {@link MusicDisc} instead of a {@link SoundType} allows you to stop them through
     * the {@link #stopMusicDisc(Vector3i)}. Playing a new {@link MusicDisc} at the same
     * position will cancel the currently playing one.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param musicDisc The music disc
     */
    void playMusicDisc(int x, int y, int z, MusicDisc musicDisc);

    /**
     * Stops the {@link MusicDisc} that is playing at the given position.
     *
     * @param position The position
     */
    default void stopMusicDisc(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        this.stopMusicDisc(position.x(), position.y(), position.z());
    }

    /**
     * Stops the {@link MusicDisc} that is playing at the given position.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    void stopMusicDisc(int x, int y, int z);

    /**
     * Sends a client-only block change.
     *
     * <p>This will not change the {@link World} in any way.</p>
     *
     * @param position The position
     * @param state The block state
     */
    default void sendBlockChange(final Vector3i position, final BlockState state) {
        Objects.requireNonNull(position, "position");
        this.sendBlockChange(position.x(), position.y(), position.z(), state);
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
     * @param position The position
     */
    default void resetBlockChange(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        this.resetBlockChange(position.x(), position.y(), position.z());
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
