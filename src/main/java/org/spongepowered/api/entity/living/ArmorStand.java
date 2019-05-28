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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.ArmorStandData;
import org.spongepowered.api.data.manipulator.mutable.entity.BodyPartRotationalData;
import org.spongepowered.api.data.manipulator.mutable.entity.DisabledSlotsData;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;

/**
 * Represents an armor stand.
 */
public interface ArmorStand extends Living, ArmorEquipable {

    /**
     * Gets a copy of the current {@link BodyPartRotationalData} used by this
     * {@link ArmorStand}.
     *
     * @return A copy of the current body rotational data
     */
    default BodyPartRotationalData getBodyPartRotationalData() {
        return get(BodyPartRotationalData.class).get();
    }

    /**
     * Gets the {@link Boolean} {@link Value} of whether this
     * {@link ArmorStand} is considered a "marker" stand. If
     * {@code true}, the armor stand's bounding box is near
     * impossible to see, and the armor stand can no longer be
     * interacted with.
     *
     * @return The value for the marker state
     */
    default Value<Boolean> marker() {
        return getValue(Keys.ARMOR_STAND_MARKER).get();
    }

    /**
     * Gets the {@link Boolean} {@link Value} of whether this
     * {@link ArmorStand} is considered a "small" armor stand.
     *
     * @return The value for the small state
     */
    default Value<Boolean> small() {
        return getValue(Keys.ARMOR_STAND_IS_SMALL).get();
    }

    /**
     * Gets the {@link Boolean} {@link Value} of whether this
     * {@link ArmorStand} will show that it has a base plate
     * visible to players.
     *
     * @return The value for the base plate state
     */
    default Value<Boolean> basePlate() {
        return getValue(Keys.ARMOR_STAND_HAS_BASE_PLATE).get();
    }

    /**
     * Gets the {@link Boolean} {@link Value} of whether this
     * {@link ArmorStand} will show that it has "arms".
     *
     * @return The value for the arms state
     */
    default Value<Boolean> arms() {
        return getValue(Keys.ARMOR_STAND_HAS_ARMS).get();
    }

    /**
     * Gets the {@link ArmorStandData} for this armor stand.
     *
     * @return The data manipulator for this armorstand
     */
    default ArmorStandData getArmorStandData() {
        return get(ArmorStandData.class).get();
    }

    default SetValue<EquipmentType> placingDisabled() {
        return getValue(Keys.ARMOR_STAND_PLACING_DISABLED).get();
    }

    default SetValue<EquipmentType> takingDisabled() {
        return getValue(Keys.ARMOR_STAND_TAKING_DISABLED).get();
    }

    default DisabledSlotsData getDisabledSlotsData() {
        return get(DisabledSlotsData.class).get();
    }
}
