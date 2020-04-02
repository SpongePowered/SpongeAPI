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
package org.spongepowered.api.event.item.inventory;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

/**
 * Fired when an {@link ItemStack} is used.
 */
public interface UseItemStackEvent extends Event {

    /**
     * Gets the original remaining duration of {@link ItemStack} in use.
     *
     * @return The original remaining duration
     */
    int getOriginalRemainingDuration();

    /**
     * Gets the remaining duration of {@link ItemStack} in use.
     *
     * @return The remaining duration
     */
    int getRemainingDuration();

    /**
     * Sets the remaining duration of {@link ItemStack} in use.
     *
     * @param duration The remaining duration to set
     */
    void setRemainingDuration(int duration);

    /**
     * Gets the {@link ItemStack} being consumed.
     *
     * @return The item being consumed
     */
    ItemStackSnapshot getItemStackInUse();

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
     * <p>Note: Cancelling the event, or setting the duration to &lt;= 0
     * prevents the {@link ItemType} from processing.</p>
     */
    interface Start extends UseItemStackEvent, Cancellable  {}

    /**
     * Called after {@link UseItemStackEvent.Start} during each tick as an
     * {@link ItemType} is being used.
     *
     * <p>In Vanilla, tick actions are used to play eating particles and
     * sounds.</p>
     *
     * <p>In Vanilla, items only perform an action every 4 ticks, and only
     * when 25 or fewer ticks remaining. Cancelling this event on other
     * ticks will have no effect in Vanilla.</p>
     *
     * <p>Cancelling the event will cause no action to be taken for the
     * particular item for the tick being processed.</p>
     *
     * <p>Note: Setting the duration 0 will cause the player to finish using
     * the item.</p>
     */
    interface Tick extends UseItemStackEvent, Cancellable {}

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
     * before 'finishing'.</p>
     *
     * <p>In Vanilla, this is only fired for players, not other entities.</p>
     *
     * <p>In Vanilla, setting the duration on this event will have no
     * effect.</p>
     *
     * <p>Cancelling this event will prevent the {@link ItemType} from being
     * notified that it has stopped being used. The only vanilla
     * {@link ItemType} this would affect are bows, and it would cause the bow
     * to NOT fire.</p>
     */
    interface Stop extends UseItemStackEvent, Cancellable {}

    /**
     * Fired when an item is finished 'normally', e.g. used for the
     * entire maximum duration. In contrast to {@link Stop}, this
     * event will not fire if the item use was interrupted in any way.
     *
     * <p>Examples:</p>
     *
     * <ul>
     *     <li>Eating a piece of food</li>
     *     <li>Drinking a potion</li>
     * </ul>
     *
     * <p>This event will always be fired with an original duration
     * of 0. Setting the duration to an integer greater than 0
     * will cause the entity to continue using the item.</p>
     *
     * <p>Cancelling this event prevents the 'finished' action
     * from taking place. For example, this would prevent a Vanilla
     * potion item from apply its effects to a player. {@link Reset}
     * will then be fired, while {@link Replace} will be skipped.</p>
     */
    interface Finish extends UseItemStackEvent, Cancellable {}

    /**
     * Called after {@link Finish}, when the item in the entity's
     * hand is replaced.
     *
     * <p>For example, this event is called to decrement the amount
     * of food in the stack being eaten.</p>
     *
     * <p>In Vanilla, setting the remaining duration for this event
     * is ignored.</p>
     *
     * <p>Cancelling the event, or marking the transaction as invalid,
     * will leave the entity's hand untouched.</p>
     */
    interface Replace extends UseItemStackEvent, Cancellable {

        /**
         * Gets the {@link ItemStack} that is placed in the player's
         * inventory in replacement of the stack that is currently being used.
         *
         * @return The result {@link ItemStack}
         */
        Transaction<ItemStackSnapshot> getItemStackResult();
    }

    /**
     * Called before an entity's used item state is reset.
     *
     * <p>In Vanilla, this usually occurs after {@link Replace} or {@link Stop}.</p>
     *
     * <p>If an entity has finished using an item normally, either
     * by using it for the maximum duration or by stopping
     * prematurely, then {@link Stop} or {@link Finish} will have been called
     * beforehand.</p>
     *
     * <p>If the item use was 'cancelled' without finishing normally,
     * such as an entity switching its held item, then {@link Stop} or {@link Finish}
     * will not have been called.</p>
     *
     * <p>Example:</p>
     *
     * <ul>
     *     <li>A player drawing back a bow, but switching to another hotbar
     *     slot without releasing their secondary mouse button.</li>
     *</ul>
     */
    interface Reset extends UseItemStackEvent {}

}
