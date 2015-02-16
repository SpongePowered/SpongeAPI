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

package org.spongepowered.api.event.block;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Called when a block is about to dispense an item.
 */
public interface BlockDispenseEvent extends BlockEvent {

    /**
     * Get the item that is being dispensed.
     *
     * <p>The item may not actually be dispensed as an item drop &mdash; it
     * may result in the placement of a block or spawn of another entity.</p>
     *
     * @return The dispensed item
     */
    ItemStack getDispensedItem();

    /**
     * Set the item that will be dispensed.
     *
     * <p>The item may not actually be dispensed as an item drop &mdash; it
     * may result in the placement of a block or spawn of another entity.</p>
     *
     * @param itemStack The item to dispense
     */
    void setDispensedItem(ItemStack itemStack);

    /**
     * Get the velocity imparted by the dispenser onto the item.
     *
     * <p>The vector may have bearing if the item stack does not result
     * in a dropped item entity.</p>
     *
     * @return The velocity
     */
    Vector3d getVelocity();

    /**
     * Set the velocity imparted by the dispenser onto the item.
     *
     * <p>The vector may have bearing if the item stack does not result
     * in a dropped item entity.</p>
     *
     * @param velocity The velocity
     */
    void setVelocity(Vector3d velocity);

}
