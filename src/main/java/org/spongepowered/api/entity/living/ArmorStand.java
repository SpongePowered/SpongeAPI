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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.inventory.ArmorEquipable;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;

/**
 * Represents an Armor Stand.
 */
public interface ArmorStand extends Living, ArmorEquipable {

    /**
     * {@link Keys#HAS_MARKER}
     * @return Whether this is a marker (non-visible) armor stand
     */
    default Value.Mutable<Boolean> marker() {
        return this.requireValue(Keys.HAS_MARKER).asMutable();
    }

    /**
     * {@link Keys#IS_SMALL}
     * @return Whether this is a small or large armor stand
     */
    default Value.Mutable<Boolean> small() {
        return this.requireValue(Keys.IS_SMALL).asMutable();
    }

    /**
     * {@link Keys#HAS_BASE_PLATE}
     * @return Whether this armorstand has a base plate or not
     */
    default Value.Mutable<Boolean> basePlate() {
        return this.requireValue(Keys.HAS_BASE_PLATE).asMutable();
    }

    /**
     * {@link Keys#HAS_ARMS}
     * @return Whether arms are visible or not
     */
    default Value.Mutable<Boolean> arms() {
        return this.requireValue(Keys.HAS_ARMS).asMutable();
    }

    /**
     * {@link Keys#IS_PLACING_DISABLED}
     * @return The equipment types where placing armor is disabled
     */
    default MapValue.Mutable<EquipmentType, Boolean> placingDisabled() {
        return this.requireValue(Keys.IS_PLACING_DISABLED).asMutable();
    }

    /**
     * {@link Keys#IS_TAKING_DISABLED}
     * @return The set of equipment types that are preventing "taking"
     */
    default MapValue.Mutable<EquipmentType, Boolean> takingDisabled() {
        return this.requireValue(Keys.IS_TAKING_DISABLED).asMutable();
    }
}
