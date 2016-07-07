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
import org.spongepowered.api.data.property.BooleanProperty;

/**
 * A property to represent whether a {@link BlockType} has a full selection
 * box. That is, the block has a selection box and it occupies the exact volume
 * of a voxel (the size is (1, 1, 1)). The selection box is the one used to
 * interact with blocks, which shows up as a black outline on a vanilla client.
 */
public class FullBlockSelectionBoxProperty extends BooleanProperty {

    /**
     * Creates a new {@link FullBlockSelectionBoxProperty} with the provided
     * value.
     *
     * @param value Whether or not this block has a full bounding box
     */
    public FullBlockSelectionBoxProperty(boolean value) {
        super(value);
    }

    /**
     * Creates a new {@link FullBlockSelectionBoxProperty} with the provided
     * value.
     *
     * @param value Whether or not this block has a full bounding box
     * @param operator The operator for comparisons
     */
    public FullBlockSelectionBoxProperty(boolean value, Operator operator) {
        super(value, operator);
    }

}
