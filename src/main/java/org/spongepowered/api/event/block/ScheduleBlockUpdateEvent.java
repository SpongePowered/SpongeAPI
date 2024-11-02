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
package org.spongepowered.api.event.block;

import org.spongepowered.api.block.transaction.ScheduleUpdateTicket;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.scheduler.ScheduledUpdate;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;
import java.util.function.Predicate;

/**
 * Fired when a {@link ScheduledUpdate scheduled block update}
 * is being proposed to the engine.
 */
public interface ScheduleBlockUpdateEvent<T extends Object> extends GenericEvent<T>, Cancellable {

    /**
     * Gets a list of the {@link ScheduleUpdateTicket}s for this event.
     * If a ticket is requested to be marked as "invalid",
     * {@link ScheduleUpdateTicket#setValid(boolean)} can be used.
     *
     * @return The unmodifiable list of tickets
     */
    List<ScheduleUpdateTicket<T>> tickets();

    /**
     * Applies the provided {@link Predicate} to the {@link List} of
     * {@link ScheduleUpdateTicket}s from {@link #tickets()} such that
     * any time that {@link Predicate#test(Object)} returns {@code false}
     * on the location of the {@link ScheduleUpdateTicket}, the
     * {@link ScheduleUpdateTicket} is marked as "invalid".
     *
     * <p>{@link ScheduleUpdateTicket#block()} is used to get the {@link ServerLocation}</p>
     *
     * @param predicate The predicate to use for filtering
     */
    default void filterTargetPositions(final Predicate<ServerLocation> predicate) {
        this.filterTickets(t -> predicate.test(t.block().serverLocation()));
    }

    /**
     * Applies the provided {@link Predicate} to the {@link List} of
     * {@link ScheduleUpdateTicket}s from {@link #tickets()} such that
     * any time that {@link Predicate#test(Object)} returns {@code false}
     * on the location of the {@link ScheduleUpdateTicket}, the
     * {@link ScheduleUpdateTicket} is marked as "invalid".
     *
     * @param predicate The predicate to use for filtering
     */
    default void filterTickets(final Predicate<ScheduleUpdateTicket<T>> predicate) {
        this.tickets().forEach(ticket -> {
            if (!predicate.test(ticket)) {
                ticket.setValid(false);
            }
        });
    }
}
