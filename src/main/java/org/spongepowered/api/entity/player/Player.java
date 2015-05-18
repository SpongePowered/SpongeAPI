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
package org.spongepowered.api.entity.player;

import org.spongepowered.api.block.tile.Sign;
import org.spongepowered.api.data.manipulators.DisplayNameData;
import org.spongepowered.api.data.manipulators.entities.GameModeData;
import org.spongepowered.api.data.manipulators.entities.JoinData;
import org.spongepowered.api.data.manipulators.tileentities.SignData;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.tab.TabList;
import org.spongepowered.api.event.block.tile.SignChangeEvent;
import org.spongepowered.api.net.PlayerConnection;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.source.LocatedSource;
import org.spongepowered.api.util.command.source.RemoteSource;
import org.spongepowered.api.world.Location;

import java.util.Date;
import java.util.Locale;

/**
 * A Player represents the in-game entity of a human playing on a server.
 * This is in contrast to User which represents the storage and data
 * associated with a Player.
 *
 * <p>Any methods called on Player that are not on User do not store any data
 * that persists across server restarts.</p>
 */
public interface Player extends Human, User, LocatedSource, RemoteSource, Viewer {

    /**
     * Gets the locale used by the player.
     *
     * @return The player's locale
     */
    Locale getLocale();

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
     * Edits a sign on this {@link Player}'s client.
     *
     * <p>Any pre-existing lines on the sign at the location given will be
     * filled in the dialog, and the sign will be edited with the contents of
     * the dialog after the "Done" button is pressed by the player.</p>
     *
     * <p>If the block at the given location is not a sign, the client will
     * make the lines blank, and show an error message in the client's chat box.</p>
     *
     * <p>This method does *not* block until the player has finished editing.
     * Instead, to obtain the edited lines, subscribe to
     * {@link SignChangeEvent}.</p>
     *
     * @param sign The sign to edit
     */
    void editSign(Location sign);

    /**
     * Opens an empty sign editing dialog on this {@link Player}'s client.
     *
     * <p>This is not tied to any specific sign, so this method will not
     * modify anything. The callback will be invoked when the client
     * clicks the "Done" button, with the four lines of the sign as
     * arguments.</p>
     *
     * <p>This method does *not* block until the player has finished editing</p>
     *
     * @param callback The callback to invoke once the editing has finished
     */
    void editSign(SignEditCallback callback);

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
     * initial join {@link Date}. Users may not have ever joined a server
     * before.</p>
     *
     * @return A copy of the join data
     */
    JoinData getJoinData();

    /**
     * Gets a copy of the current {@link DisplayNameData} for this
     * {@link Player}.
     *
     * @return A copy of the current display name data
     */
    DisplayNameData getDisplayNameData();

    /**
     * Gets a copy of the current {@link GameModeData} for this {@link Player}.
     *
     * @return A copy of the current game mode data
     */
    GameModeData getGameModeData();

    interface SignEditCallback {

        /**
         * This callback is called once a player has clicked "Done" on
         * the sign editing dialog.
         *
         * @param player The player that edited the sign
         * @param data The new SignData of the sign
         */
        void finishEdit(Player player, SignData data);
    }
}
