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
package org.spongepowered.api.item.inventory.property;

/**
 * Property for inventories of a particular capacity. For example to allow
 * querying for Inventories with 5 Slots.
 */
public class InventoryCapacity extends IntProperty {

    /**
     * Creates a new InventoryCapacity property with the specified value.
     *
     * @param capacity Capacity to match
     */
    public InventoryCapacity(int capacity) {
        super(capacity);
    }

    /**
     * Create a new InventoryCapacity property with the specified value.
     *
     * @param capacity size to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public InventoryCapacity(int capacity, Operator operator) {
        super(capacity, operator);
    }

    /**
     * Create an InventoryCapacity property which matches InventoryCapacity
     * properties with equal value.
     *
     * @param capacity value to match
     * @return new property
     */
    public static InventoryCapacity of(int capacity) {
        return new InventoryCapacity(capacity, Operator.EQUAL);
    }
}
