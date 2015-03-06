/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.item;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a modifier on an item that has various effects.
 */
@CatalogedBy(Enchantments.class)
public interface Enchantment extends Translatable {

    /**
     * Gets the id of this enchantment.
     *
     * <p>Ex. Minecraft registers Efficiency as
     * "minecraft:efficiency".</p>
     *
     * @return The id
     */
    String getId();

    /**
     * Get the weight of the enchantment.
     *
     * <p>Higher values are more common. This value is also used in the repair
     * cost calculation.</p>
     *
     * @return The weight
     */
    int getWeight();

    /**
     * Get the minimum level of this enchantment allowed where it is present.
     *
     * @return The minimum level
     */
    int getMinimumLevel();

    /**
     * Get the maximum level of this enchantment normally allowed.
     *
     * @return The maximum level
     */
    int getMaximumLevel();

    /**
     * Get the minimum item enchantibility for this level to be normally added
     * by enchanting tables.
     *
     * @param level Enchantment level
     * @return Minimum enchantability
     */
    int getMinimumEnchantabilityForLevel(int level);

    /**
     * Get the maximum item enchantibility for this level to be normally added
     * by enchanting tables.
     *
     * @param level Enchantment level
     * @return Maximum enchantability
     */
    int getMaximumEnchantabilityForLevel(int level);

    /**
     * Test if this enchantment can be applied to an ItemStack.
     *
     * @param stack ItemStack to check
     * @return Whether this enchantment can be applied
     */
    boolean canBeAppliedToStack(ItemStack stack);

    /**
     * Test if this enchantment can be applied to an ItemStack by the Enchanting Table.
     *
     * @param stack ItemStack to check
     * @return Whether this enchantment can be applied by the Enchanting Table
     */
    boolean canBeAppliedByTable(ItemStack stack);

    /**
     * Test if this enchantment can be applied along with another enchantment.
     *
     * @param ench Enchantment to test compatibility with
     * @return Whether these enchantments are compatible
     */
    boolean isCompatibleWith(Enchantment ench);
}
