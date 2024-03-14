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

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.Ticks;

import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Provides access to the item cooldowns of a {@link Player}.
 */
public interface CooldownTracker {

    /**
     * Checks if the specified {@link ItemType} is currently on cooldown
     * for the player.
     *
     * @param type The item type to check is on cooldown
     * @return Whether or not the specified item type is cooldown
     */
    boolean hasCooldown(ItemType type);

    /**
     * Gets the cooldown of the specified {@link ItemType} in ticks for the
     * player, or empty if the the item type is currently not on cooldown.
     *
     * @param type The item type to get the cooldown for
     * @return The cooldown remaining for this item type in ticks, if not
     *     on cooldown
     */
    Optional<Ticks> cooldown(ItemType type);

    /**
     * Sets the cooldown for the specified {@link ItemType} for the
     * specified amount of ticks.
     *
     * @param type The item type to set the cooldown for
     * @param ticks The amount of ticks to set the item type on cooldown for
     * @return False if setting the cooldown failed, possibly due to the event
     *     being cancelled
     * @throws IllegalArgumentException if the ticks is infinite
     */
    boolean setCooldown(ItemType type, Ticks ticks);

    /**
     * Resets the cooldown of the specified {@link ItemType} for the
     * player.
     *
     * @param type The item type to reset the cooldown for
     * @return False if setting the cooldown failed, possibly due to the event
     *     being cancelled
     */
    boolean resetCooldown(ItemType type);

    /**
     * Gets the fraction of the specified {@link ItemType}'s cooldown that
     * is remaining for the player, or empty if the the item type
     * is currently not on cooldown.
     *
     * <p>If present, this value will be between 0.0 and 1.0.</p>
     *
     * @param type The item type to get the cooldown fraction remaining
     * @return The fraction of cooldown remaining for the specified item type
     */
    OptionalDouble fractionRemaining(ItemType type);

}
