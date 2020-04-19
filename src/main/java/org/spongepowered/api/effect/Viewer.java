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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.text.BookView;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.world.World;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.function.Supplier;

/**
 * A Viewer is something that sees effects.
 * The Viewer class contains methods for spawning particles and playing sound
 * effects.
 */
public interface Viewer {

    /**
     * Plays the effect at the given position.
     *
     * @param effect The effect to play
     * @param position The position
     */
    void play(PlayableEffect effect, Vector3d position);

    /**
     * Plays the effect at the given position. The effect will only be
     * visible if it's within the given radius to the viewer.
     *
     * @param effect The effect to play
     * @param position The position
     */
    void playWithinRadius(PlayableEffect effect, Vector3d position, double radius);

    /**
     * Plays the given {@link MusicDisc} at the given position. The benefit of playing
     * {@link MusicDisc} instead of a {@link SoundType} allows you to stop them through
     * the {@link #stopMusicDisc(Vector3i)}. Playing a new {@link MusicDisc} at the same
     * position will cancel the currently playing one.
     *
     * @param position The position
     * @param musicDiscType The music disc
     */
    void playMusicDisc(Vector3i position, MusicDisc musicDiscType);

    /**
     * Plays the given {@link MusicDisc} at the given position. The benefit of playing
     * {@link MusicDisc} instead of a {@link SoundType} allows you to stop them through
     * the {@link #stopMusicDisc(Vector3i)}. Playing a new {@link MusicDisc} at the same
     * position will cancel the currently playing one.
     *
     * @param position The position
     * @param musicDiscType The music disc
     */
    void playMusicDisc(Vector3i position, Supplier<? extends MusicDisc> musicDiscType);

    /**
     * Stops the {@link MusicDisc} that is playing at the given position.
     *
     * @param position The position
     */
    void stopMusicDisc(Vector3i position);

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
        sendTitle(Title.reset());
    }

    /**
     * Removes the currently displayed {@link Title} from the player's screen.
     */
    default void clearTitle() {
        sendTitle(Title.clear());
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
