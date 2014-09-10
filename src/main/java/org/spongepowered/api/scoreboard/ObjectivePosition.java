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
package org.spongepowered.api.scoreboard;

import org.spongepowered.api.entity.Player;

/**
 * This interface represents a specific position for an objective.</p>
 * Mods can create their own implementation of this interface.
 */
public interface ObjectivePosition {

    /**
     * Called when the specified objective should be shown to the player.
     *
     * @param objective The objective to be shown
     * @param player The player to show the objective to
     */
    void showObjective(Objective objective, Player player);

    /**
     * Called when the specified objective should be destroyed on the player's client.
     *
     * @param objective The objective to be destroyed.
     * @param player The player on which's client the objective should be destroyed.
     */
    void destroyObjective(Objective objective, Player player);

    /**
     * <p>Called when the specified objective's display name
     * should be refreshed on the player's client.</p>
     *
     * @param objective The objective to be renamed.
     * @param player The player on which's client the objective should be renamed.
     */
    void renameObjective(Objective objective, Player player);

    /**
     * Called when a new string entry should be added.
     *
     * @param entry The entry to be added.
     * @param value The value of the added entry.
     * @param player The player on which's client the entry should be added.
     */
    void addStringEntry(String entry, int value, Player player);

    /**
     * Called when an entry's value should be updated on the player's client.
     *
     * @param entry The entry to be updated.
     * @param value The updated value of the entry.
     * @param player The player on which's client the entry should be updated.
     */
    void updateStringEntry(String entry, int value, Player player);

    /**
     * Called when an entry's value should be removed on the player's client.
     *
     * @param entry The entry to be removed.
     * @param player The player on which's client the entry should be removed.
     */
    void removeStringEntry(String entry, Player player);

    /**
     * <p>Called when a new team entry should be added
     * to the scoreboard on the player's client.</p>
     *
     * @param entry The entry to be added.
     * @param value The value of the added entry.
     * @param player The player on which's client the entry should be added.
     */
    void addTeamEntry(Team entry, int value, Player player);

    /**
     * Called when an entry's value should be updated on the player's client.
     *
     * @param entry The entry to be updated.
     * @param value The updated value of the entry.
     * @param player The player on which's client the entry should be updated.
     */
    void updateTeamEntry(Team entry, int value, Player player);

    /**
     * Called when an entry's value should be removed on the player's client.
     *
     * @param entry The entry to be removed.
     * @param player The player on which's client the entry should be removed.
     */
    void removeTeamEntry(Team entry, Player player);
}
