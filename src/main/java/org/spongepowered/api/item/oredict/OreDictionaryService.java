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
package org.spongepowered.api.item.oredict;

import java.util.List;

import org.spongepowered.api.item.ItemType;

/**
 * Ore dictionary service, which can register and fetch contents from it.
 */
public interface OreDictionaryService {
    /**
     * Gets special {@link OreDictType}, which represents item type for
     * all items for given dictionary entry.
     * @param name Ore dictionary key
     * @return Ore dictionary
     */
    OreDictType getItemType(String key);
    
    /**
     * Registers new item for specified ore dictionary key.
     * @param item Item to register
     * @param key Key to use
     */
    void registerItem(ItemType item, String key);
    
    /**
     * Gets all items registered to specific key. Some of them may be items
     * from mods.
     * @param key Key to use
     * @return List of items
     */
    List<ItemType> getItems(String key);
}
