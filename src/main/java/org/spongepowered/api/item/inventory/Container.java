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
import org.spongepowered.api.item.inventory.types.Interactable;

import java.util.Set;

/**
 * A Container is effectively a <em>ViewModel</em> for a particular set of
 * {@link Inventory} objects used to allow players ({@link Human}s) to interact
 * with the Inventories, usually via a GUI (the View).
 */
public interface Container extends Interactable<Human> {

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

}
