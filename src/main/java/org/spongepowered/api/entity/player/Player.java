/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.player.gamemode.GameModes;
import org.spongepowered.api.net.PlayerConnection;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.text.translation.locale.Locales;
import org.spongepowered.api.util.command.CommandSource;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

/**
 * A Player represents the in-game entity of a human playing on a server.
 * This is in contrast to User which represents the storage and data
 * associated with a Player.
 *
 * <p>Any methods called on Player that are not on User do not store any data
 * that persists across server restarts.</p>
 */
public interface Player extends Human, User, CommandSource, Viewer {

    /**
     * Gets the player's display name. If none set, returns their current
     * username.
     *
     * @return The player's display name
     */
    Message getDisplayName();

    /**
     * Returns whether the {@link Player} can fly via the fly key.
     *
     * @return {@code True} if the {@link Player} is allowed to fly
     */
    boolean getAllowFlight();

    /**
     * Sets if the {@link Player} can fly via the fly key.
     *
     * @param allowFlight {@code True} if the player is allowed to fly
     */
    void setAllowFlight(boolean allowFlight);

    /**
     * Gets the locale used by the player.
     *
     * @return The player's locale
     * @see Locales
     */
    Locale getLocale();

    /**
     * Sends the plain text message(s) with the specified {@link ChatType} on the client.
     * <p>Use {@link #sendMessage(ChatType, Message...)} for a formatted message.</p>
     *
     * @param type The chat type to send the messages to
     * @param message The message(s) to send
     */
    void sendMessage(ChatType type, String... message);

    /**
     * Sends the message(s) with the specified {@link ChatType} on the client.
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatType type, Message... messages);

    /**
     * Sends the message(s) with the specified {@link ChatType} on the client.
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatType type, Iterable<Message> messages);

    /**
     * Sends a {@link Title} to this player.
     *
     * @param title The {@link Title} to send to the player
     */
    void sendTitle(Title title);

    /**
     * Removes the currently displayed {@link Title} from the player and resets
     * all settings back to default values.
     */
    void resetTitle();

    /**
     * Removes the currently displayed {@link Title} from the player's screen.
     */
    void clearTitle();

    /**
     * Gets the current value for the given {@link Statistic}.
     *
     * @param statistic The statistic to return
     * @return The current value for the given statistic, if a value is set yet.
     *         Optional.absent() otherwise
     */
    Optional<Long> getStatistic(Statistic statistic);

    /**
     * Gets all {@link Statistic}s with their current values. Does not return
     * statistics that does not have a value set yet.
     *
     * @return An immutable map containing all statistics with their current
     *         values
     */
    Map<Statistic, Long> getStatistics();

    /**
     * Adds the specified amount to the given statistic.
     *
     * @param statistic The statistic to update
     * @param amount The amount to add to the statistic
     */
    void addToStatistic(Statistic statistic, long amount);

    /**
     * Sets the given statistic to the given value.
     *
     * @param statistic The statistic to update
     * @param newValue The new value for the statistic
     */
    void setStatistic(Statistic statistic, long newValue);

    /**
     * Resets the given statistic. The entry will be removed from the stats so
     * if you try to get it, it will return Optional.absent() until it is
     * set again.
     *
     * @param statistic The statistic to reset
     */
    void resetStatistic(Statistic statistic);

    /**
     * Resets all statistics. The entries will be removed from the stats so if
     * you try to get any of them, it will return Optional.absent() until they
     * are set again.
     */
    void resetStatistics();

    /**
     * Checks whether this player has earned the given {@link Achievement}.
     *
     * @param achievement The achievement to check
     * @return True if the player has completely earned the achievement
     */
    boolean hasAchievement(Achievement achievement);

    /**
     * Gets an {@link Collection} containing all {@link Achievement}s this player
     * has earned already.
     *
     * @return An immutable collection containing all earned achievements
     */
    Collection<Achievement> getAchievements();

    /**
     * Grants the given {@link Achievement} to this player. An
     * {@link Achievement} can be granted multiple times.
     *
     * @param achievement The achievement to grant
     */
    void grantAchievement(Achievement achievement);

    /**
     * Revokes the given {@link Achievement} from this player. This may also
     * revoke dependent {@link Achievement}s or reset {@link Statistic}s that
     * are used to count for the {@link Achievement}.
     *
     * @param achievement The achievement to revoke
     */
    void revokeAchievement(Achievement achievement);

    /**
     * Revokes all {@link Achievement}s from this player. This may also resets
     * {@link Statistic} that are used to count for the {@link Achievement}s.
     */
    void revokeAchievements();

    /**
     * Gets the player's game mode.
     *
     * @return The player's game mode
     * @see GameModes
     */
    GameMode getGameMode();

    /**
     * Sets the players's game mode.
     *
     * @param gameMode The game mode to set
     * @see GameModes
     */
    void setGameMode(GameMode gameMode);

    /**
     * Gets the appropriate {@link PlayerConnection} linking this Player
     * to a client.
     *
     * @return The connection
     */
    PlayerConnection getConnection();

}
