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
package org.spongepowered.api.util.nbt.tag;

import org.spongepowered.api.util.nbt.tag.*;
import org.spongepowered.api.util.nbt.tag.primitive.*;

/**
 * Factory for {@link Tag}s
 */
public interface TagFactory {
    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.ByteTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.ByteTag}
     */
    ByteTag newByte(byte value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.ShortTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.ShortTag}
     */
    ShortTag newShort(byte value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.IntTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.IntTag}
     */
    IntTag newInteger(int value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.LongTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.LongTag}
     */
    LongTag newLong(long value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.FloatTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.FloatTag}
     */
    FloatTag newFloat(float value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.primitive.DoubleTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.primitive.DoubleTag}
     */
    DoubleTag newDouble(double value);

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.ByteArrayTag} with {@code value}
     *
     * @param value
     * @return The new {@link org.spongepowered.api.util.nbt.tag.ByteArrayTag}
     */
    ByteArrayTag newByteArray(byte[] value);

    /**
     * Creates a new {@link IntArrayTag} with {@code value}
     *
     * @param value
     * @return The new {@link IntArrayTag}
     */
    IntArrayTag newIntArray(int[] value);

    /**
     * Creates a new {@link ListTag}
     *
     * @return A new {@link ListTag}
     */
    ListTag newList();

    /**
     * Creates a new {@link org.spongepowered.api.util.nbt.tag.CompoundTag}
     *
     * @return A new {@link org.spongepowered.api.util.nbt.tag.CompoundTag}
     */
    CompoundTag newCompound();
}
