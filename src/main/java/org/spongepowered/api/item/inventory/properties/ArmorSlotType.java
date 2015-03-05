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

import org.spongepowered.api.item.inventory.equipment.EquipmentTypeWorn;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.util.Coerce;

/**
 * Inventory property which allows queries to be constructed for a particular
 * worn equipment slot type.
 */
public class ArmorSlotType extends EquipmentSlotType {

    /**
     * Create a new ArmorSlotType property which matches armour slots of the
     * specified type.
     * 
     * @param value armour type to match
     */
    public ArmorSlotType(EquipmentTypeWorn value) {
        super(value);
    }

    /**
     * Create a new ArmorSlotType property which matches armour slots of the
     * specified type.
     * 
     * @param value armour type to match
     * @param operator logical operator (either EQUAL or NOTEQUAL) to apply
     */
    public ArmorSlotType(EquipmentTypeWorn value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new ArmorSlotType property which matches armour slots of the
     * specified type.
     * 
     * @param value armour type to match
     * @param operator logical operator (either EQUAL or NOTEQUAL) to apply
     */
    public ArmorSlotType(Object value, Operator operator) {
        super(Coerce.<EquipmentTypeWorn>toPseudoEnum(value, EquipmentTypeWorn.class, EquipmentTypeWorn.class, EquipmentTypes.WORN), operator);
    }

    /**
     * Create an ArmourSlotType property which matches ArmourSlotType properties
     * with equal value.
     * 
     * @param value Type of worn equipment to match
     * @return new property
     */
    public static ArmorSlotType of(Object value) {
        return new ArmorSlotType(value, Operator.EQUAL);
    }

    /**
     * Create an ArmourSlotType property which matches ArmourSlotType properties
     * with unequal value.
     * 
     * @param value Type of worn equipment to match
     * @return new property
     */
    public static ArmorSlotType not(Object value) {
        return new ArmorSlotType(value, Operator.NOTEQUAL);
    }

}
