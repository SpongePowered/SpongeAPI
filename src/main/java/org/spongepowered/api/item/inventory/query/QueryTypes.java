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

import org.spongepowered.api.ResourceKey;
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
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.math.vector.Vector2i;

import java.util.function.Predicate;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class QueryTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Tests based on the class of the inventory.
     */
    public static final DefaultedRegistryReference<OneParam<Class<? extends Inventory>>> INVENTORY_TYPE = QueryTypes.oneParamKey(ResourceKey.sponge("inventory_type"));

    /**
     * Allows a custom condition for the items contained within an item stack.
     */
    public static final DefaultedRegistryReference<OneParam<Predicate<ItemStack>>> ITEM_STACK_CUSTOM = QueryTypes.oneParamKey(ResourceKey.sponge("item_stack_custom"));

    /**
     * Tests for an exact match of the item stack contained in each slot.
     *
     * <p>Generally uses {@link ItemStack}'s <code>#equals</code> method.</p>
     */
    public static final DefaultedRegistryReference<OneParam<ItemStack>> ITEM_STACK_EXACT = QueryTypes.oneParamKey(ResourceKey.sponge("item_stack_exact"));

    /**
     * Tests for an exact match of the item stack contained in each slot, with
     * the exception of the quantity. This allows testing for custom data on
     * item stacks that may be moved and stacked by players.
     *
     * @see ItemStack#equalTo(ItemStack)
     */
    public static final DefaultedRegistryReference<OneParam<ItemStack>> ITEM_STACK_IGNORE_QUANTITY = QueryTypes.oneParamKey(ResourceKey.sponge("item_stack_ignore_quantity"));

    /**
     * Tests for a match of the type of item contained in each slot.
     *
     * @see ItemStack#type ()
     */
    public static final DefaultedRegistryReference<OneParam<ItemType>> ITEM_TYPE = QueryTypes.oneParamKey(ResourceKey.sponge("item_type"));

    /**
     * Tests based on an inventory property present on the target inventory.
     *
     * @see Inventory#get(Inventory, Key)
     */
    public static final DefaultedRegistryReference<OneParam<KeyValueMatcher<?>>> KEY_VALUE = QueryTypes.oneParamKey(ResourceKey.sponge("key_value"));

    /**
     * Tests based on the class of the inventory.
     */
    public static final DefaultedRegistryReference<OneParam<Class<?>>> TYPE = QueryTypes.oneParamKey(ResourceKey.sponge("type"));

    /**
     * Query for a modified order of slots in a player inventory.
     * Ordering the {@link Hotbar} before the {@link PrimaryPlayerInventory}
     */
    public static final DefaultedRegistryReference<NoParam> PLAYER_PRIMARY_HOTBAR_FIRST = QueryTypes.noParamKey(ResourceKey.sponge("player_primary_hotbar_first"));

    /**
     * Query for a reverse order of slots.
     */
    public static final DefaultedRegistryReference<NoParam> REVERSE = QueryTypes.noParamKey(ResourceKey.sponge("reverse"));

    /**
     * A grid query. Only works on grids. The first value is the offset the second value is the grid size.
     */
    public static final DefaultedRegistryReference<TwoParam<Vector2i, Vector2i>> GRID = QueryTypes.twoParamKey(ResourceKey.sponge("grid"));

    // SORTFIELDS:OFF

    // @formatter:on

    private QueryTypes() {
    }

    private static DefaultedRegistryReference<QueryType.NoParam> noParamKey(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.QUERY_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }

    private static <T1> DefaultedRegistryReference<QueryType.OneParam<T1>> oneParamKey(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.QUERY_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }

    private static <T1, T2> DefaultedRegistryReference<QueryType.TwoParam<T1, T2>> twoParamKey(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.QUERY_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
