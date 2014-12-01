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
 * NBT tag representing a list.
 */
public interface ListTag extends Tag {
    
    /**
     * Returns the count of tags in {@link ListTag}.
     * 
     * @return The count of tags in {@link ListTag}
     */
    int count();

    /**
     * Gets the {@link TagType} of {@link Tag}s in {@link ListTag}.
     * 
     * @return The {@link TagType} of {@link Tag}s in {@link ListTag}
     */
    TagType getListType();

    /**
     * Gets the byte at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The byte at {@code index}
     */
    byte getByte(int index);

    /**
     * Gets the short at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The short at {@code index}
     */
    short getShort(int index);

    /**
     * Gets the integer at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The integer at {@code index}
     */
    int getInteger(int index);

    /**
     * Gets the long at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The long at {@code index}
     */
    long getLong(int index);

    /**
     * Gets the float at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The float at {@code index}
     */
    float getFloat(int index);

    /**
     * Gets the double at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The double at {@code index}
     */
    double getDouble(int index);

    /**
     * Gets the String at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The String at {@code index}
     */
    String getString(int index);

    /**
     * Gets the array of bytes at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The array of bytes at {@code index}
     */
    byte[] getByteArray(int index);

    /**
     * Gets the array of integers at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The array of integers at {@code index}
     */
    int[] getIntArray(int index);

    /**
     * Gets the {@link ListTag} of {@link TagType} at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @param type The {@link TagType} of {@link ListTag}
     * @return The {@link ListTag} of {@link TagType} at {@code index} 
     *         
     */
    ListTag getList(int index, TagType type);

    /**
     * Gets the {@link CompoundTag} at {@code index}.
     * 
     * @param index The index to get from {@link ListTag}
     * @return The {@link CompoundTag} at {@code index}
     */
    CompoundTag getCompound(int index);

    /**
     * Appends the {@link Tag} to {@code ListTag}.
     * 
     * @param tag The {@link Tag} to append
     */
    void append(Tag tag);

    /**
     * Inserts the {@link Tag} at {@code index} in {@code ListTag}.
     * 
     * @param index The index to insert at {@link ListTag}
     * @param tag The {@link Tag} to insert
     */
    void insert(int index, Tag tag);

    /**
     * Removes the {@link Tag} at {@code index} of {@code ListTag}.
     * 
     * @param index The index to remove from {@link ListTag}
     */
    void remove(int index);
}
