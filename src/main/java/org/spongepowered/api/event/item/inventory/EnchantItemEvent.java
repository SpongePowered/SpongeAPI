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

import org.spongepowered.api.event.item.inventory.container.ClickContainerEvent;
import org.spongepowered.api.event.item.inventory.container.InteractContainerEvent;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;

import java.util.List;

public interface EnchantItemEvent extends InteractContainerEvent {

    /**
     * The seed for pseudo random enchantment generation.
     *
     * @return the seed
     */
    int getSeed();

    /**
     * The enchantment option. 1, 2 or 3
     *
     * @return The enchantment option
     */
    int getOption();

    /**
     * Triggers when the enchantment costs for an item are calculated.
     */
    interface CalculateLevelRequirement extends EnchantItemEvent {

        /**
         * The enchantment power based on bookshelves around the enchantment table.
         *
         * @return the enchantment power
         */
        int getPower();

        /**
         * The itemstack to enchant.
         *
         * @return the itemstack to enchant.
         */
        ItemStackSnapshot getItem();

        /**
         * Returns the original level requirement
         *
         * @return the original level requirement
         */
        int getOriginalLevelRequirement();

        /**
         * Returns the level requirement
         *
         * @return the level requirement
         */
        int getLevelRequirement();

        /**
         * Sets the new level requirement
         * <p>In vanilla the maximum value is 30.</p>
         * <p>Returning a much higher level may result in no enchantments
         * because the existing enchantments are too weak.</p>
         *
         * @param value the new level requrement
         */
        void setLevelRequirement(int value);
    }

    /**
     * Triggers when the enchantments for an item are calculated.
     * This happens after a new item to enchant is put in the table
     * and again when the item is enchanted.
     */
    interface CalculateEnchantment extends EnchantItemEvent {

        /**
         * The itemstack to enchant.
         *
         * @return the itemstack to enchant.
         */
        ItemStackSnapshot getItem();

        /**
         * The final level requirement from {@link CalculateLevelRequirement}.
         * <p>In vanilla the maximum value is 30.</p>
         *
         * @return the level requirement for the option
         */
        int getLevelRequirement();

        /**
         * Returns the original list of enchantments to apply to the item.
         * <p>The first item in the list is used for display when previewing the enchantments.</p>
         *
         * @return the list of enchantments
         */
        List<Enchantment> getOriginalEnchantments();

        /**
         * Returns the list of enchantments to apply to the item.
         * <p>The first item in the list is used for display when previewing the enchantments.</p>
         *
         * @return the list of enchantments
         */
        List<Enchantment> getEnchantments();

        /**
         * Sets the list of enchantments to apply to the item.
         *
         * <p>The first item in the list is used for display when previewing the enchantments.</p>
         * <p>Note that when modifying the enchantment list you should
         * return the same enchantments for the same seed and option.</p>
         * <p>See {@link Enchantment#randomListBuilder()} to generate enchantment lists.</p>
         *
         * @param enchantments the new list of enchantments
         */
        void setEnchantments(List<Enchantment> enchantments);
    }

    /**
     * This event is triggered when an item is enchanted at an enchanting table.
     */
    interface Post extends ClickContainerEvent, EnchantItemEvent {
        /**
         * Returns the slot of the enchanted item.
         *
         * @return the slot if the enchanted item.
         */
        Slot getEnchantingSlot();

    }

}
