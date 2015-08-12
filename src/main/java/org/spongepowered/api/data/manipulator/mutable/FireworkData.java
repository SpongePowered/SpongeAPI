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
package org.spongepowered.api.data.manipulator.mutable;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableFireworkData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.item.FireworkEffect;


/**
 * Represents data specific to fireworks.
 */
public interface FireworkData extends DataManipulator<FireworkData, ImmutableFireworkData> {

    /**
     * Gets the {@link ListValue} of {@link FireworkEffect}s.
     *
     * @return The list value of fire work effects
     */
    ListValue<FireworkEffect> effects();

    /**
     * Gets the flight modifier for this firework.
     *
     * <p>Flight modifiers are tiered ranks of flight duration. Generally,
     * the modifier is used to calculate the fuse time of a firework when
     * launched. This can be approximated by multiplying 10 and the modifier,
     * and adding a random number between 0 and 13. Again, this is a general
     * approximation of what vanilla Minecraft performs.</p>
     *
     * @return The flight modifier
     */
    MutableBoundedValue<Integer> flightModifier();

}
