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
package org.spongepowered.api.world.server;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.api.world.portal.Portal;
import org.spongepowered.math.vector.Vector3i;

/**
 * Types of {@link Ticket tickets} that can be requested via the
 * {@link ChunkManager}.
 */
public final class TicketTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Represents {@link Ticket tickets} that are intended to ensure that the
     * target {@link WorldChunk chunks} around a {@link Portal} are loaded, ready to
     * accept {@link Entity entities} that travel through it.
     *
     * <p>The position represented by the {@link Vector3i} is a <strong>block
     * position</strong>, specifically, it is intended it is that of the exit
     * point of a portal. When requesting a ticket using
     * {@link ChunkManager#requestTicket( TicketType, Vector3i, Object, int)},
     * the second parameter represents a chunk position, the third parameter
     * represents a block position.</p>
     */
    public static final TicketType<Vector3i> PORTAL = Sponge.game().factoryProvider().provide(Factory.class).portal();

    /**
     * Represents {@link Ticket tickets} that are intended to ensure that the
     * target {@link WorldChunk chunks} around an {@link Entity} are loaded after
     * teleportation.
     */
    public static final TicketType<Entity> POST_TELEPORT = Sponge.game().factoryProvider().provide(Factory.class).postTeleport();

    // SORTFIELDS:OFF

    // @formatter:on

    private TicketTypes() {
    }

    interface Factory {

        TicketType<Vector3i> portal();

        TicketType<Entity> postTeleport();
    }
}
