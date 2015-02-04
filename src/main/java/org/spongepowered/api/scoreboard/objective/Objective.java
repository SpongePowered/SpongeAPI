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
package org.spongepowered.api.scoreboard.objective;

import com.google.common.base.Optional;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.text.message.Message;

import javax.annotation.Nullable;

/**
 * An objective tracks an integer score for each entry it contains.
 *
 * <p>Entries can be updated by plugins, by in-game commands, or automatically by the game, depending
 * on their {@link Criterion}.</p>
 */
public interface Objective {

    /**
     * Gets the name of this Objective.
     *
     * @return The objective's name
     */
    String getName();

    /**
     * Gets the name displayed to players.
     *
     * @return The objective's display name
     */
    Message getDisplayName();

    /**
     * Sets the name displayed to players.
     *
     * @param displayName Display name to set
     * @throws IllegalArgumentException if displayName is longer than 32
     *     characters
     */
    void setDisplayName(Message displayName) throws IllegalArgumentException;

    /**
     * Gets the criterion for this objective.
     *
     * @return This objective's criterion
     */
    Criterion getCriteria();

    /**
     * Gets the scoreboard to which this objective is attached, if present.
     *
     * @return Owning scoreboard, if present
     */
    Optional<Scoreboard> getScoreboard();

    /**
     * Sets the scoreboard to which this objective is attached.
     *
     * @param scoreboard The scoreboard
     */
    void setScoreboard(Scoreboard scoreboard);

    /**
     * Gets the {@link ObjectiveDisplayMode} used to display this objective.
     *
     * @return The {@link ObjectiveDisplayMode} used to display this objective
     */
    ObjectiveDisplayMode getDisplayMode();

    /**
     * Sets the {@link ObjectiveDisplayMode} used to display this objective.
     *
     * @param displayMode The {@link ObjectiveDisplayMode} used to display this objective
     */
    void setDisplayMode(ObjectiveDisplayMode displayMode);

    /**
     * Gets the display slot this objective is displayed at.
     *
     * @return The display slot for this objective, if set
     */
    Optional<DisplaySlot> getDisplaySlot();

    /**
     * Sets this objective to display on the specified slot for the
     * scoreboard, removing it from any other display slot.
     *
     * <p>If another objective is set to the same display slot, that objective will
     * have it's display slot set to <code>null</code>.</p>
     *
     * @param slot The display slot to change, or null to not display
     */
    void setDisplaySlot(@Nullable DisplaySlot slot);

    /**
     * Gets an entry's {@link Score} for this Objective.
     *
     * @param entry The entry whose score to get
     * @return The {@link Score} for the specified entry
     */
    Score getScore(Message entry);

    /**
     * Unregisters this objective from the Scoreboard.
     */
    void unregister();

}
