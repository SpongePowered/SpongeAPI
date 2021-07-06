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
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.inventory.ArmorEquipable;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.math.vector.Vector3d;

/**
 * Represents an Armor Stand.
 */
public interface ArmorStand extends Living, ArmorEquipable {

    /**
     * {@link Keys#HAS_MARKER}
     *
     * @return Whether this is a marker (non-visible) armor stand
     */
    default Value.Mutable<Boolean> marker() {
        return this.requireValue(Keys.HAS_MARKER).asMutable();
    }

    /**
     * {@link Keys#IS_SMALL}
     *
     * @return Whether this is a small or large armor stand
     */
    default Value.Mutable<Boolean> small() {
        return this.requireValue(Keys.IS_SMALL).asMutable();
    }

    /**
     * {@link Keys#HAS_BASE_PLATE}
     *
     * @return Whether this armor stand has a visible base plate
     */
    default Value.Mutable<Boolean> basePlate() {
        return this.requireValue(Keys.HAS_BASE_PLATE).asMutable();
    }

    /**
     * {@link Keys#HAS_ARMS}
     *
     * @return Whether the arms of this armor stand are visible
     */
    default Value.Mutable<Boolean> arms() {
        return this.requireValue(Keys.HAS_ARMS).asMutable();
    }

    /**
     * {@link Keys#IS_PLACING_DISABLED}
     *
     * @return The equipment types where placing armor is disabled
     */
    default MapValue.Mutable<EquipmentType, Boolean> placingDisabled() {
        return this.requireValue(Keys.IS_PLACING_DISABLED).asMutable();
    }

    /**
     * {@link Keys#IS_TAKING_DISABLED}
     *
     * @return The set of equipment types that are preventing "taking"
     */
    default MapValue.Mutable<EquipmentType, Boolean> takingDisabled() {
        return this.requireValue(Keys.IS_TAKING_DISABLED).asMutable();
    }

    /**
     * {@link Keys#LEFT_ARM_ROTATION}
     *
     * @return The left arm rotation of the armor stand
     */
    default Value.Mutable<Vector3d> leftArmRotation() {
        return this.requireValue(Keys.LEFT_ARM_ROTATION).asMutable();
    }

    /**
     * {@link Keys#LEFT_LEG_ROTATION}
     *
     * @return The left leg rotation of the armor stand
     */
    default Value.Mutable<Vector3d> leftLegRotation() {
        return this.requireValue(Keys.LEFT_LEG_ROTATION).asMutable();
    }

    /**
     * {@link Keys#RIGHT_ARM_ROTATION}
     *
     * @return The right arm rotation of the armor stand
     */
    default Value.Mutable<Vector3d> rightArmRotation() {
        return this.requireValue(Keys.RIGHT_ARM_ROTATION).asMutable();
    }

    /**
     * {@link Keys#RIGHT_LEG_ROTATION}
     *
     * @return The right leg rotation of the armor stand
     */
    default Value.Mutable<Vector3d> rightLegRotation() {
        return this.requireValue(Keys.RIGHT_LEG_ROTATION).asMutable();
    }
}
