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
import org.spongepowered.api.item.inventory.armour.ArmourType;
import org.spongepowered.api.item.inventory.armour.ArmourTypes;
import org.spongepowered.api.util.inventory.Coerce;


/**
 * Inventory property which allows queries to be constructed for a particular
 * armour slot type.
 */
public class ArmourSlotType extends AbstractInventoryProperty<String, ArmourType> {

    public ArmourSlotType(ArmourType value) {
        super(value);
    }

    public ArmourSlotType(ArmourType value, Operator operator) {
        super(value, operator);
    }
    
    public ArmourSlotType(Object value, Operator operator) {
        super(Coerce.<ArmourType>toPseudoEnum(value, ArmourType.class, ArmourTypes.class, ArmourTypes.WORN), operator);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other == null) {
            return 1;
        }
        
        ArmourType otherValue = Coerce.<ArmourType>toPseudoEnum(other.getValue(), ArmourType.class, ArmourTypes.class, ArmourTypes.WORN);
        return this.getValue().getId().compareTo(otherValue.getId());
    }
    
    /**
     * Create an ArmourSlotType property which matches ArmourSlotType properties
     * with equal value
     */
    public static ArmourSlotType of(Object value) {
        return new ArmourSlotType(value, Operator.EQUAL);
    }
    
    /**
     * Create an ArmourSlotType property which matches ArmourSlotType properties
     * with unequal value
     */
    public static ArmourSlotType not(Object value) {
        return new ArmourSlotType(value, Operator.NOTEQUAL);
    }

}
