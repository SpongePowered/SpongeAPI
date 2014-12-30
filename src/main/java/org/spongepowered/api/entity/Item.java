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
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * Represents an Item entity.
 */
public interface Item extends Entity {

    /**
     * Get the {@link ItemStack} that this Item represents.
     *
     * @return The represented {@link ItemStack}
     */
    ItemStack getItemStack();

    /**
     * Gets the number of ticks remaining until this Item can be picked up,
     * or -1 if this Item has an infinite pickup delay.
     *
     * @return The number of ticks remaining, or Optional.absent()
     */
    int getPickupDelay();

    /**
     * Sets the number of ticks remaining until this Item can be picked up.
     *
     * <p>If this Item currently has an infinite pickup delay, the infinite
     * pickup delay will be removed, and delay will be set instead.</p>
     *
     * @param delay The number of ticks remaining
     */
    void setPickupDelay(int delay);

    /**
     * Sets whether this Item has an infinite pickup delay
     *
     * @param infinite Whether this Item has an infinite pickup delay
     */
    void setInfinitePickupDelay(boolean infinite);

    /**
     * Gets the number of ticks remaining until this Item despawns,
     * or -1 if this Item will never despawn.
     *
     * @return The number of ticks remaining, or Optional.absent()
     */
    int getDespawnTime();

    /**
     * Sets the number of ticks remaining until this Item despawns.
     *
     * <p>If this Item currently has an infinite despawn delay, the infinite
     * despawn delay will be removed, and time will be set instead.</p>
     *
     * @param time The number of ticks remaining
     */
    void setDespawnTime(int time);

    /**
     * Sets whether this Item never despawns.
     *
     * @param infinite Whether this Item never despawns
     */
    void setInfiniteDespawnTime(boolean infinite);

    /**
     * Gets the {@link Player} who threw this Item, or Optional.absent()
     * if not available.
     *
     * @return The thrower, or Optional.absent()
     */
    Optional<Player> getThrower();

    /**
     * Sets the {@link Player} who threw this Item.
     *
     * <p>If the thrower is null, then {@link #getThrower()}
     * will return Optional.absent()</p>
     *
     * @param thrower The player who threw this Item
     */
    void setThrower(@Nullable Player thrower);
}
