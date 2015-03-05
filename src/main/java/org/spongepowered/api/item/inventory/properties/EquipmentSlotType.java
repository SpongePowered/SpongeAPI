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
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.util.Coerce;

/**
 * Inventory property which allows queries to be constructed for a particular
 * equipment slot type.
 */
public class EquipmentSlotType extends AbstractInventoryProperty<String, EquipmentType> {

    /**
     * Create a new EquipmentSlotType property to match items of the specified
     * value.
     * 
     * @param value EquipmentType to match
     */
    public EquipmentSlotType(EquipmentType value) {
        super(value);
    }

    /**
     * Create a new EquipmentSlotType property to match items of the specified
     * value.
     * 
     * @param value EquipmentType to match
     * @param operator logical operator to apply when comparing with other
     *      properties
     */
    public EquipmentSlotType(EquipmentType value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new EquipmentSlotType property to match items of the specified
     * value.
     * 
     * @param value EquipmentType to match
     * @param operator logical operator to apply when comparing with other
     *      properties
     */
    public EquipmentSlotType(Object value, Operator operator) {
        super(Coerce.<EquipmentType>toPseudoEnum(value, EquipmentType.class, EquipmentTypes.class, EquipmentTypes.WORN), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other == null) {
            return 1;
        }

        EquipmentType
                otherValue =
                Coerce.<EquipmentType>toPseudoEnum(other.getValue(), EquipmentType.class, EquipmentTypes.class, EquipmentTypes.WORN);
        return this.getValue().getId().compareTo(otherValue.getId());
    }

    /**
     * Create an EquipmentSlotType property which matches EquipmentSlotType
     * properties with equal value.
     * 
     * @param value EquipmentType to match
     * @return new property
     */
    public static EquipmentSlotType of(Object value) {
        return new EquipmentSlotType(value, Operator.EQUAL);
    }

    /**
     * Create an EquipmentSlotType property which matches EquipmentSlotType
     * properties with unequal value.
     * 
     * @param value EquipmentType to match
     * @return new property
     */
    public static EquipmentSlotType not(Object value) {
        return new EquipmentSlotType(value, Operator.NOTEQUAL);
    }

}
