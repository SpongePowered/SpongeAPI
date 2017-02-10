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
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableArmorStandData;
import org.spongepowered.api.data.value.mutable.Value;

public interface ArmorStandData extends DataManipulator<ArmorStandData, ImmutableArmorStandData> {

    /**
     * Returns whether this armor stand is rendered invisible and simply a
     * "marker". The inventory contents and nameplate will still show, but
     * the body itself of the armor stand will not be visible.
     *
     * @return Whether this is a marker armor stand
     * @see Keys#ARMOR_STAND_MARKER
     */
    Value<Boolean> marker();

    /**
     * Returns whether this armor stand is a small armor stand or not.
     *
     * @return Whether this is a small armor stand
     * @see Keys#ARMOR_STAND_IS_SMALL
     */
    Value<Boolean> small();

    /**
     * Returns whether this armor stand shows arms or not.
     *
     * <p>Arms that do not show may also not show an item in hand.</p>
     *
     * @return Whether this armor stand shows its arms
     * @see Keys#ARMOR_STAND_HAS_ARMS
     */
    Value<Boolean> arms();

    /**
     * Gets whether this armor stand has a visible base plate or not.
     *
     * @return Whether this armor stand has a visible base plate
     * @see Keys#ARMOR_STAND_HAS_BASE_PLATE
     */
    Value<Boolean> basePlate();

}
