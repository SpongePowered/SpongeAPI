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

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.data.manipulator.mutable.entity.VehicleData;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.command.MessageSinkEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.living.player.TargetPlayerEvent;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.world.World;

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
public interface ClientConnectionEvent extends GameEvent {

    /**
     * Called asynchronously when the client attempts to authenticate against
     * the server.
     *
     * <p>Note: This event is fired before #Login.</p>
     */
    interface Auth extends ClientConnectionEvent, MessageSinkEvent, Cancellable {
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
     */
    interface Login extends ClientConnectionEvent, MessageSinkEvent, Cancellable {

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
    interface Join extends ClientConnectionEvent, TargetPlayerEvent, MessageSinkEvent {}

    /**
     * Called when a {@link Player} disconnects from the game.
     */
    interface Disconnect extends ClientConnectionEvent, TargetPlayerEvent, MessageSinkEvent {}
}

