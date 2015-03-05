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
package org.spongepowered.api;

import org.spongepowered.api.item.ItemType;

import java.util.Map;
import java.util.Set;

/**
 * A GameDictionary is a store of {@link org.spongepowered.api.item.ItemTypes}.
 *
 * <p>Note that the GameDictionary's keys are different from Minecraft item
 * ids. Minecraft item IDs are namespaces, e.g. minecraft:carrot while
 * ItemDictionary keys are not, by design(e.g. carrot). This is mainly to keep
 * supporting the existing Forge 'ore dictionary'.</p>
 */
public interface GameDictionary {

    /**
     * Registers an ItemType in the dictionary with a String key.
     *
     * @param key The key of the item as a String
     * @param type The item type to register
     */
    void register(String key, ItemType type);

    /**
     * Retrieves the item types registered for the given key.
     *
     * @param key The key of the items as a String
     * @return The item types registered for the given key
     */
    Set<ItemType> get(String key);

    /**
     * Retrieves all items registered in this item dictionary, mapped by
     * their key.
     *
     * @return A map of all items registered
     */
    Map<String, Set<ItemType>> getAllItems();

}
