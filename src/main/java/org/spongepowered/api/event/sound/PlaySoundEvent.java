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
package org.spongepowered.api.event.sound;

import org.spongepowered.api.block.entity.Jukebox;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.Location;

import java.util.Optional;

public interface PlaySoundEvent extends Event, Cancellable {

    /**
     * Gets the location of the sound being played.
     *
     * @return the location of the sound being played
     */
    Location getLocation();

    /**
     * Gets the {@link SoundCategory} for the sound being played
     * @return The category
     * @see org.spongepowered.api.effect.sound.SoundCategories
     */
    SoundCategory getSoundCategory();

    /**
     * Gets the {@link SoundType} for the sound being played
     * @return The sound type
     * @see org.spongepowered.api.effect.sound.SoundTypes
     */
    SoundType getSoundType();

    /**
     * Gets the volume of the sound being played
     * @return The volume being played
     */
    float getVolume();

    /**
     * Gets the pitch of the sound being played
     * @return The pitch of the sound being played
     */
    float getPitch();

    /**
     * Fired when a sound is broadcasted to all {@link Player}s on the server.
     * <p>Examples of when this might be fired include:</p>
     *
     * <ul>
     * <li>When a Wither or Dragon dies;</li>
     * <li>When a sound event is played globally</li>
     * </ul>
     */
    interface Broadcast extends PlaySoundEvent {

    }

    /**
     * Fired when a record is inserted into a Jukebox
     */
    interface Record extends PlaySoundEvent {

        /**
         * Gets the {@link Jukebox} associated with this event.
         *
         * @return The jukebox tile
         */
        Jukebox getJukebox();

        /**
         * Gets the {@link MusicDisc} associated with this event.
         *
         * @return The record type
         */
        MusicDisc getRecordType();

        interface Start extends Record {}

        interface Stop extends Record {}

    }

    interface AtEntity extends PlaySoundEvent {

        Optional<Player> getPlayer();

    }

}
