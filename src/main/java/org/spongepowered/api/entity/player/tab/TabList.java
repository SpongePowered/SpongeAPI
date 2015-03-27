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
package org.spongepowered.api.entity.player.tab;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.UUID;

/**
 * Represents a {@link Player}'s tab list.
 */
public interface TabList {

    /**
     * Gets this list's header.
     * 
     * @return The current header
     */
    Text getHeader();

    /**
     * Sets this list's header.
     * 
     * @param header The new header
     */
    void setHeader(Text header);

    /**
     * Gets this list's footer.
     * 
     * @return The current footer
     */
    Text getFooter();

    /**
     * Sets this list's footer.
     * 
     * @param footer The new footer
     */
    void setFooter(Text footer);

    /**
     * Gets the players on the list. The list should be immutable.
     * 
     * @return The players on the list
     */
    List<PlayerTabInfo> getPlayers();

    /**
     * Adds a player to the list.
     * 
     * @param player The player to add
     * @throws IllegalArgumentException when it attempts to add a player already
     *         on the list. This is to prevent modification of a
     *         {@link PlayerTabInfo} by overwriting it
     */
    void addPlayer(PlayerTabInfo player) throws IllegalArgumentException;

    /**
     * Removes a player from the list. This should only be used to completely
     * remove a player, not add it back later. Note that if this is used on a
     * player, but they remain visible in-game, their skin will not work.
     * 
     * @param playerId the UUID of the player to remove
     * @return The {@link PlayerTabInfo} that was associated with the UUID
     */
    PlayerTabInfo removePlayer(UUID playerId);

    /**
     * Finds a {@link PlayerTabInfo} matching the specified UUID. If none were
     * found, it returns Optional.absent().
     *
     * @param uuid The UUID to search for
     * @return An Optional containing a PlayerTabInfo if one was found
     */
    Optional<PlayerTabInfo> getPlayer(UUID uuid);

}
