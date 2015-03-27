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
package org.spongepowered.api.item.properties;

import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.util.Coerce;

import javax.annotation.Nullable;

/**
 * Represents the {@link EquipmentType} that the item can be used in an
 * equipment inventory.
 */
public class EquipmentProperty extends AbstractItemProperty<String, EquipmentType> {

    /**
     * Constructs a new {@link EquipmentProperty}.
     *
     * @param value The equipment type
     */
    public EquipmentProperty(@Nullable EquipmentType value) {
        super(value);
    }

    /**
     * Constructs a new {@link EquipmentProperty}.
     *
     * @param value The equipment type
     * @param op The operator to use to compare
     */
    public EquipmentProperty(@Nullable EquipmentType value, Operator op) {
        super(value, op);
    }

    /**
     * Constructs a new {@link EquipmentProperty}.
     *
     * @param value EquipmentType to match
     * @param operator logical operator to apply when comparing with other
     *      properties
     */
    public EquipmentProperty(Object value, Operator operator) {
        super(Coerce.toPseudoEnum(value, EquipmentType.class, EquipmentTypes.class, EquipmentTypes.WORN), operator);
    }

    @Override
    public int compareTo(ItemProperty<?, ?> o) {
        if (o instanceof EquipmentProperty) {
            EquipmentProperty property = (EquipmentProperty) o;
            return this.getValue().getId().compareTo(property.getValue().getId());
        }
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
}
