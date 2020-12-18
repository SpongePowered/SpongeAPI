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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link ContainerType}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ContainerTypes {

    // @formatter:off

    // SORTFIELDS:ON

    // Containers backed by an inventory.

    // TODO check container creation in 1.14 code especially merchant/horse


    // TODO add new inventories

    public static final DefaultedRegistryReference<ContainerType> BLAST_FURNACE = ContainerTypes.key(ResourceKey.minecraft("blast_furnace"));

    /**
     * Size 5.
     */
    public static final DefaultedRegistryReference<ContainerType> BREWING_STAND = ContainerTypes.key(ResourceKey.minecraft("brewing_stand"));

    /**
     * Size 3.
     */
    public static final DefaultedRegistryReference<ContainerType> FURNACE = ContainerTypes.key(ResourceKey.minecraft("furnace"));

    /**
     * Size 9 (3x3 grid). (Dispenser)
     */
    public static final DefaultedRegistryReference<ContainerType> GENERIC_3X3 = ContainerTypes.key(ResourceKey.minecraft("generic_3x3"));

    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X1 = ContainerTypes.key(ResourceKey.minecraft("generic_9x1"));

    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X2 = ContainerTypes.key(ResourceKey.minecraft("generic_9x2"));

    /**
     * Size 27 (3x9 grid)
     */
    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X3 = ContainerTypes.key(ResourceKey.minecraft("generic_9x3"));

    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X4 = ContainerTypes.key(ResourceKey.minecraft("generic_9x4"));

    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X5 = ContainerTypes.key(ResourceKey.minecraft("generic_9x5"));

    /**
     * Size 54 (6x9 grid)
     */
    public static final DefaultedRegistryReference<ContainerType> GENERIC_9X6 = ContainerTypes.key(ResourceKey.minecraft("generic_9x6"));

    /**
     * Size 5 (1x5 grid).
     */
    public static final DefaultedRegistryReference<ContainerType> HOPPER = ContainerTypes.key(ResourceKey.minecraft("hopper"));

    public static final DefaultedRegistryReference<ContainerType> LECTERN = ContainerTypes.key(ResourceKey.minecraft("lectern"));

    /**
     * Size 27 (3x9 grid). Shulker boxes are not allowed in shulker boxes.
     */
    public static final DefaultedRegistryReference<ContainerType> SHULKER_BOX = ContainerTypes.key(ResourceKey.minecraft("shulker_box"));

    public static final DefaultedRegistryReference<ContainerType> SMOKER = ContainerTypes.key(ResourceKey.minecraft("smoker"));

    // Containers with internal Inventory.

    /**
     * Size 0. All slots present in the container only: 3.
     */
    public static final DefaultedRegistryReference<ContainerType> ANVIL = ContainerTypes.key(ResourceKey.minecraft("anvil"));

    /**
     * Size 0. All slots present in the container only: 1.
     */
    public static final DefaultedRegistryReference<ContainerType> BEACON = ContainerTypes.key(ResourceKey.minecraft("beacon"));

    public static final DefaultedRegistryReference<ContainerType> CARTOGRAPHY_TABLE = ContainerTypes.key(ResourceKey.minecraft("cartography_table"));

    /**
     * Size 0. All slots present in the container only: 10 (3x3+1).
     */
    public static final DefaultedRegistryReference<ContainerType> CRAFTING = ContainerTypes.key(ResourceKey.minecraft("crafting"));

    /**
     * Size 0. All slots present in the container only 2.
     */
    public static final DefaultedRegistryReference<ContainerType> ENCHANTMENT = ContainerTypes.key(ResourceKey.minecraft("enchantment"));

    public static final DefaultedRegistryReference<ContainerType> GRINDSTONE = ContainerTypes.key(ResourceKey.minecraft("grindstone"));

    public static final DefaultedRegistryReference<ContainerType> LOOM = ContainerTypes.key(ResourceKey.minecraft("loom"));

    public static final DefaultedRegistryReference<ContainerType> STONECUTTER = ContainerTypes.key(ResourceKey.minecraft("stonecutter"));

    // Containers that cannot be opened on their own. Create an Entity to open the container instead.

    /**
     * Create a {@link Villager} Entity instead of using this ContainerType.
     */
    public static final DefaultedRegistryReference<ContainerType> MERCHANT = ContainerTypes.key(ResourceKey.minecraft("merchant"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ContainerTypes() {
    }

    private static DefaultedRegistryReference<ContainerType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CONTAINER_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
