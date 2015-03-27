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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.spongepowered.api.item.data.ItemData;
import org.spongepowered.api.item.properties.ItemProperty;

import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

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
     * {@link ItemStack} size. This
     * comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different types, or different damage values.
     */
    public static final Comparator<ItemStack> SIZE = new Size();

    /**
     * Compares ItemStacks based on {@link org.spongepowered.api.item.ItemType}
     * and {@link ItemStack} size. This comparator will not return the same
     * results as ItemStack.equals(ItemStack) for ItemStacks with extra attached
     * data or different damage values.
     */
    @SuppressWarnings("unchecked")
    public static final Comparator<ItemStack> TYPE_SIZE = Ordering.compound(ImmutableList.of(TYPE, SIZE));

    /**
     * The default comparator for {@link ItemStack}s.
     */
    public static final Comparator<ItemStack> DEFAULT = TYPE_SIZE;

    public static final Comparator<ItemStack> PROPERTIES = new Properties();

    public static final Comparator<ItemStack> ITEM_DATA = new ItemDataComparator();

    public static final Comparator<ItemStack> ALL = Ordering.compound(ImmutableList.of(TYPE, SIZE, PROPERTIES, ITEM_DATA));

    private ItemStackComparators() {}

    static final class Type implements Comparator<ItemStack> {

        @Override
        public int compare(@Nullable final ItemStack o1, @Nullable final ItemStack o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getItem().getId().compareTo(o2.getItem().getId());
        }

    }

    static final class Size implements Comparator<ItemStack> {

        @Override
        public int compare(@Nullable final ItemStack o1, @Nullable final ItemStack o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getQuantity() - o2.getQuantity();
        }
    }

    static final class Properties implements Comparator<ItemStack> {

        @Override
        public int compare(@Nullable final ItemStack o1, @Nullable final ItemStack o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            List<ItemProperty<?, ?>> properties = Lists.newArrayList(o2.getProperties());
            for (ItemProperty<?, ?> property : o1.getProperties()) {
                if (properties.contains(property)) {
                    properties.remove(property);
                } else {
                    return -1;
                }
            }
            return properties.size();
        }
    }

    static final class ItemDataComparator implements Comparator<ItemStack> {

        @Override
        public int compare(@Nullable final ItemStack o1, @Nullable final ItemStack o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            List<ItemData<?>> properties = Lists.newArrayList(o2.getItemData());
            for (ItemData<?> property : o1.getItemData()) {
                if (properties.contains(property)) {
                    properties.remove(property);
                } else {
                    return -1;
                }
            }
            return properties.size();
        }
    }
}
