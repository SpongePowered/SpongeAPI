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
package org.spongepowered.api.event.advancement;

import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.message.MessageCancellable;
import org.spongepowered.api.event.message.MessageChannelEvent;

import java.time.Instant;

/**
 * A base event for {@link Advancement} related events.
 */
public interface AdvancementEvent extends Event {

    /**
     * Gets the {@link ServerPlayer player}.
     *
     * @return The player
     */
    ServerPlayer getPlayer();

    /**
     * Gets the {@link Advancement} that is being targeted.
     *
     * @return The advancement
     */
    Advancement getAdvancement();

    /**
     * Is called when a {@link Advancement} is granted/unlocked.
     *
     * <p>This event cannot be canceled, you have to cancel the
     * {@link CriterionEvent.Grant}s of the underlying {@link CriterionEvent}s
     * to prevent unlocking the {@link Advancement}.</p>
     */
    interface Grant extends AdvancementEvent, MessageChannelEvent, MessageCancellable {

        /**
         * Gets the {@link Instant} at which the {@link Advancement}
         * was unlocked.
         *
         * @return The time instant
         */
        Instant getTime();
    }

    /**
     * Is called when a {@link AdvancementCriterion} is revoked.
     *
     * <p>This event cannot be canceled, you have to cancel the
     * {@link CriterionEvent.Grant}s of the underlying {@link CriterionEvent}s
     * to prevent revoking the {@link Advancement}.</p>
     */
    interface Revoke extends AdvancementEvent {
    }
}
