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
import org.spongepowered.api.world.ServerLocation;

import java.util.List;
import java.util.Optional;

/**
 * Represents Multiple Blocks that are the Carrier for an Inventory.
 * e.g. A DoubleChest Inventory carried by two blocks
 */
public interface MultiBlockCarrier extends BlockCarrier {

    /**
     * Returns the Locations of the Blocks.
     *
     * @return The Locations of the Blocks
     */
    List<ServerLocation> getLocations();

    /**
     * Returns the Inventory at given location if owned by this Carrier.
     *
     * @param at The location
     * @return The inventory at given location
     */
    Optional<Inventory> getInventory(ServerLocation at);

    /**
     * Returns the Inventory at given location if owned by this Carrier and
     * accessible from given direction.
     *
     * <p>e.g. A Furnace accessed from {@link Direction#DOWN} will return
     * its Fuel Slot</p>
     *
     * @param at The Location
     * @param from The Direction
     * @return The inventory at the location when accessed from given direction
     */
    Optional<Inventory> getInventory(ServerLocation at, Direction from);

}
