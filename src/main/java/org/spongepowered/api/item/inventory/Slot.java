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

/**
 * A slot is an {@link Inventory} with only a single stack.
 */
public interface Slot extends Inventory {

    /**
     * A type of Slot
     */
    enum Type {

        /**
         * Slots in an Inventory as opposed to a {@link Container}
         */
        INVENTORY

    }

    /**
     * Gets the size of the stack in this slot. Essentially the same as calling
     * slot.peek().getQuantity(); but faster because it avoids the Optional
     * boxing.
     *
     * @return the stack size or -1 if this slot is empty
     */
    int getStackSize();

    /**
     * Transforms this Slot into given Type.
     *
     * <dl>
     *   <dt>Example</dt>
     *   <dd>In a InventoryEvent with a Container to get the actual inventory from Slot,
     *     you may call this with {@link Type#INVENTORY}.</dd>
     * </dl>
     *
     * @param type the type to transform into
     * @return the transformed Slot or itself if already the correct type
     */
    Slot transform(Type type);

    /**
     * Transforms this Slot into the default Type.
     *
     * @return the transformed Slot or itself if already the default type
     */
    Slot transform();

}
