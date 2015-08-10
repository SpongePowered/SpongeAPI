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
package org.spongepowered.api.data.manipulator.mutable.block;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutablePoweredData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An {@link DataManipulator} for the "powered" state. For redstone based
 * mechanics, a "powered on" state will mean the object is currently "powered"
 * and may emit a redstone signal. Usually applicable to
 * {@link BlockTypes#LEVER}, {@link BlockTypes#STONE_BUTTON}, etc.
 */
public interface PoweredData extends DataManipulator<PoweredData, ImmutablePoweredData> {

    /**
     * Gets the {@link Value} for the "powered" state.
     *
     * @return The immutable value for the "powered" state
     */
    Value<Boolean> powered();

}
