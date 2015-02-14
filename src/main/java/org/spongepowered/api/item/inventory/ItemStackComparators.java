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

import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A utility class for getting all available {@link Comparator}s for
 * {@link ItemStack}s.
 */
public final class ItemStackComparators {

    /**
     * Compares ItemStacks based on {@link org.spongepowered.api.item.ItemType}.
     * This comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different damage values, or different sizes.
     */
    public static final Comparator<ItemStack> TYPE = new Type();

    /**
     * Compares ItemStacks based on
     * {@link org.spongepowered.api.item.inventory.ItemStack} damage. This
     * comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different types, or different sizes.
     */
    public static final Comparator<ItemStack> DAMAGE = new Damage();

    /**
     * Compares ItemStacks based on
     * {@link org.spongepowered.api.item.inventory.ItemStack} size. This
     * comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different types, or different damage values.
     */
    public static final Comparator<ItemStack> SIZE = new Size();

    /**
     * Compares ItemStacks based on {@link org.spongepowered.api.item.ItemType}
     * and {@link ItemStack}
     * damage. This comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data or
     * different sizes.
     */
    @SuppressWarnings("unchecked")
    public static final Comparator<ItemStack> TYPE_DAMAGE = Ordering.compound(Arrays.asList(TYPE, DAMAGE));

    /**
     * Compares ItemStacks based on {@link org.spongepowered.api.item.ItemType}
     * and {@link ItemStack} size. This comparator will not return the same
     * results as ItemStack.equals(ItemStack) for ItemStacks with extra attached
     * data or different damage values.
     */
    @SuppressWarnings("unchecked")
    public static final Comparator<ItemStack> TYPE_SIZE = Ordering.compound(Arrays.asList(TYPE, SIZE));

    /**
     * Compares ItemStacks based on {@link org.spongepowered.api.item.ItemType},
     * {@link ItemStack} damage and {@link ItemStack} size. This comparator will
     * not return the same results as ItemStack.equals(ItemStack) for ItemStacks
     * with extra attached data.
     */
    @SuppressWarnings("unchecked")
    public static final Comparator<ItemStack> TYPE_DAMAGE_SIZE = Ordering.compound(Arrays.asList(TYPE, DAMAGE, SIZE));

    /**
     * The default comparator for {@link org.spongepowered.api.item.inventory.ItemStack}s.
     */
    public static final Comparator<ItemStack> DEFAULT = TYPE_DAMAGE_SIZE;

    private ItemStackComparators() {}

    static final class Type implements Comparator<ItemStack> {

        @Override
        public int compare(final ItemStack o1, final ItemStack o2) {
            return o1.getItem().getId().compareTo(o2.getItem().getId());
        }

    }

    static final class Damage implements Comparator<ItemStack> {

        @Override
        public int compare(final ItemStack o1, final ItemStack o2) {
            return o1.getDamage() - o2.getDamage();
        }

    }

    static final class Size implements Comparator<ItemStack> {

        @Override
        public int compare(final ItemStack o1, final ItemStack o2) {
            return o1.getQuantity() - o2.getQuantity();
        }

    }

}
