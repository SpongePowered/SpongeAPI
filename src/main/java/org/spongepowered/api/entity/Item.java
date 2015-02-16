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

package org.spongepowered.api.entity;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * Represents an Item entity.
 */
public interface Item extends Entity {

    /**
     * Get the {@link ItemStack} that this item represents.
     *
     * @return The represented {@link ItemStack}
     */
    ItemStack getItemStack();

    /**
     * Gets the number of ticks remaining until this item can be picked up,
     * or -1 if this item has an infinite pickup delay.
     *
     * @return The number of ticks remaining, or -1
     */
    int getPickupDelay();

    /**
     * Sets the number of ticks remaining until this item can be picked up.
     *
     * <p>If this item currently has an infinite pickup delay, the infinite
     * pickup delay will be removed, and delay will be set instead.</p>
     *
     * @param delay The number of ticks remaining
     */
    void setPickupDelay(int delay);

    /**
     * Sets an infinite pickup time for this item.
     */
    void setInfinitePickupDelay();

    /**
     * Gets the number of ticks remaining until this item despawns,
     * or -1 if this item will never despawn.
     *
     * @return The number of ticks remaining, or -1
     */
    int getDespawnTime();

    /**
     * Sets the number of ticks remaining until this item despawns.
     *
     * <p>If this item currently has an infinite despawn delay, the infinite
     * despawn delay will be removed, and time will be set instead.</p>
     *
     * @param time The number of ticks remaining
     */
    void setDespawnTime(int time);

    /**
     * Sets an infinite despawn time for this item.
     */
    void setInfiniteDespawnTime();

    /**
     * Gets the {@link User} who threw this item, if available
     *
     * <p>If this item was not dropped from a player's inventory,
     * then the thrower will not be available.</p>
     *
     * @return The thrower, or Optional.absent()
     */
    Optional<User> getThrower();

    /**
     * Sets the {@link User} who threw this item.
     *
     * @param thrower The user who threw this item
     */
    void setThrower(@Nullable User thrower);
}
