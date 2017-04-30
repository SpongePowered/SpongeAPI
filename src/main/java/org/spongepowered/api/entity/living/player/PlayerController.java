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
package org.spongepowered.api.entity.living.player;

import org.spongepowered.api.command.source.RemoteSource;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.chat.ChatVisibility;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * The controller handles certain aspects of the player.
 *
 * <p>The server can see and manage all players, but the client can only manage
 * itself. e.g. The client can show itself a container, but it cannot do the
 * same to someone else.</p>
 *
 * <p>Other methods which could be located here include things the player knows
 * about itself, but cannot possibly know about another. If the server is not
 * likely to know it, look elsewhere.</p>
 *
 * TODO I don't like the name 'controller'
 */
public interface PlayerController extends RemoteSource, Viewer, ChatTypeMessageReceiver {

    /**
     * Returns whether this player has an open inventory at the moment
     * or not.
     *
     * @return Whether this player is viewing an inventory or not
     */
    boolean isViewingInventory();

    /**
     * Gets the currently viewed inventory of this player, if it is
     * currently viewing one.
     *
     * @return An inventory if this player is viewing one, otherwise
     * {@link Optional#empty()}
     */
    Optional<Container> getOpenInventory();

    /**
     * Opens the given Inventory for the player to view.
     *
     * @param inventory The inventory to view
     * @param cause The {@link Cause} to use when opening the inventory
     * @return The opened Container if the inventory was opened, otherwise
     * {@link Optional#empty()}
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the
     * root of the cause
     */
    Optional<Container> openInventory(Inventory inventory, Cause cause) throws IllegalArgumentException;

    /**
     * Closes the currently viewed entity of this player, if it is
     * currently viewing one.
     *
     * @param cause The {@link Cause} to provide when closing the inventory
     * @return whether or not closing the inventory succeeded
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the
     * root of the cause
     */
    boolean closeInventory(Cause cause) throws IllegalArgumentException;

    /**
     * Gets the view distance setting of the player. This value represents the
     * radius (around the player) in unit chunks.
     *
     * @return The player's view distance
     */
    int getViewDistance();

    /**
     * Gets the current player chat visibility setting.
     *
     * @return Chat visibility setting
     */
    ChatVisibility getChatVisibility();

    /**
     * Gets whether the player has colors enabled in chat.
     *
     * @return True if colors are enabled in chat
     */
    boolean isChatColorsEnabled();

    /**
     * Manually respawns the player.
     *
     * <p>If the player is not dead, this method will return <tt>false</tt></p>
     *
     * <p>On the client, this will not respawn the player, but send a request
     * to do so to the server.</p>
     *
     * @return Whether the respawn was successful
     */
    boolean respawnPlayer();

    /**
     * Gets the {@link Entity} followed by the camera when in the
     * {@link GameModes#SPECTATOR spectator gamemode}.
     *
     * @return The followed entity, if present, empty otherwise
     */
    Optional<Entity> getSpectatorTarget();

    /**
     * Sets the {@link Entity} followed by the camera when in the
     * {@link GameModes#SPECTATOR spectator gamemode}.
     *
     * @param entity The entity to spectate
     */
    void setSpectatorTarget(@Nullable Entity entity);
}
