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
package org.spongepowered.api.block;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.ImmutableDataBuilder;

/**
 * An {@link ImmutableDataBuilder} for a {@link BlockState}. Just like the
 * {@link ImmutableDataBuilder}, the {@link DataManipulator}s passed in to
 * create a {@link BlockState} are copied on creation.
 *
 * <p>Note that upon creation, the {@link BlockType} must be set for validation
 * of {@link DataManipulator}s, otherwise exceptions may be thrown.</p>
 */
public interface BlockStateBuilder extends ImmutableDataBuilder<BlockState, BlockStateBuilder> {

    /**
     * Sets the {@link BlockType} for the {@link BlockState} to build.
     *
     * <p>The {@link BlockType} is used for some pre-validation on addition of
     * {@link DataManipulator}s through {@link #add(DataManipulator)}. It is
     * important to understand that not all manipulators are compatible with
     * all {@link BlockType}s.</p>
     *
     * @param blockType The block type
     * @return This builder, for chaining
     */
    BlockStateBuilder blockType(BlockType blockType);

}
