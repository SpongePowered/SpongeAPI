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
package org.spongepowered.api.item.inventory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.DamageableData;
import org.spongepowered.api.item.ItemType;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

/**
 * A utility class for getting all available {@link Comparator}s for
 * {@link ItemStack}s.
 */
public final class ItemStackComparators {

    /**
     * Compares ItemStacks based on {@link ItemType}.
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
     * Compares ItemStacks based on {@link ItemType}
     * and {@link ItemStack} size. This comparator will not return the same
     * results as ItemStack.equals(ItemStack) for ItemStacks with extra attached
     * data or different damage values.
     */
    public static final Comparator<ItemStack> TYPE_SIZE = Ordering.compound(ImmutableList.of(TYPE, SIZE));

    /**
     * The default comparator for {@link ItemStack}s.
     */
    public static final Comparator<ItemStack> DEFAULT = TYPE_SIZE;

    /**
     * Compares ItemStacks based on its {@link Property} list.
     */
    public static final Comparator<ItemStack> PROPERTIES = new Properties();

    /**
     * Compares ItemStacks based on their {@link DataManipulator}s.
     */
    public static final Comparator<ItemStack> ITEM_DATA = new ItemDataComparator();

    /**
     * Compares ItemStacks based on their {@link DataManipulator}s ignoring {@link DamageableData}
     */
    public static final Comparator<ItemStack> ITEM_DATA_IGNORE_DAMAGE = new ItemDataComparator(DamageableData.class);

    /**
     * Compares ItemStacks only ignoring their stack-size.
     *
     * <p>This means for stackable items that they can stack together</p>
     */
    public static final Comparator<ItemStack> IGNORE_SIZE = Ordering.compound(ImmutableList.of(TYPE, PROPERTIES, ITEM_DATA));

    public static final Comparator<ItemStack> ALL = Ordering.compound(ImmutableList.of(TYPE, SIZE, PROPERTIES, ITEM_DATA));

    // Suppress default constructor to ensure non-instantiability.
    private ItemStackComparators() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

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
            return o1.getType().getName().compareTo(o2.getType().getName());
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
            List<Property<?, ?>> properties = Lists.newArrayList(o2.getApplicableProperties());
            for (Property<?, ?> property : o1.getApplicableProperties()) {
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

        private final Class<? extends DataManipulator<?, ?>>[] ignored;

        public ItemDataComparator(Class<? extends DataManipulator<?, ?>>... ignored) {
            this.ignored = ignored;
        }

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
            List<DataManipulator<?, ?>> manipulators = Lists.newArrayList(o2.getContainers());
            for (final DataManipulator<?, ?> manipulator : o1.getContainers()) {
                if (manipulators.contains(manipulator)) {
                    manipulators.remove(manipulator);
                } else if (!isIgnored(manipulators, manipulator)) {
                    return -1;
                }
            }
            return manipulators.size();
        }

        private boolean isIgnored(List<DataManipulator<?, ?>> list, DataManipulator<?, ?> toCheck) {
            for (Class<? extends DataManipulator<?, ?>> ignore : this.ignored) {
                if (ignore.isAssignableFrom(toCheck.getClass())) {
                    list.removeIf(manip -> ignore.isAssignableFrom(manip.getClass()));
                    return true;
                }
            }
            return false;
        }
    }
}
