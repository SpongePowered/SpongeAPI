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

package org.spongepowered.api.event.target.inventory;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.source.entity.EntityEvent;
import org.spongepowered.api.event.source.entity.living.LivingEvent;
import org.spongepowered.api.event.source.entity.living.human.HumanEvent;
import org.spongepowered.api.event.source.entity.living.human.player.PlayerEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;

public interface UseItemStackEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets the {@link ItemStack} being consumed.
     *
     * @return The item being consumed
     */
    ItemStackTransaction getConsumedItem();

    /**
     * Sets the item to be consumed.
     *
     * @param item The item being consumed
     */
    void setItem(ItemStackSnapshot item);

    interface Start extends UseItemStackEvent { }

    interface Tick extends UseItemStackEvent { }

    interface Stop extends UseItemStackEvent { }

    interface Finish extends UseItemStackEvent { }

    interface SourceEntity extends UseItemStackEvent, EntityEvent {

        interface Start extends SourceEntity, UseItemStackEvent.Start { }

        interface Tick extends SourceEntity, UseItemStackEvent.Tick { }

        interface Stop extends SourceEntity, UseItemStackEvent.Stop { }

        interface Finish extends SourceEntity, UseItemStackEvent.Finish { }

    }

    interface SourceLiving extends SourceEntity, LivingEvent {

        interface Start extends SourceLiving, SourceEntity.Start { }

        interface Tick extends SourceLiving, SourceEntity.Tick { }

        interface Stop extends SourceLiving, SourceEntity.Stop { }

        interface Finish extends SourceLiving, SourceEntity.Finish { }

    }


    interface SourceHuman extends SourceLiving, HumanEvent {

        interface Start extends SourceHuman, SourceLiving.Start { }

        interface Tick extends SourceHuman, SourceLiving.Tick { }

        interface Stop extends SourceHuman, SourceLiving.Stop { }

        interface Finish extends SourceHuman, SourceLiving.Finish { }

    }


    interface SourcePlayer extends SourceHuman, PlayerEvent {

        interface Start extends SourcePlayer, SourceHuman.Start { }

        interface Tick extends SourcePlayer, SourceHuman.Tick { }

        interface Stop extends SourcePlayer, SourceHuman.Stop { }

        interface Finish extends SourcePlayer, SourceHuman.Finish { }

    }

}
