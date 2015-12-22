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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.entity.GameModeData;
import org.spongepowered.api.data.manipulator.mutable.entity.JoinData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.network.PlayerConnection;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.source.LocatedSource;
import org.spongepowered.api.command.source.RemoteSource;

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
public interface Player extends Humanoid, User, LocatedSource, RemoteSource, Viewer {

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
    default JoinData getJoinData() {
        return get(JoinData.class).get();
    }

    default Value<Date> firstPlayed() {
        return getValue(Keys.FIRST_DATE_PLAYED).get();
    }

    default Value<Date> lastPlayed() {
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
