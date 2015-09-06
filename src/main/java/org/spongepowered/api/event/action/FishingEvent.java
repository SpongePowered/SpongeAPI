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

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.entity.ChangeEntityExperienceEvent;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;

import javax.annotation.Nullable;

/**
 * An event when a "fishing" action is performed. Always involves a
 * {@link FishHook}.
 */
public interface FishingEvent extends GameEvent, CauseTracked {

    /**
     * Gets the original {@link FishHook}, as a {@link EntitySnapshot}.
     * @return The original fish hook
     */
    EntitySnapshot getOriginalFishHook();

    /**
     * Gets the {@link FishHook} related with this event.
     *
     * @return The fish hook
     */
    FishHook getFishHook();

    /**
     * An event where the {@link FishHook} is casted.
     */
    interface Start extends FishingEvent, Cancellable {}

    /**
     * An event where an {@link Entity} is "hooked" by the {@link FishHook}.
     */
    interface Hook extends FishingEvent, TargetEntityEvent, Cancellable {

        /**
         * Gets the original hooked {@link Entity}.
         * 
         * @return The {@link Entity} snapshot
         */
        EntitySnapshot getOriginalHookedEntity();

        /**
         * Gets the {@link Entity} hooked, if available.
         *
         * @return The hooked {@link Entity}, if available
         */
        Optional<Entity> getHookedEntity();

        /**
         * Sets the {@link Entity} hooked, if available.
         *
         * @param entity The hooked {@link Entity} to set
         */
        void setHookedEntity(@Nullable Entity entity);

    }

    /**
     * A specific {@link FishingEvent} where the {@link FishHook} is retracted
     * or "reeled in".
     */
    interface Stop extends FishingEvent, ChangeEntityExperienceEvent, Cancellable {

        /**
         * Gets the {@link ItemStackTransaction} that is the transaction 
         * involving the {@link ItemStack}, if available. If you wish to
         * change the itemstack result, use {@link 
         * ItemStackTransaction#setCustom(ItemStackSnapshot)}
         * 
         * @return The itemstack transaction, if available
         */
        Optional<ItemStackTransaction> getItemStackTransaction();

        /**
         * Gets the original caught {@link Entity} if available.
         * 
         * @return The {@link Entity} snapshot, if available
         */
        Optional<EntitySnapshot> getOriginalCaughtEntity();

        /**
         * Gets the {@link Entity} hooked, if available.
         *
         * @return The hooked {@link Entity}
         */
        Optional<Entity> getCaughtEntity();

        /**
         * Sets the {@link Entity} hooked, if available.
         *
         * @param entity The hooked {@link Entity} to set
         */
        void setCaughtEntity(@Nullable Entity entity);
    }

    interface Finish extends FishingEvent {}
}
