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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableDisabledSlotsData;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;

/**
 * A {@link DataManipulator} for the disabled slots in an {@link ArmorStand}.
 * 
 * A slot can have taking disabled, placing disabled or both.
 */
public interface DisabledSlotsData extends DataManipulator<DisabledSlotsData, ImmutableDisabledSlotsData> {

    /**
     * Controls slots that players can't take items from.
     * 
     * @return A set of slots that players cannot take from.
     * @see Keys#ARMOR_STAND_TAKING_DISABLED
     */
    SetValue<EquipmentType> takingDisabled();

    /**
     * Controls slots that players can't place items into.
     * 
     * @return A set of slots that players cannot place into.
     * @see Keys#ARMOR_STAND_PLACING_DISABLED
     */
    SetValue<EquipmentType> placingDisabled();

}
