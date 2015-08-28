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

package org.spongepowered.api.event.target.entity;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.source.entity.EntityEvent;
import org.spongepowered.api.event.source.entity.living.LivingEvent;
import org.spongepowered.api.event.source.entity.living.human.HumanEvent;
import org.spongepowered.api.event.source.entity.living.human.player.PlayerEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import javax.annotation.Nullable;

public interface FishingEvent extends GameEvent, Cancellable {

    FishHook getFishHook();

    interface Cast extends FishingEvent {

        interface SourceEntity extends Cast, FishingEvent.SourceEntity { }

        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }
    }

    interface Hook extends FishingEvent, TargetEntityEvent {

        interface SourceEntity extends Hook, FishingEvent.SourceEntity { }

        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }
    }

    /**
     * A specific {@link FishingEvent} where the {@link FishHook} is retracted
     * or "reeled in".
     */
    interface Retract extends FishingEvent {

        /**
         * Gets the {@link ItemStackSnapshot} that will be given, if
         * available.
         *
         * @return The item stack snapshot that will be given
         */
        Optional<ItemStackSnapshot> getCaughtItem();

        /**
         * Sets the {@link ItemStackSnapshot} that will be given,
         * if available.
         *
         * @param item The item stack snapshot to set
         */
        void setCaughtItem(@Nullable ItemStackSnapshot item);

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

        interface SourceEntity extends Retract, FishingEvent.SourceEntity { }

        interface SourceLiving extends SourceEntity, FishingEvent.SourceLiving { }

        interface SourceHuman extends SourceLiving, FishingEvent.SourceHuman { }

        interface SourcePlayer extends SourceHuman, FishingEvent.SourcePlayer { }
    }

    interface SourceEntity extends FishingEvent, EntityEvent { }

    interface SourceLiving extends SourceEntity, LivingEvent { }

    interface SourceHuman extends SourceLiving, HumanEvent { }

    interface SourcePlayer extends SourceHuman, PlayerEvent { }

}
