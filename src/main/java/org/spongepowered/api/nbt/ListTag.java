/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.nbt;

/**
 * NBT tag representing a list
 */
public interface ListTag extends Tag {
    /**
     * Returns the count of tags in {@link ListTag}
     * 
     * @return The count of tags in {@link ListTag}
     */
    int count();
    
    /**
     * Gets the {@link TagType} of {@link Tag}s in {@link ListTag}
     * 
     * @return The {@link TagType} of {@link Tag}s in {@link ListTag}
     */
    TagType getListType();
    
    /**
     * Gets the {@link Tag} at {@code index} as byte
     * 
     * @param index
     * @return
     */
    byte getByte(int index);

    /**
     * Gets the {@link Tag} at {@code index} as short
     * 
     * @param index
     * @return
     */
    short getShort(int index);

    /**
     * Gets the {@link Tag} at {@code index} as int
     * 
     * @param index
     * @return
     */
    int getInteger(int index);

    /**
     * Gets the {@link Tag} at {@code index} as long
     * 
     * @param index
     * @return
     */
    long getLong(int index);

    /**
     * Gets the {@link Tag} at {@code index} as float
     * 
     * @param index
     * @return
     */
    float getFloat(int index);

    /**
     * Gets the {@link Tag} at {@code index} as double
     * 
     * @param index
     * @return
     */
    double getDouble(int index);

    /**
     * Gets the {@link Tag} at {@code index} as String
     * 
     * @param index
     * @return
     */
    String getString(int index);

    /**
     * Gets the {@link Tag} at {@code index} as byte[]
     * 
     * @param index
     * @return
     */
    byte[] getByteArray(int index);

    /**
     * Gets the {@link Tag} at {@code index} as int[]
     * 
     * @param index
     * @return
     */
    int[] getIntArray(int index);

    /**
     * Gets the {@link Tag} at {@code index} as {@link ListTag}
     * 
     * @param index
     * @return
     */
    ListTag getList(int index);

    /**
     * Gets the {@link Tag} at {@code index} as {@link CompoundTag}
     * 
     * @param index
     * @return
     */
    CompoundTag getCompound(int index);
    
    /**
     * Appends the {@link Tag} to {@code ListTag}
     * 
     * @param tag
     */
    void append(Tag tag);
    
    /**
     * Inserts the {@link Tag} at {@code index} in {@code ListTag}
     * 
     * @param index
     * @param tag
     */
    void insert(int index, Tag tag);
    
    /**
     * Removes the {@link Tag} at {@code index} of {@code ListTag}
     * 
     * @param index
     */
    void remove(int index);
}
