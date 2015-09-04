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

package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackTransaction;

import javax.annotation.Nullable;

/**
 * An event when a "fishing" action is performed. Always involves a
 * {@link FishHook}.
 */
public interface FishingEvent extends GameEvent, Cancellable {

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
    interface Cast extends FishingEvent {

        /**
         * An event where the source is an {@link Entity}.
         */
        interface SourceEntity extends Cast, FishingEvent.SourceEntity { }

        /**
         * An event where the source is a {@link Living}.
         */
        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        /**
         * An event where the source is a {@link Human}.
         */
        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        /**
         * An event where the source is an {@link Player}.
         */
        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }

    }

    /**
     * An event where an {@link Entity} is "hooked" by the {@link FishHook}.
     */
    interface Hook extends FishingEvent, TargetEntityEvent {

        /**
         * An event where the source is an {@link Entity}.
         */
        interface SourceEntity extends Hook, FishingEvent.SourceEntity { }

        /**
         * An event where the source is a {@link Living}.
         */
        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        /**
         * An event where the source is a {@link Human}.
         */
        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        /**
         * An event where the source is an {@link Player}.
         */
        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }

    }

    /**
     * A specific {@link FishingEvent} where the {@link FishHook} is retracted
     * or "reeled in".
     */
    interface Retract extends FishingEvent, TargetEntityEvent {

        /**
         * Gets te {@link ItemStackTransaction} that is the transaction involving the {@link ItemStack}.
         * @return The itemstack transaction
         */
        ItemStackTransaction getTargetItemStackTransaction();

        /**
         * Gets the original {@link EntitySnapshot} being targeted.
         * @return The snapshot
         */
        EntitySnapshot getOriginalTargetEntity();

        /**
         * Sets the {@link Entity} hooked, if available.
         *
         * @param entity The hooked {@link Entity} to set
         */
        void setCaughtEntity(@Nullable Entity entity);

        /**
         * An event where the source is an {@link Entity}.
         */
        interface SourceEntity extends Retract, FishingEvent.SourceEntity { }

        /**
         * An event where the source is a {@link Living}.
         */
        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        /**
         * An event where the source is a {@link Human}.
         */
        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        /**
         * An event where the source is an {@link Player}.
         */
        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }
    }

    /**
     * An event where the source is an {@link Entity}.
     */
    interface SourceEntity extends FishingEvent, EntityEvent { }

    /**
     * An event where the source is a {@link Living}.
     */
    interface SourceLiving extends SourceEntity, LivingEvent { }

    /**
     * An event where the source is a {@link Human}.
     */
    interface SourceHuman extends SourceLiving, HumanEvent { }

    /**
     * An event where the source is an {@link Player}.
     */
    interface SourcePlayer extends SourceHuman, PlayerEvent { }

}
