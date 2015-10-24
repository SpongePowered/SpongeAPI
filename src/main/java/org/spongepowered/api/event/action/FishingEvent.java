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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.block.TargetBlockEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.entity.ChangeEntityExperienceEvent;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Optional;

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
     * An event where the {@link FishHook} is cast.
     *
     * <p>This is fired before the {@link FishHook} has been spawned in the world.</p>
     */
    interface Start extends FishingEvent, Cancellable {}

    /**
     * Fired when an {@link org.spongepowered.api.entity.Entity} is hooked.
     *
     * <p>{@link CollideBlockEvent} is fired when a {@link FishHook}
     * becomes stuck in a block. This may be called multiple times
     * before {@link Stop} is fired, such as in the case where
     * the block the {@link FishHook} is stuck in is broken.</p>
     */
    interface HookEntity extends FishingEvent, TargetEntityEvent, Cancellable {}

    /**
     * A specific {@link FishingEvent} where the {@link FishHook} is retracted
     * or "reeled in".
     *
     * <p>If the {@link FishHook} was cast into water, an {@link ItemStack} may
     * be hooken when it is retracted. If the event is not cancelled, Vanilla
     * will send the @link ItemStackby spawning an {@link Item},
     * and sending it moving towards the player.
     *
     * If the {@link FishHook} has an entity hooked, Vanilla will pull
     * the hooked entity towards the caster, if the event is not cancelled.</p>
     *
     * <p>In Vanilla, {@link Transaction#getOriginal() the original {@link ItemStack}}
     * will usually be a {@link Fish}, or miscellaneous item.</p>
     */
    interface Stop extends FishingEvent, ChangeEntityExperienceEvent, Cancellable {

        /**
         * Gets the {@link Transaction} that is the transaction
         * involving the {@link ItemStack}, If you wish to
         * change the itemstack result, use {@link Transaction#setCustom(DataSerializable)}
         *
         * <p>The special item type {@link ItemTypes#NONE} is used to represent
         * no item being caught,</p>
         *
         * @return The itemstack transaction
         */
        Transaction<ItemStackSnapshot> getItemStackTransaction();
    }
}
