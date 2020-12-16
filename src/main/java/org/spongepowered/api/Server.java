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
package org.spongepowered.api;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.block.entity.CommandBlock;
import org.spongepowered.api.entity.living.Hostile;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.network.ServerSideConnection;
import org.spongepowered.api.profile.GameProfileManager;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.service.ServiceProvider;
import org.spongepowered.api.user.UserManager;
import org.spongepowered.api.util.locale.LocaleSource;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gen.WorldGenerationSettings;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.server.WorldManager;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.api.world.teleport.TeleportHelper;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a typical Minecraft Server.
 */
public interface Server extends ForwardingAudience, Engine, LocaleSource {

    /**
     * Gets the {@link WorldManager}.
     *
     * @return The world manager
     */
    WorldManager getWorldManager();

    /**
     * Gets the {@link ResourceKey key} the default world will have.
     *
     * @return The key
     */
    ResourceKey getDefaultWorldKey();

    /**
     * Gets if multiple {@link ServerWorld worlds} will be loaded by the server.
     *
     * <p>If false, no calls to loading worlds via the {@link WorldManager world manager} or otherwise will
     * load a world</p>
     *
     * @return True if enabled, false if not
     */
    boolean isMultiWorldEnabled();

    /**
     * Gets the {@link WorldGenerationSettings world generator settings}.
     *
     * @return The world generator settings
     */
    WorldGenerationSettings getWorldGeneratorSettings();

    /**
     * Gets the max {@link ServerPlayer players} allowed to join.
     *
     * @return The max players
     */
    int getMaxPlayers();

    /**
     * Gets if the whitelist is currently enforced.
     *
     * @return True if enabled, false if not
     */
    boolean isWhitelistEnabled();

    /**
     * Gets if incoming {@link ServerSideConnection connections} are authenticated against Mojang's servers.
     *
     * @return True if enabled, false if not
     */
    boolean isOnlineModeEnabled();

    /**
     * Gets the "message of the day" presented to clients who have this server saved as a connection profile
     * in the multiplayer menu
     *
     * @return The message of the day
     */
    Component getMOTD();

    /**
     * Gets the {@link ResourcePack pack} sent to clients when they join.
     *
     * @return The resource pack
     */
    Optional<ResourcePack> getResourcePack();

    /**
     * Gets the player idle timeout, in minutes.
     *
     * <p>A value of {@code 0} means the timeout is disabled</p>
     *
     * @return The player idle timeout
     */
    int getPlayerIdleTimeout();

    /**
     * Gets if hardcode mode has been enabled.
     *
     * @return True if enabled, false if not
     */
    boolean isHardcoreModeEnabled();

    /**
     * Gets the {@link Difficulty}.
     *
     * @return The difficulty
     */
    Difficulty getDifficulty();

    /**
     * Gets the {@link GameMode}.
     *
     * @return The gamemode
     */
    GameMode getGameMode();

    /**
     * Gets if {@link ServerPlayer players} will have their {@link GameMode game mode} set to the default.
     *
     * {@link Server#getGameMode()}
     *
     * @return True if enforced, false if not
     */
    boolean isGameModeEnforced();

    /**
     * Gets if pvp is enabled.
     *
     * @return True if enabled, false if not
     */
    boolean isPVPEnabled();

    /**
     * Gets if {@link CommandBlock command blocks} will run commands.
     *
     * @return True if enabled, false if not
     */
    boolean areCommandBlocksEnabled();

    /**
     * Gets if {@link Hostile monsters} will naturally spawn.
     *
     * @return True if enabled, false if not
     */
    boolean isMonsterSpawnsEnabled();

    /**
     * Gets if {@link Animal animals} will naturally spawn.
     *
     * @return True if enabled, false if not
     */
    boolean isAnimalSpawnsEnabled();

    /**
     * Gets whether this server is dedicated to being a global server, or
     * whether this server is local to a game client where a {@link Client}
     * instance may be available.
     *
     * @return True if this is a dedicated server without a game client
     */
    boolean isDedicatedServer();

    /**
     * Gets the {@link UserManager}.
     *
     * @return The user manager
     */
    UserManager getUserManager();

    /**
     * Gets the {@link TeleportHelper}, used to find safe {@link ServerLocation}s.
     *
     * @return The teleport helper
     */
    TeleportHelper getTeleportHelper();

    /**
     * Gets the {@link ServerPlayer}s currently online.
     *
     * @return A {@link Collection} of online players
     */
    Collection<ServerPlayer> getOnlinePlayers();

    /**
     * Gets a {@link ServerPlayer} by their UUID.
     *
     * @param uniqueId The UUID to get the player from
     * @return The {@link ServerPlayer} or empty if not found
     */
    Optional<ServerPlayer> getPlayer(UUID uniqueId);

    /**
     * Gets a {@link ServerPlayer} by their name.
     *
     * <p>This only works for online players.</p>
     *
     * <p><b>Note: Do not use names for persistent storage, the
     * Notch of today may not be the Notch of yesterday.</b></p>
     *
     * @param name The name to get the player from
     * @return The {@link ServerPlayer} or empty if not found
     */
    Optional<ServerPlayer> getPlayer(String name);

    /**
     * Gets the 'server' scoreboard. In Vanilla, this is the scoreboard of
     * dimension 0 (the overworld).
     *
     * <p>The server scoreboard is used with the Vanilla /scoreboard command,
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
    Audience getBroadcastAudience();

    /**
     * Sets the channel that server-wide messages should be sent through.
     *
     * @param channel The broadcast channel
     */
    void setBroadcastAudience(Audience channel);

    /**
     * Gets the bound {@link InetSocketAddress} from where this server is
     * accepting connections.
     *
     * @return The address or Optional.empty() if not found
     */
    Optional<InetSocketAddress> getBoundAddress();

    /**
     * Sets whether the server is utilizing a whitelist.
     *
     * @param enabled True to enable the whitelist, false to disable
     */
    void setHasWhitelist(boolean enabled);

    /**
     * Shuts down the server, and kicks all players with the default kick
     * message.
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
    void shutdown(Component kickMessage);

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
     * @return The current ticks per second
     */
    double getTicksPerSecond();

    /**
     * Gets the target ticks per second for this server.
     *
     * <p>This is dependent on the implementation.</p>
     *
     * @return The target tick per second rate.
     */
    int getTargetTicksPerSecond();

    /**
     * Sets the player idle timeout, in minutes.
     *
     * <p>A value of {@code 0} disables the player idle timeout.</p>
     *
     * @param timeout The player idle timeout
     */
    void setPlayerIdleTimeout(int timeout);

    /**
     * Gets the {@link ServiceProvider.ServerScoped}, used to provide Sponge
     * services that plugins may provide. Services provided here are
     * scoped to the lifetime of this Server.
     *
     * <p>The provider will not be available during plugin construction and will
     * throw an {@link IllegalStateException} if there is an attempt to access
     * this before the provider is ready.</p>
     *
     * @return The service manager
     */
    ServiceProvider.ServerScoped getServiceProvider();

}
