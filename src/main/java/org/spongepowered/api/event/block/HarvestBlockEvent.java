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
package org.spongepowered.api.event.block;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.entity.ChangeEntityExperienceEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Base event for when a target {@link BlockState} at a {@link Location} is 
 * being harvested and one or more {@link ItemStack}(s) are dropped.
 */
public interface HarvestBlockEvent extends TargetBlockEvent, ChangeEntityExperienceEvent {

    /**
     * Gets a mutable copy of the original {@link Collection}<{@link ItemStack}>
     * unaffected by changes to this event.
     *
     * @return The mutable Collection of ItemStack
     */
    Collection<ItemStack> getOriginalItemStacks();

    /**
     * Gets a mutable {@link Collection}<{@link ItemStack}> which will be
     * dropped after event resolution.
     *
     * @return The Collection of ItemStack
     */
    Collection<ItemStack> getItemStacks();

    /**
     * Sets the {@link Collection}<{@link ItemStack}> that will be dropped
     * after event resolution.
     *
     * @param items The Collection of ItemStack
     */
    void setItems(Collection<ItemStack> items);

    /**
     * Filters {@link ItemStack}s within {@link 
     * HarvestBlockEvent#getItemStacks()}.
     *
     * <p>The ItemStacks remaining in the Collection will be the ones that will 
     * be dropped. This will be the same Collection returned from {@link 
     * HarvestBlockEvent#getItemStacks()}.</p>
     *
     * @param predicate The predicate to use for filtering.
     * @return The filtered Collection
     */
    Collection<ItemStack> filterItemStacks(Predicate<ItemStack> predicate);

    /**
     * Gets the original chance unmodified by event changes.
     *
     * @return The original chance
     * @see HarvestBlockEvent#getDropChance()
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
     * <p>Keep in mind that your chance is not guaranteed; a plugin or mod could
     * change it afterwards. If the desire is to guarantee that the drop won't 
     * occur, use {@link Cancellable#setCancelled(boolean)} instead (make sure 
     * to pass in true).</p>
     *
     * @param chance The chance
     */
    void setDropChance(float chance);

}
