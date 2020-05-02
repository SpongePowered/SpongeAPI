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
package org.spongepowered.api.event.action;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.manipulator.immutable.item.ImmutableMapItemData;
import org.spongepowered.api.data.manipulator.mutable.item.MapItemData;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.world.World;

public interface CreateMapEvent extends Event, Cancellable {
    /**
     * Get the player creating this map
     *
     * @return Player who right clicked on a blank map
     */
    Player getCreator();

    /**
     * Gets the map data for this map
     * @return MapItemData Map data
     */
    MapItemData getMapData();

    /**
     * Gets the map data before any plugins have changed it.
     * @return ImmutableMapItemData Original Map Data
     */
    ImmutableMapItemData getOriginalMapData();

    /**
     * Gets the hand used
     *
     * @return HandType hand used
     */
    HandType getUsedHand();

    /**
     * Gets the world that this action took place in
     *
     * @return World world where the action happened
     */
    World getWorld();

    /**
     * Gets the before and after {@link ItemStackSnapshot} for this action
     *
     * @return Transaction of ItemStackSnaphots, before and after
     */
    Transaction<ItemStackSnapshot> getItemTransaction();

    /**
     * Get the id assigned to the map about to be created
     * (This id will not exist if the event is cancelled)
     *
     * @return int id assigned to the new map
     */
    int getNewId();
}
