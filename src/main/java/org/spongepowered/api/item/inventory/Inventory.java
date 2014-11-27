/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.item.list.ItemList;
import org.spongepowered.api.text.message.Message;

import java.util.Set;

/**
 * An Inventory is an ItemList that can be viewed by Humans
 * and be carried by a Carrier.
 *
 * <p>It also has title-related methods, which applies mainly to chest
 * inventories.</p>
 *
 * <p>Most inventory sub-interfaces are currently useless because of possible
 * tinkering from Forge mods. Once this gets sorted out, more usefull methods
 * will be added to the Inventory sub-interfaces.</p>
 */
public interface Inventory extends ItemList {

    /**
     * Gets the title of this Inventory, viewable by players looking
     * at this inventory.
     *
     * @return The title of this inventory
     */
    Message getTitle();

    /**
     * Sets the title of this Inventory, viewable by players looking
     * at this inventory.
     *
     * @param title The new title of this inventory
     */
    void setTitle(Message title);

    /**
     * Gets the current viewers looking at this Inventory.
     *
     * @return The current viewers of this inventory
     */
    Set<Human> getViewers();

    /**
     * Checks for whether this Inventory currently has viewers.
     *
     * @return True if viewers are currently looking at this inventory
     */
    boolean hasViewers();

    /**
     * Shows this Inventory to the given viewer.
     *
     * @param viewer The viewer to show this inventory to
     */
    void open(Human viewer);

    /**
     * Stops showing this Inventory to the given viewer.
     *
     * @param viewer The viewer to stop showing this inventory to
     */
    void close(Human viewer);

    /**
     * Returns the Carrier of this Inventory. It can be an entity,
     * block, or other object.
     *
     * @return This inventory's carrier
     */
    Carrier getCarrier();

}
