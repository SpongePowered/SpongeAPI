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

import org.spongepowered.api.Platform;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.user.TargetUserEvent;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.whitelist.WhitelistService;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.world.World;

import java.net.InetAddress;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents an event fired during the login process.
 *
 * <p>Together with {@link SpawnEntityEvent}, these events represent
 * the progression of a {@link Player} from first authenticating, to being
 * fully loaded in the world.
 *
 * The events are fired in the following order:
 *
 * #Auth -> #Login -> {@link SpawnEntityEvent} -> #Join
 *
 * {@link SpawnEntityEvent} is still fired for players, for consistency.
 * However, the player is not at a well-defined state at that point.
 * It's recommended to use the this event's subinterfaces to interact
 * with the player at well-defined moments during the connection process.
 */
public interface ClientConnectionEvent extends Event {

    /**
     * Called when a client attempts to handshake against the server.
     */
    interface Handshake extends ClientConnectionEvent, MessageEvent, Cancellable {

        /**
         * Gets the original handshake string.
         *
         * @return The original handshake string
         */
        String getHandshakeString();

        /**
         * Gets the server hostname string.
         *
         * <p>This should not include the port.</p>
         *
         * @return The server hostname string if present, or {@link Optional#empty()}
         */
        Optional<String> getServerHostname();

        /**
         * Sets the server hostname string.
         *
         * <p>This should not include the port.</p>
         *
         * @param serverHostname The server hostname string
         */
        void setServerHostname(String serverHostname);

        /**
         * Gets the socket address hostname string.
         *
         * <p>This should not include the port.</p>
         *
         * @return The socket address hostname string if
         *     present, or {@link Optional#empty()}
         */
        Optional<String> getSocketAddressHostname();

        /**
         * Sets the socket address hostname string.
         *
         * <p>This should not include the port.</p>
         *
         * @param socketAddressHostname The socket address hostname string
         */
        void setSocketAddressHostname(String socketAddressHostname);

        /**
         * Gets the resolved {@link GameProfile} of this client.
         *
         * @return The resolved profile if present, or {@link Optional#empty()}
         */
        Optional<GameProfile> getGameProfile();

        /**
         * Sets the resolved profile of this client.
         *
         * <p>The profile is used to retrieve the {@link UUID}
         * and profile properties for this client.</p>
         *
         * @param profile The resolved profile
         */
        void setGameProfile(GameProfile profile);

        /**
         * Determines if the handshake failed.
         *
         * <p>When {@code true}, the client connecting will be disconnected
         * with the {@link #getMessage()} () fail message}.</p>
         *
         * @return {@code true} if authentication failed, {@code false} otherwise
         */
        boolean isFailed();

        /**
         * Sets if the handshake failed and the client should be disconnected.
         *
         * <p>When {@code true}, the client connecting will be disconnected
         * with the {@link #getMessage()} () fail message}.</p>
         *
         * @param failed {@code true} if authentication failed, {@code false}
         *     otherwise
         */
        void setFailed(boolean failed);
    }

    /**
     * Called asynchronously when the client attempts to authenticate against
     * the server.
     *
     * <p>Note: This event is fired before #Login.</p>
     */
    interface Auth extends ClientConnectionEvent, MessageEvent, Cancellable {
        /**
         * Gets the {@link RemoteConnection} representing the client connection.
         *
         * @return The remote connection
         */
        RemoteConnection getConnection();

        /**
         * Gets the profile of the client attempting to connect.
         *
         * @return The client's profile
         */
        GameProfile getProfile();
    }

    /**
     * Called after the client authenticates and attempts to login to the
     * server.
     *
     * <p>Note: This event is fired after #Auth and is NOT async. Any changes
     * required for the {@link Player}s {@link Transform} should be done during
     * this event and NOT during #Join.
     * </p>
     *
     * <p>If the registered {@link BanService} or {@link WhitelistService}
     * indicates that a player should not be allowed to join
     * ({@link GameProfile} or {@link InetAddress} has an ban, or is
     * not on the whitelist), then this event will automatically cancelled by
     * the {@link Platform#getImplementation() 'game' plugin}, with the proper
     * message set through {@link MessageEvent#setMessage(TextRepresentable)}. No action
     * on the part of the registered {@link BanService} or
     * {@link WhitelistService} is required for this to occur.
     *
     * Plugins may uncancel the event to allow a client to join, regardless of
     * its ban/whitelist status.</p>
     */
    interface Login extends ClientConnectionEvent, MessageEvent, TargetUserEvent, Cancellable {

        /**
         * Gets the {@link RemoteConnection} representing the client connection.
         *
         * @return The remote connection
         */
        RemoteConnection getConnection();

        /**
         * Gets the profile of the client attempting to connect.
         *
         * @return The client's profile
         */
        GameProfile getProfile();

        /**
         * Gets the transform that the {@link Player} came from.
         *
         * @return the previous transform
         */
        Transform<World> getFromTransform();

        /**
         * Gets the new transform that the {@link Player} will change to.
         *
         * @return the new transform
         */
        Transform<World> getToTransform();

        /**
         * Sets the new transform that the {@link Player} will change to.
         *
         * @param transform The new transform
         */
        void setToTransform(Transform<World> transform);
    }

    /**
     * Called when a {@link Player} joins the game {@link World} for the first
     * time after initial connection.
     *
     * <p>The {@link SpawnEntityEvent} for the {@link Player} is fired after
     * the #Login event. This event is fired after both.</p>
     * </p>
     */
    interface Join extends ClientConnectionEvent, TargetPlayerEvent, MessageChannelEvent {}

    /**
     * Called when a {@link Player} disconnects from the game.
     */
    interface Disconnect extends ClientConnectionEvent, TargetPlayerEvent, MessageChannelEvent {}

}
