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

import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.ChunkRegenerateFlag;
import org.spongepowered.api.world.ChunkRegenerateFlags;
import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3i;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Manages {@link WorldChunk chunks} for a {@link ServerWorld}.
 */
@DoNotStore
public interface ChunkManager {

    /**
     * Gets the {@link ServerWorld} this manager operates upon.
     *
     * @return The {@link ServerWorld}
     */
    ServerWorld world();

    /**
     * Checks if the provided {@link Ticket} is valid for the world this manager
     * represents.
     *
     * @param ticket The ticket to check.
     * @return true if so
     */
    boolean valid(Ticket<?> ticket);

    /**
     * Gets the {@link Ticks} remaining on the supplied ticket.
     *
     * @return The {@link Ticks}
     */
    Ticks timeLeft(Ticket<?> ticket);

    /**
     * Request a {@link Ticket} for a given {@link TicketType} that supports a
     * chunk position.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link WorldChunk}
     *                    affected by this {@link Ticket}
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @return The ticket, if granted.
     */
    default Optional<Ticket<Vector3i>> requestTicket(final DefaultedRegistryReference<TicketType<Vector3i>> type,
                                                     final Vector3i chunkOrigin, final int radius) {
        return this.requestTicket(type.get(), chunkOrigin, radius);
    }

    /**
     * Request a {@link Ticket} for a given {@link TicketType} that supports a
     * chunk position.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link WorldChunk}
     *                    affected by this {@link Ticket}
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @return The ticket, if granted.
     */
    default Optional<Ticket<Vector3i>> requestTicket(final TicketType<Vector3i> type, final Vector3i chunkOrigin,
                                                     final int radius) {
        return this.requestTicket(type, chunkOrigin, chunkOrigin, radius);
    }

    /**
     * Request a {@link Ticket} for the given {@link TicketType}.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link WorldChunk}
     *                    affected by this {@link Ticket}
     * @param value The value to register the ticket with.
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @param <T> The type of the supplied {@code value}.
     * @return The ticket, if granted.
     */
    <T> Optional<Ticket<T>> requestTicket(TicketType<T> type, Vector3i chunkOrigin, T value, int radius);

    /**
     * Request a {@link Ticket} for the given {@link TicketType}.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link WorldChunk}
     *                    affected by this {@link Ticket}
     * @param value The value to register the ticket with.
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects. This may be capped - for the Vanilla impl, this is
     *               limited to a radius of 33 chunks.
     * @param <T> The type of the supplied {@code value}.
     * @return The ticket, if granted.
     */
    default <T> Optional<Ticket<T>> requestTicket(final DefaultedRegistryReference<TicketType<T>> type,
                                                  final Vector3i chunkOrigin, final T value, final int radius) {
        return this.requestTicket(type.get(), chunkOrigin, value, radius);
    }

    /**
     * Attempts to renew this ticket, resetting the lifetime to the default.
     *
     * <p>If this ticket is no longer valid, it cannot be renewed. Instead,
     * you should {@link #requestTicket(TicketType, Vector3i, Object, int)} a new one.</p>
     *
     * @param ticket The ticket to attempt to renew
     * @return {@code true} if successful
     */
    boolean renewTicket(Ticket<?> ticket);

    /**
     * Releases the provided {@link Ticket}, allowing the chunk position
     * represented by the given ticket to be unloaded (if it is not being kept
     * loaded by other means).
     *
     * @param ticket The ticket to release.
     */
    boolean releaseTicket(Ticket<?> ticket);

    /**
     * Gets all currently active {@link Ticket tickets} that are of the
     * provided {@link TicketType}.
     *
     * @param type The {@link TicketType} to retrieve tickets for
     * @param <T> The type of value the {@link Ticket} holds
     * @return A {@link Collection} of {@link Ticket tickets}
     */
    <T> Collection<Ticket<T>> findTickets(TicketType<T> type);

    /**
     * Gets all currently active {@link Ticket tickets} that are of the
     * provided {@link TicketType}.
     *
     * @param type The {@link TicketType} to retrieve tickets for
     * @param <T> The type of value the {@link Ticket} holds
     * @return A {@link Collection} of {@link Ticket tickets}
     */
    default <T> Collection<Ticket<T>> findTickets(final DefaultedRegistryReference<TicketType<T>> type) {
        return this.findTickets(type.get());
    }

    /**
     * Regenerates a chunk at the given chunk coordinate position.
     *
     * <p>Care should be taken to check the result of the future, as an
     * exception may be provided if the regeneration was not successful.</p>
     *
     * <p><strong>Users must not use {@link CompletableFuture#get() get} or
     * {@link CompletableFuture#join() join} on this future.</strong> Doing so
     * may end up causing a deadlock on the server.</p>
     *
     * @param chunkPosition The chunk position to regenerate
     * @return The regenerated chunk, if available
     */
    default CompletableFuture<Boolean> regenerateChunk(final Vector3i chunkPosition) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
        return this.regenerateChunk(chunkPosition.x(), chunkPosition.y(), chunkPosition.z(), ChunkRegenerateFlags.ALL.get());
    }

    /**
     * Regenerates a chunk at the given chunk coordinates.
     *
     * <p>Care should be taken to check the result of the future, as an
     * exception may be provided if the regeneration was not successful.</p>
     *
     * <p><strong>Users must not use {@link CompletableFuture#get() get} or
     * {@link CompletableFuture#join() join} on this future.</strong> Doing so
     * may end up causing a deadlock on the server.</p>
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @return The regenerated chunk, if available
     */
    default CompletableFuture<Boolean> regenerateChunk(final int cx, final int cy, final int cz) {
        return this.regenerateChunk(cx, cy, cz, ChunkRegenerateFlags.ALL.get());
    }

    /**
     * Regenerates a chunk at the given chunk coordinate position.
     *
     * <p>Care should be taken to check the result of the future, as an
     * exception may be provided if the regeneration was not successful.</p>
     *
     * <p><strong>Users must not use {@link CompletableFuture#get() get} or
     * {@link CompletableFuture#join() join} on this future.</strong> Doing so
     * may end up causing a deadlock on the server.</p>
     *
     * @param chunkPosition The chunk position to regenerate
     * @param flag The chunk regenerate flag to use
     * @return The regenerated chunk, if available
     */
    default CompletableFuture<Boolean> regenerateChunk(final Vector3i chunkPosition, final ChunkRegenerateFlag flag) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
        return this.regenerateChunk(chunkPosition.x(), chunkPosition.y(), chunkPosition.z(), Objects.requireNonNull(flag, "flag"));
    }

    /**
     * Regenerates a chunk at the given chunk coordinates.
     *
     * <p>Care should be taken to check the result of the future, as an
     * exception may be provided if the regeneration was not successful.</p>
     *
     * <p><strong>Users must not use {@link CompletableFuture#get() get} or
     * {@link CompletableFuture#join() join} on this future.</strong> Doing so
     * may end up causing a deadlock on the server.</p>
     *
     * @param cx The chunk x coordinate
     * @param cy The chunk y coordinate
     * @param cz The chunk z coordinate
     * @param flag The chunk regenerate flag to use
     * @return The regenerated chunk, if available
     */
    CompletableFuture<Boolean> regenerateChunk(int cx, int cy, int cz, ChunkRegenerateFlag flag);

    /**
     * Returns the path of the directory where region files are stored.
     *
     * @return The path of the region directory
     */
    Path regionDirPath();

    /**
     * Returns the path of the region file containing the given {@link WorldChunk}.
     *
     * @param chunk The {@link WorldChunk} for which to acquire the region file path
     * @return The path of the region file for the given chunk
     */
    Path regionFilePath(WorldChunk chunk);

    /**
     * Calculates the maximum chunk coordinates for a given region coordinates (x, z) in a world.
     *
     * @param rx The x-coordinate of the region
     * @param rz The z-coordinate of the region
     * @return A {@link Vector3i} containing the maximum chunk coordinates for the given region coordinates
     */
    Vector3i maxChunkFromRegion(int rx, int rz);

    /**
     * Calculates the maximum chunk coordinates for a given region coordinates (x, z) in a world.
     *
     * @param regionCoordinate The coordinate of the region
     * @return A {@link Vector3i} containing the maximum chunk coordinates for the given region coordinates
     */
    default Vector3i maxChunkFromRegion(Vector2i regionCoordinate) {
        Objects.requireNonNull(regionCoordinate, "regionCoordinate");
        return this.maxChunkFromRegion(regionCoordinate.x(), regionCoordinate.y());
    }

    /**
     * Calculates the minimum chunk coordinates for a given region coordinates (x, z) in a world.
     *
     * @param rx The x-coordinate of the region
     * @param rz The z-coordinate of the region
     * @return A {@link Vector3i} containing the minimum chunk coordinates for the given region coordinates
     */
    Vector3i minChunkFromRegion(int rx, int rz);

    /**
     * Calculates the maximum chunk coordinates for a given region coordinates (x, z) in a world.
     *
     * @param regionCoordinate The coordinate of the region
     * @return A {@link Vector3i} containing the maximum chunk coordinates for the given region coordinates
     */
    default Vector3i minChunkFromRegion(Vector2i regionCoordinate) {
        Objects.requireNonNull(regionCoordinate, "regionCoordinate");
        return this.minChunkFromRegion(regionCoordinate.x(), regionCoordinate.y());
    }

    /**
     * Returns the region coordinates and file paths of existing regions.
     *
     * @return the region coordinates and their file paths.
     */
    Map<Vector2i, Path> regionFiles();
}
