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
package org.spongepowered.api.nbt;

import java.util.Set;

/**
 * NBT tag representing a map.
 */
public interface CompoundTag extends Tag {
    
    /**
     * Returns all keys of {@link CompoundTag}.
     * 
     * @return All keys of {@link CompoundTag}
     */
    Set<String> keys();

    /**
     * Checks if the {@link CompoundTag} contains a {@link Tag} with
     * {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return {@code True} if the {@link CompoundTag} contains a {@link Tag}
     *         with {@code key}, otherwise {@code false}
     */
    boolean hasKey(String key);

    /**
     * Checks if the {@link CompoundTag} contains a {@link Tag} of
     * {@link TagType} with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @param type The expected type
     * @return {@code True} if the {@link CompoundTag} contains a {@link Tag}
     *         of {@link TagType} with {@code key}, otherwise {@code false}
     */
    boolean hasKey(String key, TagType type);

    /**
     * Gets the {@link TagType} of {@link Tag} with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The {@link TagType} of {@link Tag} with {@code key}
     */
    TagType getType(String key);

    /**
     * Gets the boolean with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The boolean with {@code key}
     */
    boolean getBoolean(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The boolean to set
     */
    void setBoolean(String key, boolean value);

    /**
     * Gets the byte with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The byte with {@code key}
     */
    byte getByte(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The byte to set
     */
    void setByte(String key, byte value);

    /**
     * Gets the short with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The short with {@code key}
     */
    short getShort(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The short to set
     */
    void setShort(String key, short value);

    /**
     * Gets the integer with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The integer with {@code key}
     */
    int getInteger(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The int to set
     */
    void setInteger(String key, int value);

    /**
     * Gets the long with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The long with {@code key}
     */
    long getLong(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The long to set
     */
    void setLong(String key, long value);

    /**
     * Gets the float with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The float with {@code key}
     */
    float getFloat(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The float to set
     */
    void setFloat(String key, float value);    

    /**
     * Gets the double with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The double with {@code key}
     */
    double getDouble(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The double to set
     */
    void setDouble(String key, double value);

    /**
     * Gets the array of bytes with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The array of bytes with {@code key}
     */
    byte[] getByteArray(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The array of bytes to set
     */
    void setByteArray(String key, byte[] value);

    /**
     * Gets the array of integers with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The array of integers with {@code key}
     */
    int[] getIntArray(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param value The array of integers to set
     */
    void setIntArray(String key, int[] value);

    /**
     * Gets the {@link ListTag} of {@link TagType} with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @param type The {@link TagType} of {@link ListTag}
     * @return The {@link ListTag} of {@link TagType} with {@code key} 
     *         
     */
    ListTag getList(String key, TagType type);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code list}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param list The {@link ListTag} to set
     */
    void setList(String key, ListTag list);

    /**
     * Gets the {@link CompoundTag} with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The {@link CompoundTag} with {@code key}
     */
    CompoundTag getCompound(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code compound}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param compound The {@link CompountTag} to set
     */
    void setCompound(String key, CompoundTag compound);

    /**
     * Gets the {@link Tag} with {@code key}.
     * 
     * @param key The key to get from {@link CompoundTag}
     * @return The {@link Tag} with {@code key}
     */
    Tag getTag(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code tag}.
     * 
     * @param key The key to set in {@link CompoundTag}
     * @param tag The {@link Tag} to set
     */
    void setTag(String key, Tag tag);
}
