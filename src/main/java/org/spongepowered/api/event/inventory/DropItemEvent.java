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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.block.TargetBlockEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.entity.item.AffectItemEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.world.Location;

import java.util.List;

/**
 * Handles when one or more {@link Item} or {@link ItemStack} are about to be 
 * "dropped" onto the ground. This will happen before they are physically 
 * dropped, let alone spawned.
 */
public interface DropItemEvent extends GameEvent, Cancellable, CauseTracked {

    /**
     * Handles {@link ItemStack}s and may be called before an {@link Item} 
     * entity is actually constructed.
     * 
     * <p>Note: This is not guaranteed to fire due to custom handling within
     * a mod or plugin.</p>
     */
    public interface Pre extends DropItemEvent { 

        /**
         * Gets the original immutable list of {@link ItemStackSnapshot}s to be
         * dropped.
         *
         * @return The original list of dropped items
         */
        List<ItemStackSnapshot> getOriginalDroppedItems();

        /**
         * Gets the mutable list of {@link ItemStackSnapshot}s to be dropped.
         *
         * @return The list of dropped itemstacks
         */
        List<ItemStackSnapshot> getDroppedItems();

    }

    /**
     * Called when one or more {@link Item} drops are triggered by an 
     * {@link Entity} destruction.
     */
    public interface Destruct extends DropItemEvent, AffectItemEvent {}

    /**
     * Called whenever one or more {@link Item} drops are dispensed from a Block
     * container.
     * 
     * <p>This does not include cases where the holder is destroyed resulting in
     * dropped {@link Item}s.</p>
     * 
     * <p>Cancelling the event will stop the items from entering the world, but 
     * will not prevent them being removed from the inventory.</p>
     */
    public interface Dispense extends DropItemEvent, AffectItemEvent {}

    /**
     * Called whenever an {@link Item} is tossed from a {@link Player}'s
     * or {@link Human}'s {@link Inventory}.
     * 
     * <p>This does not include cases where the holder is destroyed resulting in
     * dropped {@link Item}s.</p>
     * 
     * <p>Cancelling the event will stop the items from entering the world, but 
     * will not prevent them being removed from the inventory.</p>
     */
    public interface Toss extends DropItemEvent, AffectItemEvent {}

    /**
     * Called when a target {@link BlockState} at a {@link Location} is 
     * being harvested and one or more {@link ItemStack}(s) are dropped.
     */
    public interface Harvest extends DropItemEvent.Pre, TargetBlockEvent {

        /**
         * Gets the original chance unmodified by event changes.
         *
         * @see HarvestBlockEvent#getDropChance()
         *
         * @return The original chance
         */
        float getOriginalDropChance();

        /**
         * Gets the chance the result from {@link HarvestBlockEvent#getItemStacks()} 
         * will be dropped.
         *
         * <p>A value of 0.0f means 0% chance of drop whereas 1.0f means 100% 
         * chance of drop.</p>
         *
         * @return The chance
         */
        float getDropChance();

        /**
         * Sets the chance the result from {@link HarvestBlockEvent#getItemStacks()}
         * will drop.
         *
         * <p>A value of 0.0f means 0% chance of drop whereas 1.0f means 100% chance
         * of drop. Any value below 0.0f will be grounded at 0 and likewise any 
         * value above 1.0f will be capped at 1.0f.</p>
         *
         * Keep in mind that your chance is not guaranteed; a plugin or mod could 
         * change it afterwards. If the desire is to guarantee that the drop won't 
         * occur, use {@link Cancellable#setCancelled(boolean)} instead (make sure 
         * to pass in true).
         *
         * @param chance The chance
         */
        void setDropChance(float chance);

    }
}
