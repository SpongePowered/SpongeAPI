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

package org.spongepowered.api.event.entity.player;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.entity.living.human.HumanDeathEvent;
import org.spongepowered.api.text.Text;

/**
 * Called when a {@link Player} is killed.
 */
public interface PlayerDeathEvent extends HumanDeathEvent, PlayerEvent {

    /**
     * Gets the death message of this {@link Player}.
     *
     * @return The death message.
     */
    Text getDeathMessage();

    /**
     * Sets the death message of this {@link Player}.
     *
     * @param deathMessage The new death message.
     */
    void setDeathMessage(Text deathMessage);

    /**
     * Gets whether the player keeps their inventory on death.
     *
     * @return Whether the player keeps their inventory on death
     */
    boolean keepsInventory();

    /**
     * Sets if the player keeps their inventory on death.
     *
     * @param keepInventory Whether the player should keep inventory
     */
    void setKeepsInventory(boolean keepInventory);

    /**
     * Gets whether the player keeps all of their EXP on death.
     *
     * @return Whether the player keeps all of their EXP on death
     */
    boolean keepsLevel();

    /**
     * Sets if the player keeps all of their EXP on death.
     *
     * @param keepLevel Whether the player will keep experience on death
     */
    void setKeepsLevel(boolean keepLevel);

    /**
     * Gets the new experience the player will have towards the next level.
     *
     * <p>This is not the total experience the player will have overall.</p>
     *
     * @return The new experience towards the next level
     */
    int getNewExperience();

    /**
     * Sets the new experience towards the next level after death.
     *
     * <p>This is not the total experience the player will have overall.</p>
     *
     * @param experience The new experiences towards the next level
     */
    void setNewExperience(int experience);

    /**
     * Gets the new level the player will have after death.
     *
     * @return The new level after death
     */
    int getNewLevel();

    /**
     * Sets the new level the player will have after death.
     *
     * @param level The new level after death
     */
    void setNewLevel(int level);
}
