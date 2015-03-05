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
package org.spongepowered.api.item.inventory.properties;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.util.Coerce;

import java.util.Collection;
import java.util.List;


/**
 * A property type intended for use with
 * {@link org.spongepowered.api.item.inventory.slots.InputSlot}s in order to
 * query for slots which can accept items of the specified type. It is intended
 * that the semantics of the {@link #equals} will be such that the method will
 * return true if the other property contains <em>any</em> item present in this
 * property's collection.
 */
public class AcceptsItems extends AbstractInventoryProperty<String, Collection<ItemType>> {

    /**
     * Create a new AcceptsItems property with the supplied value.
     * 
     * @param value Item types to accept
     */
    public AcceptsItems(Collection<ItemType> value) {
        super(value);
    }

    /**
     * Create a new AcceptsItems property with the supplied value and operator.
     * 
     * @param value Item types to accept
     * @param operator Logical operator to apply when comparing with other
     *      properties
     */
    public AcceptsItems(Collection<ItemType> value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new AcceptsItems property with the supplied value and operator.
     * 
     * @param value Item types to accept
     * @param operator Logical operator to apply when comparing with other
     *      properties
     */
    public AcceptsItems(Object value, Operator operator) {
        super(Coerce.toListOf(value, ItemType.class), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        // This breaks the contract of Comparable, but we don't have a meaningful
        // way of providing a natural ordering
        return this.equals(other) ? 0 : this.hashCode() - this.hashCodeOf(other);
    }

    /**
     * Returns true if <em>other</em> is also an {@link AcceptsItems} property
     * and <b>any</b> item appearing in the other property's collecion appears
     * in this property's collection. In formal terms, the method returns true
     * if the size of the intersection between the two item type collections is
     * greater than zero.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InventoryProperty)) {
            return false;
        }

        InventoryProperty<?, ?> other = (InventoryProperty<?, ?>) obj;
        if (!other.getKey().equals(this.getKey())) {
            return false;
        }

        List<ItemType> otherTypes = Coerce.toListOf(other.getValue(), ItemType.class);
        for (ItemType t : this.value) {
            if (otherTypes.contains(t)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Create an AcceptsItems property which matches AcceptsItems properties
     * with containing one or more of the supplied values.
     * 
     * @param value {@link ItemType}s to accept
     * @return new property
     */
    public static AcceptsItems of(Object... value) {
        return new AcceptsItems(value, Operator.EQUAL);
    }
    
}
