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

import org.spongepowered.api.Nameable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Predicate;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class QueryOperationTypes {

    // SORTFIELDS:ON

    /**
     * Tests based on an inventory property present on the target inventory.
     *
     * @see Inventory#getProperties(Inventory, Class)
     */
    public static final QueryOperationType<InventoryProperty<?, ?>> INVENTORY_PROPERTY = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "INVENTORY_PROPERTY");

    /**
     * Tests based on the title of the inventory.
     *
     * @see InventoryTitle
     * @see Nameable#getName()
     */
    public static final QueryOperationType<Translation> INVENTORY_TRANSLATION = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "INVENTORY_TRANSLATION");

    /**
     * Tests based on the class of the inventory.
     */
    public static final QueryOperationType<Class<? extends Inventory>> INVENTORY_TYPE = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "INVENTORY_TYPE");

    /**
     * Allows a custom condition for the items contained within an item stack.
     */
    public static final QueryOperationType<Predicate<ItemStack>> ITEM_STACK_CUSTOM = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "ITEM_STACK_CUSTOM");

    /**
     * Tests for an exact match of the item stack contained in each slot.
     *
     * <p>Generally uses {@link ItemStack}'s <code>#equals</code> method.</p>
     */
    public static final QueryOperationType<ItemStack> ITEM_STACK_EXACT = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "ITEM_STACK_EXACT");

    /**
     * Tests for an exact match of the item stack contained in each slot, with
     * the exception of the quantity. This allows testing for custom data on
     * item stacks that may be moved and stacked by players.
     *
     * @see ItemStack#equalTo(ItemStack)
     */
    public static final QueryOperationType<ItemStack> ITEM_STACK_IGNORE_QUANTITY = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "ITEM_STACK_IGNORE_QUANTITY");

    /**
     * Tests for a match of the type of item contained in each slot.
     *
     * @see ItemStack#getType()
     */
    public static final QueryOperationType<ItemType> ITEM_TYPE = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "ITEM_TYPE");

    /**
     * Tests based on the class of the inventory.
     */
    public static final QueryOperationType<Class<?>> TYPE = DummyObjectProvider.createExtendedFor(QueryOperationType.class, "TYPE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private QueryOperationTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
