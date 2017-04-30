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
import org.spongepowered.api.block.tileentity.EnderChest;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.entity.GameModeData;
import org.spongepowered.api.data.manipulator.mutable.entity.JoinData;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.tab.PlayerTabList;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.network.PlayerConnection;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.text.chat.ChatType;

import java.time.Instant;
import java.util.Set;

/**
 * A Player represents the in-game entity of a human playing on a server.
 * This is in contrast to User which represents the storage and data
 * associated with a Player.
 *
 * <p>Any methods called on Player that are not on User do not store any data
 * that persists across server restarts.</p>
 *
 * <p>This is specifically the server player. For client, see
 * {@link ClientPlayer}.</p>
 */
public interface Player extends BasePlayer, PlayerController {

    /**
     * Simulates a chat message from a player.
     *
     * <p>This method sends a message as if it came from this player.
     * To send a message to this player instead, see
     * {@link MessageReceiver#sendMessage(Text)} or
     * {@link ChatTypeMessageReceiver#sendMessage(ChatType, Text)}.</p>
     *
     * <p>Commands cannot be sent using this method. To send commands, use
     * {@link CommandManager#process(CommandSource, String)}.</p>
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param message The message to send
     * @param cause The cause for the message
     * @return The event that was thrown from sending the message
     */
    MessageChannelEvent.Chat simulateChat(Text message, Cause cause);

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
    PlayerTabList getTabList();

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
     * Gets the skin parts that this player has allowed to render.
     *
     * @return A set of skin parts displayed
     */
    Set<SkinPart> getDisplayedSkinParts();

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
     * Gets the {@link Value} of the {@link Instant} that a {@link Player}
     * joined the {@link Server} the first time.
     *
     * @return The value for the first time a player joined
     */
    default Value<Instant> firstPlayed() {
        return getValue(Keys.FIRST_DATE_PLAYED).get();
    }

    /**
     * Gets the {@link Value} of the {@link Instant} that a {@link Player}
     * joined the {@link Server} the last time.
     *
     * @return The value for the last time a player joined
     */
    default Value<Instant> lastPlayed() {
        return getValue(Keys.LAST_DATE_PLAYED).get();
    }

    /**
     * Gets if the {@link Player} has played on the {@link Server} before. Added
     * as a utility.
     *
     * @return True if played before, false otherwise
     */
    default boolean hasPlayedBefore() {
        return !firstPlayed().equals(lastPlayed());
    }

    @Override default DisplayNameData getDisplayNameData() {
        return get(DisplayNameData.class).get();
    }

    @Override default GameModeData getGameModeData() {
        return get(GameModeData.class).get();
    }

    @Override default Value<GameMode> gameMode() {
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

    /**
     * Gets the {@link Inventory} available for this Player's shared {@link EnderChest}
     * contents.
     *
     * @return The ender chest inventory
     */
    Inventory getEnderChestInventory();

}
