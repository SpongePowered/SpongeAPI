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

package org.spongepowered.api.event.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.stats.Statistic;

import javax.annotation.Nullable;

/**
 * Represents an actual change to a {@link Statistic}.
 */
public final class StatisticChange {

    private final Statistic statistic;
    private final Player player;
    private final Type type;
    private final Optional<Long> oldValue;
    private Optional<Long> newValue;

    /**
     * Creates a new statistic change for the given player.
     *
     * @param statistic The statistic that has changed
     * @param player The player whose statistic has changed
     * @param type The type of change
     * @param oldValue The old value of this statistic
     * @param newValue The new value for this statistic
     */
    public StatisticChange(final Statistic statistic, final Player player, final Type type, final Long oldValue, final Long newValue) {
        this.statistic = checkNotNull(statistic, "Statistic cannot be null!");
        this.player = checkNotNull(player, "Player cannot be null!");
        this.type = checkNotNull(type, "Type cannot be null!");
        this.oldValue = Optional.fromNullable(oldValue);
        this.newValue = Optional.fromNullable(newValue);
    }

    /**
     * Gets the statistic that has changed.
     *
     * @return The statistic that has changed
     */
    public Statistic getStatistic() {
        return statistic;
    }

    /**
     * Gets the player whose statistic has changed.
     *
     * @return The player whose statistic has changed
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the type of change.
     *
     * @return The type of change
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets the old value of this statistic.
     *
     * @return The old value of this statistic
     */
    public Optional<Long> getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value for this statistic. If the new value is not present
     * the statistic will be reset.
     *
     * @return The new value for this statistic
     */
    public Optional<Long> getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value for this statistic. If the new value is not present
     * the statistic will be reset.
     *
     * @param newValue The new value for this statistic or null to reset it
     */
    public void setNewValue(@Nullable final Long newValue) {
        this.newValue = Optional.fromNullable(newValue);
    }

    /**
     * Sets the new value for this statistic. If the new value is not present
     * the statistic will be reset.
     *
     * @param newValue The new value for this statistic
     */
    public void setNewValue(final Optional<Long> newValue) {
        this.newValue = newValue;
    }

    /**
     * Represents the possible types of changes to the {@link Statistic}.
     */
    public static enum Type {

        /**
         * Adds a value from the statistic. This also includes negative values.
         */
        ADD,
        /**
         * Set a new value to the statistic.
         */
        SET,
        /**
         * Resets a statistic.
         */
        RESET;

    }

}
