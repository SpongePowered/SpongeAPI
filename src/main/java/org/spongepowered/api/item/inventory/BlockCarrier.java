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

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.ServerLocation;

/**
 * Represents a Block that is a carrier of an Inventory
 * e.g. An Anvil
 */
public interface BlockCarrier extends Carrier, Locatable {

    /**
     * Returns the Inventory owned by this Carrier and accessible from
     * the given direction.
     *
     * <p>e.g. A Furnace accessed from {@link Direction#DOWN} will return its Fuel Slot</p>
     *
     * <p>When no inventory is accessible a {@link EmptyInventory} is returned</p>
     *
     * @param from The Direction
     * @return The inventory at the location when accessed from given direction
     */
    Inventory getInventory(Direction from);
}
