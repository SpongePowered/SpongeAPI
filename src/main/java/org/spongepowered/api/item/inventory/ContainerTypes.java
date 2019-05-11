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

import org.spongepowered.api.entity.living.animal.horse.Horse;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link ContainerType}s in vanilla minecraft.
 */
public final class ContainerTypes {

    // Containers backed by an inventory.

    // SORTFIELDS:ON

    /**
     * Size 27 (3x9 grid)
     */
    public static final ContainerType CHEST_3X9 = DummyObjectProvider.createFor(ContainerType.class, "chest_3x9"); // "minecraft:chest"
    /**
     * Size 54 (6x9 grid)
     */
    public static final ContainerType CHEST_6x9 = DummyObjectProvider.createFor(ContainerType.class, "chest_6x9"); // "minecraft:chest"
    /**
     * Size 3.
     */
    public static final ContainerType FURNACE = DummyObjectProvider.createFor(ContainerType.class, "furnace"); // "minecraft:furnace"
    /**
     * Size 9 (3x3 grid).
     */
    public static final ContainerType DISPENSER = DummyObjectProvider.createFor(ContainerType.class, "dispenser"); // "minecraft:dispenser"
    /**
     * Size 5.
     */
    public static final ContainerType BREWING_STAND = DummyObjectProvider.createFor(ContainerType.class, "brewing_stand"); // "minecraft:brewing_stand"
    /**
     * Size 5 (1x5 grid).
     */
    public static final ContainerType HOPPER = DummyObjectProvider.createFor(ContainerType.class, "hopper"); // "minecraft:hopper"

    /**
     * Size 27 (3x9 grid). Shulker boxes are not allowed in shulker boxes.
     */
    public static final ContainerType SHULKER_BOX = DummyObjectProvider.createFor(ContainerType.class, "shulker_box"); // "minecraft:shulker_box"

    // SORTFIELDS:OFF

    // Containers with internal Inventory.

    // SORTFIELDS:ON

    /**
     * Size 0. All slots present in the container only: 10 (3x3+1).
     */
    public static final ContainerType CRAFTING_TABLE = DummyObjectProvider.createFor(ContainerType.class, "crafting_table"); // "minecraft:crafting_table"
    /**
     * Size 0. All slots present in the container only 2.
     */
    public static final ContainerType ENCHANTING_TABLE = DummyObjectProvider.createFor(ContainerType.class, "enchanting_table"); // "minecraft:enchanting_table"
    /**
     * Size 0. All slots present in the container only: 3.
     */
    public static final ContainerType ANVIL = DummyObjectProvider.createFor(ContainerType.class, "anvil"); // "minecraft:anvil"

    /**
     * Size 0. All slots present in the container only: 1.
     */
    public static final ContainerType BEACON = DummyObjectProvider.createFor(ContainerType.class, "beacon"); // "minecraft:beacon"

    // SORTFIELDS:OFF

    // Containers that cannot be opened on their own. Create an Entity to open the container instead.

    // SORTFIELDS:ON

    /**
     * Create a subtype of a {@link Horse} Entity instead of using this ContainerType.
     */
    public static final ContainerType HORSE = DummyObjectProvider.createFor(ContainerType.class, "horse"); // "minecraft:horse" internally "EntityHorse"

    /**
     * Create a {@link Villager} Entity instead of using this ContainerType.
     */
    public static final ContainerType VILLAGER = DummyObjectProvider.createFor(ContainerType.class, "villager"); // "minecraft:villager"

    // SORTFIELDS:OFF

    private ContainerTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}


