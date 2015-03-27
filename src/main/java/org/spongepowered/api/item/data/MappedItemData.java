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
package org.spongepowered.api.item.data;

import com.google.common.base.Optional;
import org.spongepowered.api.item.ItemDataTransactionResult;

import java.util.Map;
import java.util.Set;

/**
 * Represents item data that is mapped by a specific key and value type
 * definition. Examples of these include: {@link EnchantmentData},
 * {@link StoredEnchantmentData}, etc.
 *
 * @param <K> The key that can be used to retrieve values
 * @param <V> The value type
 * @param <T> The intended comparable extended type
 */
public interface MappedItemData<K, V, T extends MappedItemData<K, V, T>> extends ItemData<T> {

    /**
     * Gets all the mapped keys stored on the item stack.
     *
     * <p>The returned set is an immutable one, only representing the
     * mapped key values available on this {@link MappedItemData}. To modify
     * the available mapped key values, use the provided methods in
     * {@link MappedItemData}.</p>
     *
     * @return All mapped key values stored to the item stack
     */
    Set<K> getKeys();

    /**
     * Gets all the mapped keys and their values and the levels stored on the
     * item stack.
     *
     * <p>The returned map is an immutable one, only representing the
     * mapped key values available on this {@link MappedItemData}. To modify
     * the available mapped key values, use the provided methods in
     * {@link MappedItemData}.</p>
     *
     * @return An immutable map of all keys and their values
     */
    Map<K, V> asMap();

    /**
     * Gets the value of the desired key on the
     * item stack.
     *
     * @param key The key
     * @return The value of the key, if available
     */
    Optional<V> get(K key);

    /**
     * Sets the key with the desired value.
     *
     * <p>This will perform any and all checks that the given key
     * is compatible with the represented item, and that the value is within
     * the bounds of key.</p>
     *
     * @param key The key to set
     * @param value The value of the key
     * @return The transaction result, if the keys and their respective values
     *     were added, rejected or replaced
     */
    ItemDataTransactionResult set(K key, V value);

    /**
     * Sets mapped data attached to the item stack.
     *
     * <p>This will perform any and all checks that the given key
     * is compatible with the represented item, and that the value is within
     * the bounds of key.</p>
     *
     * @param mapped The mapped data attached to the item stack
     * @return The transaction result, if the keys and their respective values
     *     were added, rejected or replaced
     */
    ItemDataTransactionResult set(Map<K, V> mapped);

    /**
     * Sets mapped data attached to the item stack.
     *
     * <p>This will set all the mapped with their default value.</p>
     *
     * @param mapped The mapped data attached to the item stack
     * @return The transaction result, if the mapped were added rejected or replaced
     */
    ItemDataTransactionResult set(K... mapped);

    /**
     * Unsafely sets the key at the desired value.
     *
     * <p>This does NOT perform any checks on the item or whether
     * the value is within the standard bounds of key.</p>
     *
     * @param key The key to add
     * @param value The value of the key to add
     */
    void setUnsafe(K key, V value);

    /**
     * Sets the mapped data to attach to the item stack.
     *
     * <p>This does NOT perform any checks on the item or whether
     * the value is within the standard bounds of key.</p>
     *
     * @param mapped The mapped data attached to the item stack
     */
    void setUnsafe(Map<K, V> mapped);

    /**
     * Removes the desired key and it's value, if available.
     *
     * @param key The key to remove
     */
    void remove(K key);

}
