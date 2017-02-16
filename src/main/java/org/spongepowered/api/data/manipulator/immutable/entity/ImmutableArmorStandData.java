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
package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.ArmorStandData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

public interface ImmutableArmorStandData extends ImmutableDataManipulator<ImmutableArmorStandData, ArmorStandData> {

    /**
     * Returns whether this armor stand is considered a "marker" where if
     * it is a "marker", then the armor stand is not rendered itself, but
     * the equipment it has would still be rendered.
     *
     * @return Whether this armor stand is a marker
     */
    ImmutableValue<Boolean> marker();

    /**
     * Returns whether this armor stand is a small armor stand or not.
     *
     * @return Whether this is a small armor stand
     */
    ImmutableValue<Boolean> small();

    /**
     * Returns whether this armor stand shows arms or not.
     * <p>Arms that do not show may also not show an item in hand.</p>
     *
     * @return Whether this armor stand shows its arms
     */
    ImmutableValue<Boolean> arms();

    /**
     * Gets whether this armor stand has a visible base plate or not.
     *
     * @return Whether this armor stand has a visible base plate
     */
    ImmutableValue<Boolean> basePlate();

}
