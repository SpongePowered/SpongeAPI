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
package org.spongepowered.api.item;

import java.util.Set;

import org.spongepowered.api.block.Block;
import org.spongepowered.api.enchant.Enchantment;

/**
 * A representation of a stack of items in the game can range from 1 -
 * min(maxStackSize(), 64), or -1 for infinite
 */
public interface Stack {

    /**
     * @return the type of material in the stack
     */
    public ItemType getType();

    /**
     * @return the maximum size of the stack, but as a value no larger than 64
     *         (or -1 for infinite)
     */
    public byte getMaxStackSize();

    /**
     * Gets the id of this item.
     *
     * Ex. Minecraft registers a golden carrot as "minecraft:golden_carrot"
     * 
     * @return The id
     */
    public ItemID getID();

    /**
     * @return the size of the stack as it exists in its inventory
     */
    public byte getStackSize();

    /**
     * @return the metadata for the item
     */
    public Set<ItemMetaData> getStackItemMeta();

    /**
     * Recommended that you check this before accessing the meta data
     * 
     * @return whether this item has metadata associated with it
     */
    public boolean hasItemMetaData();

    /**
     * Recommended that you check this before accessing the enchantments
     * 
     * @return whether this item has enchantments
     */
    public boolean hasEnchantments();

    /**
     * @return the set of all enchantments on this item, where Enchantment has a
     *         type and a level
     */
    public Set<Enchantment> getEnchantments();

    /**
     * For now there are only two types: durability and type_id, though this
     * system allows for extension in the future
     * 
     * @param idf
     *            the item data identifier
     * @return the piece of data corresponding to idf
     */
    public short getItemData(ItemDataIdentifier idf);

    /**
     * @param e
     *            an enchantment (type + level)
     * @return whether this enchantment was successfully added, ie, whether
     *         there were no conflicts
     */
    public boolean addEnchantment(Enchantment e);

    /**
     * Force an enchantment onto an item, even if it has an out of bounds level
     * or conflicts with another enchant
     * 
     * @param e
     *            and enchantment (type + level)
     * @return
     */
    public boolean forceEnchantment(Enchantment e);

    /**
     * create an exact copy of this stack MUST USE DEEP COPYING
     * 
     * @return an exact copy
     */
    public Stack duplicate();

    /**
     * An example of the block that would exist if this were used by the player
     * 
     * @return A block representing the Item, as though it had been placed
     */
    public Block asPlaced();

}
