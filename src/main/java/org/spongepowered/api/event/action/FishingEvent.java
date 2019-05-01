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
package org.spongepowered.api.event.action;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.projectile.FishingBobber;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.List;

/**
 * An event when a "fishing" action is performed. Always involves a
 * {@link FishingBobber}.
 */
public interface FishingEvent extends Event {

    /**
     * Gets the {@link FishingBobber} related with this event.
     *
     * @return The fish hook
     */
    FishingBobber getFishHook();

    /**
     * An event where the {@link FishingBobber} is cast.
     *
     * <p>This is fired before the {@link FishingBobber} has been spawned in the
     * world.</p>
     */
    interface Start extends FishingEvent, Cancellable {}

    /**
     * Fired when an {@link org.spongepowered.api.entity.Entity} is hooked.
     *
     * <p>{@link CollideBlockEvent} is fired when a {@link FishingBobber}
     * becomes stuck in a block. This may be called multiple times
     * before {@link Stop} is fired, such as in the case where
     * the block the {@link FishingBobber} is stuck in is broken.</p>
     */
    interface HookEntity extends FishingEvent, Cancellable {

        /**
         * Gets the {@link Entity}.
         *
         * @return The entity
         */
        Entity getEntity();
    }

    /**
     * A specific {@link FishingEvent} where the {@link FishingBobber} is retracted
     * or "reeled in".
     *
     * <p>If the {@link FishingBobber} was cast into water, an {@link ItemStack} may
     * be hooked when it is retracted. If the event is not cancelled, Vanilla
     * will send one or more {@link ItemStack} by spawning {@link Item}s, and
     * sending them moving towards the player.</p>
     *
     * <p>If the {@link FishingBobber} has an entity hooked, Vanilla will pull
     * the hooked entity towards the caster, if the event is not cancelled.</p>
     */
    interface Stop extends FishingEvent, Cancellable {

        /**
         * Gets a list of {@link Transaction}s for each {@link ItemStackSnapshot}
         * that will be spawned if this event is not cancelled.
         *
         * @return The transactions
         */
        List<Transaction<ItemStackSnapshot>> getTransactions();

    }
}
