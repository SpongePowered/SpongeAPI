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
package org.spongepowered.api.util.nbt;

/**
 * Factory for {@link Tag}s.
 */
public interface TagFactory {
    
    /**
     * Creates a new {@link ByteTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link ByteTag}
     */
    ByteTag newByte(byte value);

    /**
     * Creates a new {@link ShortTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link ShortTag}
     */
    ShortTag newShort(byte value);

    /**
     * Creates a new {@link IntTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link IntTag}
     */
    IntTag newInteger(int value);

    /**
     * Creates a new {@link LongTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link LongTag}
     */
    LongTag newLong(long value);

    /**
     * Creates a new {@link FloatTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link FloatTag}
     */
    FloatTag newFloat(float value);

    /**
     * Creates a new {@link DoubleTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link DoubleTag}
     */
    DoubleTag newDouble(double value);

    /**
     * Creates a new {@link ByteArrayTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link ByteArrayTag}
     */
    ByteArrayTag newByteArray(byte[] value);

    /**
     * Creates a new {@link IntArrayTag} with {@code value}.
     * 
     * @param value
     * @return The new {@link IntArrayTag}
     */
    IntArrayTag newIntArray(int[] value);

    /**
     * Creates a new {@link ListTag}.
     * 
     * @return A new {@link ListTag}
     */
    ListTag newList();

    /**
     * Creates a new {@link CompoundTag}.
     * 
     * @return A new {@link CompoundTag}
     */
    CompoundTag newCompound();
}
