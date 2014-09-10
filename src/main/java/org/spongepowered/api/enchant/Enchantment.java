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
package org.spongepowered.api.enchant;

/**
 * An interface to represent enchantments, wrapping both the type and level
 *
 */
public interface Enchantment {

    /**
     * @return the eType
     */
    public EnchantmentType getType();

    /**
     * @return the level
     */
    public int getLevel();

    /**
     * 
     * @param other
     *            another enchantment
     * @return whether this and the other enchantment conflict, ie: not both
     *         Sharpness and Smite
     */
    public abstract boolean conflictsWith(Enchantment other);

    /**
     * 
     * @param other
     *            another enchantment
     * @return this and the other enchantment combined, ie: Sharpness I +
     *         Sharpness I = Sharpness II
     */
    public abstract Enchantment combineWith(Enchantment other);
}
