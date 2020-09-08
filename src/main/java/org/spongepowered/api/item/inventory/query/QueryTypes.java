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
package org.spongepowered.api.item.inventory.query;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.PrimaryPlayerInventory;
import org.spongepowered.api.item.inventory.query.QueryType.NoParam;
import org.spongepowered.api.item.inventory.query.QueryType.OneParam;
import org.spongepowered.api.item.inventory.query.QueryType.TwoParam;
import org.spongepowered.math.vector.Vector2i;

import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class QueryTypes {

    // SORTFIELDS:ON

    /**
     * Tests based on the class of the inventory.
     */
    public static final Supplier<OneParam<Class<? extends Inventory>>> INVENTORY_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "inventory_type");

    /**
     * Allows a custom condition for the items contained within an item stack.
     */
    public static final Supplier<OneParam<Predicate<ItemStack>>> ITEM_STACK_CUSTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "item_stack_custom");

    /**
     * Tests for an exact match of the item stack contained in each slot.
     *
     * <p>Generally uses {@link ItemStack}'s <code>#equals</code> method.</p>
     */
    public static final Supplier<OneParam<ItemStack>> ITEM_STACK_EXACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "item_stack_exact");

    /**
     * Tests for an exact match of the item stack contained in each slot, with
     * the exception of the quantity. This allows testing for custom data on
     * item stacks that may be moved and stacked by players.
     *
     * @see ItemStack#equalTo(ItemStack)
     */
    public static final Supplier<OneParam<ItemStack>> ITEM_STACK_IGNORE_QUANTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "item_stack_ignore_quantity");

    /**
     * Tests for a match of the type of item contained in each slot.
     *
     * @see ItemStack#getType()
     */
    public static final Supplier<OneParam<ItemType>> ITEM_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "item_type");

    /**
     * Tests based on an inventory property present on the target inventory.
     *
     * @see Inventory#get(Inventory, Key)
     */
    public static final Supplier<OneParam<KeyValueMatcher<?>>> KEY_VALUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "key_value");

    /**
     * Tests based on the class of the inventory.
     */
    public static final Supplier<OneParam<Class<?>>> TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "type");

    /**
     * Query for a modified order of slots in a player inventory.
     * Ordering the {@link Hotbar} before the {@link PrimaryPlayerInventory}
     */
    public static final Supplier<NoParam> PLAYER_PRIMARY_HOTBAR_FIRST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "player_primary_hotbar_first");

    /**
     * Query for a reverse order of slots.
     */
    public static final Supplier<NoParam> REVERSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "reverse");

    /**
     * A grid query. Only works on grids. The first value is the offset the second value is the grid size.
     */
    public static final Supplier<TwoParam<Vector2i, Vector2i>> GRID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(QueryType.class, "grid");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private QueryTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
