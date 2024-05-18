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
import org.spongepowered.api.event.message.AudienceMessageEvent;
import org.spongepowered.api.event.message.MessageCancellable;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.network.ServerSideConnection;
import org.spongepowered.api.network.channel.Channel;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.whitelist.WhitelistService;
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;

import java.net.InetAddress;
import java.util.Optional;

/**
 * Represents an event fired during the login and configuration phase.
 *
 * <p>These events represent the progression of a {@link ServerPlayer player}
 * from first authenticating, to being fully loaded in the world.</p>
 *
 * <p>The events are fired in the following order:</p>
 *
 * <p>#Intent -&gt; #Auth -&gt; #Handshake -&gt; #Configuration -&gt; #Login -&gt; #Join</p>
 *
 * <p>Vanilla also allows the client to go back to the configuration phase
 * where the {@link ServerPlayer player} is removed from the world before
 * being put back after the configuration phase ends. The order of the events
 * is the following: </p>
 *
 * <p>#Leave -&gt; #Configuration -&gt; #Login -&gt; #Join</p>
 *
 * <p>Traditionally one could consider a {@link SpawnEntityEvent} to be thrown,
 * but due to the nature of cancellations, a {@link ServerPlayer player} joining
 * a world after {@link Login login} would be inadvisable to cancel due to the
 * inconsistent state of both the player and the player's client.</p>
 */
public interface ServerSideConnectionEvent extends Event {

    /**
     * Gets the {@link ServerSideConnection}.
     *
     * @return The server side connection
     */
    ServerSideConnection connection();

    /**
     * <p>Called asynchronously when the client attempts to connect to
     * the server.</p>
     *
     * <p>After observing this event for particular {@link ServerSideConnection connection}
     * you are guaranteed to get #Disconnect for the same connection without
     * ordering issues.</p>
     */
    interface Intent extends ServerSideConnectionEvent, MessageEvent, Cancellable {

        /**
         * Gets if the user is intending to connect due to being transferred.
         *
         * @return {@code true} if the user is transferring.
         */
        boolean isTransfer();
    }

    /**
     * Represents an event that has knowledge about the {@link GameProfile} that
     * is linked to the connection.
     */
    @NoFactoryMethod
    interface ProfileScoped extends ServerSideConnectionEvent {

        /**
         * Gets the {@link GameProfile} of the client.
         *
         * @return The client's profile
         */
        GameProfile profile();
    }

    /**
     * Called asynchronously when the client attempts to authenticate against
     * the server.
     *
     * <p>After observing this event for particular {@link ServerSideConnection connection}
     * you are guaranteed to get #Disconnect for the same connection without
     * ordering issues.</p>
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
     * <p>Plugins may uncancel the event to allow a client to join, regardless of
     * its ban/whitelist status.</p>
     *
     * <p>Note: This event is fired before #Login.</p>
     */
    interface Auth extends ProfileScoped, MessageEvent, Cancellable {
    }

    /**
     * Called after the client authenticates and attempts to switch to the
     * configuration phase. This is the phase where plugins can perform
     * a handshake with the client by sending login related packets and requests.
     *
     * <p>During this event, it's possible to use the {@link Channel}s to send
     * requests to the client. As long as there's requests going to the client,
     * the connection will stay in the handshake phase and will not continue
     * to the {@link Configuration} event.</p>
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
    interface Handshake extends ProfileScoped {
    }

    /**
     * Called when the configuration phase starts. This can happen multiple
     * times per session.
     *
     * <p>During this event, it's possible to use the {@link Channel}s to send
     * requests to the client. As long as there's requests going to the client,
     * the connection will stay in the configuration phase and will not continue
     * to the {@link Login} event.</p>
     *
     * <p>During the lifetime of the handshake phase, a {@link ServerSideConnection}
     * can be terminated by calling {@link ServerSideConnection#close(Component)}.</p>
     */
    interface Configuration extends ProfileScoped {

    }

    /**
     * Called after the server finished its configuration with the client.
     *
     * <p>Note: This event is fired after #Configuration and is NOT async. Any changes
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
     * <p>
     * Plugins may uncancel the event to allow a client to join, regardless of
     * its ban/whitelist status.</p>
     */
    interface Login extends ProfileScoped, MessageEvent, Cancellable {

        /**
         * Gets the {@link User}.
         *
         * @return The user
         */
        User user();

        /**
         * Gets the previous {@link ServerLocation location} the {@link ServerPlayer player} would have logged in at.
         *
         * @return The location
         */
        ServerLocation fromLocation();

        /**
         * Gets the {@link ServerLocation location} the {@link ServerPlayer player} will log in at.
         *
         * @return The location
         */
        ServerLocation toLocation();

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
        Vector3d fromRotation();

        /**
         * Gets the {@link Vector3d rotation} the {@link ServerPlayer player} will log in to.
         *
         * @return The rotation
         */
        Vector3d toRotation();

        /**
         * Sets the {@link Vector3d rotation} the {@link ServerPlayer player} will log in to.
         *
         * @param rotation The rotation
         */
        void setToRotation(Vector3d rotation);
    }

    /**
     * Called when a {@link ServerPlayer player} joins the game within a
     * {@link ServerWorld world} for the first time after the configuration phase.
     * Fired after {@link Login} once the {@link ServerPlayer player} has been
     * properly added to the {@link ServerWorld}. If data is wanted to be
     * modified that could affect a player's representation (such as vanishing),
     * it's recommended to modify such data in the logging in
     * {@link Login#user() User} instead.
     */
    interface Join extends ProfileScoped, AudienceMessageEvent, MessageCancellable {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer player();
    }

    /**
     * Called when a {@link ServerPlayer player} leaves from the world. The
     * {@link ServerSideConnection connection} might not be closed yet as the
     * client could have transitioned back to the configuration state.
     */
    interface Leave extends ProfileScoped, AudienceMessageEvent, MessageCancellable {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer player();
    }

    /**
     * Called when a {@link ServerSideConnection connection} disconnects from the game.
     *
     * <p>Note: This event might be called asynchronously. Additionally, the connection
     * might have not got past #Auth.
     */
    interface Disconnect extends ServerSideConnectionEvent {

        /**
         * Gets the {@link GameProfile} of the client if it got
         * past authentication.
         *
         * @return The client's profile
         */
        Optional<GameProfile> profile();
    }
}
