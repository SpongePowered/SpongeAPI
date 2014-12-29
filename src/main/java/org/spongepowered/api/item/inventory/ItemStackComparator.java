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

package org.spongepowered.api.item.inventory;

import java.util.Comparator;

public class ItemStackComparator {

    /**
     * Compares ItemStacks based on Item type, damage, and stack size. This comparator
     * will not return the same results as ItemStack.equals(ItemStack) for ItemStacks
     * with extra attached data.
     */
    public static class TypeDamageSize implements Comparator<ItemStack> {

        @Override
        public int compare(ItemStack o1, ItemStack o2) {
            int itemTypeCompare = Integer.signum(o1.getItem().getId().compareTo(o2.getItem().getId()));

            if (itemTypeCompare == 0) {
                int itemDamageCompare = Integer.signum(o1.getDamage() - o2.getDamage());

                if (itemDamageCompare == 0) {
                    return Integer.signum(o1.getQuantity() - o2.getQuantity());
                } else {
                    return itemDamageCompare;
                }
            } else {
                return itemTypeCompare;
            }
        }
    }

    /**
     * Compares ItemStacks based on Item type, and stack size. This comparator
     * will not return the same results as ItemStack.equals(ItemStack) for ItemStacks
     * with extra attached data, or different damage values.
     */
    public static class TypeSize implements Comparator<ItemStack> {

        @Override
        public int compare(ItemStack o1, ItemStack o2) {
            int itemTypeCompare = Integer.signum(o1.getItem().getId().compareTo(o2.getItem().getId()));

            if (itemTypeCompare == 0) {
                return Integer.signum(o1.getQuantity() - o2.getQuantity());
            } else {
                return itemTypeCompare;
            }
        }
    }

    /**
     * Compares ItemStacks based on Item type and damage. This comparator
     * will not return the same results as ItemStack.equals(ItemStack) for ItemStacks
     * with extra attached data or different sizes.
     */
    public static class TypeDamage implements Comparator<ItemStack> {

        @Override
        public int compare(ItemStack o1, ItemStack o2) {
            int itemTypeCompare = Integer.signum(o1.getItem().getId().compareTo(o2.getItem().getId()));

            if (itemTypeCompare == 0) {
                return Integer.signum(o1.getDamage() - o2.getDamage());
            } else {
                return itemTypeCompare;
            }
        }
    }

    /**
     * Compares ItemStacks based on Item type. This comparator
     * will not return the same results as ItemStack.equals(ItemStack) for ItemStacks
     * with extra attached data, different damage values, or different sizes.
     */
    public static class Type implements Comparator<ItemStack> {

        @Override
        public int compare(ItemStack o1, ItemStack o2) {
            return Integer.signum(o1.getItem().getId().compareTo(o2.getItem().getId()));
        }
    }
}
