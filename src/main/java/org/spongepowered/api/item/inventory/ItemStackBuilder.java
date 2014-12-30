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

/**
 * Represents a builder interface to create an {@link ItemStack}.
 */
public interface ItemStackBuilder {

    /**
     * Sets the durability damage of the item.
     *
     * @param damage The durability of the item
     * @return This builder
     */
    ItemStackBuilder damage(int damage);

    /**
     * Sets the quantity of the item stack.
     *
     * @param quantity The quantity of the item stack
     * @return This builder
     * @throws IllegalArgumentException if the quantity is outside the allowed bounds
     */
    ItemStackBuilder quantity(int quantity) throws IllegalArgumentException;

    /**
     * Sets the maximum quantity of the specific item stack.
     *
     * @param quantity The maximum quantity of the item stack
     * @return This builder
     */
    ItemStackBuilder maxQuantity(int quantity);

    /**
     * Builds an instance of an ItemStack.
     *
     * @return A new instance of an ItemStack
     * @throws IllegalStateException If the item stack is not completed
     */
    ItemStack build() throws IllegalStateException;

}
