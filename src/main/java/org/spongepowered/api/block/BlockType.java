/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.text.translation.Translatable;

/**
 * Describes a base type of block.
 *
 * <p>Currently, instances of this class do not fully represent variants of
 * certain blocks because some blocks use data values (which are being
 * phased out in Minecraft).</p>
 */
public interface BlockType extends Translatable {

    /**
     * Return the internal ID for the block.
     *
     * <p>The format of the internal ID may vary between implementations
     * but in Minecraft, it follows the format of {@code domain:type}, an
     * example being {@code minecraft:stone}.</p>
     *
     * @return The id
     */
    String getId();

    /**
     * Return the default state for this block.
     */
    BlockState getDefaultState();

    /**
     * Get the block state for a given data value.
     *
     * @param data The data value to extract into a block state
     * @return Block state with properties set according to the data value
     * @deprecated Exists for backwards-compatibility/transitional use
     */
    @Deprecated
    BlockState getStateFromDataValue(byte data);
}
