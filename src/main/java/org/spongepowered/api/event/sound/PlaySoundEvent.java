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

import org.spongepowered.api.block.tileentity.Jukebox;
import org.spongepowered.api.block.tileentity.Note;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.record.RecordType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * An umbrella event that fires when in-game sounds, such as
 * records in jukeboxes or sounds when boss entities die.
 */
public interface PlaySoundEvent extends Event, Cancellable {

    /**
     * Gets the location of the sound being played.
     *
     * @return the location of the sound being played
     */
    Location<World> getLocation();

    /**
     * Gets the {@link SoundCategory} for the sound being played.
     *
     *  @return The {@link SoundCategory}
     */
    SoundCategory getSoundCategory();

    /**
     * Gets the {@link SoundType} for the sound being played.
     *
     * @return {@link SoundType}
     */
    SoundType getSoundType();

    /**
     * Gets the volume of the sound being played.
     *
     * @return A float that represents the relative volume. This value may be
     *         positive value.
     */
    float getVolume();

    /**
     * Gets the pitch of the sound being played
     *
     * @return A float that represents the pitch.
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
         * Gets the {@link RecordType} associated with this event.
         *
         * @return The record type
         */
        RecordType getRecordType();

        /**
         * Fired when a record starts playing.
         */
        interface Start extends Record {}

        /**
         * Fired when a record stops playing.
         */
        interface Stop extends Record {}

    }

    /**
     * Fired when a sound is played at a specific {@link Entity}
     */
    interface AtEntity extends PlaySoundEvent {

        /**
         * Gets the {@link Player} that this sound was played at, if the sound
         * was played at a {@link Player}.
         *
         * @return The {@link Player}, if applicable.
         */
        Optional<Player> getPlayer();

    }

    /**
     * Fired when a noteblock is triggered
     */
    interface NoteBlock extends PlaySoundEvent {

        /**
         * The {@link Note} that was played.
         *
         * @return The {@link Note}
         */
        Note getNote();

        /**
         * The type of instrument that played the {@link Note}.
         *
         * @return The {@link InstrumentType}
         */
        InstrumentType getInstrument();

        /**
         * The pitch of the played {@link Note}.
         *
         * @return The {@link NotePitch}
         */
        NotePitch getNotePitch();

    }

}
