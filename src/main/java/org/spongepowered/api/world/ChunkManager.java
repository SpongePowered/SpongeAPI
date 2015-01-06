/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import org.spongepowered.api.entity.Entity;

import java.util.List;
import java.util.UUID;

public interface ChunkManager {

    /**
     * Sets the callback for handling loading forced chunk tickets on world load.
     *
     * <p><b>Required</b> for any plugin that wants to force-load chunks.
     * Any plugin that does not have a registered callback will have all
     * saved tickets dropped on world load.</p>
     *
     * @param plugin Plugin that is registering a callback
     * @param callback The callback function object
     */
    void registerCallback(Object plugin, Callback callback);

    /**
     * Attempts to create a new loading ticket for a plugin to load chunks in a world.
     *
     * <p>Plugins can be limited in the number of tickets they can create per world.</p>
     *
     * @param plugin Plugin that wants to load chunks
     * @param world World that chunks will be loaded in
     * @return The new LoadingTicket, or Optional.absent() if a ticket could not be created
     */
    Optional<LoadingTicket> createTicket(Object plugin, World world);

    /**
     * Attempts to create a new loading ticket for a plugin to load chunks in a world.
     *
     * <p>This version is to create tickets that are bound to the existence of an Entity.
     * For instance, a ticket to load the chunks a minecart is travelling through.</p>
     *
     * <p>Plugins can be limited in the number of tickets they can create per world.</p>
     *
     * @param plugin Plugin that wants to load chunks
     * @param world World that chunks will be loaded in
     * @return The new LoadingTicket, or Optional.absent() if a ticket could not be created
     */
    Optional<EntityLoadingTicket> createEntityTicket(Object plugin, World world);


    /**
     * Attempts to create a new loading ticket for a plugin to load chunks in a world.
     * The returned ticket will be associated with the given player.
     *
     * <p>.</p>
     *
     * @param plugin Plugin that wants to load chunks
     * @param world World that chunks will be loaded in
     * @param player Player that chunks are being loaded for
     * @return The new LoadingTicket, or Optional.absent() if a ticket could not be created
     */
    Optional<PlayerLoadingTicket> createPlayerTicket(Object plugin, World world, UUID player);


    /**
     * Attempts to create a new loading ticket for a plugin to load chunks in a world.
     * The returned ticket will be associated with the given player.
     *
     * <p>This version is to create tickets that are bound to the existence of an Entity.
     * For instance, a ticket to load the chunks a minecart is travelling through.</p>
     *
     * <p>Plugins can be limited in the number of tickets they can create per world.</p>
     *
     * @param plugin Plugin that wants to load chunks
     * @param world World that chunks will be loaded in
     * @param player Player that chunks are being loaded for
     * @return The new LoadingTicket, or Optional.absent() if a ticket could not be created
     */
    Optional<PlayerEntityLoadingTicket> createPlayerEntityTicket(Object plugin, World world, UUID player);

    /**
     * Gets the maximum allowed per-world tickets for a plugin.
     *
     * @param plugin The plugin to get the maximum ticket count for
     * @return The maximum number of tickets the plugin can have in any given world
     */
    int getMaxTickets(Object plugin);

    /**
     * Gets the amount of remaining tickets a plugin can have in the world before
     * hitting the maximum.
     *
     * @param plugin The plugin to get the remaining available ticket count for
     * @param world The world to get the remaining count in
     * @return The remaining tickets the plugin has available in the world
     */
    int getAvailableTickets(Object plugin, World world);

    /**
     * Gets the amount of tickets remaining available for a player.
     *
     * @param player The player to get the number of remaining tickets for
     * @return The remaining tickets the player has available
     */
    int getAvailableTickets(UUID player);

    /**
     * Gets the set of currently force-loaded chunks in a world.
     *
     * @param world The world to get force-loaded chunks from
     * @return The set of all force-loaded chunk coordinates and the tickets
     *         that are loading those chunks
     */
    ImmutableSetMultimap<Vector2i, LoadingTicket> getForcedChunks(World world);

    interface LoadingTicket {

        /**
         * Sets the number of chunks this ticket will load at once.
         *
         * @param numChunks The number of chunks this ticket can load at once
         * @return True if sucessful, false if the number of chunks is above
         *          the maximum allowed for this ticket
         */
        boolean setNumChunks(int numChunks);

        /**
         * Gets the number of chunks this ticket can load at once.
         *
         * @return The number of possible concurrently loaded chunks
         */
        int getNumChunks();

        /**
         * Gets the maximum limit on the number of concurrently loaded chunks
         * this ticket can have.
         *
         * @return The maximum allowed concurrently loaded chunks
         */
        int getMaxNumChunks();

        // TODO: NBTTag getCustomData(); (Is saved with ticket information)

        /**
         * Gets the ID of the plugin that this ticket belongs to.
         *
         * @return The ID of the plugin that registered this ticket
         */
        String getPlugin();

        /**
         * Gets the set of chunks that are being force-loaded by this ticket.
         *
         * @return The set of force-loaded chunks
         */
        ImmutableSet<Vector2i> getChunkList();

        /**
         * Force-loads a chunk using this ticket. If the configured concurrently
         * loaded chunk limit is reached, the oldest loaded chunk will be removed.
         *
         * <p>This does not cause an immediate load of the chunk. Forced chunks
         * will be loaded eventually, but may not be available for a few ticks.
         * Forced chunk loading is equivalent to the loading caused by a player.</p>
         *
         * @param chunk The chunk to force-load
         */
        void forceChunk(Vector2i chunk);

        /**
         * Removes a chunk from the force-loaded set of this ticket.
         *
         * @param chunk The chunk to remove from force-loading
         */
        void unforceChunk(Vector2i chunk);

        /**
         * Reorders a chunk to count as the 'newest' loaded chunk, making it
         * the last chunk to be removed when adding more chunks for force-loading.
         *
         * @param chunk The chunk to reorder
         */
        void prioritizeChunk(Vector2i chunk);

        /**
         * Releases this ticket, removing all associated chunks and freeing up the
         * ticket slot for later use by a new ticket.
         *
         * <p>After this operation the ticket is invalid and cannot be used to
         * force-load chunks.</p>
         */
        void release();
    }

    interface PlayerLoadingTicket extends LoadingTicket {

        /**
         * Gets the UUID of the player associated with this ticket.
         *
         * @return The UUID of the player that owns this ticket
         */
        UUID getPlayerUUID();
    }

    interface EntityLoadingTicket extends LoadingTicket {

        /**
         * Binds an Entity to this Ticket, causing the chunk the Entity is
         * in to be initially loaded with the World. This makes the Entity
         * available during callbacks.
         *
         * @param entity The entity to bind to this ticket
         */
        void bindToEntity(Entity entity);

        /**
         * Gets the Entity bound to this ticket.
         *
         * @return The currently bound entity
         */
        Entity getBoundEntity();
    }

    interface PlayerEntityLoadingTicket extends PlayerLoadingTicket, EntityLoadingTicket {

    }

    interface Callback {

        /**
         * Callback for loading Tickets during world load.
         *
         * <p>The list of forced chunks is not saved with Tickets, this callback
         * is your place to reassociate chunks to Tickets, using the extra
         * information saved with the ticket or your own external
         * configuration. Any unneeded tickets must be manually released.</p>
         *
         * <p>The list of tickets contains both standard plugin and
         * player-associated tickets that were registered by this plugin.</p>
         *
         * <p>The list of tickets has been truncated to the maximum allowed for
         * your plugin, so may not be all saved tickets in the event that
         * the maximum tickets for your plugin was decreased.</p>
         *
         * @param tickets The list of tickets that need chunks registered
         * @param world The world tickets were loaded for
         */
        void onLoaded(ImmutableList<LoadingTicket> tickets, World world);
    }

    interface OrderedCallback extends Callback {

        /**
         * Callback for loading Tickets during world load.
         *
         * <p>During this callback you cannot associate chunks to tickets.
         * This callback gets all loaded non-player tickets. The returned list
         * will be truncated to maxTickets after this callback is called, and
         * and tickets absent from the list will be released.</p>
         *
         * @param tickets The list of loaded tickets
         * @param world The world tickets were loaded for
         * @param maxTickets The maximum tickets allowed for this plugin
         * @return A list of all tickets you wish to keep
         */
        List<LoadingTicket> onLoaded(ImmutableList<LoadingTicket> tickets, World world, int maxTickets);
    }

    interface PlayerOrderedCallback extends Callback {

        /**
         * Callback for loading player Tickets during world load.
         *
         * <p>During this callback you cannot associate chunks to tickets.
         * This callback gets all player-associated tickets registered by the
         * plugin. Tickets absent from the returned Multimap will be
         * released.</p>
         *
         * @param tickets The list of loaded tickets by player
         * @param world The world tickets were loaded for
         * @return All tickets per-player that you wish to keep
         */
        ListMultimap<UUID, LoadingTicket> onPlayerLoaded(ImmutableListMultimap<UUID, LoadingTicket> tickets, World world);
    }
}
