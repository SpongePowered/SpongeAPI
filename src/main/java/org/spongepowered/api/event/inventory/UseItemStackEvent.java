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

package org.spongepowered.api.event.inventory;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;
import org.spongepowered.api.potion.PotionEffectType;

public interface UseItemStackEvent extends GameEvent, Cancellable, CauseTracked {

    /**
     * Gets the {@link ItemStack} being consumed.
     *
     * @return The item being consumed
     */
    ItemStackTransaction getItemStackInUse();

    /**
     * Sets the item to be consumed.
     *
     * @param item The item being consumed
     */
    void setItemStackInUse(ItemStackSnapshot item);

    /**
     * Called before {@link UseItemStackEvent.Tick} when a player starts using an
     * {@link ItemType}, typically when they hold right mouse.
     * 
     * <p>Examples:</p>
     * 
     * <ul>
     *     <li>Drawing a bow</li>
     *     <li>Eating food</li>
     *     <li>Drinking Potions/Milk</li>
     *     <li>Guarding with a sword</li>
     * </ul>
     * 
     * <p>Note: Cancelling the event, or setting the duration to <= 0
     * prevents the {@link ItemType} from processing.</p>
     */
    interface Start extends UseItemStackEvent {}

    /**
     * Called after {@link UseItemStackEvent.Start} during each tick as an {@link ItemType} is
     * being used.
     *
     * <p>Note: Cancelling the event, or setting the duration <= 0 will cause
     * the player to stop using the item.</p>
     */
    interface Tick extends UseItemStackEvent {}

    /**
     * Called after {@link UseItemStackEvent.Tick} when an {@link ItemType} has finished being
     * used.
     * 
     * <p>Examples:</p>
     * 
     * <ul>
     *     <li>Stop eating halfway through</li>
     *     <li>Stop defending with sword</li>
     *     <li>Stop drawing bow. This case would fire the arrow</li>
     * </ul>
     * 
     * <p>Duration on this event is how long the item had left in its countdown 
     * before 'finishing'
     *
     * Cancelling this event will prevent the {@link ItemType} from being 
     * notified that it has stopped being used. The only vanilla 
     * {@link ItemType} this would affect are bows, and it would cause the bow
     * to NOT fire.</p>
     */
    interface Stop extends UseItemStackEvent {}

    /**
     * Called after {@link UseItemStackEvent.Stop} when an {@link ItemType} has finished being
     * used.
     * 
     * <p>Example:</p>
     * 
     * <ul>
     *     <li>After the player consumed a {@link PotionEffectType} that's
     *     already applied.</li>
     *</ul>
     */
    interface Finish extends UseItemStackEvent {}

}
