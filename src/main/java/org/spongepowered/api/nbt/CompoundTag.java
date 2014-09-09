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

import java.util.Set;

/**
 * NBT tag representing a map
 */
public interface CompoundTag extends Tag {
    /**
     * Returns all keys of {@link CompoundTag}
     *
     * @return All keys of {@link CompoundTag}
     */
    Set<String> keys();

    /**
     * Checks if the {@link CompoundTag} contains a {@link Tag} with
     * {@code key}
     *
     * @param key
     * @return {@code true} if the {@link CompoundTag} contains a {@link Tag} with
     *         {@code key}, otherwise {@code false}
     */
    boolean hasKey(String key);

    /**
     * Checks if the {@link CompoundTag} contains a {@link Tag} of {@link TagType}
     * with {@code key}
     *
     * @param key
     * @param type
     * @return {@code true} if the {@link CompoundTag} contains a {@link Tag} of
     *         {@link TagType} with {@code key}, otherwise {@code false}
     */
    boolean hasKey(String key, TagType type);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @return
     */
    TagType getType(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @return
     */
    boolean getBoolean(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setBoolean(String key, boolean value);

    /**
     * Gets the {@link Tag} with {@code key} as byte
     *
     * @param key
     * @return The {@link Tag} with {@code key} as byte
     */
    byte getByte(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setByte(String key, byte value);

    /**
     * Gets the {@link Tag} with {@code key} as short
     *
     * @param key
     * @return The {@link Tag} with {@code key} as short
     */
    short getShort(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setShort(String key, short value);

    /**
     * Gets the {@link Tag} with {@code key} as int
     *
     * @param key
     * @return The {@link Tag} with {@code key} as int
     */
    int getInteger(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setInteger(String key, int value);

    /**
     * Gets the {@link Tag} with {@code key} as long
     *
     * @param key
     * @return The {@link Tag} with {@code key} as long
     */
    long getLong(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setLong(String key, long value);

    /**
     * Gets the {@link Tag} with {@code key} as float
     *
     * @param key
     * @return The {@link Tag} with {@code key} as float
     */
    float getFloat(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setFloat(String key, float value);

    /**
     * Gets the {@link Tag} with {@code key} as double
     *
     * @param key
     * @return The {@link Tag} with {@code key} as double
     */
    double getDouble(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setDouble(String key, double value);

    /**
     * Gets the {@link Tag} with {@code key} as byte[]
     *
     * @param key
     * @return The {@link Tag} with {@code key} as byte[]
     */
    byte[] getByteArray(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setByteArray(String key, byte[] value);

    /**
     * Gets the {@link Tag} with {@code key} as int[]
     *
     * @param key
     * @return The {@link Tag} with {@code key} as int[]
     */
    int[] getIntArray(String key);

    /**
     * Sets {@code key} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param value
     */
    void setIntArray(String key, int[] value);

    /**
     * Gets the {@link Tag} with {@code key} as {@link ListTag} of {@link TagType}
     *
     * @param key
     * @param type
     * @return The {@link Tag} with {@code key} as {@link ListTag} of {@link TagType}
     */
    ListTag getList(String key, TagType type);

    /**
     * Sets {@code list} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param list
     */
    void setList(String key, ListTag list);

    /**
     * Gets the {@link Tag} with {@code key} as {@link CompoundTag}
     *
     * @param key
     * @return
     */
    CompoundTag getCompound(String key);

    /**
     * Sets {@code compound} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param compound
     */
    void setCompound(String key, CompoundTag compound);

    /**
     * Gets the {@link Tag} with {@code key}
     *
     * @param key
     * @return
     */
    Tag getTag(String key);

    /**
     * Sets {@code tag} in {@link CompoundTag} to {@code value}
     *
     * @param key
     * @param tag
     */
    void setTag(String key, Tag tag);
}
