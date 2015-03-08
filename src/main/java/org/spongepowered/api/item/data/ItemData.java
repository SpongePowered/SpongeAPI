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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.meta.HideableInfoType;
import org.spongepowered.api.service.persistence.DataSerializable;
import org.spongepowered.api.text.message.Message;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ItemData extends DataSerializable {

    /**
     * Gets if this item is unbreakable.
     * 
     * @return If this item is unbreakable
     */
    boolean isUnbreakable();

    /**
     * Sets if this item is unbreakable.
     * 
     * @param unbreakable If this item is now unbreakable.
     */
    void setUnbreakable(boolean unbreakable);

    /**
     * Gets a set containing all of the {@link BlockType}s this item can
     * destroy. Returning Optional.absent() means that all blocks can be
     * destroyed.
     * 
     * @return A set of the BlockTypes this item can destroy
     */
    Optional<Collection<BlockType>> getDestroyables();

    /**
     * Gets the levels added to the base cost when modifying this item in an
     * anvil.
     * 
     * @return The levels added to the base cost when modifying this item in an
     *         anvil
     */
    int getRepairModifier();

    /**
     * Sets the levels added to the base cost when modifying this item in an
     * anvil.
     * 
     * @param modifier the new levels added to the base cost when modifying this
     *        item in an anvil
     */
    void setRepairModifier(int modifier);

    /**
     * Get the enchantments applied to this stack with their levels.
     *
     * @return Map of enchantments to current levels
     */
    Map<Enchantment, Integer> getEnchantments();

    /**
     * Test if this stack has enchantments.
     *
     * @return Whether this stack is enchanted
     */
    boolean isEnchanted();

    /**
     * Set an enchantment to the given level, adding it if necessary.
     *
     * @param enchant Enchantment to set the level of
     * @param level Level to set the enchantment at
     */
    void setEnchantment(Enchantment enchant, int level);

    /**
     * Remove an enchantment from this stack.
     *
     * @param enchant Enchantment to remove
     */
    void removeEnchantment(Enchantment enchant);

    /**
     * Get the level of an enchantment on this stack.
     *
     * @param enchant The enchantment to get the level of
     * @return The level of the enchantment, or -1 if the enchantment is not
     *         applied to this stack
     */
    int getEnchantment(Enchantment enchant);

    /**
     * Gets the name of this item.
     * 
     * @return The name of this item
     */
    Message getName();

    /**
     * Sets the name of this item.
     * 
     * @param name The new name of this item
     */
    void setName(Message name);

    /**
     * Gets the list of lore on this item.
     * 
     * @return The list of lore on this item
     */
    List<Message> getLore();

    /**
     * Adds lore to the end of this item's list.
     * 
     * @param lore The lore to add
     */
    void addLore(Message lore);

    /**
     * Adds lore at a certain line, moving others as needed.
     * 
     * @param line The line to insert at
     * @param lore The lore to insert
     */
    void insertLore(int line, Message lore);

    /**
     * Sets lore at a certain line, overwriting previous values.
     * 
     * @param line The line to edit
     * @param lore The lore to set it to
     */
    void setLore(int line, Message lore);

    /**
     * Gets if certain information is displayed to the client.
     * 
     * @param infoType The type of information
     * @return If the type is hidden
     */
    boolean isHidden(HideableInfoType infoType);

    /**
     * Sets if certain information is displayed to the client.
     * 
     * @param infoType The type of information
     * @param hidden If the type is now hidden
     */
    void setHidden(HideableInfoType infoType, boolean hidden);

}
