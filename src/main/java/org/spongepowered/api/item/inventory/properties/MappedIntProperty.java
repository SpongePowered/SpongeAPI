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

import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.util.Coerce;

/**
 * An integer-mapped integer property. This is primarily used for supporting the
 * "fields" on the beacon inventory for the moment. This property is also
 * settable.
 */
public class MappedIntProperty extends AbstractInventoryProperty<Integer, Integer> {

    /**
     * Create a new MappedIntProperty with the specified key and value.
     * 
     * @param key key to match
     * @param value value to match
     */
    public MappedIntProperty(Integer key, Integer value) {
        super(key, value);
    }

    /**
     * Create a new MappedIntProperty with the specified key and value.
     * 
     * @param key key to match
     * @param value value to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public MappedIntProperty(Integer key, Integer value, Operator operator) {
        super(key, value, operator);
    }

    /**
     * Create a new MappedIntProperty with the specified key and value.
     * 
     * @param key key to match
     * @param value value to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public MappedIntProperty(Object key, Object value, Operator operator) {
        super(Coerce.toInteger(key), Coerce.toInteger(value), operator);
    }

    /**
     * Set this property to the specified value.
     * 
     * @param value value to set
     */
    void setValue(Integer value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other instanceof IntProperty || (other instanceof MappedIntProperty && other.getKey().equals(this.getKey()))) {
            return this.getValue().compareTo(Coerce.toInteger(other.getValue()));
        }

        return 1;
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with equal value and matching key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty of(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.EQUAL);
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with unequal value and matching key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty not(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.NOTEQUAL);
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with value greater than this value and matching key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty greaterThan(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.GREATER);
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with value greater than or equal to this value and matching
     * key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty greaterThanOrEqual(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.GEQUAL);
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with value less than this value and matching key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty lessThan(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.LESS);
    }

    /**
     * Create a MappedIntProperty property which matches MappedIntProperty
     * properties with value less than or equal to this value and matching key.
     * 
     * @param key key to match
     * @param value value to match
     * @return new property
     */
    public static MappedIntProperty lessThanOrEqual(Object key, Object value) {
        return new MappedIntProperty(key, value, Operator.LEQUAL);
    }

}
