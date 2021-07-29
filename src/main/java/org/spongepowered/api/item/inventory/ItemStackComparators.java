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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.ItemType;

import java.util.Comparator;

/**
 * A utility class for getting all available {@link Comparator}s for {@link ItemStack}s.
 */
public final class ItemStackComparators {

    /**
     * Compares ItemStacks based on {@link ItemType}.
     * This comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different damage values, or different sizes.
     */
    public static final Comparator<ItemStack> TYPE = Sponge.game().factoryProvider().provide(Factory.class).byType().build();

    /**
     * Compares ItemStacks based on
     * {@link ItemStack} size. This
     * comparator will not return the same results as
     * ItemStack.equals(ItemStack) for ItemStacks with extra attached data,
     * different types, or different damage values.
     */
    public static final Comparator<ItemStack> SIZE = Sponge.game().factoryProvider().provide(Factory.class).bySize().build();

    /**
     * Compares ItemStacks based on {@link ItemType}
     * and {@link ItemStack} size. This comparator will not return the same
     * results as ItemStack.equals(ItemStack) for ItemStacks with extra attached
     * data or different damage values.
     */
    public static final Comparator<ItemStack> TYPE_SIZE = Sponge.game().factoryProvider().provide(Factory.class).byType().bySize().build();

    /**
     * The default comparator for {@link ItemStack}s.
     */
    public static final Comparator<ItemStack> DEFAULT = Sponge.game().factoryProvider().provide(Factory.class).byType().bySize().build();

    /**
     * Compares ItemStacks based on their {@link Value}s.
     */
    public static final Comparator<ItemStack> ITEM_DATA = Sponge.game().factoryProvider().provide(Factory.class).byData().byDurability().build();

    /**
     * Compares ItemStacks based on their {@link Value}s ignoring {@link Keys#ITEM_DURABILITY}.
     */
    public static final Comparator<ItemStack> ITEM_DATA_IGNORE_DURABILITY = Sponge.game().factoryProvider().provide(Factory.class).byData().build();

    /**
     * Compares ItemStacks only ignoring their stack-size.
     *
     * <p>This means for stackable items that they can stack together</p>
     */
    public static final Comparator<ItemStack> IGNORE_SIZE = Sponge.game().factoryProvider().provide(Factory.class).byType().byData().byDurability().build();

    public static final Comparator<ItemStack> ALL = Sponge.game().factoryProvider().provide(Factory.class).byType().byData().byDurability().bySize().build();

    public interface Factory {

        Factory byType();

        Factory byData();

        Factory byDurability();

        Factory bySize();

        Comparator<ItemStack> build();
    }

    private ItemStackComparators() {
    }
}
