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
package org.spongepowered.api.server;

import org.spongepowered.api.Engine;
import org.spongepowered.api.client.Client;
import org.spongepowered.api.client.RemotePlayer;
import org.spongepowered.api.command.source.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.profile.GameProfileManager;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.world.WorldManager;
import org.spongepowered.api.world.chunk.ChunkTicketManager;
import org.spongepowered.api.world.storage.ChunkLayout;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a typical Minecraft Server.
 */
public interface Server extends Engine, CommandSource {

    /**
     * Gets the {@link WorldManager}.
     *
     * @return The world manager
     */
    WorldManager getWorldManager();

    /**
     * Gets the {@link Player}s currently online.
     *
     * @return A {@link Collection} of online players
     */
    Collection<Player> getOnlinePlayers();

    /**
     * Gets the max players allowed on this server.
     *
     * @return Maximum number of connected players
     */
    int getMaxPlayers();

    /**
     * Gets a {@link Player} by their UUID.
     *
     * @param uniqueId The UUID to get the player from
     * @return The {@link Player} or empty if not found
     */
    Optional<? extends Player> getPlayer(UUID uniqueId);

    /**
     * Gets a {@link Player} by their name.
     *
     * <p>This only works for online players.</p>
     *
     * <p><b>Note: Do not use names for persistent storage, the
     * Notch of today may not be the Notch of yesterday.</b></p>
     *
     * @param name The name to get the player from
     * @return The {@link Player} or empty if not found
     */
    Optional<? extends Player> getPlayer(String name);

    /**
     * Gets the 'server' scoreboard. In Vanilla, this is the scoreboard of
     * dimension 0 (the overworld).
     *
     * <p>The sever scoreboard is used with the Vanilla /scoreboard command,
     * automatic score updating through criteria, and other things.</p>
     *
     * <p>The server scoreboard may not be available if dimension 0
     * is not yet loaded. In Vanilla, this will only occur when the
     * server is first starting, as dimension 0 is normally always loaded.</p>
     *
     * @return the server scoreboard, if available.
     */
    Optional<? extends Scoreboard> getServerScoreboard();

    /**
     * Returns information about the chunk layout used by this server
     * implementation.
     *
     * @return The chunk layout used by the implementation
     */
    ChunkLayout getChunkLayout();

    /**
     * Gets the time, in ticks, since this server began running for the current
     * session.
     *
     * <p>This value is not persisted across server restarts, it is set to zero
     * each time the server starts.</p>
     *
     * @return The number of ticks since this server started running
     */
    int getRunningTimeTicks();

    /**
     * Gets the message channel that server-wide messages are sent through.
     *
     * @return The server-wide broadcast channel
     */
    MessageChannel getBroadcastChannel();

    /**
     * Sets the channel that server-wide messages should be sent through.
     *
     * @param channel The broadcast channel
     */
    void setBroadcastChannel(MessageChannel channel);

    /**
     * Gets the bound {@link InetSocketAddress} from where this server is
     * accepting connections.
     *
     * @return The address or Optional.empty() if not found
     */
    Optional<InetSocketAddress> getBoundAddress();

    /**
     * Tests if the server has a whitelist enabled.
     * @return True if enabled, false if not
     */
    boolean hasWhitelist();

    /**
     * Sets whether the server is utilizing a whitelist.
     * @param enabled True to enable the whitelist, false to disable
     */
    void setHasWhitelist(boolean enabled);

    /**
     * Tests if this server is set to online mode.
     *
     * <b>Online mode authenticates users against Minecraft's servers, false
     * performs no validity checks.</b>
     *
     * @return True if enabled, false if not
     */
    boolean getOnlineMode();

    /**
     * Gets the default message that is displayed in the server list of the
     * client.
     *
     * @return The server's default description (MOTD)
     */
    Text getMotd();

    /**
     * Shuts down the server, and kicks all players with the default kic
     * k message.
     *
     * <p>For the Sponge implementation on the client, this will trigger the
     * Integrated Server to shutdown a tick later.</p>
     */
    void shutdown();

    /**
     * Shuts down the server, and kicks all players with the given message.
     *
     * @param kickMessage The message to kick players with
     */
    void shutdown(Text kickMessage);

    /**
     * Gets the ChunkTicketManager used for requesting tickets to force load
     * chunks.
     *
     * @return This server's chunk load service
     */
    ChunkTicketManager getChunkTicketManager();

    /**
     * Gets the {@link GameProfileManager} for resolving game profiles.
     *
     * @return This server's game profile manager
     */
    GameProfileManager getGameProfileManager();

    /**
     * Gets the current ticks per second. A tick represents one cycle of the
     * game loop.
     *
     * <p>Note: The server aims to limit itself at 20 ticks per second. Lower
     * ticks per second may elude to the server taking more time to process
     * information per tick. Examples of overburdening the server per tick
     * include spawning 10,000 cows in a small area.</p>
     *
     * @return The current ticks per second
     */
    double getTicksPerSecond();

    /**
     * Gets the default resource pack. The default resource pack is sent to
     * players when they join the server.
     *
     * @return The default resource pack
     */
    Optional<ResourcePack> getDefaultResourcePack();

    /**
     * Gets the player idle timeout, in minutes.
     *
     * <p>A return value of {@code 0} disables the player idle timeout.</p>
     *
     * @return The player idle timeout
     */
    int getPlayerIdleTimeout();

    /**
     * Sets the player idle timeout, in minutes.
     *
     * <p>A value of {@code 0} disables the player idle timeout.</p>
     *
     * @param timeout The player idle timeout
     */
    void setPlayerIdleTimeout(int timeout);

    /**
     * Gets whether this server is dedicated to being a global server, or
     * whether this server is local to a game client where a {@link Client}
     * instance may be available. The primary difference will be the types
     * of {@link Player players} there may exist in the server, whether
     * they are {@link ServerPlayer server players} or {@link RemotePlayer remote players}.
     *
     * @return True if this is a dedicated server without a game client
     */
    boolean isDedicatedServer();
}
