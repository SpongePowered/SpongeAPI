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

import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.PrimaryPlayerInventory;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Commonly used {@link InventoryTransformation}s
 */
public class InventoryTransformations {

    /**
     * A transformation that puts the Hotbar of a player inventory before the main storage inventory.
     *
     * <p>This transformation is equivalent to calling {@link Inventory#union(Inventory)} on the query
     * for {@link Hotbar} with the query for {@link PrimaryPlayerInventory} as parameter.</p>
     */
    public static final InventoryTransformation PLAYER_PRIMARY_HOTBAR_FIRST = DummyObjectProvider.createFor(InventoryTransformation.class, "PLAYER_PRIMARY_HOTBAR_FIRST");

    /**
     * A transformations that reverses the slot order.
     */
    public static final InventoryTransformation REVERSE = DummyObjectProvider.createFor(InventoryTransformation.class, "REVERSE");

    /**
     * A transformation that returns the incoming inventory without changing anything.
     */
    public static final InventoryTransformation NO_OP = DummyObjectProvider.createFor(InventoryTransformation.class, "NO_OP");

    /**
     * A transformation that returns an empty inventory.
     */
    public static final InventoryTransformation EMPTY = DummyObjectProvider.createFor(InventoryTransformation.class, "EMPTY");

}
