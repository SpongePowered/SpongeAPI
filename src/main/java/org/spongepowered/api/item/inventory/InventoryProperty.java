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
package org.spongepowered.api.item.inventory;


/**
 * Base interface for Inventory Properties
 */
public interface InventoryProperty<K, V> extends Comparable<InventoryProperty<K, V>> {
    
    /**
     * Operator used to indicate to a query what operation to use when comparing
     * this property with properties present on a child inventory
     */
    public static enum Operator {
        
        /**
         * Use the <code>.equals()</code> method 
         */
        EQUAL,
        
        /**
         * Use the <code>.equals()</code> method but match if the result is
         * false 
         */
        NOTEQUAL,
        
        /**
         * Use <code>.compareTo()</code> amd match if target is greater than
         * supplied operand
         */
        GREATER,
        
        /**
         * Use <code>.compareTo()</code> amd match if target is greater than
         * or equal to supplied operand
         */
        GEQUAL,
        
        /**
         * Use <code>.compareTo()</code> amd match if target is less than the
         * supplied operand
         */
        LESS,
        
        /**
         * Use <code>.compareTo()</code> amd match if target is less than or
         * equal to the supplied operand
         */
        LEQUAL
    }
    
    /**
     * Get the key for this property. Key is only used if an inventory can have
     * more than one property of a particular type. If the property has no
     * specific key, the property class name is returned.
     */
    K getKey();
    
    /**
     * Get the "value" of this property. "Value" may have different meanings
     * depending on the exact type of this property.
     */
    V getValue();
}
