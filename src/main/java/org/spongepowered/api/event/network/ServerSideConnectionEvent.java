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
package org.spongepowered.api.event.network;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.message.MessageCancellable;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.network.ServerSideConnection;
import org.spongepowered.api.network.channel.Channel;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.whitelist.WhitelistService;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;

import java.net.InetAddress;

/**
 * Represents an event fired during the login process.
 *
 * <p>Together with {@link SpawnEntityEvent}, these events represent the
 * progression of a {@link ServerPlayer player} from first authenticating, to being fully
 * loaded in the world.</p>
 *
 * <p>The events are fired in the following order:</p>
 *
 * <p>#Auth -&gt; #Handshake -&gt; #Login -&gt; {@link SpawnEntityEvent} -&gt; #Join</p>
 *
 * <p>{@link SpawnEntityEvent} is still fired for players, for consistency.
 * However, the player is not at a well-defined state at that point. It's
 * recommended to use the event's subinterfaces to interact with the player
 * at well-defined moments during the connection process.</p>
 */
public interface ServerSideConnectionEvent extends Event {

    /**
     * Gets the {@link ServerSideConnection}.
     *
     * @return The server side connection
     */
    ServerSideConnection getConnection();

    /**
     * Gets the {@link GameProfile} of the client attempting to connect.
     *
     * @return The client's profile
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default GameProfile getProfile() {
        return this.getConnection().getProfile();
    }

    /**
     * Called asynchronously when the client attempts to authenticate against
     * the server.
     *
     * <p>Note: This event is fired before #Login.</p>
     */
    interface Auth extends ServerSideConnectionEvent, MessageEvent, Cancellable {
    }

    /**
     * Called after the client authenticates and attempts to login to the
     * server. This is the phase where plugins can perform a handshake with
     * the client by sending login related packets and requests.
     *
     * <p>During this event, it's possible to use the {@link Channel}s to send
     * requests to the client. As long as there's requests going to the client,
     * the connection will stay in the handshake phase and will not continue
     * to the {@link Login} event.</p>
     *
     * <p>For example, a plugin sends a packet to the client to request its
     * client side plugin version. The client responds and the plugin handles
     * the response. If the plugin decides to send another packet, the plugin
     * handshake phase will stay active. If the plugin doesn't send a packet,
     * it can assumed that the plugin handshake is finished.</p>
     *
     * <p>During the lifetime of the handshake phase, a {@link ServerSideConnection}
     * can be terminated by calling {@link ServerSideConnection#close(Component)}.</p>
     */
    interface Handshake extends ServerSideConnectionEvent {
    }

    /**
     * Called after the server finished its handshake with the client.
     *
     * <p>Note: This event is fired after #Auth and is NOT async. Any changes
     * required for the {@link ServerPlayer players} {@link ServerLocation location}
     * or {@link Vector3d rotation} should be done during this event and NOT
     * during #Join. </p>
     *
     * <p>If the registered {@link BanService} or {@link WhitelistService}
     * indicates that a player should not be allowed to join (
     * {@link GameProfile} or {@link InetAddress} has an ban, or is not on the
     * whitelist), then this event will automatically cancelled by the
     * implementation, with the proper message set through
     * {@link MessageEvent#setMessage(Component)}. No action on the part
     * of the registered {@link BanService} or {@link WhitelistService} is
     * required for this to occur.
     *
     * Plugins may uncancel the event to allow a client to join, regardless of
     * its ban/whitelist status.</p>
     */
    interface Login extends ServerSideConnectionEvent, MessageEvent, Event, Cancellable {

        /**
         * Gets the {@link User}.
         *
         * @return The user
         */
        User getUser();

        /**
         * Gets the previous {@link ServerLocation location} the {@link ServerPlayer player} would have logged in at.
         *
         * @return The location
         */
        ServerLocation getFromLocation();

        /**
         * Gets the {@link ServerLocation location} the {@link ServerPlayer player} will log in at.
         *
         * @return The location
         */
        ServerLocation getToLocation();

        /**
         * Sets the {@link ServerLocation location} the {@link ServerPlayer player} will log in at.
         *
         * @param location The location
         */
        void setToLocation(ServerLocation location);

        /**
         * Gets the {@link Vector3d rotation} the {@link ServerPlayer player} would have logged in to.
         *
         * @return The rotation
         */
        Vector3d getFromRotation();

        /**
         * Gets the {@link Vector3d rotation} the {@link ServerPlayer player} will log in to.
         *
         * @return The rotation
         */
        Vector3d getToRotation();

        /**
         * Sets the {@link Vector3d rotation} the {@link ServerPlayer player} will log in to.
         *
         * @param rotation The rotation
         */
        void setToRotation(Vector3d rotation);
    }

    /**
     * Called when a {@link ServerPlayer player} joins the game within a {@link ServerWorld world} for the first
     * time after initial connection.
     *
     * <p>The {@link SpawnEntityEvent} for the {@link ServerPlayer player} is fired after the
     * #Login event. This event is fired after both.</p>
     */
    interface Join extends ServerSideConnectionEvent, MessageChannelEvent, MessageCancellable {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer getPlayer();
    }

    /**
     * Called when a {@link ServerPlayer player} disconnects from the game.
     */
    interface Disconnect extends ServerSideConnectionEvent, MessageChannelEvent {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer getPlayer();
    }

}
