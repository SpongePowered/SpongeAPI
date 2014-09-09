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

public interface Item {
    /**
     * Gets the damage value of this item.
     * 
     * @return The item damage value, 0 for undamaged items
     */
    int getDamage();
    
    /**
     * Gets the id of this item.
     *
     * Ex. Minecraft registers a golden carrot as "minecraft:golden_carrot"
     * @return The id
     */
    String getID();
    
    /**
     * Gets the lore (text under the item name) of the item
     * 
     * @return The item lore, if there is any. If not, it returns null.
     */
    String getLore();
    
    /**
     * Gets the display name of this item.
     * This can change if the item is named in an anvil or through plugins.
     * 
     * @return The name
     */
    String getName();
    
    /**
     * Checks if this item is enchanted
     * 
     * @returns true if the item is enchanted, false if not
     */
    boolean isEnchanted();
    
    /**
     * Sets the new damage value for this item
     * Setting it to 0 will completely reset damage and "repair" the item
     * 
     * @param damage New damage value
     */
    void setDamage(int damage);
    
    /**
     * Sets the new lore for this item
     * 
     * @param lore New item lore
     */
    void setLore(String lore);
    
    /**
     * Sets the new name for this item
     * 
     * @param name New item name
     */
    void setName(String name);
}
