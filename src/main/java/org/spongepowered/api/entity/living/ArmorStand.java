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
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.ArmorEquipable;

/**
 * Represents an armor stand.
 */
public interface ArmorStand extends Living, ArmorEquipable {

    /**
     * Gets the {@link Boolean} {@link Value.Mutable} of whether this
     * {@link ArmorStand} is considered a "marker" stand. If
     * {@code true}, the armor stand's bounding box is near
     * impossible to see, and the armor stand can no longer be
     * interacted with.
     *
     * @return The value for the marker state
     */
    default Value.Mutable<Boolean> marker() {
        return getValue(Keys.ARMOR_STAND_MARKER).get().asMutable();
    }

    /**
     * Gets the {@link Boolean} {@link Value.Mutable} of whether this
     * {@link ArmorStand} is considered a "small" armor stand.
     *
     * @return The value for the small state
     */
    default Value.Mutable<Boolean> small() {
        return getValue(Keys.ARMOR_STAND_IS_SMALL).get().asMutable();
    }

    /**
     * Gets the {@link Boolean} {@link Value.Mutable} of whether this
     * {@link ArmorStand} will show that it has a base plate
     * visible to players.
     *
     * @return The value for the base plate state
     */
    default Value.Mutable<Boolean> basePlate() {
        return getValue(Keys.ARMOR_STAND_HAS_BASE_PLATE).get().asMutable();
    }

    /**
     * Gets the {@link Boolean} {@link Value.Mutable} of whether this
     * {@link ArmorStand} will show that it has "arms".
     *
     * @return The value for the arms state
     */
    default Value.Mutable<Boolean> arms() {
        return getValue(Keys.ARMOR_STAND_HAS_ARMS).get().asMutable();
    }
}
