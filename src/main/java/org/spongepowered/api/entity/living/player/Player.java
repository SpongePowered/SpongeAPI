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

import org.spongepowered.api.Server;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.command.source.RemoteSource;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.entity.GameModeData;
import org.spongepowered.api.data.manipulator.mutable.entity.JoinData;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.network.PlayerConnection;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatVisibility;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

/**
 * A Player represents the in-game entity of a human playing on a server.
 * This is in contrast to User which represents the storage and data
 * associated with a Player.
 *
 * <p>Any methods called on Player that are not on User do not store any data
 * that persists across server restarts.</p>
 */
public interface Player extends Humanoid, User, Locatable, RemoteSource, Viewer, ChatTypeMessageReceiver {

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
    Optional<Inventory> getOpenInventory();

    /**
     * Opens the given Inventory for the player to view.
     *
     * @param inventory The inventory to view
     * @param cause The {@link Cause} to use when opening the inventory
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the root of the cause
     */
    void openInventory(Inventory inventory, Cause cause) throws IllegalArgumentException;

    /**
     * Closes the currently viewed entity of this player, if it is
     * currently viewing one.
     *
     * @param cause The {@link Cause} to provide when closing the inventory
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the root of the cause
     */
    void closeInventory(Cause cause) throws IllegalArgumentException;

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
     * Gets the skin parts that this player has allowed to render.
     *
     * @return A set of skin parts displayed
     */
    Set<SkinPart> getDisplayedSkinParts();

    /**
     * Gets the appropriate {@link PlayerConnection} linking this Player
     * to a client.
     *
     * @return The connection
     */
    @Override
    PlayerConnection getConnection();

    /**
     * Sends a given {@link ResourcePack} to this player.
     *
     * @param pack The ResourcePack to send
     */
    void sendResourcePack(ResourcePack pack);

    /**
     * Gets this player's {@link TabList}.
     *
     * @return This player's TabList
     */
    TabList getTabList();

    /**
     * Kicks the player, showing the default kick reason (the translation key
     * {@code disconnect.disconnected}).
     */
    void kick();

    /**
     * Kicks the player given a reason.
     *
     * @param reason The reason for the kick
     */
    void kick(Text reason);

    /**
     * Gets the {@link Scoreboard} displayed to the player.
     *
     * @return The scoreboard displayed to the player
     */
    Scoreboard getScoreboard();

    /**
     * Sets the {@link Scoreboard} displayed to the player.
     *
     * @param scoreboard The scoreboard to display
     */
    void setScoreboard(Scoreboard scoreboard);

    /**
     * Gets a copy of the current {@link JoinData}.
     *
     * <p>Since a {@link Player} is already online, it means that the player
     * has joined the server at least once, meaning there is a guaranteed
     * initial join {@link Instant}. Users may not have ever joined a server
     * before.</p>
     *
     * @return A copy of the join data
     */
    default JoinData getJoinData() {
        return get(JoinData.class).get();
    }

    /**
     * Gets the {@link Value} of the {@link Instant} that a {@link Player} joined
     * the {@link Server} the first time.
     *
     * @return The value for the first time a player joined
     */
    default Value<Instant> firstPlayed() {
        return getValue(Keys.FIRST_DATE_PLAYED).get();
    }

    /**
     * Gets the {@link Value} of the {@link Instant} that a {@link Player} joined
     * the {@link Server} the last time.
     *
     * @return The value for the last time a player joined
     */
    default Value<Instant> lastPlayed() {
        return getValue(Keys.LAST_DATE_PLAYED).get();
    }

    /**
     * Gets a copy of the current {@link DisplayNameData} for this
     * {@link Player}.
     *
     * @return A copy of the current display name data
     */
    default DisplayNameData getDisplayNameData() {
        return get(DisplayNameData.class).get();
    }

    /**
     * Gets a copy of the current {@link GameModeData} for this {@link Player}.
     *
     * @return A copy of the current game mode data
     */
    default GameModeData getGameModeData() {
        return get(GameModeData.class).get();
    }

    /**
     * Gets the current {@link GameMode} for this {@link Player}.
     *
     * @return The current game mode value
     */
    default Value<GameMode> gameMode() {
        return getValue(Keys.GAME_MODE).get();
    }

    /**
     * Gets whether this {@link Player} will be ignored when checking whether to
     * skip the night due to players sleeping. The time in a world will be
     * advanced to day if all players in it either are sleeping or have this
     * tag.
     *
     * @return Whether this {@link Player} will be ignored when checking whether
     *     to skip the night
     */
    boolean isSleepingIgnored();

    /**
     * Sets whether this {@link Player} will be ignored when checking whether
     * to skip the night due to players sleeping. The time in a world will be
     * advanced to day if all players in it either are sleeping or have this
     * tag.
     *
     * @param sleepingIgnored Whether this {@link Player} will be ignored when
     *     checking whether to skip the night
     */
    void setSleepingIgnored(boolean sleepingIgnored);

}
