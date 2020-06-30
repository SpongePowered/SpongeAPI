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
package org.spongepowered.api.item.enchantment;

import net.kyori.adventure.text.ComponentLike;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.entity.EnchantmentTable;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a modifier on an item that has various effects.
 */
@CatalogedBy(EnchantmentTypes.class)
public interface EnchantmentType extends CatalogType, ComponentLike {

    /**
     * Gets the weight of this enchantment type.
     *
     * <p>Higher values are more common. This value is also used in the repair
     * cost calculation.</p>
     *
     * @return The weight of this enchantment type
     */
    int getWeight();

    /**
     * Gets the minimum level of this enchantment type allowed where
     * it is present.
     *
     * @return The minimum level
     */
    int getMinimumLevel();

    /**
     * Gets the maximum level of this enchantment type normally allowed.
     *
     * @return The maximum level
     */
    int getMaximumLevel();

    /**
     * Gets the minimum item enchantability for this level to be normally added
     * by enchanting tables.
     *
     * @param level The enchantment type level
     * @return The minimum enchantability
     */
    int getMinimumEnchantabilityForLevel(int level);

    /**
     * Gets the maximum item enchantability for this level to be normally added
     * by enchanting tables.
     *
     * @param level The enchantment type level
     * @return The maximum enchantability
     */
    int getMaximumEnchantabilityForLevel(int level);

    /**
     * Test if this enchantment type can be applied to an {@link ItemStack}.
     *
     * @param stack The item stack to check
     * @return Whether this enchantment type can be applied
     */
    boolean canBeAppliedToStack(ItemStack stack);

    /**
     * Test if this enchantment type can be applied to an {@link ItemStack} by
     * the {@link EnchantmentTable}.
     *
     * @param stack Te item stack to check
     * @return Whether this enchantment type can be applied by the
     *     enchantment table
     */
    boolean canBeAppliedByTable(ItemStack stack);

    /**
     * Test if this enchantment type can be applied along with
     * another enchantment type.
     *
     * @param enchantmentType The enchantment type to test compatibility with
     * @return Whether these enchantment types are compatible
     */
    boolean isCompatibleWith(EnchantmentType enchantmentType);

    /**
     * Gets whether or not this enchantment type is considered a "treasure"
     * enchantment.
     *
     * <p>These do not occur naturally in enchantment tables.</p>
     *
     * @return Whether this enchantment type is a treasure enchantment type
     */
    boolean isTreasure();

    /**
     * Gets whether or not this enchantment type is considered a "curse"
     * enchantment.
     *
     * @return Whether this enchantment type is a curse enchantment type
     */
    boolean isCurse();

}
