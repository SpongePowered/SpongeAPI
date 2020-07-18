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
package org.spongepowered.api.event.raid;

import org.spongepowered.api.data.type.RaidStatuses;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.raid.RaidWave;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * An event when a raid changes it's current state. Always involves
 * a {@link Raid}.
 */
public interface RaidEvent extends Event {

    /**
     * Gets the {@link Raid} involved with this event.
     *
     * @return The raid
     */
    Raid getRaid();

    /**
     * An event where the {@link Raid} is started.
     *
     * <p>This is fired before any {@link RaidWave}s have started.</p>
     */
    @GenerateFactoryMethod
    interface Start extends RaidEvent, Cancellable {
    }

    /**
     * An event where a {@link RaidWave} in a {@link Raid} has started.
     */
    @GenerateFactoryMethod
    interface StartWave extends RaidEvent, Cancellable {

        /**
         * The {@link RaidWave} which is starting.
         *
         * @return The current wave
         */
        RaidWave getWave();

    }

    /**
     * An event for when a {@link Raid} has ended.
     *
     * <p>The raid's state could be either a {@link RaidStatuses#VICTORY}
     * or {@link RaidStatuses#LOSS}</p>
     */
    @GenerateFactoryMethod
    interface End extends RaidEvent {
    }
}
