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

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryKeys;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.PrimaryPlayerInventory;
import org.spongepowered.api.item.inventory.query.QueryType.NoParam;
import org.spongepowered.api.item.inventory.query.QueryType.OneParam;
import org.spongepowered.api.item.inventory.query.QueryType.TwoParam;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.Nameable;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.math.vector.Vector2i;

import java.util.function.Predicate;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class QueryTypes {

    // SORTFIELDS:ON

    /**
     * TODO property instead?
     * Tests based on the title of the inventory.
     *
     * @see InventoryKeys#TITLE
     * @see Nameable.Translatable#getNameTranslation()
     */
    public static final OneParam<Translation> INVENTORY_TRANSLATION = DummyObjectProvider.createExtendedFor(OneParam.class, "INVENTORY_TRANSLATION");

    /**
     * Tests based on the class of the inventory.
     */
    public static final OneParam<Class<? extends Inventory>> INVENTORY_TYPE = DummyObjectProvider.createExtendedFor(OneParam.class, "INVENTORY_TYPE");

    /**
     * Allows a custom condition for the items contained within an item stack.
     */
    public static final OneParam<Predicate<ItemStack>> ITEM_STACK_CUSTOM = DummyObjectProvider.createExtendedFor(OneParam.class, "ITEM_STACK_CUSTOM");

    /**
     * Tests for an exact match of the item stack contained in each slot.
     *
     * <p>Generally uses {@link ItemStack}'s <code>#equals</code> method.</p>
     */
    public static final OneParam<ItemStack> ITEM_STACK_EXACT = DummyObjectProvider.createExtendedFor(OneParam.class, "ITEM_STACK_EXACT");

    /**
     * Tests for an exact match of the item stack contained in each slot, with
     * the exception of the quantity. This allows testing for custom data on
     * item stacks that may be moved and stacked by players.
     *
     * @see ItemStack#equalTo(ItemStack)
     */
    public static final OneParam<ItemStack> ITEM_STACK_IGNORE_QUANTITY = DummyObjectProvider.createExtendedFor(OneParam.class, "ITEM_STACK_IGNORE_QUANTITY");

    /**
     * Tests for a match of the type of item contained in each slot.
     *
     * @see ItemStack#getType()
     */
    public static final OneParam<ItemType> ITEM_TYPE = DummyObjectProvider.createExtendedFor(OneParam.class, "ITEM_TYPE");

    /**
     * Tests based on an inventory property present on the target inventory.
     *
     * @see Inventory#get(Inventory, Key)
     */
    public static final OneParam<KeyValueMatcher<?>> KEY_VALUE = DummyObjectProvider.createExtendedFor(OneParam.class, "KEY_VALUE");

    /**
     * Tests based on the class of the inventory.
     */
    public static final OneParam<Class<?>> TYPE = DummyObjectProvider.createExtendedFor(OneParam.class, "TYPE");

    /**
     * Query for a modified order of slots in a player inventory.
     * Ordering the {@link Hotbar} before the {@link PrimaryPlayerInventory}
     */
    public static final NoParam PLAYER_PRIMARY_HOTBAR_FIRST = DummyObjectProvider.createFor(NoParam.class, "PLAYER_PRIMARY_HOTBAR_FIRST");

    /**
     * Query for a reverse order of slots.
     */
    public static final NoParam REVERSE = DummyObjectProvider.createFor(NoParam.class, "REVERSE");

    /**
     * A grid query. Only works on grids. The first value is the offset the second value is the grid size.
     */
    public static final TwoParam<Vector2i, Vector2i> GRID = DummyObjectProvider.createExtendedFor(TwoParam.class, "GRID");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private QueryTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
