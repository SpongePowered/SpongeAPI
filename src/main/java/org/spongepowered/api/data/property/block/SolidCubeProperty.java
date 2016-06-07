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
package org.spongepowered.api.data.property.block;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.property.BooleanProperty;

/**
 * A property to represent whether a {@link BlockType} is a "solid cube"
 * and therefor can be considered to place a {@link BlockTypes#TORCH} on
 * its side.
 */
public class SolidCubeProperty extends BooleanProperty {

    /**
     * Creates a new {@link SolidCubeProperty} with the provided value.
     *
     * @param value The value of whether this is a solid cube or not
     */
    public SolidCubeProperty(boolean value) {
        super(value);
    }

    /**
     * Creates a new {@link SolidCubeProperty} with the provided value.
     *
     * @param value The value of whether this is a solid cube or not
     * @param operator The operator for comparisons
     */
    public SolidCubeProperty(boolean value, Operator operator) {
        super(value, operator);
    }
}
