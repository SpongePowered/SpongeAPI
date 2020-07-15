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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.entity.living.player.CooldownTracker;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.ItemType;

import java.util.OptionalInt;

/**
 * An event which handles items in a {@link ServerPlayer player's} {@link CooldownTracker}
 * being given a cooldown or going off cooldown.
 */
public interface CooldownEvent extends Event {

    /**
     * Gets the {@link ServerPlayer player}.
     *
     * @return The player
     */
    ServerPlayer getPlayer();

    /**
     * Gets the associated item type whose cooldown is being set or removed.
     *
     * @return The associated item type
     */
    ItemType getItemType();

    /**
     * Handles an {@link ItemType} being given a cooldown for a {@link ServerPlayer player}.
     *
     * <p>The cooldowns are all in ticks.</p>
     */
    interface Set extends CooldownEvent, Cancellable {

        /**
         * Gets the cooldown the item type had beforehand, if it had one at all.
         *
         * @return The cooldown of the item type beforehand
         */
        OptionalInt getStartingCooldown();

        /**
         * Gets the original new set cooldown at the beginning of the event.
         *
         * @return The originally set cooldown
         */
        int getOriginalNewCooldown();

        /**
         * Gets the new cooldown the item type has for the player.
         *
         * @return The new cooldown of the item type
         */
        int getNewCooldown();

        /**
         * Sets the new cooldown for the item type for the player.
         *
         * @param ticks The amount of ticks the cooldown should last for
         */
        void setNewCooldown(int ticks);

    }

    /**
     * Handles an {@link ItemType} going off cooldown for a {@link ServerPlayer player}.
     */
    interface End extends CooldownEvent {

    }

}
