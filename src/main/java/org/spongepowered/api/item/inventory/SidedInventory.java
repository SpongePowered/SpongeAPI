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

import org.spongepowered.api.util.Direction;

import java.util.Set;

/**
 * A SidedInventory is an inventory where items can be inserted using
 * automation(hoppers in vanilla MC, for instance).
 */
public interface SidedInventory extends Inventory {

    /**
     * Returns the slots that are connected with a certain face
     * (can be inserted into or extracted from)
     *
     * @param direction The normal to the plane of the face
     * @return The set of slots connected with the given face
     */
    Set<Integer> getSlotsForFace(Direction direction);

    /**
     * Checks for whether the given item can be inserted into the given index
     * from the given face.
     *
     * @param index The slot index to insert into
     * @param item The item to be inserted
     * @param direction The normal to the plane of the face
     * @return True if the given item can be inserted into the given index from
     *          the given face
     */
    boolean canInsertItem(int index, ItemStack item, Direction direction);

    /**
     * Checks for whether the given item can be extracted from the given index
     * from the given face.
     *
     * @param index The slot index to extract from
     * @param item The item to be extracted
     * @param direction The normal to the plane of the face
     * @return True if the given item can be inserted into the given index from
     *          the given face
     */
    boolean canExtractItem(int index, ItemStack item, Direction direction);

}
